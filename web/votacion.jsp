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
        <title>Votar por horario</title>
    </head>
    <body>
        <h1>Datos del usuario:</h1>
        <table>
            <tr>
                <td>
                    Correo electronico:  
                </td>
                <td>
                    ${action.email}
                </td>
            </tr>
            <tr>
                <td>
                    Reunion:  
                </td>
                <td>
                    ${action.idreunion}
                </td>
            </tr>
            <tr>
                <td>
                    Horario:  
                </td>
                <td>
                    ${action.idhorario}
                </td>
            </tr>
        </table>
        <hr />
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

        <hr />

        <table>
            <tr>
                <td>
            <s:form action="">
                <input type="button" name="bloquear" value="Bloqueo" />
                <s:submit />
            </s:form>
        </td>
        <td>
            Cantidad de "bloqueos" disponibles
            ${action.bloquear}
        </td>
    </tr>
    <tr>
        <td>
    <s:form action="">
        <input type="button" name="bloquear" value="Evitar" />
        <s:submit />
    </s:form>
</td>
<td>
    Cantidad de "evitar" disponibles
    ${action.evitar}
</td>
</tr>
<tr>
    <td>
<s:form action="">
    <input type="button" name="bloquear" value="Apoyos">
    <s:submit />
</s:form>
</td>
<td>
    Cantidad de "apoyos" disponible
    ${action.apoyar}
</td>
</tr>
</table>

<hr />

</body>
</html>
