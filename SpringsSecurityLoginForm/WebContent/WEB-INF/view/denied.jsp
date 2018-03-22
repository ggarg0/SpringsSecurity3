<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Employee Management</title>
</head>
<body>

	<h2 id="banner" align="center">Employee Management System</h2>
	<hr />
	<%
		session.invalidate();
	%>
	<div style="color: red">
		<h3>Login denied -- ${msg}</h3>
	</div>

	<a href="/SpringsSecurityLoginForm/login">Go back to login page</a>
</body>
</html>