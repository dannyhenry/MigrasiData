/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package migrasidata2.database;

import java.util.ArrayList;

/**
 *
 * @author Kaitero
 */
public class CustomMigrasiData {
    private String namaTable;
    private ArrayList<ColumnDescription> listStruktur;
    private ArrayList<String> listData;
    private ArrayList<KeyDescription>  listKey;
    private String namaBaru;
    private String listKolom;
    private String searchCondition;

    public CustomMigrasiData(String namaTable, ArrayList<ColumnDescription> listStruktur, ArrayList<String> listData, ArrayList<KeyDescription> listKey,String searchCondition) {
        this.namaTable = namaTable;
        this.listStruktur = listStruktur;
        this.listData = listData;
        this.listKey = listKey;
        this.searchCondition=searchCondition;
        this.namaBaru = "";
    }

    public String getNamaTable() {
        return namaTable;
    }

    public void setNamaTable(String namaTable) {
        this.namaTable = namaTable;
    }

    public ArrayList<ColumnDescription> getListStruktur() {
        return listStruktur;
    }

    public void setListStruktur(ArrayList<ColumnDescription> listStruktur) {
        this.listStruktur = listStruktur;
    }

    public ArrayList<String> getListData() {
        return listData;
    }

    public void setListData(ArrayList<String> listData) {
        this.listData = listData;
    }

    public ArrayList<KeyDescription> getListKey() {
        return listKey;
    }

    public void setListKey(ArrayList<KeyDescription> listKey) {
        this.listKey = listKey;
    }

    public String getNamaBaru() {
        return namaBaru;
    }

    public void setNamaBaru(String namaBaru) {
        this.namaBaru = namaBaru;
    }

    public String getListKolom() {
        return listKolom;
    }

    public void setListKolom(String listKolom) {
        this.listKolom = listKolom;
    }
   
}
