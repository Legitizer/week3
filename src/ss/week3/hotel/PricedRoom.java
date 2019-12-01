package ss.week3.hotel;

import ss.week3.bill.Bill;

public class PricedRoom extends Room implements Bill.Item{

	private double amount;
	
	public PricedRoom(int number, double roomPrice, double safePrice) {
		super(number, new PricedSafe(safePrice));
		this.amount = roomPrice;
	}

	@Override
	public double getAmount() {
		return this.amount;
	}
	
	@Override
	public String toString() {
		return "Room, "+getAmount()+" per night";
	}
	
}
