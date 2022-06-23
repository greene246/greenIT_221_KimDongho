package rpg_final_test;

public class Player extends Unit{
	
	private Item weapon;
	
	public Player(String name, int hp, int att) {
		super(name, hp, att);
	}

	public Item getWeapon() {
		return weapon;
	}

	public void setWeapon(Item weapon) {
		this.weapon = weapon;
	}
	
	public String toString() {
		String str = "";
		if(weapon != null)
			str = String.format("[%s] [%d / %d] [공격력 : %d + %d]", this.name, this.hp, this.maxHp, this.att, this.weapon.getPower());
		else if(weapon == null)
			str = String.format("[%s] [%d / %d] [공격력 : %d]", this.name, this.hp, this.maxHp, this.att);
		return str;
	}
	
}
