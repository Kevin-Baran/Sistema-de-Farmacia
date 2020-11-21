package Modelo;

/**
 *
 * @author Kevin
 */
public class Usuarios {

    int Cod_empleado;
    String Nombre;
    String Apellido;
    String Sexo;
    String Usuario;
    String Contraseña;
    int Cod_tipo_empleado;
    String Last_session;
    String Tipo_empleado;
    
    public Usuarios() {
    }

    public Usuarios(int Cod_empleado, String Nombre, String Apellido, String Sexo, String Usuario, String Contraseña, int Cod_tipo_empleado, String Last_session, String Tipo_empleado) {
        this.Cod_empleado = Cod_empleado;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Sexo = Sexo;
        this.Usuario = Usuario;
        this.Contraseña = Contraseña;
        this.Cod_tipo_empleado = Cod_tipo_empleado;
        this.Last_session = Last_session;
        this.Tipo_empleado = Tipo_empleado;
    }

    public int getCod_empleado() {
        return Cod_empleado;
    }

    public void setCod_empleado(int Cod_empleado) {
        this.Cod_empleado = Cod_empleado;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

    public int getCod_tipo_empleado() {
        return Cod_tipo_empleado;
    }

    public void setCod_tipo_empleado(int Cod_tipo_empleado) {
        this.Cod_tipo_empleado = Cod_tipo_empleado;
    }

    public String getLast_session() {
        return Last_session;
    }

    public void setLast_session(String Last_session) {
        this.Last_session = Last_session;
    }

    public String getTipo_empleado() {
        return Tipo_empleado;
    }

    public void setTipo_empleado(String Tipo_empleado) {
        this.Tipo_empleado = Tipo_empleado;
    }
    
    

}
