/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package migrasidata2.view;

import java.awt.CardLayout;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import migrasidata2.database.Database;
import migrasidata2.subview.PanelKosong;
import migrasidata2.subview.PanelLog;
import migrasidata2.subview.PanelMigrasiMySQL;
import migrasidata2.subview.PanelMigrasiMySQL2;
import migrasidata2.subview.PanelMigrasiOracle;
import migrasidata2.subview.PanelMigrasiOracle2;
import migrasidata2.subview.PanelTabelMySQL;
import migrasidata2.subview.PanelTabelOracle;

/**
 *
 * @author Kaitero
 */
public class FormUtama extends javax.swing.JFrame {

    /**
     * Creates new form FormUtama
     */
    private boolean click = false;
    private PanelLog pl;
    private PanelKosong pk = new PanelKosong();
    private PanelTabelOracle ptc;
    private PanelTabelMySQL ptm;
    private Database db = Database.getPk();
    private CardLayout cl;
    private JScrollPane js;
    private static FormUtama fu = null;
    private ButtonGroup bg = new ButtonGroup();
    private PanelMigrasiOracle2 pmo;
    private PanelMigrasiMySQL2 pmm;

    private FormUtama() {
        initComponents();
        jRadioButton1.setVisible(false);
        jRadioButton2.setVisible(false);
        bg.add(jRadioButton1);
        bg.add(jRadioButton2);
        cl = (CardLayout) jPanel3.getLayout();
        jPanel3.add(pk, "pk");
        cl.show(jPanel3, "pk");
        setSize(1100, 650);
        setLocationRelativeTo(null);
    }

    public static FormUtama getFU() {
        synchronized (FormUtama.class) {
            if (fu == null) {
                fu = new FormUtama();
            }
        }
        return fu;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton1.setText("Oracle Tables");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton2.setText("MySQL Tables");
        jButton2.setPreferredSize(new java.awt.Dimension(97, 23));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jButton3.setText("Migration");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                memilihArahMigrasi(evt);
            }
        });

        jRadioButton1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jRadioButton1.setText("MySQL -> Oracle");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        jRadioButton2.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jRadioButton2.setText("Oracle -> MySQL");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(536, 349));

        jPanel3.setLayout(new java.awt.CardLayout());
        jScrollPane1.setViewportView(jPanel3);

        jMenu1.setText("Log Migration");

        jMenuItem3.setText("View Log");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Connection");

        jMenuItem1.setText("Oracle Connection");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem1);

        jMenuItem2.setText("MySQL Connection");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem2);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 815, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 605, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
        String data = "";
        String alldata = "";
        JFileChooser chooser = new JFileChooser("src\\migrasidata\\log");
        FileNameExtensionFilter filter = new FileNameExtensionFilter("Log Extension", "log");
        chooser.setFileFilter(filter);
        int returnvalue = chooser.showOpenDialog(null);
        if (returnvalue == JFileChooser.APPROVE_OPTION) {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(chooser.getSelectedFile()));
                while ((data = reader.readLine()) != null) {
                    alldata = alldata + data + "\n";
                }
                reader.close();
                pl = new PanelLog(alldata);
                jPanel3.add(pl, "panellog");
                cl.show(jPanel3, "panellog");
            } catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Sorry There isn't File you choose");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    public void konfigurasiKoneksiOracle() {
        cl.show(jPanel3, "pk");
        FormConfigurasiOracle fco = FormConfigurasiOracle.getConfOra();
        fco.setVisible(true);
    }

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:         
        bg.clearSelection();
        konfigurasiKoneksiOracle();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    public void konfigurasiKoneksiMySQL() {
        cl.show(jPanel3, "pk");
        FormConfigurasiMySQL fmo = FormConfigurasiMySQL.getConfMy();
        fmo.setVisible(true);
    }

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:         
        bg.clearSelection();
        konfigurasiKoneksiMySQL();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    public void memilihView(boolean pilih) {
        pilihView(pilih);
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        boolean pilih = true;
        memilihView(pilih);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        boolean pilih = false;
        memilihView(pilih);
    }//GEN-LAST:event_jButton2ActionPerformed

    public void pilihView(boolean pilih) {
        if (pilih) {
            if (db.getConn2() != null) {
                ptc = new PanelTabelOracle();
                jPanel3.add(ptc, "tabelOra");
                cl.show(jPanel3, "tabelOra");
            }
        } else {
            if (db.getConn() != null) {
                ptm = new PanelTabelMySQL();
                jPanel3.add(ptm, "tabelmy");
                cl.show(jPanel3, "tabelmy");
            }
        }
    }
    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:  
        pmm = new PanelMigrasiMySQL2();
        jPanel3.add(pmm, "pmm");
        cl.show(jPanel3, "pmm");
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    public void validasiKoneksi(){
        if (db.getConn() == null && db.getConn2() == null) {
            JOptionPane.showMessageDialog(null, "Silahkan Hubungkan Aplikasi Dengan Database terlebih dahulu");
            cl.show(jPanel3, "pk");
        } else {
            if (db.getConn() != null) {
                if (db.getConn2() != null) {
                    if (click) {
                        click = false;
                        bg.clearSelection();
                        jRadioButton1.setVisible(false);
                        jRadioButton2.setVisible(false);
                    } else {
                        click = true;
                        jRadioButton1.setVisible(true);
                        jRadioButton2.setVisible(true);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Maaf Harap Hubungan Aplikasi Dengan Database ORACLE Terlebih Dahulu");
                    cl.show(jPanel3, "pk");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Maaf Harap Hubungan Aplikasi Dengan Database MYSQL Terlebih Dahulu");
                cl.show(jPanel3, "pk");
            }
        }
    }
    private void memilihArahMigrasi(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_memilihArahMigrasi
        // TODO add your handling code here:
        validasiKoneksi();
    }//GEN-LAST:event_memilihArahMigrasi

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        pmo = new PanelMigrasiOracle2();
        jPanel3.add(pmo, "pmo");
        cl.show(jPanel3, "pmo");
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormUtama.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormUtama().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}