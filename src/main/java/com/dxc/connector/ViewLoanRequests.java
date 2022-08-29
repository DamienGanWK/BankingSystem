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
import com.dxc.model.Loans;

/**
 * Servlet implementation class ViewLoanRequests
 */
public class ViewLoanRequests extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		//	String cusername = (String) session.getAttribute("cusername");

		AdminModel am = new AdminModel();
		ArrayList<Loans> pendingList = am.getPendingStatus();

		PrintWriter pw = response.getWriter();

		if(pendingList.size()!=0) {
			for (Loans x : pendingList) {
				pw.println(x);
			}
		}
		else {
			pw.print("No pending loans to display.");
		}

	}

}
