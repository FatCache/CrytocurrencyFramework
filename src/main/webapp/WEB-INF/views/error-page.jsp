<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Error Slash Success Page</title>
</head>
<body>

	<h2>Test-Page</h2>

	<c:choose>
		<c:when test="${empty errorMessage}"> No Error Message!</c:when>
		<c:otherwise>Well... ${errorMessage}</c:otherwise>
	</c:choose>

	<p>${user.username}</p>
	<h2>${user.userBankDetail.csv}</h2>
	<h2>${user.userBankDetail.bankName}</h2>

	<h3>${coin.name}</h3>
	<h3>${coin.coinType}</h3>
	<h3>${coin.worth}</h3>
	
	<h3>${news.messageId}</h3>
	<h3>${news.message}</h3>
	<h3>${news.coinConcern}</h3>
	<h3>${news.dateCreated}</h3>


</body>
</html>
