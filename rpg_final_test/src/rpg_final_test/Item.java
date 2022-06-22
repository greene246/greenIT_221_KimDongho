package rpg_final_test;

public  class Item {
	private String name;
	private int power;
	private int price;
	
	public Item(String name, int power, int price) {
		this.name = name;
		this.power = power;
		this.price = price;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		String str = "";
		str = String.format("[%s] [공격력 : %d] [가격 : %d]", this.name, this.power, this.price);
		return str;
	}
}
