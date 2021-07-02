package Games.catchMind.view;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GameChat {

	private JFrame frame;
	private Socket socket;
	private ObjectOutputStream writer;
	private ObjectInputStream reader;
	private Game game;
	private JTextArea chatLog;
	private JTextField chatInput;
	private String nickName;
	private JDBCModel model;
	private JButton logoutBtn, exitBtn;
	private static int gameNumber;
	private ChatSound cs;
	
	private final String serverIP = "";
	private final int port = 1521;
	
	public GameChat(Game game) {
		//채팅클라이언트를 호출한 WaitingRoom 클래스로부터 입력부, 출력부, 닉네임, 모델, 보내기버튼, 프레임을 넘겨받는다. 
		this.game = game;
		this.chatLog = game.getChatLog();
		this.chatInput = game.getChatInput();
		this.nickName = game.getNickName();
		this.model = game.getModel();
		this.frame = game.getFrame();
		
		try {
			socket = new Socket(serverIP, port);
			writer = new ObjectOutputStream(socket.getOutputStream());
			reader = new ObjectInputStream(socket.getInputStream());
		}catch (UnknownHostException e) {
			System.out.println("서버를 찾을 수 없습니다.");
			e.printStackTrace();
			System.exit(0);
		}catch (IOException e1) {
			System.out.println("서버와 연결이 되지 않습니다.");
			e1.printStackTrace();
			System.exit(0);
		}
		
		Thread chattingThread = new Thread(new Runnable() {

			@Override
			public void run() {
				GameChatDTO dto = new GameChatDTO();
				dto.setCommand(Info.JOIN);
				dto.setNickName(nickName);
				try {
					writer.writeObject(dto);
					writer.flush();
				}catch(IOException e) {
					e.printStackTrace();
				}
				
				GameChatDTO userDTO = null;
				while (true) {
					try {
						userDTO = (GameChatDTO) reader.readObject();
						cs = new ChatSound();
						
						
						
						
						
						
						
						
					}catch(IOException e) {
						e.printStackTrace();
					} catch(ClassNotFoundException e) {
						e.printStackTrace();
					}
				}
			}
			
		});
	}
}
