
package Modelo;

/**
 *
 * @author Kevin
 */
public class Venta {
    int Numero_factura;
    int Cod_empleado;
    String Fecha;
    Double Monto;
    String Estado;

    public Venta() {
    }

    public Venta(int Numero_factura, int Cod_empleado, String Fecha, Double Monto, String Estado) {
        this.Numero_factura = Numero_factura;
        this.Cod_empleado = Cod_empleado;
        this.Fecha = Fecha;
        this.Monto = Monto;
        this.Estado = Estado;
    }

    public int getNumero_factura() {
        return Numero_factura;
    }

    public void setNumero_factura(int Numero_factura) {
        this.Numero_factura = Numero_factura;
    }

    public int getCod_empleado() {
        return Cod_empleado;
    }

    public void setCod_empleado(int Cod_empleado) {
        this.Cod_empleado = Cod_empleado;
    }

    public String getFecha() {
        return Fecha;
    }

    public void setFecha(String Fecha) {
        this.Fecha = Fecha;
    }

    public Double getMonto() {
        return Monto;
    }

    public void setMonto(Double Monto) {
        this.Monto = Monto;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }
    
    
}
