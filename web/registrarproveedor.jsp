<%-- 
    Document   : registrarproveedor
    Created on : 11 ene. 2024, 11:22:36
    Author     : migue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="prov" class="model.Proveedor" />
<%@page import="dao.ProveedorDAO"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registro de Proveedor</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <link rel="stylesheet" href="css/forms.css"/>
    </head>
    <body>
        <%
        if((request.getParameter("RUC")!=null)&(request.getParameter("RazonSocial")!=null)&(request.getParameter("Telefono")!=null)&(request.getParameter("Direccion")!=null)&(request.getParameter("ProvEstado")!=null)){
            try{
            prov.setRUC(request.getParameter("RUC"));
            prov.setRazonSocial(request.getParameter("RazonSocial"));
            prov.setTelefono(request.getParameter("Telefono"));
            prov.setDireccion(request.getParameter("Direccion"));
            prov.setProvEstado(request.getParameter("ProvEstado"));
            /*Enviar datos a la tabla; Invocacion a la clase DAO y al metodo guardar*/
            int i = ProveedorDAO.guardar(prov);
            }
            catch(Exception e){System.out.println(e);}         
            }
        %>
        <div class="container">
          <h2>Registro Agregado exitosamente</h2>
          <a href="proveedores.jsp">Regresar</a>
        </div>
    </body>
</html>
