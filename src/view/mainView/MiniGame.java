package view.mainView;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class MiniGame extends JFrame {
	//배경 이미지
	private Image background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
	
	//아이콘 이미지
	private ImageIcon exitImage = new ImageIcon(Main.class.getResource("../images/false.png"));
	private ImageIcon exitEnteredImage = new ImageIcon(Main.class.getResource("../images/falseChanged.png"));
	
	private ImageIcon settingImage = new ImageIcon(Main.class.getResource("../images/gear.png"));
	private ImageIcon settingEnteredImage = new ImageIcon(Main.class.getResource("../images/gearChanged.png"));
	
	private ImageIcon loginImage = new ImageIcon(Main.class.getResource("../images/login.png"));
	private ImageIcon startImage = new ImageIcon(Main.class.getResource("../images/loginChanged.jpg"));
	
	private ImageIcon joinImage = new ImageIcon(Main.class.getResource("../images/join.png"));
	private ImageIcon joinEnteredImage = new ImageIcon(Main.class.getResource("../images/joinChanged.png"));
	
	private ImageIcon forgotImage = new ImageIcon(Main.class.getResource("../images/search.png"));
	private ImageIcon forgotEnteredImage = new ImageIcon(Main.class.getResource("../images/searchChanged.png"));
	
	
	public MiniGame() {
		//메인화면
		JPanel panelMain = new JPanel() {
			//배경화면 설정
			public void paint(Graphics g) {
				g.drawImage(background, 0, 0, null);
				super.paintComponents(g);
			}
		};
		panelMain.setBounds(0, 0, 1280, 720);
		panelMain.setLayout(null);

		//설정버튼
		JButton setting = new JButton(settingImage);
		setting.setBounds(1150, 30, 40, 40);
		setting.setBorderPainted(false);
		setting.setContentAreaFilled(false);
		setting.setFocusPainted(false);

		//닫기버튼
		JButton exit = new JButton(exitImage);
		exit.setBounds(1210, 30, 40, 40);
		exit.setBorderPainted(false);
		exit.setContentAreaFilled(false);
		exit.setFocusPainted(false);

		//아이디 입력 텍스트필드
		JTextField txtId = new JTextField();
		txtId.setBounds(430, 280, 400, 60);
		txtId.setFont(new Font("SansSerif", Font.PLAIN, 25));
		txtId.setText("아이디");
		txtId.setForeground(Color.GRAY);
		
		//아이디 placeholder
		txtId.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtId.getText().isEmpty()) {
					txtId.setText("아이디");
					txtId.setForeground(Color.GRAY);
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if (txtId.getText().equals("아이디")) {
					txtId.setForeground(Color.BLACK);
					txtId.setText("");
				}
			}
		});
		
		//비밀번호 입력 텍스트필드
		JPasswordField txtPw = new JPasswordField();
		txtPw.setBounds(430, 350, 400, 60);
		txtPw.setFont(new Font("SansSerif", Font.PLAIN, 25));
		txtPw.setEchoChar((char) 0);
		txtPw.setText("비밀번호");
		txtPw.setForeground(Color.GRAY);
		
		char charPw = txtPw.getEchoChar();

		//비밀번호 placeholder
		txtPw.addFocusListener(new FocusListener() {
			@Override
			public void focusLost(FocusEvent e) {
				if (txtPw.getText().isEmpty()) {
					txtPw.setText("비밀번호");
					txtPw.setEchoChar(charPw);
					txtPw.setForeground(Color.GRAY);
				}
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				if(txtPw.getText().equals("비밀번호")) {
					txtPw.setText("");
					txtPw.setEchoChar('*');
					txtPw.setForeground(Color.BLACK);
				}
			}
		});

		//로그인 버튼
		JButton login = new JButton(loginImage);
		login.setBounds(540, 460, 180, 70);
		login.setBorderPainted(false);
		login.setContentAreaFilled(false);
		login.setFocusPainted(false);

		//회원가입 버튼
		JButton join = new JButton(joinImage);
		join.setBounds(430, 600, 150, 50);
		join.setBorderPainted(false);
		join.setContentAreaFilled(false);
		join.setFocusPainted(false);

		//아이디비밀번호찾기 버튼
		JButton forgot = new JButton(forgotImage);
		forgot.setBounds(680, 600, 150, 50);
		forgot.setBorderPainted(false);
		forgot.setContentAreaFilled(false);
		forgot.setFocusPainted(false);

		//패널에 컴포넌트 붙여넣기
		panelMain.add(setting);
		panelMain.add(exit);
		panelMain.add(txtId);
		panelMain.add(txtPw);
		panelMain.add(login);
		panelMain.add(join);
		panelMain.add(forgot);

		//이벤트 추가
		//엑스 버튼
		exit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				//마우스포인터 올릴 시 -> falseChanged 이미지로 변경
				exit.setIcon(exitEnteredImage);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exit.setIcon(exitImage);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				System.exit(0);
			}
		});

		//설정(기어) 버튼
		setting.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				//마우스포인터 올릴 시 -> gearChanged 이미지로 변경
				setting.setIcon(settingEnteredImage);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				setting.setIcon(settingImage);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				new Setting();
			}
		});
		
		//로그인 버튼
		login.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				//마우스포인터 올릴 시 -> gearChanged 이미지로 변경
				login.setIcon(startImage);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				login.setIcon(loginImage);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				//로그인 정보 검증,
				//로그인 성공 후 페이지로 전환
			}
		});
		
		//회원가입 버튼
		join.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				join.setIcon(joinEnteredImage);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				join.setIcon(joinImage);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				new Join();
			}
		});
		
		//아이디비번찾기 버튼
		forgot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				forgot.setIcon(forgotEnteredImage);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				forgot.setIcon(forgotImage);
			}

			@Override
			public void mousePressed(MouseEvent e) {
				new Forgot();
			}
		});
		
		
		add(panelMain);
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		setLocationRelativeTo(null); //화면 가운데 뜨게
		setResizable(false); //창 크기 고정
		setUndecorated(true); //타이틀바 제거
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Background Music
		Music introBgm = new Music("bgm.mp3", true);
		introBgm.start();
	}

}
