package rpg_final_test;

import java.io.IOException;

public class StageTitle extends Stage {
	
	@Override
	public void init() {
		
	}
	
	@Override
	public FileManager dataManager() {
		return FileManager.getInstance();		
	}
	
	@Override
	public boolean update(User user) {
		System.out.println("====[TEXT RPG]====");
		System.out.println("1.로그인 2.회원가입");

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
	
	private void joinIn() {
		System.out.println("====[JOIN]==== 0.뒤로가기");
		while(true) {
			System.out.print("ID : ");
			String id = GameManager.sc.next();
			if(id.equals("0")) {
				break;
			}
			System.out.print("PW : ");
			String pw = GameManager.sc.next();
			
			if(UserManager.getInstance().Joinin(id, pw)) {
				break;
			}
		}
	}
	
	private boolean logIn() {
		System.out.println("====[LOG-IN]==== 0.뒤로가기");
		while(true) {
			System.out.print("ID : ");
			String id = GameManager.sc.next();

			if (id.equals("0")) {
				return false;
			}

			System.out.print("PW : ");
			String pw = GameManager.sc.next();

			if (UserManager.getInstance().UserCheck(id, pw)) {
				System.out.printf("[user : %s]\n\n", id);
				return true;
			} else
				System.out.println("회원 정보를 다시 확인해주세요");
		}
	}
	
	
	
}
