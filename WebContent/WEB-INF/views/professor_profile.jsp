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
<div id=val align="center">
<h3 align="center">Welcome, ${user}</h3>
<a href="/FINALYEAR-WEBAPPLICATION-PROJECT-1072657"><i>logout</i></i></a>
<hr>
<table align="center">
<tr>
<th><h4><i>Student_List</i></h4></th>
<td><a href="list">Courses_Info</a></td>
</tr>
<tr>
<th><h4><i>Grades_evaluations</i></h4></th>
<td><a href="grades">Results</a></td>
</tr>
</table>
</div>
</body>
</html>