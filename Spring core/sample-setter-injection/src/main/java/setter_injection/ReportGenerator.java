package setter_injection;


public class ReportGenerator {

	private PDFWriter pdfWriter;

	public PDFWriter getPdfWriter() {
		return pdfWriter;
	}

	public void setPdfWriter(PDFWriter pdfWriter) {
		this.pdfWriter = pdfWriter;
	}
	
	public void generateReport() {
		pdfWriter.writeData();
	}
}
