/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author migue
 */
public class Producto {
 int IdProducto, ProStock;
 String ProNombre, ProEstado, ProEnvase, Categoria;
 double PrecioCompra, PrecioVenta;

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public int getProStock() {
        return ProStock;
    }

    public void setProStock(int ProStock) {
        this.ProStock = ProStock;
    }

    public String getProNombre() {
        return ProNombre;
    }

    public void setProNombre(String ProNombre) {
        this.ProNombre = ProNombre;
    }

    public String getProEstado() {
        return ProEstado;
    }

    public void setProEstado(String ProEstado) {
        this.ProEstado = ProEstado;
    }

    public String getProEnvase() {
        return ProEnvase;
    }

    public void setProEnvase(String ProEnvase) {
        this.ProEnvase = ProEnvase;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

    public double getPrecioCompra() {
        return PrecioCompra;
    }

    public void setPrecioCompra(double PrecioCompra) {
        this.PrecioCompra = PrecioCompra;
    }

    public double getPrecioVenta() {
        return PrecioVenta;
    }

    public void setPrecioVenta(double PrecioVenta) {
        this.PrecioVenta = PrecioVenta;
    }

 
}
