package ss.week3.bill;

public interface Printer {
	default String format(String text, double price) {
		return String.format("%-20s %10.2f \n", text, price);
	}
	
	void printLine(String text, double price);
}
