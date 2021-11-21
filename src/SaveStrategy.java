import java.util.ArrayList;

public interface SaveStrategy {
	public void save(Member member);
	public ArrayList<Driver> retrieveDrivers();
	public ArrayList<Driver> retrievePendingRegistrations();
	public ArrayList<User> retrieveUsers();
}
