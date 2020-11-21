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
public class MedicamentoDAO {
    int r;
    PreparedStatement ps;
    ResultSet rs;
    //variable de conexion
    Conexion con = new Conexion();
    Connection cn = con.Conectar(); //obtener la conexion
    
    public int actualizarStock (int cant, int idp){
    String sql = "update medicamento set Stock=? where Cod_medicamento=?";
        try {
            cn = con.Conectar();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, cant);
            ps.setInt(2, idp);
            ps.executeQuery();
        } catch (Exception e) {
        }
        return r;
            
}
    public Medicamento listarID(int id){
        Medicamento med = new Medicamento();
        String sql = "SELECT *FROM Medicamento WHERE Cod_medicamento=?";
        try {
            cn = con.Conectar();
            ps = cn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
                med.setCod_medicamento(rs.getInt(1));
                med.setNombre(rs.getString(2));
                med.setStock(rs.getInt(3));
                med.setPrecio(rs.getDouble(4));
            }
        } catch (Exception e) {
        }
        return med;
    }
    public List listar() {
        List<Medicamento> lista = new ArrayList<>();
        String sql = "SELECT *FROM medicamento";
        try {
            cn = con.Conectar();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Medicamento med = new Medicamento();
                med.setCod_medicamento(rs.getInt(1));
                med.setNombre(rs.getString(2));
                med.setStock(rs.getInt(3));
                med.setPrecio(rs.getDouble(4));
                med.setUnidades_vendidas(rs.getInt(5));
                med.setCod_laboratorio(rs.getInt(6));
                med.setCod_tipo_medicamento(rs.getInt(7));
                med.setCod_presentacion(rs.getInt(8));
                lista.add(med);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    public int add(Object[] o) {
        int r = 0;
        String sql = "INSERT INTO medicamento (Nombre, Stock, Precio, Unidades_vendidas, Cod_laboratorio, Cod_tipo_medicamento, Cod_presentacion) VALUES (?,?,?,?,?,?,?)";
        try {
            cn = con.Conectar();
            ps = cn.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            ps.setObject(6, o[5]);
            ps.setObject(7, o[6]);
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
        String sql = "UPDATE medicamento SET Nombre=?, Stock=?, Precio=?, Unidades_vendidas=?, Cod_laboratorio=?, Cod_tipo_medicamento=?, Cod_presentacion=? WHERE Cod_medicamento=?";
        try {
            cn = con.Conectar();
            ps = cn.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            ps.setObject(6, o[5]);
            ps.setObject(7, o[6]);
            ps.setObject(8, o[7]);
            r = ps.executeUpdate();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Registro No Actualizado");
        }
        return r;
    }

    public void eliminar(int id) {
        String sql = "DELETE FROM medicamento WHERE Cod_medicamento = ?";
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
