package rpg_final_test;

public class StageLobby extends Stage {
	
	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public boolean update(User user) {
		while(true) {
			System.out.println("====[LOBBY]==== [" + user.getMoney() + "G]");
			System.out.println("1.[나의 캐릭터 관리] 2.[던전입장]\n3.[상점] 4.[창고] 0.뒤로가기");
			int sel = GameManager.sc.nextInt();
			
			if(sel == 1) {
				System.out.println("\n====[MY UNITS]====");
				MyUnit.getInstance().printMenu(user);
			}
			else if(sel == 2) {
				
			}
			else if(sel == 3) {
				System.out.println("====[SHOP]====");
				Shop.getInstance().buyItems(user);
			}
			else if(sel == 4) {
				System.out.println("====[INVEN]====");
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
	
	
}
