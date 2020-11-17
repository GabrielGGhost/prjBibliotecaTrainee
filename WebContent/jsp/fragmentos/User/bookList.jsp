<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="bookContainer">
	<section class="asideDetails">
		<div class="viewContainer">
			<h2 class="centerText">Livro</h2>
			<h5 class="centerText">Selecione um livro para ver seus detalhes</h5>
			<div class="topViewRow">
				<span><b>Título: </b><a id="bookTitle"></a></span>
				<span><b>Ano: </b><a id="bookYear"></a></span>
				<span><b>Autor: </b><a id="bookAuthor"></a></span>
			</div>
			<div class="bottomViewRow">
				<b>Descrição:</b> <a id="bookDescription"></a>
			</div>
		</div>
	</section>
	<section class="bookList">
		<c:forEach var="book" items="${bookList}">
			<div class="book">
					<div class="topDetails">
						<div class="bookDetails">
							<a class="displayNone">${book.tombo}</a>
							<span><b>Títulos:</b>${book.title}.</span>
				 			<span><b>Ano:</b> ${book.year}</span>
				 			<span><b>Autor:</b> ${book.author}</span>
			 		</div>
			 		<b>Gêneros:</b> 
			 		
			 		<c:forEach var="genre" items="${book.genres}">
				 		 - ${genre.name}
			 		</c:forEach>
					<div class="buttons">
						<a class="btnBook btnViewBook">Vizualizar</a>
					</div>
				</div>
			 </div>
		</c:forEach>
			
		</section>
	</div>