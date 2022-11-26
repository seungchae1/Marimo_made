package Marimo;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Shower_marimo extends JFrame/*�����ִ� �̹����� �����ӿ� �׷��ٰ���.*/ implements ActionListener, MouseMotionListener, MouseListener{
	private Image background=new ImageIcon(Shower_marimo.class.getResource("../img/sh.png")).getImage();//����̹���
	private Image marimo = new ImageIcon(Shower_marimo.class.getResource("../img/shower_marimo.png")).getImage();
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
	int s_x= 500, s_y=20; //������ ��ġ
	
	Image img_buffer = null;
	Graphics buffer = null;
	
	Point point = MouseInfo.getPointerInfo().getLocation();
	   JPanel main_panel, sun_panel, ball_panel;
	   JButton btn, btn2, btn3, btn4, sun, sh_ball, op1, op2, op3;
	   public Shower_marimo() {
	      setTitle("������ Ű���");//Ÿ��Ʋ
	      setResizable(false);//â�� ũ�⸦ �������� ���ϰ�
	      setSize(725,1024);
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      setLocationRelativeTo(null);//â�� ��� ������
	      main_panel = new JPanel(); // �г� ��üȭ / �⺻��ġ������ FlowLayout
	      sun_panel = new JPanel();
	      ball_panel = new JPanel();
	      
	      setLayout(null);
	      main_panel.setBounds(0, 780, 700, 200);
	      sun_panel.setBounds(0,0,170,200);
	      ball_panel.setBounds(s_x,s_y, 170, 170);
	      
	      //��ư ����
	      btn = new JButton(btn_img);
	      btn2 = new JButton(btn_img2);
	      btn3 = new JButton(btn_img3);
	      btn4 = new JButton(btn_img4);
	      sun = new JButton(btn_sun);
	      sh_ball = new JButton(sh_b);
	      
	      btn.setBorderPainted(false); // ��ư �׵θ� ��������
	      btn2.setBorderPainted(false); // ��ư �׵θ� ��������
	      btn3.setBorderPainted(false); // ��ư �׵θ� ��������
	      btn4.setBorderPainted(false); // ��ư �׵θ� ��������
	      sun.setBorderPainted(false);
	      sh_ball.setBorderPainted(false);
	      
	      btn.setPreferredSize(new Dimension(160, 180)); // ��ư ũ�� ����
	      btn2.setPreferredSize(new Dimension(170, 180)); // ��ư ũ�� ����
	      btn3.setPreferredSize(new Dimension(150, 180)); // ��ư ũ�� ����
	      btn4.setPreferredSize(new Dimension(185, 180)); // ��ư ũ�� ����
	      sun.setPreferredSize(new Dimension(170,170));
	      sh_ball.setPreferredSize(new Dimension(170,170));
	      
	      btn.setBackground(new Color(209,234,241,255));  //�౸��
	      btn2.setBackground(new Color(209,234,241,255)); //��
	      btn3.setBackground(new Color(209,234,241,255)); //�����
	      btn4.setBackground(new Color(209,234,241,255)); //����
	      sun.setBackground(new Color(209,234,241,255));
	      sh_ball.setBackground(new Color(209,234,241,255));
	      
	      btn4.addActionListener(this);
	      btn3.addActionListener(this);
	      addMouseMotionListener(this);
	      
	      main_panel.add(btn3); // �гο� ��ư�� �ٿ��ش�
	      main_panel.add(btn4); // �гο� ��ư�� �ٿ��ش�
	      main_panel.add(btn); // �гο� ��ư�� �ٿ��ش�
	      main_panel.add(btn2); // �гο� ��ư�� �ٿ��ش�
	      sun_panel.add(sun);
	      ball_panel.add(sh_ball);
	      
	      add(main_panel); // ���� �����ӿ� �����г��� �ٿ��ִ� �۾�
	      add(sun_panel);  // ���� �����ӿ� ���г� �ٿ��ִ� �۾�
	      //add(ball_panel);
	      setVisible(true); // ������ ���̰� �ϱ�
	}
	public JButton[] answer={op1, op2, op3};
	public void JOptionPaneEx(){
		answer[0]= new JButton(option1);
		answer[1]= new JButton(option2);
		answer[2]= new JButton(option3);
		answer[0].setBorderPainted(false);
		answer[1].setBorderPainted(false);
		answer[2].setBorderPainted(false);
		answer[0].setPreferredSize(new Dimension(170,170));
		answer[1].setPreferredSize(new Dimension(170,170));
		answer[2].setPreferredSize(new Dimension(170,170));
		answer[0].setBackground(new Color(255,255,255,255));
		answer[1].setBackground(new Color(255,255,255,255));
		answer[2].setBackground(new Color(255,255,255,255));
		int sel = JOptionPane.showOptionDialog(this, null, "�����𿡰� �� ����"
			,JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE, null, answer, null );
		switch(sel) {
			case 0: btn3.setIcon(option1); break;
			case 1: btn3.setIcon(option2); break;
			case 2: btn3.setIcon(option3); break;
		}
	}
	public void paint(Graphics g) {//�׸��� �Լ�
		g.drawImage(background, 0, 0, null);//background�� �׷���
		g.drawImage(marimo, 250, 500, null);
		g.drawImage(sh, 0, 0, null);
		//img_buffer = createImage(getWidth(),getHeight()-200);
		//buffer = img_buffer.getGraphics();
		g.drawImage(b, s_x, s_y,null);
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
		new Shower_marimo();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btn4) {
			Shower_marimo a = new Shower_marimo();
	         setVisible(false);
	    }
		else if(e.getSource()==btn3) {                                                         
			JOptionPaneEx();
		}
	}
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		//point = MouseInfo.getPointerInfo().getLocation();
		s_x=e.getX()-100;
		s_y=e.getY()-100;
		repaint();
		//ball_panel.setBounds(s_x, s_y, 170, 170);
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