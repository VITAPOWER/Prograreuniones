<%-- 
    Document   : index
    Created on : Feb 5, 2012, 3:33:48 PM
    Author     : snidE
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
        <s:form action="daralta">
        <s:textfield label="Nombre" name="nombre" />
        <s:textfield label="Usuario" name="username" />
        <s:password label="Password" name="password" />
        <s:textfield label="E-Mail" name="email" />
        <s:submit />
        </s:form>
    </body>
</html>
