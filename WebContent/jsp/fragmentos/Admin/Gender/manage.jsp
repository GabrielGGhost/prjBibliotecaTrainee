<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="genderContainer">
	<div class="buttons booksScreen">
		<a class="btnBook" href="list">Gerenciar Gêneros</a>
	</div>
	<div class="genderBoxes">
		<div class="unregistredGenders">
		<h5 class="centerText genderText">Categorias a adicionar</h5>
		<ul class="unregisteredGender">
			<c:forEach var="genre" items="${unregisteredGenres}">
				<li class="gender"><input type="button" value="Adicionar" class="btnAddGender"/> ${genre.name}</li>
			</c:forEach>
		</ul>
	</div>
	<div class="registredGenders">
		<h5 class="centerText genderText">Categorias adicionadas</h5>
		<ul class="unregisteredGender">
			<c:forEach var="genre" items="${registeredGenres}">
				<li class="gender"><input type="button" value="Remover" class="btnRmvGender"/> ${genre.name}</li>
			</c:forEach>
		</ul>
	</div>
	</div>
	
</div>