package view.lobbyView;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Lobby extends JFrame implements ActionListener{
	// -----------------기본 설정 --------------------
	private JPanel panel, inputChat;
	private JFrame frame;
	private JButton createGame, shop, myPage, relationship;
	private JTextField input;
	private JTextArea chat;
	private JTable roomList, userList, ranking;
	private JScrollPane roomScroll, chatScroll, userScroll, rankScroll;
	
	// -----------------이미지 설정 --------------------	
	private Image background = new ImageIcon(Main.class.getResource("../images/mainBackground.jpg")).getImage();
	private Image introBackground; //배경이미지
	private Graphics screenGraphic;
	
	private JLabel falseBar = new JLabel(new ImageIcon(Main.class.getResource("../images/false.png")));
	private JLabel gearBar = new JLabel(new ImageIcon(Main.class.getResource("../images/gear.png")));

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
			
			//frame = new JFrame();
			
//---------------메인 프레임 패널설정----------------------// 
			
			setUndecorated(true);
			setSize(1280,720);
			setResizable(false);
			setLocationRelativeTo(null);
			
			//Music caMusic = new Music("bgm.mp3",true);
			//caMusic.start();		
		
//--------------------버튼설정-------------------------//
			//게임생성버튼 
			createGame = new JButton(createImg);
			createGame.setLayout(null);
			createGame.setBounds(90, 50, 200, 100); //생성버튼
			createGame.setBorderPainted(false);
			createGame.setContentAreaFilled(false);
			createGame.setFocusPainted(false);
			
			//상점버튼 
			shop = new JButton(shopImg);
			shop.setLayout(null);
			shop.setBounds(340, 50, 200, 100); //상점버튼 
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
			
			falseBar.setBounds(50, 1100, 50, 50);
			gearBar.setBounds(50, 1150, 50, 50);
		
			
//--------------방 리스트----------------------
			// JTable roomList, userList, ranking;
			roomList = new JTable();
			roomScroll = new JScrollPane(roomList);
			//roomList.setBounds(50, 50, 900, 200); // 방 리스트
			roomScroll.setPreferredSize(new Dimension(900,200));
			roomScroll.setLocation(50, 200);
			
//------------유저리스트, 랭킹리스트--------------
			userList = new JTable();
			ranking = new JTable();
			
			userScroll = new JScrollPane(userList);
			rankScroll = new JScrollPane(ranking);
			userScroll.setBounds(1050, 210, 150, 200); // 유저접속리스트 
			rankScroll.setBounds(1050, 470, 150, 200); // 유저랭킹
			//userScroll.setPreferredSize(new Dimension(1000,100));
			//userList.setBounds(1050,210,150,200);
			
//--------------채팅창-------------------//
			
			chat = new JTextArea(); 
			chat.setEditable(false);
			chat.setBounds(90, 450, 900, 200);
			
			chatScroll = new JScrollPane(chat);
			
			input = new JTextField(30);
			input.addActionListener(this);
			input.setBounds(90, 550, 900, 100);
			
			/*
			chatScroll = new JScrollPane(chat);
			inputChat = new JPanel();
			inputChat.add(input);
			inputChat.setVisible(true);
			
			chatScroll.setBounds	(90, 470, 900, 200); // 채팅창 
			inputChat.setBounds		(90, 470, 900, 200); // 인풋 
			*/
			
//--------------패널 붙이기 ---------------//
			
			panel = new JPanel();
			
			//panel.add(createGame);
			//panel.add(shop);
			//panel.add(myPage);
			//panel.add(relationship);
			panel.add(roomScroll);
			//panel.add(chatScroll);
			//panel.add(userScroll);
			//panel.add(rankScroll);
			//panel.add(input);
			
			add(panel);
			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		}
	//배경이미지 삽입 메소드 
		public void paint(Graphics g) {
			//background = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
			//screenGraphic = background.getGraphics();
			//screenDraw(screenGraphic);
			g.drawImage(background, 0, 0, null);
			
		}
		
		public void screenDraw(Graphics g) {
			g.drawImage(introBackground, 0, 0, null);
			paintComponents(g);
			this.repaint();
		}
		
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == input) {
				chat.append(input.getText() + "\n");
				input.selectAll();
			}
		}
			
}