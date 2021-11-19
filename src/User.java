
public class User extends Member {
	
	public User(String username, String mobileNumber, String email, String password) {
		super(username, mobileNumber, email, password);
	}

	public void requestRide() {
		
	}
	
	@Override
	public String toString() {
		return "Username: " + this.getUsername() + "\nMobile Number: " + this.getMobileNumber() + "\nEmail: " + this.getEmail() + "\nPassword: " + this.getPassword() + "\n";
	}
	
//	@Override
//	public void register() {
//		
//	}
	
}
