package view.menuView.Dialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class four {
	// 다이어로그 생성////////////////////
	JDialog p2_4 = new JDialog();
	///////////////////////////

	///// 친추창///////////////////////////
	JButton btn5_1 = new JButton("확인");
	JButton btn5_2 = new JButton("나가기");
	JLabel label5_1 = new JLabel("ID");
	JLabel label5_2 = new JLabel("친구 아이디를 입력하세요");
	JTextField text5_1 = new JTextField();
	/////////////////////////////

	public four() {

		p2_4.setSize(400, 250);
		p2_4.setLocationRelativeTo(null);
		p2_4.setUndecorated(true);
		p2_4.setLayout(null);
		p2_4.setVisible(true);

		// 버튼이벤트설정////////
		btn5_2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				p2_4.dispose();
			}

		});

		//// 기능배치설정//////
		btn5_2.setBounds(250, 200, 60, 50);
		btn5_1.setBounds(320, 200, 60, 50);
		label5_1.setBounds(50, 90, 50, 50);
		text5_1.setBounds(80, 90, 200, 50);

		///// 기능삽입///////
		p2_4.add(btn5_1);
		p2_4.add(btn5_2);
		p2_4.add(label5_1);
		p2_4.add(label5_2);
		p2_4.add(text5_1);
		///////////////////

	}
}
