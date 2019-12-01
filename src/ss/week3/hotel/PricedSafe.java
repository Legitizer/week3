//JAVADOC

package ss.week3.hotel;

import ss.week3.bill.Bill;
import ss.week3.password.Password;

public class PricedSafe extends Safe implements Bill.Item{
	private double amount;
	
	private Password pass;
	
	public PricedSafe(double price) {
		this.opened = false;
		this.active = false;
		
		this.amount = price;
		pass = new Password();
	}
	
	public boolean activate(String pass) {
		if (this.pass.testWord(pass)) {
			this.active = true;
			return true;
		}
		return false;
	}
	
	public void activate() {
		System.out.println("You cannot activate the safe without a password");
	}
	
	public void deactivate() {
		this.active = false;
		this.opened = false;
	}
	
	public void open(String pass) {
		if (this.pass.testWord(pass) && this.active == true) {
			this.opened = true;
		}
	}
	
	public void open() {
		System.out.println("You cannot open the safe without a password");
	}
	
	public void close() {
		this.opened = false;
	}
	
	public Password getPassword() {
		return this.pass;
	}
	
	@Override
	public double getAmount() {
		return this.amount;
	}
	
	@Override
	public String toString() {
		return "Priced Safe";
	}

}
