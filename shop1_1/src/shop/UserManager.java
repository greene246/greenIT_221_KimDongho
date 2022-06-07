package shop;

import java.util.Random;
import java.util.Scanner;
import java.util.Vector;

public class UserManager {
	Random ran = new Random();
	Scanner scan = new Scanner(System.in);
	Vector<User> userList = new Vector<User>(); // 전체 유저 리스트
	int userLog = -1;

	UserManager() {
		init();
	}

	void init() {
		String[] a = { "김", "박", "이", "최", "정", "오" };
		String[] b = { "철", "병", "만", "여", "아", "영" };
		String[] c = { "수", "욱", "수", "정", "름", "희" };
		for (int i = 0; i < 10; i++) {
			int r = ran.nextInt(a.length);
			String name = a[r];
			r = ran.nextInt(b.length);
			name += b[r];
			r = ran.nextInt(c.length);
			name += c[r];
			User temp = new User(name, ran.nextInt(5000));
			userList.add(temp);
		}
	}

	void join() {
		System.out.println("[가입] id 를 입력하세요.");
		String id = scan.next();
		User temp = new User(id, 0);
		userList.add(temp);
		System.out.println("[메세지] " + temp.id + "님 가입을 축하합니다.");
	}
	
	void joinOut() {
		System.out.println("[탈퇴] id 를 입력하세요.");
		String id = scan.next();
		
		int idx = -1;
		
		for(int i=0; i<userList.size(); i++) {
			if(id.equals(userList.get(i).id)) {
				idx = i;
			}
		}
		
		if(idx != -1) {
			System.out.println("[메세지] " + id + "님의 회원정보가 삭제되었습니다.");
			userList.remove(idx);
		}
		else System.out.println("[메세지] 일치하는 회원정보가 없습니다.");
	}

	boolean logIn() {
		userLog = -1;
		System.out.println("[로그인] id 를 입력하세요.");
		String id = scan.next();
		for (int i = 0; i < userList.size(); i++) {
			if (id.equals(userList.get(i).id)) {
				userLog = i;
				break;
			}
		}
		if (userLog == -1) {
			System.out.println("[메세지] 없는 id 입니다.");
		} else {
			System.out.println("[메세지] " + userList.get(userLog).id + "님 로그인.");
			return true;
		}
		return false;
	}

	void logOut() {
		if (userLog != -1) {
			System.out.println("[메세지] " + userList.get(userLog).id + "님 로그아웃.");
		}
		userLog = -1;
	}

	void printUser() {
		for (int i = 0; i < userList.size(); i++) {
			System.out.print("[" + i + "] ");
			userList.get(i).print();
		}
	}
	
	void addUser() {
		System.out.println("[유저 추가] 추가할 유저 ID를 입력하세요.");
		String id = scan.next();
		
		if(userCheck(id) == -1) {
			System.out.println("초기 금액값을 입력하세요.");
			int money = scan.nextInt();
			User temp = new User(id, money);
			userList.add(temp);
			System.out.println("유저 '" + id + "' 가 추가되었습니다.");
		}
		else if(userCheck(id) >= 0) {
			System.out.println("이미 존재하는 유저 ID 입니다.");
		}
	}
	
	void removeUser() {
		System.out.println("[유저 삭제] 삭제할 유저 ID를 입력하세요.");
		String delId = scan.next();
		
		if(userCheck(delId) >= 0) {
			userList.remove(userCheck(delId));
			System.out.println("유저 '" + delId + "' 가 삭제되었습니다.");
		}
		else System.out.println("존재하지 않는 유저 ID 입니다.");
	}
	
	int userCheck(String delId) {
		for(int i=0; i<userList.size(); i++) {
			if(delId.equals(userList.get(i).id)) {
				return i;
			}
		}
		return -1;
	}
	
}
