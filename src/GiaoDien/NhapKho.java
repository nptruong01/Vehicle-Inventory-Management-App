package GiaoDien;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */



import Connect.MySQLConnection;
import java.sql.CallableStatement;
import javax.swing.JOptionPane;
import java.util.*;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import static java.util.Collections.list;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author MSI-VN
 */
public class NhapKho extends javax.swing.JFrame {
    
    MySQLConnection connection = new MySQLConnection();
    DefaultTableModel tableModel;
    /**
     * Creates new form AddInventory
     */
    public NhapKho() {
        initComponents();
        setTitle("Nhập Kho");
//        autoID();
//        kho();
//        ncc();
        date();
        ShowOto();
        ShowNCC();
        ShowNhapKho();
//        jButton4.setEnabled(false);
//        jButton3.setEnabled(false);
//table_update();
       
//        model = (DefaultTableModel) jTable1.getModel();
//        showTable();
    }
    
    Connection con;
    PreparedStatement insert;
    ResultSet rs1;
    
    
    private void reset(){
//        txtma.setText("");
        txtmaoto.setText("");
        txtmancc.setText("");
        txtsoluong.setText("");
//        jComboBox3.setSelectedIndex(0);

        txtdate.setText("");
    } 
//    
//        private String chuyendoiMau(String Mau){
//        String mau = "";
//        switch (Mau){
//            case "Đỏ": {
//                mau = "0";
//                break;
//            }
//            case "Đen":{
//                mau = "1";
//                break;
//            }
//            case "Trắng":{
//                mau = "2";
//                break;
//            }
//        }
//        return mau;
//    }
    
    public void date()
    {

        
        
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);
     
        txtdate.setText(date);
 
    }
        
//        public void autoID()
//    {
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            con = DriverManager.getConnection("jdbc:sqlserver://localhost; databaseName=khooto; user=sa;password=123456");
//            Statement s = con.createStatement();
//            
//            ResultSet rs =s.executeQuery("select Max(maoto)as 'MAX(maoto)' from oto2 ");
//            rs.next();
//            rs.getString("MAX(maoto)");
//            if (rs.getString("MAX(maoto)") == null) {
//                txtmaoto.setText("XE001");     
//            } else {
//                long id = Long.parseLong(rs.getString("MAX(maoto)").substring(2, rs.getString("MAX(maoto)").length()));
//                id++;
//                txtmaoto.setText("Xe" + String.format("%03d", id));
//            }
//            
//            
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ThemSanPham.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(ThemSanPham.class.getName()).log(Level.SEVERE, null, ex);
//        }
//    }
        
//        public void kho()
//    {
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            con = DriverManager.getConnection("jdbc:sqlserver://localhost; databaseName=khooto; user=sa;password=123456");
//            insert = con.prepareStatement("SELECT * FROM kho");
//            Statement s = con.createStatement();
//            ResultSet rs = insert.executeQuery();
//            jComboBox1.removeAllItems();
//             while(rs.next())
//             {
//               jComboBox1.addItem(rs.getString(1) );        
//             }
//            
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ThemSanPham.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(ThemSanPham.class.getName()).log(Level.SEVERE, null, ex);
//        }   
//    }
    
