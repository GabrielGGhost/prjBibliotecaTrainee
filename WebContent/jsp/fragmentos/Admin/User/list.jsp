<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="buttons emprestimosScreen">
	<a class="btnBook" href="${pageContext.request.contextPath}/admin/registerUser">Cadastrar Usuário</a>
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
				<a class="btnActive" href="${pageContext.request.contextPath}/admin/viewUser?id=${user.id}">Detalhes</a>
				<a class="btnEmprestimo" href="${pageContext.request.contextPath}/admin/viewLoans?id=${user.id}&select=1">Empréstimos</a>
			</td>
		</tr>
	</c:forEach>
</table>
