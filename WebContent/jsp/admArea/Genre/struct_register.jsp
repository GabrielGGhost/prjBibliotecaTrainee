<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Cadastro de Gênero</title>
<link href='${pageContext.request.contextPath}/css/style.css' rel='stylesheet' type='text/css'>

</head>
<body>
	<jsp:include page="/jsp/fragmentos/header.jsp">
		<jsp:param value="${user}" name="user"/>
	</jsp:include>
	<jsp:include page="/jsp/fragmentos/Admin/Gender/register.jsp"/>
	
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/Admin/Gender/register.js"></script>

</body>
</html>