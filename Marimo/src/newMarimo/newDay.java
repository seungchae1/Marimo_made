package newMarimo;

import javax.swing.*; 

public class newDay extends JFrame {

	private SunMoon sunMoon;
	private JLabel background;
	private myMarimo marimo; 
	private btnList btnlist;
	private MarimoInformation marimo_info;
	
	public newDay() {
		initObject();
		initSetting();
		setVisible(true); // 프레임 보이게 하기
	}
	private void initObject() {
		background = new JLabel(new ImageIcon(newDay.class.getResource("../img/day.png")));
		setContentPane(background);
		sunMoon = new SunMoon(new ImageIcon(newDay.class.getResource("../img/sun.png")), this);
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
		//setUndecorated(true); //타이틀바 없애기
		setTitle("마리모 키우기");
		setResizable(false);// 창의 크기를 변경하지 못하게
		setSize(725, 1024);
		setLayout(null);
		setName("day");
		setLocationRelativeTo(null);// 창이 가운데 나오게
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new newDay();
	}
}