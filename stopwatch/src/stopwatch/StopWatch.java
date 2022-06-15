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
				System.out.print("[시계] : ");
				System.out.println(this.time + "초");
				
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
		System.out.println("일시정지(1) / 시작(2) /정지(3)");
		while(!Watch.stop) {
			int n = sc.nextInt();
			
			if(n == 1) {
				System.out.println("시작(2) 종료(3)");
				Watch.pause = true;
			}
			else if(n == 2) {
				System.out.println("일시정지(1) 종료(3)");
				Watch.pause = false;
			}
			else if(n == 3) {
				System.out.println("종료합니다.");
				Watch.stop = true;
			}
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		System.out.println("[시계] 종료");
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
