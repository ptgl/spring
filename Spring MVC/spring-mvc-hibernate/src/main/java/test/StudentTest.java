package test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dao.StudentDao;
import model.Student;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:/WEB-INF/servlet-context.xml"})
public class StudentTest {
	
	@Autowired
	@Qualifier("studentDao")
	private StudentDao dao;
	
	@Test
	public void testMessage(){
		Student student = new Student();
		student.setAddress("HCM");
		student.setFullName("Kaka");
		student.setSex("M");
		
		dao.create(student);
		
		Student other = null;
		List<Student> students = dao.listStudents();
		for (Student s : students) {
			if (s.getFullName().equals("Kaka")){
				other = s;
				break;
			}
		}
		
		assertEquals("HCM",other.getAddress());
	}
}
