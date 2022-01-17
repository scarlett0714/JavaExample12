package tptty.example09;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class ComboActionEx extends JFrame {

	String[] fruits = { "apple", "banana", "mango" };
	ImageIcon[] images = { new ImageIcon("images/apple.png"), 
			new ImageIcon("images/banana.png"),
			new ImageIcon("images/mango.png") };
	
	JLabel imgLabel = new JLabel(images[0]);
	
	
	ComboActionEx(){
		setTitle("콤보박스 활용 예제");
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JComboBox combo = new JComboBox(fruits);
		c.add(combo);
		c.add(imgLabel);
		
		combo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox cb = (JComboBox)e.getSource();
				int index = cb.getSelectedIndex();
				imgLabel.setIcon(images[index]);
				
			}
		});
		setSize(300,250);
		setVisible(true);
	}
	public static void main(String[] args) {
		new ComboActionEx();
	}
}
