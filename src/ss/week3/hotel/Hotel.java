package ss.week3.hotel;

import java.util.ArrayList;

import ss.week3.bill.Bill;
import ss.week3.bill.Printer;

public class Hotel {
	public static double ROOM_PRICE = 30.0f;
	public static double SAFE_PRICE = 10.0f;
	private String name;
	private PricedRoom r1;
	private Room r2;
	
	private ArrayList<Guest> guests = new ArrayList<Guest>();
	
	/**
	 * Creates a hotel with name <code>name</code>
	 * @param name Name of the hotel
	 */
	public Hotel(String name) {
		this.name = name;
		r1 = new PricedRoom(1, ROOM_PRICE, SAFE_PRICE);
		r2 = new Room(2);
	}
	
	public Bill getBill(String guest, int nNights, Printer printer) {
		if (r1.getGuest() != null && r1.getGuest().getName().equals(guest)) {
			Bill bill = new Bill(printer);
			
			for (int i = 0; i < nNights; i++) {
				bill.addItem(r1);
			}
			
			bill.addItem((Bill.Item)r1.getSafe());
			bill.close();
			return bill;
		}else {
			return null;
		}
	}
	
	/**
	 * Gets the name of the hotel.
	 * @return <code>name</code> of the hotel
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Sets the name of the hotel.
	 * @param name Name of the hotel.
	 * @ensures getName() == name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Get a <code>Room</code> that has no guest.
	 * @return <code>Room</code> with <code>Room.getGuest() == null</code>
	 */
	public Room getFreeRoom() {
		if (r1.getGuest() == null) {
			return r1;
		}else if (r2.getGuest() == null) {
			return r2;
		}else {
			return null;
		}
	}
	
	private boolean guestExistsWithName(String name) {
		boolean exists = false;
		for (int i = 0; i < guests.size(); i++) {
			if (guests.get(i).getName() == name) {
				exists = true;
			}
		}
		return exists;
	}
	
	private void removeGuestFromList(Guest guest) {
		for (int i = 0; i < guests.size(); i++) {
			if (guests.get(i).getName() == guest.getName()) {
				guests.remove(i);
			}
		}
	}
	
	/**
	 * Checks in a guest with name <code>name</code>.
	 * @param name Name of the guest.
	 * @requires There exists an empty room.
	 * @ensures <code>Room.getGuest().getName() == name</code>
	 * @invariant if (There exists an empty room) then (Room.getGuest().getName() == name)
	 * @return The room the guest was checked-in in.
	 */
	public Room checkIn(String name) {
		Room emptyRoom = getFreeRoom();
		if (emptyRoom != null) {
			if (!guestExistsWithName(name)) {
				Guest g = new Guest(name);
				g.checkin(emptyRoom);
				guests.add(g);
				System.out.println(name+" has been checked in to room "+emptyRoom.getNumber());
				return emptyRoom;
			}else {
				System.out.println("There already exists a guest with this name");
				return null;
			}
			
		}else {
			System.out.println("There are no empty room");
			return null;
		}
		
	}
	
	/**
	 * Checks out guest with name <code>name</code>.
	 * @param name Name of the guest
	 * @requires There exists a checked in guest with name <code>name</code>
	 * @ensures <code>Room.getGuest() == null</code>
	 * @invariant if (There exists a checked in guest with name <code>name</code>) then (Room.getGuest() == null)
	 */
	public void checkOut(String name) {
		if (r1.getGuest() != null && r1.getGuest().getName().equals(name)) {
			removeGuestFromList(r1.getGuest());
			r1.getGuest().checkout();
			r1.getSafe().deactivate();
			System.out.println(name+" has been checked out from room "+r1.getNumber());
		}else if (r2.getGuest() != null && r2.getGuest().getName().equals(name)) {
			removeGuestFromList(r2.getGuest());
			r2.getGuest().checkout();
			r2.getSafe().deactivate();
			System.out.println(name+" has been checked out from room "+r2.getNumber());
		}else {
			System.out.println(name+" doesn't have a room");
		}
	}
	
	/**
	 * Get the room in which guest with name <code>name</code> exists.
	 * @param name Name of the guest.
	 * @requires Guest with name <code>name</code> has a room.
	 * @return <code>Room</code> in which the guest with name <code>name</code> exists.
	 */
	public Room getRoom(String name) {
		if (r1.getGuest() != null && r1.getGuest().getName().equals(name)) {
			return r1;
		}
		else if (r2.getGuest() != null && r2.getGuest().getName().equals(name)) {
			return r2;
		}else {
			System.out.println(name+" is not a guest at this hotel.");
			return null;
		}
	}
	
	/**
	 * Returns description of the hotel.
	 * @return Description of the hotel.
	 */
	public String toString() {
		String info = "";
		
		if (r1.getGuest() != null) {
			info = info + "Room: "+r1.getNumber()+" occupied by: "+r1.getGuest().getName()+". Room's safe is active: " +r1.getSafe().isActive() +"\n";
		}else {
			info = info + "Room: "+r1.getNumber()+" occupied by: NULL. Room's safe is active: " +r1.getSafe().isActive() +"\n";
		}
		
		if (r2.getGuest() != null) {
			info = info + "Room: "+r2.getNumber()+" occupied by: "+r2.getGuest().getName()+". Room's safe is active: " +r2.getSafe().isActive() +"\n";
		}else {
			info = info + "Room: "+r2.getNumber()+" occupied by: NULL. Room's safe is active: " +r2.getSafe().isActive() +"\n";
		}
		
		return info;
	}
}
