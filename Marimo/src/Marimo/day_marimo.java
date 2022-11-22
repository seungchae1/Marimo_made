package Marimo;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class day_marimo extends JFrame/*�����ִ� �̹����� �����ӿ� �׷��ٰ���.*/{
   private Image background=new ImageIcon(day_marimo.class.getResource("../img/day.png")).getImage();//����̹���
   private Image marimo = new ImageIcon(day_marimo.class.getResource("../img/marimo.png")).getImage();
   private ImageIcon btn_img = new ImageIcon(day_marimo.class.getResource("../img/icon_reallyboll.png"));
   private ImageIcon btn_img2 = new ImageIcon(day_marimo.class.getResource("../img/icon_medicine.png"));
   private ImageIcon btn_img3 = new ImageIcon(day_marimo.class.getResource("../img/icon_refresh.png"));
   private ImageIcon btn_img4 = new ImageIcon(day_marimo.class.getResource("../img/icon_shower.png"));
   private ImageIcon btn_sun = new ImageIcon(day_marimo.class.getResource("../img/sun.png"));
   
   JPanel main_panel; // ��ư�� �ٿ��� ���� �г� ����
   JPanel sun_panel;

   JButton bt_img, bt_img2, bt_img3, bt_img4, sun;
   public day_marimo() {
      homeframe();
   }
   void homeframe() {
      setTitle("������ Ű���");//Ÿ��Ʋ
      setResizable(false);//â�� ũ�⸦ �������� ���ϰ�
      setSize(725,1024);
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

      setLocationRelativeTo(null);//â�� ��� ������
      main_panel = new JPanel(); // �г� ��üȭ / �⺻��ġ������ FlowLayout
      sun_panel = new JPanel();
      setLayout(null);
      main_panel.setBounds(0, 810, 700, 200);
      sun_panel.setBounds(0, 0, 170, 200);
      
      //��ư ����
      bt_img = new JButton(btn_img);
      bt_img2 = new JButton(btn_img2);
      bt_img3 = new JButton(btn_img3);
      bt_img4 = new JButton(btn_img4);
      sun = new JButton(btn_sun);
      
      bt_img.setBorderPainted(false); // ��ư �׵θ� ��������
      bt_img2.setBorderPainted(false); // ��ư �׵θ� ��������
      bt_img3.setBorderPainted(false); // ��ư �׵θ� ��������
      bt_img4.setBorderPainted(false); // ��ư �׵θ� ��������
      sun.setBorderPainted(false);
      
      bt_img.setPreferredSize(new Dimension(170, 170)); // ��ư ũ�� ����
      bt_img2.setPreferredSize(new Dimension(170, 170)); // ��ư ũ�� ����
      bt_img3.setPreferredSize(new Dimension(170, 170)); // ��ư ũ�� ����
      bt_img4.setPreferredSize(new Dimension(170, 170)); // ��ư ũ�� ����
      sun.setPreferredSize(new Dimension(170,170));
      
      bt_img.setBackground(new Color(136,199,162,255));
      bt_img2.setBackground(new Color(136,199,162,255));
      bt_img3.setBackground(new Color(136,199,162,255));
      bt_img4.setBackground(new Color(136,199,162,255));
      sun.setBackground(new Color(0,206,255));
      
      main_panel.add(bt_img3); // �гο� ��ư�� �ٿ��ش�
      main_panel.add(bt_img4); // �гο� ��ư�� �ٿ��ش�
      main_panel.add(bt_img); // �гο� ��ư�� �ٿ��ش�
      main_panel.add(bt_img2); // �гο� ��ư�� �ٿ��ش�
      sun_panel.add(sun);
      
      add(main_panel); // ���� �����ӿ� �����г��� �ٿ��ִ� �۾�
      add(sun_panel);
      
      setVisible(true); // ������ ���̰� �ϱ�
   }
   public void paint(Graphics g) {//�׸��� �Լ�
      g.drawImage(background, 0, 0, null);//background�� �׷���
      g.drawImage(marimo, 250, 580, null);
   }
   public static void main(String args[]) {
      new day_marimo();
   }
}