package Vista;

import Modelo.Conexion;
import Modelo.Medicamento;
import Modelo.MedicamentoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Kevin
 */
public class frmMedicamento extends javax.swing.JInternalFrame {

    static ResultSet rs = null;
    PreparedStatement ps = null;
    Conexion con = new Conexion();//instanciar clase Conexion
    Connection cn = con.Conectar(); //obtener la conexion

    MedicamentoDAO dao = new MedicamentoDAO();

    DefaultTableModel modelo = new DefaultTableModel();

    int Cod;

    public frmMedicamento() {
        initComponents();
        listar();

        //tamaño columnas de tabla
        TableColumnModel columnModel = jTableMedicamento.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(150);
        columnModel.getColumn(1).setPreferredWidth(400);
        columnModel.getColumn(2).setPreferredWidth(150);
        columnModel.getColumn(3).setPreferredWidth(150);
        columnModel.getColumn(4).setPreferredWidth(250);
        columnModel.getColumn(5).setPreferredWidth(250);
        columnModel.getColumn(6).setPreferredWidth(300);
        columnModel.getColumn(7).setPreferredWidth(300);

        //jComboBoxCodLaboratorio 
        try {
            String sql = ("Select * from laboratorio");
            PreparedStatement ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                jComboCodLaboratorio.addItem(rs.getString("Cod_laboratorio"));
            }
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        //jComboBoxCodTipoMedicamento 
        try {
            String sql = ("Select * from tipo_medicamento");
            PreparedStatement ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                jComboCodTipoMedicamento.addItem(rs.getString("Cod_tipo_medicamento"));
            }
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }

