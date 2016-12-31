package generic;

public class MainApp {

	public static void main(String[] args) {
		PDFWriter pdf = new PDFWriter();
		
		ReportGenerator generator = new ReportGenerator(pdf);
		generator.generateReport();
		
		ExcelWriter excel = new ExcelWriter();
		generator = new ReportGenerator(excel);
		
		generator.generateReport();
				
	}

}
