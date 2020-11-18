<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navigation">
	<ul class="navigationUl">
		<li><a class="space pointer" href="${pageContext.request.contextPath}/admin/loan/list">Empr�stimos </a></li>
		<spawn class="space">></spawn>
		<li><a class="spaceSecond pointer"> Detalhes</a></li>
	</ul>
</nav>

<div class="containerViewUser">
	<div class="centerViewUser">
		<h1 class="centerText">Empr�timo #${loan.idLoanBook}</h1>
		<div class="ViewUserFirstRow">
			<span><b>Empr�stimo: </b>#${loan.idLoan}</span> 
		</div>
		<div class="ViewUserSecondtRow">
			<span><b>Usu�rio: </b>${loan.nameUser}</span>
			<span><b>Livro: </b>${loan.title}</span>
		</div>
		<div class="ViewUserThirdRow">
			<span><b>Data de Empr�stimo: </b>${loan.loanDate}</span>
			<span><b>Data de Devolu��o </b>${loan.devolutionDate}</span>
		</div>
		<div class="ViewUserForthtRow">
		<label>
			<span><b>Situa��o:</b></span>
			<c:choose>
				<c:when test="${not empty loan.returnedDate}">
					<td class="centerText">${loan.returnedDate}</td>
				</c:when>
				<c:otherwise>
					<c:if test="${loan.devolutionDate < date}">
						<td class="centerText">Atrasado</td>
					</c:if>
					<c:if test="${loan.devolutionDate >= date}">
						<td class="centerText">Pendente</td>
					</c:if>
				</c:otherwise>
			</c:choose>		
		</label>

		</div>
		<c:choose>
			<c:when test="${empty loan.returnedDate}">
				<div class="ViewUserFifthtRow">
					<a href="${pageContext.request.contextPath}/admin/loan/renew?id=${loan.idLoanBook}"><input type="button" class="btn" value="Renovar Livro"/></a>
					<a href="${pageContext.request.contextPath}/admin/loan/receive?id=${loan.idLoanBook}"><input type="button" class="btn" value="Receber Livro"/></a>
				</div>
			</c:when>
		</c:choose>
		
	</div>
</div>