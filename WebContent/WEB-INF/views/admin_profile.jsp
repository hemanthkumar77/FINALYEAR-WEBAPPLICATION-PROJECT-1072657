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
<hr>
<table align="center">

<tr>
<th><h2><i>Courses</i></h2></th>
<td><a href="course">Courses_Info</a></td>
</tr>
<tr>

<th><h2><i>Final_Result</i></h2></th>
<td><a href="semester_grades">Results</a></td>
</tr>

<tr>
<th><h2><i>New_Course</i></h2></th>
<td><a href="add_course">Add</a></td>
</tr>
<tr>

<th><h2><i>Final_course_Approval</i></h2></th>
<td><a href="confirmation">Approval</a></td>
</tr>

<tr>
<th><h2><i>Course_Fees</i></h2></th>
<td><a href="Fee_structure">Financial_Document</a></td>
</tr>

<tr>
<th><h2><i>Professor_Results</i></h2></th>
<td><a href="dept_results">Results</a></td>
</tr>
</table>
</div>
</body>
</html>