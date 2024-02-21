package GiaoDien;


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
public class XuatKho extends javax.swing.JFrame {
    
    MySQLConnection connection = new MySQLConnection();
    DefaultTableModel tableModel;
    /**
     * Creates new form AddInventory
     */
    public XuatKho() {
        initComponents();
        setTitle("Xuất Kho");
//        autoID();
//        kho();
//        ncc();
        date();
        ShowOto();
        ShowXuatKho();
        jButton2.setEnabled(false);
//        branch();
//        ShowNCC();
//        ShowNhapKho();
//        jButton4.setEnabled(false);
        txtmaoto.setEnabled(false);
        txttonkho.setEnabled(false);
//table_update();
       
//        model = (DefaultTableModel) jTable1.getModel();
//        showTable();
    }
    
    Connection con;
    PreparedStatement insert;
    ResultSet rs1;
    
//    public void branch()
//    {
//        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            con = DriverManager.getConnection("jdbc:mysql://localhost/car","root","");
//            insert = con.prepareStatement("SELECT * FROM `chitietphieuxuat`");
//            Statement s = con.createStatement();
//            ResultSet rs = insert.executeQuery();
//            jComboBox1.removeAllItems();
//             while(rs.next())
//             {
//               jComboBox1.addItem(rs.getString(3) );        
//             }
//            
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(XuatKho.class.getName()).log(Level.SEVERE, null, ex);
//        } catch (SQLException ex) {
//            Logger.getLogger(XuatKho.class.getName()).log(Level.SEVERE, null, ex);
//        }   
//    }
    
    private void reset(){
//        txtma.setText("");
        txtmaoto.setText("");
//        txtmancc.setText("");
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
    private void ShowOto(){
            DefaultTableModel tableModel= (DefaultTableModel)ototable.getModel();
            tableModel.setRowCount(0);
            Connection conn = connection.ConnectMySQL();
            Statement Stmt = null;
            ResultSet rs = null;
        try {
            CallableStatement cStmt = (CallableStatement) conn.prepareCall("SELECT `maoto`, `tenoto`, `donvitinh`, `tonkho`,  `mausac` FROM `oto`");
            rs = cStmt.executeQuery();
            while(rs.next()){
//                String id = rs.getString("id");
                String maoto = rs.getString("maoto");
                String tenoto = rs.getString("tenoto");
                String donvitinh = rs.getString("donvitinh");
                 String tonkho = rs.getString("tonkho");
//                 String makho = rs.getString("makho");
//                 String mancc = rs.getString("mancc");
                String mausac = rs.getString("mausac");
                        if(mausac.equals("0")){
                            mausac = "Đỏ";
                        }else if(mausac.equals("1")){
                            mausac = "Đen";
                        }else{
                            mausac = "Trắng";
                        }
//                String date = rs.getString("date");
                tableModel.addRow(new String[]{maoto, tenoto, donvitinh, tonkho,mausac});
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
        

        private void ShowXuatKho(){
            DefaultTableModel tableModel= (DefaultTableModel)xuatkhotable.getModel();
            tableModel.setRowCount(0);
            Connection conn = connection.ConnectMySQL();
            Statement Stmt = null;
            ResultSet rs = null;
        try {
            CallableStatement cStmt = (CallableStatement) conn.prepareCall("SELECT c.sophieuxuat, c.maoto,o.tenoto,o.mausac,  c.ngayxuat, c.soluongxuat\n" +
                                                        "FROM chitietphieuxuat as c,oto as o\n" +
                                                        "WHERE c.maoto=o.maoto  ORDER BY sophieuxuat");
            rs = cStmt.executeQuery();
            while(rs.next()){
//                String id = rs.getString("id");
                String sophieunhap = rs.getString("sophieuxuat");
                String maoto = rs.getString("maoto");
                String tenoto = rs.getString("tenoto");
                String mausac = rs.getString("mausac");
                        if(mausac.equals("0")){
                            mausac = "Đỏ";
                        }else if(mausac.equals("1")){
                            mausac = "Đen";
                        }else{
                            mausac = "Trắng";
                        }
//                String tenncc = rs.getString("tenncc");
                 String ngayxuat = rs.getString("ngayxuat");
                 String soluongxuat = rs.getString("soluongxuat");
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
                tableModel.addRow(new String[]{sophieunhap,maoto,tenoto,mausac, ngayxuat,soluongxuat});
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
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
        jPanel3 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        txtsoluong = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtmaoto = new javax.swing.JTextField();
        txtdate = new javax.swing.JLabel();
        txttonkho = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ototable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        xuatkhotable = new javax.swing.JTable();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
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
        jLabel1.setText("XUẤT KHO");

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setToolTipText("");
        jPanel2.setPreferredSize(new java.awt.Dimension(900, 600));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setToolTipText("");
        jPanel3.setEnabled(false);

        jPanel5.setBackground(new java.awt.Color(255, 153, 51));
        jPanel5.setPreferredSize(new java.awt.Dimension(361, 272));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Số Lượng Muốn Xuất");

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
        jLabel10.setText("Thời Gian");

        txtmaoto.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtmaoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmaotoActionPerformed(evt);
            }
        });

        txtdate.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        txtdate.setForeground(new java.awt.Color(255, 255, 255));
        txtdate.setText("jLabel2");

        txttonkho.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txttonkho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttonkhoActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("Số Lượng Tồn");

        jButton1.setBackground(new java.awt.Color(0, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/outline_add_black_24dp.png"))); // NOI18N
        jButton1.setText("Xuất Kho");
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
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(txtdate))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtmaoto, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txttonkho, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtsoluong, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(99, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtmaoto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txttonkho, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtdate))
                .addGap(28, 28, 28)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Xuất Kho");

        ototable.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        ototable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên Xe", "Giá", "Số lượng tồn", "Màu"
            }
        ));
        ototable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ototableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(ototable);

        xuatkhotable.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        xuatkhotable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Mã Xe", "Tên Xe", "Màu Sắc", "Thời Gian", "Số Lượng"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, true, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        xuatkhotable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                xuatkhotableMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(xuatkhotable);
        if (xuatkhotable.getColumnModel().getColumnCount() > 0) {
            xuatkhotable.getColumnModel().getColumn(4).setResizable(false);
            xuatkhotable.getColumnModel().getColumn(4).setPreferredWidth(200);
        }

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("THÔNG TIN XE");

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("THÔNG TIN XUẤT KHO");

        jButton2.setBackground(new java.awt.Color(0, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/outline_remove_black_24dp.png"))); // NOI18N
        jButton2.setText("Xóa Phiếu Xuất");
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
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(Exit1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(67, 67, 67)
                                .addComponent(Exit2, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(jButton2))
                            .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 531, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 790, Short.MAX_VALUE)
                        .addComponent(jScrollPane2))
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(80, 80, 80))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addGap(28, 28, 28)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Exit1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Exit2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(41, 41, 41))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
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

        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/dollar-icon.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(517, 517, 517)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1569, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1569, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 638, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:

