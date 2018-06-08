<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View News Here</title>
</head>
<body>

			
			<table border="1">
				<tr>
					<th>Date</th>
					<th>Coin</th>
					<th>News</th>
				</tr>
				<c:forEach items="${newslist}" var="news">
					<tr>
						<td>${news.dateCreated}</td>
						<td>${news.coinConcern}</td>
						<td>${news.message}</td>
					</tr>
				</c:forEach>
			</table>



</body>
</html>