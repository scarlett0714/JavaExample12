package tptty.example04;

import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class RadioButtonEx extends JFrame {

	Container contentPane;
	RadioButtonEx() {
		setTitle("라디오버튼 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		ImageIcon cherryIcon = new ImageIcon("images/cherryIcon.JPG");
		ImageIcon selectedCherryIcon = new ImageIcon("images/selectedCherryIcon.JPG");
		
		ButtonGroup g = new ButtonGroup();
		JRadioButton apple = new JRadioButton("사과");
		JRadioButton pear = new JRadioButton("배", true);
		JRadioButton cherry = new JRadioButton("체리", cherryIcon);
		cherry.setBorderPainted(true); //선택되었을 때 테두리가 그려짐
		cherry.setSelectedIcon(selectedCherryIcon); //체리가 선택되었을 때 이미지
		
		//그룹에 추가
		g.add(apple);
		g.add(pear);
		g.add(cherry);
		
		contentPane.add(apple);
		contentPane.add(pear);
		contentPane.add(cherry);
		
		setSize(250,150);
		setVisible(true);
		
		
	}
	public static void main(String[] args) {
		new RadioButtonEx();

	}

}
