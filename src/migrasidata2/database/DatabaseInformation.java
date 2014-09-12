/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package migrasidata2.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import migrasidata2.view.FormConfigurasiMySQL;

/**
 *
 * @author Kaitero
 */
public class DatabaseInformation {

    private Database db = Database.getPk();

    public ArrayList loadListTable(String database) {
        ArrayList<String> listTable = new ArrayList<String>();
        ResultSet rs = null;
        if (database.equals("oracle")) {
            rs = db.eksekusiSelectOracle("select*from tab where tabtype ='TABLE'");
        } else {
            rs = db.eksekusiSelect("show tables");
        }
        try {
            while (rs.next()) {
                listTable.add(rs.getString(1).toUpperCase());
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return listTable;
    }

    public ArrayList loadStruktur(ResultSetMetaData rsmd, String tabel) {
        ArrayList<ColumnDescription> listStruktur = new ArrayList<ColumnDescription>();
        try {
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                listStruktur.add(new ColumnDescription(rsmd.getColumnName(i), rsmd.getColumnTypeName(i),
                        rsmd.getColumnDisplaySize(i), rsmd.getScale(i), rsmd.isAutoIncrement(i), rsmd.isNullable(i), tabel));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return listStruktur;
    }

    //view
    public ArrayList loadIsiData(ResultSet rs, int totalkolom) {
        ArrayList<String> listIsiData = new ArrayList<String>();
        String data = "";
        try {
            while (rs.next()) {
                data = "";
                for (int i = 1; i <= totalkolom; i++) {
                    if (i < totalkolom) {
                        data = data + rs.getString(i) + ";";
                    } else {
                        data = data + rs.getString(i);
                    }
                }
                listIsiData.add(data);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return listIsiData;
    }

    //insert mysql
    public ArrayList loadIsiData2(ResultSet rs, ResultSetMetaData rsmd) {
        ArrayList<String> listIsiData = new ArrayList<String>();
        String data = "";
        String datakolom = "";
        try {
            int totalkolom = rsmd.getColumnCount();
            while (rs.next()) {
                data = "";
                for (int i = 1; i <= totalkolom; i++) {
                    switch (rsmd.getColumnTypeName(i)) {
                        case "DATE":
                            datakolom = "TO_DATE('" + rs.getString(i) + "','yyyy-mm-dd')";
                            break;
                        case "TIME":
                            datakolom = "TO_CHAR('" + rs.getString(i) + "','HH24:mi:ss')";
                            break;
                        case "DATETIME":
                            datakolom = "TO_DATE('" + rs.getString(i) + "','yyyy-mm-dd HH24:mi:ss')";
                            break;
                        case "YEAR":
                            datakolom = "TO_CHAR('" + rs.getString(i) + "','YYYY')";
                            break;
                        default:
                            if (rs.getString(i) != null) {
                                datakolom = rs.getString(i);
                                if (rs.getString(i).contains("'")) {
                                    datakolom = datakolom.replace("'", "''");
                                }
                                datakolom = "'" + datakolom + "'";
                            } else {
                                datakolom = "'" + rs.getString(i) + "'";
                            }
                        break;
                    }
                    if (i < totalkolom) {
                        data = data + datakolom + ",";
                    } else {
                        data = data + datakolom;
                    }
                }
                if (data.contains("'null'")) {
                    data = data.replace("'null'", "null");
                }
                listIsiData.add(data);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return listIsiData;
    }

    //insert oracle
    public ArrayList loadIsiData3(ResultSet rs, ResultSetMetaData rsmd) {
        ArrayList<String> listIsiData = new ArrayList<String>();
        String data = "";
        String datakolom = "";
        try {
            int totalkolom = rsmd.getColumnCount();
            while (rs.next()) {
                data = "";
                for (int i = 1; i <= totalkolom; i++) {
                    if (rsmd.getColumnTypeName(i).equals("DATE")) {
                        datakolom = "'" + rs.getString(i) + "'";
                    } else {
                        if (rs.getString(i) != null) {
                            datakolom = rs.getString(i);
                            if (rs.getString(i).contains("'")) {
                                datakolom = datakolom.replace("'", "''");
                            }
                            datakolom = "'" + datakolom + "'";
                        } else {
                            datakolom = "'" + rs.getString(i) + "'";
                        }
                    }

                    if (i < totalkolom) {
                        data = data + datakolom + ",";
                    } else {
                        data = data + datakolom;
                    }
                }
                if (data.contains("'null'")) {
                    data = data.replace("'null'", "null");
                }
                listIsiData.add(data);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }
        return listIsiData;
    }

    public void loadPrimaryKeys(ArrayList<KeyDescription> listKey, String database, String namaTable) {
        DatabaseMetaData meta = null;
        ResultSet rs = null;
        String schema = "";
        Connection con = null;
        try {
            if (database.equals("oracle")) {
                con = db.getConn2();
                schema = con.getCatalog();
            } else {
                con = db.getConn();
                schema = FormConfigurasiMySQL.getConfMy().getSelectedDb();
            }
            meta = con.getMetaData();
            rs = meta.getPrimaryKeys(schema, null, namaTable);
            while (rs.next()) {
                listKey.add(new KeyDescription(rs.getString("COLUMN_NAME"), "PRIMARY KEY",
                        rs.getString("TABLE_NAME"), rs.getString("PK_NAME"), namaTable));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void loadForeignKeys(ArrayList<KeyDescription> listKey, String database, String namaTable) {
        DatabaseMetaData meta = null;
        ResultSet rs = null;
        String schema = "";
        Connection con = null;
        try {
            if (database.equals("oracle")) {
                con = db.getConn2();
                schema = con.getCatalog();
            } else {
                con = db.getConn();
                schema = FormConfigurasiMySQL.getConfMy().getSelectedDb();
            }
            meta = con.getMetaData();
            rs = meta.getImportedKeys(schema, null, namaTable);
            int i = 1;
            while (rs.next()) {
                String namakey = "FK_" + namaTable + i;
                listKey.add(new KeyDescription(rs.getString("FKCOLUMN_NAME"), "FOREIGN KEY", rs.getString("PKCOLUMN_NAME"), namakey, rs.getString("PKTABLE_NAME")));
                i++;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void loadIndex(ArrayList<KeyDescription> listKey, String database, String namaTable) {
        String query = "";
        ResultSet rs = null;
        String namaKey = "";
        String namakolom = "";
        if (database.equals("oracle")) {
            query = "select index_name,column_name "
                    + "from user_ind_columns "
                    + "where table_name ='" + namaTable + "'";
            rs = db.eksekusiSelectOracle(query);
        } else {
            query = "show index from " + namaTable + " where Key_name != 'PRIMARY'";
            rs = db.eksekusiSelect(query);
        }
        try {
            while (rs.next()) {
                if (database.equals("oracle")) {
                    namaKey = rs.getString(1);
                    namakolom = rs.getString(2);
                } else {
                    namaKey = rs.getString(3);
                    namakolom = rs.getString(5);
                }
                listKey.add(new KeyDescription(namakolom, "INDEX KEY", namakolom, namaKey, namaTable));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void loadUniqueKey(ArrayList<KeyDescription> listkey, String database, String namaTable) {
        String query = "";
        ResultSet rs = null;
        String namaKey = "";
        String namaKolom = "";
        if (database.equals("oracle")) {
            query = "select cc.* \n"
                    + "from user_constraints c \n"
                    + "join user_cons_columns cc on \n"
                    + "(c.owner=cc.owner and c.constraint_name = cc.constraint_name) \n"
                    + "where c.constraint_type = 'U' \n"
                    + "and c.table_name='" + namaTable + "'";
            rs = db.eksekusiSelectOracle(query);
        } else {
            query = "show indexes from " + namaTable + " WHERE non_unique = 0 and Key_name != 'PRIMARY'";
            rs = db.eksekusiSelect(query);
        }
        try {
            while (rs.next()) {
                if (database.equals("oracle")) {
                    namaKey = rs.getString(2);
                    namaKolom = rs.getString(4);
                } else {
                    namaKey = rs.getString(3);
                    namaKolom = rs.getString(5);
                }
                listkey.add(new KeyDescription(namaKolom, "UNIQUE KEY", namaTable, namaKey, namaTable));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public ArrayList loadAllKeys(String database, String namaTable) {
        ArrayList<KeyDescription> listKey = new ArrayList<KeyDescription>();
        loadPrimaryKeys(listKey, database, namaTable);
        loadForeignKeys(listKey, database, namaTable);
        loadUniqueKey(listKey, database, namaTable);
        loadIndex(listKey, database, namaTable);
        return listKey;
    }

    public ArrayList loadAllKeys2(String database, String namaTable, String namaKolom) {
        ArrayList<KeyDescription> listKey = new ArrayList<KeyDescription>();
        String data[] = namaKolom.split(",");
        loadPrimaryKeys(listKey, database, namaTable);
        loadUniqueKey(listKey, database, namaTable);
        loadIndex(listKey, database, namaTable);
        ArrayList<KeyDescription> seleksiKolom = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < listKey.size(); j++) {
                if (data[i].equalsIgnoreCase(listKey.get(j).getNamaKolom())) {
                    seleksiKolom.add(listKey.get(j));
                }
            }
        }
        return seleksiKolom;
    }
}
