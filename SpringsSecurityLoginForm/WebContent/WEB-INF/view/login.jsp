<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<html>
<head>
<title>Employee Management</title>
<spring:url value="/resources/css/bootstrap.min.css" var="mainCss" />
<link href="${mainCss}" rel="stylesheet" />
</head>
<body>
	<h2 id="banner" align="center">Employee Management System</h2>
	<hr />
	<br>
	<br>
	<form name="f" action="<c:url value='j_spring_security_check'/>"
		method="POST">
		<table align="center">
			<tr>
				<td>Username:</td>
				<td><input type='text' name='j_username' /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='j_password'></td>
			</tr>
			<tr>
				<td colspan="2">&nbsp;</td>
			</tr>


			<c:if test="${not empty msg}">
				<div class="alert alert-${css} alert-dismissible" role="alert">
					<button type="button" class="close" data-dismiss="alert"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<strong>${msg}</strong>
				</div>
			</c:if>
			<tr>
				<td align="center"><input name="submit" type="submit" />
				<td align="center"><input name="reset" type="reset"></td>
			</tr>
		</table>
	</form>
</body>
</html>