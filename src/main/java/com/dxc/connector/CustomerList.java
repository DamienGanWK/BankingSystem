package com.dxc.connector;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dxc.model.AdminModel;
import com.dxc.model.Customer;

/**
 * Servlet implementation class CustomerList
 */
public class CustomerList extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		AdminModel am = new AdminModel();
		ArrayList<Customer> customerList = am.getCustomerList();

		PrintWriter pw = response.getWriter();

		for (Customer x : customerList) {
			pw.println(x);
		}
	}

}
