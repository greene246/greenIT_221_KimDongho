package rpg_final_test;

public class StageTitle extends Stage {
	
	@Override
	public void init() {
		
	}
	
	@Override
	public boolean update() {
		System.out.println("====[TEXT RPG]====");
		while(true) {
			System.out.println("1.로그인 2.회원가입");
			
			int sel = GameManager.sc.nextInt();
			
			if(sel == 1) {
				GameManager.nextStage = "LOG-IN";
				return false;
			}
			else if(sel == 2) {
				GameManager.nextStage = "JOIN-IN";
				return false;
			}
		}
	}
	
	
}
