package rpg_final_test;

public class StageBattle extends Stage {
	
	private MonsterManager monterInstance = MonsterManager.getInstance();
	
	@Override
	public void init() {
		monterInstance.monsterSet();
	}
	
	@Override
	public boolean update(User user) {
		System.out.println("====[DUNGEON]====");
		System.out.println("1.앞으로 나가아기 2.마을로 돌아가기");
		
		int sel = GameManager.sc.nextInt();
		
		if(sel == 1) { battle(user); }
		else if(sel == 2) {
			GameManager.nextStage = "LOBBY";
			return false;
		}

		return true;
	}
	
	private void battle(User user) {
		int turn = 0;
		while(true) {
			System.out.println("========[PLYAER]========");
			user.myPartys();
			System.out.println("========[MONSTER]========");
			monterInstance.printMons();
			
			while(true) {
				if(turn == 0) {
					playerAtt(user);
					turn ++;
				}
				else if(turn == 1) {
					monsterAtt(user);
					turn++;
				}
				if(battleOver(user)) 
					return;
				turn = turn == 2 ? 0 : 1;
			}
		}
	}
	
	private boolean battleOver(User user) {
		int playerDead = 0;
		for(int i=0; i<user.getParty().size(); i++) {
			if(user.getParty().get(i).getHp() <= 0) {
				playerDead ++;
			}
		}
		
		int monsterDead = 0;
		for(int i=0; i<monterInstance.getMonList().size(); i++) {
			if(monterInstance.getMonList().get(i).getHp() <= 0) {
				monsterDead ++;
			}
		}
		
		if(playerDead == user.getParty().size() || monsterDead == monterInstance.getMonList().size())
			return true;
		else
			return false;
	}
	
	public void playerAtt(User user) {
		System.out.println("\n========[PLAYER TURN]========");
		int playerIdx = 0;
		while(playerIdx < 4) {
			Unit attacker = user.getParty().get(playerIdx);
			
			System.out.println(attacker.toString());
			System.out.println("1.기본 공격 2.스킬");
			
			int sel = GameManager.sc.nextInt();
			
			if(sel == 1) {
				int monIdx = GameManager.ran.nextInt(monterInstance.getMonList().size());
				Unit target = monterInstance.getMonList().get(monIdx);
				
				if(target.getHp() <= 0)
					return;
				
				System.out.println(attacker.attack(target) + "\n");
				
				if(target.getHp() == 0) {
					monterInstance.getMonList().remove(monIdx);
				}
			}
			else if(sel == 2) {
				skillAtt();
			}
			
			playerIdx++;
		}
	}
	
	public void skillAtt() {
		
	}
	
	public void monsterAtt(User user) {
		System.out.println("\n========[MONSTER TURN]========");
		int mIdx = 0;
		while(mIdx < monterInstance.getMonList().size()) { 
			Unit monster = monterInstance.getMonList().get(mIdx);
			
			int playerIdx = GameManager.ran.nextInt(user.getParty().size());
			Unit target = user.getParty().get(playerIdx);
			
			System.out.println(monster.attack(target));
			
			mIdx++;
		}
	}
}
