<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Canvas</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/user.css">
</head>
<body>
<div id=support align="center">
<h2 align="center">Welcome,${user}</h2>
<a href="/FINALYEAR-WEBAPPLICATION-PROJECT-1072657"><i>logout</i></i></a>
<hr>
<table align="center">

<tr>
<th><h2><i>STUDENT PROFILE</i></h2></th>
<td><a href="update_profile">EDIT PROFILE</a></td>
</tr>
<tr>

<th><h2><i>GRADES</i></h2></th>
<td><a href="grades">CURRENT_GARDES</a></td>
</tr>

<tr>
<th><h2><i>GRADE_SHEETS</i></h2></th>
<td><a href="marksheets">MARKSHEETS</a></td>
</tr>
<tr>

<th><h2><i>REGISTER_SECTION</i></h2></th>
<td><a href="course_section">COURSES</a></td>
</tr>

<tr>
<th><h2><i>REGISTERED_COURSES</i></h2></th>
<td><a href="register">REGISTERED</a></td>
</tr>

<tr>
<th><h2><i>COURSES</i></h2></th>
<td><a href="search">Courses</a></td>
</tr>

<tr>
<th><h2><i>Course_Fees</i></h2></th>
<td><a href="Fees">Financial_Document</a></td>
</tr>
</table>
</div>
</body>
</html>