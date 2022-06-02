package atm;

import java.util.ArrayList;

public class User {
	private int code, accCnt;
	private String id, pw;
	private String name;
	
	public User(int code, String id, String pw, String name) {
		this.code = code;
		this.id = id;
		this.pw = pw;
		this.name = name;
	}


	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public int getAccCnt() {
		return accCnt;
	}

	public void setAccCnt(int accCnt) {
		this.accCnt = accCnt;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
