package atm;

import java.util.ArrayList;
import java.util.Random;

public class UserManager {
	private Random ran = new Random();
	public static ArrayList<User> users = new ArrayList<User>();
	
	public void userSetting(String name, String id, String pw) {
		User tempUser = new User(makeCode(), id, pw, name);
		
		UserManager.users.add(tempUser);
	}
	
	public boolean userCheck(String id, String pw) {
		for(int i=0; i<UserManager.users.size(); i++) {
			if(id.equals(UserManager.users.get(i).getId()) && pw.equals(UserManager.users.get(i).getPw()))
				return true;
		}
		return false;
	}
	
	public void remove(String id, String pw) {
		for(int i=0; i<UserManager.users.size(); i++) {
			if(id.equals(UserManager.users.get(i).getId()) && pw.equals(UserManager.users.get(i).getPw())) {
				UserManager.users.remove(i);
			}
				
		}
	}
	
	public int makeCode() {
		while(true) {
			int ranCode = ran.nextInt(8999)+1000;
			
			int idx = -1;
			for(int i=0; i<UserManager.users.size(); i++) {
				int tempCode = UserManager.users.get(i).getCode();
				
				if(ranCode == tempCode) {
					idx = i;
				}
			}
			
			if(idx == -1) {
				return ranCode;
			}
		}
	}
	
	public boolean idDupl(String id) {
		for(int i=0; i<UserManager.users.size(); i++) {
			String tempId = UserManager.users.get(i).getId();
			if(tempId.equals(id)) {
				return false;
			}
		}
		return true;
	}
	
	public int idLog(String id, String pw) {
		for(int i=0; i<UserManager.users.size(); i++) {
			if(id.equals(UserManager.users.get(i).getId()) && pw.equals(UserManager.users.get(i).getPw())) {
				return i;
			}
		}
		return 0;
	}
	
	public boolean checkCnt(int log) {
		if(users.get(log).getAccCnt() < 3) {
			return true;
		}
		return false;
	}
	
}
