<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h3 class="centerText">Lista de Gêneros</h3>

<div class="buttons booksScreen">
	<a class="btnBook" href="register">Cadastrar novo gênero</a>
</div>

<table class="loansTable">
	<thead>
		<tr>
			<td class="centerText">#</td>
			<td>Nome</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="gender" items="${genderList}">
			<tr>
				<td class="centerText">${gender.id}</td>
				<td>${gender.name}</td>
			</tr>
		</c:forEach>
	</tbody>
</table> 