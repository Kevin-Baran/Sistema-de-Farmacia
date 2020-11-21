
package Modelo;

/**
 *
 * @author Kevin
 */
public class TipoMedicamento {
    int Cod_tipo_medicamento;
    String Nombre;
    String Tipo_enfermedad;

    public TipoMedicamento() {
    }

    public TipoMedicamento(int Cod_tipo_medicamento, String Nombre, String Tipo_enfermedad) {
        this.Cod_tipo_medicamento = Cod_tipo_medicamento;
        this.Nombre = Nombre;
        this.Tipo_enfermedad = Tipo_enfermedad;
    }

    public int getCod_tipo_medicamento() {
        return Cod_tipo_medicamento;
    }

    public void setCod_tipo_medicamento(int Cod_tipo_medicamento) {
        this.Cod_tipo_medicamento = Cod_tipo_medicamento;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getTipo_enfermedad() {
        return Tipo_enfermedad;
    }

    public void setTipo_enfermedad(String Tipo_enfermedad) {
        this.Tipo_enfermedad = Tipo_enfermedad;
    }
    
    
}
