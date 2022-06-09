package shop1_2;

import java.util.Vector;

public class ItemManager {
	private Vector<String> category = new Vector<>();
	public static Vector<Item> items = new Vector<>();
	public static Vector<Cart> carts = new Vector<>();
	public static int n = 0;
	private int x = 0;		// ��ٱ��� ��ȣ
	private int y = 0;		// īƮ�� ���� �� ��ȣ
	
	public void inIt() {
		category.add("����");
		category.add("����");
		category.add("����");
		category.add("�ҽ�");
		
		Item item = new Item("�����", category.get(0), 1000);
		items.add(item);
		item = new Item("���ڱ�", category.get(0), 1000);
		items.add(item);
		item = new Item("����", category.get(1), 5000);
		items.add(item);
		item = new Item("��ġ", category.get(1), 15000);
		items.add(item);
		item = new Item("�ݶ�", category.get(2), 800);
		items.add(item);
		item = new Item("�������꽺", category.get(2), 1500);
		items.add(item);
		item = new Item("����", category.get(3), 3000);
		items.add(item);
		item = new Item("�������", category.get(3), 3000);
		items.add(item);
	}
	
	public void addCategory() {
		printCategory();
		System.out.print("ī�װ� �� : ");
		String cate = Shop.sc.next();
		
		if(cateDupl(cate) == -1) {
			category.add(cate);
			System.out.println("ī�װ� �߰�");
		}
		else System.out.println("�̹� ������ ī�װ�");
	}
	
	public int cateDupl(String cate) {
		for(int i=0; i<category.size(); i++) 
			if(cate.equals(category.get(i))) 
				return i;
		return -1;
	}
	
	public void printCategory() {
		for(int i=0; i<category.size(); i++) {
			System.out.println("["+(i+1)+"]"+category.get(i));
		}
	}
	
	public void delCategory() {
		printCategory();
		System.out.print("ī�װ� �� : ");
		String delCategory = Shop.sc.next();
		
		if(cateDupl(delCategory) >= 0) {
			category.remove(cateDupl(delCategory));
			System.out.println("ī�װ� ����");
		}
		else System.out.println("���� ī�װ�");
	}
	
	public void addItem() {
		printCategory();
		System.out.print("ī�װ� ���� : ");
		int sel = Shop.sc.nextInt() -1;
		
		if(sel >= 0 && sel < category.size()) {
			System.out.print("��ǰ�� : ");
			String itemName = Shop.sc.next();
			if(itemDupl(itemName) == -1) {
				System.out.print("���� : ");
				int price = Shop.sc.nextInt();
				
				Item temp = new Item(itemName, category.get(sel), price);
				items.add(temp);
				System.out.println("��ǰ �߰�");
			}
			else System.out.println("�̹� ������ ��ǰ");
		}
		else System.out.println("���� ����");
	}
	
	public int itemDupl(String itemName) {
		for(int i=0; i<items.size(); i++) {
			if(itemName.equals(items.get(i).getName())) {
				return i;
			}
		}
		return -1;
	}
	
	public void printItems() {
		for(int i=0; i<items.size(); i++) {
			System.out.println("["+(i+1)+"]"+items.get(i).getName());
		}
	}
	
	public void delItem() {
		printItems();
		System.out.print("������ ������ : ");
		String itemName = Shop.sc.next();
		
		if(itemDupl(itemName) >= 0) {
			items.remove(itemDupl(itemName));
			System.out.println("������ ����");
		}
		else System.out.println("���� ������");
	}
	
	public void printAllCart() {
		for(int i=0; i<UserManager.userList.size(); i++) {
			String temp = UserManager.userList.get(i).getId();
			System.out.println("[" + temp + "]");
			for(int j=0; j<carts.size(); j++) {
				if(temp.equals(carts.get(i).getUserId())) {
					System.out.print(carts.get(i).getItemName() + " ");
				}
			}
			System.out.println();
		}
		
	}
	
	public void myCart(int log) {
		x = 0;
		String me = UserManager.userList.get(log).getId();
		for(int i=0; i<carts.size(); i++) {
			if(me.equals(carts.get(i).getUserId())) {
				System.out.println("[" + (x+1) + "]" + carts.get(i).getItemName());
				x++;
			}
		}
	}
	
	public void shopping() {
		while(true) {
			printCategory();
			System.out.println("[0]����");
			int sel = Shop.sc.nextInt() -1;
			
			if(sel == -1) break;
			
			if(sel >= 0 && sel < category.size()) {
				printMenu(sel);
				System.out.print("��� : ");
				int selItem = Shop.sc.nextInt()-1;
				
				if(selItem >= 0 && selItem < n) {
					addInCart(UserManager.userList.get(UserManager.log).getId(), sel, selItem);
					System.out.println("��ٱ��Ͽ� ��ҽ��ϴ�.");
				}
				else System.out.println("���� ����");
			}
			else System.out.println("���� ����");
		}
	}
	
	public void addInCart(String userId, int sel, int selItem) {
		
		y = 0;
		
		Cart temp = new Cart();
		temp.setUserId(userId);
		
		for(int i=0; i<items.size(); i++) {
			if(category.get(sel).equals(items.get(i).getCategory())) {
				if(selItem == y)
					temp.setItemName(items.get(i).getName());
				y++;
			}
		}
		carts.add(temp);
	}
	
	public void printMenu(int sel) {
		n = 0;
		String temp = category.get(sel);
		
		for(int i=0; i<items.size(); i++) {
			if(temp.equals(items.get(i).getCategory())) {
				System.out.printf("[%d]%s\t%s\n",(n+1),items.get(i).getName(),items.get(i).getPrice());
				n++;
			}
		}
	}
	
	public void delFromCart() {
		myCart(UserManager.log);
		System.out.print("������ ������ ��ȣ : ");
		int sel = Shop.sc.nextInt() -1;
		
		if(sel >= 0 && sel < x) {
			
		}
		
	}
	
	public void removeMyCart(int log) {
		for(int i=carts.size()-1; i>=0; i--) {
			if(UserManager.userList.get(log).getId().equals(carts.get(i).getUserId()))
				carts.remove(i);
		}
	}
	
	
	
}

