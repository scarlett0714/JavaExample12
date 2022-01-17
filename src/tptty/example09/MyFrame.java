package tptty.example09;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

@SuppressWarnings("serial")
public class MyFrame extends JFrame implements ActionListener, ListSelectionListener {
	// ListSelectionListener : List이벤트

	JTextField text1;
	JList<String> list;
	DefaultListModel<String> listmodel; // 동적할당가능

	JComboBox<String> combo;
	DefaultComboBoxModel<String> cbmodel;

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
		this.setLayout(new FlowLayout());
		text1 = new JTextField(15);
		text1.setFont(new Font("굴림체", Font.BOLD, 20));
		text1.addActionListener(this);
		this.add(text1);

		listmodel = new DefaultListModel<>(); // DefaultListModel생성
		list = new JList<>(listmodel); // 바로 위에서 생성한 listmodel로 list생성
		list.addListSelectionListener(this);
		this.add(new JScrollPane(list)); // 아직 데이터가 없는 상태

		cbmodel = new DefaultComboBoxModel<>();
		combo = new JComboBox<>(cbmodel);
		combo.addActionListener(this);
		this.add(combo);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == text1) {
			listmodel.addElement(text1.getText());
			cbmodel.addElement(text1.getText());
		} else if (e.getSource() == combo) {
			JOptionPane.showMessageDialog(this, combo.getSelectedItem());
			//<- list.getSelectedValue()
		}

	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// list에서 선택한 항목을 메세지로 띄우기
		if (!e.getValueIsAdjusting()) // 현재 선택이 진행되고 있는 중인가 vs 완료되었는가
			// 현재 진행중인 이벤트(선택)이 완료되었다면(마우스를 계속 클릭하고 있는 동안에는 실행x),
			JOptionPane.showMessageDialog(this, list.getSelectedValue());

	}

	public static void main(String[] args) {
		new MyFrame();
	}

}
