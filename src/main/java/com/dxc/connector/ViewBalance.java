package com.dxc.connector;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dxc.model.Customer;
import com.dxc.model.CustomerModel;

/**
 * Servlet implementation class ViewBalance
 */
public class ViewBalance extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String cusername = (String) session.getAttribute("cusername");

		int count;

		CustomerModel cm = new CustomerModel();
		//ArrayList<Customer> balance= cm.getBalance();
		cm.setCusername(cusername);
		count = cm.checkBalance();
		float balance = cm.getBalance();
		PrintWriter pw = response.getWriter();
		pw.print("Your account balance is: $" + balance);
		
	}
}
