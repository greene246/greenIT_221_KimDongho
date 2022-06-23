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
		this.legend.add(new Player("해적", 1000, 100));
		this.legend.add(new Player("궁수", 700, 130));
		this.legend.add(new Player("창기사", 1200, 80));
		
		return legend;
	}
	
	public void printMenu(User user) {
		while(true) {
			user.myUnits();
			System.out.println("\n1.[파티교체] 2.[영입] 3.[방출]\n4.[장비] 0.뒤로가기");
			int sel = GameManager.sc.nextInt();
			
			if(sel == 1) { partyMenu(user); }
			else if(sel == 2) { addUnit(user); }
			else if(sel == 3) { removeChar(user); }
			else if(sel == 4) { equipment(user); }
			else if(sel == 0) break;
		}
	}
	
	private void partyMenu(User user) {
		if(user.getCharacter().size() > 4) {
			user.myPartys();
			System.out.print("교체할 유닛 번호 : ");
			int sel = GameManager.sc.nextInt() -1;
			
			remainUnit(user);
			System.out.println("새로 파티에 들어갈 유닛 번호 : ");
			
			int change = GameManager.sc.nextInt() - 1;
			
			user.getParty().remove(sel);
			user.getParty().add(user.getCharacter().get(change + 4));
			System.out.println("교체되었습니다.");
			System.out.println("====[현재 파티]====");
			user.myPartys();
			System.out.println("================");
		}
		else System.out.println("유닛 수가 부족합니다.");
	}
	
	private void remainUnit(User user) {
		int n = 1;
		for(int i=0; i<user.getCharacter().size(); i++) {
			boolean check = true;
			for(int j=0; j<user.getParty().size(); j++) {
				if(user.getCharacter().get(i).getName().equals(user.getParty().get(j).getName()))
					check = false;
			}
			if(check) {
				System.out.printf("[%d] ", n);
				System.out.println(user.getCharacter().get(i).toPrintData());
				n++;
			}
		}
	}
	
	private void addUnit(User user) {
		for(int i=0; i<legend.size(); i++) {
			System.out.printf("[%d] ", (i+1));
			System.out.println(legend.get(i).toPrintData());
		}
		
		System.out.print("영입할 유닛 [5000G]: ");
		int sel = GameManager.sc.nextInt() - 1;
		
		if(sel >= 0 && sel < legend.size()) {
			
			for(int i=0; i<user.getCharacter().size(); i++) {
				if(user.getCharacter().get(i).getName().equals(legend.get(sel).getName())) {
					System.out.println("이미 보유한 레전드입니다.");
					return;
				}
			}
			
			user.addChar(legend.get(sel));
			user.setMoney(user.getMoney() - 5000);
			System.out.println("영입 완료");
		}
		else return;
	}
	
	private void removeChar(User user) {
		remainUnit(user);
		System.out.println("삭제할 유닛 번호 : ");
		
		int sel = GameManager.sc.nextInt() - 1;
		
		user.getCharacter().remove(user.getCharacter().get(sel + 4));
	}
	
	private void equipment(User user) {
		while(true) {
			System.out.println("====[MY UNITS]====");
			user.myUnits();
			System.out.println("================");
			
			System.out.print("아이템을 장착 / 교체할 유닛을 선택해주세요. 0.[뒤로가기]: ");
			int selUnit = GameManager.sc.nextInt() -1;
			
			if(selUnit < 0 || selUnit >= user.getCharacter().size())
				return;
			
			if(user.getInventory().size() > 0) {
				System.out.println("====[나의 장비]====");
				user.myInventory();
				System.out.println("================");
				int selItem = GameManager.sc.nextInt() -1;
				
				if(selItem < 0 || selItem >= user.getInventory().size())
					return;
				
				Item targetWeapon = user.getInventory().get(selItem);
				
				if(targetWeapon.isEquiped()) {
					System.out.println("해당 장비는 장착할 수 없습니다.");
					return;
				}
				
				Player targetUnit = user.getCharacter().get(selUnit); 
				targetUnit.setWeapon(targetWeapon);
				targetWeapon.setEquiped(true);
				
				System.out.printf("[%s] 에게 [%s]가 장착되었습니다.\n",
						user.getCharacter().get(selUnit).getName(),targetWeapon.getName());
			}
			else
				System.out.println("장착할 아이템이 없습니다.");	
		}
	}
	
}