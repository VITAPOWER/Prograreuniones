<%-- 
    Document   : votacion
    Created on : 2/03/2012, 11:13:21 AM
    Author     : Carolina
--%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="EN" lang="EN" dir="ltr">
    <head profile="http://gmpg.org/xfn/11">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <meta http-equiv="imagetoolbar" content="no" />
            <link rel="stylesheet" href="styles/layout.css" type="text/css" />
            <title>Progra Reuniones</title>
            <link rel='stylesheet' type='text/css' href='styles/fullcalendar.css' />
            <link rel='stylesheet' type='text/css' href='styles/fullcalendar.print.css' media='print' />
            <link rel='stylesheet' type='text/css' href='styles/votacion.css'/>
            <link rel='stylesheet' type='text/css' href='styles/jquery.countdown.css'/>
            <script type='text/javascript' src='js/jquery/jquery-1.7.1.min.js'></script>
            <script type='text/javascript' src='js/jquery/jquery-ui-1.8.18.custom.min.js'></script>
            <script type='text/javascript' src='js/fullcalendar/fullcalendar.min.js'></script>
            <script type="text/javascript" src="js/js-pushlet-client.js"></script>
            <script type="text/javascript" src="js/jquery.countdown.min.js"></script>
            <script type="text/JavaScript" src="js/votacion.js"></script>
    </head>
    <body id="top"  onLoad="init()">
        <div class="wrapper col1">
            <div id="header">
                <div id="logo">
                    <h1><a href="#">PrograReuniones</a></h1>
                    <p><strong>Reinventando la manera de organizar las reuniones</strong></p>
                </div>
                <br class="clear" />
            </div>
        </div>
        <div class="wrapper col2">
            <div id="topbar">
                <div id="topnav">

                    <br />
                    <br />

                </div>

                <br class="clear" />
            </div>
        </div>
        <div class="wrapper col3">
            <div id="breadcrumb">
                <div id='wrap'>

                    <div id='external-events'>
                        <h4>Votos Disponibles</h4>
                        <div id="Apoyar" class='external-event'>Apoyar</div>
                        <div id="Evitar" class='external-event'>Evitar</div>
                        <div id="Bloquear" class='external-event'>Bloquear</div>
                        <button id="reset" onclick="resetVotos()">Restablecer Votos</button>
                        <hr>
                        <div>Tiempo restante:</div>    
                        <div id="countdown" class='countdown'></div>
                        <p>
                            <!--input type='checkbox' id='drop-remove' /> <label for='drop-remove'>remove after drop</label-->
                        </p>
                    </div>

                    <div id='calendar'></div>

                    <div style='clear:both'></div>
                </div>
            </div>
        </div>
        <script type="text/javascript">p_embed()</script>
        <s:hidden id="idreunion" name="idreunion" />
        <s:hidden id="email" name="email" />
        <s:hidden id="apoyar" name="apoyar" />
        <s:hidden id="evitar" name="evitar" />
        <s:hidden id="bloquear" name="bloquear" />
        <s:hidden id="resetApoyar" name="resetApoyar" />
        <s:hidden id="resetEvitar" name="resetEvitar" />
        <s:hidden id="resetBloquear" name="resetBloquear" />
        <s:hidden id="fechaFin" name="fechaFin" />
    </body>
</html>
