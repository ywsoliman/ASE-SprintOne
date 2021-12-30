import java.util.HashMap;
import java.util.Scanner;

public class Menu {
	
	Scanner sc = new Scanner(System.in);
	
	AppSystem system = new AppSystem();
	Admin admin = new Admin(system);
	
	Login driverLogin = new DriverLogin(system);
	Login userLogin = new UserLogin(system);
	
	User user;
	Driver driver;
	
	public Menu() {
		try {
			menu();
		}
		catch(Exception e) {
			System.out.println("Unknown error occured. Restarting application.");
			menu();
		}
	}
	
	public void menu() {
		
		system.setSaveStrategy(new ArrayStrategy(system));
				
		while (true) {
			
			System.out.println("Welcome to Uber");
			System.out.println("1- Login");
			System.out.println("2- Signup");
			System.out.println("3- Login as Admin");
			System.out.println("4- Exit");
			
			int input;
			input = sc.nextInt();
			
			if (input == 1 || input == 2) {
				System.out.println("1- User");
				System.out.println("2- Driver");
				
				int type = sc.nextInt();
				
				while (true) {
					if (type == 1 || type == 2)
						break;
					else {
						System.out.println("Please enter a valid number.");
						type = sc.nextInt();
					}
						
				}
				
				sc.nextLine();
				
				String username, password;
				System.out.print("Enter Username: ");
				username = sc.nextLine();
				System.out.print("Enter Password: ");
				password = sc.nextLine();
				
				if (input == 1) {
					
					if (type == 1) {
						try {
							user = (User) userLogin.login(username, password);
							if (!user.isSuspended())
								userMenu();
						}
						catch(Exception e) {
							
						}	
					}
					else if (type == 2) {
						try {
							driver = (Driver) driverLogin.login(username, password);
							if (driver.isVerified() && !driver.isSuspended())
								driverMenu();
						}
						catch(Exception e) {
							
						}	
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
						system.saveUser(user);
					}
					
					if (type == 2) {
						String nationalID, drivingLicense;
						
						System.out.print("Enter National ID: ");
						nationalID = sc.nextLine();
						System.out.print("Enter drivingLicense: ");
						drivingLicense = sc.nextLine();
						
						driver = new Driver(username, password, email, mobileNumber, nationalID, drivingLicense);
						system.saveDriver(driver);
					}
					System.out.println("Account signed up successfuly!");
					
				}
			}
			else if (input == 3) {
				sc.nextLine();
				String adminUser, adminPass;
				System.out.print("Username: ");
				adminUser = sc.nextLine();
				System.out.print("Password: ");
				adminPass = sc.nextLine();
				
				if (adminUser.equals("admin") && adminPass.equals("admin")) {
					System.out.println("Logged in successfuly.");
					adminMenu();
				}
			}
			else if (input == 4)
				break;
			else
				System.out.println("Enter a valid number.");
				
		}
	}
	
	public void userMenu() {
		while (true) {
			System.out.println("1- Request Ride");
			System.out.println("2- List Offers");
			System.out.println("3- Logout");
			
			int input = sc.nextInt();
			if (input == 1) {
				
				sc.nextLine();
				
				String src, dest;
				System.out.println("Enter source: ");
				src = sc.nextLine();
				System.out.println("Enter destination: ");
				dest = sc.nextLine();
				
				//user.subscribe(src, dest, system);
				user.requestRide(src, dest, system, 50000);
				
			}
			else if (input == 2) {
				user.listOffers();
				System.out.println("Do you want to accept one of these offers?");
				System.out.println("1- Yes");
				System.out.println("2- No");
				int choice = sc.nextInt();
				sc.nextLine();
				
				
				if (choice == 1) {
					System.out.println("Enter driver username: ");
					String acceptedDriver = sc.nextLine();
					for(Offer offer : user.getOffers()) {
						if (offer.driver.username.equals(acceptedDriver)) {
							user.acceptOffer(offer);
							user.getRide().setAcceptedOffer(offer);
							break;
						}
					}
				}
				else if (choice == 2)
					continue;
			}
			else if (input == 3)
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
			System.out.println("4- Logout");
			
			int input = sc.nextInt();
			sc.nextLine();
			
			if (input == 1) {
				System.out.print("Enter your favorite area: ");
				String area = sc.nextLine();
				driver.addFavArea(area);
			}
			else if (input == 2) {
				for (int i = 0; i < driver.getNearbyRequests().size(); i++) {
					System.out.println(i + 1 + ": " + driver.getNearbyRequests().get(i).user.username);
				}
				if (driver.getNearbyRequests().size() > 0) {

					System.out.println("Do you want to make an offer to one of these requests?");
					System.out.println("1- Yes");
					System.out.println("2- No");
					int choice = sc.nextInt();
					sc.nextLine();

					if (choice == 1) {
						System.out.print("Enter the number of the user you want to make an offer to: ");
						int offerTo = sc.nextInt();
						System.out.print("Enter price: ");
						double price = sc.nextDouble();
						sc.nextLine();

						driver.makeOffer(driver.getNearbyRequests().get(offerTo - 1).user, price);

					}
					else if (choice == 2)
						continue;
				}
				else
					System.out.println("No requests available at the moment.");
			}
			else if (input == 3) {
				driver.listUserRatings();
			}
			else if (input == 4)
				break;
			else
				System.out.println("Please enter a valid number.");
			
		}
		
	}
	
	public void adminMenu() {
		while (true) {
			System.out.println("1- Suspend");
			System.out.println("2- Verify Driver");
			System.out.println("3- List Pending Registrations");
			System.out.println("4- Back");
			
			int input = sc.nextInt();
			sc.nextLine();
			
			if (input == 1) {
				System.out.println("1- Suspend User");
				System.out.println("2- Suspend Driver");
				
				int sus = sc.nextInt();
				sc.nextLine();
				
				System.out.println("Enter username to suspend");
				String usernameSus = sc.nextLine();

				if (sus == 1) {
					for (User user : system.retrieveUsers()) {
						if (user.getUsername().equals(usernameSus)) {
							admin.suspend(user);
							break;
						}
					}
				}
				else if (sus == 2) {
					for (Driver driver : system.retrieveDrivers()) {
						if (driver.getUsername().equals(usernameSus)) {
							admin.suspend(driver);
							break;
						}
					}
				}
			}
			
			else if (input == 2) {
				System.out.println("Enter username to verify: ");
				String driverVerify = sc.nextLine();
				
				for (Driver driver : system.retrieveDrivers()) {
					if (driver.getUsername().equals(driverVerify)) {
						admin.verifyDriver(driver);
						break;
					}
				}
			}
			else if (input == 3) {
				admin.listPendingRegistrations();
			}
			else if (input == 4)
				break;
			else
				System.out.println("Please enter a valid number.");
			
		}
	}
	
}
