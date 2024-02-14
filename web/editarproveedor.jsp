<%-- 
    Document   : editarproveedor
    Created on : 14 ene. 2024, 14:57:31
    Author     : migue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="connection.Conexion, model.Proveedor, dao.ProveedorDAO, java.util.*" %>
<%
String id = request.getParameter("RUC");
Proveedor pv = ProveedorDAO.buscarporId(id);
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
            <h1>Editar Proveedor</h1>
            <% String RUC = request.getParameter("RUC");%>
            <form action="editarproveedor.jsp" method="post">
                <label for="nombre">RUC:</label>
                <input type="text" name="RUC" value="<%=pv.getRUC()%>" maxlength="11">
                <label for="nombre">Razon Social:</label>
                <input type="text" name="RazonSocial" value="<%=pv.getRazonSocial()%>">
                <label for="apellido">Telefono:</label>
                <input type="text" name="Telefono" value="<%=pv.getTelefono()%>" maxlength="9">
                <label for="dni">Direccion:</label>
                <input type="text" name="Direccion" value="<%=pv.getDireccion()%>">
                <label for="dni">Estado:</label>
                <input type="text" name="ProvEstado" value="<%=pv.getProvEstado()%>">
                <input type="submit" value="Actualizar">
            </form>
        </div>
        <%
            if((request.getParameter("RUC")!=null)&(request.getParameter("RazonSocial")!=null)&(request.getParameter("Telefono")!=null)&(request.getParameter("Direccion")!=null)&(request.getParameter("ProvEstado")!=null)){
                try{
                    pv.setRUC(request.getParameter("RUC"));
                    pv.setRazonSocial(request.getParameter("RazonSocial"));
                    pv.setTelefono(request.getParameter("Telefono"));
                    pv.setDireccion(request.getParameter("Direccion"));
                    pv.setProvEstado(request.getParameter("ProvEstado"));
                    try{
                        int i = ProveedorDAO.actualizar(pv);
                        if(i>0){
                            response.sendRedirect("proveedores.jsp");
                        }else{
                            %>
                            <p style="color:red" class="p-5"><%="Error al intentar actualizar"%></p>
                            <%
                            }
                    }catch(Exception e){
                        System.out.println(e);
                    }
                }
                catch(Exception e){System.out.println(e);}         
            }
            %>
        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.1/dist/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </body>
</html>
