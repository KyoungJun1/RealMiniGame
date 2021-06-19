package view.mainView;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Setting extends JFrame {

	public static void main(String[] args) {
		new Setting();
	}

	public Setting() {
		
		JPanel setting = new JPanel();
		setting.setBounds(0, 0, 400, 600);
		setting.setLayout(null);
		
		JLabel labBgm = new JLabel("배경음악");
		labBgm.setBounds(50, 50, 200, 50);
		
		JLabel labEffSound = new JLabel("효과음");
		labEffSound.setBounds(50, 180, 200, 50);
		
		JLabel labWinSize = new JLabel("화면크기");
		labWinSize.setBounds(50, 310, 200, 50);
		
		JButton exit = new JButton("나가기");
		exit.setBounds(130, 480, 150, 50);
		
		
		setting.add(labBgm);
		setting.add(labEffSound);
		setting.add(labWinSize);
		setting.add(exit);
		
		//이벤트 추가
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
		add(setting);
		setPreferredSize(new Dimension(400, 600));
		setSize(400, 600);
		setLocationRelativeTo(null); //화면 가운데 뜨게
		setResizable(false); //창 크기 고정
		setUndecorated(true); //타이틀바 제거
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
