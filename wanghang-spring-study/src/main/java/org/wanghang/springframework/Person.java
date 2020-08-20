package org.wanghang.springframework;

public class Person {

	private String name;

	private Integer age;

	Person(String name,Integer age){
		this.name=name;
		this.age=age;
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

	public static void main(String[] args) {
		Person person=new Person("wanghang",36);
		System.out.println("name:"+person.getName());
	}

}
