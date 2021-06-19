package ProjectTeam.menubar;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

import ProjectTeam.menubar.Dialog.five;
import ProjectTeam.menubar.Dialog.four;
import ProjectTeam.menubar.Dialog.one;
import ProjectTeam.menubar.Dialog.three;
import ProjectTeam.menubar.Dialog.two;

public class UI extends JFrame {
	
	MusicStart ms = new MusicStart();
	//
	////버튼 사진////////////////////////////////////
	private ImageIcon btImage1 = new ImageIcon(Main.class.getResource("../image/a.png"));
	private ImageIcon btImage2 = new ImageIcon(Main.class.getResource("../image/b.png"));
	private ImageIcon btImage3 = new ImageIcon(Main.class.getResource("../image/c.png"));
	private ImageIcon btImage4 = new ImageIcon(Main.class.getResource("../image/d.png"));
	private ImageIcon btImage5 = new ImageIcon(Main.class.getResource("../image/f.png"));
	private ImageIcon btImage6 = new ImageIcon(Main.class.getResource("../image/r.png"));
	private ImageIcon btImage7 = new ImageIcon(Main.class.getResource("../image/w.png"));
	private ImageIcon btImage8 = new ImageIcon(Main.class.getResource("../image/t.png"));
	private ImageIcon btImage9 = new ImageIcon(Main.class.getResource("../image/q.png"));
	private ImageIcon btImage10 = new ImageIcon(Main.class.getResource("../image/e.png"));
	
	
	
	///// ++메인_페이지 기능++//////
	JButton btn1_1 = new JButton(btImage1);
	JButton btn1_2 = new JButton(btImage2);
	JButton btn1_3 = new JButton(btImage3);
	JButton btn1_4 = new JButton(btImage4);
	JButton btn1_5 = new JButton(btImage5);
	//////////////////////////// 1

	// ------------------------임시컨테이너 ---------------------------------------//

	public UI() { // 임시_메인_페이지

		JFrame f = new JFrame();
		f.setSize(1280, 720);
		f.setUndecorated(true);
		f.setResizable(false);
		f.setLayout(null);
		f.setLocationRelativeTo(null);

		// 버튼위치설정//
		btn1_1.setBounds(50, 50, 100, 100);
		btn1_2.setBounds(150, 50, 100, 100);
		btn1_3.setBounds(250, 50, 100, 100);
		btn1_4.setBounds(350, 50, 100, 100);
		btn1_5.setBounds(450, 50, 100, 100);
		///////////////////////////////

		/// 버튼 이벤트 ///
	
		btn1_1.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btn1_1.setIcon(btImage6);
				ms.b();

			}

			@Override
			public void mouseExited(MouseEvent e) {
				btn1_1.setIcon(btImage1);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				new one();
				ms.run();
			}
			
		});
		
		btn1_2.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btn1_2.setIcon(btImage7);
				ms.b();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btn1_2.setIcon(btImage2);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				new two();
				ms.run();
			}
			
		});
		btn1_3.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btn1_3.setIcon(btImage8);
				ms.b();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btn1_3.setIcon(btImage3);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				new three();
				ms.run();
			}
			
		});

		btn1_4.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				btn1_4.setIcon(btImage9);
				ms.b();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btn1_4.setIcon(btImage4);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				new four();
				ms.run();
			}
			
		});

		

		btn1_5.addMouseListener(new MouseAdapter() {
	
			@Override
			public void mouseEntered(MouseEvent e) {
				btn1_5.setIcon(btImage10);
				ms.b();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				btn1_5.setIcon(btImage5);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				new five();
				ms.run();
			}
			
		});
		////////////////////////////////////////////////////

		// 버튼 삽입//
		f.add(btn1_1);
		f.add(btn1_2);
		f.add(btn1_3);
		f.add(btn1_4);
		f.add(btn1_5);
		///////////

		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
	
	

}
