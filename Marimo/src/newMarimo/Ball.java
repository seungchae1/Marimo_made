package newMarimo;

import javax.swing.*;

public class Ball extends JLabel{
	private static int x = 270, y = 630;
	private boolean xM=false, yM=false;
	private ImageIcon ball;
	private static int pastX, pastY;
	int a,b;

	public Ball() {
		initObject();
		initSetting();
	}
	private void initObject() {
		ball = new ImageIcon(Ball.class.getResource("../img/icon_reallyboll.png"));
	}

	private void initSetting() {
		setLayout(null);
		setIcon(ball);
		setSize(190,190);
		setLocation(x,y);
	}
	
	public void Move() {
		a = (int)(Math.random()*3)+1;
		b = (int)(Math.random()*3)+1;
		new Thread(()->{
			try{
				while(true) {
					Thread.sleep(5);
					if(yM) {
						y+=a;
					}
					else {
						y-=a;
					};
					if(xM) {
						x+=b;
					}
					else {
						x-=b;
					}
					setLocation(x,y);
					if(pastX<=0 && x>=750)break;
					else if(pastX>=750 && x<=0)break;
					else if(pastY>=1024 && y<=0)break;
					else if(pastY<=0 && y>=1024)break;
					else {
						if(x>=750 || x<=0 || y<=0 || y>=1024)break;
					}
				}
				pastX=x;
				pastY=y;
				if(x<=0) {x+=5; xM=true;}
				else {x-=5; xM=false;}
				if(y<=0) {y+=5; yM=true;}
				else {y-=5; yM=false;}
			}catch(Exception e){}
		}).start();
	}
}