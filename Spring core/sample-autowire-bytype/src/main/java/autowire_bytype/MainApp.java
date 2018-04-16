package autowire_bytype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class MainApp {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

		ATM obj = (ATM) context.getBean("atmBean");
		obj.printBalance("12345678");
	}
}

/**
 * Note:
 * Autowire by Type: If a bean of class Cat exposes a "dog" property, Spring will find if there are any exactly one bean type "dog" in container (class)
 	If yes, Spring will set this bean to the "dog" property. However, if define more than one bean with the same type, a fatal error is raised, and you cannot use byType autowiring for that bean.
 *
 */