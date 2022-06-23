package rpg_final_test;

public class StageBattle extends Stage {
	
	@Override
	public void init() {
		
	}
	
	@Override
	public boolean update(User user) {
		System.out.println("====[DUNGEON]====");
		System.out.println("1.앞으로 나가아기 2.마을로 돌아가기");
		
		int sel = GameManager.sc.nextInt();
		
		if(sel == 1) {}
		else if(sel == 2) {
			GameManager.nextStage = "LOBBY";
			return false;
		}

		return true;
	}
}
