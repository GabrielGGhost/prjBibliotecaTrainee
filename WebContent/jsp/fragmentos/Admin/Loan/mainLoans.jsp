<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="buttons emprestimosScreen">
	<a class="btnBook" href="${pageContext.request.contextPath}/makeLoan">Realizar Empr�stimo</a>
	<a class="btnBook" href="${pageContext.request.contextPath}/pendingLoans">Empr�stimos Pendentes</a>
	<a class="btnBook">Agendamentos</a>
</div>

<table class="loansTable">
	<thead>
		<tr>
			<td class="centerText">#</td>
			<td>Leitor</td>
			<td class="centerText">Data de retirada</td>
			<td style="width:110px;" class="centerText actionTd">A��es</td> 
		</tr>
	</thead>
	<tbody>
		<c:forEach var="loan" items="${loanList}">
			<tr>
				<td class="centerText">${loan.idLoan}</td>
				<td>${loan.name}</td>
				<td class="centerText">${loan.loanDate}</td>
				<td><a class="btnReceber">Ver livros</a></td>
			</tr>
		</c:forEach>
	</tbody>
</table>
