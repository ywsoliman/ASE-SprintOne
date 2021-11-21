import java.util.ArrayList;

public class Driver extends Member {
	
	String nationalID;
	String drivingLicense;
	boolean verified;
	//float rating;
	//ArrayList<String> favoriteAreas = new ArrayList<String>();
	
	
	public Driver(String username, String password, String email, String mobileNumber, String nationalID,
			String drivingLicense) {
		super(username, password, email, mobileNumber);
		this.nationalID = nationalID;
		this.drivingLicense = drivingLicense;
		this.verified = false;
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

	@Override
	public String toString() {
		return "Driver [nationalID=" + nationalID + ", drivingLicense=" + drivingLicense + ", verified=" + verified
				+ ", username=" + username + ", password=" + password + ", email=" + email + ", mobileNumber="
				+ mobileNumber + ", suspended=" + suspended + "]";
	}
	
	
}
