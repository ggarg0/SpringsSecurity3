<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Employee Management</title>
</head>
	<body>
	
		<h2 id="banner" align="center">Employee Management System</h2>	
		<hr/>
	
		<c:if test="${not empty error}">
			<div style="color:red">
		<h3>		Login denied -- ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}</h3>
			</div>
		</c:if>

		<a href="/SpringsSecurityLoginForm">Go back to login page</a> 
	</body>
</html>