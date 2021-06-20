package view.lobbyView;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import view.mainView.Setting;

public class Lobby extends JFrame implements ActionListener{
	// -----------------기본 설정 --------------------
	private JPanel panel, inputChat;
	private JFrame frame;
	private JButton createGame, shop, myPage, relationship, gear, exit;
	private JTextField input;
	private JTextArea chat;
	private JTable roomList, userList, ranking;
	private JScrollPane roomScroll, chatScroll, userScroll, rankScroll;
	
	// -----------------이미지 설정 --------------------	
	private Image background = new ImageIcon(Main.class.getResource("../images/noBack.png")).getImage();
	private Image introBackground; //배경이미지
	private Graphics screenGraphic;
	
	private ImageIcon exitImg = new ImageIcon(Main.class.getResource("../images/false.png"));
	private ImageIcon exitBackImg = new ImageIcon(Main.class.getResource("../images/falseChanged.png"));
	private ImageIcon gearImg = new ImageIcon(Main.class.getResource("../images/gear.png"));
	private ImageIcon gearBackImg = new ImageIcon(Main.class.getResource("../images/gearChanged.png"));

	// -------------------------버튼, 아이콘등 이미지 ----------------------
	private ImageIcon createImg = new ImageIcon(Main.class.getResource("../images/createBtn.png"));
	private ImageIcon shopImg = new ImageIcon(Main.class.getResource("../images/shopImg.png"));
	private ImageIcon myPageImg = new ImageIcon(Main.class.getResource("../images/mypageImg.png"));
	private ImageIcon reImg = new ImageIcon(Main.class.getResource("../images/reImg.png"));
	
	
	//기본생성자 
	public Lobby() {
		LobbyMain();
	}
	
	//메인                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
	public void LobbyMain() {
//------------------배경이미지 삽입 메소드-------------------- 			
			panel = new JPanel() {
				public void paint(Graphics g) {
					//background = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
					//screenGraphic = background.getGraphics();
					//screenDraw(screenGraphic);
					g.drawImage(background, 0, 0, null);
					super.paintComponents(g);
				}
				public void screenDraw(Graphics g) {
					g.drawImage(introBackground, 0, 0, null);
					paintComponents(g);
					this.repaint();
				}
			};
			
//---------------메인 프레임 패널설정----------------------// 
			
			setUndecorated(true);
			setSize(1280,720);
			setResizable(false);
			setLocationRelativeTo(null);
			//임시로 노래 꺼둠 
			//Music music = new Music("bgm.mp3",true);
			//music.start();		
		
//--------------------버튼설정-------------------------//
			//게임생성버튼 
			createGame = new JButton(createImg);
			createGame.setLayout(null);
			createGame.setBounds(90, 50, 200, 100); 
			createGame.setBorderPainted(false);
			createGame.setContentAreaFilled(false);
			createGame.setFocusPainted(false);
			
			//상점버튼 
			shop = new JButton(shopImg);
			shop.setLayout(null);
			shop.setBounds(340, 50, 200, 100);  
			shop.setBorderPainted(false);
			shop.setContentAreaFilled(false);
			shop.setFocusPainted(false);
			
			//마이페이지버튼 
			myPage = new JButton(myPageImg);
			myPage.setLayout(null);
			myPage.setBounds(590, 50, 200, 100);
			myPage.setBorderPainted(false);
			myPage.setContentAreaFilled(false);
			myPage.setFocusPainted(false);
			
			//친구추가버튼 
			relationship = new JButton(reImg);
			relationship.setLayout(null);
			relationship.setBounds(840, 50, 200, 100); 
			relationship.setBorderPainted(false);
			relationship.setContentAreaFilled(false);
			relationship.setFocusPainted(false);
			
			
			
//-----------------설정, 취소(뒤로가기)버튼---------------
			
			//설정버튼 
			JButton gear = new JButton(gearImg);
			gear.setBounds(1150, 50, 40, 40);
			gear.setBorderPainted(false);
			gear.setContentAreaFilled(false);
			gear.setFocusPainted(false);
			
			//닫기버튼
			JButton exit = new JButton(exitImg);
			exit.setBounds(1200, 50, 40, 40);
			exit.setBorderPainted(false);
			exit.setContentAreaFilled(false);
			exit.setFocusPainted(false);
		
			
//--------------방 리스트----------------------
			
			roomList = new JTable();
			roomScroll = new JScrollPane(roomList);
			roomScroll.setLocation(50, 200);
			roomScroll.setSize(800,200);
			

//--------------채팅창-------------------//
			
			chat = new JTextArea(); 
			chat.setEditable(false);
			chat.setLayout(null);
			
			chatScroll = new JScrollPane(chat);
			chatScroll.setLocation(50,450);
			chatScroll.setSize(800,150);
			chatScroll.setLayout(null);
			
			input = new JTextField(30);
			input.addActionListener(this);
			input.setBounds(50, 590, 800, 50);
			input.setLayout(null);
			
//------------유저리스트, 랭킹리스트--------------
			
			userList = new JTable();
			userScroll = new JScrollPane(userList);
			userScroll.setLocation(950,200);
			userScroll.setSize(300,200);
			
			ranking = new JTable();
			rankScroll = new JScrollPane(ranking); 
			rankScroll.setLocation(950,450);
			rankScroll.setSize(300,200);
			
//--------------패널 붙이기 ---------------//
			
			panel.setLayout(null);
			panel.setVisible(true);
			
			panel.add(createGame);
			panel.add(shop);
			panel.add(myPage);
			panel.add(relationship);
			panel.add(roomScroll);
			panel.add(chatScroll);
			panel.add(userScroll);
			panel.add(rankScroll);
			panel.add(input);
			panel.add(exit);
			panel.add(gear);
			
			add(panel);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

			//엑스 버튼
			exit.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					//마우스포인터 올릴 시 -> falseChanged 이미지로 변경
					exit.setIcon(exitBackImg);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					exit.setIcon(exitImg);
				}

				@Override
				public void mousePressed(MouseEvent e) {
					System.exit(0);
				}
			});

			//설정(기어) 버튼
			gear.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					//마우스포인터 올릴 시 -> gearChanged 이미지로 변경
					gear.setIcon(gearBackImg);
				}

				@Override
				public void mouseExited(MouseEvent e) {
					gear.setIcon(gearImg);
				}

				@Override
				public void mousePressed(MouseEvent e) {
					new Setting();
				}
			});
		}
//--------------- 채팅입력 이벤트 -----------------------
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == input) {
				chat.append(input.getText() + "\n");
				input.selectAll();
			}
		}
			
		
}