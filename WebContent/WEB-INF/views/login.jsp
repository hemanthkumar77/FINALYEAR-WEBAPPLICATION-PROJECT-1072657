<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
<script type="text/javascript" src="${pageContext.request.contextPath}/Javascript/script.js"/>
</script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/user.css">
</head>
<body>
<h2 align="center">LOGIN PAGE</h2>
<div id="val">
<form action="/FINALYEAR-WEBAPPLICATION-PROJECT-1072657/validate" method="post" onsubmit="return check()">
<table>
<tr>
<th>User_Name</th>
<td><input type="text" id="UN" name="UN"></td>
 <td><span id="er1"></span></td>
</tr>
<tr>
<th>Password</th>
<td><input type="text" id="PA" name="PA"></td>
<td><span id="er2"></span></td>
</tr>
<tr>
<th>Roles</th>
<td>
<select name="dropdown">
  	<option value="GRADUATE">GRADUATE</option>
    <option value="UNDER-GRADUATE">UNDER-GRADUATE</option>
  	<option value="SENIOR-PROFESSOR" selected>SENIOR-PROFESSOR</option>
  	<option value="ASSISTANT-PROFESSOR">ASSISTANT-PROFESSOR</option>
    <option value="ADMIN">ADMIN</option>
    <option value="DEPARTMENT-HEAD">DEPARTMENT-HEAD</option>    
</select>
</td>
</tr>
<tr>
<td><input type="submit" value="Login"></td>
</tr>
</table>
</form>
<span style="color: red;text-align:center">${users}</span>
</div>
</body>
</html>