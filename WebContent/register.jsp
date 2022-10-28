<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Join Us</title>
</head>
<body>
	CREATE ACCOUNT:
	<form method="post" action="login.jsp">
		<table>
			<tr>
				<td>What is your name?</td>
				<td><input type="text" name="name"></td>
			</tr>

			<tr>
				<td>What is your surname?</td>
				<td><input type="text" name="surname"></td>
			</tr>

			<tr>
				<td>Enter New UserName</td>
				<td><input type="text" name="uname"></td>
			</tr>

			<tr>
				<td>Enter New Password</td>
				<td><input type="password" name="password"></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="send"></td>
			</tr>

		</table>

	</form>

</body>
</html>