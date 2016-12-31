package contructor_injection;

public class ReportGenerator {

	private PDFWriter pdfWriter;

	public ReportGenerator(PDFWriter pdfWriter) {
		this.pdfWriter = pdfWriter;
	}

	public void generateReport() {
		pdfWriter.writeData();
	}
}
