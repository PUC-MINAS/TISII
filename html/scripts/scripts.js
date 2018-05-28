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
			size: "small",
			callback: function(){location.reload();}
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
		var op;
		var select = $('#selectBooks')[0];
		var books = response.books;
		for (var i = 0; i < books.length; i++){
			op = document.createElement('option');
			op.setAttribute('value', books[i].name);
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