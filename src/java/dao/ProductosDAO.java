/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import model.Producto;

/**
 *
 * @author migue
 */
public class ProductosDAO {
    int r;
    public static int guardar(Producto prod){
        int estado=0;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement("insert into producto(ProNombre,ProStock,PrecioCompra,PrecioVenta,ProEstado,ProEnvase,Categoria) values(?,?,?,?,?,?,?)");
            ps.setString(1, prod.getProNombre());
            ps.setInt(2, prod.getProStock());
            ps.setDouble(3, prod.getPrecioCompra());
            ps.setDouble(4, prod.getPrecioVenta());
            ps.setString(5, prod.getProEstado());
            ps.setString(6, prod.getProEnvase());
            ps.setString(7, prod.getCategoria());
            estado = ps.executeUpdate();
            con.close();
        } catch (Exception e) {System.err.println(e);}
        return estado;
    }
    
    public static int actualizar(Producto prod){
        int estado=0;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement("update producto set ProNombre=?,ProStock=?,PrecioCompra=?,PrecioVenta=?,ProEstado=?,ProEnvase=?,Categoria=? where IdProducto=?");
            ps.setString(1, prod.getProNombre());
            ps.setInt(2, prod.getProStock());
            ps.setDouble(3, prod.getPrecioCompra());
            ps.setDouble(4, prod.getPrecioVenta());
            ps.setString(5, prod.getProEstado());
            ps.setString(6, prod.getProEnvase());
            ps.setString(7, prod.getCategoria());
            ps.setInt(8, prod.getIdProducto());
            estado = ps.executeUpdate();
            con.close();
        } catch (Exception e){System.err.println(e);}
        return estado;
    }
    
    public static int eliminarxid(int idProducto) {
        int estado = 0;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from producto where IdProducto=?");
            ps.setInt(1, idProducto);
            estado = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return estado;
    }   
    
    public static int eliminar(Producto prod){
        System.out.println("Entro a eliminar producto");
        int estado=0;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from producto where IdProducto=?");
            ps.setInt(1, prod.getIdProducto());
            estado = ps.executeUpdate();
            con.close();
            System.out.println("Producto eliminado correctamente");
        } catch (Exception e){
            System.err.println("Error al eliminar producto: " + e.getMessage());}
        return estado;
    }
    
    public static int cambiarEstadoProducto(int idProducto, int nuevoEstado) {
        int estado = 0;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement("update producto set ProEstado=? where IdProducto=?");
            ps.setInt(1, nuevoEstado);
            ps.setInt(2, idProducto);
            estado = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.err.println(e);
        }
        return estado;
    }
    
    public static List<Producto> listarProductos(){
        System.out.println("Ingresaste en el metodo listar");
        List<Producto> list = new ArrayList<Producto>();
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement("select IdProducto,ProNombre,ProStock,PrecioCompra,PrecioVenta,ProEstado,proEnvase,Categoria from producto");
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Producto prod = new Producto();
                prod.setIdProducto(rs.getInt("IdProducto"));
                prod.setProNombre(rs.getString("ProNombre"));
                prod.setProStock(rs.getInt("ProStock"));
                prod.setPrecioCompra(rs.getDouble("PrecioCompra"));
                prod.setPrecioVenta(rs.getDouble("PrecioVenta"));
                prod.setProEstado(rs.getString("ProEstado"));
                prod.setProEnvase(rs.getString("ProEnvase"));
                prod.setCategoria(rs.getString("Categoria"));
                list.add(prod);
            }
            System.out.println("Saliste del metodo listar");
            con.close();
        } catch (Exception e){System.err.println(e);}
        return list;
    }
    
    public static Producto buscarporId(int IdProducto){
        Producto prod=null;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement("select IdProducto,ProNombre,ProStock,PrecioCompra,PrecioVenta,ProEstado,proEnvase,Categoria from producto where IdProducto=?");
            ps.setInt(1, IdProducto);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                prod = new Producto();
                prod.setIdProducto(rs.getInt("IdProducto"));
                prod.setProNombre(rs.getString("ProNombre"));
                prod.setProStock(rs.getInt("ProStock"));
                prod.setPrecioCompra(rs.getDouble("PrecioCompra"));
                prod.setPrecioVenta(rs.getDouble("PrecioVenta"));
                prod.setProEstado(rs.getString("ProEstado"));
                prod.setProEnvase(rs.getString("ProEnvase"));
                prod.setCategoria(rs.getString("Categoria"));
            }
            con.close();
        } catch (Exception e){System.err.println(e);}
        return prod;
    }
    
   /* public Productos buscar(int id){
        Productos p = new Productos();
        String sql="select * from producto where IdProducto="+id;
        try{
            Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                p.setIdProducto(rs.getInt(1));
                p.setProNombre(rs.getString(2));
                p.setProStock(rs.getInt(3));
                p.setPrecioCompra(rs.getDouble(4));
                p.setPrecioVenta(rs.getDouble(5));
                p.setProEstado(rs.getString(6));
                p.setProEnvase(rs.getString(7));
                p.setCategoria(rs.getString(8));
            }
        }catch(Exception e){
            System.err.println(e);
        }
        return p;
    }*/
    
    public int actualizarstock(int idproducto, int stock){
        String sql = "update producto set ProStock=? where IdProducto=?";
        
        try{
            Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, stock);
            ps.setInt(2, idproducto);
            ps.executeUpdate();
          
        }catch(Exception e){
            System.err.println(e);
        }
        return r;
    }
}
