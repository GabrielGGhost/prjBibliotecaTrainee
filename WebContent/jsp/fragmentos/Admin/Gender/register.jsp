
<nav class="navigation">
	<ul class="navigationUl">
		<li><a class="space pointer" href="${pageContext.request.contextPath}/admin/genre/list">Gêneros</a></li>
		<span class="space">></span>
		<li><a class="spaceSecond pointer">Cadastro</a></li>
	</ul>
</nav>

<div class="registerUser">
	<h1>Cadastro de Gêneros</h1>
	<div class="registerError displayNone" id="erroMessage">
		<span>Erro</span>
	</div>
	<div class="topInputsUser">
		<label>
			Nome:
			<input type="text" class="inputText" id="txtName"/>
		</label>
	</div>
	<div class="buttons">
		<input type="button" class="btn" value="Cadastrar" onclick="registerBook();"/>
	</div>
</div>