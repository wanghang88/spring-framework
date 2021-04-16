package org.wanghang.springframework.ioc.aware;


import org.wanghang.springframework.ioc.beanorder.Order;


/**
 * 获取spring容器中初始化后的bean
 */
public class BeanAwareTest {

	public static void main(String[] args) {
		Order order = SpringUtils.getBean(Order.class);
		System.out.println("order:"+order);
	}
}
