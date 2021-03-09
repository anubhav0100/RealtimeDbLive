package com.edevelopers.realtimedbLib;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import com.edevelopers.realdbtime.Model.DBColumn;
import com.edevelopers.realdbtime.Lib.Const;
import com.edevelopers.realdbtime.Model.DBColumnResult;
import com.edevelopers.realdbtime.Service.RequestProcess;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RequestProcess.dbcol = new ArrayList<>();
        RequestProcess.dbcolwhere = new ArrayList<>();
        RequestProcess.setmodelmod("USERID"); // set column name
        RequestProcess.setmodelmod("USERNAME"); // set column name
        RequestProcess.setmodelmod("FIRST_NAME"); // set column name
        RequestProcess.setmodelmod("LAST_NAME"); // set column name
        RequestProcess.setmodelmod("EMAILID"); // set column name
        RequestProcess.setmodelmod("ROLE"); // set column name

      //  RequestProcess.setmodelmodWhere("email","info@something.com");

        String ApiKEy = "apiem_live_aap_AK/jLZvU5R7eWVUKmX5C6XcFcNMsp96ldF0w8qT93P7EQ6L4WDqBbQQhXEv/Yg5G/Q==";
        String ApiSecret = "secreteml_live_secret_ANtd1RW2KQQPDaQFr0flsrOci4nlJ8SGp3e6RThzzHEyqMtIv58tCPTL1Hx873JFHw==";
        String AppName = "App";
        String Table_Name = "users";

        RequestProcess.getdatamod(MainActivity.this, ApiKEy, ApiSecret, AppName, Table_Name, Const.MSSQL,0,RequestProcess.dbcol, new RequestProcess.Callback() {
            @Override
            public void onSuccess(ArrayList<DBColumnResult> Result) {
                //GEt Your Result HEre
            }

            @Override
            public void onError(String Error) {
                // Show Error
            }
        });

//        RequestProcess.dbcolinsert = new ArrayList<>();
//        RequestProcess.setmodelmodinsert("email","info@edevlopers.com"); // set column name
//        RequestProcess.setmodelmodinsert("name","Edevlopers"); // set column name
//        RequestProcess.setmodelmodinsert("phonenumber","+911234569870"); // set column name
//        RequestProcess.setmodelmodinsert("refcode","refcode"); // set column name
//        RequestProcess.setmodelmodinsert("appied_refcode","N/A"); // set column name
//        RequestProcess.setmodelmodinsert("status","1"); // set column name
//
//        RequestProcess.savedatamod(MainActivity.this, ApiKEy, ApiSecret, AppName, Table_Name, RequestProcess.dbcolinsert, new RequestProcess.Callbackres() {
//            @Override
//            public void onSuccess(String Result) {
//                String res = Result;
//            }
//
//            @Override
//            public void onError(String Error) {
//                String err = Error;
//            }
//        });

    }
}