            String maoto = txtmaoto.getText();
            String tonkho = txttonkho.getText();
            String soluong =  txtsoluong.getText();
            String date = txtdate.getText();
            
            if(maoto.equals("")|| soluong.equals("") || date.equals("")){
             JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ");
         }
         else{ 
                int tonkho1 = Integer.parseInt(tonkho);
                int soluong1 = Integer.parseInt(soluong);
                if(tonkho1>=soluong1){
                try {    
                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost/car","root","");
                    con.setAutoCommit(false);

                    PreparedStatement st1=con.prepareStatement("update oto set tonkho=tonkho-? where maoto=?");
                    st1.setString(1,soluong);
                    st1.setString(2,maoto);
                    st1.executeUpdate( );



                    PreparedStatement st3=con.prepareStatement("insert into chitietphieuxuat(maoto,ngayxuat,soluongxuat) values(?,?,?)");
                    st3.setString(1,maoto);
        //	    st3.setString(2,mancc);
                    st3.setString(2,date);
                    st3.setString(3,soluong);
                    st3.executeUpdate( );     
                    JOptionPane.showMessageDialog(this, "Xuất Kho Thành Công");

                    ShowXuatKho();
                    ShowOto();
                    date();
                    con.commit();

                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(XuatKho.class.getName()).log(Level.SEVERE, null, ex);
                }
                catch (SQLException ex) {

                try {
                       con.rollback();
        //                 JOptionPane.showMessageDialog(this, "Transanction Failed");

                    } catch (SQLException ex1) {
                        Logger.getLogger(XuatKho.class.getName()).log(Level.SEVERE, null, ex1);
                    }
                }
                    
                }else{
                    JOptionPane.showMessageDialog(this, "Số Lượng Xuất Đã Lớn Hơn Trong Tồn Kho!!Vui Lòng Nhập Lại");
                }
            }
            ShowXuatKho();
                    ShowOto();
                    date();
//            ShowNhapKho();
//       }
//      else
//       {
//         JOptionPane.showMessageDialog(null, "Xuất Kho Thành Công");
//         
//        }               
//                       
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

