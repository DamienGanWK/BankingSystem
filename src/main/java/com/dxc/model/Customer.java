package com.dxc.model;

public class Customer {
	public Customer(String name, String customerUsername, String email) {
		super();
		this.name = name;
		this.customerUsername = customerUsername;
		this.email = email;
	}
	private String name;
	private String customerUsername;
	private String email;
	
	@Override
	public String toString() {
		return "Customer [name=" + name + ", customerUsername=" + customerUsername + ", email=" + email + "]";
	}
	
}
