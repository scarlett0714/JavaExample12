package tptty.example11;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
class MyDialog extends JDialog{
	JTextField tf = new JTextField(10);
	JButton okButton = new JButton("OK");

	public MyDialog(JFrame frame, String title) {
		super(frame, title);
		//디폴트 레이아웃 : BorderLayout
		setLayout(new FlowLayout());
		add(tf);
		add(okButton);
		setSize(200,100);
		
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false); //Test Dialog창 감추기
				
			}
			
		});
	}
	
}

@SuppressWarnings("serial")
public class DialogEx extends JFrame {
	MyDialog dialog = new MyDialog(this, "Test Dialog");
	
	public DialogEx() {
		super("DialogEx 예제 프레임");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JButton btn = new JButton("Show Dialog");
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
				//Test Dialog : 초기상태 false -> true
				
			}
			
		});
		getContentPane().add(btn);
		setSize(250,200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new DialogEx();

	}

}
