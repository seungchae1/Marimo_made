package Marimo;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Shower_marimo extends JFrame/*여기있는 이미지를 프레임에 그려줄거임.*/{
	private Image background=new ImageIcon(day_marimo.class.getResource("../img/sh.png")).getImage();//배경이미지
	private Image marimo = new ImageIcon(day_marimo.class.getResource("../img/shower_marimo.png")).getImage();
	private Image sh = new ImageIcon(day_marimo.class.getResource("../img/sh_2.png")).getImage();
	private Image b = new ImageIcon(day_marimo.class.getResource("../img/boll.png")).getImage();
	public Shower_marimo() {
		homeframe();
	}
	public void homeframe() {
		setTitle("마리모 키우기");//타이틀
		setSize(725,1024);
		setResizable(false);//창의 크기를 변경하지 못하게
		setLocationRelativeTo(null);//창이 가운데 나오게
		setLayout(null);//레이아웃을 내맘대로 설정가능하게 해줌.
		setVisible(true);//창이 보이게	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//JFrame이 정상적으로 종료되게
	}
	public void paint(Graphics g) {//그리는 함수
		g.drawImage(background, 0, 0, null);//background를 그려줌
		g.drawImage(marimo, 250, 500, null);
		g.drawImage(sh, 0, 0, null);
		g.drawImage(b, 500, 200, null);
	}
	public static void main(String args[]) {
		new Shower_marimo();
	}
}