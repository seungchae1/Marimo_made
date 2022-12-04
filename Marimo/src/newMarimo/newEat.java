package newMarimo;

import java.awt.Color;

import javax.swing.*;

public class newEat extends JFrame {

	private MarimoInformation marimo_info;
	private SunMoon sunMoon;
	private JLabel background;
	private myMarimo marimo; 
	private btnList btnlist;
	
	public newEat() {
		initObject();
		initSetting();
		setVisible(true); // ������ ���̰� �ϱ�
	}
	private void initObject() {
		background = new JLabel(new ImageIcon(newEat.class.getResource("../img/eat_back.png")));
		setContentPane(background);

		marimo_info = new MarimoInformation();
		marimo_info.setSize(100, 300);
		marimo_info.setLocation(600, 10);
		add(marimo_info);
		sunMoon = new SunMoon(new ImageIcon(newMedicine.class.getResource("../img/sun.png")), this);
		marimo = new myMarimo(260, 380);
		btnlist = new btnList(this);
		add(sunMoon);
		add(marimo);
		add(btnlist);
	}
	private void initSetting() {
		//setUndecorated(true); //Ÿ��Ʋ�� ���ֱ�
		setTitle("������ Ű���");
		setName("newEat");
		setResizable(false);// â�� ũ�⸦ �������� ���ϰ�
		setSize(725, 1024);
		setLayout(null);
		setLocationRelativeTo(null);// â�� ��� ������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new newEat();
	}
}