package ss.week3.bill;

public class StringPrinter implements Printer{
	private String collected = "";

	public String getResult() {
		return collected;
	}
	
	@Override
	public void printLine(String text, double price) {
		collected = collected + format(text, price);
	}
	
	
}
