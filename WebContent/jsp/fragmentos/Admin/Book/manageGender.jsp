<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navigation">
	<ul class="navigationUl">
		<li><a class="space pointer" href="${pageContext.request.contextPath}/admin/book/list">Livros</a></li>
		<span class="space">></span>
		<li><a class="spaceSecond pointer">Gêneros de <strong>${book.title}</strong></a></li>
	</ul>
</nav>

<div class="genderContainer">
	<div class="buttons booksScreen">
		<a class="btnBook" href="list">Gerenciar Gêneros</a>
	</div>
	<div class="genderBoxes">
		<div class="unregistredGenders">
			<h5 class="centerText genderText">Categorias a adicionar</h5>
			<ul class="unregisteredGenderList">
				<c:forEach var="genre" items="${unregisteredGenres}">
					<li class="gender"><a class="btnAddGender" href="${pageContext.request.contextPath}/admin/genre/link?idGenre=${genre.id}&tombo=${param.id}">Adicionar</a><span>- ${genre.name}</span></li>
				</c:forEach>
			</ul>
		</div>
		<div class="registredGenders">
			<h5 class="centerText genderText">Categorias adicionadas</h5>
			<ul class="registeredGenderList">
				<c:forEach var="genre" items="${registeredGenres}">
					<li class="gender"> <a class="btnRmvGender" href="${pageContext.request.contextPath}/admin/genre/unlink?idGenre=${genre.id}&tombo=${param.id}">Remover</a> <span>${genre.name}</span></li>
				</c:forEach>
			</ul>
		</div>
	</div>
	
</div>