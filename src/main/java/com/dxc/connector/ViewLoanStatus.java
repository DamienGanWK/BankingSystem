package com.dxc.connector;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dxc.model.CustomerModel;

/**
 * Servlet implementation class ViewLoanStatus
 */
public class ViewLoanStatus extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String cusername = (String) session.getAttribute("cusername");

		int count;

		CustomerModel cm = new CustomerModel();
		cm.setCusername(cusername);
		count = cm.getLoanStatus();

		if (count == 1) {
			response.sendRedirect("/BankingSystem/LoanApproved.jsp");
		} else {
			response.sendRedirect("/BankingSystem/loanPending.html");

		}
	}

}
