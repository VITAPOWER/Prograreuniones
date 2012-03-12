/**
 * @author Eder
 */

//hace la validacion de los campos estaticos;
function validacion(){
    
    var input1=document.forms["crearReunion"]["nombrereunion"].value;
    var input2=document.forms["crearReunion"]["tiempocreacion"].value;
    var input3=document.forms["crearReunion"]["tiemporestante"].value;

    //Si esta variable existe, quiere decir que hay al menos uno horario.
    var horarioDesde1 = document.getElementById('desde0');
    //Si esta variable existe, quiere decir que hay al menos dos horarios.
    var horarioDesde2 = document.getElementById('desde1');

    //Si esta variable existe, quiere decir que hay al menos un usuario.
    var usuario1 = document.getElementById('invitado0');
    //Si esta variable existe, quiere decir que hay al menos dos un usuarios.
    var usuario2 = document.getElementById('invitado1');


    //verifica que no haya campos vacios en la parte estatica.
    if(validaNoVacioEstatico(input1, input2,input3) == false){
        return false;
    }
    //verifica que el input 2 y 3 sean exclusivamente fechas.
    if(validaQueSeaFecha(input2 , input3) == false){
        return false;
    }
    //verifica que las fechas de creacion de reunion y tiempo limite para la votacion sean consistentes entre si
    if(verificaConsistenciaFecha(input2 , input3) == false){
        return false;
    }
    
    //Parte de la validacion dinamica: realiza la 
    //verificacion de los campos que se generan dinamicamente

    //verifica que exista mas de 1 horario para la votacion
    if(verificaMasDeUnHorario(horarioDesde1, horarioDesde2) == false){
        return false;
    }
 
    //Se mandan a llamar metodos en este metodo que verifican la consistencia entre los horarios.
    if (recorreHorarios() == false){
        return false;
    }
    if(recorreHorarios() == true){
     //Parte de la validacion al agregar puntos a usuario
        if(verificaMasDeUnUsuario(usuario1, usuario2) == false){
            return false;
        }
    
        if (recorreUsuarios() == false){
            return false;
        }   
    }
}

function validaQueSeaFecha(fecha1 , fecha2){
    
    var validafecha = new RegExp("^[0-9]{4}-(((0[13578]|(10|12))-(0[1-9]|[1-2][0-9]|3[0-1]))|(02-(0[1-9]|[1-2][0-9]))|((0[469]|11)-(0[1-9]|[1-2][0-9]|30))) [0-9][0-9]:[0-9][0-9]:[0-9][0-9]");
    if (validafecha.test(fecha1) == false){
        alert("Formato de fecha de inicio de votacion incorrecto");
        return false;
    }
    if (validafecha.test(fecha2) == false){
        alert("Formato de fecha de fin de votacion incorrecto");
        return false;
    }
//return true;
}

function verificaMasDeUnHorario(horarioDesde1, horarioDesde2){
    
    if(horarioDesde1 == null){
        alert("Necesita especificar los diferentes horarios para su reunion");
        return false;
    }
    
    if(horarioDesde2 == null){
        alert("Necesita especificar al menos 2 horarios para su reunion");
        return false;
    }
//return true;
}


function validaNoVacioEstatico(input1, input2,input3){

    if (input1==null || input1=="")
    {
        alert("Necesitas ponerle un nombre a la reunion");
        return false;
    }
    if (input2==null || input2==""){
        alert("Elige una fecha y hora para comenzar votacion");
        return false;
    }  
    if (input3==null || input3==""){
        alert("Elige una fecha y hora para finalizar votacion");
        return false; 
    }
//return true;
}

