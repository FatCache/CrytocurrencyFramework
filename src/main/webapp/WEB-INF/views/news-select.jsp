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
<title>Select News Here</title>
</head>
<body>

<form action="${contextPath}/news/view" method="post">
				Select Coin for News: 
				<select name="coin">
					<c:forEach items="${coinmap}" var="item">
				<option value="${item.key}">${item.value}</option>
			</c:forEach>
				</select> <input type="submit" value="View The News" />"
			</form>

</body>
</html>