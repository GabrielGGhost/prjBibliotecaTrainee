<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="containerViewUser">
	<div class="centerViewUser">
		<h1 class="centerText">Emprétimo #${loan.idLoanBook}</h1>
		<div class="ViewUserFirstRow">
			<span><b>Empréstimo: </b>#${loan.idLoan}</span> 
		</div>
		<div class="ViewUserSecondtRow">
			<span><b>Usuário: </b>${loan.nameUser}</span>
			<span><b>Livro: </b>${loan.title}</span>
		</div>
		<div class="ViewUserThirdRow">
			<span><b>Data de Empréstimo: </b>${loan.loanDate}</span>
			<span><b>Data de Devolução </b>${loan.devolutionDate}</span>
		</div>
		<div class="ViewUserForthtRow">
		<label>
			<span><b>Situação:</b></span>
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
		<div class="ViewUserFifthtRow">
			<a href="${pageContext.request.contextPath}/admin/loan/renew?id=${loan.idLoanBook}"><input type="button" class="btn" value="Renovar Livro"/></a>
			<a href="${pageContext.request.contextPath}/admin/loan/receive?id=${loan.idLoanBook}"><input type="button" class="btn" value="Receber Livro"/></a>
		</div>
	</div>
</div>