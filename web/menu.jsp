<%-- 
    Document   : menu
    Created on : 6/02/2012, 07:30:03 PM
    Author     : Carolina
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="EN" lang="EN" dir="ltr">
    <head profile="http://gmpg.org/xfn/11">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv="imagetoolbar" content="no" />
        <title>Menu</title>
        <link rel="stylesheet" href="styles/layout.css" type="text/css" />
    </head>
    <body id="top">
        <div class="wrapper col1">
            <div id="header">
                <div id="logo">
                    <h1><a href="#">PrograReuniones</a></h1>
                    <p><strong>Reinventando la manera de organizar las reuniones</strong></p>
                </div>
                <br class="clear" />
	
                <div id="newsletter">
                    <form action="logout" method="post">
                        <fieldset>
                        <input type="submit" name="news_go" id="news_go" value="Cerrar Sesion" />
                        </fieldset>
                    </form>
                </div>
	
                <br />
                <br />
	
            </div>
        </div>
        <div class="wrapper col2">
            <div id="topbar">
                <div id="topnav">
                    Bienvenido! <s:property value="#session.nombreusuario" />
                    <br />
                    <br />

                </div>
      
                <br class="clear" />
            </div>
        </div>

        <div class="wrapper col3">
            <div id="breadcrumb">

                <div id="newsletter" align = center>

                    <p><h2>Actividad Reciente</h2></p>
                    <br />
                    <br />

                    <table summary="Summary Here" cellpadding="0" cellspacing="0">
                        <thead>
                            <tr>
                                <th>Header 1</th>
                                <th>Header 2</th>
                                <th>Header 3</th>
                                <th>Header 4</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr class="light">
                                <td>Value 9</td>
                                <td>Value 10</td>
                                <td>Value 11</td>
                                <td>Value 12</td>
                            </tr>
                            <tr class="dark">
                                <td>Value 13</td>
                                <td>Value 14</td>
                                <td>Value 15</td>
                                <td>Value 16</td>
                            </tr>
                        </tbody>
                    </table>
	  
                    <table>
                        <tbody>
                            <tr>
                                <td><s:a action="creargrupo">Crear Reunión</s:a></td>
                            </tr>
                            <tr>
                                <td><s:a>Mis Grupos</s:a></td>
                            </tr>
                        </tbody>
                    </table>
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
    </body>
</html>
