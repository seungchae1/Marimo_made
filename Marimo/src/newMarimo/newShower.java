package newMarimo;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class newShower  extends JFrame{

	private MarimoInformation marimo_info;
	private SunMoon sunMoon;
	private JLabel background;
	private myMarimo marimo; 
	private btnList btnlist;
	private Showerball showerball;
	
	public newShower() {
		initObject();
		initSetting();
		setVisible(true); // 프레임 보이게 하기
	}
	private void initObject() {
		background = new JLabel(new ImageIcon(newShower.class.getResource("../img/sh.png")));
		setContentPane(background);
		marimo = new myMarimo(260, 420, new ImageIcon(newShower.class.getResource("../img/shower_marimo.png")));
		btnlist = new btnList(this);
		showerball = new Showerball();
		sunMoon = new SunMoon(new ImageIcon(newMedicine.class.getResource("../img/sun.png")), this);
		marimo_info = new MarimoInformation();
		marimo_info.setSize(100, 300);
		marimo_info.setLocation(600, 10);
		add(marimo_info);
		add(showerball);
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
		setLocationRelativeTo(null);// 창이 가운데 나오게
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		new newShower();
	}
}