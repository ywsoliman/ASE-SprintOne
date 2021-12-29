import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class User extends Member implements Observable {
	ArrayList<Driver> interestedDrivers = new ArrayList<Driver>();
	HashMap<Driver, Double> offers = new HashMap<Driver, Double>();

	public User(String username, String password, String email, String mobileNumber) {
		super(username, password, email, mobileNumber);
	}
	
//	public void requestRide(String source, String destination) {
//		
//	}

	@Override
	public void subscribe(String source, String destination, AppSystem system) {
		
		for(Driver driver : system.retrieveDrivers()) {
			
			if(driver.getFavoriteAreas().contains(source) && !driver.isSuspended() && driver.isVerified()) {
				interestedDrivers.add(driver);
			}
		}
	}
	
	
	public void acceptOffer(Driver driver) {
		// Working until here.
		System.out.println("Please rate the driver from 1 to 5");
		
		Scanner input = new Scanner(System.in);
		double rating = input.nextDouble();
		input.nextLine();
		
		while(rating < 1 || rating > 5) {
			System.out.println("Invalid rating. Please enter a number from 1 to 5.");
			rating = input.nextDouble();
			input.nextLine();
		}
		
		rateDriver(driver, rating);
		for (Driver d : interestedDrivers) {
			d.getNearbyRequests().remove(this);
		}
		
		interestedDrivers.clear();
	}
	
	
	public HashMap<Driver, Double> getOffers() {
		return offers;
	}
	
	public void listOffers() {
		for(HashMap.Entry<Driver, Double> entry : offers.entrySet()) {
			System.out.println("Driver: " + entry.getKey().getUsername() + " Average Rating:  " + entry.getKey().getAverageRating() + " Offer: $" + entry.getValue());
		}
	}
	
	public void rateDriver(Driver driver, double rating) {
		driver.getUserRatings().put(this.getUsername(), rating);
		double sum = 0.0;
		for (Map.Entry<String, Double> entry : driver.getUserRatings().entrySet()) {
			sum += entry.getValue();
		}
		driver.setAverageRating(sum / driver.getUserRatings().size());
	}

	@Override
	public void unsubscribe(Observer o) {
		
		interestedDrivers.remove((Driver) o); 
	}
	@Override
	public void requestRide() {
		//ride = this;
		
		for (Driver driver : interestedDrivers) {
			
			driver.update(this);
		}
	}
	
}
