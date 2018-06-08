<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%><%@taglib
	uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%><%@page
	contentType="text/html" pageEncoding="UTF-8"%>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Register Bank</title>
</head>
<body>

	<h2>Please Enter User Bank Details</h2>
	<h3>Welcome -> ${sessionScope.userid}</h3> 
	<form:form commandName="userbankdetails" action="${contextPath}/user/registerbank" method="post">
	<form:hidden path="passedByUserId" value="${sessionScope.userid}" />
		<table>
			<tr>
				<td>Balance:</td>
				<td><form:input type="text" path="balance" size="30" required="required"/></td>
			</tr>
			<tr>
				<td>Bank Name:</td>
				<td><form:input type="text" path="bankName" size="30" required="required"/></td>
			</tr>
			<tr>
				<td>Credit Card Number:</td>
				<td><form:input type="text" path="creditCardNumber" size="30" required="required"/></td>
			</tr>
			<tr>
				<td>CSV:</td>
				<td><form:input type="text" path="csv" size="30" required="required"/></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Submit Bank Detials" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>