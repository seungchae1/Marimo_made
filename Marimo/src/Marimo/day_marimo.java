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
		//homeframe();
		test();
	}
	public void homeframe() {
		setTitle("������ Ű���");//Ÿ��Ʋ
		setSize(725,1024);
		setResizable(false);//â�� ũ�⸦ �������� ���ϰ�
		setLocationRelativeTo(null);//â�� ��� ������
		setLayout(null);//���̾ƿ��� ������� ���������ϰ� ����.
		setVisible(true);//â�� ���̰�	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//JFrame�� ���������� ����ǰ�
		
		main_panel = new JPanel(); // �г� ��üȭ / �⺻��ġ������ FlowLayout
		
		JButton b1 = new JButton(btn_img);
		b1.setBounds(0, 0, 100, 100);//��ġ,ũ��
		main_panel.add(b1);
		add(main_panel);
	}
	void test() {
		setSize(725,1024);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLocationRelativeTo(null);//â�� ��� ������
		main_panel = new JPanel(); // �г� ��üȭ / �⺻��ġ������ FlowLayout
		main_panel.setBackground(Color.WHITE); // �г� ���� �Ͼ������ ����
		
		bt_img = new JButton(btn_img);
		bt_img.setBorderPainted(false); // ��ư �׵θ� ��������
		bt_img.setPreferredSize(new Dimension(170, 170)); // ��ư ũ�� ����
		bt_img.setBackground(new Color(120,191,161,255));
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