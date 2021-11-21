import java.util.ArrayList;

public class AppSystem {
	
	SaveStrategy saveStrategy;

	
	public void setSaveStrategy(SaveStrategy saveStrategy) {
		this.saveStrategy = saveStrategy;
	}
	public void save(Member member) {
		saveStrategy.save(member);
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
		AppSystem system = new AppSystem();
		Admin admin = new Admin(system);
		Login userLogin = new UserLogin(system);
		Login driverLogin = new DriverLogin(system);

		system.setSaveStrategy(new ArrayStrategy(system));
		Member driver = new Driver("abcd", "abcd", "abcd", "abcd", "abcd", "abcd");

		system.save(driver);
		admin.listPendingRegistrations();
		admin.verifyDriver((Driver) driver);
		//admin.suspend(driver);
		admin.listPendingRegistrations();
	
		driverLogin.login("abcd", "abcd");
	}

}
