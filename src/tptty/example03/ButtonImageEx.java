package tptty.example03;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ButtonImageEx extends JFrame {

	ButtonImageEx(){
		setTitle("이미지 버튼 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		ImageIcon normalIcon = new ImageIcon("images/normalIcon.JPG"); //일반적인 상태
		ImageIcon rolloverIcon = new ImageIcon("images/rolloverIcon.JPG"); //마우스가 버튼 위로 올라갔을 떄
		ImageIcon pressedIcon = new ImageIcon("images/pressedIcon.JPG"); //마우스로 버튼이 눌렸을 때
		
		JButton btn = new JButton("call~~", normalIcon);
		btn.setPressedIcon(pressedIcon);
		btn.setRolloverIcon(rolloverIcon);
		
		c.add(btn);
		setSize(250, 150);
		setVisible(true);
		
		
	}
	public static void main(String[] args) {
		new ButtonImageEx();

	}

}
