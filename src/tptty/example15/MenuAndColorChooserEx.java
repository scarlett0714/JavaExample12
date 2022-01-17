package tptty.example15;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

@SuppressWarnings("serial")
public class MenuAndColorChooserEx extends JFrame {
	Container contentPane;
	JLabel label = new JLabel("Hello");
	
	MenuAndColorChooserEx(){
		setTitle("JColorChooser 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Ravie", Font.ITALIC, 30));
		contentPane.add(label, BorderLayout.CENTER);
		createMenu();
		setSize(250,200);
		setVisible(true);
	}
	
	public void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenuItem colorMenuItem = new JMenuItem("Color");
		JMenu fileMenu = new JMenu("Text");
		colorMenuItem.addActionListener(new MenuActionListener());
		fileMenu.add(colorMenuItem);
		mb.add(fileMenu);
		this.setJMenuBar(mb);
	}
	
	class MenuActionListener implements ActionListener{
		JColorChooser chooser = new JColorChooser();

		@Override
		public void actionPerformed(ActionEvent e) {
			String cmd = e.getActionCommand();
			if(cmd.equals("Color")) {
				Color selectedColor = chooser.showDialog(null, "Color", Color.YELLOW);
				//창을 종료시켜야만 실행 (Modal)
				if(selectedColor != null) {
					label.setForeground(selectedColor);
				}
			}
			
		}
		
		
	}

	public static void main(String[] args) {
		new MenuAndColorChooserEx();
	}

}
