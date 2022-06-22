package rpg_final_test;

public class Unit {
	private int hp,maxHp,att;
	String name;
	String state = "노말";
	
	public Unit(){
	};
	
	public Unit(String name, int maxHp, int att) {
		this.name = name;
		this.maxHp = maxHp;
		this.att = att;
	}
	
}
