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
	private Map<String, Stage> stageList = new HashMap<>();
	public static User user;
	
	public GameManager() {
		stageList.put("TITLE", new StageTitle());
		stageList.put("LOBBY", new StageLobby());
		stageList.put("BATTLE", new StageBattle());
		
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
				run = stage.update(user);
				FileManager.getInstance().save();
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
