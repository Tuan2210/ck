<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>FORM CUSTOMER</title>
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.2.1/dist/jquery.min.js"></script>
</head>
<body>
	<div id="wrapper" style="background-color: #0073cf; color: white; padding: 4px 5% 4px 5%;">
		<div id="header">
			<h2>Form Customer</h2>
		</div>
	</div>
	
	<div id="container">
		<form:form action="saveCustomer" modelAttribute="customer" method="GET">
			<form:hidden path="id"/>
			<table>
				<tr>
					<td>First Name: </td>
					<td><form:input path="firstName" value="${customer.firstName}"/></td>
				</tr>
				<tr>
					<td>Last Name: </td>
					<td><form:input path="lastName" value="${customer.lastName}"/></td>
				</tr>
				<tr>
					<td>Email: </td>
					<td><form:input path="email" value="${customer.email}"/></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="Lưu" class="button"></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>