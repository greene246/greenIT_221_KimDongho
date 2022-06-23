package rpg_final_test;

import java.util.ArrayList;

public class StageBattle extends Stage {
	private MonsterManager monsterInstance = MonsterManager.getInstance();
	private int dungeonStage = 1;
	
	private Player[] party = MyUnit.getInstance().partyList;
	
	public StageBattle() {}
	
	@Override
	public void init() {
		monsterInstance.monsterSet(dungeonStage);
	}
	
	@Override
	public boolean update(User user) {
		System.out.println("========[DUNGEON]========");
		System.out.println("1.앞으로 나가아기 2.마을로 돌아가기");
		
		int sel = GameManager.sc.nextInt();
		
		init();
		
		if(sel == 1) { 
			moveFoward(user);
			dungeonStage ++;
		}
		else if(sel == 2) {
			GameManager.nextStage = "LOBBY";
			return false;
		}
		
		if(dungeonStage == 5) {
			GameManager.nextStage = "LOBBY";
			int reward = 3000;
			user.setMoney(user.getMoney() + reward);
			System.out.println("========[DUNGEON CLEAR!]========");
			return false;
		}

		return true;
	}
	
	private void moveFoward(User user) {
		int turn = 0;
		while(true) {
			System.out.println("========[PLYAER]========");
			MyUnit.getInstance().printParty();
			
			while(true) {
				if(turn == 0) {
					System.out.println("========[MONSTER]========");
					monsterInstance.printMons();
					playerAtt();
					turn ++;
				}
				else if(turn == 1) {
					monsterAtt();
					turn++;
				}
				turn = turn == 2 ? 0 : 1;
				if(battleOver(user)) 
					return;
			}
		}
	}
	
	private boolean battleOver(User user) {
		int playerDead = 0;
		for(int i=0; i<party.length; i++) {
			if(party[i].getHp() <= 0) {
				playerDead ++;
			}
		}
		
		int monsterDead = 0;
		for(int i=0; i<monsterInstance.getMonList().size(); i++) {
			if(monsterInstance.getMonList().get(i).getHp() <= 0) {
				monsterDead ++;
			}
		}
		
		if(playerDead == party.length || monsterDead == monsterInstance.getMonList().size())
			return true;
		else
			return false;
	}
	
	public void playerAtt() {
		System.out.println("\n========[PLAYER TURN]========");
		int playerIdx = 0;
		while(playerIdx < 4) {
			
			if(monsterInstance.getMonList().size() <= 0)
				return;
			
			Player attacker = party[playerIdx];
			
			System.out.println(attacker.toString());
			System.out.println("1.기본 공격 2.스킬");
			
			int sel = GameManager.sc.nextInt();
			
			if(sel == 1) {
				int monIdx = GameManager.ran.nextInt(monsterInstance.getMonList().size());
				Unit target = monsterInstance.getMonList().get(monIdx);
				
				if(target.getHp() <= 0)
					return;
				
				System.out.println(attacker.attackMonster(target, attacker) + "\n");
				
				if(target.getHp() == 0) {
					monsterInstance.getMonList().remove(monIdx);
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
	
	public void monsterAtt() {
		System.out.println("\n========[MONSTER TURN]========");
		int mIdx = 0;
		while(mIdx < monsterInstance.getMonList().size()) { 
			Unit monster = monsterInstance.getMonList().get(mIdx);
			
			int playerIdx = GameManager.ran.nextInt(party.length);
			Unit target = party[playerIdx];
			
			System.out.println(monster.attackPlayer(target));
			
			mIdx++;
		}
	}

}
