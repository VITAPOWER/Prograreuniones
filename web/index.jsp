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

                    <p><h2>Accede al sitio</h2></p>
  
                    <br /><br />
                    <br /><br />
                    <br /><br />
	  
	  
                    <s:form action="loginindex">
                        <fieldset>
                    <s:textfield label="Usuario" name="username" value=""/>
                    <s:password label="Password" name="password" />
                    <s:submit />
                        </fieldset>
                    <s:if test="%{#message!=''}">
                    <tr><td colspan="2"><s:property value="message" /></td></tr>
                    </s:if>
                    </s:form>
                    <br />
                    <br />
                    <br /><br />
                    <p>¿No tienes una cuenta? <s:a action="alta">Registrate aquí</s:a></p>
                    <br /><br />
                    <br /><br />
                </div>
            </div>
        </div>
    </body>
</html>
