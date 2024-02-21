package GiaoDien;



import Connect.MySQLConnection;
import com.ibm.icu.text.RuleBasedNumberFormat;
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
public class QuanLySanPham extends javax.swing.JFrame {
    
    MySQLConnection connection = new MySQLConnection();
    DefaultTableModel tableModel;
    /**
     * Creates new form AddInventory
     */
    public QuanLySanPham() {
        initComponents();
        setTitle("Quản Lý Thông Tin Xe Hơi");
//        autoID();
//        kho();
//        ncc();
//        date();
        ShowOto();
        jButton4.setEnabled(false);
        jButton3.setEnabled(false);
        jLabel3.setEnabled(false);
        txtma.setEnabled(false);
//        jLabel8.setEnabled(false);
//        txtsoluong.setEnabled(false);
//table_update();
       
//        model = (DefaultTableModel) jTable1.getModel();
//        showTable();
    }
    
    Connection con;
    PreparedStatement insert;
    
    
    private void reset(){
        txtma.setText("");
        txtloai.setSelectedIndex(0);
        txthang.setSelectedIndex(0);
        txttenoto.setText("");
        txtgia.setText("");
        jComboBox3.setSelectedIndex(0);

//        txtsoluong.setText("");
    } 
    
        private String chuyendoiMau(String Mau){
            String mau = "";
            switch (Mau){
                case "Đỏ": {
                    mau = "0";
                    break;
                }
                case "Đen":{
                    mau = "1";
                    break;
                }
                case "Trắng":{
                    mau = "2";
                    break;
                }
            }
            return mau;
            }
        
        private String chuyendoiHang(String Hang){
            String hang = "";
            switch (Hang){
                case "Ford": {
                    hang = "F";
                    break;
                }
                case " Lexus":{
                    hang = "L";
                    break;
                }
                case "Hyunda":{
                    hang = "H";
                    break;
                }
                case "Toyota":{
                    hang = "T";
                    break;
                }
                case "Kia":{
                    hang = "K";
                    break;
                }
            }
            return hang;
            }

//    public void date()
//    {
//
//        
//        
//        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
//        LocalDateTime now = LocalDateTime.now();
//        String date = dtf.format(now);
//     
//        txtdate.setText(date);
// 
//    }
        
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
            CallableStatement cStmt = (CallableStatement) conn.prepareCall("SELECT `maoto`,hang,loai,`tenoto`, `donvitinh`, `tonkho`,  `mausac` FROM `oto`");
            rs = cStmt.executeQuery();
            while(rs.next()){
//                String id = rs.getString("id");
                String maoto = rs.getString("maoto");
                String hang = rs.getString("hang");
                String loai = rs.getString("loai");
                String tenoto = rs.getString("tenoto");
                String donvitinh = rs.getString("donvitinh");
//                 String tonkho = rs.getString("tonkho");
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
                tableModel.addRow(new String[]{maoto,hang,loai, tenoto, donvitinh,mausac});
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
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txttenoto = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jComboBox3 = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtma = new javax.swing.JTextField();
        txtloai = new javax.swing.JComboBox<>();
        txthang = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtgia = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        Exit1 = new javax.swing.JButton();
        Exit2 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        ototable = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
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
        jLabel1.setText("QUẢN LÝ THÔNG TIN OTO");

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel2.setToolTipText("");
        jPanel2.setPreferredSize(new java.awt.Dimension(900, 600));

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setToolTipText("");
        jPanel3.setEnabled(false);

        jPanel5.setBackground(new java.awt.Color(255, 153, 51));
        jPanel5.setPreferredSize(new java.awt.Dimension(361, 272));

        jLabel4.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Tên Oto");

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(255, 255, 255));
        jLabel10.setText("Giá");

        txttenoto.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txttenoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txttenotoActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("Màu ");

        jComboBox3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jComboBox3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Đỏ", "Đen", "Trắng" }));

        jLabel3.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Mã Oto");

        txtma.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        txtloai.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtloai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SUV", "SEDAN", "MPV" }));

        txthang.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txthang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Ford", "Lexus", "Hyundai", "Toyota", "Kia" }));

