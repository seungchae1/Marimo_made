package newMarimo;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

import Marimo.day_marimo;

public class Start_marimo extends JFrame implements ActionListener{
	//DB
	static String driver = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/";
	static String dbname = "marimo_db?serverTimezone=UTC";
	static String id = "marimo";
	static String pwd = "Abcd123@";
	static Connection conn = null;

	static String user;
	
	private JLabel background;
	private myMarimo marimo; 
	private JPanel login;
	private JLabel idLabel;
	private JLabel pwLabel;
	private JTextField idText;
	private JPasswordField pwText;
	private JButton loginBtn;
	private JButton joinBtn;
	
	public Start_marimo() {
		initObject();
		initSetting();
		setVisible(true); // ������ ���̰� �ϱ�
		
	}

	private void initObject() {
		background = new JLabel(new ImageIcon(Start_marimo.class.getResource("../img/boll_marimo.png")));
		setContentPane(background);
		login = new JPanel();
		marimo = new myMarimo(260,300);
		add(marimo);
		
		idLabel = new JLabel("���̵� ");
		pwLabel = new JLabel("��й�ȣ ");
		idText = new JTextField();
		pwText = new JPasswordField();
		loginBtn = new JButton("�α���");
		joinBtn = new JButton("ȸ������");
		
		idText.setPreferredSize(new Dimension(200, 50));
		pwText.setPreferredSize(new Dimension(200, 50));
		loginBtn.setPreferredSize(new Dimension(200, 60));
		joinBtn.setPreferredSize(new Dimension(200, 60));
		
		login.add(idLabel);
		login.add(idText);
		login.add(pwLabel);
		login.add(pwText);
		login.add(loginBtn);
		login.add(joinBtn);
		
		idLabel.setHorizontalAlignment(NORMAL);

		pwLabel.setHorizontalAlignment(NORMAL);
		
		loginBtn.addActionListener(this);
		joinBtn.addActionListener(this);
		login.setSize(700, 400);
		login.setLocation(0, 500);
		login.setBackground(new Color(255, 255, 213, 255));
		add(login);
		
	}
	private void initSetting() {
		setTitle("������ Ű���");// Ÿ��Ʋ
		setResizable(false);// â�� ũ�⸦ �������� ���ϰ�
		setSize(725, 1024);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marimo_db?serverTimezone=UTC",id,pwd);
			System.out.println("������ ���̽� ���� ����!!");
		} catch (Exception e) {
			System.out.println("������ ���̽� �������!!");
		}
		new Start_marimo();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
        try {
			String id = idText.getText().trim();
			user=id;
			String pw = pwText.getText().trim();
        	if(id.length()==0 || pw.length()==0) {
    		JOptionPane.showMessageDialog(null, "���̵� �Ǵ� ��й�ȣ�� �Է� �ϼž� �˴ϴ�.", "���̵� ����� �Է��ϼ���", JOptionPane.DEFAULT_OPTION);
    		}
			if(e.getSource() == loginBtn) {
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		        ResultSet re = stmt.executeQuery("select * from marimo where id='"+id+"' and pass='"+pw+"';");
				re.last();
				int row = re.getRow(); //�ళ�� ���
				re.beforeFirst();
				if(row == 0) {
					JOptionPane.showMessageDialog(null, "���̵� ��й�ȣ�� Ʋ�Ƚ��ϴ�.", "�ٽ� �Է����ּ���", JOptionPane.DEFAULT_OPTION);
				}
				else {
					JOptionPane.showMessageDialog(null, id+"�� ȯ���մϴ�.",  "�α��� ����!", JOptionPane.DEFAULT_OPTION);
					new newDay();
					setVisible(false);
				}
			}
			else if(e.getSource() == joinBtn) {
		        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		        ResultSet re = stmt.executeQuery("select * from marimo where id='"+id+"' and pass='"+pw+"';");
				re.last();
				int row = re.getRow(); //�ళ�� ���
				if(row == 0) {
			        PreparedStatement pstmt = null;
					String sql = "insert into marimo values(?,?,?,?,?,?)";
			        pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,id);
					pstmt.setString(2,pw);
					pstmt.setInt(3,10);
					pstmt.setInt(4,200);
					pstmt.setInt(5,100);
					pstmt.setInt(6,50);
					pstmt.executeUpdate();
					JOptionPane.showMessageDialog(null, "ȸ�����ԵǾ����ϴ�.\n"+id+"�� ȯ���մϴ�.",  "ȸ������ ����!", JOptionPane.DEFAULT_OPTION);
				}
				else {
					JOptionPane.showMessageDialog(null, "�̹� ������� ���̵��Դϴ�.",  "���̵� �ߺ�", JOptionPane.DEFAULT_OPTION);
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
