package rpg_final_test;

import java.util.ArrayList;

public class MyUnit {
	private static MyUnit instance = new MyUnit();
	
	private ArrayList<Player> legend = new ArrayList<>();
	private Player[] partyList;
	
	private MyUnit() {
	}
	
	public static MyUnit getInstance() {
		return instance;
	}
	
	public ArrayList<Player> legend() {
		this.legend.add(new Player("창기사", 1200, 80, 2, "전사"));
		this.legend.add(new Player("비숍", 1000, 100, 2, "마법사"));
		this.legend.add(new Player("헌터", 900, 110, 2, "궁수"));
		this.legend.add(new Player("팬텀", 700, 130, 2, "도적"));
		
		return legend;
	}
	
	public void printMenu(User user) {
		while(true) {
			updateParty(user);
			user.myUnits();
			System.out.println("1.[파티교체] 2.[영입] 3.[방출]\n4.[장비] 0.뒤로가기");
			int sel = GameManager.sc.nextInt();
			
			if(sel == 1) { partyMenu(user); }
			else if(sel == 2) { addUnit(user); }
			else if(sel == 3) { removeChar(user); }
			else if(sel == 4) { equipment(user); }
			else if(sel == 0) break;
		}
	}
	
	public void updateParty(User user) {
		partyList = new Player[4];
		int n = 0;
		for(int i=0; i<user.getCharacter().size(); i++) {
			if(user.getCharacter().get(i).isParty()) {
				partyList[n] = user.getCharacter().get(i);
				n++;
			}
		}
	}
	
	public void printParty() {
		System.out.println("========[MY PARTY]========");
		for(int i=0; i<partyList.length; i++) {
			String str = "[" + (i+1) + "] " + partyList[i].toString();
			System.out.println(str);
		}
		System.out.println("===========================");
	}
	
	private void partyMenu(User user) {
		// 문제
		if(user.getCharacter().size() > 4) {
			printParty();
			System.out.print("교체할 유닛 번호 : ");
			int sel = GameManager.sc.nextInt() -1;
			
			if(sel <= -1 || sel >= partyList.length)
				return;
			
			Player[] temp = remainUnit(user);
			for(int i=0; i<temp.length; i++) {
				System.out.println((i+1) + temp[i].toPrintData());
			}
			System.out.print("새로 파티에 들어갈 유닛 번호 : ");
			
			int change = GameManager.sc.nextInt() -1;
			
			partyList[sel].setParty(false);
			temp[change].setParty(true);
			Player temp1;
			
			for(int i =0; i < user.getCharacter().size(); i ++) {
				if(user.getCharacter().get(i).equals(temp[change])) {
					user.getCharacter().get(sel).setParty(false);
					temp1 = user.getCharacter().get(i);
					temp1.setParty(true);
				}
			}
			
			updateParty(user);
			System.out.println("교체되었습니다.");
			printParty();
		}
		else System.out.println("유닛 수가 부족합니다.");
	}
	
	private Player[] remainUnit(User user) {
		System.out.println("========[UNIT]========");
		Player[] temp = new Player [user.getCharacter().size() - 4];
		int n = 0;
		for(int i=0; i<user.getCharacter().size(); i++) {
			if(!user.getCharacter().get(i).isParty()) {
				temp[n] = user.getCharacter().get(i); 
			}
		}
		System.out.println("======================");
		return temp;
	}
	
	private void addUnit(User user) {
		System.out.printf("========[BUY UNIT]======== [%d]\n", user.getMoney());
		for(int i=0; i<legend.size(); i++) {
			System.out.printf("[%d] ", (i+1));
			System.out.println(legend.get(i).toPrintData());
		}
		System.out.println("==========================");
		
		System.out.print("영입할 유닛 [5000G] : ");
		int sel = GameManager.sc.nextInt() - 1;
		
		if(user.getMoney() < 5000)
			return;
		
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
		Player[] temp = remainUnit(user);
		System.out.println(temp.length);
		System.out.print("삭제할 유닛 번호 : ");
		
		int sel = GameManager.sc.nextInt() - 1;
		
		if(sel <= -1 || sel >= temp.length) 
			return;
		
		for(int i=0; i<user.getCharacter().size(); i++) {
			if(user.getCharacter().get(i).equals(temp[sel])) {
				System.out.println("[" + user.getCharacter().get(i).getName() + "] 가 방출되었습니다");
				user.getCharacter().remove(i);
			}
		}
	}
	
	private void equipment(User user) {
		while(true) {
			user.myUnits();
			
			System.out.print("아이템을 장착 / 교체할 유닛을 선택해주세요. 0.[뒤로가기]: ");
			int selUnit = GameManager.sc.nextInt() -1;
			
			if(selUnit < 0 || selUnit >= user.getCharacter().size())
				return;
			
			if(user.getInventory().size() > 0) {
				user.myInventory();
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

	public Player[] getPartyList() {
		return partyList;
	}
	
}