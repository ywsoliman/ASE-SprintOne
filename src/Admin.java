
public class Admin {
	AppSystem system;
	
	public Admin(AppSystem system) {
		this.system = system;
	}
	public void verifyDriver(Driver driver) {
		driver.setVerified(true);
		system.update(driver);
	}
	public void suspend(Member member) {
		member.setSuspended(true);
	}
	public void listPendingRegistrations() {
		for(Driver driver : system.retrievePendingRegistrations()) {
			System.out.println(driver.toString());
		}
	}
}
