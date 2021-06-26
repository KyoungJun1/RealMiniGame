package Games.wordGame;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

public class WordMain {

	public static void main(String[] args) {
		new Main();

	}

}


class Main extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3938156274804786063L;

	Timer timer;
	int second, minute;
	String ddSecond, ddMinute;
	DecimalFormat dFormat = new DecimalFormat("00"); // timer 더블표시

	private JTextField input; // 입력받을 창
	String answer;

//	JPanel card1;
//	CardLayout card;

	int count = 0;

	public Main() {
		this.setTitle("CardGame");
		this.setUndecorated(true); // ***********************
		this.setSize(1280, 720);
		setResizable(false);
		this.setLocationRelativeTo(null);

		getContentPane().setLayout(null);

		// JPanel panel = new JPanel(null);

		// 제목
		Font font = new Font("나눔고딕", Font.BOLD, 60);
		JLabel titleLabel = new JLabel("단어 맞추기 게임");
		titleLabel.setFont(font);
		titleLabel.setBounds(290, 70, 500, 60);

		// 버튼(카드) 만들기 3*9//****************************
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(3, 9, 5, 5));
		buttonPanel.setBounds(150, 350, 700, 250);

		String cards[] = { "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R",
				"S", "T", "U", "V", "W", "X", "Y", "Z" };

		// String card_random[] = shuffle(cards);
		shuffle(cards);

		JButton btn[] = new JButton[cards.length + 1];
		Font btnFont = new Font("", Font.BOLD, 40);
		for (int i = 0; i < cards.length; i++) {
			btn[i] = new JButton(cards[i]);
			if (i % 2 == 0) {
				btn[i].setBackground(Color.gray);
				btn[i].setForeground(Color.WHITE);
			} else {
				btn[i].setBackground(Color.white);
				btn[i].setForeground(Color.gray);
			}
//			btn[i].setBackground(Color.gray);
//			btn[i].setForeground(Color.WHITE);
			btn[i].setFont(btnFont);
			;
			btn[i].setBorderPainted(false); // 테두리 없애기
			btn[i].addActionListener(new PadActionListener());
			buttonPanel.add(btn[i]);

		}
		btn[26] = new JButton("clear");
		btn[26].setBackground(Color.black);
		btn[26].setForeground(Color.WHITE);
		btn[26].setBorderPainted(false);
		btn[26].addActionListener(new PadActionListener());
		buttonPanel.add(btn[26]);

		// 제시어 //맞추면 변경되게 수정해야함!//**************************************************
		JPanel wordPanel = new JPanel();
		CardLayout card = new CardLayout();
//		card = new CardLayout();
		wordPanel.setLayout(card);
		wordPanel.setBounds(360, 150, 300, 60);

//		card1 = new JPanel();
		JPanel card1 = new JPanel();
		JPanel card2 = new JPanel();
		JPanel card3 = new JPanel();
		JPanel card4 = new JPanel();
		JPanel card5 = new JPanel();

		card1.setBackground(Color.lightGray);
		card2.setBackground(Color.lightGray);
		card3.setBackground(Color.lightGray);
		card4.setBackground(Color.lightGray);
		card5.setBackground(Color.lightGray);

		// String[] word = {"APPLE", "BANNA", "CAT", "DOG"};

		Font wordFont = new Font("", Font.BOLD, 40);
		JLabel wordLabel1 = new JLabel("APPLE");
		wordLabel1.setFont(wordFont);
		wordLabel1.setBounds(getBounds());
		card1.add(wordLabel1);

		JLabel wordLabel2 = new JLabel("BANNA");
		wordLabel2.setFont(wordFont);
		wordLabel2.setBounds(getBounds());
		card2.add(wordLabel2);

		JLabel wordLabel3 = new JLabel("CAT");
		wordLabel3.setFont(wordFont);
		wordLabel3.setBounds(getBounds());
		card3.add(wordLabel3);

		JLabel wordLabel4 = new JLabel("DOG");
		wordLabel4.setFont(wordFont);
		wordLabel4.setBounds(getBounds());
		card4.add(wordLabel4);

		JLabel wordLabelFin = new JLabel("ALL CLEAR");
		wordLabelFin.setFont(wordFont);
		wordLabelFin.setBounds(getBounds());
		card5.add(wordLabelFin);

		// 프레임(컨테이너) 패널 추가
		wordPanel.add(card1);
		wordPanel.add(card2);
		wordPanel.add(card3);
		wordPanel.add(card4);
		wordPanel.add(card5);


		input = new JTextField();
		input.setEditable(true);
		input.setBackground(Color.white);
		input.setHorizontalAlignment(JTextField.CENTER);
		input.setFont(wordFont);
		input.setForeground(Color.blue);
		input.setEnabled(false); // 타자로 입력불가
		input.setBounds(360, 250, 300, 60);

		// 카운트라벨/TIME 라벨
