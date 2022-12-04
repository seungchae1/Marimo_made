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
		setVisible(true); // 프레임 보이게 하기
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
		//setUndecorated(true); //타이틀바 없애기
		setTitle("마리모 키우기");
		setResizable(false);// 창의 크기를 변경하지 못하게
		setSize(725, 1024);
		setLayout(null);
		setName("newMedicine");
		setLocationRelativeTo(null);// 창이 가운데 나오게
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new newMedicine();
	}
}