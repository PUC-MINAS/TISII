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
		
		bootbox.alert({
			message: "Cadastro realizado com sucesso",
			size: "small"
		});
		form.elements.name.value = "";
		form.elements.author.value = "";
		form.elements.isbn.value = "";
		form.elements.language.value = "";
		form.elements.publishingCompany.value = "";
		form.elements.synopsis.value = "";
		form.elements.genre.value = "";
		
	}		
	).fail(function(){
		bootbox.alert({
			message: "Não foi possível realizar o cadastro.",
			size: "small"
		});
	});
}

function createExemplary(){
	var form = $('#formExemplary')[0];
	$.ajax({
		url : "http://127.0.0.1:781/services/exemplary/create",
	    type : 'POST',
    	data : {
    		book: form.book.value,
    		localization: form.localization.value,
    		braile: form.braile.checked    		
    	},
    	beforeSend : function(){
      		
    	}
	}).done(function(response){
		
		bootbox.alert({
			message: "Cadastro realizado com sucesso",
			size: "small"
		});
	}		
	).fail(function(){
		bootbox.alert({
			message: "Não foi possível realizar o cadastro.",
			size: "small"
		});
	});
}

function fillSelectExemplary(){
	$.ajax({
		url: "http://127.0.0.1:781/services/book/read",
		type: 'GET',
		beforeSend: function(){

		}
	}).done(function(response){
		console.log(response);
		var options = "";
		var books = response.books;
		for (int i = 0; i < books.length; i++){
			options += '<option value="'+books[i].name+'">' + books[i].name + '</option>';
		}
		console.log(options);

	});
}