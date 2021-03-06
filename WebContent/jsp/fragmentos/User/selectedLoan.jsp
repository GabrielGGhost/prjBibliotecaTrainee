<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navigation">
	<ul class="navigationUl">
		<li><a class="space pointer" href="${pageContext.request.contextPath}/myLoans">Meus Empréstimos </a></li>
		<spawn class="space">></spawn>
		<li><a class="spaceSecond pointer">Livros</a></li>
	</ul>
</nav>

<table class="loansTable">
	<thead>
		<tr>
			<td class="centerText" style="width: 10px;">#Empréstimo</td>
			<td class="centerText" style="width: 100px;">#Emp. Livro</td>
			<td>Livro</td>
			<td class="centerText" style="width: 120px;">Data de Retirada</td>
			<td class="centerText" style="width: 150px;">Data de Devolução</td>
			<td class="centerText" style="width: 120px;">Devolvido em</td>
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
			</tr>
		</c:forEach>
	</tbody>
</table>