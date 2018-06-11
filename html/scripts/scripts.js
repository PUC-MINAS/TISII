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
		console.log(response);
		if (response.status == "CREATED"){
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

/*<div class="row align-items-center" id="divModelo">	
      		<div class= "col-md-2 col-sm-2 col-xs-2">
      			<div class="row justify-content-md-center">
      				<div class="col-md-2">
      					<img src="images/book_icon.png" style="width: 60px; height: 60px;">		
      				</div>
      				
      			</div>      			
      		</div>
      		<div class="col-md-7 col-sm-6 col-xs-6">
      			<div class="row">
      				<div class="col">
      					<h5>Nome do livro</h5>
      				</div>
      			</div>
      			<div class="row">
      				<div class="col">
      					<span>place autor</span>
      				</div>
      			</div>
      			<div class="row">
      				<div class="col">
      					Genero: <span>Aventura</span> - Editora <span>Qualquer</span>
      				</div>
      			</div>
      		</div>

      		<div class="col-md-3 col-sm-4 col-xs-4">
      			<button class="btn btn-default">Detatlhes</button>
      			<button class="btn btn-primary">Reservar</button>
      		</div>
      	</div>*/

function fillDivBook( book){
	var divObj = document.createElement('div');
	divObj.setAttribute("class", "row align-items-center" );
	divObj.setAttribute("id", "book_" +book.name );

	var div = '';
	div += '<div class= "col-md-2 col-sm-2 col-xs-2"> <div class="row justify-content-md-center">';
    div += '<div class="col-md-2"><img src="images/book_icon.png" style="width: 60px; height: 60px;"></div></div></div>';
    div += '<div class="col-md-7 col-sm-6 col-xs-6"><div class="row"><div class="col">';
    div += '<h5>'+book.name+'</h5>';
    div += '</div></div><div class="row"><div class="col">';
    div += '<span>'+book.author+'</span>';
    div += '</div></div><div class="row"><div class="col">';
    div += 'Gênero: <span>'+book.genreTitle+'</span> - Editora <span>'+book.publishingCompany+'</span>';
    div += '</div></div></div><div class="col-md-3 col-sm-4 col-xs-4">';
    div += '<button class="btn btn-default">Detatlhes</button>';
    div += '<button class="btn btn-primary">Reservar</button>';
	div += '</div>';

	divObj.innerHTML = div;

	return divObj;
}

function fillBookList(){
	$.ajax({
		url: "http://127.0.0.1:781/services/book/read",
		type: 'GET',
	}).done(function(response){
		console.log(response);
		var div = $("#searchContainer")[0];
		if (response.status == 'OK'){
			var books = response.books;
			var divBook ;

			for (var i = 0; i < books.length; i++){
				div.appendChild(fillDivBook(books[i]));
			}

		}
				
	}).fail(function(){
		
	});
}

function createUser(){
	var elements = $("#formUser")[0].elements;
	$.ajax({
		url : "http://127.0.0.1:781/services/user/create",
	    type : 'POST',
    	data : {
    		username: elements.username.value,
    		type: elements.type.value,
    		email: elements.email.value,
    		password: elements.password.value,
    		firstName: elements.firstName.value,
    		lastName: elements.lastName.value,
    		birth: elements.birth.value,
    		docIdentity: elements.docIdentity.value,
    		docCpf: elements.docCpf.value,
    		phone: elements.phone.value,
    		cel: elements.cel.value,
    		adress: elements.address.value,
    		number: elements.number.value,
    		complement: elements.complement.value,
    		cep: elements.cep.value,
    		city: elements.city.value,
    		state: elements.state.value
    	},
    	beforeSend : function(){
      		
    	}
	}).done(function(response){
		console.log(response);
		if (response.status == "CREATED"){
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

//Funcao que gera div na tela de pesquisa para insercao dos dados do livro
function generateDataDiv() {
	var dataDiv = document.createElement("div");
    dataDiv.classList.add("bookData");
    document.getElementById("searchContainer").appendChild(dataDiv);
}