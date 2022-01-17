package tptty.example10;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.*;
import javax.swing.event.*;
@SuppressWarnings("serial")
public class MyFrame extends JFrame {
	
	JSlider fontsize;
	JLabel label;
	
	public MyFrame() {
		this("202110547 황윤선");
	}
	
	public MyFrame(String title) {
		super(title);
		this.setSize(500,500);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		init();
		this.setVisible(true);
		
	}

	public void init() {
		label = new JLabel("greenjoa", SwingConstants.CENTER); //레이블의 글자 가운데 정렬
		this.add(label, BorderLayout.CENTER);
		
		fontsize = new JSlider(JSlider.HORIZONTAL, 1, 50, 10);
		fontsize.setToolTipText("폰트 크기를 설정합니다.");
		fontsize.setPaintLabels(true);
		fontsize.setPaintTicks(true);
		fontsize.setMajorTickSpacing(10); //큰 간격 설정
		fontsize.setMinorTickSpacing(2); //작은 간격 설정
		fontsize.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				Font font = new Font("굴림체", Font.BOLD, fontsize.getValue());
				label.setFont(font);
				
			}
			
		});
		
		this.add(fontsize, BorderLayout.NORTH);
		
		
	}

	public static void main(String[] args) {
		new MyFrame();
	}

}
