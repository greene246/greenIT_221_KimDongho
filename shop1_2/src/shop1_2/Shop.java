package shop1_2;

import java.util.Scanner;

public class Shop {
	public static Scanner sc = new Scanner(System.in);
	private UserManager um = new UserManager();
	private ItemManager im = new ItemManager();
	
	
	public void mainMenu() {
		while(true) {
			System.out.println("1.���� 2.Ż�� 3.�α��� 4.�α׾ƿ�\n9.������ 0.����");
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
			System.out.println("[0]����\n1.�� ��ٱ��� 2.���� 3.���� 4.���� 5.����");
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
			System.out.println("[0]����\n1.ī�װ��߰� 2. ī�װ����� 3.��ǰ�߰� 4.��ǰ����");
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
