package ioc;

import ioc.ReportGenerator;

public class ReportGeneratorTest {
	
	public static void main(String[] args) {
		
		PDFWriter pdf = new PDFWriter();
		
		ReportGenerator generator = new ReportGenerator(pdf);
		generator.generateReport();
	}
}
