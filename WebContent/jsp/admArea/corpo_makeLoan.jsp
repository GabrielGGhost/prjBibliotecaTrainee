<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta charset="utf-8">
<title>Insert title here</title>
<link href='${pageContext.request.contextPath}/css/style.css' rel='stylesheet' type='text/css'>
</head>
<body>
	<jsp:include page="/jsp/fragmentos/header.jsp">
		<jsp:param value="${user}" name="user"/>
	</jsp:include>
	<jsp:include page="/jsp/fragmentos/makeLoan.jsp"/>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/buscaCliente.js"></script>
</body>
</html>