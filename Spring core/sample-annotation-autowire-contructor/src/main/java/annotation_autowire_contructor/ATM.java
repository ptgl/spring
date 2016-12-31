package annotation_autowire_contructor;

import org.springframework.beans.factory.annotation.Autowired;

public class ATM {
	
	private Printer printer;

	@Autowired
	public ATM(Printer printer) {
		this.printer = printer;
	}
	
	public void printBalance(String accountNumber) {
		printer.printBalance(accountNumber);
	}
}
