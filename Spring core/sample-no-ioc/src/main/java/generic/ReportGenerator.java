package generic;

public class ReportGenerator {
	private IWriter writer;

	public ReportGenerator(IWriter writer) {
		super();
		this.writer = writer;
	}
	
	public void generateReport(){
		this.writer.writeData();
	}
}
