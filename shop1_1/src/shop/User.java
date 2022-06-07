package shop;

public class User {
	String id;
	int money;

	public User(String id, int mo) {
		this.id = id;
		money = mo;
	}

	public void print() {
		System.out.println("[" + id + "] " + "금액 :  " + money);
	}
}
