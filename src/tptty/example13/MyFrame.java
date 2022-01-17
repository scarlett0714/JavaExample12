package tptty.example13;

import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class MyFrame extends JFrame {
	JButton btn;
	MyDialog dig = null;

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
		btn = new JButton("Show dialog");
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				//일반적으로 Modal : 지역변수, Modalless : 지역변수가 아닌 멤버로 지정

				if (dig == null) { //버튼을 누를 때마다 창이 생성되지 않고, 창이 이미 존재한다면 focus만 이동하기를 원함
					dig = new MyDialog(MyFrame.this, "MyDialog", false);
				} else
					dig.requestFocus(); //포커스 옮기기
				//오류발생 : 창을 닫고 다시 버튼을 누르면 창이 생성되지 않음
				//오류원인 : 창은 닫혔지만 이미 dig에는 객체가 생성되어 저장되어있기 때문
				//해결방법 : 창을 닫으면 dig의 정보를 다시 null로 초기화해주는 과정이 필요
				
				
				
//				MyDialog dig = new MyDialog(MyFrame.this, "MyDialog", true);				
				//boolean값이 true : ModalDialog / false : ModallessDialog
				
//				String str = dig.getInput();
//				
//				if(str==null) //textfield가 비어있다면
//					return; //그냥 끝
//				btn.setText(str);
				
				//만약 ModallessDialog인 경우라면, ok버튼을 누르지 않아도 textfield디폴트값인 greenjoa로 버튼의 캡션값이 변경되어있음
				//why? Dialog를 만들고 Modal이라면 창을 닫을 때까지 다음 실행문으로 넘어가지 않지만, Modalless라면 바로 다음 실행문으로 넘어감
				//String str = dig.getInput(); -> btn.setText(str);이 실행되는 것
			}

		});
		this.add(btn);

	}

}
