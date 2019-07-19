<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Registration</title>
</head>
<body>
<hr>
<h1>Registration Form</h1>
<hr>
<form action="RegistrationController" method ="get">
<table>
<tr>
<td>First Name</td> <td><input type="text" name="fname" required="required"></td>
</tr>
<tr>
<td>Last Name</td> <td><input type="text" value="" name="lname" required="required"/>  </td>
</tr>

<tr>
<td>User name</td> <td><input type="text" value="" name="uname" required="required"/>  </td>
</tr>

<tr>
<td>Password</td> <td><input type="password" value="" name="password" required="required"/>  </td>
</tr>
<tr>
<td>User Type</td>
 <td>
	<select name="utype">
<option value="a">Admin</option>
<option value="e">Employee</option>
<option value="s" selected>Student</option>
</select>
  </td>
</tr>
<tr>
<td>DOB</td> <td><input type="Date" value="" name="dob" required="required" autofocus/>  </td>
</tr>
<tr>
<td><input type="reset" value="Clear" /> </td>
<td><input type="submit" value="Register" name="register"/>  </td>
</tr>
</table>
</form>
</body>
</html>