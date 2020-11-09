<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="buttons booksScreen">
	<a class="btnBook">Cadastrar Novo Livro</a>
</div>

<table class="loansTable">
	<thead>
		<tr>
			<td class="centerText">#</td>
			<td>Título</td>
			<td class="centerText">Ano</td>
			<td>Autor</td>
			<td class="centerText">Ações</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="book" items="${bookList}">
			<tr>
				<td class="centerText">${book.tombo}</td>
				<td>${book.title}</td>
				<td class="centerText">${book.year}</td>
				<td>${book.author}</td>
				<td>
					<c:if test="${book.active}">
						<a class="btnDesactive">Desativar</a>	
					</c:if>
					<c:if test="${!book.active}">
						<a class="btnActive">Ativar</a>	
					</c:if>
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table> 