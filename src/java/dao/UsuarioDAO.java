/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Usuario;
/**
 *
 * @author migue
 */
public class UsuarioDAO {
    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    
    public Usuario validar(String username, String contrasena){
        Usuario us= new Usuario();
        String sql = "select * from usuario where Username=? and Contrasena=?";
        try{
            con = cn.getConnection();
            ps= con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, contrasena);
            rs=ps.executeQuery();
            while(rs.next()){
                us.setIdUsuario(rs.getInt("IdUsuario"));
                us.setUsername(rs.getString("Username"));
                us.setContrasena(rs.getString("Contrasena"));
                us.setNombres(rs.getString("Nombres"));
                us.setApellidos(rs.getString("Apellidos"));
                us.setRol(rs.getString("Rol"));
            }
            System.out.println("Entre al DAO");
        }catch(Exception e){
            e.printStackTrace();
        }
        
        return us;
    }
    
    public static int guardar(Usuario us){
        int estado=0;
        try{
            Connection con= Conexion.getConnection();
            PreparedStatement ps=con.prepareStatement("insert into usuario(Username,Contrasena,Nombres,Apellidos,Rol,Estado) values(?,?,?,?,?,?)");
            ps.setString(1, us.getUsername());
            ps.setString(2, us.getContrasena());
            ps.setString(3, us.getNombres());
            ps.setString(4, us.getApellidos());
            ps.setString(5, us.getRol());
            ps.setInt(6, us.getEstado());
            estado = ps.executeUpdate();
            con.close();
        }catch(Exception e){System.out.println(e);}
        return estado;
    }
    
    public static int actualizar(Usuario us) {
        int estado = 0;
        try{
        Connection con = Conexion.getConnection();
        PreparedStatement ps = con.prepareStatement("update usuario set Username=?,Contrasena=?,Nombres=?,Apellidos=?,Rol=?,Estado=? where IdUsuario=?");
        ps.setString(1, us.getUsername());
        ps.setString(2, us.getContrasena());
        ps.setString(3, us.getNombres());
        ps.setString(4, us.getApellidos());
        ps.setString(5, us.getRol());
        ps.setInt(6, us.getEstado());
        ps.setInt(7, us.getIdUsuario());
        estado = ps.executeUpdate();
        con.close();
        }catch (Exception e){System.out.println(e);}
        return estado;
    }
    
    public static int eliminar(Usuario us){
        int estado=0;
        try{
        Connection con = Conexion.getConnection();
        PreparedStatement ps = con.prepareStatement("delete from usuario where IdUsuario=?");
        ps.setInt(1, us.getIdUsuario());
        estado = ps.executeUpdate();
        con.close();
        }catch (Exception e){System.out.println(e);}
        return estado;
    }
    
    public static int cambiarEstadoUsuario(int idUsuario, int nuevoEstado) {
    int estado = 0;
    try {
        Connection con = Conexion.getConnection();
        PreparedStatement ps = con.prepareStatement("update usuario set Estado=? where IdUsuario=?");
        ps.setInt(1, nuevoEstado);
        ps.setInt(2, idUsuario);
        estado = ps.executeUpdate();
        con.close();
    } catch (Exception e) {
        System.out.println(e);
    }
    return estado;
    }
        public static int eliminarxid(int idUsuario) {
        int estado = 0;
        try {
            Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement("delete from usuario where IdUsuario=?");
            ps.setInt(1, idUsuario);
            estado = ps.executeUpdate();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        return estado;
    }
    
    public static List<Usuario> listarusuarios(){
        System.out.println("Ingreso al metodo");
        List<Usuario> list = new ArrayList<Usuario>();
        try{
        Connection con = Conexion.getConnection();
        PreparedStatement ps = con.prepareStatement("select IdUsuario,Username,Contrasena,Nombres,Apellidos,Rol,Estado from usuario");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Usuario us = new Usuario();
            us.setIdUsuario(rs.getInt("IdUsuario"));
            us.setUsername(rs.getString("Username"));
            us.setContrasena(rs.getString("Contrasena"));
            us.setNombres(rs.getString("Nombres"));
            us.setApellidos(rs.getString("Apellidos"));
            us.setRol(rs.getString("Rol"));
            us.setEstado(rs.getInt("Estado"));
            list.add(us);
            
        }
        System.out.println("Salio del metodo");
        con.close();
        }catch (Exception e){System.out.println(e);}
        return list;
        
    }
    
    public static Usuario buscarporId(int IdUsuario){
        Usuario us=null;
        try{
            Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement("select IdUsuario,Username,Contrasena,Nombres,Apellidos,Rol,Estado from usuario where IdUsuario=?");
            ps.setInt(1, IdUsuario);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                us = new Usuario();
                us.setIdUsuario(rs.getInt("IdUsuario"));
                us.setUsername(rs.getString("Username"));
                us.setContrasena(rs.getString("Contrasena"));
                us.setNombres(rs.getString("Nombres"));
                us.setApellidos(rs.getString("Apellidos"));
                us.setRol(rs.getString("Rol"));
                us.setEstado(rs.getInt("Estado"));
            }
            con.close();
        }catch (Exception e){System.out.println(e);}
        return us;
    }
    
}