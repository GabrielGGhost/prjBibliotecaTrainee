<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="buttons emprestimosScreen">
	<a class="btnBook" href="${pageContext.request.contextPath}/makeLoan">Realizar Empréstimo</a>
	<a class="btnBook" href="${pageContext.request.contextPath}/pendingLoans">Empréstimos Pendentes</a>
	<a class="btnBook">Agendamentos</a>
</div>
<select>
	<option value="1">Empréstimos</option>
	<option value="2">Livros</option>
</select>

<c:choose>
	<c:when test="${select == 1">
		<jsp:include page="/jsp/fragmentos/subfragmentos/user_loanList.jsp"/>
	</c:when>
	<c:otherwise>
		<jsp:include page="/jsp/fragmentos/subfragmentos/user_loanBookList.jsp"/>
	</c:otherwise>
</c:choose>

