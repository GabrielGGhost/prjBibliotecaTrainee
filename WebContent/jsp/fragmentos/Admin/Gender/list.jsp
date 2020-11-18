<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<nav class="navigation">
	<ul class="navigationUl">
		<li><a class="pointer">Gêneros</a></li>
	</ul>
</nav>
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
		<c:forEach var="genre" items="${genreList}">
			<tr>
				<td class="centerText">${genre.id}</td>
				<td>${genre.name}</td>
			</tr>
		</c:forEach>
	</tbody>
</table> 