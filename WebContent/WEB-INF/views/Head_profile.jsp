<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/user.css">
</head>
<body>
<div id=support align="center">
<h2 align="center">Welcome, ${user}</h2>
<a href="/FINALYEAR-WEBAPPLICATION-PROJECT-1072657"><i>logout</i></i></a>
<hr>
<table align="center">

<tr>
<th><h3><i>STUDENT_ACADEMIC</i></h3></th>
<td><a href="stu_pro">Profiles</a></td>
</tr>

<tr>
<th><h3><i>Pending_Approvals</i></h3></th>
<td><a href="approvals">Approvals</a></td>
</tr>
<tr>

<tr>
<th><h3><i>Professor_Profiles</i></h3></th>
<td><a href="pro_pro">Details</a></td>
</tr>
</table>
</div>
</body>
</html>