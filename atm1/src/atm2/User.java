package atm2;

public class User {
	String id;
	String password;
	Account[] accList;
	int accCount;
	
	public User(String id, String passowrd) {
		this.id = id;
		this.password = passowrd;
	}
	
	public User(String id, String passowrd, Account[] accList, int accCount) {
		this.id = id;
		this.password = passowrd;
		this.accList = accList;
		this.accCount = accCount;
	}

	public String getId() {
		return id;
	}
	
	public int getAccCount() {
		return accCount;
	}

}
