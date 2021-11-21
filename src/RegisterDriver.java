/*
public class RegisterDriver implements RegistrationStrategy {

	AppSystem system;
	
	
	
	public RegisterDriver(AppSystem system) {
		super();
		this.system = system;
	}



	@Override
	public void register(Member member) {
		//system.getPendingRegistrations().add((Driver) member);
		system.save(member);
	}


}
*/