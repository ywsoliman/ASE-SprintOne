import java.util.ArrayList;

public class ArrayStrategy implements SaveStrategy{
	
	AppSystem system;
	ArrayList<User> users = new ArrayList<User>();
	ArrayList<Driver> drivers = new ArrayList<Driver>();

	public ArrayStrategy(AppSystem system) {
		this.system = system;
	}

	@Override
	public void save(Member member) {
		if (member instanceof Driver) {
			system.retrieveDrivers().add((Driver) member);
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
		ArrayList<Driver> pendingRegistrations = new ArrayList<Driver>();
		for(Driver driver : drivers) {
			if(!driver.verified) {
				pendingRegistrations.add(driver);
			}
		}
		return pendingRegistrations;
	}

	@Override
	public ArrayList<User> retrieveUsers() {
		return users;
	}

}
