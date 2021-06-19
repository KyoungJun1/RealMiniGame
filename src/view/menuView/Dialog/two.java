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

public class two {
	///다이어 생성//////////////
	JDialog p2_2 = new JDialog();
	/////////////////////////
	
	
	///// Border////////////////
	SoftBevelBorder b2 = new SoftBevelBorder(SoftBevelBorder.RAISED);
	SoftBevelBorder b1 = new SoftBevelBorder(SoftBevelBorder.LOWERED);
	//////////////////////
	
	//////////상점기능 ////////////////
	String GM = "16000";
	String CM;
	int count3_1 = 0;
	int count3_2 = 0;
	int count3_3 = 0;
	JButton btn3_1 = new JButton("크레이지 아케이드 ");
	JButton btn3_2 = new JButton("카트라이더 ");
	JButton btn3_3 = new JButton("리그 오브 레전드 ");
	JButton btn3_4 = new JButton("구매 ");
	JButton btn3_5 = new JButton("취소");
	JTextField text3_1 = new JTextField(GM);
	JTextField text3_2 = new JTextField(CM);
	JLabel label3_1 = new JLabel("GM");
	JLabel label3_2 = new JLabel("CM");
	JTable table3_1 = new JTable();

	/////////////////////////////////////
	
	
	public two() {

		
		p2_2.setSize(900, 400);
		p2_2.setUndecorated(true);
		p2_2.setLayout(null);
		p2_2.setLocationRelativeTo(null);
		p2_2.setVisible(true);
		JScrollPane scroll3_1 = new JScrollPane(table3_1);
		scroll3_1.setVerticalScrollBarPolicy(scroll3_1.VERTICAL_SCROLLBAR_ALWAYS);
		//// 버BORDER///////////////
		btn3_1.setBorder(b2);
		btn3_2.setBorder(b2);
		btn3_3.setBorder(b2);
		btn3_4.setBorder(b2);
		btn3_5.setBorder(b2);

		/// 기능 위치 설정////////
		btn3_1.setBounds(10, 10, 150, 80);
		btn3_2.setBounds(10, 100, 150, 80);
		btn3_3.setBounds(10, 190, 150, 80);
		btn3_4.setBounds(470, 315, 150, 80);
		btn3_5.setBounds(630, 315, 150, 80);
		label3_1.setBounds(10, 350, 70, 50);
		label3_2.setBounds(10, 300, 70, 50);
		text3_1.setBounds(50, 350, 120, 50);
		text3_2.setBounds(50, 300, 120, 50);
		scroll3_1.setBounds(180, 15, 600, 300);

		//// 버튼 설정 /////////
		btn3_5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				p2_2.dispose();
			}

		});

		btn3_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (count3_1 == 0) {
					btn3_1.setBorder(b1);
					btn3_2.setBorder(b2);
					btn3_3.setBorder(b2);
					count3_1 += 1;
				} else if (count3_1 == 1) {
					btn3_1.setBorder(b2);
					count3_1 -= 1;
				}
			}

		});
		btn3_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (count3_2 == 0) {
					btn3_1.setBorder(b2);
					btn3_2.setBorder(b1);
					btn3_3.setBorder(b2);
					count3_2 += 1;
				} else if (count3_2 == 1) {
					btn3_2.setBorder(b2);
					count3_2 -= 1;
				}
			}

		});

		btn3_3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (count3_3 == 0) {
					btn3_1.setBorder(b2);
					btn3_2.setBorder(b2);
					btn3_3.setBorder(b1);
					count3_3 += 1;
				} else if (count3_3 == 1) {
					btn3_3.setBorder(b2);
					count3_3 -= 1;
				}
			}

		});

		/// 기타 설정1//////////
		text3_1.setEnabled(false);
		text3_2.setEnabled(false);
		text3_1.setText(GM);
		text3_1.setText(CM);
		////////////////////

		//// 기능 삽입//////
		p2_2.add(btn3_1);
		p2_2.add(btn3_2);
		p2_2.add(btn3_3);
		p2_2.add(btn3_4);
		p2_2.add(btn3_5);
		p2_2.add(label3_1);
		p2_2.add(label3_2);
		p2_2.add(text3_1);
		p2_2.add(text3_2);
		p2_2.add(scroll3_1);
		//////////////

		
	}

}
