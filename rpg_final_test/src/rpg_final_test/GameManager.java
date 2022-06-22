package rpg_final_test;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameManager {
	
	public static Scanner sc = new Scanner(System.in);
	public static String curStage = "";
	private String nextStage = "";
	Map<String, Stage> stageList = new HashMap<>();
	
	public GameManager() {
		stageList.put("TITLE", new StageTitle());
		stageList.put("LOBBY", new StageLobby());
		stageList.put("BATTLE", new StageBattle());
		
		nextStage = "TITLE";
	}
	
	boolean changeStage() {
		while(true) {
			System.out.println("curStage" + curStage);
			System.out.println("nextStage" + nextStage);
			
			if(curStage == nextStage)
				return true;
			
			curStage = nextStage;
			Stage stage = stageList.get(curStage);
			stage.init();
			
			boolean run = true;
			while(true) {
				run = stage.update();
				if(run == false)
					break;
			}
			
			if(nextStage.equals(""))
				return false;
			else 
				return true;
			
		}
	}
	
}
