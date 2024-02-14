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
import model.Proveedor;

/**
 *
 * @author migue
 */
public class ProveedorDAO {
    public static int guardar(Proveedor prov){
        int estado=0;
        try{
            Connection con= Conexion.getConnection();
            PreparedStatement ps=con.prepareStatement("insert into proveedor(RUC,RazonSocial,Telefono,Direccion,ProvEstado) values(?,?,?,?,?)");
            ps.setString(1, prov.getRUC());
            ps.setString(2,prov.getRazonSocial());
            ps.setString(3, prov.getTelefono());
            ps.setString(4, prov.getDireccion());
            ps.setString(5, prov.getProvEstado());
            estado = ps.executeUpdate();
            con.close();
        }catch(Exception e){System.out.println(e);}
        return estado;
    }
    
    public static int actualizar(Proveedor prov) {
        int estado = 0;
        try{
        Connection con = Conexion.getConnection();
        PreparedStatement ps = con.prepareStatement("update proveedor set RazonSocial=?,Telefono=?,Direccion=?,ProvEstado=? where RUC=?");
        ps.setString(1, prov.getRazonSocial());
        ps.setString(2, prov.getTelefono());
        ps.setString(3,prov.getDireccion());
        ps.setString(4,prov.getProvEstado());
        ps.setString(5, prov.getRUC());
        estado = ps.executeUpdate();
        con.close();
        }catch (Exception e){System.out.println(e);}
        return estado;
    }
    
    public static int eliminar(Proveedor prov){
        int estado=0;
        try{
        Connection con = Conexion.getConnection();
        PreparedStatement ps = con.prepareStatement("delete from proveedor where RUC=?");
        ps.setString(1, prov.getRUC());
        estado = ps.executeUpdate();
        con.close();
        }catch (Exception e){System.out.println(e);}
        return estado;
    }
    
    public static List<Proveedor> listarproveedores(){
        System.out.println("Ingreso al metodo");
        List<Proveedor> list = new ArrayList<Proveedor>();
        try{
        Connection con = Conexion.getConnection();
        PreparedStatement ps = con.prepareStatement("select RUC,RazonSocial,Telefono,Direccion,ProvEstado from proveedor");
        ResultSet rs = ps.executeQuery();
        while(rs.next()){
            Proveedor prov = new Proveedor();
            prov.setRUC(rs.getString("RUC"));
            prov.setRazonSocial(rs.getString("RazonSocial"));
            prov.setTelefono(rs.getString("Telefono"));
            prov.setDireccion(rs.getString("Direccion"));
            prov.setProvEstado(rs.getString("ProvEstado"));
            list.add(prov);
            
        }
        System.out.println("Salio del metodo");
        con.close();
        }catch (Exception e){System.out.println(e);}
        return list;
        
    }
    
    public static Proveedor buscarporId(String idproveedor){
        Proveedor prov=null;
        try{
            Connection con = Conexion.getConnection();
            PreparedStatement ps = con.prepareStatement("select RUC,RazonSocial,Telefono,Direccion,ProvEstado from proveedor where RUC=?");
            ps.setString(1, idproveedor);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                prov = new Proveedor();
                prov.setRUC(rs.getString("RUC"));
                prov.setRazonSocial(rs.getString("RazonSocial"));
                prov.setTelefono(rs.getString("Telefono"));
                prov.setDireccion(rs.getString("Direccion"));
                prov.setProvEstado(rs.getString("ProvEstado"));
            }
            con.close();
        }catch (Exception e){System.out.println(e);}
        return prov;
    }
}
