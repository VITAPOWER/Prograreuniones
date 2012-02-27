<%-- 
    Document   : creargrupo
    Created on : 8/02/2012, 04:00:26 PM
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
        
        <h1>Crear Grupo</h1>
        <s:form action="darcreargrupo">
            <s:textfield label="Nombre de Grupo" name="nombrereunion" />
            <s:textfield label="Hora de apertura" name="tiempocreacion" />
            <s:textfield label="Tiempo limite" name="tiemporestante" />
            <s:submit />
        </s:form>
    </body>
</html>
