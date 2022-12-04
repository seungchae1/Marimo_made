package newMarimo;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

public class myMarimo extends JLabel implements MouseListener{
	private int x, y;
	private ImageIcon marimo;
	
	public myMarimo() {
		x=250;
		y=540;
		initObject();
		initSetting();
	}

	public myMarimo(int x, int y) {
		this.x=x;
		this.y=y;
		initObject();
		initSetting();
	}
	
	public myMarimo(int x, int y, ImageIcon img) {
		this.x=x;
		this.y=y;
		initObject(img);
		initSetting();
	}
	private void initObject() {
		marimo = new ImageIcon(myMarimo.class.getResource("../img/marimo.png"));
	}

	private void initObject(ImageIcon img) {
		marimo = img;
	}
	private void initSetting() {
		setLayout(null);
		setIcon(marimo);
		setSize(190,190);
		setLocation(x,y);
		addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		if(btnList.isCatch) setIcon(new ImageIcon(myMarimo.class.getResource("../img/eat_marimo.png")));
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		 setIcon(marimo);
	}
}
