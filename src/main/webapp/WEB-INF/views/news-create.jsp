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
<title>Create New News Here</title>
</head>
<body>
<h3>Create News for Any Coin Type!</h3>


<form:form commandName="news"
		action="${contextPath}/news/createnews" method="post">
		<table>
			<tr>
				<td>Enter News Report Here:</td>
				<td><form:textarea path="message" row="5" size="30"
						required="required" /></td>
			</tr>
			<tr>
				<td>News for the Coin</td>
				<td><form:select id="coinAid" path="coinConcern" multiple="false"
						required="required">
						<form:option value="NONE" label="--- Select ---" />
						<form:options items="${coinlist}" />
					</form:select></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" value="Create News" /></td>
			</tr>
		</table>
	</form:form>


</body>
</html>