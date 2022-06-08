package shop1_2;

public class Item {
	private String name, category;
	private int price;
	
	public Item(String name, String category, int price) {
		this.name = name;
		this.category = category;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public int getPrice() {
		return price;
	}
	
	
}
