<html>
<head>
    <title>Employee Management</title>
</head>
<body>
<% session.invalidate(); %>
You are now logged out!!
<%-- <jsp:forward page="/login"></jsp:forward> --%>
<%  response.sendRedirect("/SpringsSecurityLoginForm/login");%>
</body>
</html>