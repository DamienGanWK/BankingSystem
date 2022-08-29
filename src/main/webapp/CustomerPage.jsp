<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Homepage</title>
<style>
.menu {
	padding-top: 15px
}
</style>
</head>
<body>
	<div class=container>
		<%
		out.println(session.getAttribute("cusername") + " successfully logged in");
		%>
		<br>

		<div class=menu>
			<form action="/BankingSystem/ViewBalance">
				<!-- /project/servlet -->
				<table>

					<tr>
						<td><input type="submit" value="Check Balance"></td>
					</tr>

				</table>
			</form>

			<form action="/BankingSystem/sendMoney.html">
				<!-- /project/servlet -->
				<table>

					<tr>
						<td><input type="submit" value="Send Money"></td>
					</tr>

				</table>
			</form>


			<form action="/BankingSystem/requestLoan.html">
				<!-- /project/servlet -->
				<table>
					<tr>
						<td><input type="submit" value="Request Loan"></td>
					</tr>
				</table>
			</form>


			<form action="/BankingSystem/ViewLoanStatus">
				<!-- /project/servlet -->
				<table>

					<tr>
						<td><input type="submit" value="Check Loan Status"></td>
					</tr>

				</table>
			</form>

			<form action="/BankingSystem/viewTransactions.html">
				<!-- /project/servlet -->
				<table>

					<tr>
						<td><input type="submit" value="Check Transactions"></td>
					</tr>

				</table>
			</form>

			<form action="/BankingSystem/changePassword.html">
				<!-- /project/servlet -->
				<table>
					<tr>
						<td><input type="submit" value="Change Password"></td>
					</tr>
				</table>
			</form>
		</div>
	</div>

</body>
</html>