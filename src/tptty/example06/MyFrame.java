package tptty.example06;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class MyFrame extends JFrame implements ItemListener {
	String[] data = { "사과", "포도", "배" };
	JCheckBox[] check = new JCheckBox[3];
	JLabel[] label = new JLabel[3];
	JPanel north = new JPanel(); // 사과, 포도, 배 -> north
	JPanel center = new JPanel(); // label -> center

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
		for (int i = 0; i < data.length; i++) {
			check[i] = new JCheckBox(data[i]);
			check[i].setBorderPainted(true);
			check[i].addItemListener(this);
			north.add(check[i]); // 만들고 나서 패널에 추가

			//label을 화면에 미리 붙여놓고 보였다 안보였다 (화면에 계속 남아있는 상태)
			//체크박스를 선택/해제해도 화면에 보여지는 순서가 사과 포도 배 순서유지
			label[i] = new JLabel(data[i]);
//			label[i].setVisible(false);
//			center.add(label[i]);
			//체크박스가 선택됨에 따라 화면에 나타났다 지워졌다 -> itemStateChanged
			//체크박스를 선택/해제시에 화면에 보여지는 순서가 달라짐
		}
		this.getContentPane().add(north, BorderLayout.NORTH); // 컨테이너에 패널 추가
		this.add(center, BorderLayout.CENTER); // 컨테이너 가져오기 -> this

	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		int i = -1;
		if (e.getSource() == check[0]) {
			i = 0;
		} else if (e.getSource() == check[1]) {
			i = 1;
		} else if (e.getSource() == check[2]) {
			i = 2;
		}

		if (i >= 0) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
//				label[i].setVisible(true);
				center.add(label[i]);

			} else {
//				label[i].setVisible(false);
				center.remove(label[i]);
			}
			center.revalidate(); 
			//미리 컨테이너에 add시키고 보였다 안보였다 할 경우엔 필요x
			//but 경우에 따라 이벤트로 동적으로 add, remove된 경우엔 필요 : 레이아웃이 변경되었음을 알려줌
			center.repaint(); //화면에 변경된 것을 수정해서 보여줌
		}

	}
}
