
package Modelo;

/**
 *
 * @author Kevin
 */
public class Laboratorio {
    int Cod_laboratorio;
    String Nombre;
    String Direccion;
    String Telefono;
    String Correo;
    String Nombre_contacto;
    String Funcion_contacto;

    public Laboratorio() {
    }

    public Laboratorio(int Cod_laboratorio, String Nombre, String Direccion, String Telefono, String Correo, String Nombre_contacto, String Funcion_contacto) {
        this.Cod_laboratorio = Cod_laboratorio;
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.Telefono = Telefono;
        this.Correo = Correo;
        this.Nombre_contacto = Nombre_contacto;
        this.Funcion_contacto = Funcion_contacto;
    }

    public int getCod_laboratorio() {
        return Cod_laboratorio;
    }

    public void setCod_laboratorio(int Cod_laboratorio) {
        this.Cod_laboratorio = Cod_laboratorio;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getTelefono() {
        return Telefono;
    }

    public void setTelefono(String Telefono) {
        this.Telefono = Telefono;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getNombre_contacto() {
        return Nombre_contacto;
    }

    public void setNombre_contacto(String Nombre_contacto) {
        this.Nombre_contacto = Nombre_contacto;
    }

    public String getFuncion_contacto() {
        return Funcion_contacto;
    }

    public void setFuncion_contacto(String Funcion_contacto) {
        this.Funcion_contacto = Funcion_contacto;
    }
    
    
}
