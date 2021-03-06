/*
 * NAMA  : Fiona Avila Putri
 * NIM   : 10119013
 * KELAS : IF1 2019/2020
 */
package kemahasiswaan_10119001_10119013;

/**
 *
 * @author Fiona Avila
 */
public class frm_nilai_akhir extends javax.swing.JFrame {

    /**
     * Creates new form frm_nilai_akhir
     */
    public frm_nilai_akhir() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btn_nilai_akhir_ubah1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        lbl_jdl_nilai_akhir = new javax.swing.JLabel();
        lbl_nilai_akhir_nama_mk = new javax.swing.JLabel();
        combo_nilai_akhir_nama_mk = new javax.swing.JComboBox<>();
        lbl_nilai_akhir_kd_mk = new javax.swing.JLabel();
        txt_nilai_akhir_kd_mk = new javax.swing.JTextField();
        lbl_nilai_akhir_persen_absen = new javax.swing.JLabel();
        txt_nilai_akhir_persen_absen = new javax.swing.JTextField();
        lbl_persen_absen = new javax.swing.JLabel();
        lbl_nilai_akhir_persen_tugas = new javax.swing.JLabel();
        txt_nilai_akhir_persen_tugas = new javax.swing.JTextField();
        lbl_persen_tugas = new javax.swing.JLabel();
        lbl_nilai_akhir_persen_uts = new javax.swing.JLabel();
        txt_nilai_akhir_persen_uts = new javax.swing.JTextField();
        lbl_persen_uts = new javax.swing.JLabel();
        lbl_nilai_akhir_persen_uas = new javax.swing.JLabel();
        txt_nilai_akhir_persen_uas = new javax.swing.JTextField();
        lbl_persen_uas = new javax.swing.JLabel();
        lbl_nilai_akhir_kehadiran = new javax.swing.JLabel();
        txt_nilai_akhir_kehadiran = new javax.swing.JTextField();
        lbl_nilai_akhir_pertemuan = new javax.swing.JLabel();
        lbl_nilai_akhir_tugas1 = new javax.swing.JLabel();
        lbl_nilai_akhir_tugas2 = new javax.swing.JLabel();
        lbl_nilai_akhir_tugas3 = new javax.swing.JLabel();
        txt_nilai_akhir_tugas1 = new javax.swing.JTextField();
        txt_nilai_akhir_tugas2 = new javax.swing.JTextField();
        txt_nilai_akhir_tugas3 = new javax.swing.JTextField();
        lbl_nilai_akhir_uts = new javax.swing.JLabel();
        txt_nilai_akhir_uts = new javax.swing.JTextField();
        lbl_nilai_akhir_uas = new javax.swing.JLabel();
        txt_nilai_akhir_uas = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btn_nilai_akhir_tambah = new javax.swing.JButton();
        btn_nilai_akhir_ubah = new javax.swing.JButton();
        btn_nilai_akhir_hapus = new javax.swing.JButton();
        btn_nilai_akhir_simpan = new javax.swing.JButton();
        btn_nilai_akhir_batal = new javax.swing.JButton();
        btn_nilai_akhir_keluar = new javax.swing.JButton();

