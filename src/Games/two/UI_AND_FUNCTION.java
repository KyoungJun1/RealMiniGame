package Games.two;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.SoftBevelBorder;

public class UI_AND_FUNCTION extends JFrame {

	// 프레임 선언
	JFrame frame;

	// Quest 소환
	Quest q = new Quest();
	String key[] = new String[2];

	// 게임 내부 텍스트 필드
	JTextField[] text = new JTextField[25];

	// 게임 꾸밈 설정
	SoftBevelBorder border = new SoftBevelBorder(SoftBevelBorder.RAISED);
	Font font = new Font("맑은 고딕", Font.BOLD, 40);
	Font font2 = new Font("Aharoni", Font.BOLD, 15);

	// 게임 내 버튼
	JButton button1[] = new JButton[6]; // 문제 설명
	JButton button2[] = new JButton[6]; // 문제 정답

	// 좌표 고정 시작
	int col = 77;

	// 문제확인 액션리스 반복변수
	int num = 0;
	Dialog dia;

	public UI_AND_FUNCTION() {

		JFrame_Start(); // 컨테이너 출

	}

	// 컨테이너
	private void JFrame_Start() {

		frame = new JFrame();

		frame.setSize(1280, 720);
		frame.setUndecorated(true);
		frame.setLocationRelativeTo(null);
		frame.add(JPanel_Main());
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel kk = new JLabel();

	}

