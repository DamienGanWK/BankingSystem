package com.dxc.model;

import java.sql.Date;

public class Transactions {
	public Transactions(String username, String action, float amount, Date date) {
		super();
		this.username = username;
		this.action = action;
		this.amount = amount;
		this.date = date;
	}
	@Override
	public String toString() {
		return "Transactions [username=" + username + ", action=" + action + ", amount=" + amount + ", date=" + date
				+ "]";
	}
	private String username;
	private String action;
	private float amount;
	private Date date; 
}
