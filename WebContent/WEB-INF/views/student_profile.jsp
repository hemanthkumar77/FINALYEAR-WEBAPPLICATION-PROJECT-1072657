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
<th><h3><i>STUDENT PROFILE</i></h3></th>
<td><a href="update_profile">EDIT PROFILE</a></td>
</tr>
<tr>

<th><h3><i>GRADES</i></h3></th>
<td><a href="grades">CURRENT_GARDES</a></td>
</tr>

<tr>
<th><h3><i>GRADE_SHEETS</i></h3></th>
<td><a href="marksheets">MARKSHEETS</a></td>
</tr>
<tr>

<th><h3><i>REGISTER_SECTION</i></h3></th>
<td><a href="pending_approval">COURSES</a></td>
</tr>

<tr>
<th><h3><i>REGISTERED_COURSES</i></h3></th>
<td><a href="register">REGISTERED</a></td>
</tr>

<tr>
<th><h3><i>COURSES</i></h3></th>
<td><a href="search">Courses</a></td>
</tr>
</table>
</div>
</body>
</html>