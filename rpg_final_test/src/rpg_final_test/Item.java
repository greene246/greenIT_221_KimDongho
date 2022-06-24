package rpg_final_test;

public  class Item {
	private String name;
	private int power;
	private int price;
	private boolean equiped;
	
	public Item(String name, int power, int price) {
		this.name = name;
		this.power = power;
		this.price = price;
		this.equiped = false;
	}
	
	public Item(String name, int power, int price, int equiped) {
		this.name = name;
		this.power = power;
		this.price = price;
		if(equiped == 1)
			this.equiped = true;
		else
			this.equiped = false;
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
	
	public boolean isEquiped() {
		return equiped;
	}

	public void setEquiped(boolean equiped) {
		this.equiped = equiped;
	}

	@Override
	public String toString() {
		String str = "";
		str = String.format("[%s] [공격력 : %d] [가격 : %d] [장착 중 : %b]", this.name, this.power, this.price / 2, this.equiped);
		return str;
	}
	
	public String shopItem() {
		String str = "";
		str = String.format("[%s] [공격력 : %d] [가격 : %d]", this.name, this.power, this.price);
		return str;
	}
}
