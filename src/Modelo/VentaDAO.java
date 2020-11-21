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
public class VentaDAO {

    Conexion cn = new Conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    int r = 0;

    public String IdVentas() {
        String idv = "";
        String sql = "Select max (Numero_factura)from Factura";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                idv = rs.getString(1);
            }
        } catch (Exception e) {
        }
        return idv;
    }

    public int GuardarVentas(Venta v) {
        Venta ventas = new Venta();
        String sql = "insert into Factura(Cod_empleado, Fecha, Monto, Estado)values(?,?,?,?)";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, v.getCod_empleado());
            ps.setString(2, v.getFecha());
            ps.setDouble(3, v.getMonto());
            ps.setString(4, v.getEstado());
            r = ps.executeUpdate();

        } catch (Exception e) {
        }
        return r;
    }

    public int GuardarDetalleVentas(DetalleVenta dv) {
        String sql = "insert into Detalle_Factura(Numero_factura, Cod_medicamento, Cantidad, Precio) values (?,?,?,?)";
        try {
            con = cn.Conectar();
            ps = con.prepareStatement(sql);
            ps.setInt(1, dv.getNumero_factura());
            ps.setInt(2, dv.getCod_medicamento());
            ps.setInt(3, dv.getCantidad());
            ps.setDouble(4, dv.getPrecio());
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return r;
    }

}