        //jComboBoxCodPresentacion 
        try {
            String sql = ("Select * from presentacion");
            PreparedStatement ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                jComboCodPresentacion.addItem(rs.getString("Cod_presentacion"));
            }
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
    }

    void listar() {

        List<Medicamento> lista = dao.listar();

        modelo = (DefaultTableModel) jTableMedicamento.getModel();
        RowSorter<TableModel> sorter = new TableRowSorter<>(modelo);
        jTableMedicamento.setRowSorter(sorter);

        Object[] ob = new Object[8];
        for (int i = 0; i < lista.size(); i++) {
            ob[0] = lista.get(i).getCod_medicamento();
            ob[1] = lista.get(i).getNombre();
            ob[2] = lista.get(i).getStock();
            ob[3] = lista.get(i).getPrecio();
            ob[4] = lista.get(i).getUnidades_vendidas();
            ob[5] = lista.get(i).getCod_laboratorio();
            ob[6] = lista.get(i).getCod_tipo_medicamento();
            ob[7] = lista.get(i).getCod_presentacion();
            modelo.addRow(ob);
        }
        jTableMedicamento.setModel(modelo);
        jTableMedicamento.getRowSorter().toggleSortOrder(0);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        txtNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtStock = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtPrecio = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtUnidadesVendidas = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        btnIngresar = new javax.swing.JButton();
        btnActualizar = new javax.swing.JButton();
        btnElimina = new javax.swing.JButton();
        btnNuevo = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        txtBuscar = new javax.swing.JTextField();
        jComboCodLaboratorio = new javax.swing.JComboBox<>();
        jComboCodTipoMedicamento = new javax.swing.JComboBox<>();
        jComboCodPresentacion = new javax.swing.JComboBox<>();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableMedicamento = new javax.swing.JTable();

        setClosable(true);
        setIconifiable(true);
        setTitle("MEDICAMENTOS");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        txtNombre.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Nombre");

        txtStock.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtStock.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtStockKeyTyped(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Stock");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Precio");

        txtPrecio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtPrecio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPrecioKeyTyped(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Unidades vendidas");

        txtUnidadesVendidas.setEditable(false);
        txtUnidadesVendidas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtUnidadesVendidas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtUnidadesVendidasKeyTyped(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Código de laboratorio");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel7.setText("Código tipo de medicamento");

        jLabel8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel8.setText("Código de presentación");

        btnIngresar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnIngresar.setText("Ingresar");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        btnActualizar.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnActualizar.setText("Actualizar");
        btnActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnActualizarActionPerformed(evt);
            }
        });

        btnElimina.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnElimina.setText("Eliminar");
        btnElimina.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminaActionPerformed(evt);
            }
        });

        btnNuevo.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        btnNuevo.setText("Nuevo");
        btnNuevo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoActionPerformed(evt);
            }
        });

        jLabel10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel10.setText("Buscar");

        txtBuscar.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txtBuscarKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        jComboCodLaboratorio.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jComboCodLaboratorio.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Laboratorio" }));

        jComboCodTipoMedicamento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jComboCodTipoMedicamento.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Tipo de Medicamento" }));

        jComboCodPresentacion.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jComboCodPresentacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Presentación" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(217, 217, 217)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtUnidadesVendidas, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(121, 121, 121))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboCodPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboCodLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jComboCodTipoMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(49, 49, 49)))
                .addGap(62, 62, 62)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnElimina, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel10)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(9, 9, 9)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnIngresar)
                            .addComponent(btnActualizar))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnElimina)
                            .addComponent(btnNuevo))
                        .addGap(18, 18, 18)
                        .addComponent(jLabel10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrecio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtUnidadesVendidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboCodLaboratorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jComboCodTipoMedicamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboCodPresentacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addContainerGap(20, Short.MAX_VALUE))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jTableMedicamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Codigo", "Nombre", "Stock", "Precio", "Unidades Vendidas", "Código de Laboratorio", "Código Tipo de Medicamento", "Código de Presentación"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableMedicamento.getTableHeader().setReorderingAllowed(false);
        jTableMedicamento.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTableMedicamentoMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTableMedicamento);
        if (jTableMedicamento.getColumnModel().getColumnCount() > 0) {
            jTableMedicamento.getColumnModel().getColumn(0).setResizable(false);
            jTableMedicamento.getColumnModel().getColumn(1).setResizable(false);
            jTableMedicamento.getColumnModel().getColumn(2).setResizable(false);
            jTableMedicamento.getColumnModel().getColumn(3).setResizable(false);
            jTableMedicamento.getColumnModel().getColumn(4).setResizable(false);
            jTableMedicamento.getColumnModel().getColumn(5).setResizable(false);
            jTableMedicamento.getColumnModel().getColumn(7).setResizable(false);
        }

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1142, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        agregar();
        limpiarTabla();
        listar();
        nuevo();
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnActualizarActionPerformed
        actualizar();
        limpiarTabla();
        listar();
        nuevo();
    }//GEN-LAST:event_btnActualizarActionPerformed

    private void btnEliminaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminaActionPerformed
        eliminar();
        limpiarTabla();
        listar();
        nuevo();
    }//GEN-LAST:event_btnEliminaActionPerformed

    private void btnNuevoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoActionPerformed
        nuevo();
    }//GEN-LAST:event_btnNuevoActionPerformed

    private void txtBuscarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyPressed

    }//GEN-LAST:event_txtBuscarKeyPressed

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased

        String[] titulos = {"Codigo", "Nombre", "Stock", "Precio", "Unidades Vendidas", "Código de Laboratorio", "Código Tipo de Medicamento", "Código de Presentación"};
        String[] registros = new String[8];

        String sql = "SELECT *FROM medicamento WHERE Cod_medicamento LIKE '%" + txtBuscar.getText() + "%'" + "OR Nombre LIKE'%" + txtBuscar.getText() + "%'";
        modelo = new DefaultTableModel(null, titulos);
        cn = con.Conectar();
        try {
            RowSorter<TableModel> sorter = new TableRowSorter<>(modelo);
            jTableMedicamento.setRowSorter(sorter);
            Statement st = (Statement) cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                registros[0] = rs.getString("Cod_medicamento");
                registros[1] = rs.getString("Nombre");
                registros[2] = rs.getString("Stock");
                registros[3] = rs.getString("Precio");
                registros[4] = rs.getString("Unidades_vendidas");
                registros[5] = rs.getString("Cod_laboratorio");
                registros[6] = rs.getString("Cod_tipo_medicamento");
                registros[7] = rs.getString("Cod_presentacion");
                modelo.addRow(registros);
            }
            jTableMedicamento.setModel(modelo);
            jTableMedicamento.getRowSorter().toggleSortOrder(0);

            //tamaño columnas de tabla
            TableColumnModel columnModel = jTableMedicamento.getColumnModel();
            columnModel.getColumn(0).setPreferredWidth(150);
            columnModel.getColumn(1).setPreferredWidth(400);
            columnModel.getColumn(2).setPreferredWidth(150);
            columnModel.getColumn(3).setPreferredWidth(150);
            columnModel.getColumn(4).setPreferredWidth(200);
            columnModel.getColumn(5).setPreferredWidth(250);
            columnModel.getColumn(6).setPreferredWidth(300);
            columnModel.getColumn(7).setPreferredWidth(300);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "ERROR: " + e.getMessage());
        }
    }//GEN-LAST:event_txtBuscarKeyReleased

    public int existeMedicamento(String medicamento) {
        PreparedStatement ps = null;
        ResultSet rs = null;

        Conexion con = new Conexion();//instanciar clase Conexion
        Connection cn = con.Conectar(); //obtener la conexion

        String sqlactualizar = "SELECT count(Cod_medicamento) FROM medicamento WHERE Nombre=?";
        try {
            ps = cn.prepareStatement(sqlactualizar);
            ps.setString(1, medicamento);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 1;
        } catch (SQLException e) {
            //JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            return 1;
        } finally {
            try {
                cn.close();
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
            }
        }
    }

    void agregar() {
        try {

            //condicion que verifica si algun campo se encuentra vacio
            if (txtNombre.getText().equals("") || txtStock.equals("") || txtPrecio.equals("") || jComboCodLaboratorio.getSelectedItem().equals("Seleccione Laboratorio") || jComboCodTipoMedicamento.getSelectedItem().equals("Seleccione Tipo de Medicamento") || jComboCodPresentacion.getSelectedItem().equals("Seleccione Presentación")) {
                JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
            } else {
                if (existeMedicamento(txtNombre.getText()) == 0) {
                    String Nombre = txtNombre.getText();
                    String Stock = txtStock.getText();
                    String Precio = txtPrecio.getText();
                    String UnidadesVendidas = txtUnidadesVendidas.getText();
                    String CodLaboratorio = jComboCodLaboratorio.getSelectedItem().toString();
                    String CodTipoMedicamento = jComboCodTipoMedicamento.getSelectedItem().toString();
                    String CodPresentacion = jComboCodPresentacion.getSelectedItem().toString();
                    Object[] ob = new Object[7];
                    ob[0] = Nombre;
                    ob[1] = Stock;
                    ob[2] = Precio;
                    ob[3] = UnidadesVendidas;
                    ob[4] = CodLaboratorio;
                    ob[5] = CodTipoMedicamento;
                    ob[6] = CodPresentacion;
                    dao.add(ob);
                } else {
                    JOptionPane.showMessageDialog(null, "El medicamento ya existe");
                }
            }
        } catch (Exception e) {
        }
    }

    void actualizar() {
        int fila = jTableMedicamento.getSelectedRow();
        if (fila == -1 || jComboCodLaboratorio.getSelectedItem().equals("Seleccione Laboratorio") || jComboCodTipoMedicamento.getSelectedItem().equals("Seleccione Tipo de Medicamento") || jComboCodPresentacion.getSelectedItem().equals("Seleccione Presentación")) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
        } else {
            String Nombre = txtNombre.getText();
            String Stock = txtStock.getText();
            String Precio = txtPrecio.getText();
            String UnidadesVendidas = txtUnidadesVendidas.getText();
            String CodLaboratorio = jComboCodLaboratorio.getSelectedItem().toString();
            String CodTipoMedicamento = jComboCodTipoMedicamento.getSelectedItem().toString();
            String CodPresentacion = jComboCodPresentacion.getSelectedItem().toString();

            Object[] obj = new Object[8];
            obj[0] = Nombre;
            obj[1] = Stock;
            obj[2] = Precio;
            obj[3] = UnidadesVendidas;
            obj[4] = CodLaboratorio;
            obj[5] = CodTipoMedicamento;
            obj[6] = CodPresentacion;
            obj[7] = Cod;
            dao.actualizar(obj);
        }
    }

    void eliminar() {
        int fila = jTableMedicamento.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
        } else {
            int Cods = Integer.parseInt(jTableMedicamento.getValueAt(fila, 0).toString());
            dao.eliminar(Cods);
        }
    }

    void nuevo() {
        txtNombre.setText(null);
        txtStock.setText(null);
        txtPrecio.setText(null);
        txtUnidadesVendidas.setText(null);
        jComboCodLaboratorio.setSelectedItem("Seleccione Laboratorio");
        jComboCodTipoMedicamento.setSelectedItem("Seleccione Tipo de Medicamento");
        jComboCodPresentacion.setSelectedItem("Seleccione Presentación");
        txtNombre.requestFocus();
        jTableMedicamento.clearSelection();
    }
    
        void limpiarTabla() {
        for (int i = 0; i < modelo.getRowCount(); i++) {
            modelo.removeRow(i);
            i = i - 1;
        }
    }

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        if (txtBuscar.getText().length() == 40) {
            evt.consume();
        }
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void jTableMedicamentoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTableMedicamentoMouseClicked
        int fila = jTableMedicamento.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(this, "Debe seleccionar una fila");
        } else {
            Cod = Integer.parseInt(jTableMedicamento.getValueAt(fila, 0).toString());
            String Nombre = jTableMedicamento.getValueAt(fila, 1).toString();
            String Stock = jTableMedicamento.getValueAt(fila, 2).toString();
            String Precio = jTableMedicamento.getValueAt(fila, 3).toString();
            String UnidadesVendidas = jTableMedicamento.getValueAt(fila, 4).toString();
            String CodLaboratorio = jTableMedicamento.getValueAt(fila, 5).toString();
            String CodTipoMedicamento = jTableMedicamento.getValueAt(fila, 6).toString();
            String CodPresentacion = jTableMedicamento.getValueAt(fila, 7).toString();
            txtNombre.setText(Nombre);
            txtStock.setText(Stock);
            txtPrecio.setText(Precio);
            txtUnidadesVendidas.setText(UnidadesVendidas);
            jComboCodLaboratorio.setSelectedItem(CodLaboratorio);
            jComboCodTipoMedicamento.setSelectedItem(CodTipoMedicamento);
            jComboCodPresentacion.setSelectedItem(CodPresentacion);
        }
    }//GEN-LAST:event_jTableMedicamentoMouseClicked

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        if (txtNombre.getText().length() == 30) {
            evt.consume();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtStockKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtStockKeyTyped
        if (txtStock.getText().length() == 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txtStockKeyTyped

    private void txtPrecioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioKeyTyped
        if (txtPrecio.getText().length() == 10) {
            evt.consume();
        }
    }//GEN-LAST:event_txtPrecioKeyTyped

    private void txtUnidadesVendidasKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtUnidadesVendidasKeyTyped
        if (txtUnidadesVendidas.getText().length() == 25) {
            evt.consume();
        }
    }//GEN-LAST:event_txtUnidadesVendidasKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnActualizar;
    private javax.swing.JButton btnElimina;
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnNuevo;
    private javax.swing.JComboBox<String> jComboCodLaboratorio;
    private javax.swing.JComboBox<String> jComboCodPresentacion;
    private javax.swing.JComboBox<String> jComboCodTipoMedicamento;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableMedicamento;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtStock;
    private javax.swing.JTextField txtUnidadesVendidas;
    // End of variables declaration//GEN-END:variables
}
