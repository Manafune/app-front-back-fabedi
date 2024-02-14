/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package connection;

import java.sql.*;

/**
 *
 * @author migue
 */
public class Conexion {
    public static Connection getConnection(){
    Connection cn = null;
    try{
    Class.forName("com.mysql.cj.jdbc.Driver");
    cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bodega_fabedi?autoReconnect=true&useSSL=false","root","123456");
    }
    catch(Exception e)
    {System.out.println(e);}
    return cn;
    }
}
