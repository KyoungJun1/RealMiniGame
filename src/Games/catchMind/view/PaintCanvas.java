package Games.catchMind.view;

import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JSlider;

public class PaintCanvas  {

	private Image bufferImg;
	private Game game;
	private Graphics2D bufferG;
	private int x1, x2, y1, y2, z1, z2;
	private Canvas canvas;
	private JFrame frame;
	private JButton blackBtn, redBtn, greenBtn, blueBtn, yellowBtn, eraserBtn,clearBtn;
	private ArrayList<PaintDTO> list;
	private Socket socket;
	
	private ObjectOutputStream writer;
	private ObjectInputStream reader;
	private int color, thickness;
	private JSlider slider;
	private ButtonSound bs;
	//--server
	private final String serverIP = "localhost";
	private final int port = 1521;
	
	
	
	public PaintCanvas(Game game) {
		
		this.game 		= game;
		this.frame 		= game.getFrame();
		this.blackBtn 	= game.getBlackBtn();
		this.redBtn 	= game.getRedBtn();
		this.greenBtn 	= game.getGreenBtn();
		this.blueBtn 	= game.getBlueBtn();
		this.yellowBtn 	= game.getYellowBtn();
		this.eraserBtn 	= game.getEraserBtn();
		this.clearBtn 	= game.getClearBtn();
		
		list = new ArrayList<PaintDTO>();
		canvas = new Canvas() {

			@Override
			public void paint(Graphics g) {
				g.drawImage(bufferImg, 0, 0, this);
				
			}

			@Override
			public void update(Graphics g) {
				Dimension d = canvas.getSize();
				if(bufferG == null) {
					bufferImg = canvas.createImage(d.width, d.height);
					bufferG = (Graphics2D) bufferImg.getGraphics();
				}
				try {
					if(list == null)
						return;
					
					for(PaintDTO dto : list) {
						int  color = dto.getColor();
						if(color == 0) {bufferG.setColor(Color.black);}
						if(color == 1) {bufferG.setColor(Color.red);}
						if(color == 2) {bufferG.setColor(Color.green);}
						if(color == 3) {bufferG.setColor(Color.blue);}
						if(color == 4) {bufferG.setColor(Color.yellow);}
						if(color == 5) {bufferG.setColor(canvas.getBackground());}
						
						int stroke = dto.getStroke();
						bufferG.setStroke(new BasicStroke(stroke));
						
						x1 = dto.getX1();
						y1 = dto.getY1();
						x2 = dto.getX2();
						y2 = dto.getY2();
						bufferG.drawLine(x1, y1, x2, y2);
					}
				}catch(ConcurrentModificationException e) {
					
				}
				
				paint(g);
			}
			
			
		};
		canvas.setBackground(Color.white);
		
		
		
		//----------------button actions----------------
		// X눌렀을때
		
		// 검정 눌렀을때
		blackBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				bs = new ButtonSound("button.wav",true);
				color = 0;
			}
			
		});
		redBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				bs = new ButtonSound("button.wav",true);
				color = 1;
			}
			
		});
		greenBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				bs = new ButtonSound("button.wav",true);
				color = 2;
			}
			
		});
		blueBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				bs = new ButtonSound("button.wav",true);
				color = 3;
			}
			
		});
		yellowBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				bs = new ButtonSound("button.wav",true);
				color = 4;
			}
			
		});
		eraserBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				bs = new ButtonSound("button.wav",true);
				color = 4;
			}
			
		});
		clearBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				bs = new ButtonSound("button.wav",true);
				color = 5;
			}
			
		});
		canvas.addMouseWheelListener(new MouseWheelListener() {

			@Override
			public void mouseWheelMoved(MouseWheelEvent e) {
				// TODO Auto-generated method stub
				thickness = slider.getValue();
				int n = e.getWheelRotation();
				if(n < 0) {
					slider.setValue(thickness + 3);
				}else if(n > 0) {
					slider.setValue(thickness - 3);
				}
			}
			
		});
		canvas.addMouseListener(new MouseAdapter() {
			
			public void mousePressed(MouseEvent e) {
				if(!(game.getIsOwner())) return;
				z1 = e.getX();
				z2 = e.getY();
			}
		});
		//---------발신부 시작 
		canvas.addMouseMotionListener(new MouseAdapter() {

			@Override
			public void mouseDragged(MouseEvent e) {
				if(!(game.getIsOwner())) return;
				x2 = e.getX();
				y2 = e.getY();
				
				PaintDTO dto = new PaintDTO();
				dto.setX1(z1);
				dto.setY1(z2);
				dto.setX2(x2);
				dto.setY2(y2);
				dto.setSignal(2); // 2는 정상메세지, 1은 초기화, 3은 퇴장시그널 
				dto.setColor(color); //필드선언된 color는 버튼액션에 반응해서 변경된 후 dto에 삽입된다.
				dto.setStroke(slider.getValue()/4);
				
				try {
					writer.writeObject(dto);
					writer.flush();
				}catch(IOException e1) {
					e1.printStackTrace();
				}
				
				z1=e.getX();
				z2=e.getY();
				
			}
			
		});
		//-------발신부 끝
		//-------수신부 시작 
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				while(true) {
					try {
						
						PaintDTO dto = (PaintDTO) reader.readObject();
						if(dto.getSignal() == 1) {
							setNewCanvas();
						}
						if(dto.getSignal() == 2) {
							canvas.repaint();
							list.add(dto);
						}
						if(dto.getSignal() == 3) {
							writer.close();
							reader.close();
							socket.close();
							frame.dispose();
							break;
						}
						
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
			
		});
		t.setDaemon(true);
		t.start();
	}
	public void setNewCanvas() {
		list.clear();
		bufferG = null;
		canvas.repaint();
	}
	public void exit() {
		PaintDTO dto = new PaintDTO();
		dto.setSignal(3);
		try {
			writer.writeObject(dto);
			writer.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public ObjectOutputStream getWriter() {return writer;}
	public ObjectInputStream getReader() {return reader;}
	public Socket getSocket() {return socket;}
	public Canvas getCanvas() {return canvas;}
	
	
}
