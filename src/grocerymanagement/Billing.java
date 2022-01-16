package grocerymanagement;
import Connector.ConnectionProvider;
import java.sql.*;
import java.sql.Connection;
import java.text.MessageFormat;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jitendra mishra
 */
public class Billing extends javax.swing.JFrame {
    

    String bid,cname,cphone;
    public Billing() {
        initComponents();
        comboData();
        tf4.setEditable(false);
        tf5.setEditable(false);
        tf6.setEditable(false);
        billGenerated.setEditable(false);
        billHeader();
        
 
    }
    
    public void billHeader(){
        JTextField jtf1 = new JTextField();
        JTextField jtf2 = new JTextField();
        JTextField jtf3 = new JTextField();
        Object[] message = {"Enter Bill No.:",jtf1,
                            "Enter Customer Name:", jtf2,
                            "Enter Customer Phone No.:", jtf3};
        
        int option = JOptionPane.showConfirmDialog(this, message, "Enter all your values", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION)
        {
           bid = jtf1.getText();
           cname = jtf2.getText();
           cphone = jtf3.getText();
        }
        billGenerated.setText("\n\t\t\tGROCERY MGMT SYSTEM\t\t\n"
                        +"\t\t\t11'TH MAIN, BANGALORE\n"
                        +"\t\t\tPIN: 560071\n"
                        +"\t\t\tPHONE: 080-1234567"
                        +"\n  ==============================================================\n"+
                        "  BILL NO.        : "+bid+"\n"+"  Customer Name  : "+cname+"\n"+"  Phone Number  :"+cphone+"\n"+"  Purchase Date\n"
                        +"  ===============================================================\n"
                        +"  NUM     PRODUCT     PRICE       QUANTITY        TOTAL"
                        +"\n  ===============================================================\n");
    }
    
    public void clear() {
        tf1.setText("");
        tf2.setText("");
        tf3.setText("");
        tf4.setText("");
        tf5.setText("");
        tf6.setText("");
        tf7.setText("");              
    }
    public void comboData(){
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select cname from categories;");
            while(rs.next()){
                String pat = rs.getString("cname");
                categorygBox.addItem(pat);
            }
        con.close();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
        
    public void showData() {
        try {
            DefaultTableModel model = (DefaultTableModel) billTable.getModel();
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            String query = "select * from products where category = '"+String.valueOf(categorygBox.getSelectedItem())+"';";
            ResultSet rs = st.executeQuery(query);
            
            model.setRowCount(0);
            while(rs.next()) {
                String pid = rs.getString("prodId");
                String pname = rs.getString("pname");
                String prate = rs.getString("PRate");
                
                model.addRow(new Object[] {pid,pname,prate});
            }
        }
        catch(Exception e) {
            e.printStackTrace();  
            JOptionPane.showMessageDialog(this, e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tf1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        tf6 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        tf7 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        billTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        closeBtn = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        tf3 = new javax.swing.JTextField();
        categorygBox = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        billGenerated = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        tf4 = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        tf2 = new javax.swing.JTextField();
        tf5 = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1020, 720));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(1045, 710));
        setResizable(false);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 153, 51));
        jPanel1.setPreferredSize(new java.awt.Dimension(1045, 710));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel1.setText("Prod ID");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 280, 60, 20));

        tf1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf1ActionPerformed(evt);
            }
        });
        jPanel1.add(tf1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 130, 150, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Filter By:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 70, 20));

        tf6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(tf6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 148, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Quantity");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 380, 60, -1));

        tf7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(tf7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 370, 150, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Date");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(720, 50, 40, -1));

        billTable.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        billTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Product ID", "Name", "Price"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        billTable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                billTableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(billTable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 140, 510, 160));

        jPanel2.setBackground(new java.awt.Color(23, 35, 51));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 731));

        jPanel3.setBackground(new java.awt.Color(23, 35, 51));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(117, 0, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("MANAGE BILL");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 40, -1, -1));

        addBtn.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        addBtn.setText("ADD To Bill");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        jPanel1.add(addBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 450, -1, -1));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButton5.setText("Remove");
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 450, -1, -1));

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        jButton6.setText("Print");
        jButton6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton6MouseClicked(evt);
            }
        });
        jPanel1.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 550, 90, 40));

        jPanel4.setBackground(new java.awt.Color(23, 35, 51));

        closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Exit_Btn.jpg"))); // NOI18N
        closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(closeBtn)
                .addGap(0, 0, 0))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(closeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 40));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("PRICE");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 340, -1, 20));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Customer Phone");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 200, -1, -1));

        tf3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(tf3, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 190, 150, -1));

        categorygBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        categorygBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        categorygBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categorygBoxActionPerformed(evt);
            }
        });
        jPanel1.add(categorygBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, 150, -1));

        billGenerated.setColumns(20);
        billGenerated.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        billGenerated.setRows(5);
        jScrollPane2.setViewportView(billGenerated);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, 570, 390));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Bill No");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 130, 50, 20));

        tf4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf4ActionPerformed(evt);
            }
        });
        jPanel1.add(tf4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 150, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Customer Name");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 160, -1, 20));

        tf2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(tf2, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 160, 150, -1));

        tf5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(tf5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 148, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Product Name");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, 20));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 720));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tf1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf1ActionPerformed

    private void billTableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_billTableMouseClicked
        DefaultTableModel model =(DefaultTableModel) billTable.getModel();
        int myIndex = billTable.getSelectedRow();
        tf4.setText(model.getValueAt( billTable.getSelectedRow(), 0).toString());
        tf5.setText(model.getValueAt( billTable.getSelectedRow(), 1).toString());
        tf6.setText(model.getValueAt( billTable.getSelectedRow(), 2).toString());
    }//GEN-LAST:event_billTableMouseClicked

    private void closeBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeBtnMouseClicked
        System.exit(0);
    }//GEN-LAST:event_closeBtnMouseClicked
