
public class Ride implements Observable {
	String source;
	String destination;
	@Override
	public void subscribe(Observer o) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void unsubscribe(Observer o) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void notifyDrivers(Ride ride) {
		ride = this;
	}
}
