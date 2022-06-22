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
	
}
