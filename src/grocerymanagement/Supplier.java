/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package grocerymanagement;

import Connector.ConnectionProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jitendra mishra
 */
public class Supplier extends javax.swing.JFrame {
    public Supplier() {
        initComponents();
        showData();
    }
    public void clear() {
        tf1.setText("");
        tf2.setText("");
        tf3.setText("");
        tf4.setText("");
    }
     public void showData() {
        try {
            DefaultTableModel model = (DefaultTableModel) SupplierTable.getModel();
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            String query = "select * from supplier;";
            ResultSet rs = st.executeQuery(query);
         
            model.setRowCount(0);
            while(rs.next()) {
                String sid = rs.getString("sid");
                String sname = rs.getString("sname");
                String phone = rs.getString("phone");
                String address = rs.getString("address");
                             
                model.addRow(new Object[] {sid,sname,phone,address});
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error in fetching Data");
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        editBtn = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        tf4 = new javax.swing.JTextField();
        tf2 = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        SupplierTable = new javax.swing.JTable();
        deleteBtn = new javax.swing.JButton();
        clearBtn = new javax.swing.JButton();
        addBtn = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        tf3 = new javax.swing.JTextField();
        closeBtn = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(23, 35, 51));

        jPanel2.setBackground(new java.awt.Color(255, 204, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 22)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 0));
        jLabel1.setText("MANAGE SELLERS");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 20, -1, -1));

        tf1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel2.add(tf1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 150, 220, 30));

        editBtn.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        editBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/edit_btn.png"))); // NOI18N
        editBtn.setText("  EDIT");
        editBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                editBtnMouseClicked(evt);
            }
        });
        jPanel2.add(editBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 520, 120, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel2.setText("SUPPLIER INFO");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 110, -1, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel3.setText("SELLER NAME");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 200, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel4.setText("ADDRESS");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 360, -1, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel5.setText("PHONE NO.");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 280, -1, -1));

        tf4.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel2.add(tf4, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 400, 220, 30));

        tf2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tf2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf2ActionPerformed(evt);
            }
        });
        jPanel2.add(tf2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 230, 220, 30));

        SupplierTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        SupplierTable.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        SupplierTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "SID", "SNAME", "PHONE", "ADDRESS"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        SupplierTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SupplierTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(SupplierTable);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 150, 520, 340));

        deleteBtn.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/del.png"))); // NOI18N
        deleteBtn.setText("DELETE");
        deleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteBtnMouseClicked(evt);
            }
        });
        jPanel2.add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 520, 130, 40));

        clearBtn.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        clearBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/up.png"))); // NOI18N
        clearBtn.setText("CLEAR");
        clearBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                clearBtnMouseClicked(evt);
            }
        });
        jPanel2.add(clearBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 520, 120, 40));

        addBtn.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/an.png"))); // NOI18N
        addBtn.setText("   ADD");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        jPanel2.add(addBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 520, 110, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel6.setText("SELLER ID");
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 120, -1, -1));

        tf3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel2.add(tf3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 310, 220, 30));

        closeBtn.setBackground(new java.awt.Color(255, 0, 0));
        closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeBtnMouseClicked(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("X");

        javax.swing.GroupLayout closeBtnLayout = new javax.swing.GroupLayout(closeBtn);
        closeBtn.setLayout(closeBtnLayout);
        closeBtnLayout.setHorizontalGroup(
            closeBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 57, Short.MAX_VALUE)
            .addGroup(closeBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(closeBtnLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel7)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        closeBtnLayout.setVerticalGroup(
            closeBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 44, Short.MAX_VALUE)
            .addGroup(closeBtnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(closeBtnLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(jLabel7)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(110, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1030, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 654, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tf2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf2ActionPerformed

    private void closeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeBtnMouseClicked
        Products prod = new Products();
        prod.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_closeBtnMouseClicked

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed

        String sid = tf1.getText();
        String sname = tf2.getText();
        String phone = tf3.getText();
        String address = tf4.getText();
        
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            st.executeUpdate("insert into supplier values('"+sid+"','"+sname+"','"+phone+"','"+address+"');");
            JOptionPane.showMessageDialog(null, "values added successfully");
            showData();
                       
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void SupplierTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SupplierTableMouseClicked
        DefaultTableModel model = (DefaultTableModel) SupplierTable.getModel();
        int myIndex = SupplierTable.getSelectedRow();
        tf1.setText(model.getValueAt(myIndex, 0).toString());
        tf2.setText(model.getValueAt(myIndex, 1).toString());
        tf3.setText(model.getValueAt(myIndex, 2).toString());
        tf4.setText(model.getValueAt(myIndex, 3).toString());
        
    }//GEN-LAST:event_SupplierTableMouseClicked

    private void clearBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_clearBtnMouseClicked
        clear();
    }//GEN-LAST:event_clearBtnMouseClicked

    private void deleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseClicked
        if(tf1.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Enter the seller to be deleted");
        }
        else {
            try {
                Connection con = ConnectionProvider.getCon();
                String sid = tf1.getText();
                String query = "delete from supplier where sid="+sid+";";
                Statement st = con.createStatement();
                st.executeUpdate(query);
                clear();
                showData();
                JOptionPane.showMessageDialog(this,"Seller deleted successfully");
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_deleteBtnMouseClicked

    private void editBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_editBtnMouseClicked
        if(tf2.getText().isEmpty() || tf3.getText().isEmpty() || tf4.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Missing some info");            
        }
        else {
            try {
                Connection con = ConnectionProvider.getCon();
                Statement st = con.createStatement();
                String query = "update supplier set sname='"+tf2.getText()+"',phone="+Integer.parseInt(tf3.getText())+", address='"+tf4.getText().toString()+"' where sid="+Integer.parseInt(tf1.getText())+";";
                
                st.executeUpdate(query);
                showData();
                JOptionPane.showMessageDialog(this, "Seller updates");
            }
            catch(SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this,e);
            }
        }
    }//GEN-LAST:event_editBtnMouseClicked

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
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Supplier.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Supplier().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable SupplierTable;
    private javax.swing.JButton addBtn;
    private javax.swing.JButton clearBtn;
    private javax.swing.JPanel closeBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JButton editBtn;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tf1;
    private javax.swing.JTextField tf2;
    private javax.swing.JTextField tf3;
    private javax.swing.JTextField tf4;
    // End of variables declaration//GEN-END:variables
}
