package org.wanghang.springframework.ioc;

public class Person {

	private String name;
	private Integer age;

	public Person(){
	}

	public Person(String name,Integer age){
		this.name=name;
		this.age=age;
	}


	public void work(){
		System.out.println("Person 类示例启动了,可以开始工作了");
	}





	public void setName(String name){
		this.name=name;
	}
	public void setAge(Integer age){
		this.age=age;
	}

	public String getName(){
		return this.name;
	}
	public Integer getAge(){
		return this.age;
	}



}
