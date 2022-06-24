package rpg_final_test;

public abstract class Stage {
	
	public abstract boolean update(User user);

	public abstract void init();
	
	public abstract FileManager dataManager();
	
}
