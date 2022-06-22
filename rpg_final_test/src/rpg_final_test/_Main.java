package rpg_final_test;

public class _Main {
	public static void main(String[] args) {
		GameManager gm = new GameManager();
		MyUnit.getInstance().legend();

		boolean isRun = true;
		
		while(true) {
			isRun = gm.changeStage();
			if(isRun == false)
				break;
		}
		System.out.println("게임종료");
	}
}
