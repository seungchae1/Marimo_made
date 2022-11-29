package Marimo;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Marimo.day_marimo.MyPanel;

public class night_marimo extends JFrame/* �����ִ� �̹����� �����ӿ� �׷��ٰ���. */ implements ActionListener {
	private Image background = new ImageIcon(night_marimo.class.getResource("../img/night.png")).getImage();// ����̹���
	private Image marimo = new ImageIcon(night_marimo.class.getResource("../img/sleep_marimo.png")).getImage();
	private ImageIcon btn_img = new ImageIcon(night_marimo.class.getResource("../img/icon_reallyboll.png"));
	private ImageIcon btn_img2 = new ImageIcon(night_marimo.class.getResource("../img/icon_medicine.png"));
	private ImageIcon btn_img3 = new ImageIcon(night_marimo.class.getResource("../img/icon_refresh.png"));
	private ImageIcon btn_img4 = new ImageIcon(night_marimo.class.getResource("../img/icon_shower.png"));
	private ImageIcon btn_moon = new ImageIcon(night_marimo.class.getResource("../img/moon.png"));

	MyPanel my_panel = new MyPanel();
	JPanel main_panel, moon_panel;
	JLabel money_text;
	JButton btn, btn2, btn3, btn4, moon;

	public night_marimo() {
		setTitle("������ Ű���");// Ÿ��Ʋ
		setResizable(false);// â�� ũ�⸦ �������� ���ϰ�
		setSize(725, 1024);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);// â�� ��� ������
		main_panel = new JPanel(); // �г� ��üȭ / �⺻��ġ������ FlowLayout
		moon_panel = new JPanel();
		money_text = new JLabel("money : " + Integer.toString(My_marimo.get_money()), JLabel.CENTER);
		money_text.setPreferredSize(new Dimension(150, 0));

		my_panel.setBounds(0, 0, 725, 980);
		setLayout(null);
		main_panel.setBounds(0, 780, 700, 200);
		moon_panel.setBounds(0, 0, 170, 200);

		JButton new_btn = new JButton("��ư");
		// ��ư ����
		btn = new JButton(btn_img);
		btn2 = new JButton(btn_img2);
		btn3 = new JButton(btn_img3);
		btn4 = new JButton(btn_img4);
		moon = new JButton(btn_moon);

		btn.setBorderPainted(false); // ��ư �׵θ� ��������
		btn2.setBorderPainted(false); // ��ư �׵θ� ��������
		btn3.setBorderPainted(false); // ��ư �׵θ� ��������
		btn4.setBorderPainted(false); // ��ư �׵θ� ��������
		moon.setBorderPainted(false);

		btn.setPreferredSize(new Dimension(160, 180)); // ��ư ũ�� ����
		btn2.setPreferredSize(new Dimension(170, 180)); // ��ư ũ�� ����
		btn3.setPreferredSize(new Dimension(150, 180)); // ��ư ũ�� ����
		btn4.setPreferredSize(new Dimension(185, 180)); // ��ư ũ�� ����
		moon.setPreferredSize(new Dimension(170, 170));

		btn.setBackground(new Color(136, 199, 162, 255)); // �౸��
		btn2.setBackground(new Color(136, 199, 162, 255)); // ��
		btn3.setBackground(new Color(136, 199, 162, 255)); // �����
		btn4.setBackground(new Color(136, 199, 162, 255)); // ����
		moon.setBackground(new Color(97, 97, 97)); // ��

		btn4.addActionListener(this);
		moon.addActionListener(this);

		main_panel.add(btn3); // �гο� ��ư�� �ٿ��ش�
		main_panel.add(btn4); // �гο� ��ư�� �ٿ��ش�
		main_panel.add(btn); // �гο� ��ư�� �ٿ��ش�
		main_panel.add(btn2); // �гο� ��ư�� �ٿ��ش�

		main_panel.setBackground(new Color(136, 199, 162, 255));
		moon_panel.setBackground(new Color(97, 97, 97));
		moon_panel.setLayout(new BorderLayout());
		moon_panel.add(moon, BorderLayout.WEST);
		moon_panel.add(money_text, BorderLayout.EAST);

		my_panel.setLayout(new BorderLayout());
		my_panel.add(moon_panel, BorderLayout.NORTH);
		my_panel.add(main_panel, BorderLayout.SOUTH);

		add(my_panel); // ���� �����ӿ� �����г��� �ٿ��ִ� �۾�
		setVisible(true); // ������ ���̰� �ϱ�
	}

	class MyPanel extends JPanel {
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
			g.drawImage(marimo, 260, 560, 190, 190, this);
		}
	}

	private Image img_buffer;
	private Graphics buffer;

	public void paint(Graphics g) {// �׸��� �Լ�
		img_buffer = createImage(725, 1024);
		buffer = img_buffer.getGraphics();
		paintComponents(buffer);

		buffer.drawImage(null, 0, 0, null);

		g.drawImage(img_buffer, 0, 0, null);
		repaint();
	}

	public static void main(String args[]) {
		new night_marimo();
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == moon) {
			day_marimo c = new day_marimo();
			setVisible(false);
		}
	}
}