/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package migrasidata2.database;

/**
 *
 * @author Kaitero
 */
public class ColumnDescription {
    private String namaKolom;
    private String tipedata;
    private int panjangkolom;
    private int komaKolom;
    private boolean cekIncrement;
    private boolean cekNull;
    private String namaKelas;

    public ColumnDescription(String namaKolom, String tipedata, int panjangkolom, int komaKolom, boolean cekIncrement, int cekNull, String namaKelas) {
        this.namaKolom = namaKolom;
        this.tipedata = tipedata;
        this.panjangkolom = panjangkolom;
        this.komaKolom = komaKolom;
        this.cekIncrement = cekIncrement;
        if(cekNull==0){
            this.cekNull=false;
        }else{
            this.cekNull=true;
        }
        this.namaKelas = namaKelas;
    }

    public String getNamaKolom() {
        return namaKolom;
    }

    public String getTipedata() {
        return tipedata;
    }

    public int getPanjangkolom() {
        return panjangkolom;
    }

    public int getKomaKolom() {
        return komaKolom;
    }

    public boolean isCekIncrement() {
        return cekIncrement;
    }

    public boolean isCekNull() {
        return cekNull;
    }

    public String getNamaKelas() {
        return namaKelas;
    }       
    
    public String nullAbles(){
        String cek="";
        if(cekNull){
            cek="NULL";
        }else{
            cek="NOT NULL";
        }
        return cek;
    }
    public String isCekIncrements(){
        String cek="";
        if(!cekIncrement){
            cek="NO";
        }else{
            cek="YES";
        }
        return cek;
    }
}
