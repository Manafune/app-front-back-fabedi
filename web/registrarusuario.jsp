<%-- 
    Document   : registrarusuario
    Created on : 14 ene. 2024, 18:16:31
    Author     : migue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="us" class="model.Usuario" />
<%@page import="dao.UsuarioDAO" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Usuario</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link rel="stylesheet" href="css/forms.css"/>
    </head>
    <body>
        <%
        if((request.getParameter("Username")!=null)&(request.getParameter("Contrasena")!=null)&(request.getParameter("Nombres")!=null)&(request.getParameter("Apellidos")!=null)&(request.getParameter("Rol")!=null)&(request.getParameter("Estado")!=null)){
            try{
                us.setUsername(request.getParameter("Username"));
                us.setContrasena(request.getParameter("Contrasena"));
                us.setNombres(request.getParameter("Nombres"));
                us.setApellidos(request.getParameter("Apellidos"));
                us.setRol(request.getParameter("Rol"));
                us.setEstado(Integer.parseInt(request.getParameter("Estado")));
                int i = UsuarioDAO.guardar(us);
            }catch(Exception e){
                System.out.println(e);
            }
        }
        %>
        <div class="container">
            <h2>Registro Agregado exitosamente</h2>
            <a href="usuarios.jsp">Regresar</a>
        </div>
    </body>
</html>
