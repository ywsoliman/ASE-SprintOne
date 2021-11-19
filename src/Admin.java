
public class Admin {
	
	AppSystem s;
	
	public void suspend(iMember m) {
		
	}
	
	public boolean verify(Member m) {
		if (m instanceof Driver) {
			// Condition
			return true;
		}
		else if (m instanceof User)
			return true;
		
		return false;
	}
	
}
