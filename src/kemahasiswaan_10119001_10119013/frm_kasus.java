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
    int struk;
    int htgStruk;
    String Username;
    String nama_kasir;
    int totalBayar = 0;
    int point;
    
    ArrayList<Member> arrMember = new ArrayList<>();
    ArrayList<Produk> arrProduk = new ArrayList<>();
    ArrayList<User> arrUser = new ArrayList<>();
    
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
        getNoStruk();
        tampil_combo_nama_kasir();
        tbl_transaksi.setModel(tableModel);
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
        String data[] = new String[1];
        try{
            Connection kon = DriverManager.getConnection(database, user, pass);
            Statement stt = kon.createStatement();
            String sql = "SELECT MAX(NoStruk) FROM t_struk";      
            ResultSet res = stt.executeQuery(sql);
            while(res.next()){
                data[0] = res.getString(1);
                struk = Integer.valueOf(data[0]);
            }
            res.close();
            stt.close();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    public void tampil_combo_nama_kasir(){
        try {
            Connection kon = DriverManager.getConnection(database, user, pass);
            Statement stt = kon.createStatement();
            String sql = "SELECT Username, Nama FROM t_user ORDER BY Nama ASC";      // disini saya menampilkan, anda dapat menampilkan                            // yang anda ingin kan
            ResultSet res = stt.executeQuery(sql);
            while(res.next()){
                arrUser.add(new User(res.getString("Username"), res.getString("Nama")));
                // fungsi ini bertugas menampung isi dari database
            }
            for(int i=0;i<arrUser.size();i++){
                combo_nama_kasir.addItem(arrUser.get(i).getNama());
            }
            res.close();
            stt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void tampil_total_bayar(){
        String data[] = new String[1];
        try{
            Connection kon = DriverManager.getConnection(database, user, pass);
            Statement stt = kon.createStatement();
            String sql = "SELECT SUM(TotalHarga) FROM t_detail_struk WHERE NoStruk = '"+txt_no_struk.getText()+"'";      
            ResultSet res = stt.executeQuery(sql);
            while(res.next()){
                data[0] = res.getString(1);
                totalBayar = Integer.valueOf(data[0]);
                txt_total_bayar.setText(String.valueOf(totalBayar));
            }
            res.close();
            stt.close();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }
    
    int row = 0;
    public void tampil_field(){
        row = tbl_transaksi.getSelectedRow();
        combo_nama_produk.setSelectedItem(tableModel.getValueAt(row, 1));
        txt_id_produk.setText(tableModel.getValueAt(row, 0).toString());
        txt_jumlah.setText(tableModel.getValueAt(row, 2).toString());
    }
    
    private javax.swing.table.DefaultTableModel tableModel = getDefaultTabelModel();
    private javax.swing.table.DefaultTableModel getDefaultTabelModel() {
        // membuat judul header
        return new javax.swing.table.DefaultTableModel (
            new Object[][] {},
            new String [] {"Id Produk",
                           "Nama Produk",
                           "Jumlah",
                           "Total Harga"}
        )
        // disable perubahan pada grid
        {
            boolean[] canEdit = new boolean[] {
                false, false, false, false
            };
            
            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        };
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
        lbl_nama_kasir = new javax.swing.JLabel();
        combo_nama_kasir = new javax.swing.JComboBox<>();
        btn_batal_produk = new javax.swing.JButton();

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
                .addGap(87, 87, 87))
        );

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
        txt_total_bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_total_bayarActionPerformed(evt);
            }
        });

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
                "Id Produk", "Nama Produk", "Jumlah Produk", "Total Harga"
            }
        ));
        tbl_transaksi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_transaksiMouseClicked(evt);
            }
        });
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

        lbl_nama_kasir.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lbl_nama_kasir.setText("Nama Kasir");

        combo_nama_kasir.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        combo_nama_kasir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        combo_nama_kasir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_nama_kasirActionPerformed(evt);
            }
        });

        btn_batal_produk.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        btn_batal_produk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kemahasiswaan_10119001_10119013/batal.png"))); // NOI18N
        btn_batal_produk.setText("Batal");
        btn_batal_produk.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_batal_produkMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_batal_produkMouseExited(evt);
            }
        });
        btn_batal_produk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batal_produkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(lbl_nama_member)
                                        .addComponent(lbl_id_member))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(combo_nama_member, 0, 262, Short.MAX_VALUE)
                                        .addComponent(txt_id_member)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lbl_tanya_member)
                                    .addGap(18, 18, 18)
                                    .addComponent(ada_member)
                                    .addGap(18, 18, 18)
                                    .addComponent(tidak_member))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lbl_point_member)
                                    .addGap(24, 24, 24)
                                    .addComponent(txt_point_member))
                                .addComponent(lbl_nama_kasir))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(107, 107, 107)
                                .addComponent(combo_nama_kasir, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(93, 93, 93)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btn_keluar)
                                .addContainerGap())
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lbl_nama_produk)
                                                .addGap(18, 18, 18)
                                                .addComponent(combo_nama_produk, 0, 266, Short.MAX_VALUE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lbl_id_produk)
                                                .addGap(41, 41, 41)
                                                .addComponent(txt_id_produk))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lbl_jumlah)
                                                .addGap(59, 59, 59)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txt_harga_satuan)
                                                    .addComponent(txt_jumlah))))
                                        .addGap(62, 62, 62)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(lbl_total_bayar)
                                                    .addComponent(lbl_uang_bayar))
                                                .addGap(18, 18, 18)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(txt_total_bayar)
                                                    .addComponent(txt_uang_bayar)))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btn_transaksi)
                                                .addGap(0, 0, Short.MAX_VALUE))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(lbl_no_struk)
                                                .addGap(100, 100, 100)
                                                .addComponent(txt_no_struk, javax.swing.GroupLayout.DEFAULT_SIZE, 195, Short.MAX_VALUE))))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lbl_harga_satuan)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(btn_tambah_produk)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btn_edit_produk)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(btn_hapus_produk)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btn_batal_produk)))
                                        .addGap(0, 387, Short.MAX_VALUE)))
                                .addGap(93, 93, 93))))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btn_bayar)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_keluar)
                            .addComponent(btn_transaksi, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_nama_kasir)
                            .addComponent(combo_nama_kasir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(21, 21, 21)
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
                    .addComponent(btn_hapus_produk)
                    .addComponent(btn_batal_produk))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_bayar)
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
        txt_id_produk.setText("");
        txt_jumlah.setEnabled(false);
        txt_harga_satuan.setText("");
        txt_no_struk.setText("");
        btn_tambah_produk.setEnabled(false);
        btn_edit_produk.setEnabled(false);
        btn_hapus_produk.setEnabled(false);
        txt_total_bayar.setText("");
        txt_uang_bayar.setEnabled(false);
        combo_nama_produk.setEnabled(false);
        btn_batal_produk.setEnabled(false);
        btn_bayar.setEnabled(false);
        getNoStruk();
    }//GEN-LAST:event_formWindowOpened

    private void ada_memberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ada_memberActionPerformed
        lbl_nama_member.setVisible(true);
        combo_nama_member.setVisible(true);
        lbl_point_member.setVisible(true);
        txt_point_member.setVisible(true);
        lbl_id_member.setVisible(true);
        txt_id_member.setVisible(true);
        txt_id_member.setText("");
        txt_point_member.setText("");
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
        if(txt_jumlah.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Data tidak boleh kosong!", "Error", JOptionPane.CANCEL_OPTION);
        }else{
            String adaMember = null;
            if(ada_member.isSelected()){
                adaMember = txt_id_member.getText();
            }else if(tidak_member.isSelected()){
                adaMember = "1";
            }
            
            //hitung total harga
            int jumlahProduk = Integer.valueOf(txt_jumlah.getText());
            int hargaSatuanProduk = Integer.valueOf(txt_harga_satuan.getText());
            int htgTotalHarga = jumlahProduk * hargaSatuanProduk;
            
            String data[] = new String[4];
            try{
                Connection kon = DriverManager.getConnection(database, user, pass);
                Statement stt = kon.createStatement();
                String sql = "INSERT INTO t_detail_struk"
                        + "(NoStruk, IdBarang, Username, IdMember, Jumlah, TotalHarga)"
                        + "VALUES"
                        + "('"+txt_no_struk.getText()+"',"
                        + "'"+txt_id_produk.getText()+"',"
                        + "'"+Username+"',"
                        + "'"+adaMember+"',"
                        + "'"+txt_jumlah.getText()+"',"
                        + "'"+htgTotalHarga+"');";    
                stt.executeUpdate(sql);
                data[0] = txt_id_produk.getText();
                data[1] = (String) combo_nama_produk.getSelectedItem();
                data[2] = txt_jumlah.getText();
                data[3] = String.valueOf(htgTotalHarga);
                tableModel.addRow(data);
                stt.close();
                kon.close();
                txt_id_produk.setText("");
                txt_jumlah.setText("");
                txt_harga_satuan.setText("");
                btn_bayar.setEnabled(true);
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e.getMessage(), "Gagal!", JOptionPane.INFORMATION_MESSAGE);
            }
            tampil_total_bayar();
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
        if(txt_total_bayar.getText().isEmpty() || txt_uang_bayar.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Periksa kembali apakah uang sudah diberikan atau apakah barang sudah diinput!", "Gagal!", JOptionPane.CANCEL_OPTION);
        }else{
            frm_konf_bayar konf = new frm_konf_bayar();
            
            String getNoStruk = txt_no_struk.getText();
            konf.txt_no_struk_konf.setText(getNoStruk);

            String getTotalBayar = txt_total_bayar.getText();
            konf.txt_total_bayar_konf.setText(getTotalBayar);

            String getUangBayar = txt_uang_bayar.getText();
            konf.txt_uang_bayar_konf.setText(getUangBayar);

            //hitung kembalian
            int totalBayar = Integer.valueOf(txt_total_bayar.getText());
            int uangBayar = Integer.valueOf(txt_uang_bayar.getText());
            int kembalian = uangBayar - totalBayar;
            konf.txt_uang_kembalian_konf.setText(String.valueOf(kembalian));

            String getPoint = txt_point_member.getText();
            konf.txt_point_konf.setText(getPoint);

            //hitung point
            int tmbhPoint = 0;
            if(ada_member.isSelected()){
                if((totalBayar>0) && (totalBayar<=500000)){
                    tmbhPoint = 1;
                }else if ((totalBayar>500000) && (totalBayar<=1000000)){
                    tmbhPoint = 2;
                }else if((totalBayar>1000000) && (totalBayar<=1500000)){
                    tmbhPoint = 3;
                }else if((totalBayar>1500000) && (totalBayar<=2000000)){
                    tmbhPoint = 4;
                }else if((totalBayar>2000000) && (totalBayar<=2500000)){
                    tmbhPoint = 5;
                }else if((totalBayar>2500000) && (totalBayar<=3000000)){
                    tmbhPoint = 6;
                }else if((totalBayar>3000000) && (totalBayar<=3500000)){
                    tmbhPoint = 7;
                }else if((totalBayar>3500000) && (totalBayar<=4000000)){
                    tmbhPoint = 7;
                }else{
                    tmbhPoint = 8;
                }
            }if(tidak_member.isSelected()){
                tmbhPoint = 0;
            }
            konf.txt_tambah_point_konf.setText(String.valueOf(tmbhPoint));
            
            //hitung total point
            int pointAwal = Integer.valueOf(txt_point_member.getText());
            int htgTotalPoint = pointAwal + tmbhPoint;
            konf.txt_total_point_konf.setText(String.valueOf(htgTotalPoint));
            
            String getIdMember = null;
            String getNamaMember = null;
            if(ada_member.isSelected()){
                getIdMember = txt_id_member.getText();
                getNamaMember = (String) combo_nama_member.getSelectedItem();
            }else if(tidak_member.isSelected()){
                getIdMember = "1";
                getNamaMember = "-";
            }
            konf.txt_id_member_konf.setText(getIdMember);
            konf.txt_nama_member_konf.setText(getNamaMember);
            
            konf.setVisible(true);
            hide();
        }
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
        
        txt_jumlah.setText("");
    }//GEN-LAST:event_combo_nama_produkActionPerformed

    private void txt_id_memberActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_id_memberActionPerformed

    }//GEN-LAST:event_txt_id_memberActionPerformed

    private void btn_edit_produkMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_edit_produkMouseEntered
        btn_edit_produk.setBackground(new java.awt.Color(128,136,203));
        btn_edit_produk.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_btn_edit_produkMouseEntered

    private void btn_edit_produkMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_edit_produkMouseExited
        btn_edit_produk.setBackground(new java.awt.Color(255, 255, 255));
        btn_edit_produk.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btn_edit_produkMouseExited

    private void btn_edit_produkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_edit_produkActionPerformed
        String adaMember = null;
        if(ada_member.isSelected()){
            adaMember = txt_id_member.getText();
        }else if(tidak_member.isSelected()){
            adaMember = "1";
        }
        
        //hitung total harga
        int jumlahProduk = Integer.valueOf(txt_jumlah.getText());
        int hargaSatuanProduk = Integer.valueOf(txt_harga_satuan.getText());
        int htgTotalHarga = jumlahProduk * hargaSatuanProduk;
        
        String data[] = new String[4];
        try {
            Class.forName(driver);
            java.sql.Connection kon = DriverManager.getConnection(
                                database,
                                user,
                                pass);
            Statement stt = kon.createStatement();
            String SQL = "UPDATE t_detail_struk "
                    + "SET Username = '"+Username+"', "
                    + "IdMember = '"+adaMember+"', "
                    + "Jumlah = '"+txt_jumlah.getText()+"', "
                    + "TotalHarga = '"+htgTotalHarga+"' "
                    + "WHERE NoStruk = '"+txt_no_struk.getText()+"' "
                    + "AND IdBarang = '"+txt_id_produk.getText()+"';";

            stt.executeUpdate(SQL);
            data[0] = txt_id_produk.getText();
            data[1] = (String) combo_nama_produk.getSelectedItem();
            data[2] = txt_jumlah.getText();
            data[3] = String.valueOf(htgTotalHarga);
            tableModel.removeRow(row);
            tableModel.insertRow(row, data);
            stt.close();
            kon.close();
            txt_id_produk.setText("");
            txt_jumlah.setText("");
            txt_harga_satuan.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Gagal!", JOptionPane.INFORMATION_MESSAGE);
        }
        tampil_total_bayar();
    }//GEN-LAST:event_btn_edit_produkActionPerformed

    private void btn_hapus_produkMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hapus_produkMouseEntered
        btn_hapus_produk.setBackground(new java.awt.Color(128,136,203));
        btn_hapus_produk.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_btn_hapus_produkMouseEntered

    private void btn_hapus_produkMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_hapus_produkMouseExited
        btn_hapus_produk.setBackground(new java.awt.Color(255, 255, 255));
        btn_hapus_produk.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btn_hapus_produkMouseExited

    private void btn_hapus_produkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapus_produkActionPerformed
        try {
            Class.forName(driver);
            java.sql.Connection kon = DriverManager.getConnection(
                                    database,
                                    user,
                                    pass);
            Statement stt = kon.createStatement();
            String SQL = "DELETE FROM t_detail_struk "
                    + "WHERE NoStruk = '"+txt_no_struk.getText()+"' "
                    + "AND IdBarang = '"+txt_id_produk.getText()+"';";
            stt.executeUpdate(SQL);
            tableModel.removeRow(row);
            stt.close();
            kon.close();
            btn_hapus_produk.setEnabled(false);
            btn_edit_produk.setEnabled(false);
            btn_batal_produk.setEnabled(false);
            btn_batal_produk.setEnabled(false);
            btn_tambah_produk.setEnabled(true);
            txt_id_produk.setText("");
            txt_jumlah.setText("");
            txt_harga_satuan.setText("");
            txt_total_bayar.setText("");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Gagal!", JOptionPane.INFORMATION_MESSAGE);
        }
        tampil_total_bayar();
    }//GEN-LAST:event_btn_hapus_produkActionPerformed

    private void txt_no_strukActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_no_strukActionPerformed
        
    }//GEN-LAST:event_txt_no_strukActionPerformed

    private void btn_transaksiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_transaksiActionPerformed
        htgStruk = struk + 1;
        try{
            Connection kon = DriverManager.getConnection(database, user, pass);
            Statement stt = kon.createStatement();
            String sql = "INSERT INTO t_struk(NoStruk,WaktuStruk,TotalBayar)"
                    + "VALUES('"+htgStruk+"',now(),'0');";    
            stt.executeUpdate(sql);
            txt_no_struk.setText(String.valueOf(htgStruk));
            txt_id_produk.setText("");
            txt_jumlah.setEnabled(true);
            txt_harga_satuan.setText("");
            btn_tambah_produk.setEnabled(true);
            txt_total_bayar.setText("");
            txt_uang_bayar.setEnabled(true);
            combo_nama_produk.setEnabled(true);
            btn_batal_produk.setEnabled(true);
            btn_transaksi.setEnabled(false);
            stt.close();
        }catch(Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_btn_transaksiActionPerformed

    private void combo_nama_kasirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_nama_kasirActionPerformed
        int idx = combo_nama_kasir.getSelectedIndex();
        
        if(arrUser.size() > 0){
            Username = arrUser.get(idx).getUsername();
        }
    }//GEN-LAST:event_combo_nama_kasirActionPerformed

    private void txt_total_bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_total_bayarActionPerformed
        tampil_total_bayar();
    }//GEN-LAST:event_txt_total_bayarActionPerformed

    private void tbl_transaksiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_transaksiMouseClicked
        if(evt.getClickCount()==1){
            tampil_field();
            btn_edit_produk.setEnabled(true);
            btn_hapus_produk.setEnabled(true);
            btn_tambah_produk.setEnabled(false);
            btn_batal_produk.setEnabled(true);
        }
    }//GEN-LAST:event_tbl_transaksiMouseClicked

    private void btn_batal_produkMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_batal_produkMouseEntered
        btn_batal_produk.setBackground(new java.awt.Color(128,136,203));
        btn_batal_produk.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_btn_batal_produkMouseEntered

    private void btn_batal_produkMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_batal_produkMouseExited
        btn_batal_produk.setBackground(new java.awt.Color(255, 255, 255));
        btn_batal_produk.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btn_batal_produkMouseExited

    private void btn_batal_produkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batal_produkActionPerformed
        btn_tambah_produk.setEnabled(true);
        btn_edit_produk.setEnabled(false);
        btn_hapus_produk.setEnabled(false);
        txt_id_produk.setText("");
        txt_jumlah.setText("");
        txt_harga_satuan.setText("");
    }//GEN-LAST:event_btn_batal_produkActionPerformed

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
    public javax.swing.JRadioButton ada_member;
    private javax.swing.JButton btn_batal_produk;
    private javax.swing.JButton btn_bayar;
    private javax.swing.JButton btn_edit_produk;
    private javax.swing.JButton btn_hapus_produk;
    private javax.swing.JButton btn_keluar;
    private javax.swing.JButton btn_tambah_produk;
    private javax.swing.JButton btn_transaksi;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox<String> combo_nama_kasir;
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
    private javax.swing.JLabel lbl_nama_kasir;
    private javax.swing.JLabel lbl_nama_member;
    private javax.swing.JLabel lbl_nama_produk;
    private javax.swing.JLabel lbl_no_struk;
    private javax.swing.JLabel lbl_point_member;
    private javax.swing.JLabel lbl_tanya_member;
    private javax.swing.JLabel lbl_total_bayar;
    private javax.swing.JLabel lbl_uang_bayar;
    private javax.swing.JTable tbl_transaksi;
    public javax.swing.JRadioButton tidak_member;
    private javax.swing.JTextField txt_harga_satuan;
    public javax.swing.JTextField txt_id_member;
    private javax.swing.JTextField txt_id_produk;
    private javax.swing.JTextField txt_jumlah;
    public javax.swing.JTextField txt_no_struk;
    private javax.swing.JTextField txt_point_member;
    public javax.swing.JTextField txt_total_bayar;
    public javax.swing.JTextField txt_uang_bayar;
    // End of variables declaration//GEN-END:variables
}
