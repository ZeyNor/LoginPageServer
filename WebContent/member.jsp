<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logged in</title>
</head>
<body>

	Welcome
	<%=(String) session.getAttribute("uname")%>

</body>
</html>