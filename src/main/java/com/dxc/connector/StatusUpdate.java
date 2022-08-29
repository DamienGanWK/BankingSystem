package com.dxc.connector;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dxc.model.AdminModel;

/**
 * Servlet implementation class StatusUpdate
 */
public class StatusUpdate extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String cusername = request.getParameter("cusername");
		String status = request.getParameter("status");

		int count;

		AdminModel am = new AdminModel();
		am.setCusername(cusername);
		am.setStatus(status);

		count = am.serviceUpdate();
		am.setStatus(status);
		cusername = am.getCusername();
		System.out.println("Returned " + count);

		if (count == 1) {
			response.sendRedirect("/BankingSystem/UpdateStatusSuccess.jsp");
		} else {
			response.sendRedirect("/BankingSystem/updateStatusFailure.html");
		}

	}
}
