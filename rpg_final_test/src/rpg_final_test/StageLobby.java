package rpg_final_test;

public class StageLobby extends Stage {
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean update() {
		System.out.println("====[LOBBY]====");
		System.out.println();
		int sel = GameManager.sc.nextInt();
		
		if(sel == 1) {
			GameManager.nextStage = "BATTLE";
			
			return false;
		}
		
		return false;

	}
}
