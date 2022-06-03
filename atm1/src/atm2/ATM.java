package atm2;

import java.util.Random;
import java.util.Scanner;

public class ATM {
	static Scanner scan = new Scanner(System.in);
	static Random ran = new Random();
	
	FileManager fileManager = FileManager.instance;
	UserManager userManager = UserManager.instance;
	static int log;
	
	void menu() {
		while(true) {
			System.out.println("ATM");
			System.out.println("[1] 로그인");
			System.out.println("[2] 회원가입");
			System.out.println("[0] 종료");
			System.out.println("메뉴 선택 : ");
			int selMenu = scan.nextInt();
			
			if(selMenu == 1) { login(); }
			else if(selMenu == 2) { join(); }
			else if(selMenu == 0) { break; }
		}
	}
	
	void join() {
		if(log == -1) {
			UserManager.instance.joinUser();
		}
	}
	
	void login() {
		System.out.println("[로그인]");
		System.out.print("ID : ");
		String id = scan.next();
		System.out.print("PW : ");
		String pw = scan.next();
		
		if(logDataCheck(id, pw)) {
			System.out.println(userManager.userList[log].id + " 회원님 환영합니다.");
			loginMenu();
		}
		else System.out.println("회원 정보를 다시 확인해주세요");
		
	}
	
	boolean logDataCheck(String id, String pw) {
		for(int i=0; i<userManager.userCount; i++) {
			User temp = userManager.userList[i];
			
			if(id.equals(temp.id) && id.equals(temp.password)) {
				log = i;
				return true;
			}
		}
		return false;
	}
	
	void loginMenu() {
		while(true) {
			System.out.println("[1]계좌생성");
			System.out.println("[2]계좌해지");
			System.out.println("[3]입금");
			System.out.println("[4]출금");
			System.out.println("[5]이체");
			System.out.println("[6]회원탈퇴");
			System.out.println("[0]로그아웃");
			
			int selLog = scan.nextInt();
			
			if(selLog == 1) { makeAccount(); }
			else if(selLog == 2) {}
			else if(selLog == 3) {}
			else if(selLog == 4) {}
			else if(selLog == 5) {}
			else if(selLog == 6) {}
			else if(selLog == 0) {}
		}
	}
	
	void makeAccount() {
		
	}
	
}
