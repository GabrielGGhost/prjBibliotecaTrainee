<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="containerViewUser">
	<div class="centerViewUser">
		<h1 class="centerText">Detalhes do Livro</h1>
		<div class="ViewUserFirstRow">
			<span><b>Tombo: </b> 4521</span> 
		</div>
		<div class="ViewUserSecondtRow">
			<span><b>Titulo: </b> Nomezinho do livro</span>
			<span><b>Ano: </b> 2000</span>
		</div>
		<div class="ViewUserThirdRow">
			<span><b>Autor: </b> Nome do autor vai aqui</span>
			
			<!--<c:if test="${viewUser.admin}">
				<span><b>Admin: </b>Sim</span>
			</c:if>
			<c:if test="${!viewUser.admin}"> -->
			<!--</c:if> -->
			<form action="${pageContext.request.contextPath}/Admin_User_DesActive?id=${viewUser.id}&status=${viewUser.active}" method="post">
				<!--<c:choose>
					<c:when test="${viewUser.active}"> -->
						<span><input type="submit" value="Desativar Usuário" class="btnDesactive centerText" style="width:150px;"/></span>
					<!--</c:when>
					<c:otherwise>
						<span><input type="submit" value="Ativar Usuário" class="btnActive centerText" style="width:150px;"/></span>
					</c:otherwise>
				</c:choose> -->
			</form>
		</div>
		<div class="ViewUserForthtRow">
			<span><b>Descrição: </b> Descrição blablabla</span>

		</div>

	</div>
</div>