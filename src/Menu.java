import java.util.Scanner;

public class Menu {
	
	Scanner sc = new Scanner(System.in);
	
	AppSystem system = new AppSystem();
	
	Login driverLogin = new DriverLogin(system);
	Login userLogin = new UserLogin(system);
	
	Member user;
	Member driver;
	
	public Menu() {
		menu();
	}
	
	public void menu() {
		
		system.setSaveStrategy(new ArrayStrategy(system));
				
		while (true) {
			
			System.out.println("Welcome to Uber");
			System.out.println("1- Login");
			System.out.println("2- Signup");
			System.out.println("3- Exit");
			
			int input;
			input = sc.nextInt();
			
			if (input == 1 || input == 2) {
				System.out.println("1- User");
				System.out.println("2- Driver");
				
				int type = sc.nextInt();
				
				while (true) {
					if (type == 1 || type == 2)
						break;
					else
						System.out.println("Please enter a valid number.");
				}
				
				sc.nextLine();
				
				String username, password;
				System.out.print("Enter Username: ");
				username = sc.nextLine();
				System.out.print("Enter Password: ");
				password = sc.nextLine();
				
				if (input == 1) {
					
					if (type == 1) {
						userLogin.login(username, password);
						userMenu();
					}
					else if (type == 2) {
						driverLogin.login(username, password);
						driverMenu();
					}
				}
				
				if (input == 2) {
					String email, mobileNumber;
					
					System.out.print("Enter Email: ");
					email = sc.nextLine();
					System.out.print("Enter Mobile Number: ");
					mobileNumber = sc.nextLine();
					
					if (type == 1) {
						user = new User(username, password, email, mobileNumber);
						system.save(user);
					}
					
					if (type == 2) {
						String nationalID, drivingLicense;
						
						System.out.print("Enter National ID: ");
						nationalID = sc.nextLine();
						System.out.print("Enter drivingLicense ID: ");
						drivingLicense = sc.nextLine();
						
						driver = new Driver(username, password, email, mobileNumber, nationalID, drivingLicense);
						system.save(driver);
					}
					System.out.println("Account signed up successfuly!");
					
				}
				
			}
			else if (input == 3)
				break;
			else
				System.out.println("Enter a valid number.");
				
		}
	}
	
	public void userMenu() {
		while (true) {
			System.out.println("1- Request Ride");
			System.out.println("2- Back");
			
			int input = sc.nextInt();
			if (input == 1) {
				
			}
			else if (input == 2)
				break;
			else
				System.out.println("Please enter a valid number.");
		}
	}
	
	public void driverMenu() {
		
		while (true) {
			System.out.println("1- Add favorite area");
			System.out.println("2- List all available rides");
			System.out.println("3- List user ratings");
			System.out.println("4- Back");
			
			int input = sc.nextInt();
			sc.nextLine();
			
			if (input == 1) {
				
			}
			else if (input == 2) {
				
			}
			else if (input == 4)
				break;
			else
				System.out.println("Please enter a valid number.");
			
		}
		
	}
	
}
