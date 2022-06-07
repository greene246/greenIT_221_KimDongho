package shop;

import java.util.Scanner;

public class Shop {
	private Scanner scan = new Scanner(System.in);
	private ItemManager im = new ItemManager();
	private UserManager um = new UserManager();

	public void mainMenu() {
		boolean run = true;
		while (run) {
			System.out.println("[1.가입] [2.탈퇴] [3.로그인] [4.로그아웃]\n" + "[100.관리자] [0.종료]");
			int sel = scan.nextInt();
			if (sel == 1) {
				um.join();
			}
			else if(sel == 2) {
				um.joinOut();
			}
			else if (sel == 3) {
				if (um.logIn()) {
					loginMenu();
				}
			} else if (sel == 4) {
				um.logOut();
			} else if (sel == 100) {
				managerMenu();
			}
		}
	}

	public void loginMenu() {
		boolean run = true;
		while (run) {
			System.out.println("[1.쇼핑] [2.장바구니목록] [0.뒤로가기]");
			int sel = scan.nextInt();
			if (sel == 1) {
				shopMenu();
			} else if (sel == 2) {
				cartMenu();
			} else if (sel == 0) {
				break;
			}
		}
	}

	public void cartMenu() {
		boolean run = true;
		while (run) {
			System.out.println("[1.내 장바구니] [2.삭제] [3.구입] [0.뒤로가기]");
			int sel = scan.nextInt();
			if (sel == 1) {
				im.printJang(UserManager.userList.get(um.userLog));
			} else if (sel == 2) {
				im.delMyItem();
			} else if (sel == 3) {
				im.purchase(UserManager.userList.get(um.userLog));
			} else if (sel == 0) {
				break;
			}
		}
	}

	public void shopMenu() {
		boolean run = true;
		while (run) {
			im.printCategory();
			System.out.println("[카테고리] 번호를 입력하세요.[종료.-1]");
			int caID = scan.nextInt();
			if (caID == -1)
				break;
			if(caID < ItemManager.category.size()) {
				System.out.println("[아이템] 번호를 입력하세요.");
				im.printItemList(caID);
				int itID = scan.nextInt();
				if(itID < ItemManager.n) {
					im.addCart(UserManager.userList.get(um.userLog).id, caID, itID);
				}
				else System.out.println("없는 아이템 번호");
			}
			else System.out.println("없는 카테고리 번호");
		}
	}

	public void managerMenu() {
		boolean run = true;
		while (run) {
			System.out.println("[1.아이템관리] [2.카테고리관리] [3.장바구니관리] [4.유저관리] [0.뒤로가기]");
			int sel = scan.nextInt();
			if (sel == 1) {
				itemMenu();
			} else if (sel == 2) {
				categoryMenu();
			} else if (sel == 3) {
				jangMenu();
			} else if (sel == 4) {
				userMenu();
			} else if (sel == 0) {
				run = false;
			}
		}
	}
	
	public void jangMenu() {
		boolean run = true;
		while (run) {
			System.out.println("[1.전체 장바구니] [2.장바구니 삭제] [0.뒤로가기]");
			int sel = scan.nextInt();
			if (sel == 1) {
				im.printJang();
			} else if (sel == 2) {
				im.removeJang();
			} else if (sel == 3) {
				im.removeCategory();
			} else if (sel == 0) {
				run = false;
			}
		}
	}

	public void categoryMenu() {
		boolean run = true;
		while (run) {
			System.out.println("[1.전체카테고리] [2.카테고리추가] [3.카테고리삭제] [0.뒤로가기]");
			int sel = scan.nextInt();
			if (sel == 1) {
				im.printCategory();
			} else if (sel == 2) {
				im.addCategory();
			} else if (sel == 3) {
				im.removeCategory();
			} else if (sel == 0) {
				run = false;
			}
		}
	}

	public void itemMenu() {
		boolean run = true;
		while (run) {
			System.out.println("[1.전체아이템] [2.아이템추가] [3.아이템삭제] [0.뒤로가기]");
			int sel = scan.nextInt();
			if (sel == 1) {
				im.printItemList();
			} else if (sel == 2) {
				im.addItem();
			} else if (sel == 3) {
				im.removeItem();
			} else if (sel == 0) {
				run = false;
			}
		}
	}

	public void userMenu() {
		boolean run = true;
		while (run) {
			System.out.println("[1.전체유저] [2.유저추가] [3.유저삭제] [0.뒤로가기]");
			int sel = scan.nextInt();
			if (sel == 1) {
				um.printUser();
			} else if (sel == 2) {
				um.addUser();
			} else if (sel == 3) {
				um.removeUser();
			} else if (sel == 0) {
				run = false;
			}
		}
	}
}

