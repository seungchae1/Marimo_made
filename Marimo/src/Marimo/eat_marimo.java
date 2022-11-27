package Marimo;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class eat_marimo extends JFrame/*여기있는 이미지를 프레임에 그려줄거임.*/ implements ActionListener{
	   private Image background=new ImageIcon(day_marimo.class.getResource("../img/background_.png")).getImage();//배경이미지
	   private ImageIcon marimo = new ImageIcon(day_marimo.class.getResource("../img/marimo.png"));
	   private ImageIcon eat_marimo = new ImageIcon(day_marimo.class.getResource("../img/eat_marimo.png"));
	private Image sh = new ImageIcon(Shower_marimo.class.getResource("../img/sh_2.png")).getImage();
	private Image b = new ImageIcon(day_marimo.class.getResource("../img/boll.png")).getImage();
	private ImageIcon sh_b = new ImageIcon(day_marimo.class.getResource("../img/boll.png"));
	private ImageIcon btn_img = new ImageIcon(day_marimo.class.getResource("../img/icon_reallyboll.png"));
	private ImageIcon btn_img2 = new ImageIcon(day_marimo.class.getResource("../img/icon_medicine.png"));
	private ImageIcon btn_img3 = new ImageIcon(day_marimo.class.getResource("../img/icon_refresh.png"));
	private ImageIcon btn_img4 = new ImageIcon(day_marimo.class.getResource("../img/icon_shower.png"));
	private ImageIcon btn_sun = new ImageIcon(day_marimo.class.getResource("../img/sun.png"));
	private ImageIcon option1 = new ImageIcon(day_marimo.class.getResource("../img/strawberry.png"));
	private ImageIcon option2 = new ImageIcon(day_marimo.class.getResource("../img/grapes.png"));
	private ImageIcon option3 = new ImageIcon(day_marimo.class.getResource("../img/banana.png"));
	
	int s_x= 500, s_y=20; //샤워볼 위치
	int sel=-1;
	Image img_buffer = null;
	Graphics buffer = null;
	
	   JPanel main_panel, sun_panel, m_panel;
	   JButton btn, btn2, btn3, btn4, sun, op1, op2, op3, eat_m;
	   public eat_marimo() {
	      setTitle("마리모 키우기");//타이틀
	      setResizable(false);//창의 크기를 변경하지 못하게
	      setSize(725,1024);
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      setLocationRelativeTo(null);//창이 가운데 나오게
	      main_panel = new JPanel(); // 패널 객체화 / 기본배치관리자 FlowLayout
	      sun_panel = new JPanel();
	      m_panel = new JPanel();
	      setLayout(null);
	      main_panel.setBounds(0, 780, 700, 200);
	      sun_panel.setBounds(0,0,170,200);
	      m_panel.setBounds(300, 400, 170, 200);
	      
	      //버튼 생성
	      btn = new JButton(btn_img);
	      btn2 = new JButton(btn_img2);
	      btn3 = new JButton(btn_img3);
	      btn4 = new JButton(btn_img4);
	      sun = new JButton(btn_sun);
	      eat_m= new JButton(marimo);
	      
	      btn.setBorderPainted(false); // 버튼 테두리 설정해제
	      btn2.setBorderPainted(false); // 버튼 테두리 설정해제
	      btn3.setBorderPainted(false); // 버튼 테두리 설정해제
	      btn4.setBorderPainted(false); // 버튼 테두리 설정해제
	      sun.setBorderPainted(false);
	      eat_m.setBorderPainted(false);
	      
	      btn.setPreferredSize(new Dimension(160, 180)); // 버튼 크기 지정
	      btn2.setPreferredSize(new Dimension(170, 180)); // 버튼 크기 지정
	      btn3.setPreferredSize(new Dimension(150, 180)); // 버튼 크기 지정
	      btn4.setPreferredSize(new Dimension(185, 180)); // 버튼 크기 지정
	      sun.setPreferredSize(new Dimension(170,170));
	      eat_m.setPreferredSize(new Dimension(170,200));
	      
	      btn.setBackground(new Color(233,225,255,255));  //축구공
	      btn2.setBackground(new Color(233,225,255,255)); //약
	      btn3.setBackground(new Color(233,225,255,255)); //냉장고
	      btn4.setBackground(new Color(233,225,255,255)); //샤워
	      sun.setBackground(new Color(233,225,255,255));
	      eat_m.setBackground(new Color(233,225,255,255));
	      
	      eat_m.addActionListener(this);
	      btn4.addActionListener(this);
	      btn3.addActionListener(this);
	      
	      main_panel.add(btn3); // 패널에 버튼을 붙여준다
	      main_panel.add(btn4); // 패널에 버튼을 붙여준다
	      main_panel.add(btn); // 패널에 버튼을 붙여준다
	      main_panel.add(btn2); // 패널에 버튼을 붙여준다
	      sun_panel.add(sun);
	      m_panel.add(eat_m);
	      
	      add(main_panel); // 메인 프레임에 메인패널을 붙여주는 작업
	      add(sun_panel);  // 메인 프레임에 썬패널 붙여주는 작업
	      add(m_panel);
	      //add(ball_panel);
	      setVisible(true); // 프레임 보이게 하기
	}
	public ImageIcon[] answer={option1, option2, option3};
	public void JOptionPaneEx(){
		sel=-1;
		 sel= JOptionPane.showOptionDialog(this, null, "마리모에게 줄 음식"
			,JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE, null, answer, null );
		switch(sel) {
		case 0:
			btn3.setIcon(option1);
			break;
		case 1:
			btn3.setIcon(option2);
			break;
		case 2:
			btn3.setIcon(option3); 
			break;
		default : btn3.setIcon(btn_img3);
		}
	}
	public void paint(Graphics g) {//그리는 함수
	      g.drawImage(background, 0, 0, null);//background를 그려줌
	      //g.drawImage(marimo, 250, 480, null);
	}
	
	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		//buffer.clearRect(0,0,getWidth(),getHeight());
		//buffer.drawImage(b,s_x, s_y, this);
		//g.drawImage(img_buffer,0,0,this);
		repaint();
	}
	public static void main(String args[]) {
		new eat_marimo();
	}

	   @Override
	   public void actionPerformed(ActionEvent e) {
	      if(e.getSource()==btn4) {
	         Shower_marimo shower = new Shower_marimo();
	         setVisible(false); 
	      }
	      else if(e.getSource() == sun) {
	    	  night_marimo c = new night_marimo();
	          setVisible(false); 
	      }
	      else if(e.getSource() == btn) {
	    	  Reallyboll_marimo a = new Reallyboll_marimo();
	          setVisible(false); 
	      }
	      else if(e.getSource() == btn3) {
	    	  JOptionPaneEx();
	      }
	      else if(e.getSource()==eat_m) {
	    	  if(sel!=-1) {
	    		  eat_m.setIcon(eat_marimo);
	    	  }
	    	  else {
	    		  eat_m.setIcon(marimo); 
	    	  }
	      }
	   }
	}