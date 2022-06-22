package rpg_final_test;

public class UnitSnail extends Unit {
	
	public UnitSnail() {
		this.setName("달팽이");
	}
	
	public void skill() {
		System.out.println("몸통박치기! (1.5배의 대미지)");
	}
	
}
