package Marimo;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import Marimo.eat_marimo.MyPanel;

public class day_marimo extends JFrame/* 여기있는 이미지를 프레임에 그려줄거임. */ implements ActionListener {
	private Image background = new ImageIcon(day_marimo.class.getResource("../img/day.png")).getImage();// 배경이미지
	private Image marimo = new ImageIcon(day_marimo.class.getResource("../img/marimo.png")).getImage();
	private ImageIcon btn_img = new ImageIcon(day_marimo.class.getResource("../img/icon_reallyboll.png"));
	private ImageIcon btn_img2 = new ImageIcon(day_marimo.class.getResource("../img/icon_medicine.png"));
	private ImageIcon btn_img3 = new ImageIcon(day_marimo.class.getResource("../img/icon_refresh.png"));
	private ImageIcon btn_img4 = new ImageIcon(day_marimo.class.getResource("../img/icon_shower.png"));
	private ImageIcon btn_sun = new ImageIcon(day_marimo.class.getResource("../img/sun.png"));

	MyPanel my_panel = new MyPanel();
	JPanel main_panel, sun_panel;
	JLabel money_text;
	JButton btn, btn2, btn3, btn4, sun;

	public day_marimo() {
		setTitle("마리모 키우기");// 타이틀
		setResizable(false);// 창의 크기를 변경하지 못하게
		setSize(725, 1024);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);// 창이 가운데 나오게
		main_panel = new JPanel(); // 패널 객체화 / 기본배치관리자 FlowLayout
		sun_panel = new JPanel();
		money_text = new JLabel("money : " + Integer.toString(My_marimo.get_money()), JLabel.CENTER);
		money_text.setPreferredSize(new Dimension(150, 0));

		my_panel.setBounds(0, 0, 725, 980);

		setLayout(null);
		main_panel.setBounds(0, 780, 700, 200);
		sun_panel.setBounds(0, 0, 170, 200);

		JButton new_btn = new JButton("버튼");
		// 버튼 생성
		btn = new JButton(btn_img);
		btn2 = new JButton(btn_img2);
		btn3 = new JButton(btn_img3);
		btn4 = new JButton(btn_img4);
		sun = new JButton(btn_sun);

		btn.setBorderPainted(false); // 버튼 테두리 설정해제
		btn2.setBorderPainted(false); // 버튼 테두리 설정해제
		btn3.setBorderPainted(false); // 버튼 테두리 설정해제
		btn4.setBorderPainted(false); // 버튼 테두리 설정해제
		sun.setBorderPainted(false);

		btn.setPreferredSize(new Dimension(160, 180)); // 버튼 크기 지정
		btn2.setPreferredSize(new Dimension(170, 180)); // 버튼 크기 지정
		btn3.setPreferredSize(new Dimension(150, 180)); // 버튼 크기 지정
		btn4.setPreferredSize(new Dimension(185, 180)); // 버튼 크기 지정
		sun.setPreferredSize(new Dimension(170, 170));

		btn.setBackground(new Color(136, 199, 162, 255)); // 축구공
		btn2.setBackground(new Color(136, 199, 162, 255)); // 약
		btn3.setBackground(new Color(136, 199, 162, 255)); // 냉장고
		btn4.setBackground(new Color(136, 199, 162, 255)); // 샤워
		sun.setBackground(new Color(0, 206, 255));

		btn.addActionListener(this);
		btn4.addActionListener(this);
		sun.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);

		main_panel.add(btn3); // 패널에 버튼을 붙여준다
		main_panel.add(btn4); // 패널에 버튼을 붙여준다
		main_panel.add(btn); // 패널에 버튼을 붙여준다
		main_panel.add(btn2); // 패널에 버튼을 붙여준다
		sun_panel.add(sun);

		main_panel.setBackground(new Color(136, 199, 162, 255));
		sun_panel.setBackground(new Color(0, 206, 255));
		sun_panel.setLayout(new BorderLayout());
		sun_panel.add(sun, BorderLayout.WEST);
		sun_panel.add(money_text, BorderLayout.EAST);

		my_panel.setLayout(new BorderLayout());
		my_panel.add(sun_panel, BorderLayout.NORTH);
		my_panel.add(main_panel, BorderLayout.SOUTH);

		add(my_panel); // 메인 프레임에 메인패널을 붙여주는 작업
		setVisible(true); // 프레임 보이게 하기
	}

	class MyPanel extends JPanel {
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(background, 0, 0, getWidth(), getHeight(), this);
			g.drawImage(marimo, 260, 560, 190, 190, this);
		}
	}

	private Image img_buffer;
	private Graphics buffer;

	public void paint(Graphics g) {// 그리는 함수
		img_buffer = createImage(725, 1024);
		buffer = img_buffer.getGraphics();
		paintComponents(buffer);

		buffer.drawImage(null, 0, 0, null);

		g.drawImage(img_buffer, 0, 0, null);
		repaint();
	}

	public static void main(String args[]) {
		new day_marimo();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btn4) {
			Shower_marimo shower = new Shower_marimo();
			setVisible(false);
		} else if (e.getSource() == sun) {
			night_marimo c = new night_marimo();
			setVisible(false);
		} else if (e.getSource() == btn) {
			Reallyboll_marimo a = new Reallyboll_marimo();
			setVisible(false);
		} else if (e.getSource() == btn2) {
			Medicine_marimo b = new Medicine_marimo();
			setVisible(false);
		} else if (e.getSource() == btn3) {
			eat_marimo c = new eat_marimo();
			setVisible(false);
		}
	}
}