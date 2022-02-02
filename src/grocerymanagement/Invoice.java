package grocerymanagement;

import Connector.ConnectionProvider;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class Invoice extends javax.swing.JFrame {

    public Invoice() {
        initComponents();
        showData();
    }
    
    public void clear() {
        tf1.setText("");
    }
    
    public void showData() {
        try {
            DefaultTableModel model = (DefaultTableModel) invoiceTable.getModel();
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            String query = "select * from billing;";
            ResultSet rs = st.executeQuery(query);
            
            model.setRowCount(0);
            while(rs.next()) {
                String bill = rs.getString("billno");
                String customer = rs.getString("custName");
                String phone = rs.getString("custPhone");
                String pdate = rs.getString("date");
                String totalamt = rs.getString("total");
                
                model.addRow(new Object[] {bill,customer,phone,pdate,totalamt});
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
        jScrollPane1 = new javax.swing.JScrollPane();
        invoiceTable = new javax.swing.JTable();
        searchBtn = new javax.swing.JButton();
        clearbtn = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        deleteBtn = new javax.swing.JButton();
        deleteAllBtn = new javax.swing.JButton();
        exitbtn = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        invoiceBtn = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        logOutBtn = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(23, 35, 51));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel2.setBackground(new java.awt.Color(255, 204, 102));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        invoiceTable.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        invoiceTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Bill No", "Cust Name", "Cust Phone", "Date", "Total Amt"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        invoiceTable.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_NEXT_COLUMN);
        invoiceTable.setGridColor(new java.awt.Color(0, 0, 0));
        invoiceTable.setRowMargin(2);
        invoiceTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                invoiceTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(invoiceTable);

        jPanel2.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 120, 520, 320));

        searchBtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/search-32.png"))); // NOI18N
        searchBtn.setText("Search");
        searchBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                searchBtnMouseClicked(evt);
            }
        });
        jPanel2.add(searchBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 220, -1, -1));

        clearbtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        clearbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/up.png"))); // NOI18N
        clearbtn.setText("Clear");
        clearbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearbtnActionPerformed(evt);
            }
        });
        jPanel2.add(clearbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 223, 120, 40));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Bill Number");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 140, -1, -1));

        tf1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tf1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tf1MouseClicked(evt);
            }
        });
        jPanel2.add(tf1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 170, 230, -1));

        jLabel2.setBackground(new java.awt.Color(204, 0, 0));
        jLabel2.setFont(new java.awt.Font("Arial Black", 1, 28)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 0));
        jLabel2.setText("INVOICES");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 5, -1, 40));

        deleteBtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/del.png"))); // NOI18N
        deleteBtn.setText("Delete");
        deleteBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteBtnMouseClicked(evt);
            }
        });
        jPanel2.add(deleteBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 290, 130, 40));

        deleteAllBtn.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        deleteAllBtn.setForeground(new java.awt.Color(204, 0, 0));
        deleteAllBtn.setText("Delete All Data");
        deleteAllBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deleteAllBtnMouseClicked(evt);
            }
        });
        jPanel2.add(deleteAllBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 460, 150, 30));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 40, 860, 540));

        exitbtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Exit_Btn.jpg"))); // NOI18N
        exitbtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitbtnMouseClicked(evt);
            }
        });
        jPanel1.add(exitbtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1010, 0, 40, 40));

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanel3.setForeground(new java.awt.Color(255, 0, 0));

        invoiceBtn.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        invoiceBtn.setForeground(new java.awt.Color(255, 0, 51));
        invoiceBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/home1.jpg"))); // NOI18N
        invoiceBtn.setText("  Home");
        invoiceBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                invoiceBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(invoiceBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(invoiceBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 160, 50));

        jPanel5.setBackground(new java.awt.Color(204, 204, 204));
        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        logOutBtn.setFont(new java.awt.Font("Arial Black", 1, 18)); // NOI18N
        logOutBtn.setForeground(new java.awt.Color(255, 0, 0));
        logOutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Logout.jpg"))); // NOI18N
        logOutBtn.setText("  LOG OUT");
        logOutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logOutBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logOutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(logOutBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 350, 160, 50));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 590));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void clearbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearbtnActionPerformed
        clear();
    }//GEN-LAST:event_clearbtnActionPerformed

    private void exitbtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitbtnMouseClicked
        System.exit(0);
    }//GEN-LAST:event_exitbtnMouseClicked

    private void tf1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tf1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tf1MouseClicked

    private void searchBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_searchBtnMouseClicked
        String billno = tf1.getText();
        try {
            DefaultTableModel model = (DefaultTableModel) invoiceTable.getModel();
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            String query = "select * from billing where billno='"+billno+"';";
            ResultSet rs = st.executeQuery(query);
            
            model.setRowCount(0);
            while(rs.next()) {
                String bill = rs.getString("billno");
                String customer = rs.getString("custName");
                String phone = rs.getString("custPhone");
 //               String pcat = rs.getString("category");
                
                model.addRow(new Object[] {bill,customer,phone});
            }
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(rootPane, "Error in fetching Data");
        }
    }//GEN-LAST:event_searchBtnMouseClicked

    private void invoiceTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceTableMouseClicked
        DefaultTableModel model = (DefaultTableModel)invoiceTable.getModel();
        int myIndex = invoiceTable.getSelectedRow();
        tf1.setText(model.getValueAt(myIndex,0).toString());
    }//GEN-LAST:event_invoiceTableMouseClicked

    private void deleteBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteBtnMouseClicked
        if (tf1.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Enter Bill No to be deleted");
        }
        else {
            try {
                Connection con = ConnectionProvider.getCon();
                String bid = tf1.getText();
                String query = "delete from billing where billno = "+bid+";";
                Statement st = con.createStatement();
                st.executeUpdate(query);
                clear();
                showData();
                JOptionPane.showMessageDialog(this,"Bill deleted");
            }
            catch(Exception e){
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_deleteBtnMouseClicked

    private void deleteAllBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deleteAllBtnMouseClicked
        int response = JOptionPane.showConfirmDialog(null, "Do you want to continue?", "Confirm",
            JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        if (response == JOptionPane.YES_OPTION) {
            try {
                    Connection con = ConnectionProvider.getCon();
                    String bid = tf1.getText();
                    String query = "delete *from billing;";
                    Statement st = con.createStatement();
                    st.executeUpdate(query);
                    clear();
                    showData();
                    JOptionPane.showMessageDialog(this,"All Invoice Details deleted!");
                }
                catch(Exception e){
                    e.printStackTrace();
                }
        }
    }//GEN-LAST:event_deleteAllBtnMouseClicked

    private void invoiceBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invoiceBtnMouseClicked
        AdminMode adm = new AdminMode();
        adm.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_invoiceBtnMouseClicked

    private void logOutBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_logOutBtnMouseClicked
        LoginPage lp = new LoginPage();
        lp.setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_logOutBtnMouseClicked

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Invoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Invoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Invoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Invoice.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Invoice().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton clearbtn;
    private javax.swing.JButton deleteAllBtn;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JLabel exitbtn;
    private javax.swing.JLabel invoiceBtn;
    private javax.swing.JTable invoiceTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel logOutBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField tf1;
    // End of variables declaration//GEN-END:variables
}
