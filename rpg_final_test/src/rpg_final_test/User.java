package rpg_final_test;

import java.util.ArrayList;

public class User {
	private int num;
	private String id, pw;
	private int money;
	private ArrayList<Player> character;
	private ArrayList<Item> inventory;
	
	public User(int num, String id, String pw) {
		this.num = num;
		this.id = id;
		this.pw = pw;
		this.money = 10000;
		this.character = new ArrayList<>();
		this.inventory = new ArrayList<>();
	}
	
	public User(int num, String id, String pw, int money) {
		this.num = num;
		this.id = id;
		this.pw = pw;
		this.money = money;
	}
	
	public void setCharacter(ArrayList<Player> character) {
		this.character = character;
	}

	public ArrayList<Item> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}

	public ArrayList<Player> getCharacter() {
		return character;
	}

	public void remove(int sel){
		this.character.remove(sel);
	}
	
	public void addChar(Player player) {
		this.character.add(player);
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	
	public void myUnits() {
		System.out.println("=======[MY UNITS]=======");
		for(int i=0; i<this.character.size(); i++) {
			String str = "[" + (i+1) + "] " + this.character.get(i).toString();
			System.out.println(str);
		}
		System.out.println("==========================");
	}
	
	public void myInventory() {
		System.out.println("========[MY INVENTORY]========");
		for(int i=0; i<this.inventory.size(); i++) {
			System.out.print("[" + (i + 1) + "] ");
			System.out.println(this.inventory.get(i).toString());
		}
		System.out.println("==============================");
	}
}
