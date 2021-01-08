package com.edevelopers.realdbtime.Lib;



import com.edevelopers.realdbtime.Model.DBColumn;

import java.util.ArrayList;

public class Const {

    public static final String TAG = "RealTime_Db_Live";
    public static final String api_key = "api_key";
    public static final String appname = "appname";
    public static final String api_secret = "api_secret";
    public static final String query = "query";

    public static final String BRACK_START = " ( ";
    public static final String BRACK_end = " ) ";
    public static final String BEST_LEVEL = " SELECT CONCAT('[', better_result, ']') AS best_result FROM ";
    public static final String BETTER_lEVEL = " SELECT GROUP_CONCAT('{', my_json, '}' SEPARATOR ',') AS better_result FROM ";
    public static final String BOTTOM_SECOND_lEVEL = " AS more_json ";
    public static final String BOTTOM_LAST_lEVEL = " AS yet_more_json;";

    public static final String first_t_start = "'\"";
    public static final String first_t_end = "\":',";
    public static final String mid_t = "'\"',";
    public static final String second_t_start = ", '\"'";
    public static final String second_t_end = ",','";

    public static String thirdlevelbuilder(String TableName, ArrayList<DBColumn> DBcol){
        String result = BEST_LEVEL + BRACK_START + BETTER_lEVEL + BRACK_START +" SELECT CONCAT(";

        String res = "";
        int arrsize = DBcol.size();
        arrsize = arrsize-1;
        for(int i = 0; i < DBcol.size(); i++){
            if(arrsize == i){
                res += first_t_start+DBcol.get(i).getColumnname()+first_t_end+mid_t +DBcol.get(i).getColumnname()+second_t_start;
            }
            else{
                res += first_t_start+DBcol.get(i).getColumnname()+first_t_end+mid_t +DBcol.get(i).getColumnname()+second_t_start+second_t_end;
            }
        }

        result += res;
        result += BRACK_end +" AS my_json FROM "+TableName+" ";
        result +=  BRACK_end + BOTTOM_SECOND_lEVEL + BRACK_end + BOTTOM_LAST_lEVEL;
        return result;
    }

}
