
package Modelo;

import java.util.List;

/**
 *
 * @author Kevin
 */
public interface CRUD {
    //metodos que se utilizan en formulario de mantenimiento
    public List listar();
    public int add(Object[] o);
    public int actualizar(Object[] o);
    public void eliminar(int id);
}
