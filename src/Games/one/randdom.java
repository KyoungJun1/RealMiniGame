package Games.one;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

public class randdom {	
	game1UI gg = new game1UI();
	JDialog jd = new JDialog();
	String[] king;
	int i =0;
	public JDialog dia(String[] king1 ,int num) {
		jd.setSize(500, 500);
		jd.setUndecorated(true);
		jd.setLayout(null);
		jd.setLocationRelativeTo(null);
		
		String[] t = king1[num].split("#");

		JTextField la11 = new JTextField(t[0]);
		la11.setEnabled(false);
		JTextField jt11 = new JTextField();
		JButton btn11 = new JButton("나가기");
		JButton btn12 = new JButton("체크");
		la11.setBounds(10, 10, 300, 50);
		jt11.setBounds(40, 200, 150, 50);
		btn11.setBounds(70, 400, 80, 50);
		btn12.setBounds(170, 400, 80, 50);

		btn12.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String a = t[1];
				if (jt11.getText().equals(a)) {
					
					cf f = new cf();
					f.clear(a, num);
					if(num==0) {
						gg.setTf1("CLEAR");
					}else if(num==1){
						gg.setTf2("ClEAR");
					}else if(num==2){
						gg.setTf3("ClEAR");
					}else if(num==3){
						gg.setTf4("ClEAR");
					}else if(num==4){
						gg.setTf5("ClEAR");
					}
					
				} else {
					new cf();
					
				}

			}

		});

		btn11.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				jd.dispose();
			}

		});

		jd.add(la11);
		jd.add(jt11);
		jd.add(btn11);
		jd.add(btn12);
	

		return jd;
	}
	

}
