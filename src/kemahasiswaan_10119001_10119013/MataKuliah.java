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
public class MataKuliah {
    String kd_mk;
    String nama_mk;
    
    public MataKuliah(String kd_mk, String nama_mk){
        this.kd_mk = kd_mk;
        this.nama_mk = nama_mk;
    }
    
    public String getKdMK(){
        return kd_mk;
    }
    
    public String getNamaMK(){
        return nama_mk;
    }
}
