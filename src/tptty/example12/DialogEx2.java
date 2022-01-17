package tptty.example12;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
class MyModalDialog extends JDialog{
	JTextField tf = new JTextField(10);
	JButton okButton = new JButton("OK");

	public MyModalDialog(JFrame frame, String title) {
		super(frame, title, true); //Modal 여부에 대한 boolean값 추가
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
	
	String getInput() {
		if(tf.getText().length()==0)
			return null;
		else
			return tf.getText();
	}
	
}

@SuppressWarnings("serial")
public class DialogEx2 extends JFrame {
	MyModalDialog dialog = new MyModalDialog(this, "Test Dialog");
	
	public DialogEx2() {
		super("DialogEx2 예제 프레임");
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		JButton btn = new JButton("Show Modal Dialog");
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
				//ModalDialog이므로 위의 창이 종료되기 전까지 focus이동x
				//창이 종료되기 전까지 아래에 있는 구문들은 실행x
				String text = dialog.getInput();
				if(text==null)
					return;
				JButton btn = (JButton)e.getSource();
				btn.setText(text);
				
			}
			
		});
		getContentPane().add(btn);
		setSize(250,200);
		setVisible(true);
	}

	public static void main(String[] args) {
		new DialogEx2();
	}

}
