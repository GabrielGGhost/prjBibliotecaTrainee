var searchButton = document.getElementById("searchButton");
var request;

function sendRequest(opc){
	var cod;
	if(opc == 1){
		cod = document.getElementById("codUser").value;
		
		if(cod == "" || cod == null){
			alert("Digite o código do usuário");
			return;
		}
		
		url = "buscaCliente?id=" + cod;
		
		request = new XMLHttpRequest();
		
		request.onload = buscaCliente;
		
		request.open("GET", url, true);
		
		request.send();
	} else {
		cod = document.getElementById("codBook").value;
		
		if(cod == "" || cod == null){
			alert("Digite o tombo do livro");
			return;
		}
		
		url = "searchBook?tombo=" + cod;
		
		request = new XMLHttpRequest();
		
		request.onload = searchBook;
		
		request.open("GET", url, true);
		
		request.send();
	}
};


function buscaCliente(){
	
	var response = request.responseXML;
		
	var user = [response.getElementsByTagName("user")];
	
	if(user[0][0].children.length != 0){
		document.getElementById('idUser').innerHTML = user[0][0].children[0].textContent;
		document.getElementById('nameUser').innerHTML = user[0][0].children[1].textContent;
		document.getElementById('emailUser').innerHTML = user[0][0].children[2].textContent;
		document.getElementById('phoneUser').innerHTML = user[0][0].children[3].textContent;
	} else {
		document.getElementById('idUser').innerHTML = "";
		document.getElementById('nameUser').innerHTML = "";
		document.getElementById('emailUser').innerHTML = "";
		document.getElementById('phoneUser').innerHTML = "";
		alert("O usuário com esse dígito não está disponível ou não existe!");
	}
}

function searchBook(){
	
	var response = request.responseXML;
	
	var book = [response.getElementsByTagName("book")];
	var clone = document.getElementById("preparingBooks").lastElementChild.cloneNode(true);
	if(book[0][0].children.length != 0){
		
		document.getElementById("preparingBooks").lastElementChild.children[0].children[0].children[1].innerHTML = book[0][0].children[0].textContent;
		document.getElementById("preparingBooks").lastElementChild.children[0].children[1].children[1].innerHTML = book[0][0].children[3].textContent;
		document.getElementById("preparingBooks").lastElementChild.children[0].children[2].children[1].innerHTML = book[0][0].children[1].textContent;
		document.getElementById("preparingBooks").lastElementChild.children[0].children[3].children[1].innerHTML = book[0][0].children[2].textContent;

		var element = document.getElementById("preparingBooks");
		
		element.lastElementChild.className = "book2Loan"; 
		
		document.getElementById("preparingBooks").appendChild(clone);
	} else {

	}
}