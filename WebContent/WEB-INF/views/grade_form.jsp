<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GRADE_EVALUATIONS</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/user.css">
<script type="text/javascript" src="${pageContext.request.contextPath}/Javascript/script.js"></script>
</head>
<body>
<div id=form1 align="center">
<form:form action="update_stugrades" method="post" modelAttribute="obj" >
<table align=center>
             <h2><i>profile_update</i></h2>
             <tr>
				<td>UNIVERSITY_ID</td>
				<td><form:input path="id" readonly="true"/></td>
				<td><form:errors path="id" cssClass="error"/></td>
			</tr>
            <tr>
				<td>NAME</td>
				<td><form:input path="name" readonly="true"/></td>
				<td><form:errors path="name" cssClass="error"/></td>
			</tr>
          
           <tr>
				<td>DEPARTMENT</td>
				<td><form:input path="dept" readonly="true"/></td>
				<td><form:errors path="dept" cssClass="error"/></td>
			</tr>
           <tr>
				<td>COURSE_ID</td>
				<td><form:input path="course_id" readonly="true"/></td>
				<td><form:errors path="course_id" cssClass="error"/></td>
			</tr>
            <td>ASSIGNMENT:</td>
				<td><form:select path="assignment">
						<form:options items="${gra}" />
					</form:select></td>
					<td><form:errors path="assignment" cssClass="error"/></td>
                 </td>
              </tr>
			<tr>
			<td>PROJECTS:</td>
				<td><form:select path="project">
						<form:options items="${gra}" />
					</form:select></td>
					<td><form:errors path="project" cssClass="error"/></td>
                 </td>
		</tr>
		<tr>
		   <td>MIDTERM:</td>
				<td><form:select path="midterm">
						<form:options items="${gra}" />
					</form:select></td>
					<td><form:errors path="midterm" cssClass="error"/></td>
                 </td>
			</tr>
			<tr>
			<td>FINALS:</td>
				<td><form:select path="finals">
						<form:options items="${gra}" />
					</form:select></td>
					<td><form:errors path="finals" cssClass="error"/></td>
                 </td>
			</tr>
			<tr>
				<td>FINALGRADE:</td>
				<td><form:select path="final_grade">
						<form:options items="${gra}" />
					</form:select></td>
					<td><form:errors path="final_grade" cssClass="error"/></td>
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