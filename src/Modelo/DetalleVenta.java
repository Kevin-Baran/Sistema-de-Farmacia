
package Modelo;

/**
 *
 * @author Kevin
 */
public class DetalleVenta {
    int Numero_factura;
    int Cod_detalle_factura;
    int Cod_medicamento;
    int Cantidad;
    Double Precio;

    public DetalleVenta() {
    }

    public DetalleVenta(int Numero_factura, int Cod_detalle_factura, int Cod_medicamento, int Cantidad, Double Precio) {
        this.Numero_factura = Numero_factura;
        this.Cod_detalle_factura = Cod_detalle_factura;
        this.Cod_medicamento = Cod_medicamento;
        this.Cantidad = Cantidad;
        this.Precio = Precio;
    }

    public int getNumero_factura() {
        return Numero_factura;
    }

    public void setNumero_factura(int Numero_factura) {
        this.Numero_factura = Numero_factura;
    }

    public int getCod_detalle_factura() {
        return Cod_detalle_factura;
    }

    public void setCod_detalle_factura(int Cod_detalle_factura) {
        this.Cod_detalle_factura = Cod_detalle_factura;
    }

    public int getCod_medicamento() {
        return Cod_medicamento;
    }

    public void setCod_medicamento(int Cod_medicamento) {
        this.Cod_medicamento = Cod_medicamento;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double Precio) {
        this.Precio = Precio;
    }
    
    
}
