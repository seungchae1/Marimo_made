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
		setVisible(true); // 프레임 보이게 하기
		
	}

	private void initObject() {
		background = new JLabel(new ImageIcon(Start_marimo.class.getResource("../img/boll_marimo.png")));
		setContentPane(background);
		login = new JPanel();
		marimo = new myMarimo(260,300);
		add(marimo);
		
		idLabel = new JLabel("아이디 ");
		pwLabel = new JLabel("비밀번호 ");
		idText = new JTextField();
		pwText = new JPasswordField();
		loginBtn = new JButton("로그인");
		joinBtn = new JButton("회원가입");
		
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
		setTitle("마리모 키우기");// 타이틀
		setResizable(false);// 창의 크기를 변경하지 못하게
		setSize(725, 1024);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}
	public static void main(String[] args) {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/marimo_db?serverTimezone=UTC",id,pwd);
			System.out.println("데이터 베이스 연결 성공!!");
		} catch (Exception e) {
			System.out.println("데이터 베이스 연결실패!!");
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
    		JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 입력 하셔야 됩니다.", "아이디나 비번을 입력하세요", JOptionPane.DEFAULT_OPTION);
    		}
			if(e.getSource() == loginBtn) {
				Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		        ResultSet re = stmt.executeQuery("select * from marimo where id='"+id+"' and pass='"+pw+"';");
				re.last();
				int row = re.getRow(); //행개수 계산
				re.beforeFirst();
				if(row == 0) {
					JOptionPane.showMessageDialog(null, "아이디나 비밀번호가 틀렸습니다.", "다시 입력해주세요", JOptionPane.DEFAULT_OPTION);
				}
				else {
					JOptionPane.showMessageDialog(null, id+"님 환영합니다.",  "로그인 성공!", JOptionPane.DEFAULT_OPTION);
					new newDay();
					setVisible(false);
				}
			}
			else if(e.getSource() == joinBtn) {
		        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
		        ResultSet re = stmt.executeQuery("select * from marimo where id='"+id+"' and pass='"+pw+"';");
				re.last();
				int row = re.getRow(); //행개수 계산
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
					JOptionPane.showMessageDialog(null, "회원가입되었습니다.\n"+id+"님 환영합니다.",  "회원가입 성공!", JOptionPane.DEFAULT_OPTION);
				}
				else {
					JOptionPane.showMessageDialog(null, "이미 사용중인 아이디입니다.",  "아이디 중복", JOptionPane.DEFAULT_OPTION);
				}
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}

}
