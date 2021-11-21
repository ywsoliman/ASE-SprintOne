
public interface Observable {
	public void subscribe(Observer o);
	public void unsubscribe(Observer o);
	public void notifyDrivers(Ride ride);
}