    private void Exit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_Exit1ActionPerformed

    private void ototableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ototableMouseClicked
        // TODO add your handling code here:
        date();
        
                DefaultTableModel tableModel= (DefaultTableModel)ototable.getModel();
                String maoto = tableModel.getValueAt(ototable.getSelectedRow(), 0).toString();
//        String ten = tableModel.getValueAt(ototable.getSelectedRow(), 1).toString();
//        String gia = tableModel.getValueAt(ototable.getSelectedRow(), 2).toString();
                String tonkho = tableModel.getValueAt(ototable.getSelectedRow(), 3).toString();
//        String mausac = tableModel.getValueAt(ototable.getSelectedRow(), 4).toString();

                txttonkho.setText(tonkho);
                txtmaoto.setText(maoto);

    }//GEN-LAST:event_ototableMouseClicked

    private void xuatkhotableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_xuatkhotableMouseClicked
        // TODO add your handling code here:
         date();
         jButton2.setEnabled(true);
        jButton1.setEnabled(false);
                DefaultTableModel tableModel= (DefaultTableModel)xuatkhotable.getModel();
                String maoto = tableModel.getValueAt(xuatkhotable.getSelectedRow(), 1).toString();
//        String ten = tableModel.getValueAt(ototable.getSelectedRow(), 1).toString();
//        String gia = tableModel.getValueAt(ototable.getSelectedRow(), 2).toString();
                String tonkho = tableModel.getValueAt(xuatkhotable.getSelectedRow(), 5).toString();
//        String mausac = tableModel.getValueAt(ototable.getSelectedRow(), 4).toString();

                txttonkho.setText(tonkho);
                txtmaoto.setText(maoto);
                txtsoluong.setText("");
    }//GEN-LAST:event_xuatkhotableMouseClicked

    private void txttonkhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttonkhoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttonkhoActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        String maoto = txtmaoto.getText();
            String tonkho = txttonkho.getText();
            String soluong =  txtsoluong.getText();
            String date = txtdate.getText();
        DefaultTableModel model = (DefaultTableModel) xuatkhotable.getModel();
        int selectedIndex = xuatkhotable.getSelectedRow();

        try {
            
            Connection con1;
            PreparedStatement insert;

            String maxuat = (String) xuatkhotable.getValueAt(selectedIndex, 0);

            //int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());

            int dialogResult = JOptionPane.showConfirmDialog (rootPane, "Bạn Có Chắc Muốn Xóa Xe xuất Này Không Này Chứ ?","Cảnh Báo",JOptionPane.YES_NO_OPTION);
            if(dialogResult == JOptionPane.YES_OPTION){
                // Saving code here
                Class.forName("com.mysql.jdbc.Driver");
                    con1 = DriverManager.getConnection("jdbc:mysql://localhost/car","root","");
                    insert = con1.prepareStatement("update oto set tonkho=tonkho+? where maoto= ?");
                    insert.setString(1,tonkho);
                    insert.setString(2,maoto);
                    

                    insert.executeUpdate();
                
                
                Class.forName("com.mysql.jdbc.Driver");
                con1 = DriverManager.getConnection("jdbc:mysql://localhost/car","root","");
                insert = con1.prepareStatement("DELETE FROM `chitietphieuxuat` WHERE sophieuxuat=?");

                insert.setString(1,maxuat);
                insert.executeUpdate();
                
                
                    
                
                

                JOptionPane.showMessageDialog(this, "Xóa Xe Khỏi Phiếu Xuất Thành Công");
                //                reset();
//                HienThiTTNV();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuanLySanPham.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySanPham.class.getName()).log(Level.SEVERE, null, ex);
        }
        ShowXuatKho();
        ShowOto();
         date();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void Exit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit2ActionPerformed
        // TODO add your handling code here:
        date();
        ShowOto();
        ShowXuatKho();
        reset();
        jButton2.setEnabled(false);
        jButton1.setEnabled(true);
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
            java.util.logging.Logger.getLogger(XuatKho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(XuatKho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(XuatKho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(XuatKho.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
                new XuatKho().setVisible(true);

            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exit1;
    private javax.swing.JButton Exit2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
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
    private javax.swing.JTable ototable;
    private javax.swing.JLabel txtdate;
    private javax.swing.JTextField txtmaoto;
    private javax.swing.JTextField txtsoluong;
    private javax.swing.JTextField txttonkho;
    private javax.swing.JTable xuatkhotable;
    // End of variables declaration//GEN-END:variables
}
