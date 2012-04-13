// Initialization
function init() {
    p_join_listen('/calendar' + document.getElementById("idreunion").value);
}

// Event Callback: display all events
function onEvent(event) {
    //RefreshCalendar
    $('#calendar').fullCalendar( 'refetchEvents' );
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
    var colors = new Array();
    colors[0] = "Blue";
    colors[1] = "Gray";
    colors[2] = "Red";
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
        if($(this).data("voto") == 0) {
            $(this).draggable( "option", "disabled", true );
        }
        $(this).css("background-color", colors[i]);
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
                }//Actions
            })
        }
    });
    
    $('#countdown').countdown({
        until: new Date(document.getElementById("fechaFin").value), 
        //format: 'dHM', 
        onExpiry: liftOff
    });
    if (new Date() > new Date(document.getElementById("fechaFin").value)) {
        liftOff();
    }
});

function resetVotos (){
    $.get( "resetMyVotesvotacion", 
    {
        idreunion: document.getElementById("idreunion").value,
        email: document.getElementById("email").value
    } );
    var votos = new Array();
    votos[0] = document.getElementById("resetApoyar").value;
    votos[1] = document.getElementById("resetEvitar").value;
    votos[2] = document.getElementById("resetBloquear").value;
    i = 0
    $('#external-events div.external-event').each(function() {
        $(this).data('voto', votos[i]);
        $(this).html( $(this).data('voto') + " " +  $(this).data('uitext'));
        if($(this).data("voto") > 0) {
            $(this).draggable( "option", "disabled", false );
        }
        i++;
    });
}

function liftOff() { //El tiempo termino deshabilita todo
    $('#external-events div.external-event').each(function() {
        $(this).draggable( "option", "disabled", true );
    });
    document.getElementById("reset").disabled = true;
} 