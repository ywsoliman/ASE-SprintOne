import java.util.Scanner;

public class Menu {

	public void menu() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("\t\tWelcome to Uber\t\t");
		System.out.println("1- Login");
		System.out.println("2- Signup");
		
		while (true) {
			
			int input;
			input = sc.nextInt();
			
			System.out.println("1- Driver");
			System.out.println("2- User");
			
			switch(input) {
			
			case 1:
				break;
			case 2:
				break;
				
			}
				
		}
	}
	
}
