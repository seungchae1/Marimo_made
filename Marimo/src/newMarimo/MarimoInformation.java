package newMarimo;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.*;

public class MarimoInformation  extends JLabel {

	//DB
	static String driver = "com.mysql.cj.jdbc.Driver";
	static String id = "marimo";
	static String pwd = "Abcd123@";
	static Connection conn = null;
	
	static String  user = Start_marimo.user;
	
	private int x,y;
	
	private static int money = 10;
	private static int health = 100;
	private static int happy = 100;
	private static int hungry = 50;

	static int happy_min = 0;
	static int happy_max = 200;
	static int health_min = 0;
	static int health_max = 200;
	static int hungry_min = 0;
	static int hungry_max = 100;
	
	private static JLabel moneyL, healthL, happyL, hungryL;
	
	public MarimoInformation() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marimo_db?serverTimezone=UTC",id,pwd);
			System.out.println("데이터 베이스 연결 성공!!");
		} catch (Exception e) {
			System.out.println("데이터 베이스 연결실패!!");
		}
		initObject();
		initSetting();
		setVisible(true); // 프레임 보이게 하기
	}
	private void initObject() {
		x=500;
		y=5;
		moneyL= new JLabel("money : "+Integer.toString(money));
		healthL= new JLabel("health : "+Integer.toString(health));
		happyL= new JLabel("happy : "+Integer.toString(happy));
		hungryL= new JLabel("hungry : "+Integer.toString(hungry));

		moneyL.setBounds(0, 0, 200,20);
		healthL.setBounds(0, 0, 200,20);
		happyL.setBounds(0, 0, 200,20);
		hungryL.setBounds(0, 0, 200,20);
		
		add(moneyL);
		add(healthL);
		add(happyL);
		add(hungryL);
		
	}
	private void initSetting() {
		setLayout(null);
		setSize(100,300);
		setLocation(x,y);
		setLayout(new FlowLayout());
	}
	
	public static void setMoney(int m) {
		money+=m;
		try {
        PreparedStatement pstmt = null;
		String sql = "update marimo set money = ? where id="+user+";";
		pstmt.setInt(1,money);
        pstmt = conn.prepareStatement(sql);
		pstmt.executeUpdate();
        moneyL.setText("money : "+Integer.toString(money));
		}catch(Exception e) {}
	}
	public static void setHealth(int h) {
		health+=h;
		try {
        PreparedStatement pstmt = null;
		String sql = "update marimo set health = ? where id="+user+";";
		pstmt.setInt(1,health);
        pstmt = conn.prepareStatement(sql);
		pstmt.executeUpdate();
        healthL.setText("health : "+Integer.toString(health));
		}catch(Exception e) {}
	}
	public static void setHappy(int h) {
		happy+=h;
		try {
        PreparedStatement pstmt = null;
		String sql = "update marimo set happy = ? where id="+user+";";
		pstmt.setInt(1,happy);
        pstmt = conn.prepareStatement(sql);
		pstmt.executeUpdate();
        happyL.setText("happy : "+Integer.toString(happy));
		}catch(Exception e) {}
	}
	public static void setHungry(int h) {
		hungry+=h;
		try {
        PreparedStatement pstmt = null;
		String sql = "update marimo set hungry = ? where id="+user+";";
		pstmt.setInt(1,hungry);
        pstmt = conn.prepareStatement(sql);
		pstmt.executeUpdate();
        hungryL.setText("hungry"+Integer.toString(hungry));
		}catch(Exception e) {}
		
	}
}
