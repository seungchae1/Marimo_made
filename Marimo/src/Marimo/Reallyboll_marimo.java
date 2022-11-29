package Marimo;

import java.awt.*;
import java.awt.event.*;
import java.util.Random;

import javax.swing.*;

public class Reallyboll_marimo extends JFrame/* �����ִ� �̹����� �����ӿ� �׷��ٰ���. */ implements ActionListener, MouseListener {
	private Image background = new ImageIcon(Reallyboll_marimo.class.getResource("../img/boll_marimo.png")).getImage();// ����̹���
	private Image marimo = new ImageIcon(Reallyboll_marimo.class.getResource("../img/marimo.png")).getImage();
	private Image b = new ImageIcon(Reallyboll_marimo.class.getResource("../img/icon_reallyboll.png")).getImage();
	private ImageIcon btn_img = new ImageIcon(Reallyboll_marimo.class.getResource("../img/icon_reallyboll.png"));
	private ImageIcon btn_img2 = new ImageIcon(Reallyboll_marimo.class.getResource("../img/icon_medicine.png"));
	private ImageIcon btn_img3 = new ImageIcon(Reallyboll_marimo.class.getResource("../img/icon_refresh.png"));
	private ImageIcon btn_img4 = new ImageIcon(Reallyboll_marimo.class.getResource("../img/icon_shower.png"));
	private ImageIcon btn_sun = new ImageIcon(Reallyboll_marimo.class.getResource("../img/sun.png"));

	int s_x = 270, s_y = 630; // �� ��ġ

	JPanel main_panel, sun_panel, user_panel;
	JLabel money_text, health, happy, hungry;
	JButton btn, btn2, btn3, btn4, sun;

	public Reallyboll_marimo() {
		setTitle("������ Ű���");// Ÿ��Ʋ
		setResizable(false);// â�� ũ�⸦ �������� ���ϰ�
		setSize(725, 1024);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);// â�� ��� ������
		setVisible(true); // ������ ���̰� �ϱ�

		int s_x = 270, s_y = 630; // �� ��ġ

		MyPanel my_panel = new MyPanel();
		main_panel = new JPanel(); // �г� ��üȭ / �⺻��ġ������ FlowLayout
		sun_panel = new JPanel();
		money_text = new JLabel("money : " + Integer.toString(My_marimo.get_money()), JLabel.CENTER);
		money_text.setPreferredSize(new Dimension(150, 0));
		health = new JLabel("health : " + Integer.toString(My_marimo.get_health()), JLabel.CENTER);
		health.setPreferredSize(new Dimension(150, 0));
		happy = new JLabel("happy : " + Integer.toString(My_marimo.get_happy()), JLabel.CENTER);
		happy.setPreferredSize(new Dimension(150, 0));
		hungry = new JLabel("hungry : " + Integer.toString(My_marimo.get_hungry()), JLabel.CENTER);
		hungry.setPreferredSize(new Dimension(150, 0));
		user_panel = new JPanel();

		setLayout(null);
		main_panel.setBounds(0, 780, 700, 200);
		sun_panel.setBounds(0, 0, 170, 200);
		my_panel.setBounds(0, 0, 725, 980);
		user_panel.setBounds(0, 0, 150, 170);

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

		btn.setBackground(new Color(255, 255, 213, 255)); // �౸��
		btn2.setBackground(new Color(255, 255, 213, 255)); // ��
		btn3.setBackground(new Color(255, 255, 213, 255)); // �����
		btn4.setBackground(new Color(255, 255, 213, 255)); // ����
		sun.setBackground(new Color(255, 255, 213, 255));
		user_panel.setBackground(new Color(255, 255, 213, 255));

		sun.addActionListener(this);
		btn4.addActionListener(this);
		btn3.addActionListener(this);
		btn.addActionListener(this);
		btn2.addActionListener(this);
		addMouseListener(this);
		sun.addActionListener(this);

		main_panel.add(btn3); // �гο� ��ư�� �ٿ��ش�
		main_panel.add(btn4); // �гο� ��ư�� �ٿ��ش�
		main_panel.add(btn); // �гο� ��ư�� �ٿ��ش�
		main_panel.add(btn2); // �гο� ��ư�� �ٿ��ش�

		main_panel.setBackground(new Color(255, 255, 213, 255));
		sun_panel.setBackground(new Color(255, 255, 213, 255));

		user_panel.setLayout(new GridLayout(4, 1));
		user_panel.add(money_text);
		user_panel.add(health);
		user_panel.add(happy);
		user_panel.add(hungry);

		sun_panel.setLayout(new BorderLayout(0, 0));
		sun_panel.add(sun, BorderLayout.WEST);
		sun_panel.add(user_panel, BorderLayout.EAST);

		my_panel.setLayout(new BorderLayout());
		my_panel.add(sun_panel, BorderLayout.NORTH);
		my_panel.add(main_panel, BorderLayout.SOUTH);

		add(my_panel);
	}

	class MyPanel extends JPanel {
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
			g.drawImage(marimo, 260, 380, 190, 190, this);
		}
	}

	private Image img_buffer;
	private Graphics buffer;

	public void paint(Graphics g) {// �׸��� �Լ�
		img_buffer = createImage(725, 1024);
		buffer = img_buffer.getGraphics();
		paintComponents(buffer);

		buffer.drawImage(b, s_x, s_y, null);

		g.drawImage(img_buffer, 0, 0, null);
		repaint();
	}

	@Override
	public void paintComponents(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponents(g);
	}

	public static void main(String args[]) {
		new Reallyboll_marimo();
	}

	boolean clickBall = false;

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn4) { // ����
			Shower_marimo a = new Shower_marimo();
			setVisible(false);
		} else if (e.getSource() == btn3) { // �����
			eat_marimo a = new eat_marimo();
			setVisible(false);
		} else if (e.getSource() == sun) { // ��ħ
			day_marimo a = new day_marimo();
			setVisible(false);
		} else if (e.getSource() == btn) {
			s_x = 270;
			s_y = 630;
		} else if (e.getSource() == btn2) {
			Medicine_marimo a = new Medicine_marimo();
			setVisible(false);
		}
	}

	Random rd = new Random();
	int r, r2;
	boolean a = true, a2 = false, a3 = false, a4 = false;

	@Override
	public void mouseClicked(MouseEvent e) {
		clickBall = true;
		// TODO Auto-generated method stub
		r = (rd.nextInt(1024 - 200) + 1);
		r2 = (rd.nextInt(750 - 200) + 1);
		/*
		 * if(s_x<=100) { r2=-r2; } if(s_y<100) { r=-r; }
		 */
		Moveball();
	}

	int click_cnt = 0;

	void Moveball() {
		click_cnt++;
		s_x = r2;
		s_y = r;
		if (click_cnt % 20 == 0) {
			My_marimo.set_happy(30);
			My_marimo.set_hungry(40);

			money_text.setText("money : " + Integer.toString(My_marimo.get_money()));
			health.setText("health : " + Integer.toString(My_marimo.get_health()));
			hungry.setText("hungry : " + Integer.toString(My_marimo.get_hungry()));
			happy.setText("happy : " + Integer.toString(My_marimo.get_happy()));
		}
		s_x = r2;
		s_y = r;
		/*
		 * while(!(s_x+r2> 750 || s_x+r2< 0 ||s_y+r2> 1024|| s_y+r2< 0)||clickBall) {
		 * s_x += r2; s_y += r; if(s_x+r2> 750 || s_x+r2< 0 ||s_y+r2> 1024|| s_y+r2<
		 * 0)clickBall=false; }
		 */
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