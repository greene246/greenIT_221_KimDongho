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
			System.out.println("[시계1] 남은시간 : " + this.time);
			try {
				sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			this.time--;
		}
		System.out.println("[시계1] 종료");
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
			System.out.println("[시계2] 남은시간 : " + this.time);
			
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
			this.time--;
		}
		System.out.println("[시계2] 종료");
	}
}

public class Timer {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Timer1의 제한시간 설정 (초) : ");
		int time1 = sc.nextInt();
		
		System.out.print("Timer2의 제한시간 설정 (초) : ");
		int time2 = sc.nextInt();
		
		Timer1 timer1 = new Timer1(time1);
		Timer2 timer2 = new Timer2(time2);
		
		timer1.start();
		timer2.run();
	}

}
