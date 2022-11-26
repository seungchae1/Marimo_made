package Marimo;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class night_marimo extends JFrame/* 여기있는 이미지를 프레임에 그려줄거임. */ implements ActionListener{
	private Image background = new ImageIcon(night_marimo.class.getResource("../img/night.png")).getImage();// 배경이미지
	private Image marimo = new ImageIcon(night_marimo.class.getResource("../img/sleep_marimo.png")).getImage();
	private ImageIcon btn_img = new ImageIcon(night_marimo.class.getResource("../img/icon_reallyboll.png"));
	private ImageIcon btn_img2 = new ImageIcon(night_marimo.class.getResource("../img/icon_medicine.png"));
	private ImageIcon btn_img3 = new ImageIcon(night_marimo.class.getResource("../img/icon_refresh.png"));
	private ImageIcon btn_img4 = new ImageIcon(night_marimo.class.getResource("../img/icon_shower.png"));
	private ImageIcon btn_moon = new ImageIcon(night_marimo.class.getResource("../img/moon.png"));

	JPanel main_panel; // 버튼을 붙여질 메인 패널 선언
	JPanel moon_panel;
	JButton btn, btn2, btn3, btn4, moon;

	public night_marimo() {
		setTitle("마리모 키우기");// 타이틀
		setResizable(false);// 창의 크기를 변경하지 못하게
		setSize(725, 1024);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);// 창이 가운데 나오게
		main_panel = new JPanel(); // 패널 객체화 / 기본배치관리자 FlowLayout
		moon_panel = new JPanel();

		setLayout(null);
		main_panel.setBounds(0, 780, 700, 200);
		moon_panel.setBounds(0, 0, 170, 200);

		JButton new_btn = new JButton("버튼");
		// 버튼 생성
		btn = new JButton(btn_img);
		btn2 = new JButton(btn_img2);
		btn3 = new JButton(btn_img3);
		btn4 = new JButton(btn_img4);
		moon = new JButton(btn_moon);

		btn.setBorderPainted(false); // 버튼 테두리 설정해제
		btn2.setBorderPainted(false); // 버튼 테두리 설정해제
		btn3.setBorderPainted(false); // 버튼 테두리 설정해제
		btn4.setBorderPainted(false); // 버튼 테두리 설정해제
		moon.setBorderPainted(false);

		btn.setPreferredSize(new Dimension(160, 180)); // 버튼 크기 지정
		btn2.setPreferredSize(new Dimension(170, 180)); // 버튼 크기 지정
		btn3.setPreferredSize(new Dimension(150, 180)); // 버튼 크기 지정
		btn4.setPreferredSize(new Dimension(185, 180)); // 버튼 크기 지정
		moon.setPreferredSize(new Dimension(170, 170));

		btn.setBackground(new Color(136, 199, 162, 255)); // 축구공
		btn2.setBackground(new Color(136, 199, 162, 255)); // 약
		btn3.setBackground(new Color(136, 199, 162, 255)); // 냉장고
		btn4.setBackground(new Color(136, 199, 162, 255)); // 샤워
		moon.setBackground(new Color(97,97,97)); // 달

		btn4.addActionListener(this);
		moon.addActionListener(this);

		main_panel.add(btn3); // 패널에 버튼을 붙여준다
		main_panel.add(btn4); // 패널에 버튼을 붙여준다
		main_panel.add(btn); // 패널에 버튼을 붙여준다
		main_panel.add(btn2); // 패널에 버튼을 붙여준다
		moon_panel.add(moon);

		add(main_panel); // 메인 프레임에 메인패널을 붙여주는 작업
		add(moon_panel); // 메인 프레임에 썬패널 붙여주는 작업
		setVisible(true); // 프레임 보이게 하기
	}


	public void paint(Graphics g) {// 그리는 함수
		g.drawImage(background, 0, 0, null);// background를 그려줌
		g.drawImage(marimo, 250, 580, null);
	}

	public static void main(String args[]) {
		new night_marimo();
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn4) {
			Shower_marimo a = new Shower_marimo();
		}
		if (e.getSource() == moon) {
			day_marimo b = new day_marimo();
		}
	}
}