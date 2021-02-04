package com.edevelopers.realdbtime.Service;

import android.content.Context;

import androidx.annotation.NonNull;

import com.edevelopers.realdbtime.Lib.Const;
import com.edevelopers.realdbtime.Model.DBColumn;
import com.edevelopers.realdbtime.Model.DBColumnResult;
import com.edevelopers.realdbtime.Model.ModelClass;
import com.edevelopers.realdbtime.Model.RegisterLoginModel;

import java.util.ArrayList;

public class RegisterDB {

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

    public void setRegisterDB(@NonNull Context context, RegisterLoginModel registerModel, final RequestProcess.Callbackres callback){

        RequestProcess.dbcolinsert = new ArrayList<DBColumnResult>();

        RequestProcess.setmodelmodinsert("username",registerModel.getUsername());
        RequestProcess.setmodelmodinsert("password","breplacepassword");
        RequestProcess.setmodelmodinsert("email",registerModel.getEmail());
        RequestProcess.setmodelmodinsert("phonenumber",registerModel.getPhonenumber());
        RequestProcess.setmodelmodinsert("first_name",registerModel.getFirst_name());
        RequestProcess.setmodelmodinsert("middle_name",registerModel.getMiddle_name());
        RequestProcess.setmodelmodinsert("last_name",registerModel.getLast_name());
        RequestProcess.setmodelmodinsert("address",registerModel.getAddress());
        RequestProcess.setmodelmodinsert("country",registerModel.getCountry());
        RequestProcess.setmodelmodinsert("logDate", Const.gettodaydate_timemysql_laravel());

        ModelClass modelclass = new ModelClass();
        ArrayList<DBColumn> emptydbcolumn = new ArrayList<>();
        ArrayList<DBColumnResult> emptycolwhere = new ArrayList<>();
        modelclass = new ModelClass(context,registerModel.getApiKey(),registerModel.getApi_Secret(),registerModel.getPassword(),emptydbcolumn,RequestProcess.dbcolinsert,emptycolwhere, Const.GET_TAG_INSERT);
        service_class.SaveDataRegister(modelclass, new service_class.Callbackres() {
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

}