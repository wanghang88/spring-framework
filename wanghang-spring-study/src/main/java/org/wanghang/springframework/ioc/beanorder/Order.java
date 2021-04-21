package org.wanghang.springframework.ioc.beanorder;


import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;


/**
 * Order实现InitializingBean接口在，Order初始化之后，执行初始化的方法;
 * Order实现DisposableBean接口后，在BeanFactory销毁的时候调用,总定义bean的销毁逻辑;
 *
 */
public class Order implements InitializingBean, DisposableBean {

	private Integer orderId;
	private String orderName;


	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public String getOrderName() {
		return orderName;
	}

	public Order(Integer orderId, String orderName) {
		this.orderId = orderId;
		this.orderName = orderName;
		System.out.println("order的有参构造函数执行了,订单Id为:"+orderId+"订单的name为:"+orderName);
	}

	public Order(){
		super();
		System.out.println("order的无参构造函数执行,Order对象实例话完成");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("Order实现InitializingBean接口在Order实例话之后执行");
	}

	@Override
	public String toString() {
		return "Order{" +
				"orderId=" + orderId +
				", orderName='" + orderName + '\'' +
				'}';
	}


	@Override
	public void destroy() throws Exception {
		System.out.println("spring容器销毁了,实现DisposableBean的bean执行自定义的destroy()方法");
	}
}