        btn_nilai_akhir_ubah1.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        btn_nilai_akhir_ubah1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kemahasiswaan_10119001_10119013/ubah.png"))); // NOI18N
        btn_nilai_akhir_ubah1.setText("UBAH");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SIMULASI NILAI AKHIR");
        setPreferredSize(new java.awt.Dimension(1355, 490));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(209, 209, 229));
        jPanel1.setPreferredSize(new java.awt.Dimension(1355, 490));

        jPanel2.setBackground(new java.awt.Color(162, 169, 226));
        jPanel2.setBorder(javax.swing.BorderFactory.createMatteBorder(1, 1, 1, 1, new java.awt.Color(102, 102, 102)));

        lbl_jdl_nilai_akhir.setFont(new java.awt.Font("Microsoft YaHei", 1, 18)); // NOI18N
        lbl_jdl_nilai_akhir.setText("FORM SIMULASI NILAI AKHIR");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(500, 500, 500)
                .addComponent(lbl_jdl_nilai_akhir)
                .addContainerGap(579, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lbl_jdl_nilai_akhir)
                .addContainerGap())
        );

        lbl_nilai_akhir_nama_mk.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lbl_nilai_akhir_nama_mk.setText("Nama MK");

        combo_nilai_akhir_nama_mk.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        combo_nilai_akhir_nama_mk.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        lbl_nilai_akhir_kd_mk.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lbl_nilai_akhir_kd_mk.setText("Kode MK");

        txt_nilai_akhir_kd_mk.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N

        lbl_nilai_akhir_persen_absen.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lbl_nilai_akhir_persen_absen.setText("Persentase Absen");

        txt_nilai_akhir_persen_absen.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N

        lbl_persen_absen.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lbl_persen_absen.setText("%");

        lbl_nilai_akhir_persen_tugas.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lbl_nilai_akhir_persen_tugas.setText("Persentase Tugas");

        txt_nilai_akhir_persen_tugas.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N

        lbl_persen_tugas.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lbl_persen_tugas.setText("%");

        lbl_nilai_akhir_persen_uts.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lbl_nilai_akhir_persen_uts.setText("Persentase UTS");

        txt_nilai_akhir_persen_uts.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N

        lbl_persen_uts.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lbl_persen_uts.setText("%");

        lbl_nilai_akhir_persen_uas.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lbl_nilai_akhir_persen_uas.setText("Persentase UAS");

        txt_nilai_akhir_persen_uas.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N

        lbl_persen_uas.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lbl_persen_uas.setText("%");

        lbl_nilai_akhir_kehadiran.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lbl_nilai_akhir_kehadiran.setText("Kehadiran");

        txt_nilai_akhir_kehadiran.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N

        lbl_nilai_akhir_pertemuan.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lbl_nilai_akhir_pertemuan.setText("pertemuan");

        lbl_nilai_akhir_tugas1.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lbl_nilai_akhir_tugas1.setText("Tugas 1");

        lbl_nilai_akhir_tugas2.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lbl_nilai_akhir_tugas2.setText("Tugas 2");

        lbl_nilai_akhir_tugas3.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lbl_nilai_akhir_tugas3.setText("Tugas 3");

        txt_nilai_akhir_tugas1.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N

        txt_nilai_akhir_tugas2.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N

        txt_nilai_akhir_tugas3.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N

        lbl_nilai_akhir_uts.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lbl_nilai_akhir_uts.setText("UTS");

        txt_nilai_akhir_uts.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N

        lbl_nilai_akhir_uas.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        lbl_nilai_akhir_uas.setText("UAS");

        txt_nilai_akhir_uas.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N

        jTable1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jTable1.setFont(new java.awt.Font("Microsoft YaHei", 0, 12)); // NOI18N
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Nama MK", "Persen Absen", "Persen Tugas", "Persen UTS", "Persen UAS", "Absensi", "Tgs 1", "Tgs 2", "Tgs 3", "UTS", "UAS", "Nilai Absen", "Nilai Tugas", "Nilai UTS", "Nilai UAS", "Nilai Akhir", "Indeks", "Keterangan"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        btn_nilai_akhir_tambah.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        btn_nilai_akhir_tambah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kemahasiswaan_10119001_10119013/tambah.png"))); // NOI18N
        btn_nilai_akhir_tambah.setText("TAMBAH");
        btn_nilai_akhir_tambah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_nilai_akhir_tambahMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_nilai_akhir_tambahMouseExited(evt);
            }
        });

        btn_nilai_akhir_ubah.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        btn_nilai_akhir_ubah.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kemahasiswaan_10119001_10119013/ubah.png"))); // NOI18N
        btn_nilai_akhir_ubah.setText("UBAH");
        btn_nilai_akhir_ubah.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_nilai_akhir_ubahMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_nilai_akhir_ubahMouseExited(evt);
            }
        });

        btn_nilai_akhir_hapus.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        btn_nilai_akhir_hapus.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kemahasiswaan_10119001_10119013/hapus.png"))); // NOI18N
        btn_nilai_akhir_hapus.setText("HAPUS");
        btn_nilai_akhir_hapus.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_nilai_akhir_hapusMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_nilai_akhir_hapusMouseExited(evt);
            }
        });

        btn_nilai_akhir_simpan.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        btn_nilai_akhir_simpan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kemahasiswaan_10119001_10119013/simpan.png"))); // NOI18N
        btn_nilai_akhir_simpan.setText("SIMPAN");
        btn_nilai_akhir_simpan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_nilai_akhir_simpanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_nilai_akhir_simpanMouseExited(evt);
            }
        });

        btn_nilai_akhir_batal.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        btn_nilai_akhir_batal.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kemahasiswaan_10119001_10119013/batal.png"))); // NOI18N
        btn_nilai_akhir_batal.setText("BATAL");
        btn_nilai_akhir_batal.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_nilai_akhir_batalMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_nilai_akhir_batalMouseExited(evt);
            }
        });

        btn_nilai_akhir_keluar.setFont(new java.awt.Font("Microsoft YaHei", 1, 12)); // NOI18N
        btn_nilai_akhir_keluar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/kemahasiswaan_10119001_10119013/keluar.png"))); // NOI18N
        btn_nilai_akhir_keluar.setText("KELUAR");
        btn_nilai_akhir_keluar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_nilai_akhir_keluarMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_nilai_akhir_keluarMouseExited(evt);
            }
        });
        btn_nilai_akhir_keluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_nilai_akhir_keluarActionPerformed(evt);
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
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_nilai_akhir_nama_mk)
                                    .addComponent(lbl_nilai_akhir_kd_mk))
                                .addGap(62, 62, 62)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(combo_nilai_akhir_nama_mk, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_nilai_akhir_kd_mk, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_nilai_akhir_persen_absen)
                                .addGap(18, 18, 18)
                                .addComponent(txt_nilai_akhir_persen_absen, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_persen_absen))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbl_nilai_akhir_persen_tugas)
                                    .addComponent(lbl_nilai_akhir_persen_uts)
                                    .addComponent(lbl_nilai_akhir_persen_uas))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txt_nilai_akhir_persen_uas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbl_persen_uas))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txt_nilai_akhir_persen_uts, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbl_persen_uts))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txt_nilai_akhir_persen_tugas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(lbl_persen_tugas)))))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addComponent(lbl_nilai_akhir_kehadiran)
                                    .addGap(18, 18, 18))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(lbl_nilai_akhir_tugas1)
                                    .addGap(31, 31, 31)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(lbl_nilai_akhir_tugas2)
                                .addGap(31, 31, 31))
                            .addComponent(lbl_nilai_akhir_tugas3)
                            .addComponent(lbl_nilai_akhir_uts)
                            .addComponent(lbl_nilai_akhir_uas))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txt_nilai_akhir_uas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nilai_akhir_uts, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nilai_akhir_tugas3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_nilai_akhir_tugas2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txt_nilai_akhir_tugas1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txt_nilai_akhir_kehadiran, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbl_nilai_akhir_pertemuan)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btn_nilai_akhir_tambah)
                        .addGap(18, 18, 18)
                        .addComponent(btn_nilai_akhir_ubah)
                        .addGap(18, 18, 18)
                        .addComponent(btn_nilai_akhir_hapus)
                        .addGap(18, 18, 18)
                        .addComponent(btn_nilai_akhir_simpan)
                        .addGap(18, 18, 18)
                        .addComponent(btn_nilai_akhir_batal)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btn_nilai_akhir_keluar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nilai_akhir_nama_mk)
                    .addComponent(combo_nilai_akhir_nama_mk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_nilai_akhir_kehadiran)
                    .addComponent(txt_nilai_akhir_kehadiran, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_nilai_akhir_pertemuan))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nilai_akhir_kd_mk)
                    .addComponent(txt_nilai_akhir_kd_mk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_nilai_akhir_tugas1)
                    .addComponent(txt_nilai_akhir_tugas1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nilai_akhir_persen_absen)
                    .addComponent(txt_nilai_akhir_persen_absen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_persen_absen)
                    .addComponent(lbl_nilai_akhir_tugas2)
                    .addComponent(txt_nilai_akhir_tugas2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nilai_akhir_persen_tugas)
                    .addComponent(txt_nilai_akhir_persen_tugas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_persen_tugas)
                    .addComponent(lbl_nilai_akhir_tugas3)
                    .addComponent(txt_nilai_akhir_tugas3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nilai_akhir_persen_uts)
                    .addComponent(txt_nilai_akhir_persen_uts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_persen_uts)
                    .addComponent(lbl_nilai_akhir_uts)
                    .addComponent(txt_nilai_akhir_uts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_nilai_akhir_persen_uas)
                    .addComponent(txt_nilai_akhir_persen_uas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbl_persen_uas)
                    .addComponent(lbl_nilai_akhir_uas)
                    .addComponent(txt_nilai_akhir_uas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_nilai_akhir_tambah)
                    .addComponent(btn_nilai_akhir_ubah)
                    .addComponent(btn_nilai_akhir_hapus)
                    .addComponent(btn_nilai_akhir_simpan)
                    .addComponent(btn_nilai_akhir_batal)
                    .addComponent(btn_nilai_akhir_keluar))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 691, Short.MAX_VALUE)
        );

        setSize(new java.awt.Dimension(1371, 730));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        frm_utama u = new frm_utama();
        u.setVisible(true);
    }//GEN-LAST:event_formWindowClosing

    private void btn_nilai_akhir_tambahMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nilai_akhir_tambahMouseEntered
        btn_nilai_akhir_tambah.setBackground(new java.awt.Color(128,136,203));
        btn_nilai_akhir_tambah.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_btn_nilai_akhir_tambahMouseEntered

    private void btn_nilai_akhir_tambahMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nilai_akhir_tambahMouseExited
        btn_nilai_akhir_tambah.setBackground(new java.awt.Color(255, 255, 255));
        btn_nilai_akhir_tambah.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btn_nilai_akhir_tambahMouseExited

    private void btn_nilai_akhir_ubahMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nilai_akhir_ubahMouseEntered
        btn_nilai_akhir_ubah.setBackground(new java.awt.Color(128,136,203));
        btn_nilai_akhir_ubah.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_btn_nilai_akhir_ubahMouseEntered

    private void btn_nilai_akhir_ubahMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nilai_akhir_ubahMouseExited
        btn_nilai_akhir_ubah.setBackground(new java.awt.Color(255, 255, 255));
        btn_nilai_akhir_ubah.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btn_nilai_akhir_ubahMouseExited

    private void btn_nilai_akhir_hapusMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nilai_akhir_hapusMouseEntered
        btn_nilai_akhir_hapus.setBackground(new java.awt.Color(128,136,203));
        btn_nilai_akhir_hapus.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_btn_nilai_akhir_hapusMouseEntered

    private void btn_nilai_akhir_hapusMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nilai_akhir_hapusMouseExited
        btn_nilai_akhir_hapus.setBackground(new java.awt.Color(255, 255, 255));
        btn_nilai_akhir_hapus.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btn_nilai_akhir_hapusMouseExited

    private void btn_nilai_akhir_simpanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nilai_akhir_simpanMouseEntered
        btn_nilai_akhir_simpan.setBackground(new java.awt.Color(128,136,203));
        btn_nilai_akhir_simpan.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_btn_nilai_akhir_simpanMouseEntered

    private void btn_nilai_akhir_simpanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nilai_akhir_simpanMouseExited
        btn_nilai_akhir_simpan.setBackground(new java.awt.Color(255, 255, 255));
        btn_nilai_akhir_simpan.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btn_nilai_akhir_simpanMouseExited

    private void btn_nilai_akhir_batalMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nilai_akhir_batalMouseEntered
        btn_nilai_akhir_batal.setBackground(new java.awt.Color(128,136,203));
        btn_nilai_akhir_batal.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_btn_nilai_akhir_batalMouseEntered

    private void btn_nilai_akhir_batalMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nilai_akhir_batalMouseExited
        btn_nilai_akhir_batal.setBackground(new java.awt.Color(255, 255, 255));
        btn_nilai_akhir_batal.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btn_nilai_akhir_batalMouseExited

    private void btn_nilai_akhir_keluarMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nilai_akhir_keluarMouseEntered
        btn_nilai_akhir_keluar.setBackground(new java.awt.Color(255,102,102));
        btn_nilai_akhir_keluar.setForeground(new java.awt.Color(255, 255, 255));
    }//GEN-LAST:event_btn_nilai_akhir_keluarMouseEntered

    private void btn_nilai_akhir_keluarMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btn_nilai_akhir_keluarMouseExited
        btn_nilai_akhir_keluar.setBackground(new java.awt.Color(255, 255, 255));
        btn_nilai_akhir_keluar.setForeground(new java.awt.Color(0, 0, 0));
    }//GEN-LAST:event_btn_nilai_akhir_keluarMouseExited

    private void btn_nilai_akhir_keluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_nilai_akhir_keluarActionPerformed
        frm_utama u = new frm_utama();
        u.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_nilai_akhir_keluarActionPerformed

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
            java.util.logging.Logger.getLogger(frm_nilai_akhir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frm_nilai_akhir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frm_nilai_akhir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frm_nilai_akhir.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new frm_nilai_akhir().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_nilai_akhir_batal;
    private javax.swing.JButton btn_nilai_akhir_hapus;
    private javax.swing.JButton btn_nilai_akhir_keluar;
    private javax.swing.JButton btn_nilai_akhir_simpan;
    private javax.swing.JButton btn_nilai_akhir_tambah;
    private javax.swing.JButton btn_nilai_akhir_ubah;
    private javax.swing.JButton btn_nilai_akhir_ubah1;
    private javax.swing.JComboBox<String> combo_nilai_akhir_nama_mk;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbl_jdl_nilai_akhir;
    private javax.swing.JLabel lbl_nilai_akhir_kd_mk;
    private javax.swing.JLabel lbl_nilai_akhir_kehadiran;
    private javax.swing.JLabel lbl_nilai_akhir_nama_mk;
    private javax.swing.JLabel lbl_nilai_akhir_persen_absen;
    private javax.swing.JLabel lbl_nilai_akhir_persen_tugas;
    private javax.swing.JLabel lbl_nilai_akhir_persen_uas;
    private javax.swing.JLabel lbl_nilai_akhir_persen_uts;
    private javax.swing.JLabel lbl_nilai_akhir_pertemuan;
    private javax.swing.JLabel lbl_nilai_akhir_tugas1;
    private javax.swing.JLabel lbl_nilai_akhir_tugas2;
    private javax.swing.JLabel lbl_nilai_akhir_tugas3;
    private javax.swing.JLabel lbl_nilai_akhir_uas;
    private javax.swing.JLabel lbl_nilai_akhir_uts;
    private javax.swing.JLabel lbl_persen_absen;
    private javax.swing.JLabel lbl_persen_tugas;
    private javax.swing.JLabel lbl_persen_uas;
    private javax.swing.JLabel lbl_persen_uts;
    private javax.swing.JTextField txt_nilai_akhir_kd_mk;
    private javax.swing.JTextField txt_nilai_akhir_kehadiran;
    private javax.swing.JTextField txt_nilai_akhir_persen_absen;
    private javax.swing.JTextField txt_nilai_akhir_persen_tugas;
    private javax.swing.JTextField txt_nilai_akhir_persen_uas;
    private javax.swing.JTextField txt_nilai_akhir_persen_uts;
    private javax.swing.JTextField txt_nilai_akhir_tugas1;
    private javax.swing.JTextField txt_nilai_akhir_tugas2;
    private javax.swing.JTextField txt_nilai_akhir_tugas3;
    private javax.swing.JTextField txt_nilai_akhir_uas;
    private javax.swing.JTextField txt_nilai_akhir_uts;
    // End of variables declaration//GEN-END:variables
}
