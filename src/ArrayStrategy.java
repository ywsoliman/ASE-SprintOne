import java.util.ArrayList;

public class ArrayStrategy implements SaveStrategy{
	
	AppSystem system;
	ArrayList<User> users = new ArrayList<User>();
	ArrayList<Driver> drivers = new ArrayList<Driver>();
	ArrayList<Driver> pendingRegistrations = new ArrayList<Driver>();

	public ArrayStrategy(AppSystem system) {
		this.system = system;
	}

	@Override
	public void save(Member member) {
		if (member instanceof Driver) {
			system.retrievePendingRegistrations().add((Driver) member);
		}
		else if (member instanceof User) {
			system.retrieveUsers().add((User) member);
		}
	}

	@Override
	public ArrayList<Driver> retrieveDrivers() {
		return drivers;
	}

	@Override
	public ArrayList<Driver> retrievePendingRegistrations() {
		return pendingRegistrations;
	}

	@Override
	public ArrayList<User> retrieveUsers() {
		return users;
	}

	@Override
	public void update(Driver driver) {
		system.retrievePendingRegistrations().remove(driver);
		system.retrieveDrivers().add(driver);
	}

}
