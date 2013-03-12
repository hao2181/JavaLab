package com.test.json;

import java.util.List;
import java.util.Set;

public class User1 {
	
	private String name;
	
	private int age;
	
	private boolean employed;
	
	private Address address;

	private List<Children> children;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isEmployed() {
		return employed;
	}

	public void setEmployed(boolean employed) {
		this.employed = employed;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Children> getChildren() {
		return children;
	}

	public void setChildren(List<Children> children) {
		this.children = children;
	}

}
