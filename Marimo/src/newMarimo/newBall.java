package newMarimo;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class newBall  extends JFrame implements MouseListener{

	private MarimoInformation marimo_info;
	private SunMoon sunMoon;
	private JLabel background;
	private myMarimo marimo; 
	private btnList btnlist;
	private Ball ball;
	
	public newBall() {
		initObject();
		initSetting();
		setVisible(true); // ������ ���̰� �ϱ�
	}
	private void initObject() {
		background = new JLabel(new ImageIcon(Start_marimo.class.getResource("../img/boll_marimo.png")));
		setContentPane(background);

		marimo_info = new MarimoInformation();
		marimo_info.setSize(100, 300);
		marimo_info.setLocation(600, 10);
		add(marimo_info);
		marimo = new myMarimo(260, 380);
		btnlist = new btnList(this);
		sunMoon = new SunMoon(new ImageIcon(newMedicine.class.getResource("../img/sun.png")), this);
		ball = new Ball();
		add(marimo);
		add(sunMoon);
		add(ball);
		add(btnlist);
	}
	private void initSetting() {
		//setUndecorated(true); //Ÿ��Ʋ�� ���ֱ�
		setTitle("������ Ű���");
		setResizable(false);// â�� ũ�⸦ �������� ���ϰ�
		setSize(725, 1024);
		setLayout(null);
		setLocationRelativeTo(null);// â�� ��� ������
		addMouseListener(this);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		for(int i=0; i<10; i++) {
			ball.Move();
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	public static void main(String[] args) {
		new newBall();
	}
}