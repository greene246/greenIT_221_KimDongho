package rpg_final_test;

import java.io.BufferedReader;
import java.io.File;
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
			str += targetChars.size() + "\n";
			
			for(Player player : targetChars) {
				str += player.getName() + "/";
				str += player.getHp() + "/";
				str += player.getMaxHp() + "/";
				str += player.getAtt() + "/";
				str += player.isParty();
				if(player.getWeapon() != null) {
					str += "/" + player.getWeapon().getName();
					str += "/" + player.getWeapon().getPower();
					str += "/" + player.getWeapon().getPrice();
					str += "/" + player.getWeapon().isEquiped() + "\n";
				}
				else
					str += "\n";
			}
			
			str += targetInven.size() + "\n";
			
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
	
	public void load() {
		
	}

}
