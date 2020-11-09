<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="containerViewUser">
	<div class="centerViewUser">
		<h1 class="centerText">Perfil do Usuário</h1>
		<div class="ViewUserFirstRow">
			<span><b>ID: </b>${user.id}</span> 
		</div>
		<div class="ViewUserSecondtRow">
			<span><b>Nome: </b>${user.name}</span>
			<span><b>Username: </b>${user.username}</span>
		</div>
		<div class="ViewUserThirdRow">
			<span><b>Data de registro: </b>${user.registrationDate}</span>
			<span><b>Phone: </b>${user.phone}</span>
		</div>
		<div class="ViewUserForthtRow">
			<span><b>Senha: </b><a class="btn centerText" style="width:110px;">Alterar Senha</a></span>
			<span><b>Email: </b>${user.email}</span>
		</div>
		<div class="ViewUserFifthtRow">
			<c:if test="${user.admin}">
				<span><b>Admin: </b>Sim</span>
			</c:if>
			<c:if test="${!user.admin}">
				<span><b>Admin: </b>Não</span>
			</c:if>
			<span><a class="btnDesactive centerText" style="width:150px;" onclick="des_active(1);">Desativar Usuário</a></span>
		</div>
	</div>
</div>