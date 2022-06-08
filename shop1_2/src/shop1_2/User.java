package shop1_2;

public class User {
	int money;
	private String id, pw;
	
	public User(int money, String id, String pw) {
		this.money = money;
		this.id = id;
		this.pw = pw;
	}

	public int getMoney() {
		return money;
	}


	public void setMoney(int money) {
		this.money = money;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}
	
}