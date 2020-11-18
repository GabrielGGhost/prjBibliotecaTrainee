<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Empréstimos</title>
<link href='${pageContext.request.contextPath}/css/style.css' rel='stylesheet' type='text/css'>
</head>
<body>
	<jsp:include page="/jsp/fragmentos/header.jsp">
		<jsp:param value="${user}" name="user"/>
	</jsp:include>
	<div class="userData">
		<span><b>#</b> <a id="idUser">${selectedUser.id}</a></span>
		<span><b>Usuário</b> ${selectedUser.name}</span>
	</div>
	<jsp:include page="/jsp/fragmentos/User/myLoans.jsp">
		<jsp:param value="${select}" name="select"/>
	</jsp:include>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/Admin/User/changeLoanList.js"></script>

</body>
</html>