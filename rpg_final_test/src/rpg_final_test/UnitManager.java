package rpg_final_test;

import java.util.Random;
import java.util.Vector;

public class UnitManager {
	private Random ran = new Random();
	private static UnitManager instance = new UnitManager();
	private String path = "unit_list.";
	private String[] monsters = {"UnitBlueSnail", "UnitRedSnail", "UnitPig", "UnitSnail",}; 
	private Vector<Unit> monList = new Vector<>();
	
	public UnitManager() {}
	
	public static UnitManager getInstance() {
		return instance;
	}
	
	public void monsterSet() {
		this.monList.clear();
		
		int monNum = ran.nextInt(4) + 1;
		
		for(int i=0; i<monNum; i++) {
			try {
				Class<?> clazz = Class.forName(path + "UnitPig");
				Object objMon = clazz.getDeclaredConstructor().newInstance();
				Unit tempMon = (Unit) objMon;
				
				int hp = ran.nextInt(99)+100;
				int att = ran.nextInt(11)+10;
				
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
	
}
