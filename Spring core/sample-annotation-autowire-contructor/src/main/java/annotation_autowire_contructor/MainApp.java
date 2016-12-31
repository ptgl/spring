package annotation_autowire_contructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		ATM obj = (ATM) context.getBean("atmBean");
		obj.printBalance("12345678");

	}

}
