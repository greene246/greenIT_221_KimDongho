package shop;

import java.util.Scanner;
import java.util.Vector;

public class ItemManager {
	Scanner scan = new Scanner(System.in);
	Vector<String> category = new Vector<String>();
	Vector<Item> itemList = new Vector<Item>(); // 전체 아이템리스트
	Vector<Cart> jangList = new Vector<Cart>(); // 전체 장바구니
	int n = 0;
	ItemManager() {
		init();
	}
	void init() {
		category.add("과자");
		category.add("생선");
		category.add("육류");
		category.add("음료수");
		Item temp = new Item("새우깡", 1000, category.get(0));
		itemList.add(temp);
		temp = new Item("고등어", 2000, category.get(1));
		itemList.add(temp);
		temp = new Item("칸쵸", 3600, category.get(0));
		itemList.add(temp);
		temp = new Item("소고기", 6500, category.get(2));
		itemList.add(temp);
		temp = new Item("콜라", 500, category.get(3));
		itemList.add(temp);
		temp = new Item("새우", 1800, category.get(1));
		itemList.add(temp);
	}

	void printJang() {
		for (int i = 0; i < jangList.size(); i++) {
			jangList.get(i).print();
		}
	}

	void printJang(User u) {
		for (int i = 0; i < jangList.size(); i++) {
			if (u.id.equals(jangList.get(i).userId)) {
				jangList.get(i).print();
			}
		}
	}

	void printCategory() {
		for (int i = 0; i < category.size(); i++) {
			System.out.println("[" + i + "] " + category.get(i));
		}
	}

	void printItemList() {
		for (int i = 0; i < itemList.size(); i++) {
			System.out.print("[" + i + "]");
			itemList.get(i).print();
		}
	}

	void printItemList(int caID) {
		n = 0;
		for (int i = 0; i < itemList.size(); i++) {
			if (category.get(caID).equals(itemList.get(i).category)) {
				System.out.print("[" + n + "]");
				itemList.get(i).print();
				n += 1;
			}
		}
	}

	void addItem() {
		System.out.println("[아이템추가] 아이템이름을 입력하세요.");
		String name = scan.next();
		System.out.println("[아이템추가] 가격을 입력하세요. ");
		int price = scan.nextInt();
		printCategory();
		System.out.println("[아이템추가] 카테고리를 입력하세요. ");
		int sel = scan.nextInt();
		Item temp = new Item(name, price, category.get(sel));
		itemList.add(temp);
	}
	
	void removeItem() {
		printItemList();
		System.out.println("[아이템삭제] 아이템이름을 입력하세요.");
		String name = scan.next();
		
		int delIdx = findName(name);
		
		if(delIdx >= 0) {
			itemList.remove(delIdx);
			System.out.println("[메세지] 삭제되었습니다.");
		}
		else System.out.println("[메세지] 없는 아이템입니다.");
		
	}
	
	int findName(String name) {
		for(int i=0; i<itemList.size(); i++) {
			if(name.equals(itemList.get(i).name))
				return i;
		}
		return -1;
	}

	void addCategory() {
		System.out.println("[카테고리추가] 카테고리 이름을 입력하세요. ");
		String name = scan.next();
		
		int duplIdx = categoryDupl(name);
		
		if(duplIdx >= 0) System.out.println("[메세지] 이미 존재하는 카테고리입니다.");  
		else category.add(name);
	}
	
	int categoryDupl(String name) {
		for(int i=0; i<category.size(); i++) {
			if(name.equals(category.get(i))) {
				return i;
			}
		}
		return -1;
	}
	
	void removeCategory() {
		printCategory();
		System.out.println("[카테고리삭제] 카테고리 이름을 입력하세요. ");
		String name = scan.next();
		
		int delIdx = findCategory(name);
		
		if(delIdx >= 0) {
			category.remove(delIdx);
			System.out.println("[메세지] 삭제되었습니다.");
		}
		else System.out.println("[메세지] 없는 카테고리입니다.");
	}
	
	int findCategory(String name) {
		for(int i=0; i<category.size(); i++) {
			if(name.equals(category.get(i)))
				return i;
		}
		return -1;
	}
	
	void removeJang() {
		System.out.println("[장바구니 삭제] 장바구니를 비울 id를 입력하세요");
		String id = scan.next();
		
		int idx = -1;
		for(int i=0; i<jangList.size(); i++) {
			if(id.equals(jangList.get(i).userId)) 
				idx = i;
		}
		
		if(idx >= 0) {
			for(int i=jangList.size()-1; i>=0; i--) {
				if(id.equals(jangList.get(i).userId)) 
					jangList.remove(i);
			}
			System.out.println("[메세지] " + id + "님의 장바구니를 비웠습니다.");
		}
		else System.out.println(id + "님의 장바구니는 이미 비어있습니다.");
			
	}
	
	void addCart(String usID, int caID, int itemID) {
		int n = 0;
		Cart temp = new Cart();
		temp.userId = usID;
		for (int i = 0; i < itemList.size(); i++) {
			if (category.get(caID).equals(itemList.get(i).category)) {
				if (itemID == n) {
					temp.itemName = itemList.get(i).name;
				}
				n += 1;
			}
		}
		jangList.add(temp);
	}
	
	void delMyItem() {
		int n = 0;
		System.out.println("[삭제] 삭제할 물품의 번호를 입력하세요.");
		
		for (int i = 0; i < jangList.size(); i++) {
			System.out.print("[" + i + "]");
			jangList.get(i).print();
		}
		
		int sel = scan.nextInt();
		if(sel >= 0 && sel < jangList.size()) {
			System.out.println("'" + jangList.get(sel).itemName + "' 물품이 삭제되었습니다. ");
			jangList.remove(sel);
		}
		else System.out.println("범위 오류");
	}
	
	void purchase(User u) {
		int pay = 0;
		for(int i=0; i<jangList.size(); i++) {
			if(u.id.equals(jangList.get(i).userId)) {
				String str = jangList.get(i).itemName;
				for(int j=0; j<itemList.size(); j++) {
					if(str == itemList.get(j).name) {
						pay += itemList.get(j).price;
					}
				}
			}
		}
		
		if(pay <= u.money) {
			u.money -= pay;
			
			for(int i=jangList.size()-1; i>=0; i--) {
				if(u.id.equals(jangList.get(i).userId)) 
					jangList.remove(i);
			}
			System.out.println("구매 완료");
		}
		else System.out.println("금액이 부족합니다.");
	}
}
