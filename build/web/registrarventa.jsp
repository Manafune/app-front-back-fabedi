<%-- 
    Document   : test
    Created on : 11 ene. 2024, 13:13:41
    Author     : migue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <title>TEST</title>
        <link href="css/agregar.css" rel="stylesheet" type="text/css"/>
        
        <style>
            @media print{
                .parte01, .btn .accion{
                    display:none;
                }       
            }
        </style>
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
        <div class="text-center"><h1>Nueva Venta</h1></div>
        <div class="d-flex">
            <div class="col-sm-5 parte01">
                <div class="card">
                    <form action="Controlador?menu=NuevaVenta" method="POST">
                        <div class="card-body">

                             <div class="form-group">
                                <label>Datos Producto</label>
                            </div>
                            <div class="form-group d-flex mb-3">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="idproducto" value="${producto.getIdProducto()}" class="form-control" placeholder="Codigo">
                                    <button type="submit" name="accion" value="BuscarProducto" class="btn btn-outline-info">Buscar</button>
                                </div>
                                <div class="col-sm-6">
                                    <input type="text" name="nombreproducto" value="${producto.getProNombre()}" class="form-control" placeholder="Nombre Producto" readonly>
                                </div>
                            </div>
                            <div class="form-group d-flex mb-3">
                                <div class="col-sm-6 d-flex">
                                    <input type="text" name="preciounitario" value="${producto.getPrecioVenta()}" class="form-control" placeholder="S/0.0" readonly>
                                </div>
                                <div class="col-sm-3">
                                    <input type="number" name="cantidad" value="1" class="form-control" placeholder="Cantidad" min="0">
                                </div>
                                <div class="col-sm-3">
                                    <input type="text" name="stock"  value="${producto.getProStock()}" class="form-control" placeholder="Stock" readonly>
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="col-sm">
                                    <button type="submit" name="accion" value="AgregarProducto" class="btn btn-outline-info">Agregar Producto</button>
                                </div>
                            </div>
                        </div>
               </form>
            </div>
        </div>
                <div class="col-sm-7">
                    <div class="card">
                        <div class="card-body">
                            <div>
                                <div class="d-flex col-sm-5 ml-auto">
                                    <label>Nro.Serie:</label>
                                    <input type="text" name="NroSerie" value="${nserie}" class="form-control">
                                </div>
                                <br>
                                <table border="1">
                                    <thead class="table table-hover">
                                        <tr>
                                            <th>Nro</th>
                                            <th>CodigoP</th>
                                            <th>Producto</th>
                                            <th>Precio</th>
                                            <th>Cantidad</th>
                                            <th>SubTotal</th>
                                            <th>Acciones</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var ="list" items="${lista}">
                                            <tr>
                                                <td>${list.getItem()}</td>
                                                <td>${list.getIdProducto()}</td>
                                                <td>${list.getDescripcionP()}</td>
                                                <td>${list.getPrecio()}</td>
                                                <td>${list.getCantidad()}</td>
                                                <td>${list.getSubtotal()}</td>
                                                <td class="d-flex">
                                                    <a href="#" class="btn btn-warning">Editar</a>
                                                    <a href="#" class="btn btn-danger" style="margin-left: 10px">Borrar</a>
                                                </td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div>
                            <div class="card-footer d-flex">
                                <div class="col-sm-6">
                                    <a href="Controlador?menu=NuevaVenta&accion=GenerarVenta" class="btn btn-success">Generar Venta</a>
                                    <button type="submit" class="btn btn-danger">Cancelar Venta</button>
                                </div>
                                <div class="col-sm-3 ml-auto">
                                    <input type="text" name="total" value="S/. ${total}0" class="form-control" readonly>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.11.8/dist/umd/popper.min.js" integrity="sha384-I7E8VVD/ismYTF4hNIPjVp/Zjvgyol6VFvRkX/vR+Vc4jQkC+hVqc2pM8ODewa9r" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js" integrity="sha384-BBtl+eGJRgqQAUMxJ7pMwbEyER4l1g+O15P+16Ep7Q9Q+zqX6gSbd85u4mG4QzX+" crossorigin="anonymous"></script>

    </body>
</html>
