package Marimo;

public class My_marimo {
	private static int money = 0;
	private static int health = 200;
	private static int happy = 100;
	private static int hungry = 0;
	private static int d = 0;
	
	static int happy_min=0; 
	static int happy_max=300;
	static int health_min=-100;
	static int health_max=200;
	static int d_min=-200;
	static int d_max=0;
	static int hungry_min=0;
	static int hungry_max=0;
	
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
		if(health+h>health_max) health=health_max;
		else if(health+h<health_min) health= health_min;
		else health += h;
	}
	static int get_happy() {
		return happy;
	}
	static int past_h=100;
	static void set_happy(int h) {
		if(happy+h>happy_max) happy=happy_max;
		else if(happy+h<happy_min) happy= happy_min;
		else happy += h;
		
		if((happy-past_h) >= 30) money+=100;
		else past_h+= happy-past_h;
	}
	static int get_d() {
		return d;
	}
	static void set_d(int dh) {
		if(d+dh>d_max) d=d_max;
		else if(d+dh<d_min) d= d_min;
		else d += dh;
	}
	static int get_hungry() {
		return hungry;
	}
	static void set_hungry(int h) {
		if(hungry+h>hungry_max) hungry=hungry_max;
		else if(hungry+h<hungry_min) hungry= hungry_min;
		else hungry += h;
	}
}
