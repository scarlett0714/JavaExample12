package tptty.example08;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class MyFrame extends JFrame implements ActionListener {
	JTextField text1;
	JTextField text2;
	JPasswordField text3; //비밀번호 입력하면 내가 입력한 문자가 아니라 다른 문자로 변환되어 뜸
	JTextArea text4;

	public MyFrame() {
		this("202110547 황윤선");
	}

	public MyFrame(String title) {
		super(title);
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
		this.setVisible(true);
	}

	public void init() {
		this.setLayout(new FlowLayout());
		text1 = new JTextField(15);
		text1.setFont(new Font("굴림체", Font.BOLD, 20));
		text1.addActionListener(this);

		text2 = new JTextField(15);
		text2.addActionListener(this);

		text3 = new JPasswordField(15);
		text3.setEchoChar('*'); //입력한 문자대신 *로 표시됨(문자열x)
		text3.addActionListener(this); //JTextField계열
		
		text4 = new JTextArea(20,30);
		
		this.add(text1);
		this.add(text2);
		this.add(text3);
		this.add(new JScrollPane(text4)); //스크롤추가

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == text1 || e.getSource() == text2) {
			// 두 텍스트값 swap
			String str1 = text1.getText();
			Font f1 = text1.getFont();
			String str2 = text2.getText();
			Font f2 = text2.getFont();
			text1.setText(str2);
			text1.setFont(f2);
			text2.setText(str1);
			text2.setFont(f1);
			if(text1.isFocusOwner()) { //현재 포커스를 가지고 있는 text? (포커스=커서)
				text2.requestFocus(); //text2에 포커스를 줌
			} else { //text2가 포커스를 가지고 있으면?
				text1.requestFocus(); //text1에 포커스를 줌
			}
			
			text4.append(str1+"\n");
		}else if(e.getSource()==text3) {
			String str3 = new String(text3.getPassword()); //getText()가 아니라 getPassword()로 가져옴
			if(str3.equals("greenjoa")) { //입력한 패스워드와 값 비교
				JOptionPane.showMessageDialog(this, "일치합니다."); //메세지창
			}else {
				JOptionPane.showMessageDialog(this, "일치하지 않습니다.");
			}
		}

	}

}
