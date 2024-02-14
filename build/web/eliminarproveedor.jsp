<%-- 
    Document   : eliminarproveedor
    Created on : 14 ene. 2024, 15:21:45
    Author     : migue
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="connection.Conexion, dao.ProveedorDAO" %>
<jsp:useBean id="pv" class="model.Proveedor"></jsp:useBean>
<jsp:setProperty property="*" name="pv" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Se elimino el Proveedor exitosamente</h1>
    </body>
    <%
    try{
        System.out.println(pv.getRUC());
        ProveedorDAO.eliminar(pv);
        response.sendRedirect("proveedores.jsp");
    }catch(Exception e){
        System.out.println(e);
    }
    %>
</html>
