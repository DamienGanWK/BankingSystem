package com.dxc.connector;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dxc.model.CustomerModel;
import com.dxc.model.Loans;
import com.dxc.model.Transactions;

/**
 * Servlet implementation class ViewTransactions
 */
public class ViewTransactions extends HttpServlet {
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession(true);
		String cusername = (String) session.getAttribute("cusername");
		String startDate = request.getParameter("startDate");
		String endDate = request.getParameter("endDate");

		CustomerModel cm = new CustomerModel();
		cm.setCusername(cusername);
		cm.setStartDate(startDate);
		cm.setEndDate(endDate);
		ArrayList<Transactions> transactionList = cm.getTransactions();

		PrintWriter pw = response.getWriter();

		if(transactionList.size()!=0) {
			for (Transactions x : transactionList) {
				pw.println(x);
			}
		}
		else {
			pw.print("No transactions to display.");
		}

	}

}
