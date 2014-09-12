/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package migrasidata2.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import migrasidata2.view.FormConfigurasiMySQL;
import migrasidata2.view.FormConfigurasiOracle;

/**
 *
 * @author Kaitero
 */
public class Database {

    private static Database pk;
    private String driverMysql = "com.mysql.jdbc.Driver";
    private String driverOracle = "oracle.jdbc.driver.OracleDriver";
    private Connection conn = null;
    private Connection conn2 = null;
    private int cursor=0;
    
    public static Database getPk() {
        synchronized (Database.class) {
            if (pk == null) {
                pk = new Database();
            }
        }
        return pk;
    }

    private Database() {
    }

    public Connection getConn() {
        return conn;
    }

    public Connection getConn2() {
        return conn2;
    }

    public boolean bukaDBOracle(String url, String port, String username, String password) {
        boolean flag = false;
        try {
            Class.forName(driverOracle);
            flag = true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            flag = false;
        }
        if (flag) {
            flag = false;
            try {
                conn2 = DriverManager.getConnection("jdbc:oracle:thin:@" + url + ":" + port + ":xe", username, password);
                flag = true;
                System.out.println("Connection Oracle Successful");
            } catch (Exception e) {
                System.out.println(e.getMessage());
                flag = false;
            }
        }
        return flag;
    }

    public boolean bukaDBMysql(String url, String port, String user, String password) {
        boolean flag = false;
        try {
            Class.forName(driverMysql);
            flag = true;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Maaf Driver Tidak Ditemukan");
            flag = false;
        }
        if (flag) {
            flag = false;
            try {
                conn = DriverManager.getConnection("jdbc:mysql://" + url + ":" + port + "", user, password);
                flag = true;
            } catch (Exception e) {
                System.out.println(e.getMessage());
                flag = false;
            }
        }
        return flag;
    }

    public ResultSet eksekusiSelectOracle(String query) {
        ResultSet rs = null;
        try {
            Statement st = conn2.createStatement();
            rs = st.executeQuery(query);
            cursor++;
            if(cursor>150){
                FormConfigurasiOracle.getConfOra().refreshConnection();
                cursor=0;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            cursor++;
            if(cursor>150){
                FormConfigurasiOracle.getConfOra().refreshConnection();
                cursor=0;
            }
        }
        return rs;
    }

    public ResultSet eksekusiSelect(String query) {
        ResultSet rs = null;
        try {
            Statement st = conn.createStatement();
            rs = st.executeQuery(query);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return rs;
    }

    public boolean eksekusiQueryDMLOracle(String query) {
        boolean flag = false;
        try {
            Statement st = conn2.createStatement();
            int temp = st.executeUpdate(query);
            if (query.contains("create user") || query.contains("grant dba") || query.contains("create table")||query.contains("alter table")
                    ||query.contains("CREATE INDEX")) {
                temp++;
            }
            if (temp > 0) {
                flag = true;
            } else if (temp < 0) {
                flag = true;
            }            
//            System.out.println(temp);
            cursor++;
            if(cursor>150){
                FormConfigurasiOracle.getConfOra().refreshConnection();
                cursor=0;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println(query);
            cursor++;
            if(cursor>150){
                FormConfigurasiOracle.getConfOra().refreshConnection();
                cursor=0;
            }
            flag=false;
        }
        return flag;
    }

    public boolean eksekusiQueryDML(String query) {
        boolean flag = false;
        try {
            Statement st = conn.createStatement();
            int temp = st.executeUpdate(query);
            if (query.contains("create user") || query.contains("grant dba") || query.contains("create table")||query.contains("alter table")
                    ||query.contains("CREATE INDEX")) {
                temp++;
            }
            if (temp > 0) {
                flag = true;
            } else if (temp < 0) {
                flag = true;
            }
//            System.out.println(temp);
        } catch (Exception e) {
            System.out.println(e.getMessage());
            flag=false;
        }
        return flag;
    }
}
