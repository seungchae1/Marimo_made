package Marimo;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class day_marimo extends JFrame/*여기있는 이미지를 프레임에 그려줄거임.*/{
	private Image background=new ImageIcon(day_marimo.class.getResource("../img/day.png")).getImage();//배경이미지
	private Image marimo = new ImageIcon(day_marimo.class.getResource("../img/marimo.png")).getImage();
	private ImageIcon btn_img = new ImageIcon(day_marimo.class.getResource("../img/icon_reallyboll.png"));
	
	JPanel main_panel; // 버튼을 붙여질 메인 패널 선언

	JButton bt_img;
	public day_marimo() {
		homeframe();
	}
	void homeframe() {
		setTitle("마리모 키우기");//타이틀
		setResizable(false);//창의 크기를 변경하지 못하게
		setSize(725,1024);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setLocationRelativeTo(null);//창이 가운데 나오게
		main_panel = new JPanel(); // 패널 객체화 / 기본배치관리자 FlowLayout
		setLayout(null);
		main_panel.setBounds(0, 820, 700, 200);
		bt_img = new JButton(btn_img);
		bt_img.setBorderPainted(false); // 버튼 테두리 설정해제
		bt_img.setPreferredSize(new Dimension(170, 170)); // 버튼 크기 지정
		bt_img.setBackground(new Color(136,199,162,255));
		main_panel.add(bt_img); // 패널에 버튼을 붙여준다
		add(main_panel); // 메인 프레임에 메인패널을 붙여주는 작업
		
		setVisible(true); // 프레임 보이게 하기
	}
	public void paint(Graphics g) {//그리는 함수
		g.drawImage(background, 0, 0, null);//background를 그려줌
		g.drawImage(marimo, 250, 580, null);
	}
	public static void main(String args[]) {
		new day_marimo();
	}
}