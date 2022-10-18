package Marimo;

import java.awt.*;
import java.awt.event.*;

public class marimo  extends Frame implements ActionListener{
	Button b1 =new Button("¹öÆ°");
	Panel p = new Panel();
	public marimo() {
		super("Mrimo");
		b1.addActionListener(this);
		p.add(b1);
		add(p);
		setLocation(550,0);
		setSize(768,1024);
		setVisible(true);
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource() == b1)
			System.exit(0);
	}
	public static void main(String args[]) {
		new marimo();
	}
}
