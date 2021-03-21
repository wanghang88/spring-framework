package org.wanghang.springframework.beanorder;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class OrderTest {


	public static void main(String[] args) {

		// 用我们的配置文件来启动一个 ApplicationContext
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:application.xml");
		// 从 context 中取出我们的 Bean，而不是用 new MessageServiceImpl() 这种方式
		Order order = context.getBean(Order.class);

		System.out.println("order:"+order);
	}
}
