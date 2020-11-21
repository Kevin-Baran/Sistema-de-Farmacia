/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Kevin
 */
public class Medicamento {
    int Cod_medicamento;
    String Nombre;
    int Stock;
    Double Precio;
    int Unidades_vendidas;
    int Cod_laboratorio;
    int Cod_tipo_medicamento;
    int Cod_presentacion;

    public Medicamento() {
    }

    public Medicamento(int Cod_medicamento, String Nombre, int Stock, Double Precio, int Unidades_vendidas, int Cod_laboratorio, int Cod_tipo_medicamento, int Cod_presentacion) {
        this.Cod_medicamento = Cod_medicamento;
        this.Nombre = Nombre;
        this.Stock = Stock;
        this.Precio = Precio;
        this.Unidades_vendidas = Unidades_vendidas;
        this.Cod_laboratorio = Cod_laboratorio;
        this.Cod_tipo_medicamento = Cod_tipo_medicamento;
        this.Cod_presentacion = Cod_presentacion;
    }

    public int getCod_medicamento() {
        return Cod_medicamento;
    }

    public void setCod_medicamento(int Cod_medicamento) {
        this.Cod_medicamento = Cod_medicamento;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getStock() {
        return Stock;
    }

    public void setStock(int Stock) {
        this.Stock = Stock;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double Precio) {
        this.Precio = Precio;
    }

    public int getUnidades_vendidas() {
        return Unidades_vendidas;
    }

    public void setUnidades_vendidas(int Unidades_vendidas) {
        this.Unidades_vendidas = Unidades_vendidas;
    }

    public int getCod_laboratorio() {
        return Cod_laboratorio;
    }

    public void setCod_laboratorio(int Cod_laboratorio) {
        this.Cod_laboratorio = Cod_laboratorio;
    }

    public int getCod_tipo_medicamento() {
        return Cod_tipo_medicamento;
    }

    public void setCod_tipo_medicamento(int Cod_tipo_medicamento) {
        this.Cod_tipo_medicamento = Cod_tipo_medicamento;
    }

    public int getCod_presentacion() {
        return Cod_presentacion;
    }

    public void setCod_presentacion(int Cod_presentacion) {
        this.Cod_presentacion = Cod_presentacion;
    }
    
    
}
