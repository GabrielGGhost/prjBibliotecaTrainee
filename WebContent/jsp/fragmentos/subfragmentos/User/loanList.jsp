<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="loansTable">
	<thead>
		<tr>
			<td class="centerText">#</td>
			<td class="centerText">Data de retirada</td>
			<td class="centerText">Quantidade de livros</td>
			<td style="width:110px;" class="centerText actionTd">A��es</td> 
		</tr>
	</thead>
	<tbody>
		<c:forEach var="loan" items="${userLoans}">
			<c:if test="${loan.quantity > 0}">
				<tr>
					<td class="centerText">${loan.idLoan}</td>
					<td class="centerText">${loan.loanDate}</td>
					<td class="centerText">${loan.quantity}</td>
					<td><a class="btnReceber" style="width:80px;">Ver Livros</a></td>
				</tr>
			</c:if>
		</c:forEach>
	</tbody>
</table>