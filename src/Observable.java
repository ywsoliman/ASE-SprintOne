
public interface Observable {
	public void subscribe(String source, String destination, AppSystem system);
	public void unsubscribe(Observer o);
	public void requestRide();
}
