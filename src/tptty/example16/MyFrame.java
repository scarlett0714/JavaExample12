package tptty.example16;

import java.awt.Color;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.plaf.basic.BasicMenuBarUI;

@SuppressWarnings("serial")
public class MyFrame extends JFrame {
	
	JLabel label = new JLabel(); 
	
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
		label.setOpaque(true); //색상을 바꾸기 위해 불투명으로 지정
		this.add(label); //화면에 가득 차게 배치
		initMenu();
		
	}

	public void initMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu menu = new JMenu("그리기");
		JMenuItem item1 = new JMenuItem("색상");
		JMenuItem item2 = new JMenuItem("그림불러오기");
		menu.add(item1);
		menu.add(item2);
		mb.add(menu);
		this.setJMenuBar(mb);
		
		item1.addActionListener(e->{
			Color color = JColorChooser.showDialog(this, "Color", Color.GREEN);
			if(color!=null)
				label.setBackground(color);
		});
		item2.addActionListener(e->{
			JFileChooser dig = new JFileChooser();
			FileNameExtensionFilter filter = new FileNameExtensionFilter("jpg Images", "jpg", "jpeg");
			dig.setFileFilter(filter);
			filter = new FileNameExtensionFilter("gif Images", "gif");
			dig.setFileFilter(filter);
			int result = dig.showOpenDialog(this); 
			if(result == JFileChooser.APPROVE_OPTION) { 
				String path = dig.getSelectedFile().getAbsolutePath(); //파일의 절대경로 가져오기
				label.setIcon(new ImageIcon(path));
				pack();
			}
		});
		
	}

}
