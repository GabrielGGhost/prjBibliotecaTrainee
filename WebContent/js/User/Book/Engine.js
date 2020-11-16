var btnSearch = document.getElementsByClassName("btnViewBook");

for (var i = 0; i < btnSearch.length; i++) {
	
	btnSearch[i].addEventListener('click', addEvents);
}

function addEvents(){
	
	var id = this;
	
	id = id.parentElement.parentElement.firstElementChild.firstElementChild.textContent;
	
	sendRequest(id);
}

function sendRequest(id){
	
	if(id == "" || id == null){
		alert("Algo deu errado com o código do livro!");
		return;
	}
		
	url = "viewBook?tombo=" + id;
		
	request = new XMLHttpRequest();
		
	request.onload = viewBook;
		
	request.open("GET", url, true);
		
	request.send();
	
};


function viewBook(){
	
	var response = request.responseXML;
	
	var book = [response.getElementsByTagName("book")];
	
	if(book[0][0].children.length != 0){
		document.getElementById('bookTitle').textContent = book[0][0].children[1].textContent;
		document.getElementById('bookYear').innerHTML = book[0][0].children[2].textContent;
		document.getElementById('bookAuthor').innerHTML = book[0][0].children[3].textContent;
		document.getElementById('bookDescription').innerHTML = book[0][0].children[4].textContent;
	} else {
		document.getElementById('bookTitle').textContent = "";
		document.getElementById('bookYear').innerHTML = "";
		document.getElementById('bookAuthor').innerHTML = "";
		document.getElementById('bookDescription').innerHTML = "";
		alert("O livro com esse código não está disponível ou não existe!");
	}
		
}