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
public class Produk {
    
    String IdBarang, NamaBarang;
    int Stok;
    double HargaJual;
    
    public Produk(String IdBarang, String NamaBarang, int Stok, double HargaJual){
        this.IdBarang = IdBarang;
        this.NamaBarang = NamaBarang;
        this.Stok = Stok;
        this.HargaJual = HargaJual;
    }
    
    public String getIdBarang(){
        return IdBarang;
    }
    
    public String getNamaBarang(){
        return NamaBarang;
    }
    
    public int getStok(){
        return Stok;
    }
    
    public double getHargaJual(){
        return HargaJual;
    }
}