int i=0;
int tot=0;
int summ=0;
    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        String bid = tf1.getText();
        String cname = tf2.getText();
        String cphone = tf3.getText();
//        String pid = tf4.getText();
//        String pname = tf5.getText();
//        String price = tf6.getText();
//        String qty = tf7.getText();
        
        if (bid.isEmpty()|| cname.isEmpty()|| cphone.isEmpty()){
            JOptionPane.showMessageDialog(this,"ADD BILL ID and Customer Details: ",null, JOptionPane.WARNING_MESSAGE);
            try {
                Connection con = ConnectionProvider.getCon();
                Statement st = con.createStatement();
                String query = "insert into Billing values('"+Integer.parseInt(bid)+"','"+cname+"','"+Integer.parseInt(cphone)+"');";
                st.executeUpdate(query);
                con.close();
        }
        catch(Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e);
        }
        }
        else{
            i++;
            summ= summ+Integer.valueOf(tf6.getText()) *(Integer.valueOf(tf7.getText()));

            if (i==1) {
                billGenerated.setText(billGenerated.getText()+"   "+i+"      "+tf5.getText()+"       "+tf6.getText()+"       "+tf7.getText()+"       "+summ+"\n");
            }
            else {
                billGenerated.setText(billGenerated.getText()+"   "+i+"      "+tf5.getText()+"       "+tf6.getText()+"       "+tf7.getText()+"       "+summ+"\n");
            }
        }
        
//        
        

    }//GEN-LAST:event_addBtnActionPerformed

    private void categorygBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categorygBoxActionPerformed
     showData();
    }//GEN-LAST:event_categorygBoxActionPerformed

    private void tf4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf4ActionPerformed

    private void jButton6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton6MouseClicked
 try {
     billGenerated.setText(billGenerated.getText()+"\n================================================="
            +"\ntotal: "
            +"\n=====================================================\n");
//        billGenerated.print();
    } 
 catch (Exception e) {
     e.printStackTrace();
}
    }//GEN-LAST:event_jButton6MouseClicked

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        JTextField jtf1 = new JTextField();
        JTextField jtf2 = new JTextField();
        JTextField jtf3 = new JTextField();
        Object[] message = {"Enter Bill No.:",jtf1,
                            "Enter Customer Name:", jtf2,
                            "Enter Customer Phone No.:", jtf3};
        
        int option = JOptionPane.showConfirmDialog(this, message, "Enter all your values", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION)
        {
           bid = jtf1.getText();
           cname = jtf2.getText();
           cphone = jtf3.getText();
        }
    }//GEN-LAST:event_formComponentShown

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Billing().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JTextArea billGenerated;
    private javax.swing.JTable billTable;
    private javax.swing.JComboBox<String> categorygBox;
    private javax.swing.JLabel closeBtn;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextField tf1;
    private javax.swing.JTextField tf2;
    private javax.swing.JTextField tf3;
    private javax.swing.JTextField tf4;
    private javax.swing.JTextField tf5;
    private javax.swing.JTextField tf6;
    private javax.swing.JTextField tf7;
    // End of variables declaration//GEN-END:variables
}
