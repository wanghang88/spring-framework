package org.wanghang.springframework.ioc.beanorder;


import org.springframework.beans.factory.InitializingBean;


/**
 * Order实现InitializingBean接口在，Order初始化之后，执行初始化的方法
 */
public class Order implements InitializingBean {

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
}
