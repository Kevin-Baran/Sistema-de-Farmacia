package Modelo;

import Vista.frmUsuario;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Kevin
 */
public class UsuariosDAO implements CRUD {

    PreparedStatement ps;
    ResultSet rs;
    //variable de conexion
    Conexion con = new Conexion();
    Connection cn = con.Conectar(); //obtener la conexion

    ////////////metodo para Login
    public boolean login(Usuarios usr) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        //String sqlactualizar="SELECT FROM Empleado u.Cod_empleado, u.Nombre, u.Usuario, u.Contraseña, u.Cod_tipo_empleado, t.Nombre FROM Empleado AS u INNER JOIN tipo_empleado AS t ON u.Cod_tipo_empleado=t.Cod_tipo_empleado WHERE Usuario=?";
        String sqlactualizar = "SELECT  Empleado.Cod_empleado, Empleado.Nombre, Empleado.Usuario, Empleado.Contraseña, Empleado.Cod_tipo_empleado, tipo_empleado.Nombre, tipo_empleado.Cod_tipo_empleado FROM Empleado INNER JOIN tipo_empleado ON Empleado.Cod_tipo_empleado= tipo_empleado.Cod_tipo_empleado WHERE Usuario=?";
        try {

            ps = cn.prepareStatement(sqlactualizar);
            ps.setString(1, usr.getUsuario());
            rs = ps.executeQuery();

            if (rs.next()) {
                //condicion para comparar la contraseña ingresada con la contraseña de la base de datos
                if (usr.getContraseña().equals(rs.getString(4))) {
                    //agregar registro de ultima sesion a empleado
                    String sqlUpdate = "UPDATE Empleado SET Last_session = ? WHERE Cod_empleado=?";
                    ps = cn.prepareStatement(sqlUpdate);
                    ps.setString(1, usr.getLast_session());
                    ps.setInt(2, rs.getInt(1));
                    ps.execute();

                    usr.setCod_empleado(rs.getInt(1));
                    usr.setNombre(rs.getString(2));
                    usr.setCod_tipo_empleado(rs.getInt(5));
                    usr.setTipo_empleado(rs.getString(6));
                    return true;
                } else {
                    return false;
                }
            }
            return false;

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            return false;
        }

    }

    @Override
    public List listar() {

        List<Usuarios> lista = new ArrayList<>();
        String sql = "Select * from Empleado";
        try {
            cn = con.Conectar();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Usuarios u = new Usuarios();
                u.setCod_empleado(rs.getInt(1));
                u.setNombre(rs.getString(2));
                u.setApellido(rs.getString(3));
                u.setSexo(rs.getString(4));
                u.setUsuario(rs.getString(5));
                u.setContraseña(rs.getString(6));
                u.setCod_tipo_empleado(rs.getInt(7));
                lista.add(u);
            }
        } catch (Exception e) {
        }
        return lista;
    }

    @Override
    public int add(Object[] o) {
        int r = 0;
        String sql = "insert into Empleado (Nombre, Apellido, Sexo, Usuario, Contraseña, Cod_tipo_empleado) values (?,?,?,?,?,?)";
        try {
            cn = con.Conectar();
            ps = cn.prepareStatement(sql);
            ps.setObject(1, o[0]);
            ps.setObject(2, o[1]);
            ps.setObject(3, o[2]);
            ps.setObject(4, o[3]);
            ps.setObject(5, o[4]);
            ps.setObject(6, o[5]);
            r = ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Guardado Satisfactoriamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Registro No Guardado");
        }
        return r;
    }

    @Override
    public int actualizar(Object[] o) {
        int r = 0;
        String sql = "Update Empleado SET Nombre=?, Apellido=?, Sexo=?, Usuario=?, Contraseña=?, Cod_tipo_empleado=? WHERE Cod_empleado=?";
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
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
            JOptionPane.showMessageDialog(null, "Registro No Actualizado");
        }
        return r;
    }

    @Override
    public void eliminar(int id) {
        String sql = "DELETE from Empleado WHERE Cod_empleado = ?";
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
