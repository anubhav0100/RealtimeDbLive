package com.edevelopers.realdbtime.Lib;



import com.edevelopers.realdbtime.Model.DBColRAWReturn;
import com.edevelopers.realdbtime.Model.DBColumn;
import com.edevelopers.realdbtime.Model.DBColumnDoub;
import com.edevelopers.realdbtime.Model.DBColumnResult;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Const {


    public static String API_URL = "";

    public static final int GET_TAG_INSERT = 1;
    public static final int GET_TAG_UPDATE = 2;
    public static final int GET_TAG_GETDATA = 3;
    public static final int GET_TAG_GETDATA_WHERE = 4;

    public static final int MSSQL = 1;
    public static final int MYSQL = 2;


    public static final String TAG = "RealTime_Db_Live";
    public static final String api_key = "api_key";
    public static final String appname = "appname";
    public static final String api_secret = "api_secret";
    public static final String g_username = "g_username";
    public static final String g_password = "g_password";
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

    public static final String INSERT_START_INIT = "INSERT INTO ";
    public static final String INSERT_START_VALUES = "VALUES ";
    public static final String INSERT_HEAD_DECLARE = "`";
    public static final String INSERT_separater_DECLARE = ",";
    public static final String INSERT_VALUE_HEAD_DECLARE = "'";


    public static final String WHERE_CLAUS_START = " WHERE ";
    public static final String reg = "password";
    String str = "Where email = 'admin@example.com'";

    public static String wclausebuilder(ArrayList<DBColumnResult> DBcolres){
        String wherecalus = "";
        int warrsize = DBcolres.size();
        warrsize = warrsize -1;
        for(int i = 0; i < DBcolres.size(); i++){
            if(warrsize == i){
                wherecalus += "`" +DBcolres.get(i).getColumnname()+"` = '"+ DBcolres.get(i).getColumnResult()+"' " ;
            }else{
                wherecalus += "`" +DBcolres.get(i).getColumnname()+"` = '"+ DBcolres.get(i).getColumnResult()+"' and " ;
            }
        }

        String result = WHERE_CLAUS_START + wherecalus;
        return result;
    }

    public static String thirdlevelbuilder_where(String TableName, ArrayList<DBColumn> DBcol,ArrayList<DBColumnResult> DBcolres){
        String result = BEST_LEVEL + BRACK_START + BETTER_lEVEL + BRACK_START +" SELECT CONCAT(";

        String res = "'";
        int arrsize = DBcol.size();
        arrsize = arrsize-1;
        for(int i = 0; i < DBcol.size(); i++){
            if(arrsize == i){
                res += "\""+DBcol.get(i).getColumnname()+"\":','\"'," +DBcol.get(i).getColumnname()+", '\"'";
            }
            else{
                res += "\""+DBcol.get(i).getColumnname()+"\":','\"'," +DBcol.get(i).getColumnname()+", '\"'"+",',";
            }
        }

        String wresult = wclausebuilder(DBcolres);

        result += res;
        result += BRACK_end +" AS my_json FROM "+TableName+" "+wresult + " ";
        result +=  BRACK_end + BOTTOM_SECOND_lEVEL + BRACK_end + BOTTOM_LAST_lEVEL;
        return result;
    }

    public static String thirdlevelbuilder(String TableName, ArrayList<DBColumn> DBcol){
        String result = BEST_LEVEL + BRACK_START + BETTER_lEVEL + BRACK_START +" SELECT CONCAT(";

        String res = "'";
        int arrsize = DBcol.size();
        arrsize = arrsize-1;
        for(int i = 0; i < DBcol.size(); i++){
            if(arrsize == i){
                res += "\""+DBcol.get(i).getColumnname()+"\":','\"'," +DBcol.get(i).getColumnname()+", '\"'";
            }
            else{
                res += "\""+DBcol.get(i).getColumnname()+"\":','\"'," +DBcol.get(i).getColumnname()+", '\"'"+",',";
            }
        }

        result += res;
        result += BRACK_end +" AS my_json FROM "+TableName+" ";
        result +=  BRACK_end + BOTTOM_SECOND_lEVEL + BRACK_end + BOTTOM_LAST_lEVEL;
        return result;
    }

    public static String thirdlevelbuilder_whereLimit(String limit,String TableName, ArrayList<DBColumn> DBcol,ArrayList<DBColumnResult> DBcolres){
        String result = BEST_LEVEL + BRACK_START + BETTER_lEVEL + BRACK_START +" SELECT CONCAT(";

        String res = "'";
        int arrsize = DBcol.size();
        arrsize = arrsize-1;
        for(int i = 0; i < DBcol.size(); i++){
            if(arrsize == i){
                res += "\""+DBcol.get(i).getColumnname()+"\":','\"'," +DBcol.get(i).getColumnname()+", '\"'";
            }
            else{
                res += "\""+DBcol.get(i).getColumnname()+"\":','\"'," +DBcol.get(i).getColumnname()+", '\"'"+",',";
            }
        }

        String wresult = wclausebuilder(DBcolres);

        result += res;
        result += BRACK_end +" AS my_json FROM "+TableName+" "+wresult + " limit "+limit+" ";
        result +=  BRACK_end + BOTTOM_SECOND_lEVEL + BRACK_end + BOTTOM_LAST_lEVEL;
        return result;
    }

    public static String thirdlevelbuilderLimit(String limit,String TableName, ArrayList<DBColumn> DBcol){
        String result = BEST_LEVEL + BRACK_START + BETTER_lEVEL + BRACK_START +" SELECT CONCAT(";

        String res = "'";
        int arrsize = DBcol.size();
        arrsize = arrsize-1;
        for(int i = 0; i < DBcol.size(); i++){
            if(arrsize == i){
                res += "\""+DBcol.get(i).getColumnname()+"\":','\"'," +DBcol.get(i).getColumnname()+", '\"'";
            }
            else{
                res += "\""+DBcol.get(i).getColumnname()+"\":','\"'," +DBcol.get(i).getColumnname()+", '\"'"+",',";
            }
        }

        result += res;
        result += BRACK_end +" AS my_json FROM "+TableName+" limit "+limit+" ";
        result +=  BRACK_end + BOTTOM_SECOND_lEVEL + BRACK_end + BOTTOM_LAST_lEVEL;
        return result;
    }

    public static String insertQueryBuilder(String TableName, ArrayList<DBColumnResult> DBcolres){
        String start_result = INSERT_START_INIT + INSERT_HEAD_DECLARE + TableName + INSERT_HEAD_DECLARE + BRACK_START ;
        String end_result = INSERT_START_VALUES + BRACK_START ;

        String end_start_result = BRACK_end;
        String end_end_result = BRACK_end+";";

        String res_st = "";
        String res_end = "";
        int arrsize = DBcolres.size();
        arrsize = arrsize-1;
        for(int i = 0; i < DBcolres.size(); i++){
            if(arrsize == i){
                res_st += INSERT_HEAD_DECLARE+DBcolres.get(i).getColumnname()+INSERT_HEAD_DECLARE;
                res_end += INSERT_VALUE_HEAD_DECLARE+DBcolres.get(i).getColumnResult()+INSERT_VALUE_HEAD_DECLARE;
            }
            else{
                res_st += INSERT_HEAD_DECLARE+DBcolres.get(i).getColumnname()+INSERT_HEAD_DECLARE+INSERT_separater_DECLARE;
                res_end += INSERT_VALUE_HEAD_DECLARE+DBcolres.get(i).getColumnResult()+INSERT_VALUE_HEAD_DECLARE+INSERT_separater_DECLARE;
            }
        }

        String result = start_result + res_st + end_start_result + end_result + res_end + end_end_result;
        return result;
    }

    public static String updateQueryBuilder(String TableName, ArrayList<DBColumnResult> DBcolvalue, ArrayList<DBColumnResult> DBcolwhere){
        String HeadUPdate = "UPDATE  `"+TableName+"` SET ";
        String upcalus = "";
        int uparrsize = DBcolvalue.size();
        uparrsize = uparrsize -1;
        for(int i = 0; i < DBcolvalue.size(); i++){
            if(uparrsize == i){
                upcalus += "`" +DBcolvalue.get(i).getColumnname()+"` = '"+ DBcolvalue.get(i).getColumnResult()+"' " ;
            }else{
                upcalus += "`" +DBcolvalue.get(i).getColumnname()+"` = '"+ DBcolvalue.get(i).getColumnResult()+"',  " ;
            }
        }

        String wresult = wclausebuilder(DBcolwhere);
        String result = HeadUPdate + upcalus + wresult +" ;";
        return result;
    }

    public static String gettodaydate_timemysql_laravel() {
        Date tdate = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String cdate = sdf.format(tdate).toString().trim();
        return cdate;
    }

    public static String thirdlevelbuilder_whereRawLimit(String limit,String TableName, ArrayList<DBColumn> DBcol,String DBcolres){
        String result = BEST_LEVEL + BRACK_START + BETTER_lEVEL + BRACK_START +" SELECT CONCAT(";

        String res = "'";
        int arrsize = DBcol.size();
        arrsize = arrsize-1;
        for(int i = 0; i < DBcol.size(); i++){
            if(arrsize == i){
                res += "\""+DBcol.get(i).getColumnname()+"\":','\"'," +DBcol.get(i).getColumnname()+", '\"'";
            }
            else{
                res += "\""+DBcol.get(i).getColumnname()+"\":','\"'," +DBcol.get(i).getColumnname()+", '\"'"+",',";
            }
        }

        String wresult = DBcolres;

        result += res;
        result += BRACK_end +" AS my_json FROM "+TableName+" "+wresult + " limit "+limit+" ";
        result +=  BRACK_end + BOTTOM_SECOND_lEVEL + BRACK_end + BOTTOM_LAST_lEVEL;
        return result;
    }

    public static String thirdlevelbuilder_whereRaw(String TableName, ArrayList<DBColumn> DBcol,String DBcolres){
        String result = BEST_LEVEL + BRACK_START + BETTER_lEVEL + BRACK_START +" SELECT CONCAT(";

        String res = "'";
        int arrsize = DBcol.size();
        arrsize = arrsize-1;
        for(int i = 0; i < DBcol.size(); i++){
            if(arrsize == i){
                res += "\""+DBcol.get(i).getColumnname()+"\":','\"'," +DBcol.get(i).getColumnname()+", '\"'";
            }
            else{
                res += "\""+DBcol.get(i).getColumnname()+"\":','\"'," +DBcol.get(i).getColumnname()+", '\"'"+",',";
            }
        }

        String wresult = DBcolres;

        result += res;
        result += BRACK_end +" AS my_json FROM "+TableName+" "+wresult + " ";
        result +=  BRACK_end + BOTTOM_SECOND_lEVEL + BRACK_end + BOTTOM_LAST_lEVEL;
        return result;
    }


         //AliyasingQuerybuilderssetup --------------------------------------------------------------->


    public static ArrayList<DBColRAWReturn> thirdlevelbuilder_whereRawAliyasingLimit(String limit, String TableName, ArrayList<DBColumnDoub> DBcol, String DBcolres){

        ArrayList<DBColumn> dbs = new ArrayList<>();

        String result = BEST_LEVEL + BRACK_START + BETTER_lEVEL + BRACK_START +" SELECT CONCAT(";

        String res = "'";
        int arrsize = DBcol.size();
        arrsize = arrsize-1;
        for(int i = 0; i < DBcol.size(); i++){
            if(arrsize == i){
                res += "\""+DBcol.get(i).getColumnname()+"\":','\"'," +DBcol.get(i).getColumnfunalias()+", '\"'";
            }
            else{
                res += "\""+DBcol.get(i).getColumnname()+"\":','\"'," +DBcol.get(i).getColumnfunalias()+", '\"'"+",',";
            }
            dbs.add(new DBColumn(DBcol.get(i).getColumnname()));
        }

        String wresult = DBcolres;

        result += res;
        result += BRACK_end +" AS my_json FROM "+TableName+" "+wresult + " limit "+limit+" ";
        result +=  BRACK_end + BOTTOM_SECOND_lEVEL + BRACK_end + BOTTOM_LAST_lEVEL;

        ArrayList<DBColRAWReturn> returnlist = new ArrayList<>();
        returnlist.add(new DBColRAWReturn(result,dbs));

        return returnlist;
    }

    public static ArrayList<DBColRAWReturn> thirdlevelbuilder_whereRawAliyasing(String TableName, ArrayList<DBColumnDoub> DBcol,String DBcolres){

        ArrayList<DBColumn> dbs = new ArrayList<>();
        String result = BEST_LEVEL + BRACK_START + BETTER_lEVEL + BRACK_START +" SELECT CONCAT(";

        String res = "'";
        int arrsize = DBcol.size();
        arrsize = arrsize-1;
        for(int i = 0; i < DBcol.size(); i++){
            if(arrsize == i){
                res += "\""+DBcol.get(i).getColumnname()+"\":','\"'," +DBcol.get(i).getColumnfunalias()+", '\"'";
            }
            else{
                res += "\""+DBcol.get(i).getColumnname()+"\":','\"'," +DBcol.get(i).getColumnfunalias()+", '\"'"+",',";
            }
            dbs.add(new DBColumn(DBcol.get(i).getColumnname()));
        }

        String wresult = DBcolres;

        result += res;
        result += BRACK_end +" AS my_json FROM "+TableName+" "+wresult + " ";
        result +=  BRACK_end + BOTTOM_SECOND_lEVEL + BRACK_end + BOTTOM_LAST_lEVEL;

        ArrayList<DBColRAWReturn> returnlist = new ArrayList<>();
        returnlist.add(new DBColRAWReturn(result,dbs));

        return returnlist;
    }
}
