const errorMessage = document.getElementById("erroMessage");
var data;

function registerBook(){
	
	data = [
	    document.getElementById("txtTitle").value,
	    document.getElementById("txtYear").value,
	    document.getElementById("txtAuthor").value,
	    document.getElementById("txtDescription").value,
	]
	
	if(checkData(data)){
		sendRequest();
	}
}

function checkData(data){
	
	var msg = "";
	if(data[0] == "" || data[0] == null) {
	msg = "Informe o título do livro";
		
		errorMessage.textContent = msg;
		
		checkErroMessage();
		
		return false;
	}
	if(data[1] == "" || data[1] == null) {
		msg = "Informe o ano do livro!";
		
		errorMessage.textContent = msg;
		
		checkErroMessage();
		
		return false;
	}
	if(data[2] == "" || data[2] == null) {
		msg = "Informe o autor do livro!"; 
		
		errorMessage.textContent = msg;
		
		checkErroMessage();
		
		return false;
	}
	if(data[3] == "" || data[3] == null) {
		msg = "Informe um descrição para o livro!";
		
		errorMessage.textContent = msg;
		
		checkErroMessage();
		
		return false;
	}
	
	return true;
}

function checkErroMessage(){
	if(errorMessage.classList.length == 2){
		errorMessage.classList.toggle("displayNone");
	}
}

function sendRequest(){
	
	url = "register/ajax?title=" + data[0]
			+ "&year=" + data[1]
			+ "&author=" + data[2]
			+ "&description=" + data[3];
	
	request = new XMLHttpRequest();
	
	request.onload = saveUser;
	
	request.open("GET", url, true);
	
	request.send();
}

function saveUser(){
	
	location.href="list";
}