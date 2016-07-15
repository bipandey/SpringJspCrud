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

<div align="center" title="UserDetails" ><h2>User Details</h2>
<table border="1" cellpadding="5">
            <caption><h2>List of users</h2></caption>
            <tr>
                <th>Name</th>
                <th>DOB</th>
                <th>AGE</th>
                <th>SEX</th>
                <th>Action</th>
                <!-- <th>Action</th> -->
            </tr>
            <c:forEach var="user" items="${userDetail}">
                <tr>
                    <td><c:out value="${user.userName}" /></td>
                    <td><c:out value="${user.userDob}" /></td>
                    <td><c:out value="${user.userAge}" /></td>
                    <td><c:out value="${user.userSex}" /></td>
               <td>
                        
                        <c:if test="${userRole=='admin'}">
        
                        <input type="submit" value="delete" onclick="window.location.href='/deleteUser?id1=${user.userName}&id2=${userRole}'"  />
                       <input type="submit" value="edit" onclick="window.location.href='/editUser?id1=${user.userName}&id2=${userRole}'"  />
                       
                        </c:if>
                     
                    </td>
               
                </tr>
            </c:forEach>
        </table>
         <p>${msg} ${userName}</p>
</div>
</body>
</html>