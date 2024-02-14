<%-- 
    Document   : ventas
    Created on : 11 ene. 2024, 10:05:05
    Author     : migue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="connection.*, model.Ventas, dao.VentasDAO, java.util.*"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
        <title>Ventas</title>
    </head>
    <body>
        <nav class="navbar navbar-expand-lg navbar-light bg-info">
            <div class="container ml-auto mr-auto">
                <div class="collapse navbar-collapse" id="navbarNav">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a style="border:none" class="btn btn-outline-light m-1" href="Principal.jsp">Inicio</a>
                        </li>
                        <li class="nav-item">
                            <a style="border:none" class="btn btn-outline-light m-1" href="Controlador?menu=Usuario" target="myFrame">Usuarios</a>
                        </li>
                        <li class="nav-item">
                            <a style="border:none" class="btn btn-outline-light m-1" href="Controlador?menu=Producto" target="myFrame">Productos</a>
                        </li>
                        <li class="nav-item">
                            <a style="border:none" class="btn btn-outline-light m-1" href="Controlador?menu=Proveedor" target="myFrame">Proveedores</a>
                        </li>
                        <li class="nav-item active">
                            <a style="border:none" class="btn btn-outline-light  active m-1" href="Controlador?menu=Venta" target="myFrame">Ventas</a>
                        </li>
                    </ul>
                </div>
                <div class="dropdown">
                    <button style="border:none" class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton1" data-bs-toggle="dropdown" aria-expanded="false">
                        ${usuario.getNombres()}
                    </button>
                    <div class="dropdown-menu text-center" aria-labelledby="dropdownMenuButton1">
                        <a class="dropdown-item" href="#">
                            <img src="img/avatar-de-perfil.png" alt="60" width="60"/>
                        </a>
                        <a class="dropdown-item">${usuario.getUsername()}</a>
                        <a class="dropdown-item">${usuario.getNombres()} ${usuario.getApellidos()}</a>
                        <div class="dropdown-divider"></div>
                        <form action="Validar" method="POST">
                            <button name="accion" value="Salir" class="dropdown-item">Salir</button>
                        </form>
                    </div>
                </div>
            </div>
        </nav>
    <%
    List<Ventas> miLista = VentasDAO.listarventas();
    request.setAttribute("list",miLista);
    %>
        <div id="content">
            <section class="p-5">
                <a href="Controlador?menu=NuevaVenta" class="btn btn-primary btn-lg rounded-pill shadow-sm"><span class="fw-bold">RegistrarVenta</span></a> 
            </section>
            <div class="container mt-5">
                <h2>Ventas Registradas</h2>
                <table id="Usuarios" class="table table-bordered table-striped">
                    <thead>
                        <tr>
                            <th>IdVenta</th>
                            <th>IdUsuario</th>
                            <th>Numero de Serie</th>
                            <th>Fecha</th>
                            <th>Monto</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${list}" var="ve">
                            <tr>
                                <td>${ve.getIdVentas()}</td>
                                <td>${ve.getIdUsuario()}</td>
                                <td>${ve.getNumeroSerie()}</td>
                                <td>${ve.getFecha()}</td>
                                <td>${ve.getMonto()}</td>
                                <td>
                                    <a href="editarventa.jsp?IdVentas=${ve.getIdVentas()}" class="btn btn-primary m-1">Editar</a>
                                    <a href="eliminarventao.jsp?IdVentas=${ve.getIdVentas()}" class="btn btn-danger m-1" onclick="return confirm('¿Estás seguro de eliminar este empleado?')">Eliminar</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>

    </body>
</html>
