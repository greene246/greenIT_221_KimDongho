package rpg_final_test;

import java.util.ArrayList;

public class User {
	private int num;
	private String id, pw;
	private ArrayList<Player> character;
	
	public User(int num, String id, String pw) {
		this.num = num;
		this.id = id;
		this.pw = pw;
		this.character = new ArrayList<>();
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
	
	@Override
	public String toString() {
		for(int i=0; i<character.size(); i++) {
			String.format("[%d] [%s]", (i+1), character.get(i).getName());
		}
		return toString();
	}
	
}