//		int count = 0;
		Font cntFont = new Font("", Font.BOLD, 30);
		JLabel cntLabel = new JLabel("COUNT: ");
		JLabel cnt = new JLabel("00");
		cntLabel.setFont(cntFont);
		cntLabel.setBounds(910, 180, 200, 50);
		cnt.setFont(cntFont);
		cnt.setBounds(1035, 180, 200, 50);

		// 타이머 : https://blog.naver.com/highkrs/220283709171
		// https://www.youtube.com/watch?v=zWw72j-EbqI
		JLabel tLabel = new JLabel("TIME: ");
		tLabel.setFont(cntFont);
		tLabel.setBounds(910, 230, 100, 50);
		JLabel timerLabel = new JLabel("03:00"); //////// 시간수정*************
		timerLabel.setFont(cntFont);
		timerLabel.setBounds(1000, 230, 200, 50);

		second = 00; //////// 시간수정*************
		minute = 03; //////// 시간수정*************

		timer = new Timer(1000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				second--;
				ddSecond = dFormat.format(second);
				ddMinute = dFormat.format(minute);

				timerLabel.setText(ddMinute + ":" + ddSecond);
				if (second == -1) {
					second = 59;
					minute--;
					ddSecond = dFormat.format(second);
					ddMinute = dFormat.format(minute);
					timerLabel.setText(ddMinute + ":" + ddSecond);
				}
				if (minute == 0 && second == 0) {
					timer.stop();
					// JOptionPane.showMessageDialog(null, "TIME OVER!");
					int ans1 = JOptionPane.showConfirmDialog(null, "TIME OVER!\n다시하시겠습니까?", "TIME OVER",
							JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

					if (ans1 == JOptionPane.YES_OPTION) {
						setVisible(false);
						new WordMain();
						return;
					} else if (ans1 == JOptionPane.NO_OPTION) { // *****************************출력할지 말지 확인 필요!
//						JOptionPane.showMessageDialog(null, "메인페이지로 돌아갑니다.");
//
//						setVisible(false);
//						new AppMenu();
//						return;
					}
				}

			}
		});
		timer.start();

//		TimerTask timerTask = new TimerTask() {
//
//			@Override
//			public void run() {
//				// TODO Auto-generated method stub
//				
//				JOptionPane.showMessageDialog(null,"TIME OVER!");
//			}
//			
//		};
//		timer.schedule(timerTask, 5000);

		// check Button
		JButton checkBtn = new JButton("check");
		Font checkFont = new Font("", Font.BOLD, 20);
		checkBtn.setBackground(Color.lightGray);
		checkBtn.setForeground(Color.WHITE);
		checkBtn.setFont(checkFont);
		checkBtn.setBorderPainted(false);
		checkBtn.setBounds(700, 250, 100, 60);
		checkBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// System.out.println(input.getText());

				if (input.getText().equals(wordLabel1.getText())) {
//					System.out.println("성공");
					card.next(card1.getParent());
					input.setText("");
					cnt.setText("10");

				}
				if (input.getText().equals(wordLabel2.getText())) {
//					System.out.println("성공");
					card.next(card1.getParent());
					input.setText("");
					cnt.setText("20");
				}
				if (input.getText().equals(wordLabel3.getText())) {
//					System.out.println("성공");
					card.next(card1.getParent());
					input.setText("");
					cnt.setText("30");
				}
				if (input.getText().equals(wordLabel4.getText())) {
//					System.out.println("성공");
					card.next(card1.getParent());
					input.setText("");
					cnt.setText("40");
//					JOptionPane.showMessageDialog(null, "ALL CLEAR!");
					timer.stop();
					int ans1 = JOptionPane.showConfirmDialog(null, "ALL CLEAR!\n다시하시겠습니까?", "ALL CLEAR",
							JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

					if (ans1 == JOptionPane.YES_OPTION) {
						setVisible(false);
						new WordMain();
						return;
					} else if (ans1 == JOptionPane.NO_OPTION) { // *****************************출력할지 말지 확인 필요!
//						JOptionPane.showMessageDialog(null, "메인페이지로 돌아갑니다.");
//
//						setVisible(false);
//						new AppMenu();
//						return;
					}
				}
			}
		});

