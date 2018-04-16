package autowire_byname;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		ATM obj = (ATM) context.getBean("atmBean");
//		obj.setId("123");
		obj.printBalance("12345678");
	}

}
/**
 * Note:
 * Tag <Property> must have 'ref' or 'value' otherwise throw error
 * Properties that not refer to another class (ex: String id, int num,....) don't need to set tag <property> in beans.xml
 * Properties that refer to another class (ex: Printer printer, ClassB b,....) need to set tag <property> in beans.xml
 * If set property in bean.xml, need to have setter function
 * The setter function must have correct name (ex: Printer myPrinter -> setMyPrinter); Spring may base on setter function to set or initialize the properties
 * The getter function no need to have the correct name (ex: Printer myPrinter -> getABC)
 * 'name' in tag property must have the same value of the property name declared in class (ex: String message -> <property name="message" ...>)
 * Autowire by Name: If a bean of class Cat exposes a "dog" property, Spring will try to set this to the value of the 
 	bean "dog" in the current container. If there is no matching bean by name, nothing special happens. 
 	Meaning: If a bean has "dog" property (contain another bean inside the current one), Spring will find if there are any bean "dog" in container base on name (id)
 	If yes, Spring will set this bean to the "dog" property.
 * 
 */