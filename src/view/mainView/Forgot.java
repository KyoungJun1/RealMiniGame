package view.mainView;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Forgot extends JFrame {
	
	public Forgot() {
		
		JTabbedPane tab = new JTabbedPane();
		tab.setFont(new Font("맑은 고딕", Font.CENTER_BASELINE, 20));
		
		//ID 찾기 탭
		JPanel panelForgotId = new JPanel();
		panelForgotId.setBounds(0, 0, 400, 600);
		panelForgotId.setLayout(null);
		
		JLabel labIdEmail = new JLabel("가입한 이메일 주소를 입력하세요.");
		labIdEmail.setBounds(50, 100, 250, 50);
		labIdEmail.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		
		JTextField txtIdEmail = new JTextField();
		txtIdEmail.setBounds(50, 200, 300, 50);
		
		JButton sendIdEmail = new JButton("아이디 찾기");
		sendIdEmail.setBounds(130, 330, 150, 50);
		
		JButton exitId = new JButton("나가기");
		exitId.setBounds(130, 400, 150, 50);
		
		
		panelForgotId.add(labIdEmail);
		panelForgotId.add(txtIdEmail);
		panelForgotId.add(sendIdEmail);
		panelForgotId.add(exitId);
		
		//PW 찾기 탭
		JPanel panelForgotPw = new JPanel();
		panelForgotPw.setBounds(0, 0, 400, 600);
		panelForgotPw.setLayout(null);
		
		JLabel labPwId = new JLabel("미니게임월드 아이디를 입력하세요.");
		labPwId.setBounds(50, 50, 250, 50);
		labPwId.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		
		JTextField txtPwId = new JTextField();
		txtPwId.setBounds(50, 120, 300, 50);
		
		JLabel labPwEmail = new JLabel("가입한 이메일 주소를 입력하세요.");
		labPwEmail.setBounds(50, 200, 250, 50);
		labPwEmail.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		
		JTextField txtPwEmail = new JTextField();
		txtPwEmail.setBounds(50, 270, 300, 50);
		
		JButton sendPwEmail = new JButton("비밀번호 찾기");
		sendPwEmail.setBounds(130, 370, 150, 50);
		
		JButton exitPw = new JButton("나가기");
		exitPw.setBounds(130, 440, 150, 50);
		
		
		panelForgotPw.add(labPwId);
		panelForgotPw.add(txtPwId);
		panelForgotPw.add(labPwEmail);
		panelForgotPw.add(txtPwEmail);
		panelForgotPw.add(sendPwEmail);
		panelForgotPw.add(exitPw);
		
		tab.add("     아이디찾기     ", panelForgotId);
		tab.add("    비밀번호찾기    ", panelForgotPw);
	
		
		//이벤트 추가
		sendIdEmail.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//팝업
				JOptionPane.showMessageDialog(null, "메일로 아이디 정보를 전송하였습니다.");
			}
		});
		
		sendPwEmail.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//팝업
				JOptionPane.showMessageDialog(null, "메일로 비밀번호를 전송하였습니다.");
			}
		});
		
		exitId.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		exitPw.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		add(tab);
		setPreferredSize(new Dimension(400, 600));
		setSize(400, 600);
		setLocationRelativeTo(null); //화면 가운데 뜨게
		setResizable(false); //창 크기 고정
		setUndecorated(true); //타이틀바 제거
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
