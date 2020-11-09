<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="buttons emprestimosScreen">
	<select>
		<option value="1">Empréstimos</option>
		<option value="2">Livros</option>
	</select>
</div>


<c:choose>
	<c:when test="${select == 2}">
	IMPRIMIU O PRIMEIRO
		<jsp:include page="/jsp/fragmentos/subfragmentos/user_loanList.jsp"/>
	</c:when>
	<c:otherwise>
	IMPRIMIU O SEGUNDP
		<jsp:include page="/jsp/fragmentos/subfragmentos/user_loanBookList.jsp"/>
	</c:otherwise>
</c:choose>

