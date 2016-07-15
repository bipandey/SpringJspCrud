<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/submitLogin" method="post">
<div align="center" title="Login details">
<h2>Login Details</h2>
<table>

<tr><td>UserID:</td><td><input type="text" name="userId"/></td></tr>

<tr><td>UserPassword:</td><td><input type="password" name="userPassword"/></td></tr>

<tr><td>Role:<select name="userRole">
    <option value="admin">Admin</option>
    <option value="user">User</option>
  </select></td></tr>

<tr><td><input type="submit" value="submit"/></td></tr>

<h2>${msg}</h2>
</table>
</div>
</form>
</body>
</html>