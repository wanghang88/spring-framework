package org.wanghang.springframework.beanorder;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;


/**
 * Order初始化之前，ioc容器已经初始化，并且将Order的相关参数加载到ioc容器中
 */
public class OrderBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		BeanDefinition orderBeanDefinition = beanFactory.getBeanDefinition("order");
		MutablePropertyValues pv =  orderBeanDefinition.getPropertyValues();
		//将原来的订单id由100改成了200;
		if (pv.contains("orderId")) {
			pv.addPropertyValue("orderId", 200);
		}
	}
}
