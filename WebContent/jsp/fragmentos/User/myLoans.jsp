<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="buttons emprestimosScreen">
	<select id="selectOption" class="inputSelect">
		<c:choose>
			<c:when test="${select == 1}">
				<option value="1" selected="selected">Empréstimos</option>
				<option value="2">Livros</option>
			</c:when>
			<c:otherwise>
				<option value="1">Empréstimos</option>
				<option value="2" selected="selected">Livros</option>
			</c:otherwise>
		</c:choose>

	</select>
</div>


<c:choose>
	<c:when test="${select == 1}">
		<jsp:include page="/jsp/fragmentos/Subfragmentos/User/loanList.jsp"/>
	</c:when>
	<c:otherwise>
		<jsp:include page="/jsp/fragmentos/Subfragmentos/User/loanBookList.jsp"/>
	</c:otherwise>
</c:choose>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/user_changeLoanList.js"></script>
