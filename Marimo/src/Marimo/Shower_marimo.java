package Marimo;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Shower_marimo extends JFrame/*�����ִ� �̹����� �����ӿ� �׷��ٰ���.*/{
	private Image background=new ImageIcon(day_marimo.class.getResource("../img/sh.png")).getImage();//����̹���
	private Image marimo = new ImageIcon(day_marimo.class.getResource("../img/shower_marimo.png")).getImage();
	private Image sh = new ImageIcon(day_marimo.class.getResource("../img/sh_2.png")).getImage();
	private Image b = new ImageIcon(day_marimo.class.getResource("../img/boll.png")).getImage();
	public Shower_marimo() {
		homeframe();
	}
	public void homeframe() {
		setTitle("������ Ű���");//Ÿ��Ʋ
		setSize(725,1024);
		setResizable(false);//â�� ũ�⸦ �������� ���ϰ�
		setLocationRelativeTo(null);//â�� ��� ������
		setLayout(null);//���̾ƿ��� ������� ���������ϰ� ����.
		setVisible(true);//â�� ���̰�	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//JFrame�� ���������� ����ǰ�
	}
	public void paint(Graphics g) {//�׸��� �Լ�
		g.drawImage(background, 0, 0, null);//background�� �׷���
		g.drawImage(marimo, 250, 500, null);
		g.drawImage(sh, 0, 0, null);
		g.drawImage(b, 500, 200, null);
	}
	public static void main(String args[]) {
		new Shower_marimo();
	}
}