<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Course_Details</title>
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
</head>
<body>
<div align="center">
        <table border="1" cellpadding="5">
            <caption><h3>List of courses</h3></caption>
            <tr>
                <th>COURSE_ID</th>
                <th>COURSE_NAME</th>
                <th>CREDITS</th>
                 <th>PROFESSOR</th>
                 <th>DAYS</th>
                 <th>TIMINGS</th>
                 <th>SEMESTER</th>
                 <th>update|delete</th>
            </tr>
            <c:forEach var="obj" items="${obj}">
            <c:url var="data" value="/admin/update_val">
            <c:param name="set_id" value="${obj.course_id}"></c:param>
            </c:url>
            <c:url var="eliminate" value="/admin/delete_val">
            <c:param name="del_id" value="${obj.course_id}"></c:param>
            </c:url>
            
                <tr>
                    <td><c:out value="${obj.course_id}" /></td>
                    <td><c:out value="${obj.course_name}" /></td>
                    <td><c:out value="${obj.credits}" /></td>
                    <td><c:out value="${obj.staffname}" /></td>
                     <td><c:out value="${obj.days}" /></td>
                     <td><c:out value="${obj.timings}" /></td>
                     <td><c:out value="${obj.semester}" /></td>
                     <td>
                     <a href="${data}">update</a>
                     |
                     <a href="${eliminate}">delete</a>
                     </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</table>
</body>
</html>