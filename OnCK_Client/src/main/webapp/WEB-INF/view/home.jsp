<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
.table{
	border-collapse: collapse;
	border: 1px solid
}
.table td{
border: 1px solid
}
</style>
</head>
<body>
<a href="${pageContext.request.contextPath}/sanpham/showForm">Thêm</a>
<table class="table">
	<c:forEach var="sp" items="${list}">
	<c:url var ="updateLink" value="/sanpham/update">
		<c:param name="id" value="${sp.id}"></c:param>
	</c:url>
	<c:url var ="deleteLink" value="/sanpham/delete">
		<c:param name="id" value="${sp.id}"></c:param>
	</c:url>
		<tr>
			<td>${sp.id}</td>
			<td>${sp.tenSanPham}</td>
			<td>${sp.donGia}</td>
			<td>${sp.loaiSP.tenLoai}</td>
			<td>
					<a href="${updateLink }">Sua </a> | <a href="${deleteLink }">Xoa</a>
				</td>
		</tr>
	</c:forEach>
</table>
<footer id="footer" width="100%" style="border-top:1px solid;display: block; margin-top: 200px">Test - 16252522</footer>
</body>
</html>