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
public class frm_nilai extends javax.swing.JFrame {

    koneksi dbsetting;
    String driver, database, user, pass;
    Object tabel;
    
    String nama_mahasiswa;
    String nim;
    String kd_mk;
    String nama_mk;
    
    ArrayList<Mahasiswa> arrMahasiswa = new ArrayList<>();
    ArrayList<MataKuliah> arrMataKuliah = new ArrayList<>();
    /**
     * Creates new form frm_nilai
     */
    public frm_nilai() {
        initComponents();
        
        dbsetting = new koneksi();
        driver = dbsetting.SettingPanel("DBDriver");
        database = dbsetting.SettingPanel("DBDatabase");
        user = dbsetting.SettingPanel("DBUsername");
        pass = dbsetting.SettingPanel("DBPassword");
        tbl_nilai.setModel(tableModel);
        settableload();
        tampil_combo_nama_mahasiswa();
        tampil_nim();
        tampil_combo_mata_kulah();
        tampil_kd_mk();
    }
    
    private javax.swing.table.DefaultTableModel tableModel = getDefaultTabelModel();
    private javax.swing.table.DefaultTableModel getDefaultTabelModel() {
        //  Membuat judul header
        return new javax.swing.table.DefaultTableModel
        (
            new Object[][] {},
            new String [] {
                "Nama",
                "Nama Mata Kuliah",
                "Absensi",
                "Tgs 1",
                "Tgs 2",
                "Tgs 3",
                "UTS",
                "UAS",
                "Nilai Absen",
                "Nilai Tugas",
                "Nilai UTS",
                "Nilai UAS",
                "Nilai Akhir",
                "Indeks",
                "Ket",
            }
        )
                
        // disable perubahan pada grid
        {
            boolean[] canEdit = new boolean[]
            {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false,
            };
            
            public boolean isCellEditable(int rowIndex, int columnIndex)
            {
                return canEdit[columnIndex];
            }
        };
    }
    
    String data[]=new String[17];
 
