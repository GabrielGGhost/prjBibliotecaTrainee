<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	
	<div class="buttons emprestimosScreen">
		<select id="selectOption" class="inputSelect">
			<c:choose>
				<c:when test="${select == 1}">
					<option value="1" selected="selected">Empréstimos</option>
					<option value="2">Livros</option>
				</c:when>
				<c:otherwise>
					<option value="1">Empréstimos</option>
					<option value="2" selected="selected">Livros</option>
				</c:otherwise>
			</c:choose>
	
		</select>
	</div>
	

	<c:choose>
		<c:when test="${select == 1}">
			<jsp:include page="/jsp/fragmentos/Subfragmentos/Admin/UserloanBookList.jsp"/>
		</c:when>
		<c:otherwise>
			<jsp:include page="/jsp/fragmentos/Subfragmentos/Admin/UserloanList.jsp"/>
		</c:otherwise>
	</c:choose>

</body>
</html>