package ss.week3.bill;

public class Bill {
	private double sum;
	private Printer printer;
	
	public interface Item{
		double getAmount();
		String toString();
	}
	
	public Bill(Printer printer) {
		this.printer = printer;
		this.sum = 0;
	}
	
	public StringPrinter getPrinter() {
		return (StringPrinter) printer;
	}
	
	public void addItem(Item item) {
		sum = sum + item.getAmount();
		printer.printLine(item.toString(), item.getAmount());
	}
	
	public void close() {
		printer.printLine("Total", sum);
	}
	
	public double getSum() {
		return sum;
	}
}
