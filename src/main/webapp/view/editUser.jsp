<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="/updateUserDetail" method="post">
Hello ${ userRole} edit user= ${userName }
<table>
<c:forEach var="user" items="${userDetail}">
<tr>
<th>NAME</th><th>Dob</th><th>AGE</th><th>SEX</th></tr>
<tr><td><input type="text" value="${user.userName}" name="userName"/></td>
<td><input type="text" value="${user.userDob}" name="userDob"/></td>
<td><input type="text" value="${user.userAge}" name="userAge"/></td>
<td><input type="text" value="${user.userSex}" name="userSex"/></td>
<td><input type="hidden" value="${user.u_id }" name="u_id"/></td>
</tr>
</c:forEach>
</table>
<input type="submit" value="submit"/>
<input type="hidden" value="${userRole }" name="userRole"/>

</form>
</body>
</html>
