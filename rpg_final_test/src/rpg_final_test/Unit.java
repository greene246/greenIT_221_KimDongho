package rpg_final_test;

public abstract class Unit {
	protected int hp,maxHp;
	protected int att;
	protected String name;
	protected String state = "노말";
	
	public Unit(){
	};
	
	public Unit(String name, int maxHp, int att) {
		this.name = name;
		this.hp = maxHp;
		this.maxHp = maxHp;
		this.att = att;
	}
	
	public String attackMonster(Unit target, Player attacker) {
		String str = "";
		target.hp -= this.att;
		if(attacker.getWeapon() == null) {
			str = String.format("[%s] 이(가) [%s] 을(를) [%d]의 대미지로 공격!", this.name, target.getName(), this.att);
		}
		else
			str = String.format("[%s] 이(가) [%s] 을(를) [%d + %d]의 대미지로 공격!", this.name, target.getName(), this.att, attacker.getWeapon().getPower());
			
		if(target.hp <= 0) {
			str = String.format("[%s] 을(를) 처치하였습니다", target.name);
			target.hp = 0;
		}
		return str;
	}
	
	public String attackPlayer(Unit target) {
		String str = "";
		target.hp -= this.att;
		str = String.format("[%s] 이(가) [%s] 을(를) [%d]의 대미지로 공격!", this.name, target.getName(), this.att);
		
		if(target.hp <= 0) {
			str = String.format("[%s] 을(를) 처치하였습니다", target.name);
			target.hp = 0;
		}
		return str;
	}
	
	public String toPrintData() {
		String str = "";
		str = String.format("[%s] [%d / %d] [공격력 : %d]", this.name, this.hp, this.maxHp, this.att);
		return str;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMaxHp() {
		return maxHp;
	}

	public void setMaxHp(int maxHp) {
		this.maxHp = maxHp;
	}

	public int getAtt() {
		return att;
	}

	public void setAtt(int att) {
		this.att = att;
	}
	
	public void init(int hp, int att) {
		this.hp = hp;
		this.maxHp = hp;
		this.att = att;
	}
	
	
	
}
