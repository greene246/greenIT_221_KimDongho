package rpg_final_test;

public class Unit {
	private int hp,maxHp,att;
	private String name;
	private String state = "노말";
	
	public Unit(){
	};
	
	public Unit(String name, int maxHp, int att) {
		this.name = name;
		this.maxHp = maxHp;
		this.att = att;
	}
	
	public void attack(Unit target) {
		target.hp -= this.att;
		String.format("[%s] 이(가) [%d]의 대미지로 공격!", this.name, this.att);
		if(target.hp <= 0) {
			String.format("[%s] 을(를) 처치하였습니다", target.name);
			target.hp = 0;
		}
	}
	
	public void printData() {
		System.out.printf("[%s] [%d / %d] [공격력 : %d]\n", this.name, this.hp, this.maxHp, this.att);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
