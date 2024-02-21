package GiaoDien;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */


import Connect.MySQLConnection;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author Fatimah
 */
public class QuanLyNCC extends javax.swing.JFrame {
    MySQLConnection connection = new MySQLConnection();
    DefaultTableModel tableModel;
    /**
     * Creates new form AddVendor
     */
    public QuanLyNCC() {
        initComponents();
        setTitle("Quản Lý Nhà Cung Cấp");
        ShowNCC();
        txtmancc.setEnabled(false);
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
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        txtmancc = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txttenncc = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        txtsdtncc = new javax.swing.JTextField();
        txtdiachincc = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        Exit1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ncctable = new javax.swing.JTable();
        jLabel12 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Vendor");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel1.setForeground(new java.awt.Color(51, 51, 51));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("QUẢN LÝ NHÀ CUNG CẤP");

        jPanel2.setBackground(new java.awt.Color(255, 153, 51));

        jLabel5.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Mã Nhà Cung Cấp");

        txtmancc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmanccActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Tên Nhà Cung Cấp");

        txttenncc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttennccActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Địa Chỉ");

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("SĐT Liên Hệ");

        jButton1.setBackground(new java.awt.Color(153, 153, 255));
        jButton1.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/outline_add_black_24dp.png"))); // NOI18N
        jButton1.setText("Thêm NCC");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        txtsdtncc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsdtnccActionPerformed(evt);
            }
        });

        txtdiachincc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtdiachinccActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(153, 153, 255));
        jButton2.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jButton2.setForeground(new java.awt.Color(51, 51, 51));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/outline_cached_black_24dp.png"))); // NOI18N
        jButton2.setText("Sửa NCC");
        jButton2.setBorderPainted(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        Exit1.setBackground(new java.awt.Color(255, 51, 51));
        Exit1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Exit1.setText("Thoát");
        Exit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(153, 153, 255));
        jButton3.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/outline_remove_black_24dp.png"))); // NOI18N
        jButton3.setText("Xóa NCC");
        jButton3.setBorderPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(Exit1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(35, 35, 35)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtmancc)
                                    .addComponent(txttenncc)
                                    .addComponent(txtdiachincc)
                                    .addComponent(txtsdtncc, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap(24, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(31, 31, 31)
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(41, 41, 41)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmancc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(26, 26, 26)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txttenncc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtdiachincc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(txtsdtncc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 71, Short.MAX_VALUE)
                        .addComponent(Exit1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        ncctable.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        ncctable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nhà Cung Cấp", "Tên Nhà Cung Cấp", "Địa Chỉ", "SDT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ncctable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ncctableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ncctable);
        if (ncctable.getColumnModel().getColumnCount() > 0) {
            ncctable.getColumnModel().getColumn(1).setResizable(false);
            ncctable.getColumnModel().getColumn(1).setPreferredWidth(100);
            ncctable.getColumnModel().getColumn(2).setResizable(false);
            ncctable.getColumnModel().getColumn(2).setPreferredWidth(300);
        }

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/contact-icon.png"))); // NOI18N

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("NHÀ CUNG CẤP");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("THÔNG TIN NHÀ CUNG CẤP");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 790, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(40, 40, 40))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(373, 373, 373)
                .addComponent(jLabel1)
                .addGap(69, 69, 69)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 285, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel9)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel12))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                        .addComponent(jLabel8)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(71, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
        Connection con;
        PreparedStatement insert;
        
            
        private void reset(){
            txtmancc.setText("");
            txttenncc.setText("");
            txtdiachincc.setText("");
//            jComboBox3.setSelectedIndex(0);

            txtsdtncc.setText("");
        } 
        
        private void ShowNCC(){
            DefaultTableModel tableModel= (DefaultTableModel)ncctable.getModel();
            tableModel.setRowCount(0);
            Connection conn = connection.ConnectMySQL();
            Statement Stmt = null;
            ResultSet rs = null;
        try {
            CallableStatement cStmt = (CallableStatement) conn.prepareCall("SELECT `mancc`, `tenncc`, `diachi`, `sdt` FROM `nhacungcap`");
            rs = cStmt.executeQuery();
            while(rs.next()){
//                String id = rs.getString("id");
                String mancc = rs.getString("mancc");
                String tenncc = rs.getString("tenncc");
                String diachi = rs.getString("diachi");
                 String sdt = rs.getString("sdt");
//                 String makho = rs.getString("makho");
//                 String mancc = rs.getString("mancc");
//                String mausac = rs.getString("mausac");
//                        if(mausac.equals("0")){
//                            mausac = "Đỏ";
//                        }else if(mausac.equals("1")){
//                            mausac = "Đen";
//                        }else{
//                            mausac = "Trắng";
//                        }
//                String date = rs.getString("date");
                tableModel.addRow(new String[]{mancc, tenncc, diachi, sdt});
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        
        
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        boolean fieldEmpty = false;
//        if(txtmancc.getText().isEmpty()){
//            JOptionPane.showMessageDialog(null, "Mã Nhà Cung Cấp không được để trống");
//            fieldEmpty = true;
//        }
        if(txttenncc.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Tên Nhà Cung Cấp không được để trống");
            fieldEmpty = true;
        }
        if(txtsdtncc.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "SĐT Nhà Cung Cấp không được để trống");
            fieldEmpty = true;
        }
//        if(txtfaxncc.getText().isEmpty()){
//            JOptionPane.showMessageDialog(null, "Fax Nhà Cung Cấp không được để trống");
//            fieldEmpty = true;
//        }
        if(!fieldEmpty){ 

            try {    
        
//                String mancc =txtmancc.getText();
                String tenncc =txttenncc.getText();
//            String diachincc =txtdiachincc.getText();
                String diachincc = txtdiachincc.getText();
                String sdtncc =txtsdtncc.getText();
//                String fax =txtfaxncc.getText();
            
            
                Class.forName("com.mysql.jdbc.Driver");
                con = DriverManager.getConnection("jdbc:mysql://localhost/car","root","");
                insert = con.prepareStatement("  insert into nhacungcap(tenNCC,diachi,sdt)values(?,?,?)");
//                insert.setString(1,mancc);
                insert.setString(1,tenncc);
                insert.setString(2,diachincc);
                insert.setString(3,sdtncc);
//                insert.setString(5,fax);
           
                insert.executeUpdate();
                JOptionPane.showMessageDialog(this, "Thêm Nhà Cung Cấp thành công");
           
//                txtmancc.setText("");
                txttenncc.setText("");
//            txtdiachincc.setText("");
                txtdiachincc.setText("");
                txtsdtncc.setText("");
//                txtfaxncc.setText("");
                txtmancc.requestFocus();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(QuanLyNCC.class.getName()).log(Level.SEVERE, null, ex);
            } catch (SQLException ex) {
                 Logger.getLogger(QuanLyNCC.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        ShowNCC();
        reset();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void txttennccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttennccActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttennccActionPerformed

    private void txtmanccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmanccActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmanccActionPerformed

    private void txtsdtnccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsdtnccActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsdtnccActionPerformed

    private void txtdiachinccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtdiachinccActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtdiachinccActionPerformed

    private void ncctableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ncctableMouseClicked
        // TODO add your handling code here:
//        txtma.setEnabled(false);
//        txttenoto.setEnabled(false);
//        jComboBox3.setEnabled(false);
//        jButton1.setEnabled(false);
//        jButton4.setEnabled(true);
//        jButton3.setEnabled(true);
        DefaultTableModel tableModel= (DefaultTableModel)ncctable.getModel();
        String ma = tableModel.getValueAt(ncctable.getSelectedRow(), 0).toString();
        String ten = tableModel.getValueAt(ncctable.getSelectedRow(), 1).toString();
        String diachi = tableModel.getValueAt(ncctable.getSelectedRow(), 2).toString();
        String sdt = tableModel.getValueAt(ncctable.getSelectedRow(), 3).toString();
//        String mausac = tableModel.getValueAt(ncctable.getSelectedRow(), 4).toString();

        txtmancc.setText(ma);
        txttenncc.setText(ten);
        txtdiachincc.setText(diachi);
        txtsdtncc.setText(sdt);
//        jComboBox3.setSelectedItem(mausac);

    }//GEN-LAST:event_ncctableMouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        Connection conn = connection.ConnectMySQL();
        com.mysql.jdbc.Statement Stmt = null;
        String ten = String.valueOf(txttenncc.getText()).trim();
        String diachi = String.valueOf(txtdiachincc.getText()).trim();
        String sdt = String.valueOf(txtsdtncc.getText()).trim();
         String ma = String.valueOf(txtmancc.getText()).trim();

        
             boolean checktrung = true;
            try {
                


                
                
                
                com.mysql.jdbc.CallableStatement cSmt1 = (com.mysql.jdbc.CallableStatement) conn.prepareCall("select tenncc,diachi,sdt from nhacungcap WHERE tenncc=? AND diachi=? AND sdt=?");
                cSmt1.setString(1, ten);
                cSmt1.setString(2, diachi);
                cSmt1.setString(3, sdt);
                ResultSet rs_checkid = cSmt1.executeQuery();
                if(rs_checkid.next()){
                    JOptionPane.showMessageDialog(rootPane, "Đã Bị Trùng Với Thông Tin Cũ", "Erro", 1);
                    checktrung = false;
                }else{
                    try{
                        
                    Connection con1;
                    PreparedStatement insert;
                    Class.forName("com.mysql.jdbc.Driver");
                    con1 = DriverManager.getConnection("jdbc:mysql://localhost/car","root","");
                    insert = con1.prepareStatement("update nhacungcap set tenncc= ? ,  diachi= ? ,sdt= ? where mancc= ?");
                    insert.setString(1,ten);
                    insert.setString(2,diachi);
                    insert.setString(3,sdt);
                    insert.setString(4,ma);

                    insert.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Cập Nhật Thành Công");
                    
            
//                    TC_MaCL.setText("");
//                    TC_MaNV.setText("");
//                    TC_Ngay.setSelectedIndex(-1);
//                    TC_Thang.setSelectedIndex(-1);
//                    TC_Nam.setSelectedIndex(-1);
//                    TC_BoxBuoi.setSelectedIndex(-1);
//                    TC_ghichu.setText("");
 


                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        
        ShowNCC();
        reset();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void Exit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_Exit1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) ncctable.getModel();
        int selectedIndex = ncctable.getSelectedRow();

        try {
            Connection con1;
            PreparedStatement insert;

            String mancc = (String) ncctable.getValueAt(selectedIndex, 0);

            //int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());

            int dialogResult = JOptionPane.showConfirmDialog (rootPane, "Bạn Có Chắc Muốn Xóa Nhà Cung Cấp Này Chứ ?","Cảnh Báo",JOptionPane.YES_NO_OPTION);
            if(dialogResult == JOptionPane.YES_OPTION){
                // Saving code here

                Class.forName("com.mysql.jdbc.Driver");
                con1 = DriverManager.getConnection("jdbc:mysql://localhost/car","root","");
                insert = con1.prepareStatement("DELETE FROM `nhacungcap` WHERE mancc=?");

                insert.setString(1,mancc);
                insert.executeUpdate();
                JOptionPane.showMessageDialog(this, "Xóa Nhà Cung Cấp Thành Công");
                //                reset();
//                HienThiTTNV();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuanLySanPham.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySanPham.class.getName()).log(Level.SEVERE, null, ex);
        }

        ShowNCC();
        reset();
    }//GEN-LAST:event_jButton3ActionPerformed

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(QuanLyNCC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLyNCC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLyNCC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLyNCC.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QuanLyNCC().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exit1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable ncctable;
    private javax.swing.JTextField txtdiachincc;
    private javax.swing.JTextField txtmancc;
    private javax.swing.JTextField txtsdtncc;
    private javax.swing.JTextField txttenncc;
    // End of variables declaration//GEN-END:variables
}
