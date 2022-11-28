package Marimo;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Shower_marimo extends JFrame/*여기있는 이미지를 프레임에 그려줄거임.*/ implements ActionListener, MouseMotionListener, MouseListener{
	private Image background=new ImageIcon(Shower_marimo.class.getResource("../img/sh.png")).getImage();//배경이미지
	private Image marimo = new ImageIcon(Shower_marimo.class.getResource("../img/shower_marimo.png")).getImage();
	private Image sh = new ImageIcon(Shower_marimo.class.getResource("../img/sh_2.png")).getImage();
	private Image b = new ImageIcon(day_marimo.class.getResource("../img/boll.png")).getImage();
	private ImageIcon sh_b = new ImageIcon(day_marimo.class.getResource("../img/boll.png"));
	private ImageIcon btn_img = new ImageIcon(day_marimo.class.getResource("../img/icon_reallyboll.png"));
	private ImageIcon btn_img2 = new ImageIcon(day_marimo.class.getResource("../img/icon_medicine.png"));
	private ImageIcon btn_img3 = new ImageIcon(day_marimo.class.getResource("../img/icon_refresh.png"));
	private ImageIcon btn_img4 = new ImageIcon(day_marimo.class.getResource("../img/icon_shower.png"));
	private ImageIcon btn_sun = new ImageIcon(day_marimo.class.getResource("../img/sun.png"));
	int s_x= 500, s_y=200; //샤워볼 위치
	
	   JPanel main_panel, sun_panel;
	   JLabel money_text;
	   JButton btn, btn2, btn3, btn4, sun, sh_ball;
	   public Shower_marimo() {
	      setTitle("마리모 키우기");//타이틀
	      setResizable(false);//창의 크기를 변경하지 못하게
	      setSize(725,1024);
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      setLocationRelativeTo(null);//창이 가운데 나오게
	      setVisible(true); // 프레임 보이게 하기

	      MyPanel my_panel = new MyPanel();
	      main_panel = new JPanel(); // 패널 객체화 / 기본배치관리자 FlowLayout
	      sun_panel = new JPanel();
	      money_text = new JLabel("money : "+Integer.toString(My_marimo.get_money()), JLabel.CENTER);
	      money_text.setPreferredSize(new Dimension(150,0));
	      
	      
	      setLayout(null);
	      main_panel.setBounds(0, 780, 700, 200);
	      sun_panel.setBounds(0,0,170,200);
	      my_panel.setBounds(0, 0, 725, 980);
	      
	      //버튼 생성
	      btn = new JButton(btn_img);
	      btn2 = new JButton(btn_img2);
	      btn3 = new JButton(btn_img3);
	      btn4 = new JButton(btn_img4);
	      sun = new JButton(btn_sun);
	      sh_ball = new JButton(sh_b);
	      
	      btn.setBorderPainted(false); // 버튼 테두리 설정해제
	      btn2.setBorderPainted(false); // 버튼 테두리 설정해제
	      btn3.setBorderPainted(false); // 버튼 테두리 설정해제
	      btn4.setBorderPainted(false); // 버튼 테두리 설정해제
	      sun.setBorderPainted(false);
	      sh_ball.setBorderPainted(false);
	      
	      btn.setPreferredSize(new Dimension(160, 180)); // 버튼 크기 지정
	      btn2.setPreferredSize(new Dimension(170, 180)); // 버튼 크기 지정
	      btn3.setPreferredSize(new Dimension(150, 180)); // 버튼 크기 지정
	      btn4.setPreferredSize(new Dimension(185, 180)); // 버튼 크기 지정
	      sun.setPreferredSize(new Dimension(170,170));
	      sh_ball.setPreferredSize(new Dimension(170,170));
	      
	      btn.setBackground(new Color(209,234,241,255)); //축구공
	      btn2.setBackground(new Color(209,234,241,255)); //약
	      btn3.setBackground(new Color(209,234,241,255)); //냉장고
	      btn4.setBackground(new Color(209,234,241,255)); //샤워
	      sun.setBackground(new Color(209,234,241,255));
	      sh_ball.setBackground(new Color(209,234,241,255));
	      
	      sun.addActionListener(this);
	      btn4.addActionListener(this);
	      btn3.addActionListener(this);
	      addMouseMotionListener(this);
	      
	      main_panel.add(btn3); // 패널에 버튼을 붙여준다
	      main_panel.add(btn4); // 패널에 버튼을 붙여준다
	      main_panel.add(btn); // 패널에 버튼을 붙여준다
	      main_panel.add(btn2); // 패널에 버튼을 붙여준다
	      
	      main_panel.setBackground(new Color(209,234,241,255));
	      sun_panel.setBackground(new Color(209,234,241,255));
	      sun_panel.setLayout(new BorderLayout());
	      sun_panel.add(sun, BorderLayout.WEST);
	      sun_panel.add(money_text, BorderLayout.EAST);
	      
	      my_panel.setLayout(new BorderLayout());
	      my_panel.add(sun_panel, BorderLayout.NORTH);
	      my_panel.add(main_panel, BorderLayout.SOUTH);

	      add(my_panel); // 메인 프레임에 메인패널을 붙여주는 작업
	}
	   
	   class MyPanel extends JPanel{
           @Override
           public void paintComponent(Graphics g){
               super.paintComponent(g);
               g.drawImage(background,0,0,getWidth(),getHeight(),this);
               g.drawImage(marimo,260,480,190,190,this);
               g.drawImage(sh,0,0,getWidth(),getHeight(),this);
           }
    }
	   
	private Image img_buffer;
	private Graphics buffer;
	public void paint(Graphics g) {//그리는 함수
		img_buffer = createImage(725,1024);
		buffer = img_buffer.getGraphics();
		paintComponents(buffer);
		
		buffer.drawImage(b, s_x, s_y,null);
		
		g.drawImage(img_buffer, 0,0,null);
		repaint();
	}
	
	@Override
	public void paintComponents(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponents(g);
	}
	public static void main(String args[]) {
		new Shower_marimo();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn4) {
			Shower_marimo a = new Shower_marimo();
	         setVisible(false);
	    }
		else if(e.getSource()==btn3) {
			eat_marimo a = new eat_marimo();
	         setVisible(false);
		}
	    else if(e.getSource() == sun) {
	    	day_marimo a = new day_marimo();
	        setVisible(false); 
	    }
	}
	private int dragg_cnt=0;
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		dragg_cnt++;
		if(dragg_cnt%300==0) { 
			My_marimo.set_money(100); 
			money_text.setText("money : "+Integer.toString(My_marimo.get_money()));	
		}
		
		s_x=e.getX()-100;
		s_y=e.getY()-100;
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
	}
}