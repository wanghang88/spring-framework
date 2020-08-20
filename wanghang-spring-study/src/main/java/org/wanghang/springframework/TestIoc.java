package org.wanghang.springframework;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class TestIoc {

	public static void main(String[] args) {
		ApplicationContext ac1 = new AnnotationConfigApplicationContext(JavaConfig.class);
		Person person = (Person) ac1.getBean("person");
		System.out.println("name:"+person.getName());
	}


}
