package Marimo;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Marimo.eat_marimo.MyPanel;

public class day_marimo extends JFrame/* �����ִ� �̹����� �����ӿ� �׷��ٰ���. */ implements ActionListener {
	private Image background = new ImageIcon(day_marimo.class.getResource("../img/day.png")).getImage();// ����̹���
	private Image marimo = new ImageIcon(day_marimo.class.getResource("../img/marimo.png")).getImage();
	private ImageIcon btn_img = new ImageIcon(day_marimo.class.getResource("../img/icon_reallyboll.png"));
	private ImageIcon btn_img2 = new ImageIcon(day_marimo.class.getResource("../img/icon_medicine.png"));
	private ImageIcon btn_img3 = new ImageIcon(day_marimo.class.getResource("../img/icon_refresh.png"));
	private ImageIcon btn_img4 = new ImageIcon(day_marimo.class.getResource("../img/icon_shower.png"));
	private ImageIcon btn_sun = new ImageIcon(day_marimo.class.getResource("../img/sun.png"));
	
	MyPanel my_panel = new MyPanel();
	JPanel main_panel, sun_panel;
	JLabel money_text;
	JButton btn, btn2, btn3, btn4, sun;

	public day_marimo() {
		setTitle("������ Ű���");// Ÿ��Ʋ
		setResizable(false);// â�� ũ�⸦ �������� ���ϰ�
		setSize(725, 1024);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);// â�� ��� ������
		main_panel = new JPanel(); // �г� ��üȭ / �⺻��ġ������ FlowLayout
		sun_panel = new JPanel();
		money_text = new JLabel("money : "+Integer.toString(My_marimo.get_money()), JLabel.CENTER);
	    money_text.setPreferredSize(new Dimension(150,0));
	    
	    my_panel.setBounds(0, 0, 725, 980);

		setLayout(null);
		main_panel.setBounds(0, 780, 700, 200);
		sun_panel.setBounds(0, 0, 170, 200);

		JButton new_btn = new JButton("��ư");
		// ��ư ����
		btn = new JButton(btn_img);
		btn2 = new JButton(btn_img2);
		btn3 = new JButton(btn_img3);
		btn4 = new JButton(btn_img4);
		sun = new JButton(btn_sun);

		btn.setBorderPainted(false); // ��ư �׵θ� ��������
		btn2.setBorderPainted(false); // ��ư �׵θ� ��������
		btn3.setBorderPainted(false); // ��ư �׵θ� ��������
		btn4.setBorderPainted(false); // ��ư �׵θ� ��������
		sun.setBorderPainted(false);

		btn.setPreferredSize(new Dimension(160, 180)); // ��ư ũ�� ����
		btn2.setPreferredSize(new Dimension(170, 180)); // ��ư ũ�� ����
		btn3.setPreferredSize(new Dimension(150, 180)); // ��ư ũ�� ����
		btn4.setPreferredSize(new Dimension(185, 180)); // ��ư ũ�� ����
		sun.setPreferredSize(new Dimension(170, 170));

		btn.setBackground(new Color(136, 199, 162, 255)); // �౸��
		btn2.setBackground(new Color(136, 199, 162, 255)); // ��
		btn3.setBackground(new Color(136, 199, 162, 255)); // �����
		btn4.setBackground(new Color(136, 199, 162, 255)); // ����
		sun.setBackground(new Color(0, 206, 255));

		btn.addActionListener(this);
		btn4.addActionListener(this);
		sun.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);

		main_panel.add(btn3); // �гο� ��ư�� �ٿ��ش�
		main_panel.add(btn4); // �гο� ��ư�� �ٿ��ش�
		main_panel.add(btn); // �гο� ��ư�� �ٿ��ش�
		main_panel.add(btn2); // �гο� ��ư�� �ٿ��ش�
		sun_panel.add(sun);

	      main_panel.setBackground(new Color(136, 199, 162, 255));
	      sun_panel.setBackground(new Color(0, 206, 255));
	      sun_panel.setLayout(new BorderLayout());
	      sun_panel.add(sun, BorderLayout.WEST);
	      sun_panel.add(money_text, BorderLayout.EAST);
	      
	      my_panel.setLayout(new BorderLayout());
	      my_panel.add(sun_panel, BorderLayout.NORTH);
	      my_panel.add(main_panel, BorderLayout.SOUTH);

	      add(my_panel); // ���� �����ӿ� �����г��� �ٿ��ִ� �۾�
		setVisible(true); // ������ ���̰� �ϱ�
	}
	   class MyPanel extends JPanel{
           @Override
           public void paintComponent(Graphics g){
               super.paintComponent(g);
               g.drawImage(background,0,0,getWidth(),getHeight(),this);
               g.drawImage(marimo,260,560,190,190,this);
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

	public static void main(String args[]) {
		new day_marimo();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn4) {
			Shower_marimo shower = new Shower_marimo();
			setVisible(false);
		} else if (e.getSource() == sun) {
			night_marimo c = new night_marimo();
			setVisible(false);
		} else if (e.getSource() == btn) {
			Reallyboll_marimo a = new Reallyboll_marimo();
			setVisible(false);
		} else if (e.getSource() == btn2) {
			Medicine_marimo b = new Medicine_marimo();
			setVisible(false);
		}else if (e.getSource() == btn3) {
			eat_marimo c = new eat_marimo();
			setVisible(false);
		}
	}
}