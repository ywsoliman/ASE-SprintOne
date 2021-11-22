import java.util.ArrayList;

public class User extends Member implements Observable {
	ArrayList<Driver> interestedDrivers = new ArrayList<Driver>();

	public User(String username, String password, String email, String mobileNumber) {
		super(username, password, email, mobileNumber);
	}
	
//	public void requestRide(String source, String destination) {
//		
//	}

	@Override
	public void subscribe(String source, String destination, AppSystem system) {
		
		for(Driver driver : system.retrieveDrivers()) {
			
			if(driver.favoriteAreas.contains(source) && !driver.isSuspended() && driver.isVerified()) {
				interestedDrivers.add(driver);
			}
		}
		//interestedDrivers.add((Driver) o);
	}
	@Override
	public void unsubscribe(Observer o) {
		
		interestedDrivers.remove((Driver) o); 
	}
	@Override
	public void requestRide() {
		//ride = this;
		
		for (Driver driver : interestedDrivers) {
			
			driver.update(this);
		}
	}
	
}
