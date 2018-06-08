<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page	contentType="text/html" pageEncoding="UTF-8"%><!DOCTYPE html>


<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Coin</title>
</head>
<body>

	<h2>Create New Crypto-currency Coin</h2>
	<form:form commandName="coin" action="${contextPath}/coin/createcoin" method="post">
		<table>
			<tr>
				<td>Coin Name:</td>
				<td><form:input path="name" size="30" required="required" /></td>
			</tr>
			<tr>
				<td>Worth:</td>
				<td><form:input path="worth" size="30" required="required" /></td>
			</tr>
			<tr>
				<td>Coin Type:</td>
				<td><form:input path="coinType" size="30" required="required" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Create Coin" /></td>
			</tr>
		</table>
	</form:form>

</body>
</html>