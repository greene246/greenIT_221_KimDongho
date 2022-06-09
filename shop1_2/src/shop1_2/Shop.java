package shop1_2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class Shop {
	public static String filename = "shop1_2";
	public static File file = new File(filename);
	public static FileWriter fw;
	public static FileReader fr;
	public static BufferedReader br;
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
			else if(sel == 3) { im.delFromCart(); }
			else if(sel == 4) { purchase(UserManager.log); }
			else if(sel == 5) { um.inputMoney(); }
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
			else if(sel == 2) {  }
		}
	}
	
	public void purchase(int log) {
		int myMoney = UserManager.userList.get(log).money;
		int payment = total(log);
		
		if(payment > 0 && myMoney - payment >= 0) {
			System.out.println("결제 금액 : " + payment);
			UserManager.userList.get(log).setMoney(myMoney - payment);
			im.removeMyCart(log);
			System.out.println("결제 되었습니다.");
			
		}
		else if(payment == 0) System.out.println("장바구니가 비어있습니다.");
		else System.out.println("금액이 부족합니다.");
		
	}
	
	public int total(int log) {
		int total = 0;
		
		for(int i=0; i<ItemManager.carts.size(); i++) {
			Cart temp = ItemManager.carts.get(i);
			
			if(UserManager.userList.get(log).getId().equals(temp.getUserId())) {
				for(int j=0; j<ItemManager.items.size(); j++) {
					Item info = ItemManager.items.get(j);
					
					if(temp.getItemName().equals(info.getName()))
						total += info.getPrice();
				}
			}
		}
		return total;
	}
	
	public void save() {
		
	}
	
	
}
