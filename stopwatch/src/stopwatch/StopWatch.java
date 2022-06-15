package stopwatch;

import java.util.Scanner;


class Watch extends Thread {
	static boolean stop = false;
	static boolean pause = false;
	int time = 1;
	
	@Override
	public void run() {
		while(!stop) {
			if(!pause) {
				System.out.print("[�ð�] : ");
				System.out.println(this.time + "��");
				
				this.time++;
			}
			try {
				sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
	}
	
	
}

class ToStop implements Runnable {
	Scanner sc = new Scanner(System.in);
	
	@Override
	public void run() {
		System.out.println("�Ͻ�����(1) / ����(2) /����(3)");
		while(!Watch.stop) {
			int n = sc.nextInt();
			
			if(n == 1) {
				System.out.println("����(2) ����(3)");
				Watch.pause = true;
			}
			else if(n == 2) {
				System.out.println("�Ͻ�����(1) ����(3)");
				Watch.pause = false;
			}
			else if(n == 3) {
				System.out.println("�����մϴ�.");
				Watch.stop = true;
			}
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("[�ð�] ����");
	}
	
}

public class StopWatch {

	public static void main(String[] args) {
		
		Watch watch = new Watch();
		ToStop tostop = new ToStop();
		
		watch.start();
		tostop.run();
		
	}

}
