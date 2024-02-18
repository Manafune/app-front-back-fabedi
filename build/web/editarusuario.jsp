<%-- 
    Document   : editarempleado
    Created on : 14 ene. 2024, 15:24:23
    Author     : migue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="connection.Conexion, model.Usuario, dao.UsuarioDAO, java.util.*"%>
<%
int id = Integer.parseInt(request.getParameter("IdUsuario"));
Usuario u = UsuarioDAO.buscarporId(id);
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/forms.css"/>
    </head>
    <body>
        <div class="container">
            <h1>Editar Usuario</h1>
            <% String IdUsuario = request.getParameter("IdUsuario");%>
            <form action="editarusuario.jsp" method="post">
                <input type="hidden" name="IdUsuario" value="<%= u.getIdUsuario()%>" readonly><br>

                <label for="Username">Nombre de Usuario:</label>
                <input type="text" name="Username" value="<%= u.getUsername()%>"><br>

                <label for="Contrasena">Contraseña:</label>
                <input type="password" name="Contrasena" value="<%= u.getContrasena()%>"><br>

                <label for="Nombres">Nombres:</label>
                <input type="text" name="Nombres" value="<%= u.getNombres()%>"><br>

                <label for="Apellidos">Apellidos:</label>
                <input type="text" name="Apellidos" value="<%= u.getApellidos()%>"><br>
                
                <label for="Rol">Rol:</label>
                <select name="Rol">
                    <option value="USER" <%= u.getRol().equals("USER") ? "selected" : "" %>>USER</option>
                    <option value="ADMIN" <%= u.getRol().equals("ADMIN") ? "selected" : "" %>>ADMIN</option>
                </select><br>
               <div class="form-group">
                <label for="Estado">Estado:</label>
                <select class="form-control" name="Estado" required>
                    <option value="1">Activo</option>
                </select>
                </div>
                <input type="submit" value="Actualizar">
            </form>
        </div>
        <%
            if((request.getParameter("IdUsuario")!=null)&(request.getParameter("Username")!=null)&(request.getParameter("Contrasena")!=null)&(request.getParameter("Nombres")!=null)&(request.getParameter("Apellidos")!=null)&(request.getParameter("Rol")!=null)&(request.getParameter("Estado")!=null)){
                try{
                    u.setIdUsuario(Integer.parseInt(request.getParameter("IdUsuario")));
                    u.setUsername(request.getParameter("Username"));
                    u.setContrasena(request.getParameter("Contrasena"));
                    u.setNombres(request.getParameter("Nombres"));
                    u.setApellidos(request.getParameter("Apellidos"));
                    u.setRol(request.getParameter("Rol"));
                    u.setEstado(Integer.parseInt(request.getParameter("Estado")));
                    try{
                        int i = UsuarioDAO.actualizar(u);
                        if(i>0){
                            response.sendRedirect("usuarios.jsp");
                        }else{
                            %>
                            <p style="color:red" class="p-5"><%="Error al intentar actualizar"%></p>
                            <%
                        }
                    }catch(Exception e){
                        System.out.println(e);
                    }
                }catch(Exception e){
                    System.out.println(e);
                }
            }
            %>
    </body>
</html>
