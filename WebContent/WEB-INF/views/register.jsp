<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/user.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/Javascript/script.js"></script>
</head>
<body>
<marquee><h2><i>WELCOME TO THE REGISTERATION PAGE</i></h2></marquee>
<div id=form1 align="center">
<form:form action="/FINALYEAR-WEBAPPLICATION-PROJECT-1072657/savedata" method="post" modelAttribute="save" >
		<h2 align="center">Registration form</h2>
		<span>${message}</span>
		<table align="center">
			<tr>
				<td>USERNAME</td>
				<td><form:input path="username" id="un"/></td>
				<td><form:errors path="username" cssClass="error"/></td>
			</tr>

			<tr>
				<td>PASSWORD</td>
				<td><form:password showPassword="false" path="password" id="up"/></td> 
				<td><form:errors path="password" cssClass="error"/></td>
			</tr>

             <tr>
				<td>UNIVERSITY_ID</td>
				<td><form:input path="pro.id" /></td>
				<td><form:errors path="pro.id" cssClass="error"/></td>
			</tr>

           <tr>
				<td>FIRST_NAME</td>
				<td><form:input path="pro.firstname" id="fn"/></td>
				<td><form:errors path="pro.firstname" cssClass="error"/></td>
			</tr>

            <tr>
				<td>LAST_NAME</td>
				<td><form:input path="pro.lastname" id="ln"/></td>
				<td><form:errors path="pro.lastname" cssClass="error"/></td>
			</tr>
          
           <tr>
				<td>AGE</td>
				<td><form:input path="pro.age" id="ag"/></td>
				<td><form:errors path="pro.age" cssClass="error"/></td>
			</tr>
          
             <tr>
				<td>ROLE:</td>
				<td><form:select path="pro.role">
						<form:options items="${role}" />
					</form:select></td>
					<td><form:errors path="pro.role" cssClass="error"/></td>
                 </td>
			</tr>
			
			 <tr>
				<td>DEPARTMENT_NAME:</td>
				<td><form:select path="pro.department">
						<form:options items="${department}" />
					</form:select></td>
					<td><form:errors path="pro.department" cssClass="error"/></td>
                 </td>
			</tr>
		
		    <tr>
				<td>GENDER:</td>
				<td><form:select path="pro.gender">
						<form:options items="${gender}" />
					</form:select></td>
					<td><form:errors path="pro.gender" cssClass="error"/></td>
                 </td>
			</tr>
			
			<tr>
				<td>DOB:</td>
				<td><form:input path="pro.DOB" id="db"/></td>
				<td><form:errors path="pro.DOB" cssClass="error"/></td>
			</tr>
			
			<tr>
				<td>EMAIL</td>
				<td><form:input path="pro.email_id" /></td>
				<td><form:errors path="pro.email_id" cssClass="error"/></td>
			</tr>
			
			<tr>
				<td>PHONE_NUMBER</td>
				<td><form:input path="pro.number"  id="pn"/></td>
				<td><form:errors path="pro.number" cssClass="error"/></td>
			</tr>
						
			<tr>
				<td>ADDRESS</td>
				<td><form:textarea path="pro.address"/></td>
				<td><form:errors path="pro.address" cssClass="error"/></td>
			</tr>	
			<tr>
				<td><input type="submit" value="Register" onclick="fun()"></td>
			</tr>
		</table>

	</form:form>
	</div>
</body>
</html>