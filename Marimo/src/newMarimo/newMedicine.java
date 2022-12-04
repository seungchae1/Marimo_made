package newMarimo;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class newMedicine  extends JFrame {

	private MarimoInformation marimo_info;
	private SunMoon sunMoon;
	private JLabel background;
	private myMarimo marimo; 
	private btnList btnlist;
	
	public newMedicine() {
		initObject();
		initSetting();
		setVisible(true); // ������ ���̰� �ϱ�
	}
	private void initObject() {
		background = new JLabel(new ImageIcon(newMedicine.class.getResource("../img/Medicine_marimo.png")));
		sunMoon = new SunMoon(new ImageIcon(newMedicine.class.getResource("../img/sun.png")), this);
		marimo = new myMarimo(260, 380);
		btnlist = new btnList(this);
		setContentPane(background);

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
		setName("newMedicine");
		setLocationRelativeTo(null);// â�� ��� ������
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new newMedicine();
	}
}