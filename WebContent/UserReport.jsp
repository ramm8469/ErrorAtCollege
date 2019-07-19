<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="java.util.*"  %>
    <%@ page import="com.project.model.*" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UserReport</title>
</head>
<body>


<%
	List<User> list = (List<User>)request.getAttribute("user_list");
%>

<table border="1" height="50%" width="60%">
		<tr>
			<td>First Name</td>
			<td>Last Name</td>
			<td>User Name</td>
			<td>DOB</td>
		</tr>
		<%
			for(User u : list) {
		%>
		<tr>
			<td><%=u.getFirstName()%></td>
			<td><%=u.getLastName()%></td>
			<td><%=u.getUserName()%></td>
			<td><%=u.getDob()%></td>
		</tr>

		<%
			}
		%>



	</table>
</body>
</html>