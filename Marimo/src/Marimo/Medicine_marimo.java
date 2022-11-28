package Marimo;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Marimo.Shower_marimo.MyPanel;

public class Medicine_marimo extends JFrame/*�����ִ� �̹����� �����ӿ� �׷��ٰ���.*/ implements ActionListener, MouseListener{
	private ImageIcon marimo = new ImageIcon(day_marimo.class.getResource("../img/marimo.png"));
	private ImageIcon eat_marimo = new ImageIcon(day_marimo.class.getResource("../img/eat_marimo.png"));
	private ImageIcon btn_img = new ImageIcon(day_marimo.class.getResource("../img/icon_reallyboll.png"));
	private ImageIcon btn_img2 = new ImageIcon(day_marimo.class.getResource("../img/icon_medicine.png"));
	private ImageIcon btn_img3 = new ImageIcon(day_marimo.class.getResource("../img/icon_refresh.png"));
	private ImageIcon btn_img4 = new ImageIcon(day_marimo.class.getResource("../img/icon_shower.png"));
	private ImageIcon btn_sun = new ImageIcon(day_marimo.class.getResource("../img/sun.png"));
	private ImageIcon option1 = new ImageIcon(day_marimo.class.getResource("../img/medicine1.png"));
	private ImageIcon option2 = new ImageIcon(day_marimo.class.getResource("../img/medicine2.png"));
	private ImageIcon option3 = new ImageIcon(day_marimo.class.getResource("../img/medicine3.png"));
	
	int sel=-1;
	
