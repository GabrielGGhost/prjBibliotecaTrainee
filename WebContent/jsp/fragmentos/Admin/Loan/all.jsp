<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="buttons booksScreen">
	<select class="inputSelect" id="select">
		<c:choose>
			<c:when test="${select == 1}">
				<option value="1" selected="selected">Empr�stimos Pendentes</option>
				<option value="2">Empr�stimos Resolvidos</option>
				<option value="3">Empr�stimos Atrasados</option>
				<option value="4">Todos os Empr�stimos</option>
			</c:when>
			<c:when test="${select == 2}">
				<option value="1">Empr�stimos Pendentes</option>
				<option value="2" selected="selected">Empr�stimos Resolvidos</option>
				<option value="3">Empr�stimos Atrasados</option>
				<option value="4">Todos os Empr�stimos</option>
			</c:when>
			<c:when test="${select == 3}">
				<option value="1">Empr�stimos Pendentes</option>
				<option value="2">Empr�stimos Resolvidos</option>
				<option value="3" selected="selected">Empr�stimos Atrasados</option>
				<option value="4">Todos os Empr�stimos</option>
			</c:when>
			<c:otherwise>
				<option value="1">Empr�stimos Pendentes</option>
				<option value="2">Empr�stimos Resolvidos</option>
				<option value="3">Empr�stimos Atrasados</option>
				<option value="4" selected="selected">Todos os Empr�stimos</option>
			</c:otherwise>
		</c:choose>

	</select>
	<br>
	<label>
		Buscar empr�stimo por c�digo do usu�rio:
		<input type="text" class="inputText"/>
	</label>
	<input type="button" value="Buscar" class="btn"/>
</div>

<table class="loansTable">
	<thead>
		<tr>
			<td class="centerText" style="width: 10px;">#Empr�stimo</td>
			<td class="centerText" style="width: 100px;">#Emp. Livro</td>
			<td>Livro</td>
			<td class="centerText" style="width: 120px;">Data de Retirada</td>
			<td class="centerText" style="width: 150px;">Data de Devolu��o</td>
			<td class="centerText" style="width: 120px;">Devolvido em</td>
			<td style="width: 70px;">A��es</td>
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