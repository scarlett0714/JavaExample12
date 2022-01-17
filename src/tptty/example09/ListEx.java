package tptty.example09;

import java.awt.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class ListEx extends JFrame {
	String[] fruits = { "apple", "banana", "kiwi", "mango", "pear", "peach", "berry", "strawberry", "blackberry" };
	ImageIcon[] images = { new ImageIcon("images/icon1.PNG"), 
			new ImageIcon("images/icon2.PNG"),
			new ImageIcon("images/icon3.PNG"), 
			new ImageIcon("images/icon4.PNG") };
	
	ListEx(){
		setTitle("리스트 만들기 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JList strList = new JList(fruits);
		c.add(strList);
		
		JList imageList = new JList();
		imageList.setListData(images);
		c.add(imageList);
		
		JList scrollList = new JList(fruits);
		c.add(new JScrollPane(scrollList));
		
		setSize(300,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ListEx();
	}

}
