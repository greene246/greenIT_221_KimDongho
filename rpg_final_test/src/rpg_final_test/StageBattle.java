package rpg_final_test;

public class StageBattle extends Stage {
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean update(User user) {
		System.out.println("====[DUNGEON]====");
		System.out.println("");

		int sel = GameManager.sc.nextInt();

		if (sel == 1) {
			if(logIn()) {
				GameManager.nextStage = "LOBBY";
				return false;
			}
		} else if (sel == 2) {
			joinIn();
		}
		return true;
	}
}
