package org.wanghang.springframework.ioc;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@ComponentScan
@Configuration
public class JavaConfig {

	@Bean
	public Person person() {
		return new Person("李小龙", 33);
	}
}
