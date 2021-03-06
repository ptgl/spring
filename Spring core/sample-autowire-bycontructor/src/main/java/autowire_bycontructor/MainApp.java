package autowire_bycontructor;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		ATM obj = (ATM) context.getBean("atmBean");
		obj.printBalance("12345678");
	}
}

/*Note
Autowire by constructor: Similar to byType, but type applies to constructor arguments. 
If there is not exactly one bean of the constructor argument type in the container, 
a fatal error is raised.
*/