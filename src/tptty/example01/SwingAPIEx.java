package tptty.example01;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class SwingAPIEx extends JFrame {
	Container contentPane;
	JLabel la;
	JButton b1, b2, b3, b4;

	SwingAPIEx() {
		setTitle("Swing 공통 매소드 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout()); // 레이아웃 : FlowLayout으로 변경

		b1 = new JButton("위치와 크기 정보");
		b1.addActionListener(new MyButtonListener()); // 이벤트 처리
		contentPane.add(b1); // 버튼을 화면에 추가

		b2 = new JButton("모양 정보");
		b2.setOpaque(true); // 불투명성 : 투명->불투명 : 글자색 변경 가능
		b2.setForeground(Color.MAGENTA); // 글자색
		b2.setBackground(Color.YELLOW); // 배경색
		b2.setFont(new Font("고딕체", Font.ITALIC, 20)); // 글자모양 (글자, 폰트, 글자크기)
		b2.addActionListener(new MyButtonListener());
		contentPane.add(b2);

		b3 = new JButton("작동하지 않는 버튼");
		b3.setEnabled(false); // 컴포넌트 활성(true)/비활성(false)
		b3.addActionListener(new MyButtonListener());
		contentPane.add(b3);

		b4 = new JButton("숨기기/보이기");
		b4.addActionListener(new MyButtonListener());
		contentPane.add(b4);

		setSize(250, 200);
		setVisible(true);

	}

	class MyButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			Object source = e.getSource();
			if (source == b1) { // b1의 이벤트 처리
				System.out.println("버튼의 위치와 크기");
				// System.out.println : 화면이 아니라 콘솔창에 출력
				System.out.println("위치 = (" + b1.getX() + "," + b1.getY() + ")");
				System.out.println("크기 = (" + b1.getWidth() + "x" + b1.getHeight() + ")");

				JPanel c = (JPanel) b2.getParent(); // b2의 부모인 Container를 받아서 JPanel로 변경
				System.out.println("컨텐트팬의 위치와 크기");
				System.out.println("위치 = (" + c.getX() + "," + c.getY() + ")");
				System.out.println("크기 = (" + c.getWidth() + "x" + c.getHeight() + ")");

			} else if (source == b2) { // b1의 이벤트 처리
				System.out.println("폰트 = " + b2.getFont());
				System.out.println("배경색 = " + b2.getBackground());
				System.out.println("글자색 = " + b2.getForeground());
			} else { // b4의 이벤트 처리
				// b3인 경우는 비활성화 버튼이기 때문에 이벤트 처리x
				if (b1.isVisible()) { // b1이 화면에 보여지는 상황
					b1.setVisible(false); // 화면에서 감추기
					b2.setVisible(false);
					b3.setVisible(false);
				} else {
					b1.setVisible(true);
					b2.setVisible(true);
					b3.setVisible(true);
				}
			}
		}

	}

	public static void main(String[] args) {
		new SwingAPIEx();

	}
}
