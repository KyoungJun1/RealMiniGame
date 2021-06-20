package Games.one;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.SoftBevelBorder;

public class game1UI extends JFrame {

   SoftBevelBorder b1 = new SoftBevelBorder(SoftBevelBorder.LOWERED);
   SoftBevelBorder b2 = new SoftBevelBorder(SoftBevelBorder.RAISED);
   JDialog jd = new JDialog();
   JDialog jd2 = new JDialog();
   JDialog jd3 = new JDialog();
   
   
   JFrame jf = new JFrame();
   JPanel jp = new JPanel();
   JPanel jp2 = new JPanel();

   JTextField tf1 = new JTextField();
   JTextField tf2 = new JTextField();
   JTextField tf3 = new JTextField();
   JTextField tf4 = new JTextField();
   JTextField tf5 = new JTextField();

   public game1UI() {

      setframe();

   }

   public void setframe() {

      jf.setSize(1280, 720);
      jf.setUndecorated(true);
      jf.setLocationRelativeTo(null);
      jf.setLayout(null);
      jf.add(setpanel());
      jf.setVisible(true);
      jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

   }

   public JPanel setpanel() {

      jp.setSize(1280, 720);
      jp.setLayout(null);
      jp.setVisible(true);

      // 패널안 패널 설정//
      jp2.setLayout(null);
      jp2.setVisible(true);

      {
         jp2.setBounds(50, 50, 650, 400);
         jp2.setVisible(true);
         jp2.setBorder(b2);
         JButton btn1 = new JButton("확인");
         JButton btn2 = new JButton("확인");
         JButton btn3 = new JButton("확인");
         JButton btn4 = new JButton("확인");
         JButton btn5 = new JButton("확인");

         JLabel la1 = new JLabel("1");
         JLabel la2 = new JLabel("2");
         JLabel la3 = new JLabel("3");
         JLabel la4 = new JLabel("4");
         JLabel la5 = new JLabel("5");

         
         tf1.setEnabled(false);
         tf2.setEnabled(false);
         tf3.setEnabled(false);
         tf4.setEnabled(false);
         tf5.setEnabled(false);

         btn1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

               dia().setVisible(true);

            }

         });

         la1.setBounds(30, 30, 60, 40);
         tf1.setBounds(100, 30, 150, 40);
         btn1.setBounds(270, 30, 60, 40);

         la2.setBounds(30, 80, 60, 40);
         tf2.setBounds(100, 80, 150, 40);
         btn2.setBounds(270, 80, 60, 40);

         la3.setBounds(30, 130, 60, 40);
         tf3.setBounds(100, 130, 150, 40);
         btn3.setBounds(270, 130, 60, 40);

         la4.setBounds(30, 180, 60, 40);
         tf4.setBounds(100, 180, 150, 40);
         btn4.setBounds(270, 180, 60, 40);

         la5.setBounds(30, 230, 60, 40);
         tf5.setBounds(100, 230, 150, 40);
         btn5.setBounds(270, 230, 60, 40);

         jp2.add(btn1);
         jp2.add(btn2);
         jp2.add(btn3);
         jp2.add(btn4);
         jp2.add(btn5);

         jp2.add(la1);
         jp2.add(la2);
         jp2.add(la3);
         jp2.add(la4);
         jp2.add(la5);

         jp2.add(tf1);
         jp2.add(tf2);
         jp2.add(tf3);
         jp2.add(tf4);
         jp2.add(tf5);

      }
      jp.add(jp2);

      return jp;
   }

   public JDialog dia() {
      jd.setSize(500, 500);
      jd.setUndecorated(true);
      jd.setLayout(null);
      jd.setLocationRelativeTo(null);
      
      
      JLabel la11 = new JLabel("설명 : 아비지옥과 규환지\n옥을 아울러 이르는 말 ");
      JTextField jt11 = new JTextField();
      JButton btn11 = new JButton("나가기");
      JButton btn12 = new JButton("체크");
      la11.setBounds(10, 10, 300, 50);
      jt11.setBounds(40, 200, 150, 50);
      btn11.setBounds(70, 400, 80, 50);
      btn12.setBounds(170, 400,80, 50);
      
      btn12.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            String a =  "아비규환";
            if(jt11.getText().equals(a)) {
               clear().setVisible(true);
            }else {
               flase().setVisible(true);
            }
            
         }
         
      });
      
      btn11.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            jd.dispose();
         }
         
      });

      jd.add(la11);
      jd.add(jt11);
      jd.add(btn11);
      jd.add(btn12);

      return jd;
   }
   
   public JDialog clear() {

      
      jd2.setSize(200, 200);
      //jd2.setUndecorated(true);
      jd2.setLayout(null);
      jd2.setLocationRelativeTo(null);
      JButton btn12 = new JButton("정답입니다!!!");
      btn12.setBounds(20,20,150,60);
      btn12.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            tf1.setText("아비규환");
            jd.dispose();
            jd2.dispose();
         }
         
      });
      
      jd2.add(btn12);
      return jd2;
      
   }
   
   public JDialog flase() {
      jd3.setSize(200, 200);
      //jd3.setUndecorated(true);
      jd3.setLayout(null);
      jd3.setLocationRelativeTo(null);
      JButton btn12 = new JButton("틀렷습니다!!!");
      btn12.setBounds(20,20,150,60);
      btn12.addActionListener(new ActionListener() {

         @Override
         public void actionPerformed(ActionEvent e) {
            jd3.dispose();
         }
         
      });
      
      jd3.add(btn12);
      return jd3;
      
   }

}