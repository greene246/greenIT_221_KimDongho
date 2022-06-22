package rpg_final_test;

public class StageJoin extends Stage {
	
	@Override
	public void init() {
	// TODO Auto-generated method stub
	
	}
	
	@Override
	public boolean update() {
		System.out.println("====[JOIN]==== 0.뒤로가기");
		while(true) {
			System.out.print("ID : ");
			String id = GameManager.sc.next();
			if(id.equals("0")) {
				GameManager.nextStage = "TITLE";
				return false;
			}
			System.out.print("PW : ");
			String pw = GameManager.sc.next();
			
			if(UserManager.getInstance().Joinin(id, pw)) {
				GameManager.nextStage = "TITLE";
				return false;
			}
		}
	}
}
