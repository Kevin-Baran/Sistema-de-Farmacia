
package Modelo;

/**
 *
 * @author Kevin
 */
public class Presentacion {
    int Cod_presentacion;
    String presentacion;

    public Presentacion() {
    }

    public Presentacion(int Cod_presentacion, String presentacion) {
        this.Cod_presentacion = Cod_presentacion;
        this.presentacion = presentacion;
    }

    public int getCod_presentacion() {
        return Cod_presentacion;
    }

    public void setCod_presentacion(int Cod_presentacion) {
        this.Cod_presentacion = Cod_presentacion;
    }

    public String getPresentacion() {
        return presentacion;
    }

    public void setPresentacion(String presentacion) {
        this.presentacion = presentacion;
    }
    
    
    
}
