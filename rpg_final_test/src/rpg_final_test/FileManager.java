package rpg_final_test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

public class FileManager {
	private static FileManager instance = new FileManager();
	private File file;
	private FileWriter fw;
	private FileReader fr;
	private BufferedReader br;
	private Vector<String> data;
	
	public FileManager() {
		data = new Vector<>();
	}
	
	public static FileManager getInstance() {
		return instance;
	}
	
	private ArrayList<User> getUserList() {
		return UserManager.getInstance().getUserList();
	}
	
	private void dataList() {
		for(int i=0; i<getUserList().size(); i++) {
			String str = "userData[" + (i+1) + "]";
			data.add(str);
		}
	}
	
	public void save() {
		dataList();
		int n = 0;
		while(n < getUserList().size()) {
			User target = getUserList().get(n);
			ArrayList<Player> targetChars = getUserList().get(n).getCharacter();
			ArrayList<Item> targetInven = getUserList().get(n).getInventory();
			String str = "";
			
			str += target.getNum() + "/";
			str += target.getId() + "/";
			str += target.getPw() + "/";
			str += target.getMoney() + "\n";
			str += target.getCharacter().size() + "\n";
			
			for(Player player : targetChars) {
				str += player.getName() + "/";
				str += player.getHp() + "/";
				str += player.getAtt() + "/";
				str += player.isParty() + "/";
				str += player.getState();
				if(player.getWeapon() != null) {
					str += "/" + player.getWeapon().getName();
					str += "/" + player.getWeapon().getPower();
					str += "/" + player.getWeapon().getPrice();
					str += "/" + player.getWeapon().isEquiped() + "\n";
				}
				
					str += "\n";
			}
			
			str += target.getInventory().size() + "\n";
			
			for(Item item : targetInven) {
				str += item.getName() + "/";
				str += item.getPower() + "/";
				str += item.getPrice() + "/";
				str += item.isEquiped() + "\n";
			}
			
			try {
				file = new File(data.get(n));
				fw = new FileWriter(file);
				fw.write(str);
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
				System.err.println("!!!");
			}
			n++;
		}
	}
	
	public void load() throws IOException {
		ArrayList<User> userList = UserManager.getInstance().getUserList();
		int n = 1;
		
		while(true) {
			String fileName = "userData[" + n + "]";
			file = new File(fileName);
			
			if(file.exists()) {
				try {
					fr = new FileReader(fileName);
					br = new BufferedReader(fr);
					
					String userData = br.readLine();
					String[] uda = userData.split("/");
					
					User tempUser = new User(Integer.parseInt(uda[0]), uda[1], uda[2], Integer.parseInt(uda[3]));
					ArrayList<Player> tempCharacter = new ArrayList<>();
					ArrayList<Item> tempInven = new ArrayList<>();
					
					int cnt = 0;
					int charCnt = Integer.parseInt(br.readLine());
					// 캐릭터들 불러오기
					while(cnt < charCnt) {
						String playerData = br.readLine();
						
						if(playerData == null)
							break;
						
						String[] pda = playerData.split("/");
						
						int isParty = 0;
						if(pda[3].equals("true")) 
							isParty = 1;
						else
							isParty = 2;
						
						Player tempPlayer = new Player(pda[0], Integer.parseInt(pda[1]), Integer.parseInt(pda[2]), isParty, pda[4]);
						
						tempCharacter.add(tempPlayer);
						cnt ++;
					}
					
					cnt = 0;
					int itemCnt = Integer.parseInt(br.readLine());
					// 장비 불러오기
					while(cnt < itemCnt) {
						String itemData = br.readLine();
						
						if(itemData == null)
							break;
						
						String[] ida = itemData.split("/");
						
						int isEquip = 0;
						if(ida[3].equals("true")) 
							isEquip = 1;
						else
							isEquip = 2;
						
						Item tempItem = new Item(ida[0], Integer.parseInt(ida[1]), Integer.parseInt(ida[2]), isEquip);
						
						tempInven.add(tempItem);
						cnt++;
					}
					
					tempUser.setCharacter(tempCharacter);
					tempUser.setInventory(tempInven);
					
					userList.add(tempUser);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				n++;
			}
			else
				return;
		}
		
	}

}
