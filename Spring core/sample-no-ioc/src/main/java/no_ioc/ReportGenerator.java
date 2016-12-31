package no_ioc;

public class ReportGenerator {
	
	private PDFWriter pdfWriter;
	
	public ReportGenerator(){
		pdfWriter = new PDFWriter();
	}

	public void generateReport(){
		pdfWriter.writeData();
	}
}
