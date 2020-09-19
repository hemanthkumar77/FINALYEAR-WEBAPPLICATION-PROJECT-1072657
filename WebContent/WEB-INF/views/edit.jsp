<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>UPDATE_COURSE</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/user.css">
</head>
<body>
<div id=form1 align="center">
<form:form action="data_update" method="post" modelAttribute="object" >
		<h2 align="center">UPDATE COURSE</h2>
		<table align="center">
			<tr>
				<td>COURSE_ID</td>
				<td><form:input path="course_id" readonly="true"/></td>
			</tr>

			<tr>
				<td>COURSE_NAME</td>
				<td><form:input path="course_name" /></td> 
				<td><form:errors path="course_name" cssClass="error"/></td>
			</tr>

             <tr>
				<td>COURSE CREDITS</td>
				<td><form:input path="credits" /></td>
				<td><form:errors path="credits" cssClass="error"/></td>
			</tr>

           <tr>
				<td>PROFESSOR</td>
				<td><form:input path="staffname"/></td>
				<td><form:errors path="staffname" cssClass="error"/></td>
			</tr>
		    <tr>
				<td>TIMINGS</td>
				<td><form:input path="timings"/></td>
				<td><form:errors path="timings" cssClass="error"/></td>
			</tr>
		
             <tr>
				<td>DAYS:</td>
				<td><form:select path="days">
						<form:options items="${role}" />
					</form:select></td>
					<td><form:errors path="days" cssClass="error"/></td>
                 </td>
			</tr>
			 <tr>
				<td>SEMESTER:</td>
				<td><form:select path="semester">
						<form:options items="${sem}" />
					</form:select></td>
					<td><form:errors path="semester" cssClass="error"/></td>
                 </td>
			</tr>	
			<tr>
				<td><input type="submit" value="update"></td>
			</tr>
		</table>

	</form:form>
	</div>
</body>
</html>