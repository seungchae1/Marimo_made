package newMarimo;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class newNight extends JFrame {

	private MarimoInformation marimo_info;
	private SunMoon sunMoon;
	private JLabel background;
	private myMarimo marimo; 
	private btnList btnlist;
	
	public newNight() {
		initObject();
		initSetting();
		setVisible(true); // ������ ���̰� �ϱ�
	}
	private void initObject() {
		background = new JLabel(new ImageIcon(newDay.class.getResource("../img/night.png")));
		setContentPane(background);
		sunMoon = new SunMoon(new ImageIcon(newDay.class.getResource("../img/moon.png")), this);
		marimo = new myMarimo();
		btnlist = new btnList(this);
		marimo_info = new MarimoInformation();
		marimo_info.setSize(100, 300);
		marimo_info.setLocation(600, 10);
		add(marimo_info);
		
		add(sunMoon);
		add(marimo);
		add(btnlist);
	}
	private void initSetting() {
		//setUndecorated(true); //Ÿ��Ʋ�� ���ֱ�
		setTitle("������ Ű���");
		setResizable(false);// â�� ũ�⸦ �������� ���ϰ�
		setSize(725, 1024);
		setLayout(null);
		setName("newNight");
		setLocationRelativeTo(null);// â�� ��� ������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new newNight();
	}
}