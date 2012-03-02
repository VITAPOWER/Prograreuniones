<%-- 
    Document   : votacion
    Created on : 2/03/2012, 11:13:21 AM
    Author     : Carolina
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>${action.email}</h1>
        <table>
            <tr>
                <td>
                    Imagen
                </td>
                <td>
                    ${action.bloquear}
                </td>
                <td>
                    Imagen
                </td>
                <td>
                    ${action.evitar}
                </td>
                <td>
                    Imagen
                </td>
                <td>
                    ${action.apoyar}
                </td>
            </tr>
        </table>
    </body>
</html>
