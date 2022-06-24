package rpg_final_test;

import java.util.ArrayList;

public class StageBattle extends Stage {
	private MonsterManager monsterInstance = MonsterManager.getInstance();
	private int dungeonStage = 1;
	
	private Player[] party;
	
	@Override
	public void init() {
		monsterInstance.monsterSet(dungeonStage);
	}
	
	@Override
	public FileManager dataManager() {
		return FileManager.getInstance();		
	}
	
	@Override
	public boolean update(User user) {
		dataManager().save();
		party = MyUnit.getInstance().getPartyList();
		System.out.printf("========[DUNGEON]========[Stage : %d]\n", dungeonStage);
		System.out.println("1.앞으로 나가아기 2.마을로 돌아가기");
		
		int sel = GameManager.sc.nextInt();
		
		init();
		
		if(sel == 1) { 
			if(moveFoward(user)) {
				System.out.println("\n=========[MASSAGE]========");
				System.out.println("모든 캐릭터가 쓰러졌습니다. 마을로 돌아갑니다...");
				System.out.println("정신을 잃어 1500G를 잃어버렸다...\n");
				user.setMoney(user.getMoney() - 1500);
				GameManager.nextStage = "LOBBY";
				return false;
			}
			else {
				dungeonStage ++;
			}
		}
		else if(sel == 2) {
			GameManager.nextStage = "LOBBY";
			return false;
		}
		
		if(dungeonStage == 8) {
			GameManager.nextStage = "LOBBY";
			int reward = 3000;
			user.setMoney(user.getMoney() + reward);
			System.out.println("========[DUNGEON CLEAR!]========");
			System.out.println("=========[3000G GET!!!]========");
			return false;
		}

		return true;
	}
	
	private boolean moveFoward(User user) {
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
				
				if(battleOver(user).equals("GAMEOVER")) 
					return true;
				else if(battleOver(user).equals("CONTINUE"))
					return false;
			}
		}
	}
	
	private String battleOver(User user) {
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
		
		if(playerDead == party.length) {
			return "GAMEOVER";
		}
		else if(monsterDead == monsterInstance.getMonList().size()) {
			return "CONTINUE";
		}
		else
			return " ";
	}
	
	public void playerAtt() {
		System.out.println("\n========[PLAYER TURN]========");
		int playerIdx = 0;
		while(playerIdx < 4) {
			
			if(monsterInstance.getMonList().size() <= 0)
				return;
			
			Player attacker = party[playerIdx];
			
			if(attacker.getHp() == 0) {
				playerIdx++;
				continue;
			}
			
			System.out.println(attacker.toString());
			System.out.println("1.기본 공격 2.스킬");
			
			int sel = GameManager.sc.nextInt();
			
			int monIdx = GameManager.ran.nextInt(monsterInstance.getMonList().size());
			Unit target = monsterInstance.getMonList().get(monIdx);
			
			if(target.getHp() <= 0)
				return;
			
			if(sel == 1) {
				System.out.println(attacker.attackMonster(target, attacker) + "\n");
			}
			else if(sel == 2) {
				skill(party, attacker, target, monIdx);
			}
			
			if(target.getHp() == 0) {
				monsterInstance.getMonList().remove(monIdx);
			}
			playerIdx++;
		}
	}
	
	public void monsterAtt() {
		System.out.println("\n========[MONSTER TURN]========");
		int mIdx = 0;
		while(mIdx < monsterInstance.getMonList().size()) { 
			Unit monster = monsterInstance.getMonList().get(mIdx);
			
			int playerIdx = GameManager.ran.nextInt(party.length);
			Unit target = party[playerIdx];
			
			if(target.getHp() == 0)
				continue;
			
			System.out.println(monster.attackPlayer(target));
			
			mIdx++;
		}
	}
	
	public void skill(Player[] party, Player player, Unit target, int monIdx) {
		
		if(player.getState().equals("전사")) {
			int plusPower = player.getMaxHp() / 50;
			
			for(int i=0; i<party.length; i++) {
				party[i].setAtt(party[i].getAtt() + plusPower);
			}
			System.out.printf("모든 파티원의 공격력이 [%d] 만큼 올라갑니다\n", plusPower);
		}
		
		else if(player.getState().equals("마법사")) {
			for(int i=0; i<party.length; i++) {
				int playerHp = party[i].getHp();
				int healPower = playerHp / 10;
				
				if(playerHp + healPower > party[i].getMaxHp())
					party[i].setHp(party[i].getMaxHp());
				else {
					party[i].setHp(playerHp + healPower);
				}
			}
			System.out.println("파티원의 체력을 회복합니다.");
		}
		else if(player.getState().equals("궁수")) {
			int tempAtt = player.getAtt();
			player.setAtt(player.getAtt() * 2);
			System.out.println(player.attackMonster(target, player) + "\n");
			player.setAtt(tempAtt);
		}
		else if(player.getState().equals("도적")) {
			int tempAtt = player.getAtt();
			player.setAtt(player.getAtt() * 2);
			System.out.println(player.attackMonster(target, player) + "\n");
			player.setAtt(tempAtt);
		}
		
		
	}

}
