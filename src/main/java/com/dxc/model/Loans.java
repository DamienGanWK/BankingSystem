package com.dxc.model;

public class Loans {

	public Loans(String username, String loantype, float rates) {
		super();
		this.username = username;
		this.loantype = loantype;
		this.rates = rates;
	}
	@Override
	public String toString() {
		return "Loans [username=" + username + ", loantype=" + loantype + ", rates=" + rates + "]";
	}
	private String username;
	private String loantype;
	private float rates;

}
