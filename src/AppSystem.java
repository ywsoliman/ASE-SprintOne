
import java.util.ArrayList;

public class AppSystem {

	ArrayList<Member> members;
	
	public AppSystem() {
		members = new ArrayList<Member>();
	}
	
	public void registerMember() {
		
	}
	
	public void printMemebers() {
		for (Member m : members)
			System.out.println(m);
	}
		

	
}
