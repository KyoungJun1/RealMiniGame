
package Games.one;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;

public class game1UI extends JFrame {

	int[] arr;
	String king[];
	int ii=0;
	SoftBevelBorder b1 = new SoftBevelBorder(SoftBevelBorder.LOWERED);
	SoftBevelBorder b2 = new SoftBevelBorder(SoftBevelBorder.RAISED);

	JFrame jf = new JFrame();
	JPanel jp = new JPanel();
	JPanel jp2 = new JPanel();

	JTextField tf1 = new JTextField();
	JTextField tf2 = new JTextField();
	JTextField tf3 = new JTextField();
	JTextField tf4 = new JTextField();
	JTextField tf5 = new JTextField();

	public game1UI() {

		arr = new int[5];
		for (int i = 0; i < 5; i++) {
			arr[i] = (int) (Math.random() * 10 + 1);
			for (int j = 0; j < i; j++) {
				if (arr[i] == arr[j]) {
					i--;
				}
			}
		}
		king = matter();
		System.out.println(arr[3]);
		setframe();

	}

	public void setframe() {

		jf.setSize(1280, 720);
		jf.setUndecorated(true);
		jf.setLocationRelativeTo(null);
		jf.setLayout(null);
		jf.add(setpanel());
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	public JPanel setpanel() {
		
		jp.setSize(1280, 720);
		jp.setLayout(null);

		// 패널안 패널 설정//
		jp2.setLayout(null);

		{
			jp2.setBounds(50, 50, 650, 400);
			jp2.setVisible(true);
			jp2.setBorder(b2);
			JButton btn1 = new JButton("확인");
			JButton btn2 = new JButton("확인");
			JButton btn3 = new JButton("확인");
			JButton btn4 = new JButton("확인");
			JButton btn5 = new JButton("확인");

			JLabel la1 = new JLabel("1");
			JLabel la2 = new JLabel("2");
			JLabel la3 = new JLabel("3");
			JLabel la4 = new JLabel("4");
			JLabel la5 = new JLabel("5");

			tf1.setEnabled(false);
			tf2.setEnabled(false);
			tf3.setEnabled(false);
			tf4.setEnabled(false);
			tf5.setEnabled(false);

			btn1.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					randdom rd = new randdom();
					rd.dia(king, 0).setVisible(true);
					
			
					
				}

			});
			btn2.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					new randdom().dia(king, 1).setVisible(true);

				}

			});
			btn3.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					new randdom().dia(king, 2).setVisible(true);

				}

			});
			btn4.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					new randdom().dia(king, 3).setVisible(true);

				}

			});
			btn5.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					new randdom().dia(king, 4).setVisible(true);

				
				}

			});
			

			la1.setBounds(30, 30, 60, 40);
			tf1.setBounds(100, 30, 150, 40);
			btn1.setBounds(270, 30, 60, 40);

			la2.setBounds(30, 80, 60, 40);
			tf2.setBounds(100, 80, 150, 40);
			btn2.setBounds(270, 80, 60, 40);

			la3.setBounds(30, 130, 60, 40);
			tf3.setBounds(100, 130, 150, 40);
			btn3.setBounds(270, 130, 60, 40);

			la4.setBounds(30, 180, 60, 40);
			tf4.setBounds(100, 180, 150, 40);
			btn4.setBounds(270, 180, 60, 40);

			la5.setBounds(30, 230, 60, 40);
			tf5.setBounds(100, 230, 150, 40);
			btn5.setBounds(270, 230, 60, 40);

			jp2.add(btn1);
			jp2.add(btn2);
			jp2.add(btn3);
			jp2.add(btn4);
			jp2.add(btn5);

			jp2.add(la1);
			jp2.add(la2);
			jp2.add(la3);
			jp2.add(la4);
			jp2.add(la5);

			jp2.add(tf1);
			jp2.add(tf2);
			jp2.add(tf3);
			jp2.add(tf4);
			jp2.add(tf5);
			jp2.setVisible(true);
		}
		jp.add(jp2);
		jp2.setVisible(true);
		jp.setVisible(true);

		return jp;
	}

	
	

	public String[] matter() {
		
		String str1 = "우리집 강아지 이름은?#쭈니"; 
		String str2	=  "내 나이는?#27";
		String str3 =  "내가사는역은?#아차산역"; 
		String str4 = "쭈니의 종은?#말티즈";
		String str5 = "나의 주거래은행은?#국민은행";
		String str6 = "내핸드폰기종은?#갤럭시노트10";
		String str7 = "사과의색깔은?#빨간색";
		String str8 = "바나나의색깔은?#노란색";
		String str9 = "학원끝나는날은?#1115";
		String str10 = "수박바는 몇가지맛?#2가지";
		
		String[] key = new String[5];
		for(int i=0; i < arr.length; i++) {
			switch(arr[i]) {
			case 1 : key[i] = str1; break;
			case 2 : key[i] = str2; break;
			case 3 : key[i] = str3; break;
			case 4 : key[i] = str4; break;
			case 5 : key[i] = str5; break;
			case 6 : key[i] = str6; break;
			case 7 : key[i] = str7; break;
			case 8 : key[i] = str8; break;
			case 9 : key[i] = str9; break;
			case 10 : key[i] = str10; break;
			
			}
		}
		
		
		
		return key;
		
		

		
	}

	public void setTf1(String a) {
		tf1.setText(a);
	}

	public void setTf2(String a) {
		tf2.setText(a);
		}

	public void setTf3(String a) {
		tf3.setText(a);
	}

	public void setTf4(String a) {
		tf4.setText(a);
	}

	public void setTf5(String a) {
		tf5.setText(a);
	}

}