<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GRADES</title>
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
        <table border="1" cellpadding="3">
        <h3>FirstNAME:"${data.firstname}"</h3>
        <h3>LastName:"${data.lastname}"</h3>
        <h3>STUDENT_ID:"${data.id}"</h3>
        <h3>DEPARTMENT:"${data.department}"</h3>
        <h3>GPA:${GPA}</h3>
            <caption><h3>Courses_Grade</h3></caption>
            <tr>
               <th>COURSE_ID</th>
                <th>FINAL_GRADE</th>
            </tr>
            <c:forEach var="obj" items="${obj}">     
                <tr>
                    <td><c:out value="${obj.course_id}"/></td>
                     <td><c:out value="${obj.final_grade}"/></td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</table>
</body>
</html>