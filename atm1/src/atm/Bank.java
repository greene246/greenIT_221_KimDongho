package atm;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Bank {
	private Scanner sc = new Scanner(System.in);
	public static Bank instance = new Bank();
	private String name = "";
	private UserManager um = new UserManager();
	private AccountManager am = new AccountManager();
	private String filename = "banklist";
	File file = new File(filename);

	public void print() {
		System.out.println("----- " + this.name + " ATM -----");
		System.out.println("1. 회원가입");
		System.out.println("2. 회원탈퇴");
		System.out.println("3. 계좌개설");
		System.out.println("4. 계좌해지");
		System.out.println("5. 저장");
		System.out.println("6. 불러오기");
		System.out.print("메뉴 선택 : ");
		int sel = sc.nextInt();
		
		selMenu(sel);
	}
	
	public void selMenu(int sel) {
		if(sel == 1) join();
		else if(sel == 2) removeUser();
		else if(sel == 3) makeAcc();
		else if(sel == 4) removeAcc();
		else if(sel == 5) save();
		else if(sel == 6) load();
	}
	
	public void join() {
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("사용할 ID : ");
		String id = sc.next();
		
		if(this.um.idDupl(id)) {
			System.out.println("사용할 수 있는 ID입니다.");
			System.out.print("PW : ");
			String pw = sc.next();
			this.um.userSetting(name, id, pw);
			System.out.println("회원가입 완료");
		}
		else System.out.println("이미 존재하는 ID입니다.");
	}
	
	public void removeUser() {
		System.out.print("ID : ");
		String id = sc.next();
		System.out.print("PW : ");
		String pw = sc.next();
		
		if(this.um.userCheck(id, pw)) {
			this.um.remove(id, pw);
			System.out.println("탈퇴되었습니다.");
		}
		else System.out.println("사용자 정보를 다시 입력해주세요");
	}
	
	public void makeAcc() {
		System.out.print("ID : ");
		String id = sc.next();
		System.out.print("PW : ");
		String pw = sc.next();
		
		if(this.um.userCheck(id, pw)) {
			int log = this.um.idLog(id, pw);
			
			if(this.um.checkCnt(log)) {
				this.am.accSetting(log);
				
				System.out.println("계좌과 개설되었습니다.");
			}
			else System.out.println("4개 이상의 계좌는 만들 수 없습니다.");
			
		}
		else System.out.println("사용자 정보를 다시 입력해주세요");
	}
	
	public void removeAcc() {
		System.out.print("ID : ");
		String id = sc.next();
		System.out.print("PW : ");
		String pw = sc.next();
		
		if(this.um.userCheck(id, pw)) {
			int log = this.um.idLog(id, pw);
			
			this.am.callAccNum(log);
			System.out.println("해지하실 계좌번호");
			
			int selAcc = sc.nextInt();
			
			if(this.am.removeSelAcc(selAcc)) {
				System.out.println("해당계좌가 해지되었습니다.");
			}
			else System.out.println("계좌번호를 다시 확인해주십시오.");
		}
	}
	
	public void save() {

		
		try {
			FileWriter fw = new FileWriter(this.file);
			
			String data = "";
			for (int i = 0; i < UserManager.users.size(); i++) {
				data += UserManager.users.get(i).getCode() + ",";
				data += UserManager.users.get(i).getId() + ",";
				data += UserManager.users.get(i).getPw() + ",";
				data += UserManager.users.get(i).getName() + ",";
				data += UserManager.users.get(i).getAccCnt();

				for (int j = 0; j < AccountManager.accs.size(); j++) {
					data += "/" + AccountManager.accs.get(j).getAccNum() + ",";
					data += AccountManager.accs.get(j).getMoney();
				}
				if (i < UserManager.users.size() - 1)
					data += "\n";
			}
			fw.write(data);
			fw.close();
			System.out.println("SAVE");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("FAIL");
		}
	}
	
	public void load() {
		if(this.file.exists()) {
			try {
				FileReader fr = new FileReader(this.filename);
				BufferedReader br = new BufferedReader(fr);
				
				int n = 0;
				
				while(true) {
					String data = br.readLine();
					
					if(data == null)
						break;
					
					String[] temp = data.split("/");
					
					String[] userInfo = temp[0].split(",");
					
					int tempCode = Integer.parseInt(userInfo[0]);
					User dataUser = new User(tempCode, userInfo[1], userInfo[2], userInfo[3]);
					dataUser.setAccCnt(Integer.parseInt(userInfo[4]));
					
					UserManager.users.add(dataUser);
					
					for(int i=1; i<temp.length; i++) {
						String[] info = temp[i].split(",");
						
						int tempAccNum = Integer.parseInt(info[0]);
						int tempMoney = Integer.parseInt(info[1]);
						
						Account dataAcc = new Account(tempCode, tempAccNum, tempMoney);
						AccountManager.accs.add(dataAcc);
					}
				}
				fr.close();
				br.close();
				System.out.println("LOAD");
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void run() {
		// 실행 로직
		while(true) {
			print();
		}
	}
	
	public void setName(String name) {
		this.name = name;
	}
}
