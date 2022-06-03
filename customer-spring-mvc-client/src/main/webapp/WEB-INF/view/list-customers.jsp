<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>LIST CUSTOMERS training CK</title>

	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	<script src="https://cdn.jsdelivr.net/npm/jquery@3.2.1/dist/jquery.min.js"></script>
	
	<link rel="stylesheet" href="css/list-customers.css">
	<%-- <link rel="stylesheet" href="${pageContext.request.contextPath}/list-customers.css"> --%>	
</head>
<body>
	<div class="head">
		<h2>Customers</h2>
	</div>
	<div>
		<!-- <button style="background-color: lightgray; margin-top: 2%; margin-left: 20px;">Add Student</button> -->
		<input class="btnAdd" type="button" value="Add Customer" 
				onclick="window.location.href='showFormAdd'; return false;">
	</div>
	
	<!-- list customers -->
	<table class="table" border=1>
		<thead>
			<tr>
				<!-- <th>ID</th> -->
				<th>First Name</th>
				<th>Last name</th>
				<th>Email</th>

				<th>Chức năng</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="customer" items="${listCustomers}">
				<c:url var="deleteLink" value="deleteCustomer">
					<c:param name="customerId" value="${customer.id}" />
				</c:url>

				<c:url var="updateLink" value="showFormUpdate">
					<c:param name="customerId" value="${customer.id}" />
				</c:url>
				
				<tr>
					<%-- <td>${student.id}</td> --%>
					<td>${customer.firstName}</td>
					<td>${customer.lastName}</td>
					<td>${customer.email}</td>
					<td>
						<a href="${deleteLink}" onclick="if(!(confirm('Bạn muốn xóa khách hàng này?'))) return false;">Xóa</a> | 
						<%-- <a href="${loadLink}" onclick="window.location.href='update-student-form.jsp'; return false;">Update</a> --%>
						<%-- <a href="update-student-form.jsp?studentId=${student.id} &firstName=${student.firstName} &lastName=${student.lastName} &email=${student.email}" onclick="window.location.href='update-student-form.jsp'; return false;">Cập nhật</a> --%>
						<a href="${updateLink}">Cập nhật</a>
					</td>
				</tr>
			</c:forEach>			
		</tbody>
	</table>
	
</body>
</html>