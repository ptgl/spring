package autowire_bycontructor;


public class ATM {
	
	private Printer printer;

	public ATM(Printer printer) {
		this.printer = printer;
	}

	public void printBalance(String accountNumber) {
		printer.printBalance(accountNumber);
	}
}
