package newMarimo;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.*;

public class Showerball extends JLabel implements MouseMotionListener{
	private int x, y;
	private ImageIcon showerball;
	
	public Showerball() {
		x=450;
		y=200;
		initObject();
		initSetting();
		setVisible(true); // 프레임 보이게 하기
	}
	private void initObject() {
		showerball = new ImageIcon(Showerball.class.getResource("../img/boll.png"));
	}
	private void initSetting() {
		setLayout(null);
		setIcon(showerball);
		setSize(190,190);
		setLocation(x,y);
		addMouseMotionListener(this);
	}
	int cnt=0;
	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub'
		cnt++;
		if(cnt==10) {
			MarimoInformation.setMoney(100);
		}
		setLocation(e.getLocationOnScreen());
	}
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
