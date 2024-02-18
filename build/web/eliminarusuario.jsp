<%-- 
    Document   : eliminarempleado
    Created on : 14 ene. 2024, 18:12:25
    Author     : migue
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="connection.Conexion, dao.UsuarioDAO" %>
<jsp:useBean id="user" class="model.Usuario"></jsp:useBean>
<jsp:setProperty property="*" name="user"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Se elimino el Usuario exitosamente</h1>
    </body>
    <%
    try{
        UsuarioDAO.cambiarEstadoUsuario(Integer.parseInt(request.getParameter("IdUsuario")),2);
        response.sendRedirect("usuarios.jsp");
    }catch(Exception e){
        System.out.println(e);
    }
    %>
</html>

