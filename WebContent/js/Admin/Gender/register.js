const errorMessage = document.getElementById("erroMessage");
var name;

function registerBook(){
	
	name = document.getElementById("txtName").value;
	
	if(checkData(name)){
		sendRequest();
	}
}

function checkData(name){
	
	var msg = "";
	if(name == "" || name == null) {
	msg = "Informe o nome do gênero!";
		
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
	
	url = "save?name=" + name;

	
	location.href = url;
}