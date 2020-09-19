<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PROFILE</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/user.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/Javascript/script.js"></script>
</head>
<body>
<div id=form1 align="center">
<form:form action="update_pro" method="post" modelAttribute="save" >
<table align=center>
             <h2><i>profile_update</i></h2>
             <tr>
				<td>UNIVERSITY_ID</td>
				<td><form:input path="id" readonly="true"/></td>
				<td><form:errors path="id" cssClass="error"/></td>
			</tr>

           <tr>
				<td>FIRST_NAME</td>
				<td><form:input path="firstname"/></td>
				<td><form:errors path="firstname" cssClass="error"/></td>
			</tr>

            <tr>
				<td>LAST_NAME</td>
				<td><form:input path="lastname" /></td>
				<td><form:errors path="lastname" cssClass="error"/></td>
			</tr>
          
           <tr>
				<td>AGE</td>
				<td><form:input path="age" /></td>
				<td><form:errors path="age" cssClass="error"/></td>
			</tr>
          
             <tr>
				<td>ROLE:</td>
				<td><form:input path="role" readonly="true"/></td>
					<td><form:errors path="role" cssClass="error"/></td>
                 </td>
			</tr>
			
			 <tr>
				<td>DEPARTMENT_NAME:</td>
				    <td><form:input path="department" readonly="true"/></td>
					<td><form:errors path="department" cssClass="error"/></td>
                 </td>
			</tr>
		
		    <tr>
				<td>GENDER:</td>
				<td><form:input path="gender" readonly="true"/></td>
					<td><form:errors path="gender" cssClass="error"/></td>
                 </td>
			</tr>
			
			<tr>
				<td>DOB:</td>
				<td><form:input path="DOB" readonly="true"/></td>
				<td><form:errors path="DOB" cssClass="error"/></td>
			</tr>
			
			<tr>
				<td>EMAIL</td>
				<td><form:input path="email_id" readonly="true"/></td>
				<td><form:errors path="email_id" cssClass="error"/></td>
			</tr>
			
			<tr>
				<td>PHONE_NUMBER</td>
				<td><form:input path="number"  id="pn"/></td>
				<td><form:errors path="number" cssClass="error"/></td>
			</tr>
						
			<tr>
				<td>ADDRESS</td>
				<td><form:textarea path="address"/></td>
				<td><form:errors path="address" cssClass="error"/></td>
			</tr>	
			<tr>
				<td><input type="submit" value="update" onclick="fun()"></td>
			</tr>
		</table>

	</form:form>
	</div>
</body>
</html>