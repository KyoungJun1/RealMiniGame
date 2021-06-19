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
import javax.swing.JTextField;

public class Join extends JFrame {
	
	public Join() {
		
		//회원가입 창
		JPanel panelJoin = new JPanel();
		panelJoin.setBounds(0, 0, 400, 600);
		panelJoin.setLayout(null);
		
		JLabel joinInfo = new JLabel("가입정보를 입력하세요");
		joinInfo.setBounds(120, 30, 200, 50);
		joinInfo.setFont(new Font("맑은 고딕", Font.BOLD, 15));
		
		JLabel labJoinId = new JLabel("ID");
		labJoinId.setBounds(60, 120, 50, 50);
		labJoinId.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		
		JTextField txtJoinId = new JTextField();
		txtJoinId.setBounds(130, 120, 200, 50);
		
		JLabel labJoinPw = new JLabel("PW");
		labJoinPw.setBounds(60, 190, 50, 50);
		labJoinPw.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		
		JTextField txtJoinPw = new JTextField();
		txtJoinPw.setBounds(130, 190, 200, 50);
		
		JLabel labPwCheck = new JLabel("PW확인");
		labPwCheck.setBounds(60, 260, 60, 50);
		labPwCheck.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		
		JTextField txtPwCheck = new JTextField();
		txtPwCheck.setBounds(130, 260, 200, 50);
		
		JLabel labJoinNicname = new JLabel("닉네임");
		labJoinNicname.setBounds(60, 330, 50, 50);
		labJoinNicname.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		
		JTextField txtJoinNicname = new JTextField();
		txtJoinNicname.setBounds(130, 330, 200, 50);
		
		JLabel labJoinEmail = new JLabel("이메일");
		labJoinEmail.setBounds(60, 400, 50, 50);
		labJoinEmail.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		
		JTextField txtJoinEmail = new JTextField();
		txtJoinEmail.setBounds(130, 400, 200, 50);
		
		JButton joinCancel = new JButton("취소");
		joinCancel.setBounds(60, 500, 100, 50);
		
		JButton joinOk = new JButton("가입하기"); //모든 정보 입력했는지, 중복데이터 없는지 유효성 검사 추가.
		joinOk.setBounds(230, 500, 100, 50);
		
		
		panelJoin.add(joinInfo);
		panelJoin.add(labJoinId);
		panelJoin.add(labJoinPw);
		panelJoin.add(labPwCheck);
		panelJoin.add(labJoinNicname);
		panelJoin.add(labJoinEmail);
		panelJoin.add(txtJoinId);
		panelJoin.add(txtJoinPw);
		panelJoin.add(txtPwCheck);
		panelJoin.add(txtJoinNicname);
		panelJoin.add(txtJoinEmail);
		panelJoin.add(joinCancel);
		panelJoin.add(joinOk);
		
		
		//이벤트 추가
		joinCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
		joinOk.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String info = "입력하신 정보는\n\n ID : " + txtJoinId.getText()
				+ "\n 닉네임 : " + txtJoinNicname.getText()
				+ "\n 이메일 : " + txtJoinEmail.getText()
				+ "\n\n 입니다. 가입하시겠습니까?";
				
				int confirm = JOptionPane.showConfirmDialog(null, info, "확인", JOptionPane.OK_CANCEL_OPTION);
				if (confirm == JOptionPane.OK_OPTION) { 
					JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
				} else {
					
				}
			}
		});
		
		
		add(panelJoin);
		setPreferredSize(new Dimension(400, 600));
		setSize(400, 600);
		setLocationRelativeTo(null); //화면 가운데 뜨게
		setResizable(false); //창 크기 고정
		setUndecorated(true); //타이틀바 제거
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
