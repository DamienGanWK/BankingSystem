<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Portal</title>
</head>
<body>
	<h1>Welcome Admin</h1>

	<div class=menu>
		<form action="/BankingSystem/CustomerList">
			<!-- /project/servlet -->
			<table>
				<tr>
					<td><input type="submit" value="View Customer List"></td>
				</tr>
			</table>
		</form>


		<form action="/BankingSystem/ViewLoanRequests">
			<!-- /project/servlet -->
			<table>
				<tr>
					<td><input type="submit" value="View Loan Requests"></td>
				</tr>
			</table>
		</form>


		<form action="/BankingSystem/loanStatusUpdate.html">
			<!-- /project/servlet -->
			<table>

				<tr>
					<td><input type="submit" value="Update Loan Status"></td>
				</tr>

			</table>
		</form>
	</div>

</body>
</html>