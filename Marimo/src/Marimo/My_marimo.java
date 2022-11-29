package Marimo;

public class My_marimo {
	private static int money = 0;
	private static int health = 200;
	private static int happy = 100;
	private static int hungry = 0;
	private static int d = 0;

	static int happy_min = 0;
	static int happy_max = 300;
	static int health_min = -100;
	static int health_max = 200;
	static int d_min = -200;
	static int d_max = 0;
	static int hungry_min = 0;
	static int hungry_max = 0;

	static int get_money() {
		return money;
	}

	static void set_money(int m) {
		money += m;
	}

	static int get_health() {
		return health;
	}

	static void set_health(int h) {
		health += h;
	}

	static int get_happy() {
		return happy;
	}

	static void set_happy(int h) {
		happy += h;
	}

	static int get_d() {
		return d;
	}

	static void set_d(int dh) {
		d += dh;
	}

	static int get_hungry() {
		return hungry;
	}

	static void set_hungry(int h) {
		if (hungry + h > hungry_max)
			hungry = hungry_max;
		else
			hungry += h;
	}
}
