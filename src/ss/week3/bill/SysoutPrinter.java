package ss.week3.bill;

public class SysoutPrinter implements Printer {
	@Override
	public void printLine(String text, double price) {
		System.out.print(format(text, price));
	}
	
	public static void main(String[] args) {
		Printer printer = new SysoutPrinter();
		printer.printLine("Some Text", 3.14159);
		printer.printLine("Some Other Text", 2.71828);
	}
}
