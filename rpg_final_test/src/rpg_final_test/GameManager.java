package rpg_final_test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class GameManager {
	public static Random ran = new Random();
	public static Scanner sc = new Scanner(System.in);
	public static String nextStage = "";
	private String curStage = "";
	Map<String, Stage> stageList = new HashMap<>();
	
	public GameManager() {
		stageList.put("TITLE", new StageTitle());
		stageList.put("LOBBY", new StageLobby());
		stageList.put("BATTLE", new StageBattle());
		stageList.put("LOG-IN", new StageLogin());
		stageList.put("JOIN-IN", new StageJoin());
		
		nextStage = "TITLE";
	}
	
	boolean changeStage() {
		while(true) {
			System.out.println("CurStage : " + curStage);
			System.out.println("NextStage : " + nextStage);
			
			if(curStage.equals(nextStage))
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
