package Games.catchMind.view;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.geom.Line2D;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Game extends JFrame {
	//기본 
	private int x1, x2, y1, y2, z1, z2;
	private List<PaintDTO> list;
	private JFrame frame;
	private JPanel panel, userPan1, userPan2, userPan3, userPan4;
	private JButton blackBtn, redBtn, greenBtn, blueBtn, yellowBtn, eraserBtn, clearBtn, exitBtn, startBtn;
	private JLabel nickname1, nickname2, nickname3, nickname4, score1, score2, score3, score4, grade1, grade2, grade3, grade4;
	private Canvas canvas;
	private JDBCModel model;
	private JSlider slider;
	private JTextField chatInput;
	private JTextArea chatLog;
	private GameChat gameChat;
	private String nickName, answer;
	private boolean isowner;
	private static int gameNumber;
	private int color, thickness;
	private ObjectOutputStream writer;
	private ObjectInputStream reader;
	
	//이미지 
	private Image bufferImg;
	private Graphics2D g2, bufferG;
	
	
	private ImageIcon blackBtnIcon 	= new ImageIcon(GameRun.class.getResource("../image/blackBtnIcon.png"));
	private ImageIcon redBtnIcon 	= new ImageIcon(GameRun.class.getResource("../image/redBtnIcon.png"));
	private ImageIcon greenBtnIcon 	= new ImageIcon(GameRun.class.getResource("../image/greenBtnIcon.png"));
	private ImageIcon blueBtnIcon 	= new ImageIcon(GameRun.class.getResource("../image/blueBtnIcon.png"));
	private ImageIcon yellowBtnIcon = new ImageIcon(GameRun.class.getResource("../image/yellowBtnIcon.png"));
	private ImageIcon eraserBtnIcon = new ImageIcon(GameRun.class.getResource("../image/eraserBtnIcon.png"));
	private ImageIcon clearBtnIcon 	= new ImageIcon(GameRun.class.getResource("../image/clearBtnIcon.png"));
	
	//sound
	private ButtonSound bs;
	
	
	//호출	
	private PaintCanvas paintCanvas;
	private Socket socket;
	
	public Game() {
		//메인 프레임 설정 
				panel = new JPanel();
				setUndecorated(true);
				setSize(1280,720);
				setResizable(false);
				setLocationRelativeTo(null);
				
				paintCanvas = new PaintCanvas(Game.this); 
				canvas = paintCanvas.getCanvas();
				//그림판 설정 
				canvas = new Canvas() {
					public void paint(Graphics g) {
						g.drawImage(bufferImg, 0, 0, this);
					}
				};/*
					public void update(Graphics g) {
						Dimension d = canvas.getSize();
						if (bufferG == null) {
							bufferImg = canvas.createImage(d.width, d.height);
							bufferG = (Graphics2D) bufferImg.getGraphics();
						}
					};
					*/
				
				canvas.setBackground(Color.white);
				canvas.setBounds(300, 100, 700, 400);
				//frame.getContentPane().add(canvas);
				canvas.addMouseListener(new MouseAdapter() {
					public void mouseListener(MouseEvent e) {
						if(!isowner) return;
						Toolkit tk = Toolkit.getDefaultToolkit();
						Image cursorimage=tk.getImage("../image/pencilcursor.png");
						Point point = new Point(0,0);
						Cursor cursor = tk.createCustomCursor(cursorimage, point, "GG");
						canvas.setCursor(cursor);
					}
				});
				
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
				
				panel.add(canvas);
				
				add(panel);
				setVisible(true);
				setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				//Music music = new Music("bgm.mp3",true);
				//music.start();		
				//-------------------Button Actions---------------------
				
				
				
				
				
				frame.addWindowListener(new WindowAdapter() {
					/*
					@Override
					public void windowClosing(WindowEvent e) {
						bs = new ButtonSound("button.wav",true);
						int sel = JOptionPane.showConfirmDialog(frame, "게임 종료?");
						if(!(sel == JOptionPane.YES_OPTION)) {
							bs = new ButtonSound("button.wav",true);
							return;
						}
						bs = new ButtonSound("button.wav",true);
						
						model.addScoreWhenExitRoom(nickName);
						int no = model.exitScoreReset(nickName);
						
						System.out.println("점수 추가 완료");
						
						model.setOffline(model.getEmailByNickName(nickName));
						model.exitGame(nickName);
						
						if(model.isOwner(nickName)) {
							System.out.println("방장님이 퇴장합니다.");
							model.ownerExit(nickName);
							
							if(model.isEmptyRoom()) {
								model.setOwner(1);
							}else {
								no = model.getFilledRow();
								model.setOwner(no);
							}
						}
						
						PaintDTO dto = new PaintDTO();
						dto.setSignal(3);
						try {
							paintCanvas.getWriter().writeObject(dto);
							paintCanvas.getWriter().flush();
						}catch(IOException e1) {
							e1.printStackTrace();
						}
						System.exit(0);
					}
					*/
					
				});
				
				//---------대기실로 나가기 --------------
				
				}
			
			class MyCanvas extends Canvas{
				public MyCanvas() {
					setBackground(Color.white);
				}
				public void paint(Graphics g) {
					Graphics2D g2;
					g2 = (Graphics2D) g;
					g2.setColor(Color.WHITE);
					Font font = new Font("Serif", Font.PLAIN, 13);
					g2.setFont(font);
					g2.drawString("CatchMind", 10, 20);
					g2.setColor(Color.BLACK);
					g2.draw(new Line2D.Double(30,30,60,100));
				}
			
			}
	
	
		
	
	
	
		

	public JFrame getFrame() {return frame;}
	public Canvas getCanvas() {return canvas;}
	
	public JButton getBlackBtn() {return blackBtn;}
	public JButton getRedBtn() {return redBtn;}
	public JButton getGreenBtn() {return greenBtn;}
	public JButton getBlueBtn() {return blueBtn;}
	public JButton getYellowBtn() {return yellowBtn;}
	public JButton getEraserBtn() {return eraserBtn;}
	public JButton getClearBtn() {return clearBtn;}
	public JButton getStartBtn() {return startBtn;}
	public JButton getExitBtn() {return exitBtn;}
	
	public JSlider getSlider() {return slider;}
	public PaintCanvas getPaintCanvas() {return paintCanvas;}
	public JTextArea getChatLog() {return chatLog;}
	public JTextField getChatInput() {return chatInput;}
	public String getNickName() {return nickName;}
	public JDBCModel getModel() {return model;}
	public boolean getIsOwner() {return isowner;}
	public String getAnswer() {return answer;}
	public int getGameNumber() {return gameNumber;}
	

}
