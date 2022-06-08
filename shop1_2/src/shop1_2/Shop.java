package shop1_2;

import java.util.Scanner;

public class Shop {
	public static Scanner sc = new Scanner(System.in);
	private UserManager um = new UserManager();
	private ItemManager im = new ItemManager();
	
	
	public void mainMenu() {
		while(true) {
			System.out.println("1.가입 2.탈퇴 3.로그인 4.로그아웃\n9.관리자 0.종료");
			int sel = sc.nextInt();
			
			if(sel == 1) um.join();
			else if(sel == 2) um.joinOut();
			else if(sel == 3) um.logIn();
			else if(sel == 4) um.logOut();
			else if(sel == 9) managerMode();
			else if(sel == 0) break;
		}
	}
	
	public void myMenu() {
		while(true) {
			System.out.println("[0]종료\n1.내 장바구니 2.구매 3.삭제 4.결제 5.충전");
			int sel = sc.nextInt();
			
			if(sel == 0) { break; }
			else if(sel == 1) {}
			else if(sel == 2) {}
			else if(sel == 3) {}
			else if(sel == 4) {}
			else if(sel == 5) {}
		}
	}
	
	public void managerMode() {
		while(true) {
			System.out.println("[0]종료\n1.유저관리 2.물품관리 3.장바구니관리");
			int sel = sc.nextInt();
			
			if(sel == 0) { break; }
			else if(sel == 1) { userMode(); }
			else if(sel == 2) { itemMode(); }
			else if(sel == 3) { cartMode(); }
		}
	}
	
	public void userMode() {
		while(true) {
			System.out.println("[0]종료\n1.전체유저 2.유저추가 3.유저삭제");
			int sel = sc.nextInt();
			
			if(sel == 0) { break; }
			else if(sel == 1) { um.printUser(); }
			else if(sel == 2) { um.addUser(); }
			else if(sel == 3) { um.delUser(); }
		}
	}
	
	public void itemMode() {
		while(true) {
			System.out.println("[0]종료\n1.카테고리추가 2. 카테고리삭제 3.물품추가 4.물품삭제");
			int sel = sc.nextInt();
			
			if(sel == 0) { break; }
			else if(sel == 1) { um.printUser(); }
			else if(sel == 2) { um.addUser(); }
			else if(sel == 3) { um.delUser(); }
			else if(sel == 3) { um.delUser(); }
		}
	}
	
	public void cartMode() {
		
	}
	
	
	
}
