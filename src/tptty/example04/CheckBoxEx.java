package tptty.example04;

import java.awt.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class CheckBoxEx extends JFrame {

	Container contentPane;
	CheckBoxEx() {
		setTitle("체크박스 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		ImageIcon cherryIcon = new ImageIcon("images/cherryIcon.JPG");
		ImageIcon selectedCherryIcon = new ImageIcon("images/selectedCherryIcon.JPG");
		
		JCheckBox apple = new JCheckBox("사과");
		JCheckBox pear = new JCheckBox("배", true); //배 CheckBox는 이미 선택된 상태로 생성
		JCheckBox cherry = new JCheckBox("체리", cherryIcon);
		cherry.setBorderPainted(true); //선택되었을 때 테두리가 그려짐
		cherry.setSelectedIcon(selectedCherryIcon); //체리가 선택되었을 때 이미지
		
		contentPane.add(apple);
		contentPane.add(pear);
		contentPane.add(cherry);
		
		setSize(250,150);
		setVisible(true);
		
		
	}
	public static void main(String[] args) {
		new CheckBoxEx();

	}

}
