package org.wanghang.springframework.ioc.manualioc;

public class Student {

	private String name;
	private Integer age;
	private String address;


	public void setName(String name) {
		this.name = name;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public Integer getAge() {
		return age;
	}
	public String getAddress() {
		return address;
	}

	@Override
	public String toString() {
		return "Student{" +
				"name='" + name + '\'' +
				", age=" + age +
				", address='" + address + '\'' +
				'}';
	}
}
