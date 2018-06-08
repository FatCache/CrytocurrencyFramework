<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Dashboard</title>
</head>
<body>

	<c:choose>
		<c:when test="${userRole == 'admin'}">
			<h1>Welcome Admin</h1>
			<H3>God Mode over coin, transaction history & news</H3>

			<a href="${contextPath}/coin/manage">Manage Coins</a>
			<a href="${contextPath}/transaction/manageadmin">View All Transaction</a>
			<a href="${contextPath}/news/createnews">Create News</a>
		</c:when>
		<c:otherwise>
			<h1>Welcome Humble User Username -> ${user.username}</h1>

			<a href="${contextPath}/transaction/create?personid=${user.personid}">Create Transaction</a>
			<a href="${contextPath}/transaction/viewtransaction?personid=${user.personid}">View Transaction History</a>
			<a href="${contextPath}/news/view">View News</a>
		</c:otherwise>
	</c:choose>




</body>
</html>