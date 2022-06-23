package rpg_final_test;

import java.util.ArrayList;

public class User {
	private int num;
	private String id, pw;
	private int money;
	private ArrayList<Player> character;
	private ArrayList<Player> party;
	private ArrayList<Item> inventory;
	
	public User(int num, String id, String pw) {
		this.num = num;
		this.id = id;
		this.pw = pw;
		this.money = 10000;
		this.character = new ArrayList<>();
		this.party = new ArrayList<>();
		this.inventory = new ArrayList<>();
	}
	
	public ArrayList<Item> getInventory() {
		return inventory;
	}

	public void setInventory(ArrayList<Item> inventory) {
		this.inventory = inventory;
	}

	public ArrayList<Player> getParty() {
		return party;
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
	
	public void addParty(Player player) {
		this.party.add(player);
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
		for(int i=0; i<this.character.size(); i++) {
			String str = "[" + (i+1) + "] " + this.character.get(i).toString();
			System.out.println(str);
		}
	}
	
	public void myPartys() {
		for(int i=0; i<this.party.size(); i++) {
			String str = "[" + (i+1) + "] " + this.party.get(i).toString();
			System.out.println(str);
		}
	}
	
	public void myInventory() {
		for(int i=0; i<this.inventory.size(); i++) {
			System.out.print("[" + (i + 1) + "] ");
			System.out.println(this.inventory.get(i).toString());
		}
	}
}
