var comboLoan = document.getElementById("selectOption");

comboLoan.addEventListener('change', function(){
	
	var opc = comboLoan.value;
	var id = document.getElementById("idUser").textContent;
	location.href = "viewLoans?id=" + id + "&select=" + opc;
})