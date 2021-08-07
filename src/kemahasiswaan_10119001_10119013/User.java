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
public class User {
    String Username;
    String Nama;
    
    public User(String Username, String Nama){
        this.Username = Username;
        this.Nama = Nama;
    }
    
    public String getUsername(){
        return Username;
    }
    
    public String getNama(){
        return Nama;
    }
}
