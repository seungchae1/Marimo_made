package Marimo;

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

public class Start_marimo extends JFrame/*�����ִ� �̹����� �����ӿ� �׷��ٰ���.*/ implements ActionListener{
	private Image background=new ImageIcon(Reallyboll_marimo.class.getResource("../img/boll_marimo.png")).getImage();//����̹���
	private Image marimo = new ImageIcon(Reallyboll_marimo.class.getResource("../img/marimo.png")).getImage();
	
	//DB
	static String driver = "com.mysql.cj.jdbc.Driver";
	static String url = "jdbc:mysql://localhost:3306/";
	static String dbname = "marimo_db?serverTimezone=UTC";
	static String id = "marimo";
	static String pwd = "Abcd123@";
	static Connection conn = null;
	
	private MyPanel loginPanel = new MyPanel();
	private JLabel idLabel = new JLabel("���̵� ");
	private JLabel pwLabel = new JLabel("��й�ȣ ");
	private JTextField idText = new JTextField();
	private JPasswordField pwText = new JPasswordField();
	private JButton loginBtn = new JButton("�α���");
	private JButton joinBtn = new JButton("ȸ������");
	
	public Start_marimo() {
		
		setTitle("������ Ű���");// Ÿ��Ʋ
		setResizable(false);// â�� ũ�⸦ �������� ���ϰ�
		setSize(725, 1024);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true); // ������ ���̰� �ϱ�
		idText.setPreferredSize(new Dimension(200, 50));
		pwText.setPreferredSize(new Dimension(200, 50));
		loginBtn.setPreferredSize(new Dimension(200, 60));
		joinBtn.setPreferredSize(new Dimension(200, 60));
		
		loginPanel.add(idLabel);
		
		loginPanel.add(idText);

		loginPanel.add(pwLabel);

		loginPanel.add(pwText);

		loginPanel.add(loginBtn);
		loginPanel.add(joinBtn);
		
		idLabel.setHorizontalAlignment(NORMAL);

		pwLabel.setHorizontalAlignment(NORMAL);
		
		add(loginPanel);
		
		loginBtn.addActionListener(this);
		joinBtn.addActionListener(this);
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
		//���̵� ��� Ȯ�� �׽�Ʈ �ڵ�~
        try {
			String id = idText.getText().trim();
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
					day_marimo s = new day_marimo();
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
					pstmt.setInt(3,0);
					pstmt.setInt(4,200);
					pstmt.setInt(5,100);
					pstmt.setInt(6,0);
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
