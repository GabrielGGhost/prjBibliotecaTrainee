<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navigation">
	<ul class="navigationUl">
		<li><a class="pointer" href="${pageContext.request.contextPath}/admin/user/list">Usuários</a></li>
	</ul>
</nav>

<div class="buttons emprestimosScreen">
	<a class="btnBook" href="${pageContext.request.contextPath}/admin/user/register">Cadastrar Usuário</a>
</div>
<table class="userTable">
	<thead>
		<tr>
			<td class="centerText">#</td>
			<td>Nome</td>
			<td>Email</td>
			<td>Telefone</td>
			<td>Username</td>
			<td class="centerText">Admin</td>
			<td style="width:180px;" class="centerText">Ações</td> 
		</tr>
	</thead>
	<c:forEach var="user" items="${userList}">
		<tr>
			<td class="centerText">${user.id}</td>
			<td>${user.name}</td>
			<td>${user.email}</td>
			<td>${user.phone}</td>
			<td>${user.username}</td>
			<c:if test="${user.admin}">
				<td class="centerText">Sim</td>
			</c:if>
			<c:if test="${!user.admin}">
				<td class="centerText">Não</td>
			</c:if>

			<td>
				<a class="btnActive" href="${pageContext.request.contextPath}/admin/user/view?id=${user.id}">Detalhes</a>
				<a class="btnEmprestimo" href="${pageContext.request.contextPath}/admin/user/selectedLoan?id=${user.id}&select=1">Empréstimos</a>
			</td>
		</tr>
	</c:forEach>
</table>
