<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<table class="loansTable">
	<thead>
		<tr>
			<td class="centerText">#Empréstimo</td>
			<td class="centerText">#Emp. Livro</td>
			<td class="centerText">Data de retirada</td>
			<td class="centerText">Quantidade de livros</td>
			<td style="width:110px;" class="centerText actionTd">Ações</td> 
		</tr>
	</thead>
	<tbody>
		<c:forEach var="loan" items="${userLoans}">
			<tr>

			</tr>
		</c:forEach>
	</tbody>
</table>