package com.edevelopers.realdbtime.Model;

import android.content.Context;

import com.edevelopers.realdbtime.Lib.Const;

import java.util.ArrayList;

public class ModelClass {
    Context context;
    String api_key="";
    String appname="";
    String api_secret="";
    String query="";
    String TableName = "";
    ArrayList<DBColumn> dbcolumn = new ArrayList<>();

    public ModelClass(){

    }

    public ModelClass(Context context, String api_key, String apisecret, String appname, String TableName, ArrayList<DBColumn> dbcolumn){
        this.context = context;
        this.api_key = api_key;
        this.api_secret = apisecret;
        this.appname = appname;
        this.TableName = TableName;
        this.dbcolumn = dbcolumn;
        this.query = Const.thirdlevelbuilder(TableName,dbcolumn);
    }

    public Context getContext() {
        return context;
    }

    public String getApi_key() {
        return api_key;
    }

    public String getApi_secret() {
        return api_secret;
    }

    public String getAppname() {
        return appname;
    }

    public String getQuery() {
        return query;
    }

    public ArrayList<DBColumn> getDbcolumn() {
        return dbcolumn;
    }

    public String getTableName() {
        return TableName;
    }
}
