package com.dxc.model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class CustomerModel {

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCusername() {
		return cusername;
	}

	public void setCusername(String cusername) {
		this.cusername = cusername;
	}

	public String getCpassword() {
		return cpassword;
	}

	public void setCpassword(String cpassword) {
		this.cpassword = cpassword;
	}

	public String getCemail() {
		return cemail;
	}

	public void setCemail(String cemail) {
		this.cemail = cemail;
	}

	private String cname;
	private String cusername;
	private String cpassword;
	private String cemail;

	public float getBalance() {
		return balance;
	}

	public void setBalance(float balance) {
		this.balance = balance;
	}

	private float balance;

	public float getRate() {
		return rate;
	}

	public void setRate(float rate) {
		this.rate = rate;
	}

	private float rate = 1.0f;

	public String getLoanType() {
		return loanType;
	}

	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}

	private String loanType;

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	private String newPassword;

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}

	public String getTargetUser() {
		return targetUser;
	}

	public void setTargetUser(String targetUser) {
		this.targetUser = targetUser;
	}

	private float amount;
	private String targetUser;

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	private String startDate;
	private String endDate;

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	private String answer;
	
	public String getQns() {
		return qns;
	}

	public void setQns(String qns) {
		this.qns = qns;
	}

	private String qns;

	Connection con = null;
	Statement stmt = null;
	ResultSet res = null;
	ResultSet res1 = null;

	PreparedStatement pstmt = null;

	public int requestLoan() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			System.out.println("Driver loaded");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample_dxc", "root", "root");
			System.out.println("Connection established successfully");

			String s = "insert into customer_loans values(?,?,?,?)";
			pstmt = con.prepareStatement(s);
			pstmt.setString(1, cusername);
			pstmt.setString(2, loanType);
			pstmt.setString(3, "false");
			pstmt.setFloat(4, rate);

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

	public int checkBalance() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			System.out.println("Driver loaded");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample_dxc", "root", "root");
			System.out.println("Connection established successfully");

			String s = "select balance from bank_customers where username=?";
			pstmt = con.prepareStatement(s);
			pstmt.setString(1, cusername);

			res = pstmt.executeQuery();
			res.next();
			System.out.println(res.getFloat(1));

			balance = res.getFloat(1);

			if (res.getString(1).equals("true")) {
				return 1;
			} else {
				return 0;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	public int login() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			System.out.println("Driver loaded");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample_dxc", "root", "root");
			System.out.println("Connection established successfully");

			String s = "select * from bank_customers where username=?";
			pstmt = con.prepareStatement(s);
			pstmt.setString(1, cusername);

			res = pstmt.executeQuery();
			while (res.next()) {
				if (cpassword.equals(res.getString(3))) {

					return 1;
				} else {
					return -1;
				}
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0; // user not found
	}

	public int registerCustomer() {
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			System.out.println("Driver loaded");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample_dxc", "root", "root");
			System.out.println("Connection established successfully");

			String s = "select * from bank_customers where username=?";
			pstmt = con.prepareStatement(s);
			pstmt.setString(1, cusername);

			res = pstmt.executeQuery();
			while (res.next()) {
				if (cusername.equals(res.getString(2))) {
					return -1;
				}
			}

			s = "insert into bank_customers value(?,?,?,?,?,?,?)";
			pstmt = con.prepareStatement(s);
			pstmt.setString(1, cname);
			pstmt.setString(2, cusername);
			pstmt.setString(3, cpassword);
			pstmt.setString(4, cemail);
			pstmt.setFloat(5, 1000);
			pstmt.setString(6,qns);
			pstmt.setString(7, answer);

			int row = pstmt.executeUpdate();
			System.out.println("Number of rows updated: " + row);
			if (row != 0) {
				return 1;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0; // user not found
	}

	public int getLoanStatus() {
		// TODO Auto-generated method stub
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			System.out.println("Driver loaded");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample_dxc", "root", "root");
			System.out.println("Connection established successfully");

			String s = "select status from customer_loans where username=?";
			pstmt = con.prepareStatement(s);
			pstmt.setString(1, cusername);

			res = pstmt.executeQuery();
			res.next();
			System.out.println(res.getString(1));

			if (res.getString(1).equals("true")) {
				return 1;
			} else {
				return 0;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	public int changePassword() {
		// TODO Auto-generated method stub
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			System.out.println("Driver loaded");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample_dxc", "root", "root");
			System.out.println("Connection established successfully");

			String s = "update bank_customers set password=? where username=? and password=?";
			pstmt = con.prepareStatement(s);
			pstmt.setString(3, cpassword);
			pstmt.setString(2, cusername);
			pstmt.setString(1, newPassword);

			int res = pstmt.executeUpdate();
			if (res != 0) {
				return 1;

			} else {
				return 0;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	public int transferMoney() {
		// TODO Auto-generated method stub
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			System.out.println("Driver loaded");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample_dxc", "root", "root");
			System.out.println("Connection established successfully");

			String s = "select balance from bank_customers where username=?";
			pstmt = con.prepareStatement(s);
			pstmt.setString(1, cusername);

			res = pstmt.executeQuery();
			res.next();
			float remainder = res.getFloat(1) - amount;
			float newBalance;
//			LocalDate date = LocalDate.now();
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

			if (remainder > 0) {
				// check if target user exists
				s = "select balance from bank_customers where username=?";
				pstmt = con.prepareStatement(s);
				pstmt.setString(1, targetUser);
				res = pstmt.executeQuery();
				if (res.next()) {
					newBalance = res.getFloat(1) + amount;
				} else {
					return -1; // user not found
				}

				// update current user balance
				s = "update bank_customers set balance=" + remainder + " where username=" + "'" + cusername + "'";
				pstmt = con.prepareStatement(s);
				int row = pstmt.executeUpdate();

				s = "insert into customer_transactions values(?,?,?,?)";
				pstmt = con.prepareStatement(s);
				pstmt.setString(1, cusername);
				pstmt.setString(2, "transfer");
				pstmt.setFloat(3, amount);
				pstmt.setDate(4, java.sql.Date.valueOf(java.time.LocalDate.now()));
				int row1 = pstmt.executeUpdate();

				// update target user balance
				s = "update bank_customers set balance=" + newBalance + " where username=" + "'" + targetUser + "'";
				pstmt = con.prepareStatement(s);
				int row2 = pstmt.executeUpdate();

				s = "insert into customer_transactions values(?,?,?,?)";
				pstmt = con.prepareStatement(s);
				pstmt.setString(1, targetUser);
				pstmt.setString(2, "received");
				pstmt.setFloat(3, amount);
				pstmt.setDate(4, java.sql.Date.valueOf(java.time.LocalDate.now()));
				int row3 = pstmt.executeUpdate();

				if (row != 0 && row2 != 0) {
					return 1;
				} else {
					return 0;
				}
			} else {
				return 0;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}

	public ArrayList<Transactions> getTransactions() {
		// TODO Auto-generated method stub
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			System.out.println("Driver loaded");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample_dxc", "root", "root");
			System.out.println("Connection established successfully");

			String s = "select * from customer_transactions where username=? and date between? and ?";
			pstmt = con.prepareStatement(s);
			pstmt.setString(1, cusername);
			pstmt.setString(2, startDate);
			pstmt.setString(3, endDate);

			res = pstmt.executeQuery();

			ArrayList<Transactions> transactionList = new ArrayList<Transactions>();

			while (res.next()) {
				String cusername = res.getString(1);
				String action = res.getString(2);
				float amount = res.getFloat(3);
				Date date = res.getDate(4);
				Transactions tempTransaction = new Transactions(cusername, action, amount, date);
				transactionList.add(tempTransaction);
			}

			// System.out.println(customerNames);
			return transactionList;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public String getSecurityQns() {
		// TODO Auto-generated method stub
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			System.out.println("Driver loaded");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample_dxc", "root", "root");
			System.out.println("Connection established successfully");

			String s = "select question from bank_customers where username=?";
			pstmt = con.prepareStatement(s);
			pstmt.setString(1, cusername);

			res = pstmt.executeQuery();
			if (res.next()) {
				System.out.println(res.getString(1));
				String qns = res.getString(1);
				return qns;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return null;
	}

	public int resetPassword() {
		// TODO Auto-generated method stub
		try {
			DriverManager.registerDriver(new com.mysql.jdbc.Driver());
			System.out.println("Driver loaded");

			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sample_dxc", "root", "root");
			System.out.println("Connection established successfully");

			String s = "update bank_customers set password=? where username=? and answer=?";
			pstmt = con.prepareStatement(s);
			pstmt.setString(3, answer);
			pstmt.setString(2, cusername);
			pstmt.setString(1, newPassword);

			int res = pstmt.executeUpdate();
			if (res != 0) {
				return 1;

			} else {
				return 0;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return 0;
	}
}
