<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>profile</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/user.css">
</head>
<body>
<div id=support align="center">
<h2 align="center">Welcome, ${user}</h2>
<a href="/FINALYEAR-WEBAPPLICATION-PROJECT-1072657"><i>logout</i></i></a>
<hr>
<table align="center">
<tr>
<th><h3><i>Courses</i></h3></th>
<td><a href="course">Courses_Info</a></td>
</tr>
<tr>
<th><h3><i>New_Course</i></h3></th>
<td><a href="add_course">Add</a></td>
</tr>
<tr>
<th><h3><i>Final_course_Approval</i></h3></th>
<td><a href="confirmation">Approval</a></td>
</tr>
<tr>
<th><h3><i>Professor_details</i></h3></th>
<td><a href="pro_details">DETAILS</a></td>
</tr>
</table>
</div>
</body>
</html>