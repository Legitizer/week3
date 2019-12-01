package ss.week3.hotel;

import static ss.utils.TextIO.*;

import ss.week3.bill.Bill;
import ss.week3.bill.StringPrinter;

public class HotelTUI {
	private static final String IN = "i";
	private static final String OUT = "o";
	private static final String ROOM = "r";
	private static final String ASAFE = "a";
	private static final String GBILL = "b";
	private static final String HELP = "h";
	private static final String PRINT = "p";
	private static final String EXIT = "x";
	
	private Hotel hotel;
	
	private boolean exitRequested = false;
	
	public HotelTUI(String name) {
		hotel = new Hotel(name);
	}
	
	private boolean getBillOfGuest(String name, String nights) {
		int nNights = 0;
		try {
			nNights = Integer.parseInt(nights);
		}catch(Exception e) {
			System.out.println(nights+" is not a valid value for number of nights. Please try again or type 'h' for HELP");
			return false;
		}
		
		Bill bill = hotel.getBill(name, nNights, new StringPrinter());
		if (bill != null) {
			System.out.println(bill.getPrinter().getResult());
		}else {
			System.out.println(name+" is not a guest at this hotel");
			return false;
		}
		return true;
	}
	
	public void start() {
		System.out.println("Welcome to the Hotel booking system of "+ hotel.getName());
		printHelpMenu();
		
		while (!exitRequested) {
			String input = getln();
			String[] splitTxt = input.split(" ");
			
			if (splitTxt.length == 2) {
				String c1 = splitTxt[0].toLowerCase();
				String c2 = splitTxt[1].toLowerCase();
				
				switch(c1) {
				case IN:
					hotel.checkIn(c2);
					break;
				case OUT:
					hotel.checkOut(c2);
					break;
				case ROOM:
					Room room = hotel.getRoom(c2);
					System.out.println(c2 + " has room number "+room.getNumber()+".");
					break;
				default:
					System.out.println("Command not recognized. Please try again or type 'h' for HELP");
				}
			}else if(splitTxt.length == 1) {
				String c1 = splitTxt[0].toLowerCase();
				
				switch(c1) {
				case HELP:
					printHelpMenu();
					break;
				case PRINT:
					System.out.println("Hotel name: "+hotel.getName());
					break;
				case EXIT:
					exitRequested = true;
					System.out.println("Exiting Application...");
					break;
				default:
					System.out.println("Command not recognized. Please try again or type 'h' for HELP");
				}
			}else if (splitTxt.length == 3) {
				String c1 = splitTxt[0].toLowerCase();
				String c2 = splitTxt[1].toLowerCase();
				String c3 = splitTxt[2].toLowerCase();
				
				switch(c1) {
				case ASAFE:
					Room room = hotel.getRoom(c2);
					if (room != null) {
						PricedSafe safe = (PricedSafe)room.getSafe();
						if (safe != null) {
							boolean success = safe.activate(c3);
							if (success) {
								System.out.println(c2+"'s safe has been activated.");
							}else {
								System.out.println("Wrong password. Please try again or type 'h' for HELP");
							}
						}else {
							System.out.println(c2+" does not have a safe.");
						}
					}else {
						System.out.println(c2+" is not a guest at this hotel.");
					}
					break;
				case GBILL:
					boolean success = getBillOfGuest(c2, c3);
					
					break;
				default:
					System.out.println("Command not recognized. Please try again.");
				}
			}
			else {
				System.out.println("Command not recognized. Please try again or type 'h' for HELP");
			}
		}
	}
	
	public void printHelpMenu() {
		System.out.println("Welcome to the Hotel booking system of "+hotel);
		System.out.println("Commands:");
		System.out.println("i name ........... check in guest with name");
		System.out.println("o name ........... check out guest with name");
		System.out.println("r name ........... request room of quest");
		System.out.println("a name password .. activate safe -password needed-");
		System.out.println("b name nights .... print bill for guest for the number of nights");
		System.out.println("h ................ help");
		System.out.println("p ................ print state");
		System.out.println("x ................ exit");
		
	}
	
	public static void main(String[] args) {
		(new HotelTUI("U_Parkhotel")).start();
		System.out.println("Application has exited successfully.");
	}
}
