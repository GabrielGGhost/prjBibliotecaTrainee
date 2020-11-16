
var element = document.getElementById("select");
var btnSearchUser = document.getElementById("").

element.addEventListener('change', changeList);

function changeList(){
	var opc = element.value;
	location.href = "all?select=" + opc;
}