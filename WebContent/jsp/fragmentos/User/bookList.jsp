<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="bookContainer">
	<section class="asideDetails">
		<img src="${pageContext.request.contextPath}/img/chavepreta.png" class="viewBook"/>
		<div class="viewContainer">
			<div class="topViewRow">
				<span><b>T�tulo:</b> A chave preta.</span>
				<span><b>Ano:</b> 2015</span>
				<span><b>Autor:</b> HP Lovecraft</span>
			</div>
			<div class="bottomViewRow">
				<b>Descri��o:</b> Essa � a descri��o do livro, ela pode ser longa ou curta, mas tem um limtie de caracteres de 200 por exemplo
			</div>
			<div class="buttons viewButtons">
				<a class="btnBook">Agendar</a>
			</div>
		</div>
	</section>
	<section class="bookList">
		<c:forEach var="book" items="${bookList}">
			<div class="book">
				<img src="${pageContext.request.contextPath}/img/chavepreta.png"/>
					<div class="topDetails">
						<div class="bookDetails">
							<span><b>T�tulos:</b>${book.title}.</span>
				 			<span><b>Ano:</b> ${book.year}</span>
				 			<span><b>Autor:</b> ${book.author}</span>
			 		</div>
			 		<b>G�neros:</b> Terror, Fic��o, Suspense, Drama, Gen, Gen, Gen, Gen, Gen, Gen
					<div class="buttons">
						<a class="btnBook">Agendar</a>
						<a class="btnBook">Vizualizar</a>
					</div>
				</div>
			 </div>
		</c:forEach>
			
		</section>
	</div>