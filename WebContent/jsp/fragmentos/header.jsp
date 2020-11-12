<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
	<nav>
		<h1 class="title">Biblioteca Epiousion</h1>

		<ul class="menu">
			<c:if test="${user.admin}">
				<li><a href="${pageContext.request.contextPath}/admin/listaUsuarios">Usuários</a></li>
				|
				<li><a href="${pageContext.request.contextPath}/admin/book/list">Livros</a></li>
				|
				<li><a href="${pageContext.request.contextPath}/admin/loan/list">Empréstimos</a></li>
				| 
				<li>Agendamentos</li>
				|
			</c:if>
			<c:if test="${!user.admin}">
				<li>Lista de livros</li>
				|
				<li><a href="${pageContext.request.contextPath}/myLoans">Reservas/Empréstimos</a></li>
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

	