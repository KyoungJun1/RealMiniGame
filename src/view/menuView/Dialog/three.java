package view.menuView.Dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;

public class three {

	//// 다이어로그 생성////////////
	JDialog p2_3 = new JDialog();
	/////////////////////////

	///// Border////////////////
	SoftBevelBorder b2 = new SoftBevelBorder(SoftBevelBorder.RAISED);
	SoftBevelBorder b1 = new SoftBevelBorder(SoftBevelBorder.LOWERED);
	//////////////////////

	////// MyPage+기////////////////////
	JLabel label4_1 = new JLabel("ID");
	JLabel label4_2 = new JLabel("닉네임 ");
	JLabel label4_3 = new JLabel("GM");
	JLabel label4_4 = new JLabel("CM");
	JTextField text4_1 = new JTextField();
	JTextField text4_2 = new JTextField();
	JTextField text4_3 = new JTextField();
	JTextField text4_4 = new JTextField();
	JButton btn4_1 = new JButton("가방");
	JButton btn4_2 = new JButton("정보수정");
	JButton btn4_3 = new JButton("나가기");
	JTable table4_1 = new JTable();
	///////////////////////////////////

	public three() {

		p2_3.setSize(400, 600);
		p2_3.setLayout(null);
		p2_3.setUndecorated(true);
		p2_3.setLocationRelativeTo(null);
		p2_3.setVisible(true);

		// 기타 설정////////////
		text4_1.setEnabled(false);
		text4_2.setEnabled(false);
		text4_3.setEnabled(false);
		text4_4.setEnabled(false);

		// 버튼설정 기능///////////
		btn4_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				p2_3.dispose();
			}

		});

		// 랭킹시스템/////////////
		JScrollPane scroll4_1 = new JScrollPane(table4_1);
		scroll4_1.setVerticalScrollBarPolicy(scroll4_1.VERTICAL_SCROLLBAR_ALWAYS);

		////// 기능위치설정////////////
		label4_1.setBounds(170, 20, 60, 50);
		label4_2.setBounds(170, 100, 60, 50);
		label4_3.setBounds(170, 180, 60, 50);
		label4_4.setBounds(170, 260, 60, 50);
		text4_1.setBounds(220, 20, 150, 50);
		text4_2.setBounds(220, 100, 150, 50);
		text4_3.setBounds(220, 180, 150, 50);
		text4_4.setBounds(220, 260, 150, 50);
		btn4_1.setBounds(220, 410, 150, 50);
		btn4_2.setBounds(220, 470, 150, 50);
		btn4_3.setBounds(220, 530, 150, 50);
		scroll4_1.setBounds(15, 410, 150, 170);

		///////////////////

		//// 기능 삽입//////
		p2_3.add(btn4_1);
		p2_3.add(btn4_2);
		p2_3.add(btn4_3);
		p2_3.add(text4_1);
		p2_3.add(text4_2);
		p2_3.add(text4_3);
		p2_3.add(text4_4);
		p2_3.add(label4_1);
		p2_3.add(label4_2);
		p2_3.add(label4_3);
		p2_3.add(label4_4);
		p2_3.add(scroll4_1);
		//////////////////

	}

}
