<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="userTable">
	<thead>
		<tr>
			<td>#</td>
			<td>Nome</td>
			<td>Email</td>
			<td>Telefone</td>
			<td>Username</td>
			<td>Admin</td>
			<td style="width:180px;"></td> 
		</tr>
	</thead>
	<c:forEach var="user" items="${userList}">
		<tr>
			<td>${user.id}</td>
			<td>${user.name}</td>
			<td>${user.email}</td>
			<td>${user.phone}</td>
			<td>${user.username}</td>
			<c:if test="${user.admin}">
				<td class="centerText">Sim</td>
			</c:if>
			<c:if test="${!user.admin}">
				<td class="centerText">N�o</td>
			</c:if>

			<td>
				<c:if test="${user.active}">
					<a class="btnDesactive">Desativar</a>
				</c:if>
				<c:if test="${!user.active}">
					<a class="btnActive">Ativar</a>
				</c:if>
				<a class="btnEmprestimo">Empr�stimos</a>
			</td>
		</tr>
	</c:forEach>
</table>
