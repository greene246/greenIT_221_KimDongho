package rpg_final_test;

import java.util.Vector;

public class MonsterManager {
	private static MonsterManager instance = new MonsterManager();
	private String path = "unit_list.";
	private String[] monsters = {"UnitBlueSnail", "UnitRedSnail", "UnitPig", "UnitSnail"}; 
	private Vector<Unit> monList = new Vector<>();
	
	public MonsterManager() {}
	
	public static MonsterManager getInstance() {
		return instance;
	}
	
	public void monsterSet() {
		this.monList.clear();
		
		int monNum = GameManager.ran.nextInt(4) + 1;
		
		for(int i=0; i<monNum; i++) {
			try {
				int ranMon = GameManager.ran.nextInt(monsters.length);
				Class<?> clazz = Class.forName(path + monsters[ranMon]);
				Object objMon = clazz.getDeclaredConstructor().newInstance();
				Unit tempMon = (Unit) objMon;
				
				int hp = GameManager.ran.nextInt(99)+100;
				int att = GameManager.ran.nextInt(11)+10;
				
				tempMon.init(hp, att);
				monList.add(tempMon);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public Vector<Unit> getMonList() {
		return monList;
	}

	public void setMonList(Vector<Unit> monList) {
		this.monList = monList;
	}
	
	public void printMons() {
		for(int i=0; i<monList.size(); i++) {
			String str = "[" + (i+1) + "]" + monList.get(i).toPrintData();
			System.out.println(str);
		}
	}
	
}
