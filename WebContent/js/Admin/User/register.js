const errorMessage = document.getElementById("erroMessage");
var data;

function registerUser(){
	
	data = [
	    document.getElementById("txtName").value,
	    document.getElementById("txtUsername").value,
	    document.getElementById("txtPassword").value,
	    document.getElementById("txtConfirmPassword").value,
	    document.getElementById("chkAdm").checked,
	    document.getElementById("txtEmail").value,
	    document.getElementById("txtPhone").value
	]
	
	if(checkData(data)){
		sendRequest();
	}
	

}

function checkData(data){
	
	var msg = "";
	if(data[0] == "" || data[0] == null) {
	msg = "Informe o nome do usuário";
		
		errorMessage.textContent = msg;
		
		checkErroMessage();
		
		return false;
	}
	if(data[1] == "" || data[1] == null) {
		msg = "Informe o usuário!";
		
		errorMessage.textContent = msg;
		
		checkErroMessage();
		
		return false;
	}
	if(data[2] == "" || data[2] == null) {
		msg = "Informe a senha!"; 
		
		errorMessage.textContent = msg;
		
		checkErroMessage();
		
		return false;
	}
	if(data[3] == "" || data[3] == null) {
		msg = "Confirme a senha!";
		
		errorMessage.textContent = msg;
		
		checkErroMessage();
		
		return false;
	}
	
	if(data[2] != data[3]) {
		msg = "Senhas incompatíveis!";
		
		errorMessage.textContent = msg;
		
		checkErroMessage();
		
		return false;
	}
	
	if(data[5] == "" || data[5] == null) {
		msg = "Informe o email!!";
		
		errorMessage.textContent = msg;
		
		checkErroMessage();
		checkDuplicatedData();
		return false;
	}
	
	return true;
}

function checkErroMessage(){
	if(errorMessage.classList.length == 2){
		errorMessage.classList.toggle("displayNone");
	}
}

function checkDuplicatedData(){
	
	url = "saveUser?username=" + data[1]
			+ "&email=" + data[5];


	request = new XMLHttpRequest();
	
	request.onload = saveUser;
	
	request.open("GET", url, true);
	
	request.send();
}

function sendRequest(){
	
	url = "save?name=" + data[0]
			+ "&username=" + data[1]
			+ "&password=" + data[2]
			+ "&admin=" + data[4]
			+ "&email=" + data[5]
			+ "&phone=" + data[6];
	
	request = new XMLHttpRequest();
	
	request.onload = saveUser;
	
	request.open("GET", url, true);
	
	request.send();
}

function saveUser(){
	
	location.href="list";
}