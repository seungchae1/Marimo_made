package newMarimo;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;

import Marimo.My_marimo;

public class btnList extends JLabel implements MouseListener{
	//JLabel을 버튼처럼 사용
	
	public static boolean isCatch;
	private JLabel btnR, btnS, btnB, btnM;
	private JFrame thisFrame;
	private int sel;
	
	public btnList(JFrame thisFrame) {
		this.thisFrame= thisFrame;
		initObject();
		initSetting();
	}

	private void initObject() {
		btnR = new JLabel(new ImageIcon(btnList.class.getResource("../img/icon_refresh.png")));
		btnS = new JLabel(new ImageIcon(btnList.class.getResource("../img/icon_shower.png")));
		btnB = new JLabel(new ImageIcon(btnList.class.getResource("../img/icon_reallyboll.png")));
		btnM = new JLabel(new ImageIcon(btnList.class.getResource("../img/icon_medicine.png")));

		btnR.setPreferredSize(new Dimension(150, 180)); //버튼사이즈
		btnS.setPreferredSize(new Dimension(185, 180));
		btnB.setPreferredSize(new Dimension(160, 180));
		btnM.setPreferredSize(new Dimension(170, 180));
		
		btnR.addMouseListener(this);
		btnS.addMouseListener(this);
		btnB.addMouseListener(this);
		btnM.addMouseListener(this);
		
		add(btnR);
		add(btnS);
		add(btnB);
		add(btnM);
	}

	private void initSetting() {
		setLayout(new FlowLayout());
		setSize(725,200);
		setLocation(-15,790);
	}

	@Override
	public void mouseClicked(MouseEvent e) { //창이동
		// TODO Auto-generated method stub
		isCatch=false;
		if(e.getComponent()==btnR) {
			if(thisFrame.getName() == "newEat") {
				JOptionPaneEat();
			}
			else {
				new newEat();
				thisFrame.setVisible(false);
			}
		}
		else if(e.getComponent()==btnS) {
			new newShower();
			thisFrame.setVisible(false);
		}
		else if(e.getComponent()==btnB) {
			new newBall();
			thisFrame.setVisible(false);
		}
		else if(e.getComponent()==btnM) {
			if(thisFrame.getName()=="newMedicine") {
				JOptionPaneMedi();
			}else {
				new newMedicine();
				thisFrame.setVisible(false);
			}
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
	int eat_cnt[]= {0,0,0};
	public void JOptionPaneEat() {
		ImageIcon[] answer = {new ImageIcon(btnList.class.getResource("../img/strawberry.png")),new ImageIcon(btnList.class.getResource("../img/grapes.png")),new ImageIcon(btnList.class.getResource("../img/banana.png"))};
		sel = -1;
		isCatch=false;
		sel = JOptionPane.showOptionDialog(thisFrame, null, "마리모에게 줄 음식", JOptionPane.PLAIN_MESSAGE,
				JOptionPane.PLAIN_MESSAGE, null, answer, null);
		switch (sel) {
		case 0:
			eat_cnt[0]++;
			btnR.setIcon(answer[0]);
			isCatch=true;
			MarimoInformation.setMoney(-20);
			if(eat_cnt[0]>10)MarimoInformation.setHealth(-10);
			MarimoInformation.setHappy(20);
			MarimoInformation.setHungry(-20);
			break;
		case 1:
			eat_cnt[1]++;
			btnR.setIcon(answer[1]);
			isCatch=true;
			if(eat_cnt[1]>20)MarimoInformation.setHealth(-10);
			MarimoInformation.setMoney(-50);
			MarimoInformation.setHappy(40);
			MarimoInformation.setHungry(-30);
			break;
		case 2:
			eat_cnt[2]++;
			btnR.setIcon(answer[2]);
			isCatch=true;
			if(eat_cnt[2]>2)MarimoInformation.setHealth(-5);
			MarimoInformation.setMoney(-40);
			MarimoInformation.setHappy(30);
			MarimoInformation.setHungry(-40);
			break;
		default:
			btnR.setIcon(new ImageIcon(btnList.class.getResource("../img/icon_shower.png")));
			isCatch=false;
		}
	}
	public void JOptionPaneMedi() {
		ImageIcon[] answer = {new ImageIcon(btnList.class.getResource("../img/medicine1.png")),new ImageIcon(btnList.class.getResource("../img/medicine2.png")),new ImageIcon(btnList.class.getResource("../img/medicine3.png"))};
		sel = -1;
		isCatch=false;
		sel = JOptionPane.showOptionDialog(thisFrame, null, "마리모에게 줄 약", JOptionPane.PLAIN_MESSAGE,
				JOptionPane.PLAIN_MESSAGE, null, answer, null);
		switch (sel) {
		case 0:
			btnM.setIcon(answer[0]);
			isCatch=true;
			MarimoInformation.setMoney(-20);
			MarimoInformation.setHappy(20);
			MarimoInformation.setHealth(20);
			break;
		case 1:
			btnM.setIcon(answer[1]);
			MarimoInformation.setMoney(-30);
			MarimoInformation.setHappy(30);
			MarimoInformation.setHealth(30);
			isCatch=true;
			break;
		case 2:
			btnM.setIcon(answer[2]);
			MarimoInformation.setMoney(-50);
			MarimoInformation.setHappy(50);
			MarimoInformation.setHealth(50);
			isCatch=true;
			break;
		default:
			btnM.setIcon(new ImageIcon(btnList.class.getResource("../img/icon_shower.png")));
			isCatch=false;
		}
	}
}
