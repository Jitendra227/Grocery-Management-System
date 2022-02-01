package grocerymanagement;

import Connector.ConnectionProvider;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.sql.Connection;
import java.text.DateFormat;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.util.Date;
import javax.swing.Timer;


public class Billing extends javax.swing.JFrame {

    public String bid,cname,cphone;
   
    public Billing() {
        initComponents();
        comboData();
        tf4.setEditable(false);
        tf5.setEditable(false);
        tf6.setEditable(false);
        billGenerated.setEditable(false);


        SimpleDateFormat dtf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
        Date date = new Date();   
        
        dateTime.setText(dtf.format(date));
        
        billHeader();
    }
       
    public void billHeader(){
        billGenerated.setText("\n\t\t\tGROCERY MGMT SYSTEM\t\t\n"
                        +"\t\t\t11'TH MAIN, BANGALORE\n"
                        +"\t\t\tPIN: 560071\n"
                        +"\t\t\tPHONE: 080-1234567"
                        +"\n  ==============================================================\n"+
                        "  BILL NO.      : "+bid+"\n"+"  Customer Name : "+cname+"\n"+"  Phone Number  : "+cphone+"\n"+"  Purchase Date : "+dateTime.getText()+"\n"
                        +"  ===============================================================\n"
                        +"  NUM   PRODUCT \t PRICE       QUANTITY        TOTAL"
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
        dateTime = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        billTable = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        addBtn = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        printBtn = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        closeBtn = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        logOutBtn = new javax.swing.JLabel();
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
        submitBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(1020, 720));
        setUndecorated(true);
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
        jPanel1.add(tf1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 110, 150, -1));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setText("Filter By:");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 110, 70, 20));

        tf6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(tf6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 340, 148, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Quantity");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 390, 60, -1));

        tf7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(tf7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 380, 150, 30));

        dateTime.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        dateTime.setText("Date");
        jPanel1.add(dateTime, new org.netbeans.lib.awtextra.AbsoluteConstraints(700, 70, 250, -1));

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

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 0, 0));
        jLabel11.setText("MANAGE BILL");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 50, -1, -1));

        addBtn.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
        addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/add.png"))); // NOI18N
        addBtn.setText("  ADD To Bill");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });
        jPanel1.add(addBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 430, 160, 40));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/del.png"))); // NOI18N
        jButton5.setText("Remove");
        jPanel1.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 440, 140, 40));

        printBtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        printBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/print.png"))); // NOI18N
        printBtn.setText("Print");
        printBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                printBtnMouseClicked(evt);
            }
        });
        jPanel1.add(printBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 570, 130, 50));

        jPanel4.setBackground(new java.awt.Color(23, 35, 51));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        closeBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Exit_Btn.jpg"))); // NOI18N
        closeBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeBtnMouseClicked(evt);
            }
        });
        jPanel4.add(closeBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 0, -1, 46));

        jPanel6.setBackground(new java.awt.Color(153, 153, 153));
        jPanel6.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jPanel5.setBackground(new java.awt.Color(0, 204, 255));
        jPanel5.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        logOutBtn.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        logOutBtn.setForeground(new java.awt.Color(255, 0, 0));
        logOutBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Logout.jpg"))); // NOI18N
        logOutBtn.setText("  LOG OUT !");
        logOutBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                logOutBtnMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 135, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(logOutBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 34, Short.MAX_VALUE)
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(logOutBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 43, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jPanel4.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 190, 40));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1040, 40));

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("PRICE");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 350, -1, 20));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setText("Customer Phone");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, -1, -1));

        tf3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(tf3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 170, 150, -1));

        categorygBox.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        categorygBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        categorygBox.setToolTipText("");
        categorygBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categorygBoxActionPerformed(evt);
            }
        });
        jPanel1.add(categorygBox, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 110, 150, -1));

        billGenerated.setColumns(20);
        billGenerated.setFont(new java.awt.Font("Monospaced", 0, 14)); // NOI18N
        billGenerated.setRows(5);
        billGenerated.setWrapStyleWord(true);
        jScrollPane2.setViewportView(billGenerated);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 320, 570, 390));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setText("Bill No");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 110, 50, 20));

        tf4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        tf4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf4ActionPerformed(evt);
            }
        });
        jPanel1.add(tf4, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 280, 150, -1));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel13.setText("Customer Name");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 140, -1, 20));

        tf2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(tf2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 140, 150, -1));

        tf5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jPanel1.add(tf5, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 310, 148, -1));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel14.setText("Product Name");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 310, -1, 20));

        submitBtn.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        submitBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/submit.png"))); // NOI18N
        submitBtn.setText("  SUBMIT");
        submitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitBtnActionPerformed(evt);
            }
        });
        jPanel1.add(submitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 210, 160, -1));

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
        
        if (bid.isEmpty()|| cname.isEmpty()|| cphone.isEmpty()){
            JOptionPane.showMessageDialog(this,"ADD BILL ID and Customer Details: ",null, JOptionPane.WARNING_MESSAGE);
           
        }
        else{
            i++;
            summ= summ+Integer.valueOf(tf6.getText()) *(Integer.valueOf(tf7.getText()));
            tot+=summ;

            if (i==1) {
                billGenerated.setText(billGenerated.getText()+"   "+i+"    "+tf5.getText()+"    \t"+tf6.getText()+" \t\t"+tf7.getText()+" \t\t"+summ+"\n");
            }
            else {
                billGenerated.setText(billGenerated.getText()+"   "+i+"    "+tf5.getText()+"    \t"+tf6.getText()+" \t\t"+tf7.getText()+" \t\t"+summ+"\n");
            }
        }
    }//GEN-LAST:event_addBtnActionPerformed

    private void categorygBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categorygBoxActionPerformed
        showData();
    }//GEN-LAST:event_categorygBoxActionPerformed

    private void tf4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf4ActionPerformed

    private void printBtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_printBtnMouseClicked
 try {
     billGenerated.setText(billGenerated.getText()
            +"\n  =============================================================="
            +"\n  total:     \t\t\t\t\t\t"+tot+""
            +"\n  ==============================================================\n");
     try {
                Connection con = ConnectionProvider.getCon();
                String query = "update Billing set total='"+tot+"' where billno = "+Integer.parseInt(tf1.getText())+";";
                Statement st = con.createStatement();
                st.executeUpdate(query);
            }
            catch(SQLException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(this,e);
            }
    billGenerated.print();
    
    } 
 catch (Exception e) {
     e.printStackTrace();
}
    }//GEN-LAST:event_printBtnMouseClicked

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        
    }//GEN-LAST:event_formComponentShown

    private void submitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitBtnActionPerformed
        bid = tf1.getText();
        cname = tf2.getText();
        cphone = tf3.getText();
        String bDate = java.time.LocalDate.now().toString();
        System.out.println(bDate);
        
        try {
                Connection con = ConnectionProvider.getCon();
                Statement st = con.createStatement();
                String query = "insert into Billing(billno,custName,custphone,date) values('"+Integer.parseInt(bid)+"','"+cname+"','"+cphone+"','"+bDate+"');";
                st.executeUpdate(query);
                con.close();
                billHeader();
                tf1.setEditable(false);
                tf2.setEditable(false);
                tf3.setEditable(false);
        }
        catch(Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e);
        }
    }//GEN-LAST:event_submitBtnActionPerformed

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
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Billing.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

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
    private javax.swing.JLabel dateTime;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel logOutBtn;
    private javax.swing.JButton printBtn;
    private javax.swing.JButton submitBtn;
    private javax.swing.JTextField tf1;
    private javax.swing.JTextField tf2;
    private javax.swing.JTextField tf3;
    private javax.swing.JTextField tf4;
    private javax.swing.JTextField tf5;
    private javax.swing.JTextField tf6;
    private javax.swing.JTextField tf7;
    // End of variables declaration//GEN-END:variables
}
