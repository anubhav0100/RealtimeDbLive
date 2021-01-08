package com.edevelopers.realdbtime.Model;

import android.content.ComponentName;
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

    public ModelClass(Context context, String api_key, String apisecret, String appname, String TableName,
                      ArrayList<DBColumn> dbcolumn,ArrayList<DBColumnResult> DBcolres,ArrayList<DBColumnResult> DBcolwhere,int type){
        this.context = context;
        this.api_key = api_key;
        this.api_secret = apisecret;
        this.appname = appname;
        this.TableName = TableName;
        this.dbcolumn = dbcolumn;
        if(Const.GET_TAG_INSERT == type){
            this.query = Const.insertQueryBuilder(TableName,DBcolres);
        }
        else if(Const.GET_TAG_GETDATA == type){
            this.query = Const.thirdlevelbuilder(TableName,dbcolumn);
        }
        if(Const.GET_TAG_UPDATE == type){
            this.query = Const.updateQueryBuilder(TableName,DBcolres,DBcolwhere);
        }
        else if(Const.GET_TAG_GETDATA_WHERE == type){
            this.query = Const.thirdlevelbuilder_where(TableName,dbcolumn,DBcolwhere);
        }
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
