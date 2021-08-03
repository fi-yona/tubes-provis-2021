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
public class Member {
    
    int IdMember;
    String NamaMember;
    int Point;
    
    public Member(int IdMember, String NamaMember, int Point){
        this.IdMember = IdMember;
        this.NamaMember = NamaMember;
        this.Point = Point;
    }
    
    public int getIdMember(){
        return IdMember;
    }
    
    public String getNamaMember(){
        return NamaMember;
    }
    
    public int getPoint(){
        return Point;
    }
}
