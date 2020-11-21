/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class LaboratorioDAO {
    PreparedStatement ps;
    ResultSet rs;
    //variable de conexion
    Conexion con = new Conexion();
    Connection cn = con.Conectar(); //obtener la conexion
    
    public List listar(){
        List<Laboratorio> lista = new ArrayList<>();
        String sql = "SELECT *FROM Laboratorio";
        try {
            cn = con.Conectar();
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Laboratorio lab = new Laboratorio();
                lab.setCod_laboratorio(rs.getInt(1));
                lab.setNombre(rs.getString(2));
                lab.setDireccion(rs.getString(3));
                lab.setTelefono(rs.getString(4));
                lab.setCorreo(rs.getString(5));
                lab.setNombre_contacto(rs.getString(6));
                lab.setFuncion_contacto(rs.getString(7));
                lista.add(lab);
            }
        } catch (Exception e) {
        }
        return lista;
    }
    
    public int add(Object[] o){
        int r = 0;
        String sql = "INSERT INTO Laboratorio (Nombre, Direccion, Telefono, Correo, Nombre_contacto, Funcion_contacto) VALUES (?,?,?,?,?,?)";
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
    
    public int actualizar(Object [] o){
        int r = 0;
        String sql = "UPDATE Laboratorio SET Nombre=?, Direccion=?, Telefono=?, Correo=?, Nombre_contacto=?, Funcion_contacto=? WHERE Cod_laboratorio=?";
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
    
    public void eliminar(int id){
        String sql = "DELETE FROM Laboratorio WHERE Cod_laboratorio = ?";
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
