package hello;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:beans.xml"})
public class HelloTest {

	@Autowired
	private HelloSpring hello;
	
	@Test
	public void testMessage(){
		assertEquals("Your message: Kien!",hello.getMessage());
	}
}
