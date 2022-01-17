package tptty.example13;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class MyDialog extends JDialog {
	JTextField tf = new JTextField("greenjoa");
	JButton okButton = new JButton("OK");
	MyFrame parent;
	
	public MyDialog(MyFrame parent, String title, boolean modal) {
		super(parent, title, modal);
		this.parent = parent; //부모의 정보를 초기화시키기 위해, 그 정보를 저장해둠
		this.setSize(500, 500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		//EXIT_ON_CLOSE : CLOSE버튼을 누르면 프로그램이 종료됨
		//프레임은 놔두고 해당 dialog만 종료되기를 원함 : DISPOSE_ON_CLOSE (창을 종료o, 프로그램 종료x)
		init();
		this.setVisible(true);
	}

	public void init() {
		this.setLayout(new FlowLayout());
		this.add(tf);
		this.add(okButton);
		
//		okButton.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				
//				
//			}
//			
//		}); 를 람다식으로 표현하면?
		
		okButton.addActionListener(e->{
			
			//Modalless인 경우
			String str = getInput();
			if(str!=null) 
				parent.btn.setText(str); 
			parent.dig = null; //부모의 dig정보를 초기화
			//
			
			dispose(); //창을 종료
			
			//ModalDialog이므로 창을 종료하기 전까지 아래구문 실행x
		});
		
		//ok버튼을 누르지 않고 x를 눌러 창을 종료할 경우
		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				//textfield에 있던 값을 지우고
				tf.setText(""); 
				
				parent.dig = null; //부모의 dig정보를 초기화
				
				//창을 종료해라
				dispose();
			}
			
		});
	}
	
	String getInput() { //Dialog에 입력한 문자를 버튼의 캡션값으로 사용
		if(tf.getText().length()==0)
			return null;
		else
			return tf.getText();
	}

}