//        public void ncc()
//    {
//        try {
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            con = DriverManager.getConnection("jdbc:sqlserver://localhost; databaseName=khooto; user=sa;password=123456");
//            insert = con.prepareStatement("SELECT * FROM NhaCungCap");
//            Statement s = con.createStatement();
//            ResultSet rs = insert.executeQuery();
//            jComboBox2.removeAllItems();
//             while(rs.next())
//             {
//               jComboBox2.addItem(rs.getString(1) );        
//             }
//            
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(ThemSanPham.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(ThemSanPham.class.getName()).log(Level.SEVERE, null, ex);
//        }   
//    }
        private void ShowOto(){
            DefaultTableModel tableModel= (DefaultTableModel)ototable.getModel();
            tableModel.setRowCount(0);
            Connection conn = connection.ConnectMySQL();
            Statement Stmt = null;
            ResultSet rs = null;
        try {
            CallableStatement cStmt = (CallableStatement) conn.prepareCall("SELECT `maoto`, `tenoto`,mausac FROM `oto`");
            rs = cStmt.executeQuery();
            while(rs.next()){
//                String id = rs.getString("id");
                String maoto = rs.getString("maoto");
                String tenoto = rs.getString("tenoto");
//                String donvitinh = rs.getString("donvitinh");
//                 String tonkho = rs.getString("tonkho");
////                 String makho = rs.getString("makho");
////                 String mancc = rs.getString("mancc");
                String mausac = rs.getString("mausac");
                        if(mausac.equals("0")){
                            mausac = "Đỏ";
                        }else if(mausac.equals("1")){
                            mausac = "Đen";
                        }else{
                            mausac = "Trắng";
                        }
////                String date = rs.getString("date");
                tableModel.addRow(new String[]{maoto, tenoto,mausac});
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
                private void ShowNCC(){
            DefaultTableModel tableModel= (DefaultTableModel)ncctable.getModel();
            tableModel.setRowCount(0);
            Connection conn = connection.ConnectMySQL();
            Statement Stmt = null;
            ResultSet rs = null;
        try {
            CallableStatement cStmt = (CallableStatement) conn.prepareCall("SELECT `mancc`, `tenncc` FROM `nhacungcap`");
            rs = cStmt.executeQuery();
            while(rs.next()){
//                String id = rs.getString("id");
                String mancc = rs.getString("mancc");
                String tenncc = rs.getString("tenncc");
//                String donvitinh = rs.getString("donvitinh");
//                 String tonkho = rs.getString("tonkho");
////                 String makho = rs.getString("makho");
////                 String mancc = rs.getString("mancc");
//                String mausac = rs.getString("mausac");
//                        if(mausac.equals("0")){
//                            mausac = "Đỏ";
//                        }else if(mausac.equals("1")){
//                            mausac = "Đen";
//                        }else{
//                            mausac = "Trắng";
//                        }
////                String date = rs.getString("date");
                tableModel.addRow(new String[]{mancc, tenncc});
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        private void ShowNhapKho(){
            DefaultTableModel tableModel= (DefaultTableModel)nhapkhotable.getModel();
            tableModel.setRowCount(0);
            Connection conn = connection.ConnectMySQL();
            Statement Stmt = null;
            ResultSet rs = null;
        try {
            CallableStatement cStmt = (CallableStatement) conn.prepareCall("SELECT c.sophieunhap, o.tenoto,o.mausac, ncc.tenncc, c.ngaynhap, c.soluongnhap \n" +
                                                                            "FROM chitietphieunhap as c,oto as o,nhacungcap as ncc \n" +
                                                                            "WHERE c.maoto=o.maoto AND c.mancc=ncc.mancc ORDER BY sophieunhap");
            rs = cStmt.executeQuery();
            while(rs.next()){
//                String id = rs.getString("id");
                String sophieunhap = rs.getString("sophieunhap");
                String maoto = rs.getString("tenoto");
                String mausac = rs.getString("mausac");
                        if(mausac.equals("0")){
                            mausac = "Đỏ";
                        }else if(mausac.equals("1")){
                            mausac = "Đen";
                        }else{
                            mausac = "Trắng";
                        }
                String mancc = rs.getString("tenncc");
                String ngaynhap = rs.getString("ngaynhap");
                String soluongnhap = rs.getString("soluongnhap");

                tableModel.addRow(new String[]{sophieunhap,maoto,mausac,mancc, ngaynhap,soluongnhap});
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//              private void table_update() {
//
//                  int CC;
//        
//                  try {
//            
//            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
//            con = DriverManager.getConnection("jdbc:sqlserver://localhost; databaseName=khooto; user=sa;password=123456");
//            
//            insert = con.prepareStatement("SELECT * FROM oto2");
//             ResultSet Rs = insert.executeQuery();
//            
//   
//            ResultSetMetaData RSMD = Rs.getMetaData();
//            CC = RSMD.getColumnCount();
//            DefaultTableModel DFT = (DefaultTableModel) ototable.getModel();
//            DFT.setRowCount(0);
//
//            while (Rs.next()) {
//                Vector v2 = new Vector();
//           
//                for (int ii = 1; ii <= CC; ii++) {
//                    v2.add(Rs.getString("id"));
//                    v2.add(Rs.getString("maoto"));
//                    v2.add(Rs.getString("tenoto"));
//                     v2.add(Rs.getString("donvitinh"));
//                     v2.add(Rs.getString("tonkho"));
//                    v2.add(Rs.getString("makho"));
//                    v2.add(Rs.getString("mancc"));
//                     v2.add(Rs.getString("mausac"));
//                     v2.add(Rs.getString("date"));
// 
//                    
//                    
//                    
//                    
//                    
//                    
//                    
//                }
//
//                DFT.addRow(v2);
//            }
//        } catch (Exception e) {
//        }
//    }
        
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
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtsoluong = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtmaoto = new javax.swing.JTextField();
        txtmancc = new javax.swing.JTextField();
        txtdate = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ototable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        ncctable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        nhapkhotable = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        Exit1 = new javax.swing.JButton();
        Exit2 = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Add Inventory in Warehouse");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setToolTipText("");
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 709));

        jLabel1.setFont(new java.awt.Font("Times New Roman", 3, 48)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("NHẬP KHO");

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setToolTipText("");
        jPanel2.setPreferredSize(new java.awt.Dimension(900, 600));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setToolTipText("");
        jPanel3.setEnabled(false);

        jPanel5.setBackground(new java.awt.Color(255, 153, 0));
        jPanel5.setPreferredSize(new java.awt.Dimension(361, 272));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Số Lượng");

        txtsoluong.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtsoluong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtsoluongActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Mã Oto");

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Mã Nhà Cung Cấp");

        txtmaoto.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtmaoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmaotoActionPerformed(evt);
            }
        });

        txtmancc.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtmancc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmanccActionPerformed(evt);
            }
        });

        txtdate.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtdate.setForeground(new java.awt.Color(255, 255, 255));
        txtdate.setText("jLabel2");

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Ngày Giờ");

        jButton1.setBackground(new java.awt.Color(114, 114, 244));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/outline_add_black_24dp.png"))); // NOI18N
        jButton1.setText("Nhập");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdate)
                    .addComponent(txtmaoto, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmancc, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(44, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmaoto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtmancc, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdate))
                .addGap(51, 51, 51)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel5.setBackground(new java.awt.Color(255, 51, 51));
        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("NHẬP KHO");

        ototable.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        ototable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Oto", "Tên Xe Oto", "Màu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ototable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ototableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ototable);
        if (ototable.getColumnModel().getColumnCount() > 0) {
            ototable.getColumnModel().getColumn(1).setResizable(false);
            ototable.getColumnModel().getColumn(1).setPreferredWidth(300);
        }

        ncctable.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        ncctable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NCC", "Tên Nhà Cung Cấp"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false
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
        jScrollPane2.setViewportView(ncctable);
        if (ncctable.getColumnModel().getColumnCount() > 0) {
            ncctable.getColumnModel().getColumn(1).setResizable(false);
            ncctable.getColumnModel().getColumn(1).setPreferredWidth(300);
        }

        nhapkhotable.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        nhapkhotable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Nhập", "Tên Oto", "Màu Sắc", "Tên Nhà Cung Cấp", "Ngày Nhập", "Số Lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        nhapkhotable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                nhapkhotableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(nhapkhotable);
        if (nhapkhotable.getColumnModel().getColumnCount() > 0) {
            nhapkhotable.getColumnModel().getColumn(1).setResizable(false);
            nhapkhotable.getColumnModel().getColumn(1).setPreferredWidth(100);
            nhapkhotable.getColumnModel().getColumn(2).setResizable(false);
            nhapkhotable.getColumnModel().getColumn(2).setPreferredWidth(100);
            nhapkhotable.getColumnModel().getColumn(3).setResizable(false);
            nhapkhotable.getColumnModel().getColumn(3).setPreferredWidth(200);
            nhapkhotable.getColumnModel().getColumn(4).setResizable(false);
            nhapkhotable.getColumnModel().getColumn(4).setPreferredWidth(200);
        }

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("THÔNG TIN NHẬP KHO");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("THÔNG TIN XE");

        jLabel11.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("THÔNG TIN NHÀ CUNG CẤP");

        Exit1.setBackground(new java.awt.Color(255, 51, 51));
        Exit1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Exit1.setText("Thoát");
        Exit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit1ActionPerformed(evt);
            }
        });

        Exit2.setBackground(new java.awt.Color(102, 255, 102));
        Exit2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        Exit2.setText("Reset");
        Exit2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Exit2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(389, 389, 389))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                .addComponent(Exit2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(119, 119, 119)
                                .addComponent(Exit1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(129, 129, 129)))))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel11)
                        .addGap(93, 93, 93))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(0, 18, Short.MAX_VALUE)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 863, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel3Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 376, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(76, 76, 76))))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 397, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(29, 29, 29)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Exit1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Exit2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/pencil-icon.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(444, 444, 444)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(99, 99, 99)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1600, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 661, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1600, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 746, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
