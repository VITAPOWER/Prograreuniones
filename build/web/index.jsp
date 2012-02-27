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
        <title>Progra Reuniones</title>
    </head>
    <body>
        <s:form action="loginindex">
        <s:textfield label="Usuario" name="username" value=""/>
        <s:password label="Password" name="password" />
        <s:submit />
        <s:if test="%{#message!=''}">
        <tr><td colspan="2"><s:property value="message" /></td></tr>
        </s:if>
        </s:form>
    </body>
    <s:a action="alta">Presione aqui para darse de alta</s:a>
</html>
