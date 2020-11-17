<div class="makeLoanContainer">
	<section class="user2Loan">
		<div class="searchDiv">
			Escolher leitor por c�digo:
			<input type="number" id="codUser" name="codUser" class="inputText searchUser"/>
			<input type="button" id="searchButton" value="Buscar" class="btn" onclick="sendRequest(1)"/>
		</div>
		<div class="resultSearch">
			<span><b>ID: </b><label id="idUser" name="idUser"></label></span>
			<span><b>Nome: </b><label id="nameUser"></label></span>
			<span><b>Telefone: </b><label id="phoneUser"></label></span>
		</div>
		<span id="aloneSpan"><b>Email: </b><label id="emailUser"></label></span>
	</section>
	<section class="books2Loan">
		<div class="searchDiv">
			<Label>
				Adicionar livro por tombo:
				<input type="number" id="codBook" name="codBook" class="inputText"/>
			</Label>
			<input type="button" value="Adicionar livro" class="btn" onclick="sendRequest(2)"/>
			<input type="button" id="makeLoan" class="btn left" value="Realizar Empr�stimo"/>
			<span><b>Data de devolu��o: </b>${date}</span>
		</div>
		<div id="preparingBooks">
			<div id="book2Loan" class="displayNone book2Loan">
				<div class="bookData">
					<span><b>Tombo: </b><label class="tomboBook"></label></span>
					<span><b>Autor: </b><label></label></span>
					<span><b>T�tulo: </b><label></label></span>
					<span><b>Ano: </b><label></label></span>
				</div>
				<div class="removeDivButton">
					<input type="button" class="btnRemove" value="Remover"/>
				</div>
			</div>
		</div>
	</section>
		
</div>