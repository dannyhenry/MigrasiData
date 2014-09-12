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
public class FullMigration {
    private String namaTable;
    private ArrayList<ColumnDescription> listStruktur;
    private ArrayList<String> listData;
    private ArrayList<KeyDescription>  listKey;
    private String namaBaru;

    public FullMigration(String namaTable, ArrayList<ColumnDescription> listStruktur, ArrayList<String> listData, ArrayList<KeyDescription> listKey) {
        this.namaTable = namaTable;
        this.listStruktur = listStruktur;
        this.listData = listData;
        this.listKey = listKey;
        this.namaBaru="";
    }

    public String getNamaBaru() {
        return namaBaru;
    }

    public void setNamaBaru(String namaBaru) {
        this.namaBaru = namaBaru;
    }
    
    public String getNamaTable() {
        return namaTable;
    }

    public ArrayList<ColumnDescription> getListStruktur() {
        return listStruktur;
    }

    public ArrayList<String> getListData() {
        return listData;
    }

    public ArrayList<KeyDescription> getListKey() {
        return listKey;
    }
    
    
}
