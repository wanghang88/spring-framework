package org.wanghang.springframework;


import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.Scope;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.StopWatch;
import org.wanghang.springframework.manualioc.Student;


/**
 *
 * spring源码调试之:IOC容器(容器的初始化+bean的初始化)
 * 参考：https://javadoop.com/post/spring-ioc
 *
 * 1)容器在初始化的时候会将xml定义的bean转成BeanDefinition，bean的定义;
 * 2)Spring容器在初始化所有的单例对象时：
 *    a)BeanDefinition的信息找到对象构造器，实例化对象;
 *    b)BeanDefinition的信息找到属性值，填充之,如果有初始化方法，调用初始化方法;
 *
 * spring IOC容器的初始化：BeanFactoryPostProcessor,InitializingBean,BeanPostProcessor
 * https://my.oschina.net/mindfind/blog/918515
 *a)Spring容器的初始化过程
 * 1)Resource定位:将xml文件转成bean对象，使用Spring的Resource类来读取并解析;
 * 2)BeanDefinition的载入:把用户定义好的Bean表示成IoC容器内部的数据结,这个容器内部的数据结构就是BeanDefinition,这个BeanDefinition实际上就是POJO对象在IoC容器中的抽象
 * 3)向IoC容器注册这些BeanDefinition:BeanDefinitionRegistry接口的实现来完成的,在IoC容器内部将BeanDefinition注入到一个HashMap中去，IoC容器就是通过这个HashMap来持有这些BeanDefinition数据的.
 *
 *b)BeanFactoryPostProcessor,InitializingBean以及BeanPostProcessor的区别：
 * BeanFactoryPostProcessor：实现该接口，可以在spring的bean创建之前(IOC容器已经创建,并且也加载了bean的信息)，修改bean的定义属性
 *                           可以同时配置多个BeanFactoryPostProcessor，并通过设置'order'属性来控制各个BeanFactoryPostProcessor的执行次序。
 *
 * InitializingBean接口:可以在spring初始化bean(实现这个接口的bean)之后,执行其初始化后的方法;
 *
 * BeanPostProcessor:可以在spring容器实例化bean之后,在执行bean的初始化方法前,执行postProcessBeforeInitialization();然后再执行初始化的方法;初始化的方法执行完成之后再执行postProcessAfterInitialization()方法,
 *                   并且在配置之后，所有的bean都会有这个功能;
 *
 *
 *
 *c)spring容器初始化之Aware接口：aware接口的处理在spring ioc容器初始化完成之后，也就是bean转成了BeanDefinition,并注册进了ioc容器中(beanDefinitionMap)
 *                    使用场景：TODO
 *                           1)获取bean在容器中初始化之后的对象；
 * https://www.jianshu.com/p/b19f3848856f
 *ApplicationContextAware，ApplicationEventPublisherAware，BeanClassLoadAware，BeanFactoryAware，MessageSourceAware，ResourceLoaderAware
 *重点介绍：ApplicationContextAware接口，SpringUtils
 *
 *
 *d)如何手动地将bean交给Spring初始化？//TODO:和上面报一样的错
 * https://www.jianshu.com/p/816f74e975c9/
 *               SingletonBeanRegistry是BeanFactory默认实现DefaultListableBeanFactory实现的接口之一
 *
 *
 *
 *c)springBean的生命周期：
 * 参考这个图
 * https://blog.csdn.net/weixin_42762133/article/details/98459194
 *
 *
 * d)关于spring的aop，两种代理的代码实现：
 * https://blog.csdn.net/weixin_42762133/article/details/104908894
 *
 *
 * e)关于使用spring的Aop实现事务的参考
 * https://yuanyu.blog.csdn.net/article/details/89792082
 *
 *
 *
 */
public class TestIoc {

	public static void main(String[] args) throws InterruptedException {
		TestIoc ioc=new TestIoc();

	//	ioc.annotationConfigIOc();

	//	ioc.classPathXml();

	//	ioc.userLoadToSpringIoc();

		ioc.testStopWatch();
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


	//3:用户以手工的方式将bean加入到spring的容器中:
	private void userLoadToSpringIoc() {
		ClassPathXmlApplicationContext classPathXmlApplicationContext = new ClassPathXmlApplicationContext("classpath:application.xml");

		Student student=new Student();
		student.setName("wanghang");
		student.setAge(18);
		student.setAddress("上海市");

		ConfigurableListableBeanFactory beanFactory = classPathXmlApplicationContext.getBeanFactory();
		beanFactory.registerScope("student", (Scope) student);

		System.out.println("student:"+student);
	}


	//测试StopWatch
	private void testStopWatch() throws InterruptedException {
		StopWatch stopWatch=new StopWatch();
		stopWatch.start();

		Thread.sleep(1000);

		stopWatch.stop();

		System.out.println("程序执行的时间:"+stopWatch.getTotalTimeMillis());
		System.out.println("程序执行的时间:"+stopWatch.prettyPrint());
	}







}
