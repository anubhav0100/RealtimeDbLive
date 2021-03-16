package com.edevelopers.realdbtime.Model;

public class DBColumnDoub {

    String Columnname;
    String Columnfunalias;

    public DBColumnDoub(String Columnname, String Columnfunalias){
        this.Columnname = Columnname;
        this.Columnfunalias = Columnfunalias;
    }

    public String getColumnname() {
        return Columnname;
    }

    public String getColumnfunalias() {
        return Columnfunalias;
    }
}
