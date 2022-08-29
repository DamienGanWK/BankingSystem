package com.dxc.connector;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dxc.model.CustomerModel;

/**
 * Servlet implementation class GetSecurityQns
 */
public class GetSecurityQns extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cusername = request.getParameter("cusername");
		String qns;
		
		HttpSession session = request.getSession(true); // create new session
		session.setAttribute("cusername", cusername); // (name of variable,value of variable)

		CustomerModel cm = new CustomerModel();
		cm.setCusername(cusername);
		qns = cm.getSecurityQns();
		session.setAttribute("qns", qns); // (name of variable,value of variable)

		if (!qns.equals(null)) {
			response.sendRedirect("/BankingSystem/ResetPassword.jsp");
		} else {
			response.sendRedirect("/BankingSystem/passwordChangeFail.html");

		}
	}
}
