<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SEARCH</title>
<script type="text/javascript">
function data()
{
	val3=document.getElementById("CD");
    er3=document.getElementById("err2");
    exp3=/^UB-[A-Z]{4}-[0-9]{4}$/;
      if(val3.value=="")
			{
				er3.innerHTML="please fill the username";
				return false;
			}
			else if(exp3.test(val3.value)==false)
			{
				er3.innerHTML="UB-CPCS-1000";
				val3.focus();
				return false;
			}
			else
			{
				er3.innerHTML="";
			}		
}

</script>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/user.css">
</head>
<body>
<h2 align="center">Search</h2>
<div id="val">
<form action="calculations" method="post" onsubmit="return data()">
<table>
<tr>
<th>COURSE_ID</th>
<td><input type="text" id="CD" name="CD"></td>
<td><span id="err2"></span></td>
</tr>
<tr>
<th>SEMESTER</th>
<td>
<select name="dropdown">
  	<option value="fall"selected>FALL</option>
    <option value="spring">SPRING</option>
  	<option value="summer">SUMMER</option>  
</select>
</td>
</tr>
<tr>
<td><input type="submit" value="check"></td>
</tr>
</table>
</form>
<span style="color: red;text-align:center">${error}</span>
</div>
</body>
</html>