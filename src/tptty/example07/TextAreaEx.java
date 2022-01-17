package tptty.example07;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class TextAreaEx extends JFrame {

	// 텍스트필드에 문자열을 입력하고 Enter를 치면 텍스트영역에 문자열이 입력됨
	JTextField tf = new JTextField(20);
	JTextArea ta = new JTextArea(7, 20);

	TextAreaEx() {
		setTitle("텍스트영역 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(new JLabel("입력 후 <Enter> 키를 입력하세요"));
		c.add(tf);
		c.add(new JScrollPane(ta));

		tf.addActionListener(new ActionListener() { //텍스트필드에서 enter치면 이벤트 발생

			@Override
			public void actionPerformed(ActionEvent e) {
				JTextField t = (JTextField) e.getSource();
				ta.append(t.getText() + "\n"); //text를 추가시키고 다음 줄
				t.setText(""); //텍스트필드를 비움

			}

		});
		setSize(300, 300);
		setVisible(true);

	}

	public static void main(String[] args) {
		new TextAreaEx();

	}

}
