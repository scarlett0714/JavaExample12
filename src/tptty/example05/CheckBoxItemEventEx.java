package tptty.example05;

import java.awt.*;

import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class CheckBoxItemEventEx extends JFrame {
	Container contentPane;
	JCheckBox[] fruits = new JCheckBox[3]; //빈 방 3개
	String[] names = {"사과", "베", "체리"};
	JLabel sumLabel;
	int sum =0;
	
	CheckBoxItemEventEx(){
		setTitle("체크박스와 ItemEvent 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.setLayout(new FlowLayout());
		
		contentPane.add(new JLabel("사과 100원, 배 500원, 체리 20000원")); //익명객체로 JLabel생성
		for(int i=0;i<fruits.length;i++) { //체크박스 생성
			fruits[i] = new JCheckBox(names[i]);
			fruits[i].setBorderPainted(true); //체크박스 선택시 나타나는 테두리 설정
			contentPane.add(fruits[i]);
			fruits[i].addItemListener(new MyItemListener()); //이벤트 처리
		}
		sumLabel = new JLabel("현재 0원입니다.");
		contentPane.add(sumLabel);
		setSize(250,200);
		setVisible(true);
		
	}
	class MyItemListener implements ItemListener{
		public void itemStateChanged(ItemEvent e) {
			int selected =1;
			if(e.getStateChange()==ItemEvent.SELECTED) //체크박스가 선택
				selected = 1;
			else //체크박스 선택해제
				selected =-1;
			
			if(e.getItem()==fruits[0]) //사과인 경우
				sum = sum + selected*100;
			else if(e.getItem()==fruits[1]) //배인 경우
				sum = sum + selected*500;
			else //체리인 경우
				sum = sum + selected*20000;
			
			sumLabel.setText("현재 "+sum+"원 입니다.");
		}
	}
	
	public static void main(String[] args) {
		new CheckBoxItemEventEx();

	}

}
