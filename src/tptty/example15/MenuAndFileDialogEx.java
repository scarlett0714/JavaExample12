package tptty.example15;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.filechooser.*;

@SuppressWarnings("serial")
public class MenuAndFileDialogEx extends JFrame {
	Container contentPane;
	JLabel imageLabel = new JLabel();
	
	MenuAndFileDialogEx() {
		setTitle("Menu와 JFileChooser 활용 예제");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = getContentPane();
		contentPane.add(imageLabel);
		createMenu();
		setSize(250,200);
		setVisible(true);
	}

	public void createMenu() {
		JMenuBar mb = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem openItem = new JMenuItem("Open");
		openItem.addActionListener(new OpenActionListener());
		fileMenu.add(openItem);
		mb.add(fileMenu);
		this.setJMenuBar(mb);
	}
	
	class OpenActionListener implements ActionListener{
		JFileChooser chooser;
		OpenActionListener(){
			chooser = new JFileChooser();
		}
		
		@Override
		public void actionPerformed(ActionEvent e) {
			FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
			chooser.setFileFilter(filter);
			
			//jpg, gif만 뜨는 다이얼로그
			int ret = chooser.showOpenDialog(null);
			if(ret!=JFileChooser.APPROVE_OPTION) { //파일을 정상적으로 선택하지 않은 경우
				JOptionPane.showMessageDialog(null, "파일을 선택하지 않았습니다.", "경고", JOptionPane.WARNING_MESSAGE);
				return;
			}
			//파일을 정상적으로 선택한 경우
			String filePath = chooser.getSelectedFile().getPath(); //파일경로
			imageLabel.setIcon(new ImageIcon(filePath)); //파일경로가지고 이미지아이콘생성
			pack(); //이미지사이즈만큼 프레임 사이즈 조절
			
		}
		
	}

	public static void main(String[] args) {
		new MenuAndFileDialogEx();

	}

}
