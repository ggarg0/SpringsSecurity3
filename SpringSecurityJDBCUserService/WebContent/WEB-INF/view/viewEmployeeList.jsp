<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Employee Management</title>
</head>
<body>
 
 <h2 id="banner" align="center">Employee Management System</h2>	<hr/>
 <h4><a href="addEmp">Add Employee</a>&nbsp;&nbsp;&nbsp;&nbsp;
  <a href="<c:url value='j_spring_security_logout'/>">Logout</a></h4>

<c:if  test="${!empty employeeList}">
<table class="data" border="1">
<tr>
    <th>Employee Id</th>
    <th>First Name</th>
    <th>Last Name</th>
    <th>Email</th>
    <th>Telephone</th>
    <th>Job Id</th>
    <th>Salary</th>
    <th>Manager Id</th>    
    <th>Department Id</th>
</tr>
<c:forEach items="${employeeList}" var="emp">
    <tr>
        <td><a href="editEmp/${emp.id}"> ${emp.id}</a></td>
        <td>${emp.firstname} </td>
        <td>${emp.lastname} </td>
        <td>${emp.email} </td>
        <td>${emp.telephone} </td>
        <td>${emp.jobid} </td>
                
        <td>${emp.salary}</td>
        <td>${emp.managerid}</td>
        <td>${emp.departmentid}</td>
       
    </tr>
</c:forEach>
</table>
</c:if>
 </center>
</body>
</html>