package com.dxc.connector;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dxc.model.CustomerModel;

/**
 * Servlet implementation class CustomerLogin
 */
public class CustomerLogin extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cpassword = request.getParameter("cpassword");
		String cusername = request.getParameter("cusername");
		int count;

		HttpSession session = request.getSession(true); // create new session
		session.setAttribute("cusername", cusername); // (name of variable,value of variable)
		
		CustomerModel cm = new CustomerModel();
		cm.setCusername(cusername);
		cm.setCpassword(cpassword);

		count = cm.login();
		cusername = cm.getCusername();
		System.out.println("Returned " + count);

		if (count == 1) {
			response.sendRedirect("/BankingSystem/CustomerPage.jsp");
		} else {
			response.sendRedirect("/BankingSystem/invalidCustomerLogin.html");
		}


	}
}