    private void settableload() {
        String stat = "";
        try {
            Class.forName(driver);
            java.sql.Connection kon = DriverManager.getConnection(
                    database,
                    user,
                    pass);
            Statement stt = kon.createStatement();
            String SQL = "select t_mahasiswa.nama, t_mata_kuliah.nama_mk, t_nilai.kehadiran,\n" +
                    "t_nilai.tugas_satu, t_nilai.tugas_dua, t_nilai.tugas_tiga, t_nilai.uts, t_nilai.uas, t_nilai.nilai_absen, t_nilai.nilai_tugas, t_nilai.nilai_uts, t_nilai.nilai_uas, t_nilai.nilai_akhir, t_nilai.indeks, t_nilai.ket\n" +
                    "from t_nilai JOIN t_mata_kuliah ON\n" +
                    "t_nilai.kd_mk = t_mata_kuliah.kd_mk JOIN t_mahasiswa ON\n" +
                    "t_nilai.nim = t_mahasiswa.nim";
            ResultSet res = stt.executeQuery(SQL);
            
            while (res.next()) {
                data[0] = res.getString(1);
                data[1] = res.getString(2);
                data[2] = res.getString(3);
                data[3] = res.getString(4);
                data[4] = res.getString(5);
                data[5] = res.getString(6);
                data[6] = res.getString(7);
                data[7] = res.getString(8);
                data[8] = res.getString(9);
                data[9] = res.getString(10);
                data[10] = res.getString(11);
                data[11] = res.getString(12);
                data[12] = res.getString(13);
                data[13] = res.getString(14);
                data[14] = res.getString(15);
                tableModel.addRow(data);
            }
            res.close();
            stt.close();
            kon.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR",
                    JOptionPane.INFORMATION_MESSAGE);
            System.exit(0);
        }
    }
    
    public void membersihkan_teks(){
        txt_nilai_kd_mk.setText("");
        txt_nilai_nim.setText("");
        txt_nilai_kehadiran.setText("");
        txt_nilai_tugas1.setText("");
        txt_nilai_tugas2.setText("");
        txt_nilai_tugas3.setText("");
        txt_nilai_uts.setText("");
        txt_nilai_uas.setText("");
    }
    
    public void nonaktif_teks(){
        txt_nilai_kd_mk.setEnabled(false);
        txt_nilai_nim.setEnabled(false);
        txt_nilai_kehadiran.setEnabled(false);
        txt_nilai_tugas1.setEnabled(false);
        txt_nilai_tugas2.setEnabled(false);
        txt_nilai_tugas3.setEnabled(false);
        txt_nilai_uts.setEnabled(false);
        txt_nilai_uas.setEnabled(false);
    }
    
    public void aktif_teks(){
        txt_nilai_kd_mk.setEnabled(true);
        txt_nilai_nim.setEnabled(true);
        txt_nilai_kehadiran.setEnabled(true);
        txt_nilai_tugas1.setEnabled(true);
        txt_nilai_tugas2.setEnabled(true);
        txt_nilai_tugas3.setEnabled(true);
        txt_nilai_uts.setEnabled(true);
        txt_nilai_uas.setEnabled(true);
    }
    
    int row = 0;
    public void tampil_field(){
        row = tbl_nilai.getSelectedRow();
        combo_nilai_nama.setSelectedItem(tableModel.getValueAt(row, 0));
        combo_nilai_nama_mk.setSelectedItem(tableModel.getValueAt(row, 1));
//        txt_nilai_nim.setText(data[3].toString());
        txt_nilai_kehadiran.setText(tableModel.getValueAt(row, 2).toString());
        txt_nilai_tugas1.setText(tableModel.getValueAt(row, 3).toString());
        txt_nilai_tugas2.setText(tableModel.getValueAt(row, 4).toString());
        txt_nilai_tugas3.setText(tableModel.getValueAt(row, 5).toString());
        txt_nilai_uts.setText(tableModel.getValueAt(row, 6).toString());
        txt_nilai_uas.setText(tableModel.getValueAt(row, 7).toString());
        
        btn_nilai_simpan.setEnabled(false);
        btn_nilai_ubah.setEnabled(true);
        btn_nilai_hapus.setEnabled(true);
        btn_nilai_batal.setEnabled(true);
        aktif_teks();
    }
                      
    public void tampil_combo_nama_mahasiswa(){
        try {
            Connection kon = DriverManager.getConnection(database, user, pass);
            Statement stt = kon.createStatement();
            String sql = "SELECT nim, nama FROM t_mahasiswa ORDER BY nama ASC;";
            ResultSet res = stt.executeQuery(sql);
            while(res.next()){
                arrMahasiswa.add(new Mahasiswa(res.getString("nim"), res.getString("nama")));
                // fungsi ini bertugas menampung isi dari database
            }
            for(int i=0;i<arrMahasiswa.size();i++){
                combo_nilai_nama.addItem(arrMahasiswa.get(i).getNama());
            }
            res.close();
            stt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void tampil_nim(){
        int idx = combo_nilai_nama.getSelectedIndex();
        nama_mahasiswa = (String)combo_nilai_nama.getSelectedItem();
        String data[] = new String[1];
        if(idx>=0){
            try {
                Connection kon = DriverManager.getConnection(database, user, pass);
                Statement stt = kon.createStatement();
                String sql = "SELECT nim FROM t_mahasiswa WHERE nama='"+nama_mahasiswa+"'";      
                ResultSet res = stt.executeQuery(sql);
                while(res.next()){
                    data[0] = res.getString(1);
                    txt_nilai_nim.setText(data[0]);
                }
                res.close();
                stt.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
    public void tampil_combo_mata_kulah(){
        try {
            Connection kon = DriverManager.getConnection(database, user, pass);
            Statement stt = kon.createStatement();
            String sql = "SELECT kd_mk, nama_mk FROM t_mata_kuliah ORDER BY nama_mk ASC;";
            ResultSet res = stt.executeQuery(sql);
            while(res.next()){
                arrMataKuliah.add(new MataKuliah(res.getString("kd_mk"), res.getString("nama_mk")));
                // fungsi ini bertugas menampung isi dari database
            }
            for(int i=0;i<arrMataKuliah.size();i++){
                combo_nilai_nama_mk.addItem(arrMataKuliah.get(i).getNamaMK());
            }
            res.close();
            stt.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void tampil_kd_mk(){
        int idx = combo_nilai_nama_mk.getSelectedIndex();
        nama_mk = (String)combo_nilai_nama_mk.getSelectedItem();
        String data[] = new String[1];
        if(idx>=0){
            try {
                Connection kon = DriverManager.getConnection(database, user, pass);
                Statement stt = kon.createStatement();
                String sql = "SELECT kd_mk FROM t_mata_kuliah WHERE nama_mk='"+nama_mk+"'";      
                ResultSet res = stt.executeQuery(sql);
                while(res.next()){
                    data[0] = res.getString(1);
                    txt_nilai_kd_mk.setText(data[0]);
                }
                res.close();
                stt.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
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
        jPanel2 = new javax.swing.JPanel();
        lbl_jdl_nilai = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        lbl_key = new javax.swing.JLabel();
        txt_nilai_key = new javax.swing.JTextField();
        lbl_nilai_nama = new javax.swing.JLabel();
        combo_nilai_nama = new javax.swing.JComboBox<>();
        lbl_nilai_nim = new javax.swing.JLabel();
        txt_nilai_nim = new javax.swing.JTextField();
        lbl_nilai_kehadiran = new javax.swing.JLabel();
        lbl_nilai_tugas1 = new javax.swing.JLabel();
        lbl_nilai_tugas2 = new javax.swing.JLabel();
        lbl_nilai_tugas3 = new javax.swing.JLabel();
        lbl_nilai_nama_mk = new javax.swing.JLabel();
        combo_nilai_nama_mk = new javax.swing.JComboBox<>();
        txt_nilai_kehadiran = new javax.swing.JTextField();
        lbl_nilai_pertemuan = new javax.swing.JLabel();
        txt_nilai_tugas1 = new javax.swing.JTextField();
        txt_nilai_tugas2 = new javax.swing.JTextField();
        txt_nilai_tugas3 = new javax.swing.JTextField();
        lbl_nilai_kd_mk = new javax.swing.JLabel();
        lbl_nilai_uts = new javax.swing.JLabel();
        lbl_nilai_uas = new javax.swing.JLabel();
        lbl_nilai_angkatan = new javax.swing.JLabel();
        txt_nilai_kd_mk = new javax.swing.JTextField();
        txt_nilai_uts = new javax.swing.JTextField();
        txt_nilai_uas = new javax.swing.JTextField();
        year_nilai_angkatan = new com.toedter.calendar.JYearChooser();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_nilai = new javax.swing.JTable();
        btn_nilai_tambah = new javax.swing.JButton();
        btn_nilai_ubah = new javax.swing.JButton();
        btn_nilai_hapus = new javax.swing.JButton();
        btn_nilai_simpan = new javax.swing.JButton();
        btn_nilai_batal = new javax.swing.JButton();
        btn_mata_kuliah_keluar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("DATA NILAI");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(209, 209, 229));

        jPanel2.setBackground(new java.awt.Color(162, 169, 226));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));

        lbl_jdl_nilai.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        lbl_jdl_nilai.setText("FORM NILAI MAHASISWA");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(540, 540, 540)
                .addComponent(lbl_jdl_nilai)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_jdl_nilai)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel7.setBackground(new java.awt.Color(209, 209, 229));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "PENCARIAN DATA", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Microsoft YaHei", 1, 12))); // NOI18N

        lbl_key.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lbl_key.setText("Masukkan Kata Kunci");

        txt_nilai_key.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        txt_nilai_key.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_nilai_keyKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbl_key)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_nilai_key, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_key)
                    .addComponent(txt_nilai_key, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        lbl_nilai_nama.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lbl_nilai_nama.setText("Nama");

        combo_nilai_nama.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        combo_nilai_nama.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_nilai_namaActionPerformed(evt);
            }
        });

        lbl_nilai_nim.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lbl_nilai_nim.setText("NIM");

        txt_nilai_nim.setEditable(false);
        txt_nilai_nim.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        txt_nilai_nim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nilai_nimActionPerformed(evt);
            }
        });

        lbl_nilai_kehadiran.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lbl_nilai_kehadiran.setText("Kehadiran");

        lbl_nilai_tugas1.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lbl_nilai_tugas1.setText("Tugas 1");

        lbl_nilai_tugas2.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lbl_nilai_tugas2.setText("Tugas 2");

        lbl_nilai_tugas3.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lbl_nilai_tugas3.setText("Tugas 3");

        lbl_nilai_nama_mk.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lbl_nilai_nama_mk.setText("Nama MK");

        combo_nilai_nama_mk.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        combo_nilai_nama_mk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                combo_nilai_nama_mkActionPerformed(evt);
            }
        });

        txt_nilai_kehadiran.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N

        lbl_nilai_pertemuan.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lbl_nilai_pertemuan.setText("pertemuan");

        txt_nilai_tugas1.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N

        txt_nilai_tugas2.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N

        txt_nilai_tugas3.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N

        lbl_nilai_kd_mk.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lbl_nilai_kd_mk.setText("Kode MK");

        lbl_nilai_uts.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lbl_nilai_uts.setText("UTS");

        lbl_nilai_uas.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lbl_nilai_uas.setText("UAS");

        lbl_nilai_angkatan.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lbl_nilai_angkatan.setText("Angkatan");

        txt_nilai_kd_mk.setEditable(false);
        txt_nilai_kd_mk.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N

        txt_nilai_uts.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N

        txt_nilai_uas.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N

        tbl_nilai.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tbl_nilai.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        tbl_nilai.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nama", "Nama Mata Kuliah", "Absensi", "Tgs 1", "Tgs 2", "Tgs 3", "UTS", "UAS", "Nilai Absen", "Nilai Tugas", "Nilai UTS", "Nilai UAS", "Nilai Akhir", "Indeks", "Ket"
            }
        ));
        tbl_nilai.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_nilaiMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_nilai);

        btn_nilai_tambah.setBackground(new java.awt.Color(255, 255, 255));
        btn_nilai_tambah.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        btn_nilai_tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kemahasiswaan_10119001_10119013/tambah.png"))); // NOI18N
        btn_nilai_tambah.setText("TAMBAH");
        btn_nilai_tambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_nilai_tambahMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_nilai_tambahMouseExited(evt);
            }
        });
        btn_nilai_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nilai_tambahActionPerformed(evt);
            }
        });

        btn_nilai_ubah.setBackground(new java.awt.Color(255, 255, 255));
        btn_nilai_ubah.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        btn_nilai_ubah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kemahasiswaan_10119001_10119013/ubah.png"))); // NOI18N
        btn_nilai_ubah.setText("UBAH");
        btn_nilai_ubah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_nilai_ubahMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_nilai_ubahMouseExited(evt);
            }
        });
        btn_nilai_ubah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nilai_ubahActionPerformed(evt);
            }
        });

        btn_nilai_hapus.setBackground(new java.awt.Color(255, 255, 255));
        btn_nilai_hapus.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        btn_nilai_hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kemahasiswaan_10119001_10119013/hapus.png"))); // NOI18N
        btn_nilai_hapus.setText("HAPUS");
        btn_nilai_hapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_nilai_hapusMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_nilai_hapusMouseExited(evt);
            }
        });
        btn_nilai_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nilai_hapusActionPerformed(evt);
            }
        });

        btn_nilai_simpan.setBackground(new java.awt.Color(255, 255, 255));
        btn_nilai_simpan.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        btn_nilai_simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kemahasiswaan_10119001_10119013/simpan.png"))); // NOI18N
        btn_nilai_simpan.setText("SIMPAN");
        btn_nilai_simpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_nilai_simpanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_nilai_simpanMouseExited(evt);
            }
        });
        btn_nilai_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nilai_simpanActionPerformed(evt);
            }
        });

        btn_nilai_batal.setBackground(new java.awt.Color(255, 255, 255));
        btn_nilai_batal.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        btn_nilai_batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kemahasiswaan_10119001_10119013/batal.png"))); // NOI18N
        btn_nilai_batal.setText("BATAL");
        btn_nilai_batal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_nilai_batalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_nilai_batalMouseExited(evt);
            }
        });
        btn_nilai_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nilai_batalActionPerformed(evt);
            }
        });

        btn_mata_kuliah_keluar.setBackground(new java.awt.Color(255, 255, 255));
        btn_mata_kuliah_keluar.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        btn_mata_kuliah_keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kemahasiswaan_10119001_10119013/keluar.png"))); // NOI18N
        btn_mata_kuliah_keluar.setText("KELUAR");
        btn_mata_kuliah_keluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_mata_kuliah_keluarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_mata_kuliah_keluarMouseExited(evt);
            }
        });
        btn_mata_kuliah_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_mata_kuliah_keluarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_nilai_nama)
                                    .addComponent(lbl_nilai_nim)
                                    .addComponent(lbl_nilai_kehadiran)
                                    .addComponent(lbl_nilai_tugas1)
                                    .addComponent(lbl_nilai_tugas2)
                                    .addComponent(lbl_nilai_tugas3))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(combo_nilai_nama, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txt_nilai_kehadiran, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbl_nilai_pertemuan))
                                    .addComponent(txt_nilai_tugas1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_nilai_tugas2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_nilai_tugas3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_nilai_nim, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_nilai_kd_mk)
                                    .addComponent(lbl_nilai_nama_mk)
                                    .addComponent(lbl_nilai_uts)
                                    .addComponent(lbl_nilai_uas)
                                    .addComponent(lbl_nilai_angkatan))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(combo_nilai_nama_mk, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nilai_kd_mk, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nilai_uts, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(year_nilai_angkatan, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 70, Short.MAX_VALUE)
                                .addComponent(txt_nilai_uas, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addGap(0, 501, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btn_nilai_tambah)
                                .addGap(18, 18, 18)
                                .addComponent(btn_nilai_ubah)
                                .addGap(18, 18, 18)
                                .addComponent(btn_nilai_hapus)
                                .addGap(18, 18, 18)
                                .addComponent(btn_nilai_simpan)
                                .addGap(18, 18, 18)
                                .addComponent(btn_nilai_batal)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btn_mata_kuliah_keluar)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_nilai_nama)
                            .addComponent(combo_nilai_nama, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_nilai_nama_mk)
                            .addComponent(combo_nilai_nama_mk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_nilai_nim)
                            .addComponent(txt_nilai_nim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_nilai_kd_mk)
                            .addComponent(txt_nilai_kd_mk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_nilai_kehadiran)
                            .addComponent(txt_nilai_kehadiran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_nilai_pertemuan)
                            .addComponent(lbl_nilai_uts)
                            .addComponent(txt_nilai_uts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_nilai_tugas1)
                            .addComponent(txt_nilai_tugas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_nilai_uas)
                            .addComponent(txt_nilai_uas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lbl_nilai_tugas2)
                            .addComponent(txt_nilai_tugas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbl_nilai_angkatan)))
                    .addComponent(year_nilai_angkatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nilai_tugas3)
                    .addComponent(txt_nilai_tugas3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btn_nilai_ubah)
                        .addComponent(btn_nilai_hapus)
                        .addComponent(btn_nilai_simpan)
                        .addComponent(btn_nilai_batal)
                        .addComponent(btn_mata_kuliah_keluar))
                    .addComponent(btn_nilai_tambah))
                .addGap(0, 21, Short.MAX_VALUE))
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

        setSize(new java.awt.Dimension(1371, 730));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        frm_utama u = new frm_utama();
        u.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void btn_nilai_tambahMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nilai_tambahMouseEntered
        btn_nilai_tambah.setBackground(new java.awt.Color(128,136,203));
        btn_nilai_tambah.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_btn_nilai_tambahMouseEntered

    private void btn_nilai_tambahMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nilai_tambahMouseExited
        btn_nilai_tambah.setBackground(new java.awt.Color(255, 255, 255));
        btn_nilai_tambah.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btn_nilai_tambahMouseExited

    private void btn_nilai_ubahMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nilai_ubahMouseEntered
        btn_nilai_ubah.setBackground(new java.awt.Color(128,136,203));
        btn_nilai_ubah.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_btn_nilai_ubahMouseEntered

    private void btn_nilai_ubahMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nilai_ubahMouseExited
        btn_nilai_ubah.setBackground(new java.awt.Color(255, 255, 255));
        btn_nilai_ubah.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btn_nilai_ubahMouseExited

    private void btn_nilai_hapusMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nilai_hapusMouseEntered
        btn_nilai_hapus.setBackground(new java.awt.Color(128,136,203));
        btn_nilai_hapus.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_btn_nilai_hapusMouseEntered

    private void btn_nilai_hapusMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nilai_hapusMouseExited
        btn_nilai_hapus.setBackground(new java.awt.Color(255, 255, 255));
        btn_nilai_hapus.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btn_nilai_hapusMouseExited

    private void btn_nilai_simpanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nilai_simpanMouseEntered
        btn_nilai_simpan.setBackground(new java.awt.Color(128,136,203));
        btn_nilai_simpan.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_btn_nilai_simpanMouseEntered

    private void btn_nilai_simpanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nilai_simpanMouseExited
        btn_nilai_simpan.setBackground(new java.awt.Color(255, 255, 255));
        btn_nilai_simpan.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btn_nilai_simpanMouseExited

    private void btn_nilai_batalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nilai_batalMouseEntered
        btn_nilai_batal.setBackground(new java.awt.Color(128,136,203));
        btn_nilai_batal.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_btn_nilai_batalMouseEntered

    private void btn_nilai_batalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nilai_batalMouseExited
        btn_nilai_batal.setBackground(new java.awt.Color(255, 255, 255));
        btn_nilai_batal.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btn_nilai_batalMouseExited

    private void btn_mata_kuliah_keluarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_mata_kuliah_keluarMouseEntered
        //[255,0,0]
        btn_mata_kuliah_keluar.setBackground(new java.awt.Color(255,102,102));
        btn_mata_kuliah_keluar.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_btn_mata_kuliah_keluarMouseEntered

    private void btn_mata_kuliah_keluarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_mata_kuliah_keluarMouseExited
        btn_mata_kuliah_keluar.setBackground(new java.awt.Color(255, 255, 255));
        btn_mata_kuliah_keluar.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btn_mata_kuliah_keluarMouseExited

    private void btn_mata_kuliah_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_mata_kuliah_keluarActionPerformed
        frm_utama u = new frm_utama();
        u.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_mata_kuliah_keluarActionPerformed

    private void tbl_nilaiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_nilaiMouseClicked
        // TODO add your handling code here:
        if(evt.getClickCount()==1){
            tampil_field();
        }
    }//GEN-LAST:event_tbl_nilaiMouseClicked

    private void btn_nilai_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nilai_hapusActionPerformed
        // TODO add your handling code here:
        try {
             Class.forName(driver);
             java.sql.Connection kon = DriverManager.getConnection(
                                    database,
                                    user,
                                    pass);
             Statement stt = kon.createStatement();
             String SQL = "DELETE FROM t_nilai "
                                    + "WHERE "
                                + "='"+tableModel.getValueAt(row, 0).toString()+"'";
                stt.executeUpdate(SQL);
                tableModel.removeRow(row);
                stt.close();
                kon.close();
                membersihkan_teks();
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }//GEN-LAST:event_btn_nilai_hapusActionPerformed

    private void btn_nilai_ubahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nilai_ubahActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btn_nilai_ubahActionPerformed

    private void txt_nilai_nimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nilai_nimActionPerformed
        
    }//GEN-LAST:event_txt_nilai_nimActionPerformed

    private void combo_nilai_namaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_nilai_namaActionPerformed
        int idx = combo_nilai_nama.getSelectedIndex();
        
        if(arrMahasiswa.size() > 0){
            nim = arrMahasiswa.get(idx).getNim();
            tampil_nim();
        }
    }//GEN-LAST:event_combo_nilai_namaActionPerformed

    private void combo_nilai_nama_mkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_combo_nilai_nama_mkActionPerformed
        int idx = combo_nilai_nama_mk.getSelectedIndex();
        
        if(arrMataKuliah.size() > 0){
            kd_mk = arrMataKuliah.get(idx).getNamaMK();
            tampil_kd_mk();
        }
    }//GEN-LAST:event_combo_nilai_nama_mkActionPerformed

    private void txt_nilai_keyKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_nilai_keyKeyReleased
        tableModel.setRowCount(0);
        try{
            Class.forName(driver);
            Connection kon = DriverManager.getConnection(database, user, pass);
            Statement stt = kon.createStatement();
            String sql = "SELECT t_mahasiswa.nama, t_mata_kuliah.nama_mk, t_nilai.kehadiran, t_nilai.tugas_satu, t_nilai.tugas_dua, t_nilai.tugas_tiga, t_nilai.uts, t_nilai.uas, t_nilai.nilai_absen, t_nilai.nilai_tugas, t_nilai.nilai_uts, t_nilai.nilai_uas, t_nilai.nilai_akhir, t_nilai.indeks, t_nilai.ket"
                        + "FROM t_nilai "
                        + "JOIN t_mahasiswa ON t_nilai.nim = t_mahasiswa.nim "
                        + "JOIN t_mata_kuliah ON t_nilai.kd_mk = t_mata_kuliah.kd_mk "
                        + "WHERE (t_mahasiswa.nama LIKE '%" + txt_nilai_key.getText() + "%') "
                        + "OR (t_mahasiswa.nim LIKE '%" + txt_nilai_key.getText() + "%') "
                        + "OR (t_mata_kuliah.kd_mk LIKE '%" + txt_nilai_key.getText() + "%') "
                        + "OR (t_mata_kuliah.nama_mk LIKE '%" + txt_nilai_key.getText() + "%') "
                        + "OR (t_nilai.indeks LIKE '%" + txt_nilai_key.getText() + "%') "
                        + "OR (t_nilai.ket LIKE '%" + txt_nilai_key.getText() + "%') "
                        + "ORDER BY t_mahasiswa.nama ASC;";
            ResultSet res = stt.executeQuery(sql);
            while(res.next()){
                data[0] = res.getString(1);
                data[1] = res.getString(2);
                data[2] = res.getString(3);
                data[3] = res.getString(4);
                data[4] = res.getString(5);
                data[5] = res.getString(6);
                data[6] = res.getString(7);
                data[7] = res.getString(8);
                data[8] = res.getString(9);
                data[9] = res.getString(10);
                data[10] = res.getString(11);
                data[11] = res.getString(12);
                data[12] = res.getString(13);
                data[13] = res.getString(14);
                data[14] = res.getString(15);
                tableModel.addRow(data);
            }
            res.close();
            stt.close();
            kon.close();
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }//GEN-LAST:event_txt_nilai_keyKeyReleased

    private void btn_nilai_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nilai_simpanActionPerformed
        // TODO add your handling code here:
        String data[] = new String[17];
        double jmlhPertemuan = Double.valueOf(txt_nilai_kehadiran.getText());
        int angkatan = 2021;
        double tugas_satu = Double.valueOf(txt_nilai_tugas1.getText());
        double tugas_dua = Double.valueOf(txt_nilai_tugas2.getText());
        double tugas_tiga = Double.valueOf(txt_nilai_tugas3.getText());
        double uts = Double.valueOf(txt_nilai_uts.getText());
        double uas = Double.valueOf(txt_nilai_uas.getText());
        
        if (("".equals(txt_nilai_kehadiran.getText())) || ("".equals(txt_nilai_tugas1.getText())) || ("".equals(txt_nilai_tugas2.getText())) || ("".equals(txt_nilai_tugas3.getText())) || ("".equals(txt_nilai_uts.getText())) || ("".equals(txt_nilai_uas.getText()))){
            JOptionPane.showMessageDialog(null, "Data tidak boleh kosong, silahkan dilengkapi", "Error!", JOptionPane.CANCEL_OPTION);
        } else {
            //hitung nilai_absen
            double nilai_absen = (jmlhPertemuan/14)*5;

            //hitung nilai_tugas
            double rataTugas = (tugas_satu + tugas_dua + tugas_tiga)/3;
            double nilai_tugas = rataTugas *0.25;

            //hitung nilai_uts
            double nilai_uts = uts * 0.30;

            //hitung nilai_uas
            double nilai_uas = uas * 0.40;

            //hitung nilai_akhir
            double nilai_akhir = nilai_absen + nilai_tugas + nilai_uts + nilai_uas;

            //cari nilai indeks dan keterangan
            String indeks = "";
            String ket = "";
            if((nilai_akhir >= 80) && (nilai_akhir <=100)){
                indeks = "A";
                if(jmlhPertemuan<11){
                    ket = "Tidak Lulus";
                }else{
                    ket = "Lulus";
                }
            }if((nilai_akhir >= 68) && (nilai_akhir <80)){
                indeks = "B";
                if(jmlhPertemuan<11){
                    ket = "Tidak Lulus";
                }else{
                    ket = "Lulus";
                }
            }if((nilai_akhir >= 56) && (nilai_akhir <68)){
                indeks = "C";
                if(jmlhPertemuan<11){
                    ket = "Tidak Lulus";
                }else{
                    ket = "Lulus";
                }
            }if((nilai_akhir >= 45) && (nilai_akhir <56)){
                indeks = "D";
                ket = "Tidak Lulus";
            }if((nilai_akhir >= 0) && (nilai_akhir <45)){
                indeks = "E";
                ket = "Tidak Lulus";
            }
            
            try {
                Class.forName(driver);
                java.sql.Connection kon = DriverManager.getConnection(
                                    database,
                                    user,
                                    pass);
                Statement stt = kon.createStatement();
                String SQL = "INSERT INTO t_nilai"
                                + "(nim, kd_mk, kehadiran, tugas_satu, tugas_dua, tugas_tiga, uts, uas, angkatan, nilai_absen, nilai_tugas, nilai_uts, nilai_uas, nilai_akhir, indeks, ket)"
                                + "VALUES "
                                + "('"+txt_nilai_nim.getText()+"',"
                                + " '"+txt_nilai_kd_mk.getText()+"' ,"
                                + " '"+jmlhPertemuan+"' ,"
                                + " '"+tugas_satu+"' ,"
                                + " '"+tugas_dua+"' ,"
                                + " '"+tugas_tiga+"' ,"
                                + " '"+uts+"' ,"
                                + " '"+uas+"' ,"
                                + " '"+angkatan+"' ,"
                                + " '"+nilai_absen+"' ,"
                                + " '"+nilai_tugas+"' ,"
                                + " '"+nilai_uts+"' ,"
                                + " '"+nilai_uas+"' ,"
                                + " '"+nilai_akhir+"' ,"
                                + " '"+indeks+"' ,"
                                + " '"+ket+"' )";
                
                stt.executeUpdate(SQL);
                data[0] = combo_nilai_nama.getSelectedItem().toString();
                data[1] = combo_nilai_nama_mk.getSelectedItem().toString();
                data[2] = String.valueOf(jmlhPertemuan);
                data[3] = String.valueOf(tugas_satu);
                data[4] = String.valueOf(tugas_dua);
                data[5] = String.valueOf(tugas_tiga);
                data[6] = String.valueOf(uts);
                data[7] = String.valueOf(uas);
                data[8] = String.valueOf(nilai_absen);
                data[9] = String.valueOf(nilai_tugas);
                data[10] = String.valueOf(nilai_uts);
                data[11] = String.valueOf(nilai_uas);
                data[12] = String.valueOf(nilai_akhir);
                data[13] = indeks;
                data[14] = ket;
                tableModel.addRow(data);
                stt.close();
                kon.close();
                membersihkan_teks();
                btn_nilai_simpan.setEnabled(false);
                nonaktif_teks();
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Eror",
                JOptionPane.INFORMATION_MESSAGE);
            }    
        }
    }//GEN-LAST:event_btn_nilai_simpanActionPerformed

    private void btn_nilai_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nilai_tambahActionPerformed
        // TODO add your handling code here:
        membersihkan_teks();
        btn_nilai_tambah.setEnabled(false);
        btn_nilai_ubah.setEnabled(false);
        btn_nilai_hapus.setEnabled(false);
        btn_nilai_simpan.setEnabled(true);
        btn_nilai_batal.setEnabled(true);
        tampil_nim();
        tampil_kd_mk();
    }//GEN-LAST:event_btn_nilai_tambahActionPerformed

    private void btn_nilai_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nilai_batalActionPerformed
        membersihkan_teks();
        btn_nilai_tambah.setEnabled(true);
        btn_nilai_simpan.setEnabled(false);
        btn_nilai_ubah.setEnabled(false);
        btn_nilai_hapus.setEnabled(false);
    }//GEN-LAST:event_btn_nilai_batalActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        btn_nilai_tambah.setEnabled(true);
        btn_nilai_simpan.setEnabled(false);
        btn_nilai_ubah.setEnabled(false);
        btn_nilai_hapus.setEnabled(false);
        btn_nilai_batal.setEnabled(false);
        txt_nilai_nim.setText("");
        txt_nilai_kd_mk.setText("");
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(frm_nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_nilai.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_nilai().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_mata_kuliah_keluar;
    private javax.swing.JButton btn_nilai_batal;
    private javax.swing.JButton btn_nilai_hapus;
    private javax.swing.JButton btn_nilai_simpan;
    private javax.swing.JButton btn_nilai_tambah;
    private javax.swing.JButton btn_nilai_ubah;
    private javax.swing.JComboBox<String> combo_nilai_nama;
    private javax.swing.JComboBox<String> combo_nilai_nama_mk;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbl_jdl_nilai;
    private javax.swing.JLabel lbl_key;
    private javax.swing.JLabel lbl_nilai_angkatan;
    private javax.swing.JLabel lbl_nilai_kd_mk;
    private javax.swing.JLabel lbl_nilai_kehadiran;
    private javax.swing.JLabel lbl_nilai_nama;
    private javax.swing.JLabel lbl_nilai_nama_mk;
    private javax.swing.JLabel lbl_nilai_nim;
    private javax.swing.JLabel lbl_nilai_pertemuan;
    private javax.swing.JLabel lbl_nilai_tugas1;
    private javax.swing.JLabel lbl_nilai_tugas2;
    private javax.swing.JLabel lbl_nilai_tugas3;
    private javax.swing.JLabel lbl_nilai_uas;
    private javax.swing.JLabel lbl_nilai_uts;
    private javax.swing.JTable tbl_nilai;
    private javax.swing.JTextField txt_nilai_kd_mk;
    private javax.swing.JTextField txt_nilai_kehadiran;
    private javax.swing.JTextField txt_nilai_key;
    private javax.swing.JTextField txt_nilai_nim;
    private javax.swing.JTextField txt_nilai_tugas1;
    private javax.swing.JTextField txt_nilai_tugas2;
    private javax.swing.JTextField txt_nilai_tugas3;
    private javax.swing.JTextField txt_nilai_uas;
    private javax.swing.JTextField txt_nilai_uts;
    private com.toedter.calendar.JYearChooser year_nilai_angkatan;
    // End of variables declaration//GEN-END:variables
}