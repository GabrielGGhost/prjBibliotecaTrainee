
<div class="makeLoanContainer">
	<section class="user2Loan">
		<div class="searchDiv">
			Escolher leitor por código:
			<input type="text" id="codUser" name="codUser" class="inputText searchUser"/>
			<input type="button" id="searchButton" value="Buscar" class="btn" onclick="sendRequest()"/>
		</div>
		<div class="resultSearch">
			<span><b>ID: </b><label id="idUser"></label></span>
			<span><b>Nome: </b><label id="nameUser"></label></span>
			<span><b>Telefone: </b><label id="phoneUser"></label></span>
		</div>
		<span id="aloneSpan"><b>Email: </b><label id="emailUser"></label></span>
	</section>
	<section class="books2Loan">
		<div class="searchDiv">
			<Label>
				Adicionar livro por tombo:
				<input type="text" class="inputText"/>
			</Label>
			<input type="button" value="Adicionar livro" class="btn"/>
		</div>
		<div id="preparingBooks">
			<div class="book2Loan">
				<div class="bookData">
					<span><b>Tombo: </b></span>
					<span><b>Autor: </b></span>
					<span><b>Título: </b></span>
					<span><b>Ano: </b></span>
				</div>
				<div class="removeDivButton">
					<input type="button" class="btnRemove" value="Remover"/>
				</div>
			</div>
		</div>
	</section>
		
</div>