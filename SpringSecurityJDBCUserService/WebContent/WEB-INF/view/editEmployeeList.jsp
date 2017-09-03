<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Employee Management</title>
</head>
<body>
 
 <h2 id="banner" align="center">Employee Management System</h2>	<hr/>
 
 <h4><a href="/SpringSecurityJDBCUserService/list">View Employees</a>&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="<c:url value='j_spring_security_logout'/>">Logout</a></h4>
<form:form method="post" action="edit" commandName="employee">
 <center>
    <table>
   
    <tr>
        <td><form:hidden path="id"/></td>
    </tr>
    <tr>
        <td><form:label path="firstname"><spring:message code="label.firstname"/></form:label></td>
        <td><form:input path="firstname" /></td>
    </tr>
    <tr>
        <td><form:label path="lastname"><spring:message code="label.lastname"/></form:label></td>
        <td><form:input path="lastname" /></td>
    </tr>
    <tr>
        <td><form:label path="email"><spring:message code="label.email"/></form:label></td>
        <td><form:input path="email" /></td>
    </tr>
    <tr>
        <td><form:label path="telephone"><spring:message code="label.telephone"/></form:label></td>
        <td><form:input path="telephone" /></td>
    </tr>
    <tr>
        <td><form:label path="jobid"><spring:message code="label.jobid"/></form:label></td>
        <td><form:input path="jobid" /></td>
    </tr>
    <tr>
        <td><form:label path="salary"><spring:message code="label.salary"/></form:label></td>
        <td><form:input path="salary" /></td>
    </tr>
    <tr>
        <td><form:label path="managerid"><spring:message code="label.managerid"/></form:label></td>
        <td><form:input path="managerid" /></td>
    </tr>
    <tr>
        <td><form:label path="departmentid"><spring:message code="label.departmentid"/></form:label></td>
        <td><form:input path="departmentid" /></td>
    </tr>
    

    
</table> 
<br>
<table>
	<tr>
    	<td colspan="2">
            <input type="submit" value="<spring:message code="label.save"/>"/>
        </td>
    </tr>
</table>
</center>
</form:form>

</body>
</html>