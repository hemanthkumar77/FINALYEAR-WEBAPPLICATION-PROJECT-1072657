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
                <th>COURSE_ID</th>
                <th>COURSE_NAME</th>
                <th>CREDITS</th>
                 <th>PROFESSOR</th>
                 <th>DAYS</th>
                 <th>TIMINGS</th>
                 <th>SEMESTER</th>
                 <th>HEAD_APPROVAL</th>
                 <th>ADMIN_APPROVAL</th>
                 <th>ADD/DECLINE/DROP</th>
            </tr>
            <c:forEach var="obj" items="${obj}">
            <c:url var="approved" value="/admin/add">
            <c:param name="id" value="${obj.id}"></c:param>
            <c:param name="name" value="${obj.firstname}"></c:param>  
            <c:param name="dept" value="${obj.department}"></c:param>
            <c:param name="cou_id" value="${obj.course_id}"></c:param>
            <c:param name="cou_name" value="${obj.course_name}"></c:param>
            <c:param name="staff" value="${obj.staffname}"></c:param>
            <c:param name="cred" value="${obj.credits}"></c:param>
            <c:param name="sem" value="${obj.semester}"></c:param>
            </c:url>     
             <c:url var="drop" value="/admin/dropped">
            <c:param name="id" value="${obj.id}"></c:param>
            <c:param name="dept" value="${obj.department}"></c:param>
            <c:param name="cou_id" value="${obj.course_id}"></c:param>  
            </c:url>  
                <tr>
                    <td><c:out value="${obj.id}" /></td>
                    <td><c:out value="${obj.firstname}" /></td>
                    <td><c:out value="${obj.department}" /></td>
                    <td><c:out value="${obj.course_id}" /></td>
                    <td><c:out value="${obj.course_name}" /></td>
                    <td><c:out value="${obj.credits}" /></td>
                    <td><c:out value="${obj.staffname}" /></td>
                     <td><c:out value="${obj.days}" /></td>
                     <td><c:out value="${obj.timings}" /></td>
                     <td><c:out value="${obj.semester}" /></td>
                     <td><c:out value="${obj.head}"/></td>
                     <td><c:out value="${obj.admin}"/></td>
                     <td><a href="${approved}">APPROVE</a>
                       |
                       <a href="${drop}">DROP</a>
                     </td>
                </tr>
            </c:forEach>
        </table>
    </div>	
</table>
</body>
</html>