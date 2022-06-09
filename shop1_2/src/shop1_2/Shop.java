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
			System.out.println("1.���� 2.Ż�� 3.�α���\n9.������ 0.����");
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
			System.out.println("[0]����\n1.�� ��ٱ��� 2.���� 3.���� 4.���� 5.����");
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
			System.out.println("[0]����\n1.�������� 2.��ǰ���� 3.��ٱ��ϰ���");
			int sel = sc.nextInt();
			
			if(sel == 0) { break; }
			else if(sel == 1) { userMode(); }
			else if(sel == 2) { itemMode(); }
			else if(sel == 3) { cartMode(); }
		}
	}
	
	public void userMode() {
		while(true) {
			System.out.println("[0]����\n1.��ü���� 2.�����߰� 3.��������");
			int sel = sc.nextInt();
			
			if(sel == 0) { break; }
			else if(sel == 1) { um.printUser(); }
			else if(sel == 2) { um.addUser(); }
			else if(sel == 3) { um.delUser(); }
		}
	}
	
	public void itemMode() {
		while(true) {
			System.out.println("[0]����\n1.ī�װ��߰� 2.ī�װ����� 3.��ǰ�߰� 4.��ǰ����");
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
			System.out.println("[0]����\n1.��ü���� ��ٱ��� 2.��ٱ��� ����");
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
			System.out.println("���� �ݾ� : " + payment);
			UserManager.userList.get(log).setMoney(myMoney - payment);
			im.removeMyCart(log);
			System.out.println("���� �Ǿ����ϴ�.");
			
		}
		else if(payment == 0) System.out.println("��ٱ��ϰ� ����ֽ��ϴ�.");
		else System.out.println("�ݾ��� �����մϴ�.");
		
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
