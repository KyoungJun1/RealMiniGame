package Games.catchMind.view;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Game extends JFrame {
	//기본 
	private JFrame frame;
	private JPanel panel, userPan1, userPan2, userPan3, userPan4;
	private JButton blackBtn, redBtn, greenBtn, blueBtn, yellowBtn, eraserBtn, clearBtn;
	private JLabel 
	nickname1, nickname2, nickname3, nickname4,
	score1,	   score2,    score3,    score4, 
	grade1,    grade2,    grade3,    grade4;
	private Canvas canvas;
	
	//이미지 
	private Image bufferImg;
	private Graphics2D bufferG;
	
	private ImageIcon blackBtnIcon 	= new ImageIcon(GameRun.class.getResource("../image/blackBtnIcon.png"));
	private ImageIcon redBtnIcon 	= new ImageIcon(GameRun.class.getResource("../image/redBtnIcon.png"));
	private ImageIcon greenBtnIcon 	= new ImageIcon(GameRun.class.getResource("../image/greenBtnIcon.png"));
	private ImageIcon blueBtnIcon 	= new ImageIcon(GameRun.class.getResource("../image/blueBtnIcon.png"));
	private ImageIcon yellowBtnIcon = new ImageIcon(GameRun.class.getResource("../image/yellowBtnIcon.png"));
	private ImageIcon eraserBtnIcon = new ImageIcon(GameRun.class.getResource("../image/eraserBtnIcon.png"));
	private ImageIcon clearBtnIcon 	= new ImageIcon(GameRun.class.getResource("../image/clearBtnIcon.png"));
	
	//호출	
	private PaintCanvas paintCanvas;
	
	
	public Game() {
		CatchMind();
	}
	
	public void CatchMind() {
		//메인 프레임 설정 
		panel = new JPanel();
		setUndecorated(true);
		setSize(1280,720);
		setResizable(false);
		setLocationRelativeTo(null);
		
		//paintCanvas = new PaintCanvas(Game.this); 
		//그림판 설정 
		canvas = new Canvas() {
			public void paint(Graphics g) {
				g.drawImage(bufferImg, 0, 0, this);
			}
			
			public void update(Graphics g) {
				Dimension d = canvas.getSize();
				if (bufferG == null) {
					bufferImg = canvas.createImage(d.width, d.height);
					bufferG = (Graphics2D) bufferImg.getGraphics();
				}
			}
			
			
			
		};
		canvas.setBackground(Color.white);
		
		
		//버튼 설정 
		blackBtn = new JButton(blackBtnIcon); 
		blackBtn.setBounds(550, 500, 45, 70);
		
		redBtn = new JButton(redBtnIcon); 
		redBtn.setBounds(600, 500, 45, 70);
		
		greenBtn = new JButton(greenBtnIcon); 
		greenBtn.setBounds(650, 500, 45, 70);
		
		blueBtn = new JButton(blueBtnIcon); 
		blueBtn.setBounds(700, 500, 45, 70);
		
		yellowBtn = new JButton(yellowBtnIcon); 
		yellowBtn.setBounds(750, 500, 45, 70);
		
		eraserBtn = new JButton(eraserBtnIcon); 
		eraserBtn.setBounds(800, 500, 50, 50);
		
		clearBtn = new JButton(clearBtnIcon); 
		clearBtn.setBounds(850, 500, 100, 50);
		
		
		panel.setLayout(null);
		panel.setVisible(true);
		
		panel.add(blackBtn);
		panel.add(redBtn);
		panel.add(greenBtn);
		panel.add(blueBtn);
		panel.add(yellowBtn);
		panel.add(eraserBtn);
		panel.add(clearBtn);
		
		add(panel);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	
}
