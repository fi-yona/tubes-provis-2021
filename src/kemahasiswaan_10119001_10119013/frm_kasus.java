/*
 * NAMA  : Fiona Avila Putri
 * NIM   : 10119013
 * KELAS : IF1 2019/2020
 */
package kemahasiswaan_10119001_10119013;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Fiona Avila
 */
public class frm_kasus extends javax.swing.JFrame {

    /**
     * Creates new form frm_kasus
     */
    
    koneksi dbsetting;
    String driver, database, user, pass;
    int IdMember;
    String IdBarang; 
    String nama_produk;
    String nama_member;
    String username;
    
    ArrayList<Member> arrMember = new ArrayList<>();
    ArrayList<Produk> arrProduk = new ArrayList<>();
    
    public frm_kasus() {
        initComponents();
        dbsetting = new koneksi();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");
        tampil_combo_nama_member();
        tampil_combo_nama_produk();
        tampil_id_member();
        tampil_point_member();
        tampil_id_produk();
        tampil_harga_satuan();
    }
    
    public void tampil_combo_nama_member(){
        try {
        Connection kon = DriverManager.getConnection(database, user, pass);
        Statement stt = kon.createStatement();
        String sql = "SELECT IdMember, NamaMember, Point FROM t_member ORDER BY NamaMember ASC";      // disini saya menampilkan, anda dapat menampilkan                            // yang anda ingin kan
        ResultSet res = stt.executeQuery(sql);
        while(res.next()){
            arrMember.add(new Member(res.getInt("IdMember"), res.getString("NamaMember"), res.getInt("Point")));
            // fungsi ini bertugas menampung isi dari database
        }
        for(int i=0;i<arrMember.size();i++){
            combo_nama_member.addItem(arrMember.get(i).getNamaMember());
        }
        res.close();
        stt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void tampil_combo_nama_produk(){
        try {
        Connection kon = DriverManager.getConnection(database, user, pass);
        Statement stt = kon.createStatement();
        String sql = "SELECT IdBarang, NamaBarang, Stok, HargaJual FROM t_barang ORDER BY NamaBarang ASC";      // disini saya menampilkan, anda dapat menampilkan                            // yang anda ingin kan
        ResultSet res = stt.executeQuery(sql);
        while(res.next()){
            arrProduk.add(new Produk(res.getString("IdBarang"), res.getString("NamaBarang"), res.getInt("Stok"), res.getDouble("HargaJual")));
            // fungsi ini bertugas menampung isi dari database
        }
        for(int i=0;i<arrProduk.size();i++){
            combo_nama_produk.addItem(arrProduk.get(i).getNamaBarang());
        }
        res.close();
        stt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void tampil_id_member(){
        int idx = combo_nama_member.getSelectedIndex();
        nama_member = (String)combo_nama_member.getSelectedItem();
        String data[] = new String[1];
        if(idx>=0){
            try {
                Connection kon = DriverManager.getConnection(database, user, pass);
                Statement stt = kon.createStatement();
                String sql = "SELECT IdMember FROM t_member WHERE NamaMember='"+nama_member+"'";      
                ResultSet res = stt.executeQuery(sql);
                while(res.next()){
                    data[0] = res.getString(1);
                    txt_id_member.setText(data[0]);
                }
                res.close();
                stt.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public void tampil_point_member(){
        int idx = combo_nama_member.getSelectedIndex();
        nama_member = (String)combo_nama_member.getSelectedItem();
        String data[] = new String[1];
        if(idx>=0){
            try {
                Connection kon = DriverManager.getConnection(database, user, pass);
                Statement stt = kon.createStatement();
                String sql = "SELECT Point FROM t_member WHERE NamaMember='"+nama_member+"'";      
                ResultSet res = stt.executeQuery(sql);
                while(res.next()){
                    data[0] = res.getString(1);
                    txt_point_member.setText(data[0]);
                }
                res.close();
                stt.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public void tampil_id_produk(){
        int idx = combo_nama_produk.getSelectedIndex();
        nama_produk = (String)combo_nama_produk.getSelectedItem();
        String data[] = new String[1];
        if(idx>=0){
            try {
                Connection kon = DriverManager.getConnection(database, user, pass);
                Statement stt = kon.createStatement();
                String sql = "SELECT IdBarang FROM t_barang WHERE NamaBarang='"+nama_produk+"'";      
                ResultSet res = stt.executeQuery(sql);
                while(res.next()){
                    data[0] = res.getString(1);
                    txt_id_produk.setText(data[0]);
                }
                res.close();
                stt.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public void tampil_harga_satuan(){
        int idx = combo_nama_produk.getSelectedIndex();
        nama_produk = (String)combo_nama_produk.getSelectedItem();
        String data[] = new String[1];
        if(idx>=0){
            try {
                Connection kon = DriverManager.getConnection(database, user, pass);
                Statement stt = kon.createStatement();
                String sql = "SELECT HargaJual FROM t_barang WHERE NamaBarang='"+nama_produk+"'";      
                ResultSet res = stt.executeQuery(sql);
                while(res.next()){
                    data[0] = res.getString(1);
                    txt_harga_satuan.setText(data[0]);
                }
                res.close();
                stt.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public void getNoStruk(){
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPopupMenu1 = new javax.swing.JPopupMenu();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbl_jdl_kasus = new javax.swing.JLabel();
        lbl_nama_kasir1 = new javax.swing.JLabel();
        lbl_tanya_member = new javax.swing.JLabel();
        ada_member = new javax.swing.JRadioButton();
        tidak_member = new javax.swing.JRadioButton();
        lbl_nama_member = new javax.swing.JLabel();
        lbl_id_member = new javax.swing.JLabel();
        combo_nama_member = new javax.swing.JComboBox<>();
        txt_id_member = new javax.swing.JTextField();
        lbl_uang_bayar = new javax.swing.JLabel();
        lbl_nama_produk = new javax.swing.JLabel();
        combo_nama_produk = new javax.swing.JComboBox<>();
        lbl_id_produk = new javax.swing.JLabel();
        txt_id_produk = new javax.swing.JTextField();
        lbl_jumlah = new javax.swing.JLabel();
        txt_jumlah = new javax.swing.JTextField();
        lbl_total_bayar = new javax.swing.JLabel();
        txt_total_bayar = new javax.swing.JTextField();
        lbl_harga_satuan = new javax.swing.JLabel();
        txt_harga_satuan = new javax.swing.JTextField();
        btn_tambah_produk = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_transaksi = new javax.swing.JTable();
        txt_uang_bayar = new javax.swing.JTextField();
        btn_bayar = new javax.swing.JButton();
        btn_keluar = new javax.swing.JButton();
        lbl_point_member = new javax.swing.JLabel();
        txt_point_member = new javax.swing.JTextField();
        lbl_no_struk = new javax.swing.JLabel();
        txt_no_struk = new javax.swing.JTextField();
        btn_edit_produk = new javax.swing.JButton();
        btn_hapus_produk = new javax.swing.JButton();
        btn_transaksi = new javax.swing.JButton();

        jPopupMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("PROGRAM TRANSAKSI");
        setPreferredSize(new java.awt.Dimension(1355, 691));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(209, 209, 229));
        jPanel1.setPreferredSize(new java.awt.Dimension(1350, 730));

        jPanel2.setBackground(new java.awt.Color(162, 169, 226));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));
        jPanel2.setPreferredSize(new java.awt.Dimension(1350, 48));

        lbl_jdl_kasus.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        lbl_jdl_kasus.setText("TRANSAKSI");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(607, 607, 607)
                .addComponent(lbl_jdl_kasus)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_jdl_kasus)
                .addContainerGap())
        );

        lbl_nama_kasir1.setFont(new java.awt.Font("Microsoft YaHei", 0, 18)); // NOI18N
        lbl_nama_kasir1.setText("HALO, SAYA (NAMA)");

        lbl_tanya_member.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lbl_tanya_member.setText("Apakah pelanggan ada member?");

        ada_member.setBackground(new java.awt.Color(209, 209, 229));
        buttonGroup1.add(ada_member);
        ada_member.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        ada_member.setText("Ada");
        ada_member.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ada_memberMouseClicked(evt);
            }
        });
        ada_member.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ada_memberActionPerformed(evt);
            }
        });

        tidak_member.setBackground(new java.awt.Color(209, 209, 229));
        buttonGroup1.add(tidak_member);
        tidak_member.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        tidak_member.setText("Tidak Ada");
        tidak_member.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tidak_memberActionPerformed(evt);
            }
        });

        lbl_nama_member.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lbl_nama_member.setText("Nama Member");

        lbl_id_member.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lbl_id_member.setText("Id Member");

        combo_nama_member.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        combo_nama_member.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        combo_nama_member.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_nama_memberActionPerformed(evt);
            }
        });

        txt_id_member.setEditable(false);
        txt_id_member.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        txt_id_member.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_id_memberActionPerformed(evt);
            }
        });

        lbl_uang_bayar.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        lbl_uang_bayar.setText("Uang Bayar");

        lbl_nama_produk.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lbl_nama_produk.setText("Nama Produk");

        combo_nama_produk.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        combo_nama_produk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_nama_produkActionPerformed(evt);
            }
        });

        lbl_id_produk.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lbl_id_produk.setText("Id Produk");

        txt_id_produk.setEditable(false);
        txt_id_produk.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N

        lbl_jumlah.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lbl_jumlah.setText("Jumlah");

        txt_jumlah.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N

        lbl_total_bayar.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        lbl_total_bayar.setText("TOTAL BAYAR");

        txt_total_bayar.setEditable(false);
        txt_total_bayar.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N

        lbl_harga_satuan.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lbl_harga_satuan.setText("Harga Satuan");

        txt_harga_satuan.setEditable(false);
        txt_harga_satuan.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N

        btn_tambah_produk.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        btn_tambah_produk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kemahasiswaan_10119001_10119013/add.png"))); // NOI18N
        btn_tambah_produk.setText("Tambahkan");
        btn_tambah_produk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_tambah_produkMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_tambah_produkMouseExited(evt);
            }
        });
        btn_tambah_produk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambah_produkActionPerformed(evt);
            }
        });

        tbl_transaksi.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbl_transaksi.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        tbl_transaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Id Barang", "Nama Barang", "Jumlah Barang", "Total Harga"
            }
        ));
        jScrollPane1.setViewportView(tbl_transaksi);

        txt_uang_bayar.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N

        btn_bayar.setBackground(new java.awt.Color(255, 255, 255));
        btn_bayar.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        btn_bayar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kemahasiswaan_10119001_10119013/money.png"))); // NOI18N
        btn_bayar.setText("BAYAR");
        btn_bayar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_bayarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_bayarMouseExited(evt);
            }
        });
        btn_bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bayarActionPerformed(evt);
            }
        });

        btn_keluar.setBackground(new java.awt.Color(255, 255, 255));
        btn_keluar.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        btn_keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kemahasiswaan_10119001_10119013/keluar.png"))); // NOI18N
        btn_keluar.setText("KELUAR");
        btn_keluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_keluarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_keluarMouseExited(evt);
            }
        });
        btn_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_keluarActionPerformed(evt);
            }
        });

        lbl_point_member.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lbl_point_member.setText("Point Member");

        txt_point_member.setEditable(false);
        txt_point_member.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N

        lbl_no_struk.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lbl_no_struk.setText("NO STRUK");

        txt_no_struk.setEditable(false);
        txt_no_struk.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        txt_no_struk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_no_strukActionPerformed(evt);
            }
        });

        btn_edit_produk.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        btn_edit_produk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kemahasiswaan_10119001_10119013/ubah.png"))); // NOI18N
        btn_edit_produk.setText("Edit");
        btn_edit_produk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_edit_produkMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_edit_produkMouseExited(evt);
            }
        });
        btn_edit_produk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_edit_produkActionPerformed(evt);
            }
        });

        btn_hapus_produk.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        btn_hapus_produk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kemahasiswaan_10119001_10119013/hapus.png"))); // NOI18N
        btn_hapus_produk.setText("Hapus");
        btn_hapus_produk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_hapus_produkMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_hapus_produkMouseExited(evt);
            }
        });
        btn_hapus_produk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapus_produkActionPerformed(evt);
            }
        });

        btn_transaksi.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        btn_transaksi.setText("Buat Transaksi");
        btn_transaksi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_transaksiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 1334, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lbl_nama_kasir1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_tanya_member)
                                .addGap(18, 18, 18)
                                .addComponent(ada_member)
                                .addGap(18, 18, 18)
                                .addComponent(tidak_member))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_nama_member)
                                    .addComponent(lbl_id_member))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(combo_nama_member, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(txt_id_member)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_point_member)
                                .addGap(24, 24, 24)
                                .addComponent(txt_point_member)))
                        .addGap(97, 97, 97)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btn_keluar)
                                .addContainerGap())
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_tambah_produk)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_edit_produk)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_hapus_produk)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lbl_harga_satuan)
                                        .addGap(18, 18, 18)
                                        .addComponent(txt_harga_satuan, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(168, 168, 168)
                                        .addComponent(txt_uang_bayar, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lbl_nama_produk)
                                                .addGap(18, 18, 18)
                                                .addComponent(combo_nama_produk, 0, 223, Short.MAX_VALUE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lbl_id_produk)
                                                .addGap(41, 41, 41)
                                                .addComponent(txt_id_produk))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lbl_jumlah)
                                                .addGap(59, 59, 59)
                                                .addComponent(txt_jumlah, javax.swing.GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)))
                                        .addGap(62, 62, 62)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btn_transaksi)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lbl_total_bayar)
                                                    .addComponent(lbl_uang_bayar))
                                                .addGap(18, 18, 18)
                                                .addComponent(txt_total_bayar, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lbl_no_struk)
                                                .addGap(43, 43, 43)
                                                .addComponent(txt_no_struk, javax.swing.GroupLayout.DEFAULT_SIZE, 222, Short.MAX_VALUE)))))
                                .addGap(150, 150, 150))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_bayar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(lbl_nama_kasir1)
                        .addComponent(btn_keluar))
                    .addComponent(btn_transaksi, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_tanya_member)
                            .addComponent(ada_member)
                            .addComponent(tidak_member)
                            .addComponent(lbl_nama_produk)
                            .addComponent(combo_nama_produk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_no_struk)
                            .addComponent(txt_no_struk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(4, 4, 4)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nama_member)
                    .addComponent(combo_nama_member, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_id_produk)
                    .addComponent(txt_id_produk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_id_member)
                    .addComponent(txt_id_member, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_total_bayar)
                    .addComponent(txt_total_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_jumlah)
                    .addComponent(txt_jumlah, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_uang_bayar)
                    .addComponent(lbl_harga_satuan)
                    .addComponent(txt_harga_satuan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_uang_bayar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_point_member)
                    .addComponent(txt_point_member, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_tambah_produk)
                    .addComponent(btn_edit_produk)
                    .addComponent(btn_hapus_produk))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_bayar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1334, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 695, Short.MAX_VALUE)
        );

        setBounds(0, 0, 1350, 730);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        frm_login l = new frm_login();
        l.setVisible(true);
        dispose();
    }//GEN-LAST:event_formWindowClosing

    private void ada_memberMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ada_memberMouseClicked
        
    }//GEN-LAST:event_ada_memberMouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        lbl_nama_member.setVisible(false);
        combo_nama_member.setVisible(false);
        lbl_point_member.setVisible(false);
        txt_point_member.setVisible(false);
        lbl_id_member.setVisible(false);
        txt_id_member.setVisible(false);
        lbl_nama_produk.setVisible(false);
        lbl_id_produk.setVisible(false);
        lbl_jumlah.setVisible(false);
        lbl_harga_satuan.setVisible(false);
        combo_nama_produk.setVisible(false);
        txt_id_produk.setVisible(false);
        txt_jumlah.setVisible(false);
        txt_harga_satuan.setVisible(false);
        lbl_total_bayar.setVisible(false);
        txt_total_bayar.setVisible(false);
        lbl_uang_bayar.setVisible(false);
        txt_uang_bayar.setVisible(false);
        btn_tambah_produk.setVisible(false);
        btn_edit_produk.setVisible(false);
        btn_hapus_produk.setVisible(false);
        btn_bayar.setVisible(false);
    }//GEN-LAST:event_formWindowOpened

    private void ada_memberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ada_memberActionPerformed
        lbl_nama_member.setVisible(true);
        combo_nama_member.setVisible(true);
        lbl_point_member.setVisible(true);
        txt_point_member.setVisible(true);
        lbl_id_member.setVisible(true);
        txt_id_member.setVisible(true);
    }//GEN-LAST:event_ada_memberActionPerformed

    private void tidak_memberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tidak_memberActionPerformed
        lbl_nama_member.setVisible(false);
        combo_nama_member.setVisible(false);
        lbl_point_member.setVisible(false);
        txt_point_member.setVisible(false);
        lbl_id_member.setVisible(false);
        txt_id_member.setVisible(false);
    }//GEN-LAST:event_tidak_memberActionPerformed

    private void btn_tambah_produkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambah_produkActionPerformed
        btn_edit_produk.setVisible(false);
        btn_hapus_produk.setVisible(false);
        if(txt_jumlah.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Data tidak boleh kosong!", "Error", JOptionPane.CANCEL_OPTION);
        }else{
            
        }
    }//GEN-LAST:event_btn_tambah_produkActionPerformed

    private void btn_tambah_produkMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tambah_produkMouseEntered
        btn_tambah_produk.setBackground(new java.awt.Color(128,136,203));
        btn_tambah_produk.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_btn_tambah_produkMouseEntered

    private void btn_tambah_produkMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_tambah_produkMouseExited
        btn_tambah_produk.setBackground(new java.awt.Color(255, 255, 255));
        btn_tambah_produk.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btn_tambah_produkMouseExited

    private void btn_bayarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_bayarMouseEntered
        // [102,255,153]
        btn_bayar.setBackground(new java.awt.Color(102,255,153));
        btn_bayar.setForeground(new java.awt.Color(255,0,51));
    }//GEN-LAST:event_btn_bayarMouseEntered

    private void btn_bayarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_bayarMouseExited
        btn_bayar.setBackground(new java.awt.Color(255, 255, 255));
        btn_bayar.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btn_bayarMouseExited

    private void btn_bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_bayarActionPerformed

    private void btn_keluarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_keluarMouseEntered
        btn_keluar.setBackground(new java.awt.Color(255,102,102));
        btn_keluar.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_btn_keluarMouseEntered

    private void btn_keluarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_keluarMouseExited
        btn_keluar.setBackground(new java.awt.Color(255, 255, 255));
        btn_keluar.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btn_keluarMouseExited

    private void btn_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_keluarActionPerformed
        frm_login l = new frm_login();
        l.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_keluarActionPerformed

    private void combo_nama_memberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_nama_memberActionPerformed
        int idx = combo_nama_member.getSelectedIndex();
        
        if(arrMember.size() > 0){
            IdMember = arrMember.get(idx).getIdMember();
            tampil_id_member();
            tampil_point_member();
        }
    }//GEN-LAST:event_combo_nama_memberActionPerformed

    private void combo_nama_produkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_nama_produkActionPerformed
        int idx = combo_nama_produk.getSelectedIndex();
        
        if(arrProduk.size() > 0){
            IdBarang = arrProduk.get(idx).getIdBarang();
            tampil_id_produk();
            tampil_harga_satuan();
        }
    }//GEN-LAST:event_combo_nama_produkActionPerformed

    private void txt_id_memberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_memberActionPerformed

    }//GEN-LAST:event_txt_id_memberActionPerformed

    private void btn_edit_produkMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_edit_produkMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_edit_produkMouseEntered

    private void btn_edit_produkMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_edit_produkMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_edit_produkMouseExited

    private void btn_edit_produkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit_produkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_edit_produkActionPerformed

    private void btn_hapus_produkMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hapus_produkMouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_hapus_produkMouseEntered

    private void btn_hapus_produkMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hapus_produkMouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_hapus_produkMouseExited

    private void btn_hapus_produkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapus_produkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_hapus_produkActionPerformed

    private void txt_no_strukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_no_strukActionPerformed
        String data[] = new String[1];
        try{
            Connection kon = DriverManager.getConnection(database, user, pass);
            Statement stt = kon.createStatement();
            String sql = "SELECT NoStruk FROM t_struk WHERE WaktuStruk = (SELECT MAX(WsktuStruk) FROM t_struk)";      
            ResultSet res = stt.executeQuery(sql);
            while(res.next()){
                data[0] = res.getString(1);
                txt_no_struk.setText(data[0]);
            }
            res.close();
            stt.close();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_txt_no_strukActionPerformed

    private void btn_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transaksiActionPerformed
        lbl_nama_produk.setVisible(true);
        lbl_id_produk.setVisible(true);
        lbl_jumlah.setVisible(true);
        lbl_harga_satuan.setVisible(true);
        combo_nama_produk.setVisible(true);
        txt_id_produk.setVisible(true);
        txt_jumlah.setVisible(true);
        txt_harga_satuan.setVisible(true);
        lbl_total_bayar.setVisible(true);
        txt_total_bayar.setVisible(true);
        lbl_uang_bayar.setVisible(true);
        txt_uang_bayar.setVisible(true);
        btn_tambah_produk.setVisible(true);
        btn_edit_produk.setVisible(true);
        btn_hapus_produk.setVisible(true);
        btn_bayar.setVisible(true);
        
    }//GEN-LAST:event_btn_transaksiActionPerformed

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
            java.util.logging.Logger.getLogger(frm_kasus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_kasus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_kasus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_kasus.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_kasus().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton ada_member;
    private javax.swing.JButton btn_bayar;
    private javax.swing.JButton btn_edit_produk;
    private javax.swing.JButton btn_hapus_produk;
    private javax.swing.JButton btn_keluar;
    private javax.swing.JButton btn_tambah_produk;
    private javax.swing.JButton btn_transaksi;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> combo_nama_member;
    private javax.swing.JComboBox<String> combo_nama_produk;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_harga_satuan;
    private javax.swing.JLabel lbl_id_member;
    private javax.swing.JLabel lbl_id_produk;
    private javax.swing.JLabel lbl_jdl_kasus;
    private javax.swing.JLabel lbl_jumlah;
    private javax.swing.JLabel lbl_nama_kasir1;
    private javax.swing.JLabel lbl_nama_member;
    private javax.swing.JLabel lbl_nama_produk;
    private javax.swing.JLabel lbl_no_struk;
    private javax.swing.JLabel lbl_point_member;
    private javax.swing.JLabel lbl_tanya_member;
    private javax.swing.JLabel lbl_total_bayar;
    private javax.swing.JLabel lbl_uang_bayar;
    private javax.swing.JTable tbl_transaksi;
    private javax.swing.JRadioButton tidak_member;
    private javax.swing.JTextField txt_harga_satuan;
    private javax.swing.JTextField txt_id_member;
    private javax.swing.JTextField txt_id_produk;
    private javax.swing.JTextField txt_jumlah;
    private javax.swing.JTextField txt_no_struk;
    private javax.swing.JTextField txt_point_member;
    private javax.swing.JTextField txt_total_bayar;
    private javax.swing.JTextField txt_uang_bayar;
    // End of variables declaration//GEN-END:variables
}
