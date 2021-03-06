<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Grades</title>
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
            <caption><h3>List of courses</h3></caption>
            <tr>
               <th>STUDENT_ID</th>
               <th>STUDENT_NAME</th>
               <th>DEPARTMENT</th>
                <th>ASSIGNMENT</th>
                 <th>PROJECT</th>
                 <th>MIDTERM</th>
                 <th>FINALS</th>
                 <th>FINAL_GRADE</th>
                 <th>UPDATE GRADES</th>
            </tr>
            <c:forEach var="obj" items="${obj}">  
             <c:url var="UPDATE" value="/professor/update">
            <c:param name="id" value="${obj.id}"></c:param>
            <c:param name="semester" value="${obj.semester}"></c:param>
             <c:param name="cou_id" value="${obj.course_id}"></c:param>
            </c:url>   
                <tr>
                    <td><c:out value="${obj.id}" /></td>
                    <td><c:out value="${obj.name}" /></td>
                    <td><c:out value="${obj.dept}" /></td>
                    <td><c:out value="${obj.assignment}" /></td>
                     <td><c:out value="${obj.project}" /></td>
                     <td><c:out value="${obj.midterm}" /></td>
                     <td><c:out value="${obj.finals}" /></td>
                     <td><c:out value="${obj.final_grade}" /></td>
                      <td><a href="${UPDATE}">UPDATE</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</table>
</body>
</html>