<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="containerViewUser">
	<div class="centerViewUser">
		<h1 class="centerText">Perfil do Usu�rio</h1>
		<div class="ViewUserFirstRow">
			<span><b>ID: </b>${viewUser.id}</span> 
		</div>
		<div class="ViewUserSecondtRow">
			<span><b>Nome: </b>${viewUser.name}</span>
			<span><b>Username: </b>${viewUser.username}</span>
		</div>
		<div class="ViewUserThirdRow">
			<span><b>Data de registro: </b>${viewUser.registrationDate}</span>
			<span><b>Phone: </b>${viewUser.phone}</span>
		</div>
		<div class="ViewUserForthtRow">
			<span><b>Senha: </b><input type="button" value="Alterar Senha" class="btn centerText" style="width:110px;"/></span>
			
			<span><b>Email: </b>${viewUser.email}</span>
		</div>
		<div class="ViewUserFifthtRow">
			<c:if test="${viewUser.admin}">
				<span><b>Admin: </b>Sim</span>
			</c:if>
			<c:if test="${!viewUser.admin}">
				<span><b>Admin: </b>N�o</span>
			</c:if>
			<form action="${pageContext.request.contextPath}/admin/userDesActive?id=${viewUser.id}&status=${viewUser.active}" method="post">
				<c:choose>
					<c:when test="${viewUser.active}">
						<span><input type="submit" value="Desativar Usu�rio" class="btnDesactive centerText" style="width:150px;"/></span>
					</c:when>
					<c:otherwise>
						<span><input type="submit" value="Ativar Usu�rio" class="btnActive centerText" style="width:150px;"/></span>
					</c:otherwise>
				</c:choose>
			</form>
			
		</div>
	</div>
</div>