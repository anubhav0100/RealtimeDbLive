package com.edevelopers.realdbtime.Service;

import android.content.Context;

import com.edevelopers.realdbtime.Model.DBColumn;
import com.edevelopers.realdbtime.Model.DBColumnResult;
import com.edevelopers.realdbtime.Model.ModelClass;

import java.util.ArrayList;

public class RequestProcess {

    public static ArrayList<DBColumn> dbcol;

    public interface Callback
    {
        void onSuccess(ArrayList<DBColumnResult> Result);

        void onError(String Error);
    }

    public static void setmodelmod(String Colname){
        dbcol.add(new DBColumn(Colname));
    }

    public static void setdatamod(Context context, String ApiKey, String Api_Secret, String appname, String TableName , ArrayList<DBColumn> dbcolumn, final Callback callback){
        ModelClass modelclass = new ModelClass();
        modelclass = new ModelClass(context,ApiKey,Api_Secret,appname,TableName,dbcolumn);
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

}
