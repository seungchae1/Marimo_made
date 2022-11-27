package Marimo;

public class My_marimo {
	private static int money = 0;
	private static int health = 200;
	private static int happy = 100;
	
	static int happy_min=0; 
	static int happy_max=300;
	static int health_min=-100;
	static int health_max=200;
	
	static int get_money() {
		return money;
	}
	static void set_money(int m) {
		money += m;
	}
}
