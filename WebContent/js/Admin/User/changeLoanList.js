var comboLoan = document.getElementById("selectOption");

comboLoan.addEventListener('change', function(){
	
	var opc = comboLoan.value;
	
	location.href = "/admin/viewLoans?select=" + opc;
})