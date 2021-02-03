package com.edevelopers.realdbtime.Model;

import android.content.Context;

import androidx.annotation.NonNull;

import com.edevelopers.realdbtime.Lib.Const;
import com.edevelopers.realdbtime.Service.RequestProcess;
import com.edevelopers.realdbtime.Service.service_class;

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

    public void setRegisterDB(@NonNull Context context,RegisterModel registerModel,final RequestProcess.Callbackres callback){

        RequestProcess.dbcolinsert = new ArrayList<DBColumnResult>();

        RequestProcess.setmodelmodinsert("username",registerModel.username);
        RequestProcess.setmodelmodinsert("password","breplacepassword");
        RequestProcess.setmodelmodinsert("email",registerModel.email);
        RequestProcess.setmodelmodinsert("phonenumber",registerModel.phonenumber);
        RequestProcess.setmodelmodinsert("first_name",registerModel.first_name);
        RequestProcess.setmodelmodinsert("middle_name",registerModel.middle_name);
        RequestProcess.setmodelmodinsert("last_name",registerModel.last_name);
        RequestProcess.setmodelmodinsert("address",registerModel.address);
        RequestProcess.setmodelmodinsert("country",registerModel.country);
        RequestProcess.setmodelmodinsert("logDate", Const.gettodaydate_timemysql_laravel());

        ModelClass modelclass = new ModelClass();
        ArrayList<DBColumn> emptydbcolumn = new ArrayList<>();
        ArrayList<DBColumnResult> emptycolwhere = new ArrayList<>();
        modelclass = new ModelClass(context,registerModel.ApiKey,registerModel.Api_Secret,registerModel.Password,emptydbcolumn,RequestProcess.dbcolinsert,emptycolwhere, Const.GET_TAG_INSERT);
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