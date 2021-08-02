/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kemahasiswaan_10119001_10119013;

import java.io.FileInputStream;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author USER
 */
public class koneksi {
    public Properties mypanel, myLanguage;
    private String strNamePanel;
    
    public koneksi(){
    }
    
    public String SettingPanel(String nmPanel) {
        try {
            mypanel = new Properties();
            mypanel.load(new FileInputStream
                    ("lib/database.ini"));
            strNamePanel = mypanel.getProperty(nmPanel);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "ERROR",
                    JOptionPane.INFORMATION_MESSAGE);
            System.err.print(e.getMessage());
            System.exit(0);
        }
        return strNamePanel;
    }    
}