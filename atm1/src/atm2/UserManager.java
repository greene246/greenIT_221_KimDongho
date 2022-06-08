package atm2;

public class UserManager {
static UserManager instance = new UserManager();
	
	User[] userList;
	int userCount;
	
	void joinUser() {
		System.out.println("[가입]");
		System.out.print("사용하실 ID : ");
		String id = ATM.scan.next();
		
		if(idDupl(id)) {
			System.out.print("사용하실 PW : ");
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
			System.out.println("회원가입 되었습니다.");
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
			int yourAccCnt = loginUser.accCount;
			
			if(yourAccCnt > 0) {
				Account[] temp = loginUser.accList;
				loginUser.accList = new Account[yourAccCnt + 1];
				
				for(int i=0; i<loginUser.accCount; i++) {
					loginUser.accList[i] = temp[i]; 
				}
			}
			
			else {
			}
			
			loginUser.accList[yourAccCnt].number = makeRanNum();
			loginUser.accList[yourAccCnt].money = 1000;
			yourAccCnt ++;
		}
		else System.out.println("[더 이상 계좌를 생성할 수 없습니다.]");
	}
	
	int makeRanNum() {
		while(true) {
			int ranNum = ATM.ran.nextInt(8999)+1000;
			
			int idx = -1;
			for(int i=0; i<userList.length; i++) 
				for(int j=0; j<userList[i].getAccCount(); j++) 
					if(ranNum == userList[i].accList[j].number) 
						idx = j;
			
			if(idx == -1) 
				return ranNum;
		}
	}
	
}
