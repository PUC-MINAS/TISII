function execRetrieveUser(){
    
    var tabelaHTML = '<label class="title">Dados do Usuario</label><hr>';
    tabelaHTML += '<div class="user-data">';
    tabelaHTML += '<table id="user-data"><tr><th></th>';
    tabelaHTML += '<th>Dados</th></tr><tr>';
    tabelaHTML += '<td>Nome de usuario:</td>';
    tabelaHTML += '<td>'+  +'</td></tr>';
    tabelaHTML += '<tr><td>Email:</td>';
    tabelaHTML += '<td>'+  +'</td></tr>';
    tabelaHTML += '</table>';
    tabelaHTML += '</div>';
    document.getElementById("info-profile-div").innerHTML = tabelaHTML;
}

function execRetrieveUserName(){
    if(localStorage.getItem("user-name")== null)
        localStorage.setItem("user-name","Jon");

            document.getElementById("user-name").innerHTML = localStorage.getItem("user-name");
    document.getElementsByClassName("user-name").innerHTML = localStorage.getItem("user-name");
    document.getElementsByClassName("user-name").style.display = "inline-block";
}

function login(){
    var loginInfo = '';
}

function execRetrieveBorrowed(){
    
    var tabelaHTML = '<label class="title">Livros Emprestados</label><hr>';

    document.getElementById("info-profile-div").innerHTML = tabelaHTML;
}

function execRetrieveReservs(){
    
    var tabelaHTML = '<label class="title">Livros Reservados</label><hr>';

    document.getElementById("info-profile-div").innerHTML = tabelaHTML;
}

