package shop1_2;

import java.util.Scanner;

public class Shop {
	public static Scanner sc = new Scanner(System.in);
	private UserManager um = new UserManager();
	private ItemManager im = new ItemManager();
	
	
	public void mainMenu() {
		im.inIt();
		while(true) {
			System.out.println("1.가입 2.탈퇴 3.로그인\n9.관리자 0.종료");
			int sel = sc.nextInt();
			
			if(sel == 1) um.join();
			else if(sel == 2) um.joinOut();
			else if(sel == 3) {
				if(um.logIn())
					myMenu();
			}
			else if(sel == 9) managerMode();
			else if(sel == 0) break;
		}
	}
	
	public void myMenu() {
		while(true) {
			System.out.println("[0]종료\n1.내 장바구니 2.쇼핑 3.삭제 4.결제 5.충전");
			int sel = sc.nextInt();
			
			if(sel == 0) { 
				UserManager.log = -1;
				break; 
			}
			else if(sel == 1) { im.myCart(UserManager.log); }
			else if(sel == 2) { im.shopping(); }
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
			System.out.println("[0]종료\n1.카테고리추가 2.카테고리삭제 3.물품추가 4.물품삭제");
			int sel = sc.nextInt();
			
			if(sel == 0) { break; }
			else if(sel == 1) { im.addCategory(); }
			else if(sel == 2) { im.delCategory(); }
			else if(sel == 3) { im.addItem(); }
			else if(sel == 4) { im.delItem(); }
		}
	}
	
	public void cartMode() {
		while(true) {
			System.out.println("[0]종료\n1.전체유저 장바구니 2.장바구니 비우기");
			int sel = sc.nextInt();
			
			if(sel == 0) { break; }
			else if(sel == 1) { im.printAllCart(); }
			else if(sel == 2) { im.delCategory(); }
			
		}
	}
	
	
	
}
