function createBook (){
	var elements = $("#formBook")[0].elements;
	$.ajax({
		url : "http://127.0.0.1:781/services/book/create",
	    type : 'POST',
    	data : {
    		name: elements.name.value,
    		publishingCompany: elements.publishingCompany.value,
    		language: elements.language.value,
    		isbn: elements.isbn.value,
    		genre: elements.genre.value,
    		author: elements.author.value,
    		synopsis: elements.synopsis.value
    	},
    	beforeSend : function(){
      		
    	}
	}).done(function(response){
		if (response.status == "OK"){
			bootbox.alert({
				message: "Cadastro realizado com sucesso",
				size: "small",
				callback: function(){location.reload();}
			});		
		}
		else {
			bootbox.alert({
				message: "Não foi possível realizar o cadastro.",
				size: "small",
				callback: function(){location.reload();}
			});
		}
			
	}		
	).fail(function(){
		bootbox.alert({
			message: "Não foi possível realizar o cadastro.",
			size: "small",
			callback: function(){location.reload();}
		});
	});
}

function createExemplary(){
	var elements = $("#formExemplary")[0].elements; 
	$.ajax({
		url : "http://127.0.0.1:781/services/exemplary/create",
	    type : 'POST',
    	data : {
    		isbnBook: elements.book.value,
    		exemplaryCode: elements.exemplaryCode.value,
    		localization: elements.localization.value,
    		braile: elements.braile.checked
    	},
    	beforeSend : function(){
      		
    	}
	}).done(function(response){
		
		bootbox.alert({
			message: "Cadastro realizado com sucesso",
			size: "small",
			callback: function(){location.reload();}
		});
	}		
	).fail(function(){
		bootbox.alert({
			message: "Não foi possível realizar o cadastro.",
			size: "small",
			callback: function(){location.reload();}
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
		var op;
		var select = $('#selectBooks')[0];
		var books = response.books;
		for (var i = 0; i < books.length; i++){
			op = document.createElement('option');
			op.setAttribute('value', books[i].isbn);
			op.innerHTML = books[i].name;
			select.appendChild(op);
		}
	});
}

function createUser(){
	var elements = $("#formUser")[0].elements;
	var formData = new FormData($("#formUser")[0]); 
	$.ajax({
		url : "http://127.0.0.1:781/services/user/create",
	    type : 'POST',
	    processData: false,
  		contentType: false,
    	data : formData,
    	beforeSend : function(){
      		
    	}
	}).done(function(response){
		bootbox.alert({
			message: "Cadastro realizado com sucesso",
			size: "small",
			callback: function(){location.reload();}
		});
	}).fail(function(){
		bootbox.alert({
			message: "Não foi possível realizar o cadastro.",
			size: "small",
			callback: function(){location.reload();}
		});
		
	});
}


function nextUserForm(){
	var inputStep = $("#inputStep");
	var steps = $('#steps');

	if(inputStep.val() == "1"){
		$("#step1").css('display', 'none');
		$("#step2").css('display', 'block');
		$("#btnBack").css('display', 'block');
		inputStep.val('2');
		steps.html("2 de 3");
	}
	else if (inputStep.val() == "2"){
		$("#step2").css('display', 'none');
		$("#step3").css('display', 'block');
		$("#btnProx").html("Finalizar");
		inputStep.val('3');
		steps.html("3 de 3");
	}
	else if(inputStep.val() == "3"){
		createUser();
	}
}

function backUserForm(){
	var inputStep = $("#inputStep");
	var steps = $('#steps');

	if(inputStep.val() == "2"){
		$("#step2").css('display', 'none');
		$("#step1").css('display', 'block');
		$("#btnBack").css('display', 'none');
		inputStep.val('1');
		steps.html("1 de 3");
	}
	else if (inputStep.val() == "3"){
		$("#step3").css('display', 'none');
		$("#step2").css('display', 'block');
		$("#btnProx").html("Próximo");
		inputStep.val('2');
		steps.html("2 de 3");
	}

}