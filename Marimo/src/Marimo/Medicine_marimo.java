package Marimo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Medicine_marimo extends JFrame/*�����ִ� �̹����� �����ӿ� �׷��ٰ���.*/ implements ActionListener{
	private Image background=new ImageIcon(Reallyboll_marimo.class.getResource("../img/boll_marimo.png")).getImage();//����̹���
	private Image marimo = new ImageIcon(Reallyboll_marimo.class.getResource("../img/marimo.png")).getImage();
	private ImageIcon btn_img = new ImageIcon(Reallyboll_marimo.class.getResource("../img/icon_reallyboll.png"));
	private ImageIcon btn_img2 = new ImageIcon(Reallyboll_marimo.class.getResource("../img/icon_medicine.png"));
	private ImageIcon btn_img3 = new ImageIcon(Reallyboll_marimo.class.getResource("../img/icon_refresh.png"));
	private ImageIcon btn_img4 = new ImageIcon(Reallyboll_marimo.class.getResource("../img/icon_shower.png"));

	
	JPanel main_panel; // ��ư�� �ٿ��� ���� �г� ����
	//JPanel sun_panel;
	JButton btn, btn2, btn3, btn4, sun;
	
	public Medicine_marimo() {
		homeframe();
	}
	
	public void homeframe() {
		setTitle("������ Ű���");// Ÿ��Ʋ
		setResizable(false);// â�� ũ�⸦ �������� ���ϰ�
		setSize(725, 1024);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);// â�� ��� ������
		main_panel = new JPanel(); // �г� ��üȭ / �⺻��ġ������ FlowLayout
		//sun_panel = new JPanel();

		setLayout(null);
		main_panel.setBounds(0, 780, 700, 200);
		//sun_panel.setBounds(0, 0, 170, 200);

		JButton new_btn = new JButton("��ư");
		// ��ư ����
		btn = new JButton(btn_img);
		btn2 = new JButton(btn_img2);
		btn3 = new JButton(btn_img3);
		btn4 = new JButton(btn_img4);

		btn.setBorderPainted(false); // ��ư �׵θ� ��������
		btn2.setBorderPainted(false); // ��ư �׵θ� ��������
		btn3.setBorderPainted(false); // ��ư �׵θ� ��������
		btn4.setBorderPainted(false); // ��ư �׵θ� ��������
		//sun.setBorderPainted(false);

		btn.setPreferredSize(new Dimension(160, 180)); // ��ư ũ�� ����
		btn2.setPreferredSize(new Dimension(170, 180)); // ��ư ũ�� ����
		btn3.setPreferredSize(new Dimension(150, 180)); // ��ư ũ�� ����
		btn4.setPreferredSize(new Dimension(185, 180)); // ��ư ũ�� ����
		//sun.setPreferredSize(new Dimension(170, 170));

		btn.setBackground(new Color(255, 255, 213)); // �౸��
		btn2.setBackground(new Color(255, 255, 213)); // ��
		btn3.setBackground(new Color(255, 255, 213)); // �����
		btn4.setBackground(new Color(255, 255, 213)); // ����
		//sun.setBackground(new Color(97,97,97)); // ��

		btn4.addActionListener(this);
		//sun.addActionListener(this);

		main_panel.add(btn3); // �гο� ��ư�� �ٿ��ش�
		main_panel.add(btn4); // �гο� ��ư�� �ٿ��ش�
		main_panel.add(btn); // �гο� ��ư�� �ٿ��ش�
		main_panel.add(btn2); // �гο� ��ư�� �ٿ��ش�
		//sun_panel.add(sun);

		add(main_panel); // ���� �����ӿ� �����г��� �ٿ��ִ� �۾�
		//add(sun_panel); // ���� �����ӿ� ���г� �ٿ��ִ� �۾�
		setVisible(true); // ������ ���̰� �ϱ�
	}
	public void paint(Graphics g) {//�׸��� �Լ�
		g.drawImage(background, 0, 0, null);//background�� �׷���
		g.drawImage(marimo, 250, 500, null);
	}
	
	
	public static void main(String[] args) {
		new Medicine_marimo();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
	}

}