////        String ma = txtma.getText();
//        String maoto = txtmaoto.getText();
//        String mancc = txtmancc.getText();
//        String soluong =  txtsoluong.getText();
//        String date = txtdate.getText();
//            try {    
//            Class.forName("com.mysql.jdbc.Driver");
//            con = DriverManager.getConnection("jdbc:mysql://localhost/car","root","");
//            con.setAutoCommit(false);
//            
//            PreparedStatement st1=con.prepareStatement("update oto set tonkho=tonkho+? where maoto=?");
//	    st1.setString(1,soluong);
//	    st1.setString(2,maoto);
//	    st1.executeUpdate( );
//                             
////            PreparedStatement st2=con.prepareStatement("update account set balance=balance+? where acc_id=?");
////	    st2.setString(1,amount);
////	    st2.setString(2,toaccount);
////	    st2.executeUpdate( );
//                
//            PreparedStatement st3=con.prepareStatement("insert into transfer(maoto,mancc,ngaynhap,soluongnhap) values(?,?,?,?)");
//	    st3.setString(1,maoto);
//	    st3.setString(2,mancc);
//            st3.setString(3,date);
//	    st3.setString(4,soluong);
//	    st3.executeUpdate( );     
//            JOptionPane.showMessageDialog(this, "Nhập Kho Thành Công");
//                        
////            txtfacc.setText("");
////            txtemailto.setText("");
////            txttoaccount.setText("");
////            txtamount.setText("");
////            txtbal.setText("");
////            txtcode.setText("");
//                  
//            con.commit();
//
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(QuanLySanPham.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        catch (SQLException ex) {
//          
//            try {
//               con.rollback();
//                 JOptionPane.showMessageDialog(this, "Transanction Failed");
//               
//            } catch (SQLException ex1) {
//                Logger.getLogger(QuanLyNhap.class.getName()).log(Level.SEVERE, null, ex1);
//            }
//        }
            
//        try {
//            
//            Class.forName("com.mysql.jdbc.Driver");
//            con = DriverManager.getConnection("jdbc:mysql://localhost/car","root","");
//            insert = con.prepareStatement("SELECT maoto,mancc,ngaynhap,soluongnhap FROM chitietphieunhap WHERE  maoto=? and mancc=? and ngaynhap=? and soluongnhap=? ");                           
//            insert.setString(1, txtma.getText());
//            insert.setString(2, txtmaoto.getText());
//            insert.setString(3, txtmancc.getText());
//            insert.setString(4, txtdate.getText());
//            insert.setString(5, txtsoluong.getText());
//            rs1=insert.executeQuery();
//     if(rs1.next())
//       {
            String maoto = txtmaoto.getText();
            String mancc = txtmancc.getText();
            String soluong =  txtsoluong.getText();
            String date = txtdate.getText();
    try {    
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/car","root","");
            con.setAutoCommit(false);
            
            PreparedStatement st1=con.prepareStatement("update oto set tonkho=tonkho+? where maoto=?");
	    st1.setString(1,soluong);
	    st1.setString(2,maoto);
	    st1.executeUpdate( );
                             
//            PreparedStatement st2=con.prepareStatement("update account set balance=balance+? where acc_id=?");
//	    st2.setString(1,amount);
//	    st2.setString(2,toaccount);
//	    st2.executeUpdate( );
                
            PreparedStatement st3=con.prepareStatement("insert into chitietphieunhap(maoto,mancc,ngaynhap,soluongnhap) values(?,?,?,?)");
	    st3.setString(1,maoto);
	    st3.setString(2,mancc);
            st3.setString(3,date);
	    st3.setString(4,soluong);
	    st3.executeUpdate( );     
            JOptionPane.showMessageDialog(this, "Nhập Kho Thành Công");
//	    st3.executeUpdate( );     
//            JOptionPane.showMessageDialog(this, "Chuyển Khoản Thành Công");
                        
//            txtfacc.setText("");
//            txtemailto.setText("");
//            txttoaccount.setText("");
//            txtamount.setText("");
//            txtbal.setText("");
//            txtcode.setText("");
                  
            con.commit();

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NhapKho.class.getName()).log(Level.SEVERE, null, ex);
        }
        catch (SQLException ex) {
          
        try {
               con.rollback();
                 JOptionPane.showMessageDialog(this, "Nhập Kho Thất Bại");
               
            } catch (SQLException ex1) {
                Logger.getLogger(NhapKho.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
            ShowNhapKho();
//       }
//      else
//       {
//         JOptionPane.showMessageDialog(null, "Code không đúng. Chuyển Khoản Thất Bại");
//         
//        }               
                       
//        } catch (Exception e) {
//            
//              System.out.println("Failed " + e);
//            
//        }
        

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txtsoluongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtsoluongActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtsoluongActionPerformed

    private void txtmaotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmaotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmaotoActionPerformed

    private void ototableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ototableMouseClicked
        // TODO add your handling code here:
//        txtma.setEnabled(false);
//        txtmaoto.setEnabled(false);
//        jComboBox3.setEnabled(false);
//        jButton1.setEnabled(false);
//        jButton4.setEnabled(true);
//        jButton3.setEnabled(true);
        DefaultTableModel tableModel= (DefaultTableModel)ototable.getModel();
        String maoto = tableModel.getValueAt(ototable.getSelectedRow(), 0).toString();
//        String ten = tableModel.getValueAt(ototable.getSelectedRow(), 1).toString();
//        String gia = tableModel.getValueAt(ototable.getSelectedRow(), 2).toString();
//        String tonkho = tableModel.getValueAt(ototable.getSelectedRow(), 3).toString();
//        String mausac = tableModel.getValueAt(ototable.getSelectedRow(), 4).toString();

//        txtma.setText(maoto);
        txtmaoto.setText(maoto);
//        txtgia.setText(gia);
//        txtsoluong.setText(tonkho);
//        jComboBox3.setSelectedItem(mausac);
        
    }//GEN-LAST:event_ototableMouseClicked

    private void Exit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_Exit1ActionPerformed

    private void ncctableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ncctableMouseClicked
        // TODO add your handling code here:
                DefaultTableModel tableModel= (DefaultTableModel)ncctable.getModel();
        String mancc = tableModel.getValueAt(ncctable.getSelectedRow(), 0).toString();
//        String ten = tableModel.getValueAt(ototable.getSelectedRow(), 1).toString();
//        String gia = tableModel.getValueAt(ototable.getSelectedRow(), 2).toString();
//        String tonkho = tableModel.getValueAt(ototable.getSelectedRow(), 3).toString();
//        String mausac = tableModel.getValueAt(ototable.getSelectedRow(), 4).toString();

//        txtma.setText(maoto);
        txtmancc.setText(mancc);
    }//GEN-LAST:event_ncctableMouseClicked

    private void txtmanccActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmanccActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmanccActionPerformed

    private void nhapkhotableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_nhapkhotableMouseClicked
        // TODO add your handling code here:
//        txtma.setEnabled(false);
//        txttenoto.setEnabled(false);
//        jComboBox3.setEnabled(false);
//        jButton1.setEnabled(false);
//        jButton4.setEnabled(true);
//        jButton3.setEnabled(true);
//        DefaultTableModel tableModel= (DefaultTableModel)ototable.getModel();
//        String ma = tableModel.getValueAt(ototable.getSelectedRow(), 0).toString();
//        String ten = tableModel.getValueAt(ototable.getSelectedRow(), 1).toString();
//        String gia = tableModel.getValueAt(ototable.getSelectedRow(), 2).toString();
//        String tonkho = tableModel.getValueAt(ototable.getSelectedRow(), 3).toString();
//        String mausac = tableModel.getValueAt(ototable.getSelectedRow(), 4).toString();
//
//        txtma.setText(ma);
//        txttenoto.setText(ten);
//        txtgia.setText(gia);
//        txtsoluong.setText(tonkho);
//        jComboBox3.setSelectedItem(mausac);

    }//GEN-LAST:event_nhapkhotableMouseClicked

    private void Exit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit2ActionPerformed
        // TODO add your handling code here:
        date();
        ShowOto();
        ShowNCC();
        ShowNhapKho();
        reset();
    }//GEN-LAST:event_Exit2ActionPerformed

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
            java.util.logging.Logger.getLogger(NhapKho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NhapKho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NhapKho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhapKho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NhapKho().setVisible(true);

            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exit1;
    private javax.swing.JButton Exit2;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable ncctable;
    private javax.swing.JTable nhapkhotable;
    private javax.swing.JTable ototable;
    private javax.swing.JLabel txtdate;
    private javax.swing.JTextField txtmancc;
    private javax.swing.JTextField txtmaoto;
    private javax.swing.JTextField txtsoluong;
    // End of variables declaration//GEN-END:variables
}
