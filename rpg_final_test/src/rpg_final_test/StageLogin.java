package rpg_final_test;

public class StageLogin extends Stage {
	
	@Override
	public void init() {
	// TODO Auto-generated method stub
	
	}
	@Override
	public boolean update() {
		System.out.println("====[LOG-IN]==== 0.뒤로가기");
		while(true) {
			System.out.print("ID : ");
			String id = GameManager.sc.next();
			
			if(id.equals("0")) {
				GameManager.nextStage = "TITLE";
				return false;
			}
			
			System.out.print("PW : ");
			String pw = GameManager.sc.next();
			
			if(UserManager.getInstance().UserCheck(id, pw)) {
				System.out.printf("[user : %s]\n\n", id);
				GameManager.nextStage = "LOBBY";
				return false;
			}
			else
				System.out.println("회원 정보를 다시 확인해주세요");
		}
		
	}
}