//		System.out.println(wordLabel1.getText());

		// 일시 정지 버튼 & 종료 버튼 & 다시 시작 & 새게임 버튼!
		JButton newGameBtn = new JButton("New Game");
		newGameBtn.setBackground(Color.lightGray);
		newGameBtn.setForeground(Color.WHITE);
		newGameBtn.setFont(cntFont);
		newGameBtn.setBorderPainted(false);
		newGameBtn.setBounds(910, 360, 200, 50);
		newGameBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				timer.stop();
				setVisible(false);
				new WordMain();
				return;

			}
		});

		JButton stopBtn = new JButton("II");
		stopBtn.setBackground(Color.lightGray);
		stopBtn.setForeground(Color.WHITE);
		stopBtn.setFont(cntFont);
		stopBtn.setBorderPainted(false);
		stopBtn.setBounds(910, 420, 200, 50);
		stopBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				timer.stop();

			}
		});

		JButton restartBtn = new JButton("▶");
		restartBtn.setBackground(Color.lightGray);
		restartBtn.setForeground(Color.WHITE);
		restartBtn.setFont(cntFont);
		restartBtn.setBorderPainted(false);
		restartBtn.setBounds(910, 480, 200, 50);
		restartBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				timer.restart();
			}
		});

		JButton endBtn = new JButton("EXIT");
		endBtn.setBackground(Color.lightGray);
		endBtn.setForeground(Color.WHITE);
		endBtn.setFont(cntFont);
		endBtn.setBorderPainted(false);
		endBtn.setBounds(910, 540, 200, 50);
		endBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				timer.stop();
				JOptionPane.showMessageDialog(null, "게임을 종료합니다.");

				setVisible(false);
				// new Main();
				System.exit(0);
				return;
			}
		});

		this.add(titleLabel);
		this.add(checkBtn);
		this.add(wordPanel);
		this.add(input);
		this.add(buttonPanel);
		this.add(cntLabel);
		this.add(cnt);
		this.add(tLabel);
		this.add(timerLabel);
		this.add(newGameBtn);
		this.add(stopBtn);
		this.add(restartBtn);
		this.add(endBtn);

		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// suffle참고: https://korbillgates.tistory.com/116
	public String[] shuffle(String[] cards) {
		for (int k = 0; k < cards.length; k++) {
			int i = (int) (Math.random() * cards.length);
			int j = (int) (Math.random() * cards.length);

			String tmp = cards[i];
			cards[i] = cards[j];
			cards[j] = tmp;

		}
		return cards;
	}

	public class PadActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			String str = e.getActionCommand();
			if (str.equals("clear")) {
				input.setText("");
//			} else if (str.equals("A") || str.equals("B") || str.equals("C") || str.equals("D") || str.equals("E")
//					|| str.equals("F") || str.equals("G") || str.equals("H") || str.equals("I") || str.equals("J")
//					|| str.equals("K") || str.equals("L") || str.equals("M") || str.equals("N") || str.equals("O")
//					|| str.equals("P") || str.equals("Q") || str.equals("R") || str.equals("S") || str.equals("T")
//					|| str.equals("U") || str.equals("V") || str.equals("W") || str.equals("X") || str.equals("Y")
//					|| str.equals("Z")) {
//				input.setText(input.getText() + e.getActionCommand());
			} else {
				input.setText(input.getText() + e.getActionCommand());
//				String result = input.getText();
//				answer += result;

			}
//			System.out.println(input.getText());
		}
	}
}

