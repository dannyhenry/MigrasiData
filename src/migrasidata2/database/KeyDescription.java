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
public class KeyDescription {

    private String namaKolom;
    private String jenisKey;
    private String asalKey;
    private String namaKey;
    private String namaTabel;

    public KeyDescription(String namaKolom, String jenisKey, String asalKey, String namaKey, String namaTabel) {
        this.namaKolom = namaKolom;
        this.jenisKey = jenisKey;
        this.asalKey = asalKey;
        if (jenisKey.equals("PRIMARY KEY")) {namaKey = "PK_" + namaTabel;            
            if (namaKey.equals("PRIMARY") || namaKey.equals(null)) {
                this.namaKey = "PK_" + namaTabel;
            } else {
                this.namaKey = namaKey;
            }
        } else {
            this.namaKey = namaKey;
        }
        this.namaTabel = namaTabel.toUpperCase();
    }

    public String getNamaKolom() {
        return namaKolom;
    }

    public String getJenisKey() {
        return jenisKey;
    }

    public String getAsalKey() {
        return asalKey;
    }

    public String getNamaKey() {
        return namaKey;
    }

    public String getNamaTabel() {
        return namaTabel;
    }

}
