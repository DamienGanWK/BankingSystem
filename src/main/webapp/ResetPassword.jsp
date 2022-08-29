<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reset Password</title>
</head>
<body>
	<%
	out.println(session.getAttribute("qns"));
	%>
	<form action="/BankingSystem/ResetPassword">
		<!-- /project/servlet -->
		<table>

			<tr>
				<td>Answer</td>
				<td><input type="text" name="answer"></td>

			</tr>

			<tr>
				<td>New Password</td>
				<td><input type="text" name="newPassword"></td>

			</tr>

			<tr>
				<td><input type="submit" value="Reset Password"></td>
			</tr>

		</table>
	</form>
</body>
</html>