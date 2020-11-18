<nav class="navigation">
	<ul class="navigationUl">
		<li><a class="space pointer" href="${pageContext.request.contextPath}/admin/book/list">Livros </a></li>
		<span class="space"> ></span>
		<li><a class="spaceSecond pointer"> Cadastro</a></li>
	</ul>
</nav>

<div class="registerUser">
	<h1>Cadastro de Livros</h1>
	<div class="registerError displayNone" id="erroMessage">
		<span>Erro</span>
	</div>
	<div class="topInputsUser">
		<label>
			Título:
			<input type="text" class="inputText" id="txtTitle"/>
		</label>
		<label>
			Ano:
			<input type="number" class="inputText" id="txtYear" style="width:100px;"/>
		</label>
		<label>
			Autor:
			<input type="text" class="inputText" id="txtAuthor"/>
		</label>
	</div>
	<div class="bottomInputsUser">
		<label>
			Descrição:
			<textarea class="inputText" rows="10" id="txtDescription"></textarea>
		</label>
	</div>
	<div class="buttons">
		<input type="button" class="btn" value="Cadastrar" onclick="registerBook();"/>
	</div>
</div>