package newMarimo;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class SunMoon extends JLabel implements MouseListener{
	private int x, y;
	private ImageIcon sunMoon;
	private JFrame thisFrame;

	public SunMoon(ImageIcon img, JFrame thisFrame) {
		this.thisFrame = thisFrame;
		x=3;
		y=5;
		initObject(img);
		initSetting();
	}
	private void initObject(ImageIcon img) {
		sunMoon = img;
		addMouseListener(this);
	}
	private void initSetting() {
		setLayout(null);
		setIcon(sunMoon);
		setSize(190,190);
		setLocation(x,y);
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if(thisFrame.getName()=="day") {
			new newNight();
			thisFrame.setVisible(false);
		}
		else {
			new newDay();
			thisFrame.setVisible(false);
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
}
