package tptty.example09;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class SliderEx extends JFrame {

	Container contentPane;
	SliderEx(){
		setTitle("슬라이더 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		JSlider slider = new JSlider(JSlider.HORIZONTAL,0,200,100);
		//(수평방향, 최솟값, 최댓값, 초기값)
		
		//화면에 보여주고 싶으면 true
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setPaintTrack(true);
		
		//간격정보
		slider.setMajorTickSpacing(50); //Label 간격 50
		slider.setMinorTickSpacing(10); //눈금 간격 10
		
		contentPane.add(slider);
		setSize(300,100);
		setVisible(true);
	}
	public static void main(String[] args) {
		new SliderEx();

	}

}
