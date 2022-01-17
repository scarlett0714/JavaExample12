package tptty.example14;

import java.awt.BorderLayout;

import javax.swing.*;
import javax.swing.table.*;

public class MyFrame extends JFrame {
	JPanel panel1 = new JPanel();
	JButton btn1 = new JButton("정보입력");
	
	String[] colum = {"아이디", "비밀번호", "이름", "전화번호"};
	DefaultTableModel model;
	JTable table;
	
	MyDialog dig = null; //Modalless로 운영
	
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
		panel1.add(btn1);
		this.add(panel1, BorderLayout.NORTH);
		
		//모델생성
		model = new DefaultTableModel(colum, 0); //(컬럼, row개수)
		//위의 모델로 테이블 생성
		table = new JTable(model);
		this.add(new JScrollPane(table), BorderLayout.CENTER); //중앙에 table배치
		//table은 JScrollPane으로 감싸서 만들기 : 스크롤
		
		
		initListener();
		
	}

	public void initListener() {
		btn1.addActionListener(e->{
			if(dig==null) {
				dig = new MyDialog(MyFrame.this, "정보입력", false);
			} else {
				dig.requestFocus();
			}
		});
		
	}
}
