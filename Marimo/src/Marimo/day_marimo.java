package Marimo;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class day_marimo extends JFrame/*�����ִ� �̹����� �����ӿ� �׷��ٰ���.*/{
	private Image background=new ImageIcon(day_marimo.class.getResource("../img/day.png")).getImage();//����̹���
	private Image marimo = new ImageIcon(day_marimo.class.getResource("../img/marimo.png")).getImage();
	private ImageIcon btn_img = new ImageIcon(day_marimo.class.getResource("../img/icon_reallyboll.png"));
	
	JPanel main_panel; // ��ư�� �ٿ��� ���� �г� ����

	JButton bt_img;
	public day_marimo() {
		homeframe();
	}
	void homeframe() {
		setTitle("������ Ű���");//Ÿ��Ʋ
		setResizable(false);//â�� ũ�⸦ �������� ���ϰ�
		setSize(725,1024);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLocationRelativeTo(null);//â�� ��� ������
		main_panel = new JPanel(); // �г� ��üȭ / �⺻��ġ������ FlowLayout
		setLayout(null);
		main_panel.setBounds(0, 820, 700, 200);
		bt_img = new JButton(btn_img);
		bt_img.setBorderPainted(false); // ��ư �׵θ� ��������
		bt_img.setPreferredSize(new Dimension(170, 170)); // ��ư ũ�� ����
		bt_img.setBackground(new Color(136,199,162,255));
		main_panel.add(bt_img); // �гο� ��ư�� �ٿ��ش�
		add(main_panel); // ���� �����ӿ� �����г��� �ٿ��ִ� �۾�
		
		setVisible(true); // ������ ���̰� �ϱ�
	}
	public void paint(Graphics g) {//�׸��� �Լ�
		g.drawImage(background, 0, 0, null);//background�� �׷���
		g.drawImage(marimo, 250, 580, null);
	}
	public static void main(String args[]) {
		new day_marimo();
	}
}