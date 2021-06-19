package view.lobbyView;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import view.lobbyView.*;

public class Lobby extends JFrame{
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
	
	//배경이미지 삽입 메소드 
	public void paint(Graphics g) {
		//background = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		//screenGraphic = background.getGraphics();
		//screenDraw(screenGraphic);
		g.drawImage(background, 0, 0, null);
		
	}
	/*
	public void screenDraw(Graphics g) {
		g.drawImage(introBackground, 0, 0, null);
		paintComponents(g);
		this.repaint();
	}
	*/
	//기본생성자 
	public Lobby() {
		LobbyMain();
	}
	
	//메인                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    
	public void LobbyMain() {
			add(panel);
//---------------메인 프레임 패널설정----------------------// 
			setTitle("로비");
			setUndecorated(true);
			setVisible(true);
			setSize(1280,720);
			setResizable(false);
			setLocationRelativeTo(null);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					
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
			shop = new JButton(createImg);
			shop.setLayout(null);
			shop.setBounds(340, 50, 200, 100); //상점버튼 
			shop.setBorderPainted(false);
			shop.setContentAreaFilled(false);
			shop.setFocusPainted(false);
			
			//마이페이지버튼 
			myPage = new JButton(createImg);
			myPage.setLayout(null);
			myPage.setBounds(590, 50, 200, 100);
			myPage.setBorderPainted(false);
			myPage.setContentAreaFilled(false);
			myPage.setFocusPainted(false);
			
			//친구추가버튼 
			relationship = new JButton(createImg);
			relationship.setLayout(null);
			relationship.setBounds(840, 50, 200, 100); 
			relationship.setBorderPainted(false);
			relationship.setContentAreaFilled(false);
			relationship.setFocusPainted(false);
			
//-----------------설정, 취소(뒤로가기)버튼---------------
			
			falseBar.setBounds(50, 1100, 50, 50);
			gearBar.setBounds(50, 1150, 50, 50);
		
			
//--------------방 리스트----------------------
			
			roomScroll = new JScrollPane(roomList);
			roomScroll.setBounds	(90, 210, 900, 200); // 방 리스트 
			
//------------유저리스트, 랭킹리스트--------------
			/*
			userScroll.setBounds	(1050, 210, 150, 200); // 유저접속리스트 
			rankScroll.setBounds	(1050, 470, 150, 200); // 유저랭킹 
			
			userScroll = new JScrollPane(userList);
			rankScroll = new JScrollPane(ranking);
			*/
//--------------채팅창-------------------//
			chatScroll = new JScrollPane(chat);
			//inputChat.add(input);
			//inputChat.setVisible(true);
			
			chatScroll.setBounds	(90, 470, 900, 200); // 채팅창 
			//inputChat.setBounds		(90, 470, 900, 200); // 인풋 
			
			
//--------------패널 붙이기 ---------------//
			
			
			panel.add(inputChat);
			panel.add(createGame);
			panel.add(shop);
			panel.add(myPage);
			panel.add(relationship);
			panel.add(roomScroll);
			panel.add(chatScroll);
			panel.add(userScroll);
			panel.add(rankScroll);
			

		}
		
			
}