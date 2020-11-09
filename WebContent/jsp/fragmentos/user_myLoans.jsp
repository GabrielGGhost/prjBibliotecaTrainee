<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="buttons emprestimosScreen">
	<a class="btnBook" href="${pageContext.request.contextPath}/makeLoan">Realizar Empr�stimo</a>
	<a class="btnBook" href="${pageContext.request.contextPath}/pendingLoans">Empr�stimos Pendentes</a>
	<a class="btnBook">Agendamentos</a>
</div>
<select>
	<option value="1">Empr�stimos</option>
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

