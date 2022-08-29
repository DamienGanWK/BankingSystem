package com.dxc.connector;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dxc.model.CustomerModel;

/**
 * Servlet implementation class CustomerRegister
 */
public class CustomerRegister extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String cname = request.getParameter("cname");
		String cpassword = request.getParameter("cpassword");
		String cusername = request.getParameter("cusername");
		String cemail = request.getParameter("cemail");
		String qns = request.getParameter("qns");
		String answer = request.getParameter("answer");
		int count;
		
		HttpSession session = request.getSession(true); // create new session
		session.setAttribute("cusername", cusername); // (name of variable,value of variable)

		CustomerModel cm = new CustomerModel();
		cm.setCname(cname);
		cm.setCusername(cusername);
		cm.setCpassword(cpassword);
		cm.setCemail(cemail);
		cm.setQns(qns);
		cm.setAnswer(answer);

		count = cm.registerCustomer();
		cusername = cm.getCusername();
		System.out.println("Returned " + count);

		if (count == 1) {
			response.sendRedirect("/BankingSystem/SuccessfulRegister.jsp");
		} else if (count == -1) {
			response.sendRedirect("/BankingSystem/usernameExisted.html");
		} else {
			response.sendRedirect("/BankingSystem/registerFail.html");
		}

	
	}
}
