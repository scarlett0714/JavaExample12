package tptty.example14;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class MyDialog extends JDialog {
	
	MyFrame parent = null;
	
	JTextField uID;
	JPasswordField uPasswd;
	JTextField uName;
	JTextField uPhone;
	JButton okBtn, cancelBtn;

	public MyDialog(MyFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		this.parent = parent;
		this.setSize(300,300);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		init();
		initListener();
		this.setVisible(true);

	}

	public void init() {
		this.setLayout(new GridLayout(5,2));
		//(5,2) 넣어주는 순서대로 2개씩 채워짐
		
		this.add(new JLabel("아이디"));
		uID = new JTextField(15);
		this.add(uID);
		
		this.add(new JLabel("비밀번호"));
		uPasswd = new JPasswordField(15);
		uPasswd.setEchoChar('*');
		this.add(uPasswd);
		
		this.add(new JLabel("이름"));
		uName = new JTextField(15);
		this.add(uName);
		
		this.add(new JLabel("전화번호"));
		uPhone = new JTextField(15);
		this.add(uPhone);
		
		okBtn = new JButton("입력");
		cancelBtn = new JButton("취소");
		this.add(okBtn);
		this.add(cancelBtn);
		
	}
	
	public void initListener() {
		okBtn.addActionListener(e->{
			String sID = uID.getText();
			if(sID.length()==0) {
				JOptionPane.showMessageDialog(null, "아이디는 필수입력 항목입니다.");
				uID.requestFocus(); //다시 아이디를 입력하라고 ID창에 focus를 줌
				return;
			}
			
			//아이디를 제대로 입력했다면, 정보를 담은 String배열 생성
			String[] data = {sID, new String(uPasswd.getPassword()), uName.getText(), uPhone.getText()};
			
			//부모의 tabel에 추가
			parent.model.addRow(data); //행으로 추가됨
			parent.dig = null;
			dispose();
		});
		
		cancelBtn.addActionListener(e->{
			parent.dig = null;
			dispose();
		});
		
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				parent.dig = null;
				dispose();
			}
			
		});
		
	}

}
