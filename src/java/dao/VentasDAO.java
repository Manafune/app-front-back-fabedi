/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.DetalleVenta;
import model.Ventas;

/**
 *
 * @author migue
 */
public class VentasDAO {
    public static int guardar(Ventas ve){
        int estado=0;
        try {
            Connection con = Conexion.getConnection();
            Date fechaActual = new Date();
            //Trasformar Fecha
            Timestamp fechaSQL = new Timestamp(fechaActual.getTime());
            PreparedStatement ps = con.prepareStatement("insert into ventas(IdUsuario,NumeroSerie,FechaVentas,Monto) values(?,?,?,?)");
            ps.setInt(1, ve.getIdUsuario());
            ps.setString(2, ve.getNumeroSerie());
            ps.setTimestamp(3, fechaSQL);
            ps.setDouble(4, ve.getMonto());
            estado= ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return estado;
    }
    
    public static int actualizar(Ventas ve){
        int estado=0;
        try {
            Connection con = Conexion.getConnection();
            Date fechaActual = new Date();
            Timestamp fechaSQL = new Timestamp(fechaActual.getTime());
            PreparedStatement ps = con.prepareStatement("update ventas set IdUsuario=?,NumeroSerie=?,FechaVentas=?,Monto=? where IdVentas=?");
            ps.setInt(1, ve.getIdUsuario());
            ps.setString(2, ve.getNumeroSerie());
            //Trasformar Fecha
            
            ps.setTimestamp(3, fechaSQL);
            ps.setDouble(4, ve.getMonto());
            ps.setInt(5, ve.getIdVentas());
            estado= ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return estado;
    }
    
    public static int eliminar(Ventas ve){
        int estado=0;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from ventas where IdVentas=?");
            ps.setInt(1, ve.getIdVentas());
            estado = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return estado;
    }
    
    public static List<Ventas> listarventas(){
        System.out.println("Ingreso en el metodo listar");
        List<Ventas> list = new ArrayList<Ventas>();
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement("select IdVentas,IdUsuario,NumeroSerie,FechaVentas,Monto from ventas");
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                Ventas ve = new Ventas();
                ve.setIdVentas(rs.getInt("IdVentas"));
                ve.setIdUsuario(rs.getInt("IdUsuario"));
                ve.setNumeroSerie(rs.getString("NumeroSerie"));
                ve.setFecha(rs.getTimestamp("FechaVentas"));
                ve.setMonto(rs.getDouble("Monto"));
                list.add(ve);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return list;
    }
    
    public static Ventas buscarporId(int IdVentas){
        Ventas ve=null;
        try{
            Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement("select IdVentas,IdUsuario,NumeroSerie,FechaVenta,Monto from ventas where IdVentas=?");
            ps.setInt(1, IdVentas);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                ve = new Ventas();
                ve.setIdVentas(rs.getInt("IdVentas"));
                ve.setIdUsuario(rs.getInt("IdUsuario"));
                ve.setNumeroSerie(rs.getString("NumeroSerie"));
                ve.setFecha(rs.getTimestamp("Fecha"));
                ve.setMonto(rs.getDouble("Monto"));
            }
            con.close();
        }catch (Exception e){System.out.println(e);}
        return ve;
    }
    
    
    public String GenerarSerie(){
        String numeroserie="";
        String sql="select max(NumeroSerie) from ventas";
        try{
            Connection con = Conexion.getConnection();
            PreparedStatement ps =con.prepareStatement(sql);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                numeroserie=rs.getString(1);               
            }
        }catch(Exception e){
        
        }
        return numeroserie;
    }
    
    public String IdVentas(){
    String idventas="";
    String sql="select max(IdVentas) from ventas";
    try{
        Connection con = Conexion.getConnection();
        PreparedStatement ps =con.prepareStatement(sql);
        ResultSet rs=ps.executeQuery();
        while(rs.next()){
            idventas=rs.getString(1);
        }
    }catch(Exception e){
    }
    return idventas;
    }
    
    public int guardarDetalleVentas(DetalleVenta detalleventa) {
        String sql = "INSERT INTO detalleventa(IdVentas, IdProducto, Precio, Cantidad) VALUES(?,?,?,?)";
        int estado = 0;

        try {
            Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            // Configurar los parámetros después de crear el PreparedStatement
            ps.setInt(1, detalleventa.getIdVentas());
            ps.setInt(2, detalleventa.getIdProducto());
            ps.setDouble(3, detalleventa.getPrecio());
            ps.setInt(4, detalleventa.getCantidad());

            // Usar executeUpdate() para una inserción
            estado = ps.executeUpdate();

            con.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return estado;
    }
}
