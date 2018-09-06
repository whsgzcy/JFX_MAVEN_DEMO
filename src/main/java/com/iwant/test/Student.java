package com.iwant.test;

public class Student {

	private String name;
	private String age;
	private String love;

	public Student(String name, String age, String love) {
		super();
		this.name = name;
		this.age = age;
		this.love = love;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getLove() {
		return love;
	}

	public void setLove(String love) {
		this.love = love;
	}

}