	   JPanel main_panel, sun_panel, m_panel;
	   JLabel money_text, health;
	   JButton btn, btn2, btn3, btn4, sun, op1, op2, op3, eat_m;
	   public Medicine_marimo() {
	      setTitle("������ Ű���");//Ÿ��Ʋ
	      setResizable(false);//â�� ũ�⸦ �������� ���ϰ�
	      setSize(725,1024);
	      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      setLocationRelativeTo(null);//â�� ��� ������
	      setVisible(true); // ������ ���̰� �ϱ�
	      
	      MyPanel my_panel = new MyPanel();
	      main_panel = new JPanel(); // �г� ��üȭ / �⺻��ġ������ FlowLayout
	      sun_panel = new JPanel();
	      money_text = new JLabel("money : "+Integer.toString(My_marimo.get_money()), JLabel.CENTER);
	      money_text.setPreferredSize(new Dimension(150,0));
	      health= new JLabel("health : "+Integer.toString(My_marimo.get_health()), JLabel.CENTER);
	      health.setPreferredSize(new Dimension(150,0));
	      m_panel = new JPanel();
	      
	      setLayout(null);
	      main_panel.setBounds(0, 780, 700, 200);
	      sun_panel.setBounds(0,0,170,200);
	      m_panel.setBounds(0, 0, 170, 200);
	      my_panel.setBounds(0, 0, 725, 980);
	      
	      //��ư ����
	      btn = new JButton(btn_img);
	      btn2 = new JButton(btn_img2);
	      btn3 = new JButton(btn_img3);
	      btn4 = new JButton(btn_img4);
	      sun = new JButton(btn_sun);
	      eat_m= new JButton(marimo);
	      
	      btn.setBorderPainted(false); // ��ư �׵θ� ��������
	      btn2.setBorderPainted(false); // ��ư �׵θ� ��������
	      btn3.setBorderPainted(false); // ��ư �׵θ� ��������
	      btn4.setBorderPainted(false); // ��ư �׵θ� ��������
	      sun.setBorderPainted(false);
	      eat_m.setBorderPainted(false);
	      
	      btn.setPreferredSize(new Dimension(160, 180)); // ��ư ũ�� ����
	      btn2.setPreferredSize(new Dimension(170, 180)); // ��ư ũ�� ����
	      btn3.setPreferredSize(new Dimension(150, 180)); // ��ư ũ�� ����
	      btn4.setPreferredSize(new Dimension(185, 180)); // ��ư ũ�� ����
	      sun.setPreferredSize(new Dimension(170,170));
	      eat_m.setPreferredSize(new Dimension(170,190));
	      
	      eat_m.setFocusPainted(false);
	      
	      btn.setBackground(new Color(255,255,213,255)); //�౸��
	      btn2.setBackground(new Color(255,255,213,255)); //��
	      btn3.setBackground(new Color(255,255,213,255)); //�����
	      btn4.setBackground(new Color(255,255,213,255)); //����
	      sun.setBackground(new Color(255,255,213,255));
	      eat_m.setBackground(new Color(255,255,213,255));
	      
	      eat_m.addMouseListener(this);
	      eat_m.addActionListener(this);
	      btn4.addActionListener(this);
	      btn2.addActionListener(this);
	      btn3.addActionListener(this);
	      sun.addActionListener(this);
	      
	      main_panel.add(btn3); // �гο� ��ư�� �ٿ��ش�
	      main_panel.add(btn4); // �гο� ��ư�� �ٿ��ش�
	      main_panel.add(btn); // �гο� ��ư�� �ٿ��ش�
	      main_panel.add(btn2); // �гο� ��ư�� �ٿ��ش�
	      sun_panel.add(sun);
	      m_panel.add(eat_m);
	      
	      m_panel.setBorder(BorderFactory.createEmptyBorder(200 , 10 , 10 , 10)); //������ �ִ� panel�� padding
	      
	      main_panel.setBackground(new Color(255,255,213,255));
	      sun_panel.setBackground(new Color(255,255,213,255));
	      m_panel.setBackground(new Color(255,255,213,255));
	      sun_panel.setLayout(new BorderLayout(0,0));
	      sun_panel.add(sun, BorderLayout.WEST);
	      sun_panel.add(money_text, BorderLayout.EAST);
	      sun_panel.add(health, BorderLayout.EAST);
	      
	      my_panel.setLayout(new BorderLayout(0,0));
	      my_panel.add(sun_panel, BorderLayout.NORTH);
	      my_panel.add(main_panel, BorderLayout.SOUTH);
	      my_panel.add(m_panel, BorderLayout.CENTER);

	      add(my_panel); // ���� �����ӿ� �����г��� �ٿ��ִ� �۾�
	}
	   class MyPanel extends JPanel{
        @Override
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            //g.setColor(new Color(233,225,255,255));
        }
 }
	public ImageIcon[] answer={option1, option2, option3};
	public void JOptionPaneEx(){
		sel=-1;
		 sel= JOptionPane.showOptionDialog(this, null, "�����𿡰� �� ��"
			,JOptionPane.PLAIN_MESSAGE, JOptionPane.PLAIN_MESSAGE, null, answer, null );
		switch(sel) {
		case 0:
			btn2.setIcon(option1);
			break;
		case 1:
			btn2.setIcon(option2);
			break;
		case 2:
			btn2.setIcon(option3); 
			break;
		default : btn2.setIcon(btn_img2);
		}
	}

	private Image img_buffer;
	private Graphics buffer;
	public void paint(Graphics g) {//�׸��� �Լ�
		img_buffer = createImage(725,1024);
		buffer = img_buffer.getGraphics();
		paintComponents(buffer);
		
		buffer.drawImage(null,0,0,null);
		
		g.drawImage(img_buffer, 0,0,null);
		repaint();
	}

	@Override
	public void paintComponents(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponents(g);
	}
	@Override
	public void update(Graphics g) {
		// TODO Auto-generated method stub
		repaint();
	}
	public static void main(String args[]) {
		new Medicine_marimo();
	}

	   @Override
	   public void actionPerformed(ActionEvent e) {
	      if(e.getSource()==btn4) {
	         Shower_marimo shower = new Shower_marimo();
	         setVisible(false); 
	      }
	      else if(e.getSource() == sun) {
	    	  day_marimo c = new day_marimo();
	          setVisible(false); 
	      }
	      else if(e.getSource() == btn3) {
				eat_marimo a = new eat_marimo();
		         setVisible(false);
	      }
	      else if(e.getSource() == btn) {
	    	  Reallyboll_marimo a = new Reallyboll_marimo();
	          setVisible(false); 
	      }
	      else if(e.getSource() == btn2) {
	    	  JOptionPaneEx();
	      }
	      else if(e.getSource() == eat_m) {

	  		switch (sel) {
	  		case 0:
	  			My_marimo.set_health(+10);
	  			health.setText(My_marimo.get_health());
	  			break;
	  		case 1:
	  			My_marimo.set_health(+20);
	  			health.setText(My_marimo.get_health());
	  			break;
	  		case 2:
	  			My_marimo.set_health(+30);
	  			health.setText(My_marimo.get_health());
	  			break;
	  		default:
	  			break;
	  		}
  			money_text.setText("money : "+Integer.toString(My_marimo.get_money()));
	      }
	   }

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
	  if(sel!=-1) {
   		  eat_m.setIcon(eat_marimo);
   	  }
   	  else {
   		  eat_m.setIcon(marimo); 
   	  }
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
 		  eat_m.setIcon(marimo); 
		
	}
}