function verificaConsistenciaFecha(fecha1 , fecha2){
    
    var arrayDate1 = fecha1.split(" ");
    var arrayDate2 = fecha2.split(" ");
    
    var fechaEntera1 = arrayDate1[0];
    var fechaEntera2 = arrayDate2[0];
    
    var horaEntera1 = arrayDate1[1];
    var horaEntera2 = arrayDate2[1];
    
    
    var anio1 = parseInt(fechaEntera1.split("-")[0]);
    var mes1  = parseInt(fechaEntera1.split("-")[1]);
    var dia1  = parseInt(fechaEntera1.split("-")[2]);
    
    var anio2 = parseInt(fechaEntera2.split("-")[0]);
    var mes2  = parseInt(fechaEntera2.split("-")[1]);
    var dia2  = parseInt(fechaEntera2.split("-")[2]);
    
    var hora1 = parseInt(horaEntera1.split(":")[0]);
    //var min1  = parseInt(horaEntera1.split(":")[1]);
    //var seg1  = parseInt(horaEntera1.split(":")[2]);
    
    var hora2 = parseInt(horaEntera2.split(":")[0]);
    //var min2  = parseInt(horaEntera2.split(":")[1]);
    //var seg2  = parseInt(horaEntera1.split(":")[2]);    
    
    
    if(anio1 > anio2 || mes1 > mes2 || dia1 > dia2){
        alert("Inconsistencia entre la fecha de creacion y la fecha de finalizacion");
        return false;
    }
    
    if(anio1 == anio2 && mes1 == mes2 && dia1 == dia2){
        if(hora1 > hora2){
            alert("Inconsistencia entre la fecha de creacion y la fecha de finalizacion");
            return false;
        } 
        if(hora1 == hora2){
            alert("Tiempo de votacion insuficiente");
            return false;
        }    
    }
//return true;
    
}

function verificaFechaEnRango(fecha1 , fecha2, fecha3,numHorario){
    
    var arrayDate1 = fecha1.split(" ");
    var arrayDate2 = fecha2.split(" ");
    var arrayDate3 = fecha2.split(" ");
    
    var fechaEntera1 = arrayDate1[0];
    var fechaEntera2 = arrayDate2[0];
    var fechaEntera3 = arrayDate3[0];
    
    var horaEntera1 = arrayDate1[1];
    var horaEntera2 = arrayDate2[1];
    var horaEntera3 = arrayDate2[1];
    
    var anio1 = parseInt(fechaEntera1.split("-")[0]);
    var mes1  = parseInt(fechaEntera1.split("-")[1]);
    var dia1  = parseInt(fechaEntera1.split("-")[2]);
    
    var anio2 = parseInt(fechaEntera2.split("-")[0]);
    var mes2  = parseInt(fechaEntera2.split("-")[1]);
    var dia2  = parseInt(fechaEntera2.split("-")[2]);
    
    var anio3 = parseInt(fechaEntera3.split("-")[0]);
    var mes3  = parseInt(fechaEntera3.split("-")[1]);
    var dia3  = parseInt(fechaEntera3.split("-")[2]);
    
    var hora1 = parseInt(horaEntera1.split(":")[0]);
    //var min1  = parseInt(horaEntera1.split(":")[1]);
    //var seg1  = parseInt(horaEntera1.split(":")[2]);
    
    var hora2 = parseInt(horaEntera2.split(":")[0]);
    //var min2  = parseInt(horaEntera2.split(":")[1]);
    //var seg2  = parseInt(horaEntera1.split(":")[2]);    
    
    var hora3 = parseInt(horaEntera3.split(":")[0]);
    //var min2  = parseInt(horaEntera2.split(":")[1]);
    //var seg2  = parseInt(horaEntera1.split(":")[2]);    
    
    
    if(anio1 > anio2 || mes1 > mes2 || dia1 > dia2){
        alert("La fecha de inicio del horario numero" + numHorario + " debe ser posterior a la fecha de apertura del grupo");
        return false;
    }
    
    if(anio1 == anio2 && mes1 == mes2 && dia1 == dia2){
        if(hora1 > hora2){
            alert("La fecha y hora del horario numero " + numHorario + " es posterior a la fecha y hora de apertura del grupo");
            return false;
        }     
        if(hora2 < (hora1 + 1)){
            alert("La hora del horario numero " + numHorario + " debe ser al menos una hora mas que la hora de la creacion de la reunion");
            return false;
        } 
    }
    
    if(anio1 > anio3 || mes1 > mes3 || dia1 > dia3){
        alert("La fecha del horario numero" + numHorario + "es posterior a la fecha de apertura del grupo");
        return false;
    }
    
    if(anio3 == anio2 && mes1 == mes3 && dia1 == dia3){
        if(hora1 > hora3){
            alert("La fecha y hora del horario numero " + numHorario + " es posterior a la fecha y hora de apertura del grupo");
            return false;
        }     
    }
    
//return true;
    
}

