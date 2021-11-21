/*
public class RegisterUser implements RegistrationStrategy {

	AppSystem system;
	
	
	
	public RegisterUser(AppSystem system) {
		super();
		this.system = system;
	}



	@Override
	public void register(Member member) {
		//system.getUsers().add((User) member);
		system.save(member);
	}

}
*/