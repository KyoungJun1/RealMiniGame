package view.menuView.Dialog;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;

public class one extends JFrame {

	/// 다이로그 생성//////////////////
	JDialog p2_1 = new JDialog();
	///////////////////////////////

	///// Border////////////////
	SoftBevelBorder b2 = new SoftBevelBorder(SoftBevelBorder.RAISED);
	SoftBevelBorder b1 = new SoftBevelBorder(SoftBevelBorder.LOWERED);
	////////////////////////////

	///// ++방생성_페이지 기능++/////
	int count1 = 0; // 난이도 버튼 윤곽을 위한정수
	int count2 = 0; // 난이도 버튼 윤곽을 위한정수
	int count3 = 0; // 난이도 버튼 윤곽을 위한정수
	JButton btn2_1 = new JButton("생성");
	JButton btn2_2 = new JButton("취소");
	JButton btn2_3 = new JButton("상");
	JButton btn2_4 = new JButton("중");
	JButton btn2_5 = new JButton("하");
	JLabel label2_1 = new JLabel("방 제목");
	JLabel label2_2 = new JLabel("패스워드");
	JLabel label2_3 = new JLabel("게임 모드");
	JLabel label2_4 = new JLabel("게임 난이도");
	JTextField text2_1 = new JTextField();
	JPasswordField text2_2 = new JPasswordField();
	// (임시 콤보박스 리스트)//
	String str[] = { "크레이지 아케이드", " 카트라이더 ", "리그오브레전드" };
	JComboBox<String> box2_1 = new JComboBox(str);
	/////////////////////////////////
	
	//배경설정////////////////////////
	///private Image screenImage;
	///private Graphics screenGraphic;
	///private Image onebackground = new ImageIcon(Main.class.getResource("../images/image001.tif")).getImage();
	//static final int WE1 = 600;
	//static final int HE1 = 400;
	

	// -----------------------------------------------------------------------//

	public one() { // 방생성 팝

		p2_1.setUndecorated(true);
		p2_1.setSize(600, 400);
		p2_1.setLayout(null);
		p2_1.setLocationRelativeTo(null);
		p2_1.setVisible(true);

		///////// 배경 설정//////////

		////// 버튼BORDER ///////////
		btn2_3.setBorder(b2);
		btn2_4.setBorder(b2);
		btn2_5.setBorder(b2);
		//////////////////////

		// 기능위치설정//////////
		btn2_1.setBounds(450, 300, 100, 70);
		btn2_2.setBounds(350, 300, 100, 70);
		btn2_3.setBounds(100, 160, 80, 70);
		btn2_4.setBounds(180, 160, 80, 70);
		btn2_5.setBounds(260, 160, 80, 70);
		label2_1.setBounds(10, 10, 100, 50);
		label2_2.setBounds(10, 60, 100, 50);
		label2_3.setBounds(10, 110, 100, 50);
		label2_4.setBounds(10, 160, 100, 50);
		text2_1.setBounds(110, 10, 200, 50);
		text2_2.setBounds(110, 60, 200, 50);
		box2_1.setBounds(110, 110, 200, 50);
		/////////////////////

		//// 기능 이벤트 설정////
		btn2_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				p2_1.dispose();
			}

		});

		btn2_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (count1 == 0) {
					btn2_3.setBorder(b1);
					btn2_4.setBorder(b2);
					btn2_5.setBorder(b2);
					count1 += 1;
				} else if (count1 == 1) {
					btn2_3.setBorder(b2);
					count1 -= 1;
				}
			}

		});
		btn2_4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (count2 == 0) {
					btn2_3.setBorder(b2);
					btn2_4.setBorder(b1);
					btn2_5.setBorder(b2);
					count2 += 1;
				} else if (count2 == 1) {
					btn2_4.setBorder(b2);
					count2 -= 1;
				}
			}

		});
		btn2_5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (count3 == 0) {
					btn2_3.setBorder(b2);
					btn2_4.setBorder(b2);
					btn2_5.setBorder(b1);
					count3 += 1;
				} else if (count3 == 1) {
					btn2_5.setBorder(b2);
					count3 -= 1;
				}
			}

		});

		// 기능 삽입///////////
		p2_1.add(btn2_1);
		p2_1.add(btn2_2);
		p2_1.add(btn2_3);
		p2_1.add(btn2_4);
		p2_1.add(btn2_5);
		p2_1.add(label2_1);
		p2_1.add(label2_2);
		p2_1.add(label2_3);
		p2_1.add(label2_4);
		p2_1.add(text2_1);
		p2_1.add(text2_2);
		p2_1.add(box2_1);
		///////////////////

		
	}
	
	//public void paint(Graphics g) {//그리는 함수
		//g.drawImage(onebackground, 0, 0, null);
	//}

}