function recorreHorarios(){
    
    var i = 0;
    var numHorario = i + 1;
    var initReunion=document.forms["crearReunion"]["tiempocreacion"].value;
    var endReunion=document.forms["crearReunion"]["tiemporestante"].value;
        
    while(document.getElementById('desde'+i).value != null && document.getElementById('hasta'+i).value != null){
        
       
        if(validaQueSeaFecha(document.getElementById('desde'+i).value ,  document.getElementById('hasta'+i).value) == false){
            return false;
        }
        
        if(verificaFechaEnRango(initReunion, document.getElementById('desde'+i).value, endReunion, numHorario) == false){
            return false;
        }
        
        if(verificaConsistenciaFecha(document.getElementById('desde'+i).value, document.getElementById('hasta'+i).value) == false){
            return false;
        }
        //alert("estos son los horarios creados" + i+1);
        i++;
        
    }
//return true;    
}

function recorreUsuarios(){

    var i = 0;

    alert("haha business3!!");

    while(document.getElementById('invitado'+i).value != null){
        
        if(esVacioUsuario(document.getElementById('invitado'+i).value,
            document.getElementById('tagblock'+i).value,
            document.getElementById('tagevade'+i).value,
            document.getElementById('tagsupport'+i).value) == true){
            return false;
        }
       
        if(validaInputsUsuario( document.getElementById('invitado'+i).value,  
            document.getElementById('tagblock'+i).value,
            document.getElementById('tagevade'+i).value, 
            document.getElementById('tagsupport'+i).value) == false){
            return false;
        }
        //alert("estos son los horarios creados" + i+1);
        i++;
    }
}

function verificaMasDeUnUsuario(usuario1, usuario2){
    
    if(usuario1 == null){
        alert("Necesita especificar usuarios para su reunion");
        return false;
    }
    
    if(usuario2 == null){
        alert("Necesita especificar al menos 2 usuarios para su reunion");
        return false;
    }
//return true;
}

function esVacioUsuario(usuario,blokear,evadir, apoyar){
   
    if(usuario == null || usuario == ""){
        alert("Campo de Email vacio");
        return true;
    }
    if(blokear == null || blokear == ""){
        alert("Campo de Bloqueo vacio");
        return true;
    }
   
    if(evadir == null || evadir == ""){
        alert("Campo de Evadir vacio");
        return true;
    }
   
    if(apoyar == null || apoyar == ""){
        alert("Campo de Apoyar vacio");
        return true;
    }
}

function validaInputsUsuario(usuarioMail, numBlock, numEvade, numSupport){
    
    var emailPattern = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;  
    var numOnly      = /^[0-9]$/;

    if(!emailPattern.test(usuarioMail)){
        alert("Escriba una direccion de Email valida");
        return false;
    }
    if(!numOnly.test(numBlock)){
        alert("Escriba un numero para el campo de bloqueo");
        return false;
    }
    if(!numOnly.test(numEvade)){
        alert("Escriba un numero para el campo de Evadir");
        return false;
    }
    if(!numOnly.test(numSupport)){
        alert("Escriba un numero para el campo de Apoyar");
        return false;
    }
//return true;
}
