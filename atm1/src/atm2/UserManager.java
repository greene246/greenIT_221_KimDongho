package atm2;

public class UserManager {
static UserManager instance = new UserManager();
	
	User[] userList;
	int userCount;
	
	void joinUser() {
		System.out.println("[가입]");
		System.out.print("사용하실 ID :");
		String id = ATM.scan.next();
		
		if(idDupl(id)) {
			System.out.print("사용하실 PW :");
			String pw = ATM.scan.next();
			
			if(userCount == 0) {
				userList = new User[1];
				userList[0] = new User(id, pw);
			}
			else {
				User[] temp = userList;
				userList = new User[userCount +1];
				
				int n = 0;
				for(User i : temp) {
					userList[n] = i;
					n++;
				}
			}
			userCount++;
		}
		else System.out.println("중복된 ID입니다.");
	}
	
	boolean idDupl(String id) {
		for(int i=0; i<userCount; i++) {
			if(id.equals(userList[i].getId()))
				return false;
		}
		return true;
	}
	
	void makeAccount() {
		User loginUser = userList[ATM.log];
		int userAccountCnt = userList[ATM.log].getAccCount();
		
		if(userAccountCnt < 3) {
			System.out.println("[계좌 생성]");
			int ranNum = ATM.ran.nextInt(8999)+1000;
			
			userList[ATM.log].accList = new Account[1];
			
			
		}
		else System.out.println("[더 이상 계좌를 생성할 수 없습니다.");
	}
	
	
	
}
