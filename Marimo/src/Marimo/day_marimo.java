package Marimo;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class day_marimo extends JFrame/*�����ִ� �̹����� �����ӿ� �׷��ٰ���.*/{
	private Image background=new ImageIcon(day_marimo.class.getResource("../img/day.png")).getImage();//����̹���
	private Image marimo = new ImageIcon(day_marimo.class.getResource("../img/marimo.png")).getImage();
	public day_marimo() {
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
		g.drawImage(marimo, 250, 580, null);
	}
	public static void main(String args[]) {
		new day_marimo();
	}
}