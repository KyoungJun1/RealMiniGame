package ProjectTeam.menubar;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

public class MusicStart extends Thread {
//
	private Player p;
	private boolean isLoop;
	private File f;
	private FileInputStream fis;
	private BufferedInputStream bis;

	public void a() {
		try {
			f = new File(Main.class.getResource("../music/sound.mp3").toURI());
			fis = new FileInputStream(f);
			bis = new BufferedInputStream(fis);
			p = new Player(bis);
			p.play();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public void b() {
		try {
			f = new File(Main.class.getResource("../music/sound2.mp3").toURI());
			fis = new FileInputStream(f);
			bis = new BufferedInputStream(fis);
			p = new Player(bis);
			p.play();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void run() {
		try {

			p.play();

		} catch (JavaLayerException e) {
			e.printStackTrace();

		}
	}
}
