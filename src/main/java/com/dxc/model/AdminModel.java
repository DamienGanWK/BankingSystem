package com.dxc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AdminModel {

	public String getAusername() {
		return ausername;
	}

	public void setAusername(String ausername) {
		this.ausername = ausername;
	}

	public String getApassword() {
		return apassword;
	}

	public void setApassword(String apassword) {
		this.apassword = apassword;
	}

	private String ausername;
	private String apassword;
	
	public String getCusername() {
		return cusername;
	}

	public void setCusername(String cusername) {
		this.cusername = cusername;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	private String cusername;
	private String status;

	Connection con = null;
	Statement stmt = null;
	ResultSet res = null;
	PreparedStatement pstmt = null;
	
	public int serviceUpdate() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			System.out.println("Driver loaded");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample_dxc", "root", "root");
			System.out.println("Connection established successfully");

			String s = "update customer_loans set status=? where username=?";
			pstmt = con.prepareStatement(s);
			pstmt.setString(2, cusername);
			pstmt.setString(1, status);


			int rows = pstmt.executeUpdate();
			System.out.println("Successfully updated: " + rows);

			if (rows != 0) {
				return 1;
			} else {
				return -1;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return 0; // not added
	}

	public ArrayList<Loans> getPendingStatus() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			System.out.println("Driver loaded");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample_dxc", "root", "root");
			System.out.println("Connection established successfully");

			String s = "select * from customer_loans where status='false'";
			pstmt = con.prepareStatement(s);

			res = pstmt.executeQuery();

			ArrayList<Loans> pendingList = new ArrayList<Loans>();

			while (res.next()) {
				String cusername = res.getString(1);
				String loantype = res.getString(2);
				float rate = res.getFloat(4);

				System.out.println(cusername + " ");
				Loans tempCustomer = new Loans(cusername, loantype, rate);
				pendingList.add(tempCustomer);
			}

			return pendingList;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public ArrayList<Customer> getCustomerList() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			System.out.println("Driver loaded");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample_dxc", "root", "root");
			System.out.println("Connection established successfully");

			String s = "select * from bank_customers";
			pstmt = con.prepareStatement(s);

			res = pstmt.executeQuery();

			ArrayList<Customer> customerList = new ArrayList<Customer>();

			while (res.next()) {
				String cname = res.getString(1);
				String cusername = res.getString(2);
				String cemail = res.getString(4);
				System.out.print(cname + " ");
				Customer tempCustomer = new Customer(cname, cusername, cemail);
				customerList.add(tempCustomer);
			}

			// System.out.println(customerNames);
			return customerList;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public int adminLogin() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			System.out.println("Driver loaded");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample_dxc", "root", "root");
			System.out.println("Connection established successfully");

			String s = "select * from admin where ausername=?";
			pstmt = con.prepareStatement(s);
			pstmt.setString(1, ausername);

			res = pstmt.executeQuery();

			while (res.next()) {
				if (res.getString(2).equals(apassword)) {
					return 1; // correct user and password
				} else {
					return -1;
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}
}
