<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="containerViewUser">
	<div class="centerViewUser">
		<h1 class="centerText">Detalhes do Livro</h1>
		<div class="ViewUserFirstRow">
			<span><b>Tombo: </b> ${book.tombo}</span> 
		</div>
		<div class="ViewUserSecondtRow">
			<span><b>Titulo: </b> ${book.title}</span>
			<span><b>Ano: </b> ${book.year}</span>
		</div>
		<div class="ViewUserThirdRow">
			<span><b>Autor: </b> ${book.author}</span>
			<form action="${pageContext.request.contextPath}/admin/book/desActive?id=${book.tombo}&status=${book.active}" method="post">
				<c:choose>
					<c:when test="${book.active}">
						<span><input type="submit" value="Desativar Livro" class="btnDesactive centerText" style="width:150px;"/></span>
					</c:when>
					<c:otherwise>
						<span><input type="submit" value="Ativar Livro" class="btnActive centerText" style="width:150px;"/></span>
					</c:otherwise>
				</c:choose>
			</form>
		</div>
		<div class="ViewUserForthtRow">
			<span><b>Descrição: </b> ${book.description}</span>
		</div>
	</div>
</div>