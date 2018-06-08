<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<html>
<head>
<style>
ff {
	color: red;
	margin: 4px;
}

b {
	color: blue;
}
</style>
<script
	src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script src="https://code.jquery.com/jquery-1.10.2.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Transaction</title>
</head>
<body>
	<div data-ng-app="" data-ng-init="balance=${balance};amount=0">

		<hr />

		<form:form commandName="transaction"
			action="${contextPath}/transaction/create" method="post">
			<form:hidden path="passedByPersonId" value="${sessionScope.personid}" />
			<table>
				<tr>
					<td>Amount:</td>
					<td><form:input type="text" path="amount" size="30"
							required="required" ng-model="amount" /></td>
				</tr>
				<tr>
					<td>Coin A:</td>
					<td><form:select id="coinAid" path="coinA" multiple="false"
							required="required">
							<form:option value="NONE" label="--- Select ---" />
							<form:options items="${coinlist}" />
						</form:select></td>
				</tr>
				<tr>
					<td>Coin B:</td>
					<td><form:select id="coinBid" path="coinB" multiple="false"
							required="required">
							<form:option value="NONE" label="--- Select ---" />
							<form:options items="${coinlist}" />
						</form:select>
				</tr>
				<tr>
					<td colspan="2"><input type="submit"
						value="Create Transaction" /></td>
				</tr>
			</table>
		</form:form>
		<hr />

		<h3>Balance Difference</h3>
		<p>
			<b>Your Balance remaining</b> {{balance - amount}}
		</p>

		<hr />


		<h3>Conversion Ratio</h3>
		<coina id="coinAid-ajax"></coina>
		<p></p>
		<coinb id="coinBid-ajax"></coinb>
		<hr />
		Conversion Rate between the two currencies

		<button onclick="ajaxEvent()">Estimate Conversion Rate</button>
		<div id="conversiondiv"></div>

		<script>
			function displayVals() {
				var coinAid = $("#coinAid").val();
				var coinBid = $("#coinBid").val();
				$("coina").html(coinAid);
				$("coinb").html(coinBid);
			}

			$("select").change(displayVals);
			displayVals();
		</script>

		<script>
			function ajaxEvent() {

				var xmlHttp;
				try // Firefox, Opera 8.0+, Safari
				{
					xmlHttp = new XMLHttpRequest();
				} catch (e) {
					try // Internet Explorer
					{
						xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
					} catch (e) {
						try {
							xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
						} catch (e) {
							alert("Your browser does not support AJAX!");
							return false;
						}
					}
				}

				xmlHttp.onreadystatechange = function() {
					if (xmlHttp.readyState == 4) {
						document.getElementById("conversiondiv").innerHTML = xmlHttp.responseText;
					}
				}

				var queryCoinA = document.getElementById("coinAid-ajax").innerHTML;
				var queryCoinB = document.getElementById("coinBid-ajax").innerHTML;
				xmlHttp.open("POST", "../transaction/fireupajax?coinA="
						+ queryCoinA + "&coinB=" + queryCoinB, true);
				xmlHttp.send();
			}
		</script>
</body>
</html>