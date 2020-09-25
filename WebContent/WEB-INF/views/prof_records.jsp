<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
table
		{
			border: 3px solid red;
		}
		tr:nth-child(odd)
		{
			color: blue;
			background-color: green;
			text-align: justify;
		}
		tr:nth-child(even)
		{
			color: green;
			background-color: yellow;
			text-align: justify;
		}
		td:hover {
       color: hotpink;
        }
</style>
<title>Professor details</title>
</head>
<body>
<div align="center">
        <table border="1" cellpadding="5">
            <caption><h3>List of courses</h3></caption>
             <caption><span>${invalid}</span></caption>
            <tr>
                <th>STAFF_ID</th>
                <th>FIRST_NAME</th>
                <th>LAST_NAME</th>
                 <th>ROLE</th>
                 <th>DEPARTMENT</th>
                 <th>EMAIL_ID</th>
            </tr>
            <c:forEach var="obj" items="${obj}">  
                <tr>
                    <td><c:out value="${obj.id}" /></td>
                    <td><c:out value="${obj.firstname}" /></td>
                    <td><c:out value="${obj.lastname}" /></td>
                    <td><c:out value="${obj.role}" /></td>
                     <td><c:out value="${obj.department}" /></td>
                     <td><c:out value="${obj.email_id}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</table>
</body>
</html>