	// 바탕 패널
	private JPanel JPanel_Main() {

		JPanel panel = new JPanel();

		panel.setSize(1280, 720);
		panel.setLayout(null);
		panel.add(JPanel_Game());

		// 이미지 삽입

		// 가로 세로 설명
		JLabel label1 = new JLabel("  가로문제<순서대로 1,2,3> ");
		JLabel label2 = new JLabel("  세로문제<순서대로 1,2,3> ");
		label1.setBackground(Color.black);
		label2.setBackground(Color.black);
		label1.setFont(font2);
		label2.setFont(font2);
		label1.setBorder(border);
		label2.setBorder(border);
		label1.setBounds(720, 10, 200, 60);
		label2.setBounds(720, 320, 200, 60);
		panel.add(label1);
		panel.add(label2);

		// 버튼 적용1
		for (int i = 0; i < button1.length; i++) {

			button1[i] = new JButton("문제 확인");
			button1[i].setBounds(740, col, 70, 70);
			if (i == 2)
				col += 75;
			col += 80;
			panel.add(button1[i]);

		}

		// 버튼 적용2
		col = 77;
		for (int i = 0; i < button1.length; i++) {

			button2[i] = new JButton("정답 확인");
			button2[i].setBounds(810, col, 70, 70);
			if (i == 2)
				col += 75;
			col += 80;
			panel.add(button2[i]);

		}

		// 버튼 적용
		button1[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dia = new Dialog(0);

			}

		});
		button1[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dia = new Dialog(1);

			}

		});
		button1[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dia = new Dialog(2);

			}

		});
		button1[3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dia = new Dialog(3);

			}

		});
		button1[4].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dia = new Dialog(4);

			}

		});
		button1[5].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dia = new Dialog(5);

			}

		});

		// 정답 확인 액션 설정
		button2[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				StringBuilder bd1 = new StringBuilder();
				key = q.getA();

				bd1.append(text[11].getText());
				bd1.append(text[12].getText());
				bd1.append(text[13].getText());
				bd1.append(text[14].getText());
				String a = bd1.toString();
				String b = key[1];

				if (a.equals(b)) {
					text[11].setEnabled(false);
					text[12].setEnabled(false);
					text[13].setEnabled(false);
					text[14].setEnabled(false);
					text[11].setBackground(Color.pink);
					text[12].setBackground(Color.pink);
					text[13].setBackground(Color.pink);
					text[14].setBackground(Color.pink);
				} else {
					text[11].setText("");
					text[12].setText("");
					text[13].setText("");
					text[14].setText("");
					text[11].setEnabled(true);
					text[12].setEnabled(true);
					text[13].setEnabled(true);
					text[14].setEnabled(true);

				}

			}

		});
		button2[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				StringBuilder bd1 = new StringBuilder();
				key = q.getB();

				bd1.append(text[15].getText());
				bd1.append(text[16].getText());
				String a = bd1.toString();
				String b = key[1];

				if (a.equals(b)) {
					text[15].setEnabled(false);
					text[16].setEnabled(false);
					text[15].setBackground(Color.pink);
					text[16].setBackground(Color.pink);
				} else {
					text[15].setText("");
					text[16].setText("");
					text[15].setEnabled(true);
					text[16].setEnabled(true);

				}

			}

		});
		button2[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				StringBuilder bd1 = new StringBuilder();
				key = q.getC();

				bd1.append(text[21].getText());
				bd1.append(text[22].getText());
				String a = bd1.toString();
				String b = key[1];

				if (a.equals(b)) {
					text[21].setEnabled(false);
					text[22].setEnabled(false);
					text[21].setBackground(Color.pink);
					text[22].setBackground(Color.pink);
				} else {
					text[21].setText("");
					text[22].setText("");
					text[21].setEnabled(true);
					text[22].setEnabled(true);

				}

			}

		});
		button2[3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				StringBuilder bd1 = new StringBuilder();
				key = q.getD();

				bd1.append(text[4].getText());
				bd1.append(text[9].getText());
				bd1.append(text[14].getText());
				String a = bd1.toString();
				String b = key[1];

				if (a.equals(b)) {
					text[4].setEnabled(false);
					text[9].setEnabled(false);
					text[14].setEnabled(false);
					text[4].setBackground(Color.pink);
					text[9].setBackground(Color.pink);
					text[14].setBackground(Color.pink);
				} else {
					text[4].setText("");
					text[9].setText("");
					text[14].setText("");
					text[4].setEnabled(true);
					text[9].setEnabled(true);
					text[14].setEnabled(true);

				}

			}

		});
		button2[4].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				StringBuilder bd1 = new StringBuilder();
				key = q.getE();

				bd1.append(text[11].getText());
				bd1.append(text[16].getText());
				bd1.append(text[21].getText());
				String a = bd1.toString();
				String b = key[1];

				if (a.equals(b)) {
					text[11].setEnabled(false);
					text[16].setEnabled(false);
					text[21].setEnabled(false);
					text[11].setBackground(Color.pink);
					text[16].setBackground(Color.pink);
					text[21].setBackground(Color.pink);
				} else {
					text[11].setText("");
					text[21].setText("");
					text[16].setText("");
					text[11].setEnabled(true);
					text[21].setEnabled(true);
					text[16].setEnabled(true);

				}

			}

		});
		button2[5].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				StringBuilder bd1 = new StringBuilder();
				key = q.getF();

				bd1.append(text[13].getText());
				bd1.append(text[18].getText());
				String a = bd1.toString();
				String b = key[1];

				if (a.equals(b)) {
					text[13].setEnabled(false);
					text[18].setEnabled(false);
					text[13].setBackground(Color.pink);
					text[18].setBackground(Color.pink);
				} else {
					text[13].setText("");
					text[18].setText("");
					text[13].setEnabled(true);
					text[118].setEnabled(true);

				}

			}

		});

		JButton bt1 = new JButton("해설");
		JButton bt2 = new JButton("나가기");
		bt1.setBounds(1050, 600, 100, 100);
		bt2.setBounds(1150, 600, 100, 100);
		bt1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				text[4].setText("임");
				text[4].setEnabled(false);
				text[9].setText("산");
				text[9].setEnabled(false);
				text[14].setText("부");
				text[14].setEnabled(false);
				text[11].setText("잉");
				text[11].setEnabled(false);
				text[12].setText("꼬");
				text[12].setEnabled(false);
				text[13].setText("부");
				text[13].setEnabled(false);
				text[15].setText("핑");
				text[15].setEnabled(false);
				text[16].setText("크");
				text[16].setEnabled(false);
				text[18].setText("금");
				text[18].setEnabled(false);
				text[21].setText("병");
				text[21].setEnabled(false);
				text[22].setText("세");
				text[22].setEnabled(false);
			}

		});
		bt2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}

		});
		panel.add(bt1);
		panel.add(bt2);

		panel.setVisible(true);

		return panel;
	}

	// 문제 화면
	private JPanel JPanel_Game() {

		JPanel panel_Game = new JPanel();

		GridLayout grid = new GridLayout(5, 5);
		panel_Game.setLayout(grid);
		panel_Game.setBorder(border);
		panel_Game.setBounds(10, 10, 700, 700);

		for (int i = 0; i < text.length; i++) {
			text[i] = new JTextField(SwingConstants.CENTER);
			text[i].setSize(100, 100);
			text[i].setBorder(border);
			text[i].setFont(font);
			text[i].setBackground(Color.CYAN);
			panel_Game.add(text[i]);
		}

		// 1열 제거
		for (int i = 0; i < 4; i++) {
			text[i].setEnabled(false);
			text[i].setBackground(Color.LIGHT_GRAY);
		}

		// 2열 제거
		for (int i = 5; i < 9; i++) {
			text[i].setEnabled(false);
			text[i].setBackground(Color.LIGHT_GRAY);
		}

		// 3열 제거

		text[10].setEnabled(false);
		text[10].setBackground(Color.LIGHT_GRAY);

		// 4열 제거
		for (int i = 17; i < 20; i++) {
			text[i].setEnabled(false);
			text[i].setBackground(Color.LIGHT_GRAY);
			i++;
		}

		// 5열 제거
		text[20].setEnabled(false);
		text[20].setBackground(Color.LIGHT_GRAY);
		for (int i = 23; i < 25; i++) {
			text[i].setEnabled(false);
			text[i].setBackground(Color.LIGHT_GRAY);
		}

		panel_Game.setVisible(true);

		return panel_Game;

	}

	public void setButton2(JButton[] button2) {
		this.button2 = button2;
	}

}
