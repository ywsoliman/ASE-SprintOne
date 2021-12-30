
public class Admin {
	AppSystem system;
	
	public Admin(AppSystem system) {
		this.system = system;
	}
	public void verifyDriver(Driver driver) {
		driver.setVerified(true);
	}
	public void suspend(Member member) {
		member.setSuspended(true);
	}
	public void listPendingRegistrations() {
		for(Driver driver : system.retrievePendingRegistrations()) {
			System.out.println(driver.toString());
		}
	}
	public void listRides() {
		for(Ride ride : system.retrieveRides()) {
			System.out.println(ride.toString());
		}
	}
	public void addDiscountedArea(String destination) {
		system.addDiscountedArea(destination);
	}
}
