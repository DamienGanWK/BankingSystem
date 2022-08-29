package com.dxc.connector;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dxc.model.AdminModel;

/**
 * Servlet implementation class AdminLogin
 */
public class AdminLogin extends HttpServlet {
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String ausername = request.getParameter("ausername");
		String apassword = request.getParameter("apassword");
		int count = 0;

		AdminModel am = new AdminModel();
		am.setAusername(ausername);
		am.setApassword(apassword);

		count = am.adminLogin();
		ausername = am.getAusername();
		System.out.println("Returned " + count);

		if (count == 1) {
			response.sendRedirect("/BankingSystem/AdminPage.jsp");
		} else if (count == -1) {
			response.sendRedirect("/BankingSystem/invalidAdminPassword.html");
		} else {
			response.sendRedirect("/BankingSystem/invalidAdminUser.html");
		}

		// HttpSession session = request.getSession(true); //create new session
		// session.setAttribute("ausername", ausername); //(name of variable,value of
		// variable)
	}

}
