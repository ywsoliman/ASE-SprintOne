
public class Main {

	public static void main(String[] args) {
		
		AppSystem s = new AppSystem();
		Admin admin = new Admin();
		
		Member m1 = new User("Youssef", "010", "@gmail.com", "123123");
		Member m2 = new Driver("Youssef", "010", "@gmail.com", "123123", "32645486", "98976532");
		
		s.members.add(m1);
		
		if (admin.verify(m2))
			s.members.add(m2);
		
		s.printMemebers();

	}

}
