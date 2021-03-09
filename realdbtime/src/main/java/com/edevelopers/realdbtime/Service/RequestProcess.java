package com.edevelopers.realdbtime.Service;

import android.content.Context;

import com.edevelopers.realdbtime.Lib.Const;
import com.edevelopers.realdbtime.Model.DBColumn;
import com.edevelopers.realdbtime.Model.DBColumnResult;
import com.edevelopers.realdbtime.Model.ModelClass;

import java.util.ArrayList;

public class RequestProcess {

    public static ArrayList<DBColumn> dbcol;
    public static ArrayList<DBColumnResult> dbcolwhere;
    public static ArrayList<DBColumnResult> dbcolinsert;

    public interface Callback
    {
        void onSuccess(ArrayList<DBColumnResult> Result);

        void onError(String Error);
    }

    public interface Callbackres
    {
        void onSuccess(String Result);

        void onError(String Error);
    }

    public static void setmodelmod(String Colname){
        dbcol.add(new DBColumn(Colname));
    }

    public static void setmodelmodWhere(String Colname,String Value){
        dbcolwhere.add(new DBColumnResult(Colname,Value));
    }

    public static void setmodelmodinsert(String Colname,String Value){
        dbcolinsert.add(new DBColumnResult(Colname,Value));
    }

    public static void getdatamod(Context context, String ApiKey, String Api_Secret, String appname, String TableName ,int dbtype,int limit,
                                  ArrayList<DBColumn> dbcolumn, final Callback callback){
        ModelClass modelclass = new ModelClass();
        ArrayList<DBColumnResult> emptycolres = new ArrayList<>();
        ArrayList<DBColumnResult> emptycolwhere = new ArrayList<>();
        modelclass = new ModelClass(context,ApiKey,Api_Secret,appname,TableName,dbcolumn,emptycolres,emptycolwhere, Const.GET_TAG_GETDATA,dbtype,limit);
        service_class.RequestData(modelclass, new service_class.Callback() {
            @Override
            public void onSuccess(ArrayList<DBColumnResult> Result) {
                callback.onSuccess(Result);
            }

            @Override
            public void onError(String Error) {
                callback.onError(Error);
            }
        });
    }

    public static void getdatamod_Where(Context context, String ApiKey, String Api_Secret, String appname,
                                        String TableName ,int dbtype,int limit, ArrayList<DBColumn> dbcolumn,ArrayList<DBColumnResult> DBcolres_where, final Callback callback){
        ModelClass modelclass = new ModelClass();
        ArrayList<DBColumnResult> emptycolres = new ArrayList<>();
        modelclass = new ModelClass(context,ApiKey,Api_Secret,appname,TableName,dbcolumn,emptycolres,DBcolres_where, Const.GET_TAG_GETDATA_WHERE,dbtype,limit);
        service_class.RequestData(modelclass, new service_class.Callback() {
            @Override
            public void onSuccess(ArrayList<DBColumnResult> Result) {
                callback.onSuccess(Result);
            }

            @Override
            public void onError(String Error) {
                callback.onError(Error);
            }
        });
    }

    public static void savedatamod(Context context, String ApiKey, String Api_Secret, String appname, String TableName ,
                                   ArrayList<DBColumnResult> dbcolres, final Callbackres callback){
        ModelClass modelclass = new ModelClass();
        ArrayList<DBColumn> emptydbcolumn = new ArrayList<>();
        ArrayList<DBColumnResult> emptycolwhere = new ArrayList<>();
        modelclass = new ModelClass(context,ApiKey,Api_Secret,appname,TableName,emptydbcolumn,dbcolres,emptycolwhere, Const.GET_TAG_INSERT,0,0);
        service_class.SaveData(modelclass, new service_class.Callbackres() {
            @Override
            public void onSuccess(String Result) {
                callback.onSuccess(Result);
            }

            @Override
            public void onError(String Error) {
                callback.onError(Error);
            }
        });
    }

    public static void updatedatamod(Context context, String ApiKey, String Api_Secret, String appname, String TableName ,
                                     ArrayList<DBColumnResult> DBcolres, ArrayList<DBColumnResult> DBcolres_where, final Callbackres callback){
        ModelClass modelclass = new ModelClass();
        ArrayList<DBColumn> emptydbcolumn = new ArrayList<>();
        modelclass = new ModelClass(context,ApiKey,Api_Secret,appname,TableName,emptydbcolumn,DBcolres,DBcolres_where, Const.GET_TAG_UPDATE,0,0);
        service_class.SaveData(modelclass, new service_class.Callbackres() {
            @Override
            public void onSuccess(String Result) {
                callback.onSuccess(Result);
            }

            @Override
            public void onError(String Error) {
                callback.onError(Error);
            }
        });
    }

    public static String getresultaccordingindex(String colname,int index,ArrayList<DBColumnResult> Result){
        String Value = "";
        for(int i = 0; i < Result.size();i++){
            if(index == Result.get(i).getIndex() && colname.equals(Result.get(i).getColumnname())){
                Value = Result.get(i).getColumnResult();
            }
         }
        return Value;
    }

}
