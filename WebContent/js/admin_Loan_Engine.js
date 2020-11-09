var searchButton = document.getElementById("searchButton");
var request;
var btnMakeLoan = document.getElementById("makeLoan");

btnMakeLoan.addEventListener('click', redirect);

function loadRemoves(){
	
	var btnRemove = document.getElementsByClassName("btnRemove");
	
	for (var i = 0; i < btnRemove.length; i++) {
		btnRemove[i].addEventListener('click', removeBook);
	}
}

function removeBook(){
	
	document.getElementById("preparingBooks").removeChild(this.parentNode.parentNode);
		
}


function sendRequest(opc){
	var cod;
	if(opc == 1){
		cod = document.getElementById("codUser").value;
		
		if(cod == "" || cod == null){
			alert("Digite o código do usuário");
			return;
		}
		
		url = "searchUser?id=" + cod;
		
		request = new XMLHttpRequest();
		
		request.onload = searchUser;
		
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


function searchUser(){
	
	var response = request.responseXML;
		
	var user = [response.getElementsByTagName("user")];
	
	if(user[0][0].children.length != 0){
		document.getElementById('idUser').textContent = user[0][0].children[0].textContent;
		document.getElementById('nameUser').innerHTML = user[0][0].children[1].textContent;
		document.getElementById('emailUser').innerHTML = user[0][0].children[2].textContent;
		document.getElementById('phoneUser').innerHTML = user[0][0].children[3].textContent;
	} else {
		document.getElementById('idUser').innerHTML = "";
		document.getElementById('nameUser').innerHTML = "";
		document.getElementById('emailUser').innerHTML = "";
		document.getElementById('phoneUser').innerHTML = "";
		alert("O usuário com esse código não está disponível ou não existe!");
	}
}

function searchBook(){
	
	var response = request.responseXML;
	
	var book = [response.getElementsByTagName("book")];
	
	var clone = document.getElementById("preparingBooks").lastElementChild.cloneNode(true);
	if(book[0][0].children.length != 0){
		
		if(!checkExistingBookOnList(book[0][0].children[0].textContent)){
			
			document.getElementById("preparingBooks").lastElementChild.children[0].children[0].children[1].innerHTML = book[0][0].children[0].textContent;
			document.getElementById("preparingBooks").lastElementChild.children[0].children[1].children[1].innerHTML = book[0][0].children[3].textContent;
			document.getElementById("preparingBooks").lastElementChild.children[0].children[2].children[1].innerHTML = book[0][0].children[1].textContent;
			document.getElementById("preparingBooks").lastElementChild.children[0].children[3].children[1].innerHTML = book[0][0].children[2].textContent;

			var element = document.getElementById("preparingBooks");
			
			element.lastElementChild.className = "book2Loan"; 
			
			document.getElementById("preparingBooks").appendChild(clone);
			loadRemoves();
			
			document.getElementById("codBook").value = "";
			document.getElementById("codBook").focus();
		} else {
			alert("Livro já inserido na lista!");
		}
		

	} else {
		alert("O livro com este tombo está indisponível ou não existe!");
	}
}

function checkExistingBookOnList(tombo){
	
	var booksOnList = document.getElementsByClassName("tomboBook");
	
	for (var i = 0; i < booksOnList.length - 1; i++) {
		
		if(booksOnList[i].innerText == tombo){
			return true;
		}
	}
	return false;
}

function redirect(){
	
	var idUser = document.getElementById("idUser").textContent;
	var qttBooks = document.getElementsByClassName("tomboBook");
	if(idUser == null || idUser == ""){
		alert("É preciso selecionar um usuário!");
		return;
	} else if(qttBooks.length <= 1){
		alert("É preciso selecionar ao mneos 1 livro para o empréstimo!");
		return;
	} else {
		
		url = "saveLoan?idUser=" + idUser;
		
		for (var i = 0; i < qttBooks.length - 1; i++) {
			url += "&idBook_" + i + "=" + qttBooks[i].innerText;
		}
		location.href = url;
	}
	
}