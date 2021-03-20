package org.wanghang.springframework;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 *
 * spring源码调试之:IOC容器
 * 参考：https://javadoop.com/post/spring-ioc
 *
 *
 */
public class TestIoc {

	public static void main(String[] args) {
		TestIoc ioc=new TestIoc();

	//	ioc.annotationConfigIOc();
		ioc.classPathXml();
	}


	//1:以注解的方式启动spring的容器:
	private void annotationConfigIOc() {
		ApplicationContext ac1 = new AnnotationConfigApplicationContext(JavaConfig.class);
		Person person = (Person) ac1.getBean("person");
		System.out.println("name:"+person.getName());
	}


    //2:已xml的方式启动Spring的容器:
	private void classPathXml() {
		// 用我们的配置文件来启动一个 ApplicationContext
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
		System.out.println("context 启动成功");

		// 从 context 中取出我们的 Bean，而不是用 new MessageServiceImpl() 这种方式
		Person person = context.getBean(Person.class);
		person.work();
	}


}
