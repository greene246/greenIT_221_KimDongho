package shop1_2;

import java.util.Vector;

public class UserManager {
	public static Vector<User> userList = new Vector<>();
	public static int log = -1;
	
	public void printUser() {
		for(int i=0; i<userList.size(); i++) {
			System.out.println("["+ (i+1) +"]" + userList.get(i).getId());
		}
	}
	
	public void delUser() {
		printUser();
		System.out.print("������ ���� ��ȣ : ");
		int sel = Shop.sc.nextInt()-1;
		
		if(sel >= 0 && sel < userList.size()) {
			userList.remove(sel);
			System.out.println("���� �Ϸ�");
		}
		else System.out.println("���� ����");
	}
	
	public void addUser() {
		printUser();
		System.out.print("ID : ");
		String id = Shop.sc.next();
		
		if(idDupl(id)) {
			System.out.print("PW : ");
			String pw = Shop.sc.next();
			System.out.print("MONEY : ");
			int money = Shop.sc.nextInt();
			
			User temp = new User(money, id, pw);
			
			userList.add(temp);
			System.out.println("�߰��Ǿ����ϴ�.");
		}
		else System.out.println("�ߺ��� ID�Դϴ�.");
		
	}
	
	public void join() {
		while(true) {
			System.out.print("[0]����\nID : ");
			String id = Shop.sc.next();
			
			if(id.equals("0")) break;
			
			if(idDupl(id)) {
				System.out.print("PW : ");
				String pw = Shop.sc.next();
				
				User temp = new User(3000, id, pw);
				userList.add(temp);
				System.out.println("���ԵǾ����ϴ�.");
				break;
			}
			else System.out.println("�ߺ��� ID�Դϴ�.");
		}
	}
	
	public boolean idDupl(String id) {
		for(int i=0; i<userList.size(); i++) {
			if(id.equals(userList.get(i).getId()))
				return false;
		}
		return true;
	}
	
	public void joinOut() {
		while(true) {
			System.out.print("[0]����\nID : ");
			String id = Shop.sc.next();
			
			if(id.equals("0")) break;
			
			System.out.print("PW : ");
			String pw = Shop.sc.next();
			
			if(userCheck(id, pw) >= 0) {
				userList.remove(userCheck(id, pw));
				System.out.println("Ż��Ǿ����ϴ�.");
				break;
			}
			else System.out.println("ȸ�������� �ٽ� Ȯ�����ּ���.");
		}
	}
	
	public int userCheck(String id, String pw) {
		for(int i=0; i<userList.size(); i++) {
			if(userList.get(i).getId().equals(id) && userList.get(i).getPw().equals(pw))
				return i;
		}
		return -1;
	}
	
	public boolean logIn() {
		System.out.print("[0]����\nID : ");
		String id = Shop.sc.next();

		System.out.print("PW : ");
		String pw = Shop.sc.next();

		if (userCheck(id, pw) >= 0) {
			log = userCheck(id, pw);
			System.out.println("'" + id + "' ȸ���� ȯ���մϴ�.");
			return true;
		} else {
			System.out.println("ȸ�������� �ٽ� Ȯ�����ּ���");
			return false;
		}
	}
	
}
