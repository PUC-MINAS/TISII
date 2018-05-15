function createBook (){
	var form = $('#formBook')[0];
	$.ajax({
		url : "http://127.0.0.1:781/services/book/create",
	    type : 'POST',
    	data : {
    		name: form.name.value
    		
    	},
    	beforeSend : function(){
      
    	}
	}).done(function(response){
		alert("done");
		console.log(response);
	}		
	).fail(function(){
		alert("fail");
	}
	);
}