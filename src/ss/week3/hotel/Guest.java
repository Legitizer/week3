package ss.week3.hotel;

public class Guest {
	private String name;
	private Room room;
	
	/**
	 * Creates a guest with the given name
	 * @param name Name of the guest
	 */
	public Guest(String name) {
		this.name = name;
		this.room = null;
	}
	
	/**
	 * Returns the name of the guest
	 * @return Name of the guest
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * Returns the room that the guest occupies
	 * @return {@code Room} occupied by the guest
	 */
	public Room getRoom() {
		return room;
	}
	
	
	/**
	 * @param room Rents room of type <code>Room</code> to guest
	 * @requires <code>getGuest() == null</code>
	 * @ensures <code>getGuest() == this</code>
	 * @return True if it was successful. False if it was NOT successful.
	 */
	public boolean checkin(Room room) {
		if (room.getGuest() == null) {
			this.room = room;
			room.setGuest(this);
			return true;
		}else {
			System.out.println(room.getNumber() + " is already occupied.");
			return false;
		}
	}
	
	/**
	 * Checks out the guest
	 * @requires <code>this.room != null</code>
	 * @return Whether it was successful.
	 */
	public boolean checkout() {
		if (room != null) {
			room.setGuest(null);
			room = null;
			return true;
		}
		return false;
	}
	
	/**
	 * Returns a description of the guest.
	 * @return Description of the guest.
	 */
	public String toString() {
		return ("Guest: " + name + ". Occupant of room: "+room.getNumber());
	}
}
