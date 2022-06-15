package stopwatch;

import java.util.Scanner;

class Timer1 extends Thread {
	int time;
	
	public Timer1(int time) {
		this.time = time;
	}
	
	@Override
	public void run() {
		while(0 < this.time) {
			System.out.println("[�ð�1] �����ð� : " + this.time);
			try {
				sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			this.time--;
		}
		System.out.println("[�ð�1] ����");
	}
}

class Timer2 implements Runnable {
	int time;
	
	public Timer2(int time) {
		this.time = time;
	}
	
	@Override
	public void run() {
		while(0 < this.time) {
			System.out.println("[�ð�2] �����ð� : " + this.time);
			
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			this.time--;
		}
		System.out.println("[�ð�2] ����");
	}
}

public class Timer {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Timer1�� ���ѽð� ���� (��) : ");
		int time1 = sc.nextInt();
		
		System.out.print("Timer2�� ���ѽð� ���� (��) : ");
		int time2 = sc.nextInt();
		
		Timer1 timer1 = new Timer1(time1);
		Timer2 timer2 = new Timer2(time2);
		
		timer1.start();
		timer2.run();
	}

}
