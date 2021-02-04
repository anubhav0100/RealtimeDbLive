package com.edevelopers.realdbtime.Service;

import android.content.Context;
import android.util.Log;

import androidx.annotation.NonNull;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.edevelopers.realdbtime.Lib.Const;
import com.edevelopers.realdbtime.Lib.customRequest;
import com.edevelopers.realdbtime.Model.DBColumn;
import com.edevelopers.realdbtime.Model.DBColumnResult;
import com.edevelopers.realdbtime.Model.ModelClass;
import com.edevelopers.realdbtime.Model.RegisterLoginModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class LoginDB {

    public interface Callback
    {
        void onSuccess(RegisterLoginModel Result);

        void onError(String Error);
    }

    public static void LoginUser(Context context, String ApiKEy, String ApiSecret, String Username, String Password,final Callback callback){
        service_class.RequestDataLogin(context, ApiKEy, ApiSecret, Username, Password, new service_class.Callbacklogin() {
            @Override
            public void onSuccess(RegisterLoginModel Result) {
                callback.onSuccess(Result);
            }

            @Override
            public void onError(String Error) {
                callback.onError(Error);
            }
        });
    }

}
