import java.util.ArrayList;

public class AppSystem {
	
	SaveStrategy saveStrategy;

	
	public void setSaveStrategy(SaveStrategy saveStrategy) {
		this.saveStrategy = saveStrategy;
	}
	public void saveUser(User user) {
		saveStrategy.saveUser(user);
	}
	public void saveDriver(Driver driver) {
		saveStrategy.saveDriver(driver);
	}
	public ArrayList<Driver> retrievePendingRegistrations() {
		return saveStrategy.retrievePendingRegistrations();
	}
	public ArrayList<User> retrieveUsers() {
		return saveStrategy.retrieveUsers();
	}
	public ArrayList<Driver> retrieveDrivers() {
		return saveStrategy.retrieveDrivers();
	}


	public static void main(String[] args) {

		Menu menu = new Menu();
		
	}
}
