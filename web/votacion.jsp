<%-- 
    Document   : votacion
    Created on : 2/03/2012, 11:13:21 AM
    Author     : Carolina
--%>

<%-- 
    Document   : index
    Created on : Feb 5, 2012, 3:33:48 PM
    Author     : snidE
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

                    <p><h2>Votacion de ${action.email}</h2></p>
                     <%--Se debe de hacer una tabla dinamica para todos los horarios disponibles o un update panel --%>
        <table>
            <tr>
                <td>
                    Horario disponible
                </td>
            </tr>
            <tr>
                <td>
                   Fecha de inicio:
                   ${action.horarioInicio} 
                </td>
                <td>
                   Fecha de fin:
                   ${action.horarioFin} 
                </td>
            </tr>
        </table>
        <table>
            <tr>
                <td>
                    <img alt="Bloquea un horario" src="images/votacion/round_delete.png" id="imgblock" height="48" width="48">
                </td>
                <td>
                    <input type="text" id ="textblock" value="${action.bloquear}" size="2" name="textblock" />
                </td>
                <td>
                    <img alt="Evitar un horario" src="images/votacion/round_minus.png" id="imgevade" height="48" width="48">
                </td>
                <td>
                    <input type="text" id ="textevade" value="${action.evitar}" size="2" name="textevade" />
                </td>
                <td>
                    <img alt="Apoyar un horario" src="images/votacion/round_plus.png" id="imgsupport" height="48" width="48">
                </td>
                <td>
                    <input type="text" id ="textsupport" value="${action.apoyar}" size="2" name="textsupport"/>
                </td>
                <td>
                    <input type="button" value="Reset" id="Reset" name="Reset"/>
                </td>
            </tr>
        </table>
                    <br /><br />
                    <br /><br />
                    <br /><br />
                    <br />
                    <br />
                    <br /><br />
                    <br /><br />
                    <br /><br />
                </div>
            </div>
        </div>
    </body>
</html>
