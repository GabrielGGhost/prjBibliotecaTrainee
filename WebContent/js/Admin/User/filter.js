var btnFilter = document.getElementById("btnFilter");


btnFilter.addEventListener('click', function(){
	var filter = document.getElementById("txtFilter").value;
	
	location.href="list?filter=" + filter;
});