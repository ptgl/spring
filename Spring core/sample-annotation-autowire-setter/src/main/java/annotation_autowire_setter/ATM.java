package annotation_autowire_setter;

import org.springframework.beans.factory.annotation.Autowired;

public class ATM {
	private Printer printer;

	public Printer getPrinter() {
		return printer;
	}

	@Autowired
	public void setPrinter(Printer printer) {
		this.printer = printer;
	}

	public void printBalance(String accountNumber) {
		getPrinter().printBalance(accountNumber);
	}
}

