<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navigation">
	<ul class="navigationUl">
		<li><a class="space pointer" href="${pageContext.request.contextPath}/admin/loan/list">Empréstimos</a></li>
		<spawn class="space">></spawn>
		<c:choose>
			<c:when test="${select == 1}">
				<li><a class="spaceSecond pointer"><a>Pendentes</a></li>
			</c:when>
			<c:when test="${select == 2}">
				<li><a class="spaceSecond pointer">Resolvidos</a></li>
			</c:when>
			<c:when test="${select == 3}">
				<li><a class="spaceSecond pointer">Atrasados</a></li>
			</c:when>
			<c:otherwise>
				<li><a class="spaceSecond pointer">Todos</a></li>
			</c:otherwise>
		</c:choose>
	</ul>
</nav>

<div class="buttons booksScreen">
	<select class="inputSelect" id="select">
		<c:choose>
			<c:when test="${select == 1}">
				<option value="1" selected="selected">Empréstimos Pendentes</option>
				<option value="2">Empréstimos Resolvidos</option>
				<option value="3">Empréstimos Atrasados</option>
				<option value="4">Todos os Empréstimos</option>
			</c:when>
			<c:when test="${select == 2}">
				<option value="1">Empréstimos Pendentes</option>
				<option value="2" selected="selected">Empréstimos Resolvidos</option>
				<option value="3">Empréstimos Atrasados</option>
				<option value="4">Todos os Empréstimos</option>
			</c:when>
			<c:when test="${select == 3}">
				<option value="1">Empréstimos Pendentes</option>
				<option value="2">Empréstimos Resolvidos</option>
				<option value="3" selected="selected">Empréstimos Atrasados</option>
				<option value="4">Todos os Empréstimos</option>
			</c:when>
			<c:otherwise>
				<option value="1">Empréstimos Pendentes</option>
				<option value="2">Empréstimos Resolvidos</option>
				<option value="3">Empréstimos Atrasados</option>
				<option value="4" selected="selected">Todos os Empréstimos</option>
			</c:otherwise>
		</c:choose>

	</select>
	<br>
	<form method="post" action="${pageContext.request.contextPath}/admin/loan/userLoans">
		<label>
			Buscar empréstimo por código do usuário:
			<input type="text" class="inputText" name="id"/>
		</label>
		<input type="submit" value="Buscar" class="btn"/>
	</form>
	
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