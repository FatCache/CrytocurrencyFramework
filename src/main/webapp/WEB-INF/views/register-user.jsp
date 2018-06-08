<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Add User Form</title>
</head>
<body>

	<c:set var="contextPath" value="${pageContext.request.contextPath}" />

	<a href="${contextPath}">Go Back</a>
	<br />

	<h2>Register a New User</h2>

	<form:form action="${contextPath}/user/register"
		commandName="user" method="post">

		<table>
			<tr>
				<td>First Name:</td>
				<td><form:input path="firstname" size="30"
						required="required" /> <font color="red"><form:errors
							path="firstname" /></font></td>
			</tr>

			<tr>
				<td>Last Name:</td>
				<td><form:input path="lastname" size="30"
						required="required" /> <font color="red"><form:errors
							path="lastname" /></font></td>
			</tr>


			<tr>
				<td>User Name:</td>
				<td><form:input path="username" size="30" required="required" />
					<font color="red"><form:errors path="username" /></font></td>
			</tr>

			<tr>
				<td>Password:</td>
				<td><form:password path="password" size="30"
						required="required" /> <font color="red"><form:errors
							path="password" /></font></td>
			</tr>

			<tr>
				<td colspan="2"><input type="submit" value="Register User" /></td>
			</tr>
		</table>

	</form:form>

</body>
</html>