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
			<td>Livro</td>
			<td class="centerText">Data de retirada</td>
			<td class="centerText">Data de devolu��o</td>
			<td style="width:110px;" class="centerText actionTd">A��es</td> 
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>1</td>
			<td>Gabriel Santos</td>
			<td>A chave preta</td>
			<td class="centerText">30/10/2020</td>
			<td class="centerText">8/11/2020</td>
			<td><a class="btnReceber">Receber Livro</a></td>
		</tr>
		<tr>
			<td>1</td>
			<td>Gabriel Santos</td>
			<td>A chave preta</td>
			<td class="centerText">30/10/2020</td>
			<td class="centerText">8/11/2020</td>
			<td><a class="btnReceber">Receber Livro</a></td>
		</tr>
		<tr>
			<td>1</td>
			<td>Gabriel Santos</td>
			<td>A chave preta</td>
			<td class="centerText">30/10/2020</td>
			<td class="centerText">8/11/2020</td>
			<td><a class="btnReceber">Receber Livro</a></td>
		</tr>
		<tr>
			<td>1</td>
			<td>Gabriel Santos</td>
			<td>A chave preta</td>
			<td class="centerText">30/10/2020</td>
			<td class="centerText">8/11/2020</td>
			<td><a class="btnReceber">Receber Livro</a></td>
		</tr>
	</tbody>
</table>
