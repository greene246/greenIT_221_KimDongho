package rpg_final_test;

public class Player extends Unit{
	
	private Item weapon;
	
	private boolean party;
	
	public Player(String name, int hp, int att, int party, String state) {
		super(name, hp, att);
		this.state = state;
		if(party == 1)
			this.party = true;
		else if(party == 2)
			this.party = false;
	}

	public Item getWeapon() {
		return weapon;
	}

	public void setWeapon(Item weapon) {
		this.weapon = weapon;
	}
	
	public boolean isParty() {
		return party;
	}

	public void setParty(boolean party) {
		this.party = party;
	}
	
	public void heal() {
		this.hp = this.maxHp;
	}
	
	public String getState() {
		return this.state;
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
