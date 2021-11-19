
public class Driver extends Member {

	String nationalID, drivingLicense;
	
	public Driver(String username, String mobileNumber, String email, String password, String nationalID, String drivingLicense) {
		super(username, mobileNumber, email, password);
		this.nationalID = nationalID;
		this.drivingLicense = drivingLicense;
	}

//	@Override
//	public void register() {
//		
//	}
	
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
	
	@Override
	public String toString() {
		return "Username: " + this.getUsername() + "\nMobile Number: " + this.getMobileNumber() + "\nEmail: " + this.getEmail() + "\nPassword: " + this.getPassword()
		+ "\nNational ID: " + this.nationalID + "\nDriving License: " + this.drivingLicense;
	}
	
}
