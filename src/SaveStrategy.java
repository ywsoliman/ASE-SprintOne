import java.util.ArrayList;

public interface SaveStrategy {
	public void saveUser(User user);
	public void saveDriver(Driver driver);
	public ArrayList<Driver> retrieveDrivers();
	public ArrayList<Driver> retrievePendingRegistrations();
	public ArrayList<User> retrieveUsers();
}
