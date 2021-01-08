package com.edevelopers.realdbtime.Model;

public class DBColumnResult {

    String Columnname;
    String ColumnResult;
    int index;

    public DBColumnResult(String Columnname,String ColumnResult){
        this.Columnname = Columnname;
        this.ColumnResult = ColumnResult;
    }

    public DBColumnResult(String Columnname,String ColumnResult,int index){
        this.Columnname = Columnname;
        this.ColumnResult = ColumnResult;
        this.index = index;
    }

    public String getColumnname() {
        return Columnname;
    }

    public String getColumnResult() {
        return ColumnResult;
    }

    public int getIndex() {
        return index;
    }
}
