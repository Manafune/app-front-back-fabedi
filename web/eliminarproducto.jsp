<%-- 
    Document   : eliminarproducto
    Created on : 23 ene. 2024, 13:05:56
    Author     : migue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="connection.Conexion, dao.ProductosDAO" %>
<jsp:useBean id="pr" class="model.Producto"></jsp:useBean>
<jsp:setProperty property="*" name="pr" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Eliminar Producto</title>
    </head>
    <body>
        <h1>Se elimino el Producto exitosamente</h1>
    </body>
    <%
    try{
        ProductosDAO.cambiarEstadoProducto(2,Integer.parseInt(request.getParameter("IdProducto")));
        response.sendRedirect("productos.jsp");
    }catch(Exception e){
        System.out.println(e);
    }
    %>
</html>
