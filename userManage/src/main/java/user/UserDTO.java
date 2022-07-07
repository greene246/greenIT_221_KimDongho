package user;

public class UserDTO {
	
	private String id, pw, name, gender, country, email, mobile;
	private int year, month, day, userCode;
	
	public UserDTO(String id, String pw, String name, int year, int month, int day, String gender, String email, String country, String mobile, int userCode) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.year = year;
		this.month = month;
		this.day = day;
		this.gender = gender;
		this.country = country;
		this.mobile = mobile;
		this.email = email;
		this.userCode = userCode;
	}
	
	public UserDTO(String id, String pw, String name, int year, int month, int day, String gender, String email, String country, String mobile) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.year = year;
		this.month = month;
		this.day = day;
		this.gender = gender;
		this.country = country;
		this.mobile = mobile;
		this.email = email;
	}
	
	public UserDTO(String id, String pw){
		this.id = id;
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getUserCode() {
		return userCode;
	}

	public void setUserCode(int userCode) {
		this.userCode = userCode;
	}
	
	
	
}
