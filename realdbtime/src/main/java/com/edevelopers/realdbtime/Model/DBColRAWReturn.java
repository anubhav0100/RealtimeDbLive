package com.edevelopers.realdbtime.Model;

import java.util.ArrayList;

public class DBColRAWReturn {

    ArrayList<DBColumn> dbcols = new ArrayList<>();
    String query;

    public DBColRAWReturn( String query,ArrayList<DBColumn> dbcols){
        this.query = query;
        this.dbcols = dbcols;
    }

    public String getQuery() {
        return query;
    }

    public ArrayList<DBColumn> getDbcols() {
        return dbcols;
    }
}
