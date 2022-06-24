package rpg_final_test;

public class StageLobby extends Stage {
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void dataManager() {
		FileManager.getInstance().save();
	}
	
	@Override
	public boolean update(User user) {
		while(true) {
			MyUnit.getInstance().updateParty(user);
			dataManager();
			heal(user);
			System.out.println("========[LOBBY]======== [" + user.getMoney() + "G]");
			System.out.println("1.[나의 캐릭터 관리] 2.[던전입장]\n3.[상점] 4.[창고] 0.뒤로가기");
			int sel = GameManager.sc.nextInt();
			
			if(sel == 1) {
				MyUnit.getInstance().printMenu(user);
			}
			else if(sel == 2) {
				GameManager.nextStage = "BATTLE";
				return false;
			}
			else if(sel == 3) {
				Shop.getInstance().shopMenu(user);
			}
			else if(sel == 4) {
				user.myInventory();
			}
			else if(sel == 0) {
				GameManager.nextStage = "TITLE";
				return false;
			}
				
			else
				continue;
		}
	}
	
	private void heal(User user) {
		for(Player player : user.getCharacter()) {
			player.heal();
		}
	}
	
	
}
