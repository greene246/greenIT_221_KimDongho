package rpg_final_test;

import java.util.ArrayList;

public class UserManager {
	private ArrayList<User> userList;
	private boolean userJoin;
	
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
		this.userJoin = false;
		if(UserDupl(id)) {
			int userCode = makeRanCode();
			User user = new User(userCode, id, pw);
			
			userList.add(user);
			defaultUnit(user);
			System.out.println("[회원가입 되었습니다.]\n");
			this.userJoin = true;
			return true;
		}
		else {
			System.out.println("[이미 존재하는 ID입니다.");
			return false;
		}
	}
	
	private void defaultUnit(User user) {
		user.addChar(new Player("히어로", 1000, 45, 1, "전사"));
		user.addChar(new Player("위자드", 700, 55, 1, "마법사"));
		user.addChar(new Player("보우마스터", 900, 50, 1, "궁수"));
		user.addChar(new Player("섀도어", 600, 60, 1, "도적"));
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
	
	public boolean getUserJoin() {
		return userJoin;
	}

	public ArrayList<User> getUserList() {
		return userList;
	}
	
	
}
