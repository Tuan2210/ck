<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form:form action="${pageContext.request.contextPath}/sanpham/saveSanPham" modelAttribute="sanpham" method="POST">
	<form:hidden path="id"/>
	Tên: <form:input path="tenSanPham"/>
	Đơn giá: <form:input path="donGia"/>
	Loại Sản phẩm: <form:select path="loaiSP.id">
		<form:option value="1">Điện</form:option>
		<form:option value="2">gia dụng</form:option>
	</form:select>
	<input type="submit">
	</form:form>
</body>
</html>