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

public class Start_marimo extends JFrame/*�����ִ� �̹����� �����ӿ� �׷��ٰ���.*/ implements ActionListener{
	private Image background=new ImageIcon(Reallyboll_marimo.class.getResource("../img/boll_marimo.png")).getImage();//����̹���
	private Image marimo = new ImageIcon(Reallyboll_marimo.class.getResource("../img/marimo.png")).getImage();
	

    private Connection conn; //DB Ŀ�ؼ� ���� ��ü
    private static final String USERNAME = "root";//DBMS���� �� ���̵�
    private static final String PASSWORD = "mirim";//DBMS���� �� ��й�ȣ
    private static final String URL = "jdbc:mysql://localhost:3306/marimo_db?serverTimezone=UTC";//DBMS������ db��

	private MyPanel loginPanel = new MyPanel();
	private JLabel idLabel = new JLabel("���̵� ");
	private JLabel pwLabel = new JLabel("��й�ȣ ");
	private JTextField idText = new JTextField();
	private JPasswordField pwText = new JPasswordField();
	private JButton loginBtn = new JButton("�α���");
	
	public Start_marimo() {

		try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("����̹� �ε� ����");
        } catch (Exception e) {
            System.out.println("����̹� �ε� ���� ");
            try {
                conn.close();
            } catch (SQLException e1) {    }
        }
		
		setTitle("������ Ű���");// Ÿ��Ʋ
		setResizable(false);// â�� ũ�⸦ �������� ���ϰ�
		setSize(725, 1024);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true); // ������ ���̰� �ϱ�
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

			//���̵� ��� Ȯ�� �׽�Ʈ �ڵ�~
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
					JOptionPane.showMessageDialog(null, "�ٸ� ���̵� �̿����ּ���", "�̹� ������� ���̵��Դϴ�.", JOptionPane.DEFAULT_OPTION);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			

			if(id.length()==0 || pw.length()==0) {
			JOptionPane.showMessageDialog(null, "���̵� �Ǵ� ��й�ȣ�� �Է� �ϼž� �˴ϴ�.", "���̵� ����� �Է��ϼ���", JOptionPane.DEFAULT_OPTION);
			return;
			}

			if(id.equals("test") && pw.equals("test1")) {
			JOptionPane.showMessageDialog(null, "�α��� ����", "�α��� Ȯ��!", JOptionPane.DEFAULT_OPTION);
			return;
			}

			JOptionPane.showMessageDialog(null, "�α��� ����", "�α��� Ȯ��!", JOptionPane.DEFAULT_OPTION);
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
		public void paint(Graphics g) {//�׸��� �Լ�
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
