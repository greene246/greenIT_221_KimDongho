package atm;

public class Main {

	public static void main(String[] args) {
		Bank.instance.setName("Green");
		Bank.instance.run();
		
	}
}