        jButton1.setBackground(new java.awt.Color(114, 114, 244));
        jButton1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton1.setForeground(new java.awt.Color(51, 51, 51));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/outline_add_black_24dp.png"))); // NOI18N
        jButton1.setText("Thêm");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(114, 114, 244));
        jButton4.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton4.setForeground(new java.awt.Color(51, 51, 51));
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/outline_cached_black_24dp.png"))); // NOI18N
        jButton4.setText("Sửa");
        jButton4.setBorderPainted(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(114, 114, 244));
        jButton3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jButton3.setForeground(new java.awt.Color(51, 51, 51));
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/outline_remove_black_24dp.png"))); // NOI18N
        jButton3.setText("Xóa");
        jButton3.setBorderPainted(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Hãng");

        jLabel7.setFont(new java.awt.Font("SansSerif", 1, 16)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Loại");

        txtgia.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        txtgia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                txtgiaMouseExited(evt);
            }
        });
        txtgia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtgiaActionPerformed(evt);
            }
        });

        jButton5.setText("Check");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
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

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Exit2, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(58, 58, 58)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(56, 56, 56)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(txthang, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtloai, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txttenoto)
                        .addComponent(txtma)
                        .addComponent(jComboBox3, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Exit1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtgia, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton5)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtma, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txthang, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtloai, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txttenoto, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtgia, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jComboBox3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Exit1, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Exit2, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        ototable.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        ototable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Hãng", "Loại", "Tên Xe", "Giá", "Màu"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                true, true, true, false, true, true
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
            ototable.getColumnModel().getColumn(3).setResizable(false);
            ototable.getColumnModel().getColumn(3).setPreferredWidth(200);
        }

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("XE");

        jLabel9.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("THÔNG TIN XE");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 594, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 54, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 920, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 482, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, 526, Short.MAX_VALUE)
                .addGap(12, 12, 12))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(76, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0))
        );

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/car-icon.png"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(538, 538, 538)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 628, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(84, 84, 84)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 1698, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 621, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1698, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 706, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    
    

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        
        Connection conn = connection.ConnectMySQL();
        com.mysql.jdbc.Statement Stmt = null;
        
        String ma = String.valueOf(txtma.getText()).trim();
        String hang =txthang.getSelectedItem().toString();
//        String hang = chuyendoiHang(Hang);
        String loai =txtloai.getSelectedItem().toString();
        String ten = String.valueOf(txttenoto.getText()).trim();
        String gia = String.valueOf(txtgia.getText()).trim();
