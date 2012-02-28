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
        <title>Registrar nueva cuenta</title>
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
                    <p><h2>Registro de cuenta</h2></p>
  
                    <br /><br />
                    <br /><br />

                    <s:form action="daralta">
                  
                    <s:textfield label="Nombre" name="nombre" />
                    <s:textfield label="Usuario" name="username" />
                    <s:password label="Password" name="password" />
                    <s:textfield label="E-Mail" name="email" />
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
    </body>
</html>
