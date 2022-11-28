package Marimo;

import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.*;

public class Start_marimo extends JFrame/*여기있는 이미지를 프레임에 그려줄거임.*/ implements ActionListener{
	private Image background=new ImageIcon(Reallyboll_marimo.class.getResource("../img/boll_marimo.png")).getImage();//배경이미지
	private Image marimo = new ImageIcon(Reallyboll_marimo.class.getResource("../img/marimo.png")).getImage();
	

    private Connection conn; //DB 커넥션 연결 객체
    private static final String USERNAME = "root";//DBMS접속 시 아이디
    private static final String PASSWORD = "mirim";//DBMS접속 시 비밀번호
    private static final String URL = "jdbc:mysql://localhost:3306/marimo_db?serverTimezone=UTC";//DBMS접속할 db명

	private MyPanel loginPanel = new MyPanel();
	private JLabel idLabel = new JLabel("아이디 ");
	private JLabel pwLabel = new JLabel("비밀번호 ");
	private JTextField idText = new JTextField();
	private JPasswordField pwText = new JPasswordField();
	private JButton loginBtn = new JButton("로그인");
	
	public Start_marimo() {

		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("드라이버 로딩 성공");
        } catch (Exception e) {
            System.out.println("드라이버 로딩 실패 ");
            try {
                conn.close();
            } catch (SQLException e1) {    }
        }
		
		setTitle("마리모 키우기");// 타이틀
		setResizable(false);// 창의 크기를 변경하지 못하게
		setSize(725, 1024);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true); // 프레임 보이게 하기
		idText.setPreferredSize(new Dimension(200, 50));
		pwText.setPreferredSize(new Dimension(200, 50));
		loginBtn.setPreferredSize(new Dimension(200, 60));
		loginPanel.add(idLabel);

		loginPanel.add(idText);

		loginPanel.add(pwLabel);

		loginPanel.add(pwText);

		loginPanel.add(loginBtn);
		
		idLabel.setHorizontalAlignment(NORMAL);

		pwLabel.setHorizontalAlignment(NORMAL);
		
		add(loginPanel);
		
		loginBtn.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

			//아이디 비번 확인 테스트 코드~
			String id = idText.getText().trim();
			String pw = pwText.getText().trim();
			String sql = "select from marimo where id=?;";
	        PreparedStatement pstmt = null;
	        try {
		        pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, id);
				ResultSet re = pstmt.executeQuery(sql);
				
				ResultSetMetaData md = re.getMetaData() ;
				int column = md.getColumnCount();
				
				if(column == 0) {
					sql = "insert into marimo values(?,?,?,?,?);";
			        pstmt = conn.prepareStatement(sql);
					pstmt.setString(1,id);
					pstmt.setString(2,pw);
					pstmt.setInt(3,0);
					pstmt.setInt(4,200);
					pstmt.setInt(5,100);
					pstmt.setInt(6,0);
					pstmt.executeUpdate();
				}
				else {
					JOptionPane.showMessageDialog(null, "다른 아이디를 이용해주세요", "이미 사용중인 아이디입니다.", JOptionPane.DEFAULT_OPTION);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			

			if(id.length()==0 || pw.length()==0) {
			JOptionPane.showMessageDialog(null, "아이디 또는 비밀번호를 입력 하셔야 됩니다.", "아이디나 비번을 입력하세요", JOptionPane.DEFAULT_OPTION);
			return;
			}

			if(id.equals("test") && pw.equals("test1")) {
			JOptionPane.showMessageDialog(null, "로그인 성공", "로그인 확인!", JOptionPane.DEFAULT_OPTION);
			return;
			}

			JOptionPane.showMessageDialog(null, "로그인 실패", "로그인 확인!", JOptionPane.DEFAULT_OPTION);
			}

			});
		
	}
	 class MyPanel extends JPanel{
         @Override
         public void paintComponent(Graphics g){
             super.paintComponent(g);
             g.drawImage(background,0,0,getWidth(),getHeight(),this);
             g.drawImage(marimo,260,200,190,190,this);
         }
	 }

		private Image img_buffer;
		private Graphics buffer;
		public void paint(Graphics g) {//그리는 함수
			img_buffer = createImage(725,1024);
			buffer = img_buffer.getGraphics();
			paintComponents(buffer);
			
			buffer.drawImage(null, 0, 0,null);
			
			g.drawImage(img_buffer, 0,0,null);
			repaint();
		}
	
	
	public static void main(String[] args) {
		new Start_marimo();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
	}

}
