package org.wanghang.springframework.aop;


/**
 *Spring 源码解析
 * 参考博文：
  https://www.pianshen.com/article/91011526648/

 1)关于Spring的aop的一些基础：
    一个切面(Advisor),有两个属性构成，切点和方法增强(需要增强的功能)
    切点(PointCut)：切面要增强的地方，一般是包的模糊匹配或者注解,
    方法增强(Advice):对方法功能的增强。

 连接点(JoinPoint)：程序执行过程中明确的点，连接点由两个信息确定，
                   方法:表示程序执行点
                   相对点:表示方位,即目标方法的什么位置，比如调用前，后等。

 切入点(PointCut):对连接点进行拦截的条件定义(对方法的标注),

 通知(Advice):通知是指拦截到连接点之后要执行的代码，包括了“around”、“before”和“after”等不同类型的通知,

 织入(Weaving):织入是将切面和业务逻辑对象连接起来, 并创建通知代理的过程,织入可以在编译时，类加载时和运行时完成。在编译时进行织入就是静态代理，而在运行时进行织入则是动态代理.

 增强器(Adviser):Advisor是切面的另外一种实现，能够将通知以更为复杂的方式织入到目标对象中,是将通知包装为更复杂切面的装配器。Advisor由切入点和Advice组成.

 AOP代理（AOP Proxy):AOP框架创建的对象，包含通知。 在Spring中，AOP代理可以是JDK动态代理或者CGLIB代理。
 目标对象（Target Object):包含连接点的对象。也被称作被通知或被代理对象。


 2)Spring aop的实现原理:
   https://blog.csdn.net/qq_26323323/article/details/81012855  (流程原理分析)
  a)如何生成代理对象？
  b)切面如何植入？












 */
public class AopDemo {
}
