package ss.week3.hotel;

public class Safe {
	public boolean opened;
	public boolean active;
	
	public Safe() {
		opened = false;
		active = false;
	}
	
	public void activate() {
		active = true;
	}
	
	
	public void deactivate() {
		active = false;
	}
	
	public void open() {
		opened = true;
	}
	
	public void close() {
		opened = false;
	}
	
	public boolean isActive() {
		return active;
	}
	
	public boolean isOpen() {
		return opened;
	}
}
