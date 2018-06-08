<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"></c:set>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Transaction History</title>
</head>
<body>

	<table border="1">
		<tr>
			<th>Userid</th>
			<th>Username</th>
			<th>Transaction Id</th>
			<th>Amount</th>
			<th>Date</th>
			<th>CoinA</th>
			<th>CoinB</th>
		</tr>
		<c:forEach items="${transactionList}" var="transaction">
			<tr>
				<td>${transaction.user.userId}</td>
				<td>${transaction.user.username}</td>
				<td>${transaction.transactionid}</td>
				<td>${transaction.amount}</td>
				<td>${transaction.date}</td>
				<c:forEach items="${transaction.coins}" var="coin">
					<td>${coin}</td>
				</c:forEach>
		</c:forEach>
		</table>
</body>
</html>