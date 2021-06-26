package Games.catchMind.view;

import java.awt.Canvas;

import javax.swing.JFrame;

public class PaintCanvas  {

	private Game game;
	private Canvas canvas;
	private JFrame frame;
	
	//--server
	private final String serverIP = "localhost";
	private final int port = 1521;
	
	
	public PaintCanvas(Game game) {
		
		this.game = game;
		this.frame = game.getFrame();
		this.blackBtn = game.getBlackBtn();
	}
	
	
}
