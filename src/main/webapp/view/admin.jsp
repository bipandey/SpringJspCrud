<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>hey</title>
</head>
<body>
<form action="/createUser" method="post">
		<div align="center">
			<h2>User Details</h2>
			<table>
				<p>Hello :${userRole }</p>
				<tr>
					<td>UserName:</td>
					<td><input type="text" name="userName" /></td>
				</tr>
				<tr>
					<td>UserDob:</td>
					<td><input type="text" name="userDob" /></td>
				</tr>
				<tr>
					<td>UserAge:</td>
					<td><input type="text" name="userAge" /></td>
				</tr>
				<tr>
					<td>UserSex:</td>
					<td><input type="radio" name="userSex" value="M" />Male <input
						type="radio" name="userSex" value="F" />Female</td>
				</tr>

				<tr>
					<td><input type="submit" name="AddUser" value="Adduser" />

						<p>${msg}</p>
						
						<input type="hidden" name="userRole" value="${userRole}">
						
			</table>
		</div>
		<%-- <table>
 <c:forEach var="user" items="${userDetail}">
                <tr>
                    <td><c:out value="${user.userName}" /></td>
                    <td><c:out value="${user.userDob}" /></td>
                    <td><c:out value="${user.userAge}" /></td>
                    <td><c:out value="${user.userSex}" /></td>         
                </tr>
            </c:forEach>
</table> --%>
	
		<!-- <form action="/viewUser" method="get" >
<input type="submit" value="ViewUsers"/>
 -->
	
		</form>
</body>
</html>