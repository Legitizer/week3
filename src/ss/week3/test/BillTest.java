package ss.week3.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ss.week3.bill.Bill;
import ss.week3.bill.StringPrinter;

class BillTest {
	class Item implements Bill.Item{
		private double amount;
		private String desc;
		
		public Item(String text, double amount) {
			this.desc = text;
			this.amount = amount;
		}
		
		@Override
		public double getAmount() {
			return amount;
		}
		
		@Override
		public String toString() {
			return desc;
		}
		
	}
	
	private Bill bill;
	private BillTest.Item item;
	
	@BeforeEach
	void setUp() throws Exception {
		bill = new Bill(new StringPrinter());
		item = new BillTest.Item("Oranges", 2.40f);
	}

	@Test
	void testBeginState() {
		assertEquals(0, bill.getSum(), 0.05f);
	}
	
	@Test
	void textNewItem() {
		assertEquals(0, bill.getSum(), 0.05f);
		bill.addItem(item);
		assertEquals(2.40f, bill.getSum(), 0.05f);
	}

}
