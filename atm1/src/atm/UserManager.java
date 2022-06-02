package atm;

import java.util.ArrayList;
import java.util.Random;

public class UserManager {
	private Random ran = new Random();
	private ArrayList<User> users = new ArrayList<User>();
	
	public void userSetting(String name, String id, String pw) {
		int tempCode = makeCode();
		
		User tempUser = new User(tempCode, id, pw, name);
		
		this.users.add(tempUser);
	}
	
	public boolean userCheck(String id, String pw) {
		for(int i=0; i<this.users.size(); i++) {
			if(id.equals(this.users.get(i).getId()) && pw.equals(this.users.get(i).getPw()))
				return true;
		}
		return false;
	}
	
	public void remove(String id, String pw) {
		for(int i=0; i<this.users.size(); i++) {
			if(id.equals(this.users.get(i).getId()) && pw.equals(this.users.get(i).getPw())) {
				this.users.remove(i);
			}
				
		}
	}
	
	public int makeCode() {
		while(true) {
			int ranCode = ran.nextInt(8999)+1000;
			
			int idx = -1;
			for(int i=0; i<this.users.size(); i++) {
				int tempCode = this.users.get(i).getCode();
				
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
		for(int i=0; i<this.users.size(); i++) {
			String tempId = this.users.get(i).getId();
			
			if(tempId == id)
				return false;
		}
		return true;
	}
}
