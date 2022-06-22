package rpg_final_test;

import java.util.ArrayList;

public class MyUnit {
	private static MyUnit instance = new MyUnit();
	
	private ArrayList<Player> legend = new ArrayList<>();
	
	private MyUnit() {}
	
	public static MyUnit getInstance() {
		return instance;
	}
	
	public ArrayList<Player> legend() {
		this.legend.add(new Player("해적", 800, 70));
		this.legend.add(new Player("궁수", 700, 80));
		this.legend.add(new Player("창기사", 1000, 100));
		
		return legend;
	}
	
	public void printMenu(User user) {
		while(true) {
			System.out.println("\n====[나의 유닛]====");
			System.out.println(user.getParty().size());
			user.myUnits();
			System.out.println("\n1.[파티교체] 2.[영입]\n3.[방출] 0.뒤로가기");
			int sel = GameManager.sc.nextInt();
			
			if(sel == 1) { partyMenu(user); }
			else if(sel == 2) { addUnit(user); }
			else if(sel == 3) { removeChar(user); }
			else if(sel == 0) break;
		}
	}
	
	private void partyMenu(User user) {
		if(user.getCharacter().size() > 4) {
			user.myPartys();
			System.out.print("교체할 유닛 번호 : ");
			int sel = GameManager.sc.nextInt();
			
			remainUnit(user);
			System.out.println("새로 파티에 들어갈 유닛 번호 : ");
			
			int change = GameManager.sc.nextInt();
			
		}
		else System.out.println("유닛 수가 부족합니다.");
	}
	
	private void remainUnit(User user) {
		boolean check = true;
		for(int i=0; i<user.getCharacter().size(); i++) {
			for(int j=0; j<user.getParty().size(); j++) {
				if(user.getCharacter().get(i).getName().equals(user.getParty().get(j).getName()))
					check = false;
			}
			if(check)
				user.getCharacter().get(i).printData();
		}
	}
	
	private void addUnit(User user) {
		for(int i=0; i<legend.size(); i++) {
			System.out.printf("[%d] ", (i+1));
			legend.get(i).printData();
		}
		
		System.out.print("영입할 유닛 : ");
		int sel = GameManager.sc.nextInt() - 1;
		
		if(sel >= 0 && sel < legend.size()) {
			
			for(int i=0; i<user.getCharacter().size(); i++) {
				if(user.getCharacter().get(i).getName().equals(legend.get(sel).getName())) {
					System.out.println("이미 보유한 레전드입니다.");
					return;
				}
			}
			
			user.addChar(legend.get(sel));
			System.out.println("영입 완료");
		}
		else return;
	}
	
	private void removeChar(User user) {
		for(int i=0; i<user.getCharacter().size(); i++) {
			System.out.print("[" + (i+1) + "] ");
			user.getCharacter().get(i).printData();
		}
		System.out.print("방출할 유닛 번호 : ");
		int sel = GameManager.sc.nextInt() - 1;
		
		user.getCharacter().remove(sel);
	}
	
}