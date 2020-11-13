<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="buttons emprestimosScreen">
	<a class="btnBook" href="${pageContext.request.contextPath}/loan/make">Realizar Empréstimo</a>
	<a class="btnBook" href="${pageContext.request.contextPath}/pendingLoans">Empréstimos Pendentes</a>
	<a class="btnBook">Agendamentos</a>
</div>


<table class="loansTable">
	<thead>
		<tr>
			<td class="centerText" style="width: 10px;">#Empréstimo</td>
			<td class="centerText" style="width: 100px;">#Emp. Livro</td>
			<td>Livro</td>
			<td class="centerText" style="width: 120px;">Data de Retirada</td>
			<td class="centerText" style="width: 150px;">Data de Devolução</td>
			<td class="centerText" style="width: 120px;">Devolvido em</td>
			<td style="width: 70px;">Ações</td>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="loan" items="${loanList}">
			<c:if test="${loan.devolutionDate < date}">
				<tr style="background-color: rgba(220,0,0,.5);">			
			</c:if>
			<c:if test="${loan.devolutionDate >= date}">
				<tr>			
			</c:if>
				<td class="centerText">${loan.idLoan}</td>
				<td class="centerText">${loan.idLoanBook}</td>
				<td>${loan.title}</td>
				<td class="centerText">${loan.loanDate}</td>
				<td class="centerText">${loan.devolutionDate}</td>
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
				<td><a class="btnActive" href="${pageContext.request.contextPath}/admin/loan/detail?id=${loan.idLoanBook}">Detalhes</a></td>	
			</tr>
		</c:forEach>
	</tbody>
</table>