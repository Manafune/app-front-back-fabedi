/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author migue
 */
public class DetalleVenta {
    int IdDetalleVentas,IdVentas,IdProducto,Cantidad,item;
    double Precio,subtotal;
    String DescripcionP;

    public int getIdDetalleVentas() {
        return IdDetalleVentas;
    }

    public void setIdDetalleVentas(int IdDetalleVentas) {
        this.IdDetalleVentas = IdDetalleVentas;
    }

    public int getIdVentas() {
        return IdVentas;
    }

    public void setIdVentas(int IdVentas) {
        this.IdVentas = IdVentas;
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }

    

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public String getDescripcionP() {
        return DescripcionP;
    }

    public void setDescripcionP(String DescripcionP) {
        this.DescripcionP = DescripcionP;
    }

    @Override
    public String toString() {
        return "DetalleVenta{" + "IdDetalleVentas=" + IdDetalleVentas + ", IdVentas=" + IdVentas + ", IdProducto=" + IdProducto + ", Cantidad=" + Cantidad + ", item=" + item + ", Precio=" + Precio + ", subtotal=" + subtotal + ", DescripcionP=" + DescripcionP + '}';
    }

    
}