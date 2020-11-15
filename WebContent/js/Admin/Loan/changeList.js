
var element = document.getElementById("select");


element.addEventListener('change', changeList);

function changeList(){
	var opc = element.value;
	location.href = "all?select=" + opc;
}