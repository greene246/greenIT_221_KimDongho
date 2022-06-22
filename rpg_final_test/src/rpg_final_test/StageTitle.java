package rpg_final_test;

public class StageTitle extends Stage {
	
	@Override
	public void init() {
		System.out.println("====[TEXT RPG]====");
		System.out.println("[시작]을 입력하세요");
		
		String input = GameManager.sc.next();
		if(input.equals("시작")) {
			
		}
		
		
	}
	
	@Override
	public boolean update() {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
