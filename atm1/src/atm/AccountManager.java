package atm;

import java.util.ArrayList;
import java.util.Random;

public class AccountManager {
	private Random ran = new Random();
	public static ArrayList<Account> accs = new ArrayList<Account>();
	
	public void accSetting(int log) {
		
		int userCode = UserManager.users.get(log).getCode();
		
		Account acc = new Account(userCode, makeAccNum(), 0);
		
		int tempCnt = UserManager.users.get(log).getAccCnt();
		
		AccountManager.accs.add(acc);
		UserManager.users.get(log).setAccCnt(tempCnt+1);
		
	}
	
	public int makeAccNum() {
		while(true) {
			int ranAccNum = ran.nextInt(899999) + 100000;
			
			int idx = -1;
			
			for(int i=0; i<accs.size(); i++) {
				if(AccountManager.accs.get(i).getAccNum() == ranAccNum) {
					idx = i;
				}
			}
			
			if(idx == -1)
				return ranAccNum;
		}
	}
	
	public void callAccNum(int log) {
		int n = 1;
		for(int i=0; i<accs.size(); i++) {
			if(accs.get(i).getUserCode() == UserManager.users.get(log).getCode()) {
				System.out.println(n + " : " + accs.get(i).getAccNum());
				n++;
			}
		}
	}
	
	public boolean removeSelAcc(int selAcc) {
		for(int i=0; i<accs.size(); i++) {
			if(accs.get(i).getAccNum() == selAcc) {
				accs.remove(i);
				return true;
			}
		}
		return false;
	}
	
}
