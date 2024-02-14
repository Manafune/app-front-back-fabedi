/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package controlador;

import dao.ProductosDAO;
import dao.UsuarioDAO;
import dao.VentasDAO;
import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import model.DetalleVenta;
import model.GenerarSerie;
import model.Producto;
import model.Usuario;
import model.Ventas;

/**
 *
 * @author migue
 */
@WebServlet(name = "Controlador", urlPatterns = {"/Controlador"})
public class Controlador extends HttpServlet {
    Usuario us = new Usuario();
    Producto p = new Producto();
    ProductosDAO pdao = new ProductosDAO();
    Ventas v = new Ventas();
    DetalleVenta de = new DetalleVenta();
    List<DetalleVenta> lista = new ArrayList<>();
    double total;
    String numeroserie;
    VentasDAO vdao= new VentasDAO();
    int item;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            String menu = request.getParameter("menu");
            String accion = request.getParameter("accion");
            
            if(menu.equals("Principal")){
                    request.getRequestDispatcher("Principal.jsp").forward(request, response);
            }
            if(menu.equals("Producto")){    
                    request.getRequestDispatcher("productos.jsp").forward(request, response);
            }
            if(menu.equals("Usuario")){     
                    request.getRequestDispatcher("usuarios.jsp").forward(request, response);
            }
            if(menu.equals("Proveedor")){    
                    request.getRequestDispatcher("proveedores.jsp").forward(request, response);
            }
            if(menu.equals("Venta")){   
                    request.getRequestDispatcher("ventas.jsp").forward(request, response);
            }
            if(menu.equals("NuevaVenta")) {
                System.out.println("Ingreso a la venta");
                if(accion!=null){ 
                        if(accion.equals("BuscarProducto")){
                            System.out.println("Ingreso a la buscar");
                            int id=Integer.parseInt(request.getParameter("idproducto"));
                            p=pdao.buscarporId(id);
                            request.setAttribute("producto", p);
                            request.setAttribute("lista",lista);
                            request.setAttribute("total",total);
                   
                        }
                        if(accion.equals("AgregarProducto")){
                            System.out.println("Ingreso a agregar");
                            total=0.0;
                            item = lista.size()+1;
                            int cod = p.getIdProducto();
                            String descripcion= request.getParameter("nombreproducto");
                            double precio=Double.parseDouble(request.getParameter("preciounitario"));
                            int cant = Integer.parseInt(request.getParameter("cantidad"));
                            double subtotal = precio*cant;
                            System.out.println(subtotal);
                            de = new DetalleVenta();
                            de.setItem(item);
                            de.setIdProducto(cod);
                            de.setDescripcionP(descripcion);
                            de.setPrecio(precio);
                            de.setCantidad(cant);
                            de.setSubtotal(subtotal);
                            lista.add(de);

                            for(int i=0; i<lista.size();i++){
                                total = total + lista.get(i).getSubtotal();
                            }
                            request.setAttribute("total",total);
                            request.setAttribute("lista",lista);
                        }
                        
                        switch (accion){
                            case "GenerarVenta":
                                /*for(int i= 0; i< lista.size(); i++){
                                    Producto pr = new Producto();
                                    int cantidad = lista.get(i).getCantidad();
                                    int idproducto=lista.get(i).getIdProducto();
                                    pr=pdao.buscarporId(idproducto);
                                    int sac= pr.getProStock()-cantidad;
                                    pdao.actualizarstock(idproducto, sac);
                                }
                                int idus = (int) request.getSession().getAttribute("idUsuario"); 
                                v.setIdUsuario(idus);
                                v.setNumeroSerie(numeroserie);
                                v.setMonto(total);
                                vdao.guardar(v);

                                int idv = Integer.parseInt(vdao.IdVentas());
                                for(int i=0; i< lista.size(); i++){
                                    de =new DetalleVenta();
                                    de.setIdVentas(idv);
                                    de.setIdProducto(lista.get(i).getIdProducto());
                                    de.setPrecio(lista.get(i).getPrecio());
                                    de.setCantidad(lista.get(i).getCantidad());
                                    vdao.guardarDetalleVentas(de);
                                }
                                
                                
                                v = new Ventas();
                                lista = new ArrayList<>();
                                total = 0.0;*/
                                if (total > 0.0) {
                                    for (int i = 0; i < lista.size(); i++) {
                                        Producto pr = new Producto();
                                        int cantidad = lista.get(i).getCantidad();
                                        int idproducto = lista.get(i).getIdProducto();
                                        pr = pdao.buscarporId(idproducto);
                                        int sac = pr.getProStock() - cantidad;
                                        pdao.actualizarstock(idproducto, sac);
                                    }

                                    int idus = (int) request.getSession().getAttribute("idUsuario");
                                    v.setIdUsuario(idus);
                                    v.setNumeroSerie(numeroserie);
                                    v.setMonto(total);
                                    vdao.guardar(v);

                                    int idv = Integer.parseInt(vdao.IdVentas());
                                    for (int i = 0; i < lista.size(); i++) {
                                        de = new DetalleVenta();
                                        de.setIdVentas(idv);
                                        de.setIdProducto(lista.get(i).getIdProducto());
                                        de.setPrecio(lista.get(i).getPrecio());
                                        de.setCantidad(lista.get(i).getCantidad());
                                        vdao.guardarDetalleVentas(de);
                                    }

                                    v = new Ventas();
                                    lista = new ArrayList<>();
                                    total = 0.0;
                                } else{
                                    System.out.println("Error: El total debe ser mayor a 0 para generar la venta.");
                                }
                                break;
                            case "CancelarVenta":
                                lista = new ArrayList<>(); // Limpiar la lista de productos
                                total = 0.0; // Restablecer el total a cero
                                // Redirigir de nuevo a la página de registrar venta
                                request.getRequestDispatcher("registrarventa.jsp").forward(request, response);
                                break;
                            default:
                                System.out.println("default");
                                numeroserie = vdao.GenerarSerie();
                                if(numeroserie==null){
                                    numeroserie="00000001";
                                    request.setAttribute("nserie", numeroserie);
                                }
                                else{
                                    int incrementar = Integer.parseInt(numeroserie);
                                    GenerarSerie gs= new GenerarSerie();
                                    numeroserie= gs.NumeroSerie(incrementar);
                                    request.setAttribute("nserie", numeroserie);
                                }
                                request.getRequestDispatcher("registrarventa.jsp").forward(request, response);
                                
                        }
                        /*if(accion.equals("GenerarVenta")){
                            for(int i= 0; i< lista.size(); i++){
                                Productos pr = new Productos();
                                int cantidad = lista.get(i).getCantidad();
                                int idproducto=lista.get(i).getIdProducto();
                                pr=pdao.buscarporId(idproducto);
                                int sac= pr.getProStock()-cantidad;
                                pdao.actualizarstock(idproducto, sac);
                            }

                            v.setIdUsuario(1);
                            v.setNumeroSerie(numeroserie);
                            v.setMonto(total);
                            vdao.guardar(v);

                            int idv = Integer.parseInt(vdao.IdVentas());
                            for(int i=0; i< lista.size(); i++){
                                de =new DetalleVenta();
                                de.setIdVentas(idv);
                                de.setIdProducto(lista.get(i).getIdProducto());
                                de.setPrecio(lista.get(i).getPrecio());
                                de.setCantidad(lista.get(i).getCantidad());
                                vdao.guardarDetalleVentas(de);
                            }
                        }*/    
 
                    }
                /*numeroserie = vdao.GenerarSerie();
                if(numeroserie==null){
                    numeroserie="00000001";
                    request.setAttribute("nserie", numeroserie);
                }
                else{
                    int incrementar = Integer.parseInt(numeroserie);
                    GenerarSerie gs= new GenerarSerie();
                    numeroserie= gs.NumeroSerie(incrementar);
                    request.setAttribute("nserie", numeroserie);
                }*/
                    
                request.getRequestDispatcher("registrarventa.jsp").forward(request,response);
                }
                
            }

        
    

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
