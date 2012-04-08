                
function pageReload(opcion)
{
    var urlCompleto;
                    
    /*,email,reunion, horario
     *operacion 1 = bloqueo
     *operacion 2 = evitar
     *operacion 3 = apoyar
     *operacion 4 = reset
     **/
                    
    switch(opcion)
    {
        case 1:
            urlCompleto = 'http://localhost:8084/PrograReuniones/votacion.action?email=${action.email}&idreunion=${action.idreunion}&idhorario=${action.idhorario}&operacion=1';
            //alert("Caso1");
            break;
        case 2:
            urlCompleto = 'http://localhost:8084/PrograReuniones/votacion.action?email=${action.email}&idreunion=${action.idreunion}&idhorario=${action.idhorario}&operacion=2';
            //alert("Caso2");
            break;
        case 3:
            urlCompleto = 'http://localhost:8084/PrograReuniones/votacion.action?email=${action.email}&idreunion=${action.idreunion}&idhorario=${action.idhorario}&operacion=3';
            //alert("Caso3");
            break;
        case 4:
            urlCompleto = 'http://localhost:8084/PrograReuniones/votacion.action?email=${action.email}&idreunion=${action.idreunion}&idhorario=${action.idhorario}&operacion=4';
            //alert("Caso4");
            break;
        default:
            ;
    }
    return urlCompleto;
}

// Initialization
function init() {
    p_join_listen('/calendar');
}

// Event Callback: display all events
function onEvent(event) {
//RefreshCalendar
    
}


$(document).ready(function() {
	
    
        
    /* initialize the external events
		-----------------------------------------------------------------*/
    var vt = new Array();
    vt[0] = "Apoyar";
    vt[1] = "Evitar";
    vt[2] = "Bloquear";
    var votos = new Array();
    votos[0] = document.getElementById("apoyar").value;
    votos[1] = document.getElementById("evitar").value;
    votos[2] = document.getElementById("bloquear").value;
    i = 0
    $('#external-events div.external-event').each(function() {
		
        // store the Event Object in the DOM element so we can get to it later
        $(this).data('uitext', vt[i]);
        $(this).data('voto', votos[i]);
			
        $(this).html( votos[i] + " " + vt[i]);
        // make the event draggable using jQuery UI
        $(this).draggable({
            zIndex: 999,
            revert: true,      // will cause the event to go back to its
            revertDuration: 0,  //  original position after the drag
            stop: function(event, ui) {
                if($(this).data("voto") == 0) {
                    $(this).draggable( "option", "disabled", true );
                }
            }
        });
        i++;	
    });
	
    /* initialize the calendar
		-----------------------------------------------------------------*/
    $('#calendar').fullCalendar({
        header: {
            left: 'prev,next today',
            center: 'title',
            right: 'month,agendaWeek,agendaDay'
        },
        eventSources: [

        // your event source
        {
            url: 'buildCalendarvotacion',
            type: 'POST',
            data: {
                idreunion: document.getElementById("idreunion").value,
                email: document.getElementById("email").value
            },
            error: function() {
                alert('there was an error while fetching events!');
            }
        //dropableEvent
        }

        // any other sources...

        ],
        editable: false,
        droppable: false,
        eventRender: 
        function(event, element) {//Our events -> from eventSources
            element.droppable({
                activeClass: 'droppable-active',
                hoverClass: 'droppable-hover',
                drop: function(e, ui){ 
                    ui.draggable.data("voto", ui.draggable.data("voto") - 1);
                    ui.draggable.html( ui.draggable.data("voto") + " " + ui.draggable.data("uitext"));
                    //Aqui se manda votar
                    $.get( "voto" + ui.draggable.data("uitext") + "votacion", 
                    {
                        idreunion: document.getElementById("idreunion").value,
                        email: document.getElementById("email").value,
                        idhorario: event.id
                    } );
                /*if(ui.draggable.data("voto") == 0) {
                        ui.draggable( "option", "disabled", true );
                    }*/
                }//Actions
            })
        }
    });
		
});