package rpg_final_test;

import java.util.ArrayList;

public class Shop {
	
	private ArrayList<Item> itemList = new ArrayList<>();
	
	private static Shop instance = new Shop();
	
	private Shop() {}
	
	public static Shop getInstance(){
		return instance;
	}
	
	public ArrayList<Item> makeItem() {
		this.itemList.add(new Item("대검", 20, 2000));
		this.itemList.add(new Item("단검", 20, 2000));
		this.itemList.add(new Item("스태프", 20, 2000));
		this.itemList.add(new Item("지팡이", 20, 2000));
		this.itemList.add(new Item("자동권총", 40, 4000));
		this.itemList.add(new Item("석궁", 50, 5000));
		this.itemList.add(new Item("청룡언월도", 100, 10000));
		
		return itemList;
	}
	
	public void shopMenu(User user) {
		while(true) {
			System.out.printf("1.[구매] 2.[판매] 0.[뒤로가기] [%dG]\n", user.getMoney());
			int sel = GameManager.sc.nextInt();
			
			if(sel == 1) { buyItems(user); }
			else if(sel == 2) { sellItems(user); }
			else if(sel == 0) { return; }
		}
	}
	
	public void buyItems(User user) {
		while(true) {
			System.out.println("====[BUY]====");
			System.out.printf("[%dG]\n", user.getMoney());
			printItemList();
			
			System.out.print("원하는 아이템을 선택해주세요 0.[뒤로가기] : ");
			int sel = GameManager.sc.nextInt() -1;
			
			if(sel < 0 || sel >= itemList.size())
				return;
			
			Item target = itemList.get(sel);
			int targetPrice = itemList.get(sel).getPrice();
			int myMoney = user.getMoney();
			
			if(targetPrice > myMoney) {
				System.out.println("보유 골드가 부족합니다.");
			}
			else {
				user.setMoney(myMoney - targetPrice);
				user.getInventory().add(target);
				System.out.println("[" + target.getName() + "] 구매 완료\n");
			}
		}
	}
	
	public void printItemList() {
		int n = 1;
		for(Item i : itemList) {
			System.out.println("[" + n + "]" + i.shopItem());
			n++;
		}
	}
	
	public void sellItems(User user) {
		while(true) {
			System.out.println("====[SELL]==== 기존 가격의 1/2 값");
			System.out.printf("[%dG]\n", user.getMoney());
			user.myInventory();
			
			System.out.print("판매할 아이템을 선택해주세요 0.[뒤로가기] : ");
			int sel = GameManager.sc.nextInt() - 1;
			
			if(sel < 0 || sel >= itemList.size())
				return;
			
			Item target = user.getInventory().get(sel);
			int targetPrice = target.getPrice() / 2;
			int myMoney = user.getMoney();
			
			user.setMoney(myMoney + targetPrice);
			user.getInventory().remove(sel);
			System.out.println("[" + target.getName() + "] 판매 완료\n");
		}
	}
	
}
