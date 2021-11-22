import java.util.ArrayList;
import java.util.HashMap;

public class Driver extends Member implements Observer {
	
	String nationalID;
	String drivingLicense;
	boolean verified;
	User user;
	double averageRating;
	//float rating;
	ArrayList<String> favoriteAreas = new ArrayList<String>();
	ArrayList<User> nearbyRequests = new ArrayList<User>();
	HashMap<String, Double> userRatings = new HashMap<String, Double>();
	

	public Driver(String username, String password, String email, String mobileNumber, String nationalID,
			String drivingLicense) {
		super(username, password, email, mobileNumber);
		this.nationalID = nationalID;
		this.drivingLicense = drivingLicense;
		this.verified = false;
		this.averageRating = 0.0;
		//ride.subscribe(this);
	}
	

	public HashMap<String, Double> getUserRatings() {
		return userRatings;
	}


	public ArrayList<User> getNearbyRequests() {
		return nearbyRequests;
	}


	public double getAverageRating() {
		return averageRating;
	}

	public void setAverageRating(double averageRating) {
		this.averageRating = averageRating;
	}

	public String getNationalID() {
		return nationalID;
	}
	public void setNationalID(String nationalID) {
		this.nationalID = nationalID;
	}
	public String getDrivingLicense() {
		return drivingLicense;
	}
	public void setDrivingLicense(String drivingLicense) {
		this.drivingLicense = drivingLicense;
	}
	public boolean isVerified() {
		return verified;
	}
	public void setVerified(boolean verified) {
		this.verified = verified;
	}
	public void addFavArea(String area) {
		favoriteAreas.add(area);
	}
	public ArrayList<String> getFavoriteAreas() {
		return favoriteAreas;
	}
	
	public void makeOffer(User user, double price) {
		user.getOffers().put(this, price);
	}
	
	public void listUserRatings() {
		for(HashMap.Entry<String, Double> entry : userRatings.entrySet()) {
			System.out.println("User: " + entry.getKey() + " Rating:  " + entry.getValue());
		}
	}

	@Override
	public String toString() {
		return "Driver [nationalID=" + nationalID + ", drivingLicense=" + drivingLicense + ", verified=" + verified
				+ ", username=" + username + ", password=" + password + ", email=" + email + ", mobileNumber="
				+ mobileNumber + ", suspended=" + suspended + "]";
	}	

	public User getUser() {
		return user;
	}

	@Override
	public void update(User user) {
		this.user = user;
		nearbyRequests.add(user);
	}
	
	
}
