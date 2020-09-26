<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
                <th>CREDITS</th>
                 <th>SEMESTER</th>
                 <th>ADD_GRADE_PORTAL</th>
            </tr>
            <c:forEach var="obj" items="${obj}">  
             <c:url var="ADD" value="/professor/grade_pro">
            <c:param name="id" value="${obj.id}"></c:param>
            <c:param name="dept" value="${obj.department}"></c:param>
            <c:param name="name" value="${obj.studentname}"></c:param>
            <c:param name="semester" value="${obj.semester}"></c:param>
             <c:param name="cou_id" value="${obj.course_id}"></c:param>
            </c:url>   
                <tr>
                    <td><c:out value="${obj.id}" /></td>
                    <td><c:out value="${obj.studentname}" /></td>
                    <td><c:out value="${obj.department}" /></td>
                    <td><c:out value="${obj.credits}" /></td>
                     <td><c:out value="${obj.semester}" /></td>
                      <td><a href="${ADD}">ADD_TO_GRADES</a></td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</table>
</body>
</html>