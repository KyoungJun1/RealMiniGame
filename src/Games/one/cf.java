package Games.one;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;

public class cf {

	JDialog jd2 = new JDialog();
	JDialog jd3 = new JDialog();
	String pass ;
	public JDialog clear(String a, int num) {

		jd2.setSize(200, 200);
		// jd2.setUndecorated(true);
		jd2.setLayout(null);
		jd2.setLocationRelativeTo(null);
		JButton btn12 = new JButton("정답입니다!!!");
		btn12.setBounds(20, 20, 150, 60);
		btn12.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				 pass = a;

				
				jd2.dispose();
			}

		});

		jd2.add(btn12);
		jd2.setVisible(true);
		return jd2;

	}

	public JDialog flase() {
		jd3.setSize(200, 200);
		// jd3.setUndecorated(true);
		jd3.setLayout(null);
		jd3.setLocationRelativeTo(null);
		JButton btn12 = new JButton("틀렷습니다!!!");
		btn12.setBounds(20, 20, 150, 60);
		btn12.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jd3.dispose();
			}

		});

		jd3.add(btn12);
		jd3.setVisible(true);
		return jd3;

	}

	public String getPass() {
		return pass;
	}
	
}
