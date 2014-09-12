/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package migrasidata2.subview;

import java.awt.event.KeyEvent;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;
import migrasidata2.database.ColumnDescription;
import migrasidata2.database.CustomMigrasiData;
import migrasidata2.database.Database;
import migrasidata2.database.DatabaseInformation;
import migrasidata2.database.FullMigration;
import migrasidata2.database.KeyDescription;
import migrasidata2.pluginsclass.AutoResizeTable1;
import migrasidata2.view.SaveLog;

/**
 *
 * @author Kaitero
 */
public class PanelMigrasiMySQL extends javax.swing.JPanel {

    /**
     * Creates new form PanelMigrasiOracle
     */
    DatabaseInformation di = new DatabaseInformation();
    DefaultListModel listmodel = new DefaultListModel();
    DefaultListModel listmodel2 = new DefaultListModel();
    ArrayList<CustomMigrasiData> listdata = new ArrayList<CustomMigrasiData>();
    ArrayList<String> listTable = null;
    ArrayList<ColumnDescription> listStruktur;
    List last = null;
    Database db = Database.getPk();
    String log = "";
    String pilihan[] = {"", "LIKE", "LIKE%..%", "NOT LIKE", "=", "!=", "<", ">", "<=", ">="};
    JComboBox comboCari = new JComboBox(pilihan);
    DefaultTableModel model1 = new DefaultTableModel(0, 5) {
        Class[] ColumnTypes = {Boolean.class, String.class, String.class, JComboBox.class, String.class};

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            return ColumnTypes[columnIndex];
        }
    };
    private int sukses;
    private int gagal;

    public void setSukses(int sukses) {
        this.sukses = sukses;
    }

    public void setGagal(int gagal) {
        this.gagal = gagal;
    }

    public int getSukses() {
        return sukses;
    }

    public int getGagal() {
        return gagal;
    }

    public PanelMigrasiMySQL() {
        initComponents();
        loadListTabel();
        jLabel1.setText("");
        jTable1.setModel(model1);
        jList2.setModel(listmodel);
        jList1.setModel(listmodel2);
        kondisiFullMigrasi();
        refreshTabel();
    }

    public void kondisiFullMigrasi() {
        jTable1.setEnabled(false);
        jButton2.setEnabled(false);
        jList2.setEnabled(false);
    }

    public void kondisiCustomMigrasi() {
        jTable1.setEnabled(true);
        jList2.setEnabled(true);
    }

    public void loadListTabel() {
        listmodel.removeAllElements();
        listTable = di.loadListTable("mysql");
        for (int i = 0; i < listTable.size(); i++) {
            listmodel.addElement(listTable.get(i));
        }
    }

    public void refreshTabel() {
        model1.setRowCount(0);
        model1.setColumnCount(0);
    }

    public void loadStrukturToTabel() {
        refreshTabel();
        model1.setColumnIdentifiers(new Object[]{"Selection", "Column Name", "Data Type", "Search Conditon", "Search Value"});
        jTable1.getColumn("Search Conditon").setCellEditor(new DefaultCellEditor(comboCari));
        for (int i = 0; i < listStruktur.size(); i++) {
            model1.insertRow(i, new Object[]{true, listStruktur.get(i).getNamaKolom(), listStruktur.get(i).getTipedata(), "", ""});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jButton3 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jList2 = new javax.swing.JList();
        humanProgressBar1 = new javax.swing.JProgressBar();

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Full Migration", "Custom Migration" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jTable1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTable1KeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(jTable1);

        jButton1.setText("Start Migration");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("jLabel1");

        jButton2.setText("ADD");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jList1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane3.setViewportView(jList1);

        jButton3.setText("Remove");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jList2.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jList2.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList2ValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(jList2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(humanProgressBar1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(jScrollPane4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(humanProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        if (jComboBox1.getSelectedIndex() == 0) {
            kondisiFullMigrasi();
        } else {
            kondisiCustomMigrasi();
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        ArrayList<ColumnDescription> datastruktur = new ArrayList<ColumnDescription>();
        String listkolom = "";
        String search = "";
        String valueserach = "";
        String kolom = "";
        int totalkolom = 0;
        String tabel = jList2.getSelectedValue().toString();
        System.out.println(model1.getRowCount());
        int countcek = 0;
        for (int i = model1.getRowCount() - 1; i >= 0; i--) {
            boolean cek = (boolean) jTable1.getValueAt(i, 0);
            if (cek) {
                totalkolom++;
                listkolom = listkolom + jTable1.getValueAt(i, 1) + ",";
                datastruktur.add(listStruktur.get(i));
                if (!jTable1.getValueAt(i, 3).toString().equalsIgnoreCase("")) {
                    kolom = jTable1.getValueAt(i, 1).toString().toUpperCase();
                    valueserach = jTable1.getValueAt(i, 4).toString().toUpperCase();
                    if (countcek > 0) {
                        search = search + " AND ";
                    }
                    switch (jTable1.getValueAt(i, 3).toString()) {
                        case "LIKE":
                            search = search + kolom + " LIKE '" + valueserach + "'";
                            break;
                        case "LIKE%..%":
                            search = search + kolom + " LIKE '%" + valueserach + "%'";
                            break;
                        case "NOT LIKE":
                            search = search + kolom + " NOT LIKE '" + valueserach + "'";
                            break;
                        case "=":
                            search = search + kolom + " = '" + valueserach + "'";
                            break;
                        case "!=":
                            search = search + kolom + " != '" + valueserach + "'";
                            break;
                        case "<":
                            search = search + kolom + " < '" + valueserach + "'";
                            break;
                        case ">":
                            search = search + kolom + " > '" + valueserach + "'";
                            break;
                        case "<=":
                            search = search + kolom + " <= '" + valueserach + "'";
                            break;
                        case ">=":
                            search = search + kolom + " >= '" + valueserach + "'";
                            break;
                    }
                    countcek++;
                }
            }
        }
        listkolom = listkolom.substring(0, listkolom.length() - 1);
        String query = "";
        if (search.trim().equals("")) {
            query = "select " + listkolom + " from " + tabel;
        } else {
            query = "select " + listkolom + " from " + tabel + " where " + search;
        }
        System.out.println(search);
        System.out.println(query);
        System.out.println();
        ResultSet rs = db.eksekusiSelect(query);
//        listdata.add(new CustomMigrasiData(tabel, datastruktur, di.loadIsiTabel2(rs, totalkolom), di.loadAllKeys2("mysql", tabel,listkolom), search));
        listmodel.remove(jList2.getSelectedIndex());
        listmodel2.addElement(tabel);
        refreshTabel();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jList2ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList2ValueChanged
        // TODO add your handling code here:
        if (jList2.getSelectedIndex() != -1) {
            jButton2.setEnabled(true);
            String tabel = jList2.getSelectedValue().toString();
            ResultSet rs = db.eksekusiSelect("select * from " + tabel);
            try {
                ResultSetMetaData rsmd = rs.getMetaData();
                listStruktur = di.loadStruktur(rsmd, tabel);
                loadStrukturToTabel();
                new AutoResizeTable1().sesuaikanKolom(jTable1);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        } else {
            jButton2.setEnabled(false);
        }
    }//GEN-LAST:event_jList2ValueChanged

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        if (jList1.getSelectedIndex() != -1) {
            for (int i = 0; i < listdata.size(); i++) {
                if (listdata.get(i).getNamaTable().equalsIgnoreCase(jList1.getSelectedValue().toString())) {
                    listdata.remove(i);
                    i = listdata.size();
                }
            }
            listmodel.addElement(jList1.getSelectedValue());
            listmodel2.remove(jList1.getSelectedIndex());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    public void customMigrasi() {
        log = "Migrasi From MYSQL To ORACLE \n";
        log = log + "Migration Type : Custom Migration \n";
        log = log + "Migration Time : " + Calendar.getInstance().getTime().toString();
    }
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        humanProgressBar1.setStringPainted(true);
        String query = "";
        String tipedata = "";
        String namatabel = "";
        String namakolom = "";
        log = "";
        ArrayList<String> listquery = new ArrayList<String>();
        if (jComboBox1.getSelectedItem().toString().equals("Custom Migration")) {
            jLabel1.setText("Getting Data From Database......");
            //get struktur
            for (int i = 0; i < listdata.size(); i++) {
                namakolom = "";
                namatabel = cekTabelTujuan(listdata.get(i).getNamaTable());
                listdata.get(i).setNamaBaru(namatabel);
                query = "create table " + namatabel + "( \n";
                ArrayList<ColumnDescription> struktur = listdata.get(i).getListStruktur();
                for (int j = 0; j < struktur.size(); j++) {
                    tipedata = cekTipeData(struktur.get(j).getTipedata(), struktur.get(j).getPanjangkolom(), struktur.get(j).getKomaKolom());
                    if (j < struktur.size() - 1) {
                        query = query + struktur.get(j).getNamaKolom() + " " + tipedata + " " + struktur.get(j).nullAbles() + ",";
                        namakolom = namakolom + struktur.get(j).getNamaKolom() + ",";
                    } else {
                        query = query + struktur.get(j).getNamaKolom() + " " + tipedata + " " + struktur.get(j).nullAbles();
                        namakolom = namakolom + struktur.get(j).getNamaKolom();
                    }
                    query = query + "\n";
                }
                query = query + ")";
                listquery.add(query);
                System.out.println(query);
                listdata.get(i).setListKolom(namakolom);
                ResultSet rs = db.eksekusiSelect("select " + listdata.get(i).getListKolom() + " from " + listdata.get(i).getNamaTable());
                try {
                    ResultSetMetaData rsmd = rs.getMetaData();
                    ArrayList<String> isiTable = di.loadIsiData2(rs, rsmd);
                    for (int j = 0; j < isiTable.size(); j++) {
                        query = "insert into " + listdata.get(i).getNamaBaru() + " values (" + isiTable.get(j) + ")";
                        listquery.add(query);
                        System.out.println(query);
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            jLabel1.setText("Moving Data to Destination Schema......");
            humanProgressBar1.setStringPainted(true);
            humanProgressBar1.setMinimum(0);
            humanProgressBar1.setMaximum(listquery.size());
            int value = 0;
            new Thread() {
                @Override
                public void run() {
                    eksekusiData(listquery);
                }
            }.start();
        } else {
            fullMigrasi();
        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTable1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTable1KeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable1KeyPressed

    public void fullMigrasi() {
        loadListTabel();
        ArrayList<FullMigration> dataMigrasi = new ArrayList<FullMigration>();
        for (int i = 0; i < listTable.size(); i++) {
            System.out.println(listTable.get(i));
            ResultSet rs = db.eksekusiSelect("select * from " + listTable.get(i));
            try {
                ResultSetMetaData rsmd = rs.getMetaData();
                dataMigrasi.add(new FullMigration(listTable.get(i), di.loadStruktur(rsmd, listTable.get(i)),
                        di.loadIsiData2(rs, rsmd), di.loadAllKeys("mysql", listTable.get(i))));
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        createKeDataBase(dataMigrasi);
    }

    public void createKeDataBase(ArrayList<FullMigration> dataMigrasi) {
        String namatabel = "";
        String query = "";
        String tipedata = "";
        String kolomkey = "";
        ArrayList<String> listquery = new ArrayList<String>();
        for (int i = 0; i < dataMigrasi.size(); i++) {
            namatabel = cekTabelTujuan(dataMigrasi.get(i).getNamaTable());
            dataMigrasi.get(i).setNamaBaru(namatabel);
            query = "create table " + namatabel + "( \n";
            ArrayList<ColumnDescription> listStruktur1 = dataMigrasi.get(i).getListStruktur();
            for (int j = 0; j < listStruktur1.size(); j++) {
                tipedata = cekTipeData(listStruktur1.get(j).getTipedata(), listStruktur1.get(j).getPanjangkolom(), listStruktur1.get(j).getKomaKolom());
                query = query + listStruktur1.get(j).getNamaKolom() + " ";
                if (j < listStruktur1.size() - 1) {
                    query = query + listStruktur1.get(j).getNamaKolom() + " " + tipedata + " " + listStruktur1.get(j).nullAbles() + ",";
                } else {
                    query = query + listStruktur1.get(j).getNamaKolom() + " " + tipedata + " " + listStruktur1.get(j).nullAbles();
                }
                query = query + "\n";
            }
            query = query + ")";
            System.out.println(query);
            listquery.add(query);
            ArrayList<String> isiTable = dataMigrasi.get(i).getListData();
            for (int j = 0; j < isiTable.size(); j++) {
                query = "insert into " + namatabel + " values (" + isiTable.get(j) + ")";
                listquery.add(query);
                System.out.println(query);
            }
        }

        for (int i = 0; i < dataMigrasi.size(); i++) {
            ArrayList<KeyDescription> listkey = dataMigrasi.get(i).getListKey();
            for (int j = 0; j < listkey.size(); j++) {
                if (listkey.get(j).getJenisKey().equals("PRIMARY KEY")) {
                    kolomkey = kolomkey + listkey.get(j).getNamaKolom() + ",";
                }
            }
        }
        for (int i = 0; i < dataMigrasi.size(); i++) {
            ArrayList<KeyDescription> listkey = dataMigrasi.get(i).getListKey();
            for (int j = 0; j < listkey.size(); j++) {
                if (listkey.get(j).getJenisKey().equalsIgnoreCase("FOREIGN KEY")) {
                    query = "alter table " + dataMigrasi.get(i).getNamaBaru() + " add CONSTRAINT " + listkey.get(j).getNamaKey()
                            + " FOREIGN KEY (" + listkey.get(j).getNamaKolom() + ") REFERENCES " + listkey.get(j).getNamaTabel() + " ("
                            + listkey.get(j).getAsalKey() + ")";
                    System.out.println(query);
                    listquery.add(query);
                }
            }
        }
    }

    public void eksekusiData(ArrayList<String> listquery) {
        int totalsukses = 0;
        int totalgagal = 0;
        for (int i = 0; i < listquery.size(); i++) {
            Runnable runner = new Runnable() {
                public void run() {
                    int value = humanProgressBar1.getValue();
                    humanProgressBar1.setValue(value + 1);
                }
            };
            try {
                SwingUtilities.invokeAndWait(runner);
                boolean cek = db.eksekusiQueryDMLOracle(listquery.get(i));
                if (cek) {
                    totalsukses++;
                } else {
                    totalgagal++;
                }
                Thread.sleep(1);
            } catch (InterruptedException ignoredException) {
            } catch (InvocationTargetException ignoredException) {
            }
        }
        log = log + " - " + Calendar.getInstance().getTime().toString() + "\n";
        log = log + "Total Proses   : " + listquery.size() + " Process \n";
        log = log + "Total Sukses : " + totalsukses + " Proccess \n";
        log = log + "Total Gagal  : " + totalgagal + " Process \n";
        SaveLog sl = new SaveLog(log);
        sl.setVisible(true);
        jLabel1.setText("Moving Data Finished........");
    }

    public String cekTipeData(String tipe, int panjang, int koma) {
        tipe = tipe.toUpperCase();
        switch (tipe) {
            case "TEXT":
                tipe = "VARCHAR2(4000)";
                break;
            case "BIGINT":
                tipe = "NUMBER(20)";
                break;
            case "VARCHAR":
                if (panjang > 4000) {
                    panjang = 4000;
                }
                tipe = "VARCHAR2(" + panjang + ")";
                break;
            case "INT":
                tipe = "NUMBER(" + panjang + ")";
                break;
            case "FLOAT":
                tipe = "FLOAT(12)";
                break;
            case "DOUBLE":
                tipe = "NUMBER(22)";
                break;
            case "CHAR":
                tipe = "CHAR(" + panjang + ")";
                break;
            case "DATE":
                tipe = "DATE";
                break;
            case "DATETIME":
                tipe = "DATE";
                break;
            case "DECIMAL":
                tipe = "FLOAT(11)";
                break;
            case "MEDIUMINT":
                tipe = "NUMBER(7)";
                break;
            case "SMALLINT":
                tipe = "NUMBER(5)";
                break;
            case "TINYINT":
                tipe = "NUMBER(3)";
                break;
            case "TIME":
                tipe = "DATE";
                break;
            case "TIMESTAMP":
                tipe = "DATE";
                break;
        }
        return tipe;
    }

    public String cekTabelTujuan(String tabel) {
        String tabel1 = "";
        boolean status = false;
        while (!status) {
            switch (tabel) {
                case "UPDATE":
                    tabel = JOptionPane.showInputDialog("MAAF Tabel tidak bisa bernama UPDATE Silahkan Ganti nama Tabel anda");
                    status = false;
                    break;
                case "INPUT":
                    tabel = JOptionPane.showInputDialog("MAAF TABEL tidak bisa bernama INPUT Silahkan Ganti nama Tabel anda");
                    status = false;
                    break;
                case "DELETE":
                    tabel = JOptionPane.showInputDialog("MAAF TABEL tidak bisa bernama DELETE Silahkan Ganti nama Tabel anda");
                    status = false;
                    break;
                case "SELECT":
                    tabel = JOptionPane.showInputDialog("MAAF TABEL tidak bisa bernama SELECT Silahkan Ganti nama Tabel anda");
                    status = false;
                    break;
                case "TRIGGER":
                    tabel = JOptionPane.showInputDialog("MAAF TABEL tidak bisa bernama TRIGGER Silahkan Ganti nama Tabel anda");
                    status = false;
                    break;
                case "USER":
                    tabel = JOptionPane.showInputDialog("MAAF TABEL tidak bisa bernama USER Silahkan Ganti nama Tabel anda");
                    status = false;
                    break;
                case "TABLE":
                    tabel = JOptionPane.showInputDialog("MAAF TABEL tidak bisa bernama TABLE Silahkan Ganti nama Tabel anda");
                    status = false;
                    break;
                case "DATABASE":
                    tabel = JOptionPane.showInputDialog("MAAF TABEL tidak bisa bernama DATABASE Silahkan Ganti nama Tabel anda");
                    status = false;
                    break;
                case "GRANT":
                    tabel = JOptionPane.showInputDialog("MAAF TABEL tidak bisa bernama GRANT Silahkan Ganti nama Tabel anda");
                    status = false;
                    break;
                default:
                    tabel1 = tabel;
                    status = true;
                    break;
            }
        }
        tabel1 = tabel1.toUpperCase();
        return tabel1;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JProgressBar humanProgressBar1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JList jList1;
    private javax.swing.JList jList2;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}