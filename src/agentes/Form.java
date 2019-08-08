/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agentes;

import conectar.conectar;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author pipem
 */
public class Form extends javax.swing.JFrame {

        static DefaultListModel listModel;
    /**
     * Creates new form Form
     */
    public Form() {
        initComponents();
        listModel = new DefaultListModel();

        list_tel.setModel(listModel);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        txt_id = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txt_nombre = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txt_fecnac = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txt_genero = new javax.swing.JComboBox<>();
        btn_enviar = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        btn_addtel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        list_tel = new javax.swing.JList<>();
        btn_deltel = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        btn_consultar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Identificacion:");

        jLabel2.setText("Nombre:");

        jLabel3.setText("Fecha Nacimiento:");

        txt_fecnac.setText("09/09/1999");

        jLabel4.setText("Genero:");

        txt_genero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "M", "F", "X" }));

        btn_enviar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agentes/add_icon-icons.com_74429.png"))); // NOI18N
        btn_enviar.setText("Enviar");
        btn_enviar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_enviarMouseClicked(evt);
            }
        });

        jLabel5.setText("Telefonos:");

        btn_addtel.setText("Agregar telefono");
        btn_addtel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_addtelMouseClicked(evt);
            }
        });

        jScrollPane1.setViewportView(list_tel);

        btn_deltel.setText("Eliminar telefono");
        btn_deltel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_deltelMouseClicked(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel6.setText("Agrega persona:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(55, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(37, 37, 37))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btn_consultar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/agentes/xmag_search_find_export_locate_5984.png"))); // NOI18N
        btn_consultar.setText("Consultar");
        btn_consultar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btn_consultarMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5)
                                .addComponent(jLabel4)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_genero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_fecnac, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btn_addtel)
                                .addGap(18, 18, 18)
                                .addComponent(btn_deltel))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel1))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txt_nombre)
                                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btn_enviar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(btn_consultar, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addComponent(jSeparator1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_fecnac, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_genero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_addtel)
                    .addComponent(btn_deltel))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btn_consultar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btn_enviar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_enviarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_enviarMouseClicked
         
        String id_persona = txt_id.getText();
        String nombre = txt_nombre.getText();
        String fecnac = txt_fecnac.getText();
        String genero = (String) txt_genero.getSelectedItem();
        
        Material.p = new Persona(id_persona, nombre, fecnac, genero);
        
        for(int i = 0; i< list_tel.getModel().getSize();i++){
            System.out.println(list_tel.getModel().getElementAt(i));
            Material.p.agregarTelefono(list_tel.getModel().getElementAt(i));
        }
        
        
        Material.numero = 1;
    }//GEN-LAST:event_btn_enviarMouseClicked

    private void btn_addtelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_addtelMouseClicked
        String tel_aux = JOptionPane.showInputDialog("Agrega un telefono");
        
        
        listModel.addElement(tel_aux);
            
        
    }//GEN-LAST:event_btn_addtelMouseClicked

    private void btn_deltelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_deltelMouseClicked

        int selectedIndex = list_tel.getSelectedIndex();
if (selectedIndex != -1) {
    listModel.remove(selectedIndex);
}

    }//GEN-LAST:event_btn_deltelMouseClicked

    private void btn_consultarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_consultarMouseClicked
        
        if (txt_id.getText().isEmpty()) {
            System.out.println("Debes ingresar la indentificacion!");
            JOptionPane.showMessageDialog(null, "Debes ingresar la identificacion de la persona a consultar!");
        } else {
            conectar conn = new conectar();
            String info = null;
            String telefonos = "";
            System.out.println("Ya te busco esperate :v");
            System.out.println(conn.crearConexion());
            String sqlS = "SELECT * FROM personas WHERE id = "+txt_id.getText();
            ResultSet rs = conn.ejecutarSQLSelect(sqlS);
            try {
                while(rs.next()){
                    System.out.println(rs.getString(rs.findColumn("Nombre")));
                    info = "Identificacion: " + rs.getString(rs.findColumn("id")) +
                            "\nNombre: " + rs.getString(rs.findColumn("nombre")) +
                            "\nFecha de nacimiento: " + rs.getString(rs.findColumn("fecha")) + 
                            "\nGenero: " +rs.getString(rs.findColumn("gen"));
                }   } catch (SQLException ex) {
                Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
            }
            sqlS = "SELECT telefono FROM telefonos WHERE id_persona = "+txt_id.getText();
            rs = conn.ejecutarSQLSelect(sqlS);
            try {
                while(rs.next()){
                    System.out.println(rs.getString(rs.findColumn("telefono")));
                    telefonos +=  "\n"+ rs.getString(rs.findColumn("telefono")) + "\n";
                }   } catch (SQLException ex) {
                Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
            }
            JOptionPane.showMessageDialog(null, 
                    info + "\nTelefonos: \n" + telefonos);
        }
    }//GEN-LAST:event_btn_consultarMouseClicked

   public static void borrarFormulario(){
       txt_id.setText("");
       txt_fecnac.setText("");
       txt_nombre.setText("");
       listModel.removeAllElements();
   }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_addtel;
    private javax.swing.JButton btn_consultar;
    private javax.swing.JButton btn_deltel;
    private javax.swing.JButton btn_enviar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private static javax.swing.JList<String> list_tel;
    private static javax.swing.JTextField txt_fecnac;
    private javax.swing.JComboBox<String> txt_genero;
    private static javax.swing.JTextField txt_id;
    private static javax.swing.JTextField txt_nombre;
    // End of variables declaration//GEN-END:variables
}
