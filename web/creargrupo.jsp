<%-- 
    Document   : creargrupo
    Created on : 8/02/2012, 04:00:26 PM
    Author     : Carolina

<
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="EN" lang="EN" dir="ltr">
    <head profile="http://gmpg.org/xfn/11">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="imagetoolbar" content="no" />
        <link rel="stylesheet" href="styles/layout.css" type="text/css" />
        <title>Crear Reunión</title>
        <script type="text/javascript" src="js/addhorario.js"></script>
        <script type="text/javascript" src="js/addparticipantes.js"></script>
        <script type="text/javascript" src="js/datetimepicker.js"></script>
        <script type="text/javascript" src="js/addcalendars.js"></script>
        <script type="text/javascript" src="js/validaciones.js"></script>
    </head>
    <body id="top">
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

                <div id="newsletter" align = center>
                    <p><h2>Crear Reunión</h2></p>
        
                    <br /><br />
                    <br /><br />
        
                    <s:form  name="crearReunion" action="darcreargrupo" method="post" onsubmit ="return  validacion()">
                        <s:textfield label="Nombre de Grupo" name="nombrereunion"/>
                        <s:textfield label="Hora de apertura" name="tiempocreacion" id="tiempocreacion"/>
                        <s:textfield label="Tiempo limite" name="tiemporestante" id="tiemporestante"/>
                        <tr><td class="tdLabel"><input type="button" value="Agrega horario" onclick="addhr()"/></td>
                            <td><table id="fooBar"></table></td></tr>
                        <tr><td class="tdLabel"><input type="button" value="Agrega usuario" onclick="addparticipante()"/></td>
                            <td><table id="addpart"></table></td></tr>
                        <s:submit />
                    </s:form>
                    <br />
                    <br />
                    <br />
                </div>
            </div>
        </div>
    
        <div id="copyright">
            <p class="fl_left">Copyright &copy; 2011 - All Rights Reserved</p>
            <br class="clear" />
        </div>
        <script>window.onload=loadcalendarios;</script>
    </body>
</html>

