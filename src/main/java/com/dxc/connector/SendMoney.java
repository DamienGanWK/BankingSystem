package com.dxc.connector;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dxc.model.CustomerModel;

/**
 * Servlet implementation class SendMoney
 */
public class SendMoney extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String cusername = (String) session.getAttribute("cusername");
		float amount = Float.parseFloat(request.getParameter("amount"));
		String targetUser = request.getParameter("targetUser");

		int count;

		CustomerModel cm = new CustomerModel();
		cm.setCusername(cusername);
		cm.setAmount(amount);
		cm.setTargetUser(targetUser);
		count = cm.transferMoney();

		if (count == 1) {
			response.sendRedirect("/BankingSystem/TransferSuccess.jsp");
		} else {
			response.sendRedirect("/BankingSystem/transferFail.html");

		}
	}

}
