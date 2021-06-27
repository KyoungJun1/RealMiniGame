package Games.two;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.SoftBevelBorder;

public class Dialog extends JFrame {

	SoftBevelBorder border = new SoftBevelBorder(SoftBevelBorder.RAISED);
	Font font = new Font("맑은 고딕", Font.BOLD, 30);
	Font font2 = new Font("Aharoni", Font.BOLD, 15);

	Quest q = new Quest();

	public Dialog(int num) {

		Dialog_Start(num);

	}

	private JDialog Dialog_Start(int num) {

		JDialog log = new JDialog();
		log.setSize(700, 300);
		log.setLocationRelativeTo(null);
		log.setUndecorated(true);
		log.setVisible(true);

		String[] key = new String[2];
		if (num == 0) {
			key = q.getA();
		} else if (num == 1) {
			key = q.getB();
		} else if (num == 2) {
			key = q.getC();
		} else if (num == 3) {
			key = q.getD();
		} else if (num == 4) {
			key = q.getE();
		} else
			key = q.getF();

		JButton button1 = new JButton(key[0]);
		button1.setBackground(Color.LIGHT_GRAY);
		button1.setFont(font);

		button1.setBounds(250, 400, 100, 60);
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				log.dispose();
			}

		});
		log.add(button1);

		return log;
	}

}
