<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix="fn" 
           uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:if test="${userRole=='admin'}">

<div align="center" style="margin-top: 100px;">
<h2>welcomem ${userRole} :${userId} </h2>

<input type="submit" value="Add User" onclick="window.location.href='/addUser?id=${userRole}'" style="height:100px;width:100px;color:black;" />

<input type="submit" value="View Details" onclick="window.location.href='/viewUser?id=${userRole}' " style="height:100px;width:100px;color:black;"/>

</div>

</c:if>


<c:if test="${userRole=='user'}">

<div align="center" style="margin-top: 100px;">
<h2> WELCOME ${userRole}: ${userId} </h2><p>you can only perform read operation</p>
<form action="/viewUser" method="get">
<input type="submit" value="View Details" onclick="window.location.href='/viewUser?id=${userRole}'" style="height:100px;width:200px;color:red;">
</form>
</div>

</c:if>
</body>
</html>