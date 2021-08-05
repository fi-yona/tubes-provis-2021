/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kemahasiswaan_10119001_10119013;

/**
 *
 * @author USER
 */
public class Mahasiswa {
    
    String nama;
    String nim;
    
    public Mahasiswa(String nim, String nama){
        this.nim = nim;
        this.nama = nama;
    }
    
    public String getNama(){
        return nama;
    }
    
    public String getNim(){
        return nim;
    }
}
