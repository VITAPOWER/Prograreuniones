<%-- 
    Document   : menu
    Created on : 6/02/2012, 07:30:03 PM
    Author     : Carolina
--%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <p>Bienvenido! <s:property value="#session.nombreusuario" />
        </p>
        <h1>Panel de Usuario</h1>
        <table>
            <tr>
                <td><s:a action="creargrupo">Crear Reunión</s:a></td>
            </tr>
            <tr>
                <td><s:a>Mis Grupos</s:a></td>
            </tr>
        </table>
    </body>
</html>
