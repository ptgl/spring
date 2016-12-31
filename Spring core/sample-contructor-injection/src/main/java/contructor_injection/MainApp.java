package contructor_injection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainApp {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		ReportGenerator obj = (ReportGenerator) context.getBean("reportGenerator");

		obj.generateReport();

	}
}
