import java.util.ArrayList;

public class Driver extends Member implements Observer {
	
	String nationalID;
	String drivingLicense;
	boolean verified;
	User user;
	//float rating;
	ArrayList<String> favoriteAreas = new ArrayList<String>();
	

	public Driver(String username, String password, String email, String mobileNumber, String nationalID,
			String drivingLicense) {
		super(username, password, email, mobileNumber);
		this.nationalID = nationalID;
		this.drivingLicense = drivingLicense;
		this.verified = false;
		//ride.subscribe(this);
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
		
	}
	
	
}
