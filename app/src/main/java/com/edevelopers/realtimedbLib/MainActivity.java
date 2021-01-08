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
        RequestProcess.setmodelmod("user_name"); // set column name
        RequestProcess.setmodelmod("email"); // set column name

        String ApiKEy = "";
        String ApiSecret = "";
        String AppName = "";
        String Table_Name = "users";
        RequestProcess.setdatamod(MainActivity.this, ApiKEy, ApiSecret, AppName, Table_Name, RequestProcess.dbcol, new RequestProcess.Callback() {
            @Override
            public void onSuccess(ArrayList<DBColumnResult> Result) {
                //GEt Your Result HEre
            }

            @Override
            public void onError(String Error) {
                // Show Error
            }
        });

    }
}