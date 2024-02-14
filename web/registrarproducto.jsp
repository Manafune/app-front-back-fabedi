<%-- 
    Document   : registrarproducto
    Created on : 14 ene. 2024, 12:00:33
    Author     : migue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="prod" class="model.Producto" />
<%@page import="dao.ProductosDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Productos</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link rel="stylesheet" href="css/forms.css"/>
    </head>
    <body>
        <%
        if((request.getParameter("ProNombre")!=null)&(request.getParameter("ProStock")!=null)&(request.getParameter("PrecioCompra")!=null)&(request.getParameter("PrecioVenta")!=null)&(request.getParameter("ProEstado")!=null)&(request.getParameter("ProEnvase")!=null)&(request.getParameter("Categoria")!=null)){
            try{
                prod.setProNombre(request.getParameter("ProNombre"));
                prod.setProStock(Integer.parseInt(request.getParameter("ProStock")));
                prod.setPrecioCompra(Float.parseFloat(request.getParameter("PrecioCompra")));
                prod.setPrecioVenta(Float.parseFloat(request.getParameter("PrecioVenta")));
                prod.setProEstado(request.getParameter("ProEstado"));
                prod.setProEnvase(request.getParameter("ProEnvase"));
                prod.setCategoria(request.getParameter("Categoria"));
                /*Enviar datos a la tabla de Invocacion a la clase DAO y el metodo Guardar*/
                int i = ProductosDAO.guardar(prod);
            }
            catch(Exception e){
                System.out.println(e);
                }
            }
        %>
        <div class="container">
            <h2>Registro Agregado Exitosamente</h2>
            <a href="productos.jsp">Regresar</a>
        </div>
    </body>
</html>
