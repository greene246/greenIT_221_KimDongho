package shop1_2;

import java.util.Vector;

public class ItemManager {
	private Vector<String> category = new Vector<>();
	public static Vector<Item> items = new Vector<>();
	public static Vector<Cart> carts = new Vector<>();
	public static int n = 0;
	private int x = 0;		// 장바구니 번호
	private int y = 0;		// 카트에 넣을 때 번호
	
	public void inIt() {
		category.add("과자");
		category.add("생선");
		category.add("음료");
		category.add("소스");
		
		Item item = new Item("새우깡", category.get(0), 1000);
		items.add(item);
		item = new Item("감자깡", category.get(0), 1000);
		items.add(item);
		item = new Item("고등어", category.get(1), 5000);
		items.add(item);
		item = new Item("참치", category.get(1), 15000);
		items.add(item);
		item = new Item("콜라", category.get(2), 800);
		items.add(item);
		item = new Item("오렌지쥬스", category.get(2), 1500);
		items.add(item);
		item = new Item("케찹", category.get(3), 3000);
		items.add(item);
		item = new Item("마요네즈", category.get(3), 3000);
		items.add(item);
	}
	
	public void addCategory() {
		printCategory();
		System.out.print("카테고리 명 : ");
		String cate = Shop.sc.next();
		
		if(cateDupl(cate) == -1) {
			category.add(cate);
			System.out.println("카테고리 추가");
		}
		else System.out.println("이미 생성된 카테고리");
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
		System.out.print("카테고리 명 : ");
		String delCategory = Shop.sc.next();
		
		if(cateDupl(delCategory) >= 0) {
			category.remove(cateDupl(delCategory));
			System.out.println("카테고리 삭제");
		}
		else System.out.println("없는 카테고리");
	}
	
	public void addItem() {
		printCategory();
		System.out.print("카테고리 선택 : ");
		int sel = Shop.sc.nextInt() -1;
		
		if(sel >= 0 && sel < category.size()) {
			System.out.print("물품명 : ");
			String itemName = Shop.sc.next();
			if(itemDupl(itemName) == -1) {
				System.out.print("가격 : ");
				int price = Shop.sc.nextInt();
				
				Item temp = new Item(itemName, category.get(sel), price);
				items.add(temp);
				System.out.println("물품 추가");
			}
			else System.out.println("이미 생성된 상품");
		}
		else System.out.println("범위 오류");
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
		System.out.print("삭제할 아이템 : ");
		String itemName = Shop.sc.next();
		
		if(itemDupl(itemName) >= 0) {
			items.remove(itemDupl(itemName));
			System.out.println("아이템 삭제");
		}
		else System.out.println("없는 아이템");
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
			System.out.println("[0]종료");
			int sel = Shop.sc.nextInt() -1;
			
			if(sel == -1) break;
			
			if(sel >= 0 && sel < category.size()) {
				printMenu(sel);
				System.out.print("담기 : ");
				int selItem = Shop.sc.nextInt()-1;
				
				if(selItem >= 0 && selItem < n) {
					addInCart(UserManager.userList.get(UserManager.log).getId(), sel, selItem);
					System.out.println("장바구니에 담았습니다.");
				}
				else System.out.println("범위 오류");
			}
			else System.out.println("범위 오류");
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
		System.out.print("삭제할 아이템 번호 : ");
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