//        String soluong = String.valueOf(txtsoluong.getText()).trim();
        String Mau =jComboBox3.getSelectedItem().toString();
        String mau = chuyendoiMau(Mau);

        if(txttenoto.equals("") || gia.equals("")){
            JOptionPane.showMessageDialog(rootPane, "Yêu cầu nhập đầy đủ thông tin!!!", "Error", 1);
        }else{
        boolean checktrung = true;
            try {
                
                com.mysql.jdbc.CallableStatement cSmt1 = (com.mysql.jdbc.CallableStatement) conn.prepareCall("select tenoto,hang,mausac from oto WHERE tenoto=? AND hang=? AND mausac=?");
                cSmt1.setString(1, ten);
                cSmt1.setString(2, hang);
                cSmt1.setString(3, mau);
                ResultSet rs_checkid = cSmt1.executeQuery();
                if(rs_checkid.next()){
                    JOptionPane.showMessageDialog(rootPane, "Đã Bị Trùng Với Thông Tin Xe Hiện Tại", "Erro", 1);
                    checktrung = false;
                }else{
                    try{
                        Class.forName("com.mysql.jdbc.Driver");
                        con = DriverManager.getConnection("jdbc:mysql://localhost/car","root","");
                        insert = con.prepareStatement("INSERT INTO oto( hang,loai,tenoto, donvitinh, tonkho, mausac) "
                            + "VALUES(?,?,?,?,0,?)");
                        insert.setString(1,hang);
                        insert.setString(2,loai);
                        insert.setString(3,ten);
                        insert.setString(4,gia);
                        insert.setString(5,mau);
                        insert.executeUpdate();
                        JOptionPane.showMessageDialog(this, "Lưu Thông Tin Xe Thành Công");
                            
                        ShowOto();
                        reset();
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        
        
            // TODO add your handling code here:
//            String hang =txthang.getSelectedItem().toString();
////            String hang = chuyendoiHang(Hang);
//            String loai =txtloai.getSelectedItem().toString();
//            String tenoto =txttenoto.getText();
//            String gia =txtgia.getText();
//            String soluong =txtsoluong.getText();
//            String Mau =jComboBox3.getSelectedItem().toString();
//            String mau = chuyendoiMau(Mau);
//            

//        
//        boolean checktrung = true;
//            try {
//                
//                com.mysql.jdbc.CallableStatement cSmt1 = (com.mysql.jdbc.CallableStatement) con.prepareCall("select tenoto,hang,mausac from oto WHERE tenoto=? AND hang=? AND mausac=?");
//                cSmt1.setString(1, tenoto);
//                cSmt1.setString(2, hang);
//                cSmt1.setString(3, mau);
//                ResultSet rs_checkid = cSmt1.executeQuery();
//                if(rs_checkid.next()){
//                    JOptionPane.showMessageDialog(rootPane, "Đã Bị Trùng Với Thông Tin Xe Hiện Tại", "Erro", 1);
//                    checktrung = false;
//                }else{
//                    try{
//                        
//                        Class.forName("com.mysql.jdbc.Driver");
//                        con = DriverManager.getConnection("jdbc:mysql://localhost/car","root","");
//                        insert = con.prepareStatement("INSERT INTO oto( hang,loai,tenoto, donvitinh, tonkho, mausac) "
//                            + "VALUES(?,?,?,?,0,?)");
//                        insert.setString(1,hang);
//                        insert.setString(2,loai);
//                        insert.setString(3,tenoto);
//                        insert.setString(4,gia);
//                        insert.setString(5,mau);
//                        insert.executeUpdate();
//                        JOptionPane.showMessageDialog(this, "Lưu Thông Tin Xe Thành Công");
//
//                    }catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        
//        ShowOto();
//        reset();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void txttenotoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txttenotoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txttenotoActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) ototable.getModel();
        int selectedIndex = ototable.getSelectedRow();

        try {
            Connection con1;
            PreparedStatement insert;

            String maoto = (String) ototable.getValueAt(selectedIndex, 0);

            //int id = Integer.parseInt(model.getValueAt(selectedIndex, 0).toString());

            int dialogResult = JOptionPane.showConfirmDialog (rootPane, "Bạn Có Chắc Muốn Xóa Xe Này Chứ ?","Cảnh Báo",JOptionPane.YES_NO_OPTION);
            if(dialogResult == JOptionPane.YES_OPTION){
                // Saving code here

                Class.forName("com.mysql.jdbc.Driver");
                con1 = DriverManager.getConnection("jdbc:mysql://localhost/car","root","");
                insert = con1.prepareStatement("DELETE FROM `oto` WHERE maoto=?");

                insert.setString(1,maoto);
                insert.executeUpdate();
                JOptionPane.showMessageDialog(this, "Xóa Xe Thành Công");
                //                reset();
//                HienThiTTNV();
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(QuanLySanPham.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(QuanLySanPham.class.getName()).log(Level.SEVERE, null, ex);
        }

        ShowOto();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Connection conn = connection.ConnectMySQL();
        com.mysql.jdbc.Statement Stmt = null;
        String ma = String.valueOf(txtma.getText()).trim();
        String hang =txthang.getSelectedItem().toString();
//        String hang = chuyendoiHang(Hang);
        String loai =txtloai.getSelectedItem().toString();
        String ten = String.valueOf(txttenoto.getText()).trim();
        String gia = String.valueOf(txtgia.getText()).trim();
//        String soluong = String.valueOf(txtsoluong.getText()).trim();
        String Mau =jComboBox3.getSelectedItem().toString();
        String mau = chuyendoiMau(Mau);

        
        boolean checktrung = true;
            try {
                
                com.mysql.jdbc.CallableStatement cSmt1 = (com.mysql.jdbc.CallableStatement) conn.prepareCall("select tenoto,hang,mausac from oto WHERE tenoto=? AND hang=? AND mausac=?");
                cSmt1.setString(1, ten);
                cSmt1.setString(2, hang);
                cSmt1.setString(3, mau);
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
                    insert = con1.prepareStatement("update oto set hang=?,loai=?,tenoto=? ,donvitinh= ? , mausac=? where maoto= ?");
                    insert.setString(1,hang);
                    insert.setString(2,loai);
                    insert.setString(3,ten);
                    insert.setString(4,gia);
//                    insert.setString(3,soluong);
                    insert.setString(5,mau);
                    insert.setString(6,ma);

                    insert.executeUpdate();
                    JOptionPane.showMessageDialog(this, "Cập Nhật Thành Công");
                    ShowOto();
                    reset();
                    }catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void ototableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ototableMouseClicked
        // TODO add your handling code here:
        txtma.setEnabled(false);
//        txttenoto.setEnabled(false);
//        jComboBox3.setEnabled(false);
        jButton1.setEnabled(false);
        jButton4.setEnabled(true);
        jButton3.setEnabled(true);
        
        jLabel3.setEnabled(true);
//        jLabel8.setEnabled(true);
//        txtsoluong.setEnabled(true);
        
        DefaultTableModel tableModel= (DefaultTableModel)ototable.getModel();
        String ma = tableModel.getValueAt(ototable.getSelectedRow(), 0).toString();
        String hang = tableModel.getValueAt(ototable.getSelectedRow(), 1).toString();
        
                        
        String loai = tableModel.getValueAt(ototable.getSelectedRow(), 2).toString();
        String ten = tableModel.getValueAt(ototable.getSelectedRow(), 3).toString();
        String gia = tableModel.getValueAt(ototable.getSelectedRow(), 4).toString();
//        String tonkho = tableModel.getValueAt(ototable.getSelectedRow(), 5).toString();
        String mausac = tableModel.getValueAt(ototable.getSelectedRow(), 5).toString();
        

        txtma.setText(ma);
        txtloai.setSelectedItem(loai);
        txthang.setSelectedItem(hang);
        txttenoto.setText(ten);
        txtgia.setText(gia);
//        txtsoluong.setText(tonkho);
        jComboBox3.setSelectedItem(mausac);
        
    }//GEN-LAST:event_ototableMouseClicked

    private void Exit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit1ActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_Exit1ActionPerformed

    private void txtgiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtgiaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtgiaActionPerformed

    private void txtgiaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtgiaMouseExited
        // TODO add your handling code here:

    }//GEN-LAST:event_txtgiaMouseExited

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
                        String output = "";
    try {
        
        String input = String.valueOf(txtgia.getText()).trim();
        RuleBasedNumberFormat ruleBasedNumberFormat = new RuleBasedNumberFormat(new Locale("vi", "VN"), RuleBasedNumberFormat.SPELLOUT);
        output = ruleBasedNumberFormat.format(Long.parseLong(input)) + " VND";
        JOptionPane.showMessageDialog(null, "Giá sẽ là: "+output);
    } catch (Exception e) {
        output = "không đồng";
        JOptionPane.showMessageDialog(null, "Giá sẽ là: "+output);
    }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void Exit2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Exit2ActionPerformed
        // TODO add your handling code here:
        reset();
        ShowOto();
        txtma.setEnabled(false);
        txttenoto.setEnabled(true);
        jComboBox3.setEnabled(true);
        jButton1.setEnabled(true);
        jButton4.setEnabled(false);
        jButton3.setEnabled(false);
        jLabel3.setEnabled(false);
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
            java.util.logging.Logger.getLogger(QuanLySanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(QuanLySanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(QuanLySanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(QuanLySanPham.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
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
                new QuanLySanPham().setVisible(true);

            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Exit1;
    private javax.swing.JButton Exit2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JComboBox<String> jComboBox3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable ototable;
    private javax.swing.JTextField txtgia;
    private javax.swing.JComboBox<String> txthang;
    private javax.swing.JComboBox<String> txtloai;
    private javax.swing.JTextField txtma;
    private javax.swing.JTextField txttenoto;
    // End of variables declaration//GEN-END:variables
}
