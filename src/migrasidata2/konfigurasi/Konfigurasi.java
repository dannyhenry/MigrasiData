/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package migrasidata2.konfigurasi;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author Kaitero
 */
public class Konfigurasi {
    private String port;
    private String url;
    private String password;
    private String user;
    
    public void simpanConfigurasi(String url,String port,String user,String password) {
        Connection con = null;
        try {
            Properties prop = new Properties();
            FileOutputStream os = new FileOutputStream("src/mysql.cfg");
            prop.setProperty("url", url);
            prop.setProperty("port", port);
            prop.setProperty("user", user);
            prop.setProperty("password", password);
            prop.store(os, "MySQL config");
            os.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void simpanConfigurasiOracle(String url,String port,String user,String password) {
        Connection con = null;
        try {
            Properties prop = new Properties();
            FileOutputStream os = new FileOutputStream("src/oracle.cfg");
            prop.setProperty("url", url);
            prop.setProperty("port", port);
            prop.setProperty("user", user);
            prop.setProperty("password", password);
            prop.store(os, "MySQL config");
            os.close();
            JOptionPane.showMessageDialog(null, "Simpan Konfigurasi Sukses");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void refresh(){
        this.port="";
        this.url="";
        this.user="";
        this.password="";
    }
    public void loadKonfigurasiMySQL() {
        refresh();
        try {
            Properties prop = new Properties();
            InputStream is = Konfigurasi.class.getClassLoader().getResourceAsStream("mysql.cfg");
            prop.load(is);
            this.port = prop.getProperty("port");
            this.url = prop.getProperty("url");
            this.user = prop.getProperty("user");
            this.password = prop.getProperty("password");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void loadKonfigurasiOracle() {
        refresh();
        try {
            Properties prop = new Properties();
            InputStream is = Konfigurasi.class.getClassLoader().getResourceAsStream("oracle.cfg");
            prop.load(is);
            this.port = prop.getProperty("port");
            this.url = prop.getProperty("url");
            this.user = prop.getProperty("user");
            this.password = prop.getProperty("password");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String getPort() {
        return port;
    }

    public String getUrl() {
        return url;
    }

    public String getPassword() {
        return password;
    }

    public String getUser() {
        return user;
    }
    
}
