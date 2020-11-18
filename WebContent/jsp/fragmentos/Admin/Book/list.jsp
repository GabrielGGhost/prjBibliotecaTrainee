<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<nav class="navigation">
	<ul class="navigationUl">
		<li><a class="pointer" href="${pageContext.request.contextPath}/admin/book/list">Livros</a></li>
	</ul>
</nav>

<div class="buttons booksScreen">
	<a class="btnBook" href="${pageContext.request.contextPath}/admin/book/register">Cadastrar Novo Livro</a>
</div>

<table class="loansTable">
	<thead>
		<tr>
			<td class="centerText">#</td>
			<td>Título</td>
			<td class="centerText">Ano</td>
			<td>Autor</td>
			<td class="centerText" style="width: 200px;">Detalhes</td>
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
					<div class="booksScreen  ">
						<a class="btnActive" href="detail?id=${book.tombo}" style="margin-right: 15px; margin-left: -8px;">Detalhes</a>
						<a class="btnActive" href="${pageContext.request.contextPath}/admin/genre/manage?id=${book.tombo}">Gêneros</a>
					</div>
					
				</td>
			</tr>
		</c:forEach>
	</tbody>
</table> 