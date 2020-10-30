<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href='css/style.css' rel='stylesheet' type='text/css'>

<title>Insert title here</title>
</head>
<body>
	<div class="container"> 
		<form action="${pageContext.request.contextPath}/validarLogin" method="post">
			<div class="center">
			<c:if test="${mensagem != null}">
				<div class="loginError">
					${mensagem}
				</div>
			</c:if>
				
				<div class="dados">
					<Label for="username">Usuário:</Label>
					<input type="text" id="username" name="username" class="inputText"/>
				
					<Label for="password">Senha:</Label>
					<input type="password" id="password" name="password" class="inputText"/>
				</div>
				<input type="submit" class="btn"/>
				<label>
					<input type="checkbox" style="margin-bottom: 15px; ">
					Lembrar minha senha
				</label>
				<div class="rodape">
					<a class="tagLogin tagLoginLeft" >Novo Usuário</a>
					<a class="tagLogin tagLoginRight">Esqueci minha senha</a>
				</div>
			</div>
		</form>
	</div>
</body>
</html>