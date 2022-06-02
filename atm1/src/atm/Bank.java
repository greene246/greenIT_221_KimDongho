package atm;

import java.util.Scanner;

public class Bank {
	private Scanner sc = new Scanner(System.in);
	public static Bank instance = new Bank();
	private String name = "";
	private UserManager um = new UserManager();
	private AccountManager am = new AccountManager();
	
	private Bank() {
		
	}
	
	public void print() {
		System.out.println("----- " + this.name + " ATM -----");
		System.out.println("1. 회원가입");
		System.out.println("2. 회원탈퇴");
		System.out.println("3. 계좌개설");
		System.out.println("4. 계좌해지");
		System.out.print("메뉴 선택 : ");
		int sel = sc.nextInt();
		
		selMenu(sel);
	}
	
	public void selMenu(int sel) {
		if(sel == 1) join();
		else if(sel == 2) remove();
		else if(sel == 3) {}
		else if(sel == 4) {}
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
	
	public void remove() {
		System.out.print("ID : ");
		String id = sc.next();
		System.out.println("PW : ");
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
		System.out.println("PW : ");
		String pw = sc.next();
		
		if(this.um.userCheck(id, pw)) {
			
		}
		else System.out.println("사용자 정보를 다시 입력해주세요");
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
