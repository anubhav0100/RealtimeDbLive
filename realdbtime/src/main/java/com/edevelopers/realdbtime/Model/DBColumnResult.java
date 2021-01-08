package com.edevelopers.realdbtime.Model;

public class DBColumnResult {

    String Columnname;
    String ColumnResult;

    public DBColumnResult(String Columnname,String ColumnResult){
        this.Columnname = Columnname;
        this.ColumnResult = ColumnResult;
    }

    public String getColumnname() {
        return Columnname;
    }

    public String getColumnResult() {
        return ColumnResult;
    }
}
