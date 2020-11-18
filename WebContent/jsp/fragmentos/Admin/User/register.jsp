<nav class="navigation">
	<ul class="navigationUl">
		<li><a class="space pointer" href="${pageContext.request.contextPath}/admin/user/list">Usuários</a></li>
		<spawn class="space">></spawn>
		<li><a class="spaceSecond pointer"> Cadastro</a></li>
	</ul>
</nav>
<div class="registerUser">
	<h1>Cadastro de Usuários</h1>
	<div class="registerError displayNone" id="erroMessage">
		<span>Erro</span>
	</div>
	<div class="topInputsUser">
		<label>
			Nome:
			<input type="text" class="inputText" id="txtName"/>
		</label>
		<label>
			Usuário:
			<input type="text" class="inputText" id="txtUsername"/>
		</label>
		<label>
			Senha:
			<input type="password" class="inputText" id="txtPassword"/>
		</label>
		<label>
			Confirmar Senha:
			<input type="password" class="inputText" id="txtConfirmPassword"/>
		</label>
		<label>
			<input type="checkbox" class="inputText checkBox" id="chkAdm"/>
			Administrador
		</label>
	</div>
	<div class="bottomInputsUser">
		<label>
			Email:
			<input type="email" class="inputText" id="txtEmail"/>
		</label>
		<label>
			Telefone:
			<input type="text" class="inputText" id="txtPhone"/>
		</label>
	</div>
	<div class="buttons">
		<input type="button" class="btn" value="Cadastrar" onclick="registerUser()"/>
	</div>
</div>