package rpg_final_test;

import java.util.ArrayList;

public class UserManager {
	private ArrayList<User> userList;
	
	private static UserManager instance = new UserManager();
	
	private UserManager() {
		userList = new ArrayList<>();
	}
	
	public static UserManager getInstance() {
		return instance;
	}
	
	private boolean UserDupl(String id) {
		for(int i=0; i<userList.size(); i++) {
			if(userList.get(i).getId().equals(id))
				return false;
		}
		return true;
	}
	
	
	private int makeRanCode() {
		while(true) {
			boolean check = true;
			int userCode = GameManager.ran.nextInt(89)+10;
			
			for(int i=0; i<userList.size(); i++) {
				if(userList.get(i).getNum() == userCode) {
					check = false;
				}
			}
			
			if(check == true)
				return userCode;
		}
	}
	
	public boolean Joinin(String id, String pw) {
		if(UserDupl(id)) {
			int userCode = makeRanCode();
			User user = new User(userCode, id, pw);
			
			userList.add(user);
			defaultUnit(user);
			System.out.println("[회원가입 되었습니다.]\n");
			return true;
		}
		else {
			System.out.println("[이미 존재하는 ID입니다.");
			return false;
		}
	}
	
	private void defaultUnit(User user) {
		user.addChar(new Player("전사", 1000, 45, 1));
		user.addChar(new Player("마법사", 700, 55, 1));
		user.addChar(new Player("힐러", 900, 50, 1));
		user.addChar(new Player("도적", 600, 60, 1));
	}
	
	public boolean UserCheck(String id, String pw) {
		for(int i=0; i<userList.size(); i++) {
			if(userList.get(i).getId().equals(id) && userList.get(i).getPw().equals(pw)) {
				GameManager.user = userList.get(i);
				return true;
			}
		}
		return false;
	}
	
}
