<%-- 
    Document   : editarproducto
    Created on : 14 ene. 2024, 12:30:18
    Author     : migue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="connection.Conexion, model.Producto, dao.ProductosDAO, java.util.*" %>
<%
int id = Integer.parseInt(request.getParameter("IdProducto"));
Producto pr = ProductosDAO.buscarporId(id);
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
            <h1>Editar Producto</h1>
            <% String IdProducto = request.getParameter("IdProducto");%>
            <form action="editarproducto.jsp" method="post">
                <input type="hidden" name="IdProducto" value="<%= pr.getIdProducto()%>">
                <label for="ProNombre">Nombre Producto</label>
                <input type="text" name="ProNombre" value="<%= pr.getProNombre()%>">
                <label for="ProStock">Stock Producto</label>
                <input type="number" name="ProStock" value="<%= pr.getProStock()%>">
                <label for="PrecioCompra">Precio Compra</label>
                <input type="number" name="PrecioCompra" value="<%= pr.getPrecioCompra()%>">
                <label for="PrecioVenta">Precio Venta</label>
                <input type="number" name="PrecioVenta" value="<%= pr.getPrecioVenta()%>">
                <label for="ProEstado">Estado</label>
                <input type="text" name="ProEstado" value="<%= pr.getProEstado()%>">
                <label for="ProEnvase">Envase</label>
                <input type="text" name="ProEnvase" value="<%= pr.getProEnvase()%>">
                <label for="Categoria">Categoria</label>
                <input type="text" name="Categoria" value="<%= pr.getCategoria()%>">
                <input type="submit" value="Actualizar">
            </form>   
        </div>
        <%
        if((request.getParameter("ProNombre")!=null)&(request.getParameter("ProStock")!=null)&(request.getParameter("PrecioCompra")!=null)&(request.getParameter("PrecioVenta")!=null)&(request.getParameter("ProEstado")!=null)&(request.getParameter("ProEnvase")!=null)&(request.getParameter("Categoria")!=null)){
                try{
                    pr.setProNombre(request.getParameter("ProNombre"));
                    pr.setProStock(Integer.parseInt(request.getParameter("ProStock")));
                    pr.setPrecioCompra(Float.parseFloat(request.getParameter("PrecioCompra")));
                    pr.setPrecioVenta(Float.parseFloat(request.getParameter("PrecioVenta")));
                    pr.setProEstado(request.getParameter("ProEstado"));
                    pr.setProEnvase(request.getParameter("ProEnvase"));
                    pr.setCategoria(request.getParameter("Categoria"));
                    try{
                        int i = ProductosDAO.actualizar(pr);
                        if(i>0){
                            response.sendRedirect("productos.jsp");
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
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
