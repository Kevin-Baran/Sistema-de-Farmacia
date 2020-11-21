package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Kevin
 */
public class PresentacionDAO {

    PreparedStatement ps;
    ResultSet rs;
    //variable de conexion
    Conexion con = new Conexion();
    Connection cn = con.Conectar(); //obtener la conexion

    public List listar() {
        List<Presentacion> lista = new ArrayList<>();
        String sql = "SELECT *FROM presentacion";
        try {
            cn = con.Conectar();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Presentacion pre = new Presentacion();
                pre.setCod_presentacion(rs.getInt(1));
                pre.setPresentacion(rs.getString(2));
                lista.add(pre);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public int add(Object[] o) {
        int r = 0;
        String sql = "INSERT INTO presentacion (presentacion) VALUES (?)";
        try {
            cn = con.Conectar();
            ps = cn.prepareStatement(sql);
            ps.setObject(1, o[0]);
            r = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Guardado Satisfactoriamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Registro No Guardado");
        }
        return r;
    }

    public int actualizar(Object[] o) {
        int r = 0;
        String sql = "UPDATE presentacion SET presentacion=? WHERE Cod_presentacion=?";
        try {
            cn = con.Conectar();
            ps = cn.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            r = ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Registro No Actualizado");
        }
        return r;
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM presentacion WHERE Cod_presentacion = ?";
        try {
            cn = con.Conectar();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Registro No Eliminado");
        }
    }
}
