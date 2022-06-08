package shop1_2;

public class Cart {
	private String userId, itemName;
	
	public Cart(String userId, String itemName) {
		this.userId = userId;
		this.itemName = itemName;
	}

	public String getUserId() {
		return userId;
	}

	public String getItemName() {
		return itemName;
	}
	
}
