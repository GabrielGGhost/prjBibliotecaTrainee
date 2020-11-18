<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
	<nav>
		<h1 class="title" ><a href="${pageContext.request.contextPath}/">Biblioteca Epiousion</a></h1>

		<ul class="menu">
			<c:if test="${user.admin}">
				<li><a href="${pageContext.request.contextPath}/admin/user/list">Usuários</a></li>
				|
				<li><a href="${pageContext.request.contextPath}/admin/book/list">Livros</a></li>
				|
				<li><a href="${pageContext.request.contextPath}/admin/loan/list">Empréstimos</a></li>
				| 
				<li><a href="${pageContext.request.contextPath}/admin/genre/list">Gêneros</a></li>
				|
			</c:if>
			<c:if test="${!user.admin}">
				<li><a href="${pageContext.request.contextPath}/">Lista de livros</a></li>
				|
				<li><a href="${pageContext.request.contextPath}/myLoans">Empréstimos</a></li>
				|
			</c:if>
			<c:choose>
				<c:when test="${user != null}">
					<li>${user.username}</li><a href="${pageContext.request.contextPath}/logout" class="sair"> sair</a>
				</c:when>
				<c:otherwise>
					<li><a href="${pageContext.request.contextPath}/login">Entrar</a></li>
				</c:otherwise>
			</c:choose>
		</ul>
	</nav>
</header>

	