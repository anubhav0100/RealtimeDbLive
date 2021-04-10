package com.edevelopers.realdbtime.Lib;

import com.edevelopers.realdbtime.Model.DBColRAWReturn;
import com.edevelopers.realdbtime.Model.DBColumn;
import com.edevelopers.realdbtime.Model.DBColumnDoub;
import com.edevelopers.realdbtime.Model.DBColumnResult;

import java.util.ArrayList;

public class ConstOrc {

    public static final String INSERT_START_INIT = "INSERT INTO ";
    public static final String INSERT_START_VALUES = "VALUES ";
    public static final String INSERT_HEAD_DECLARE = " ";
    public static final String INSERT_separater_DECLARE = ",";
    public static final String INSERT_VALUE_HEAD_DECLARE = "'";
    public static final String BRACK_START = " ( ";
    public static final String BRACK_end = " ) ";

    public static String getORACLEQuery(String TableName, ArrayList<DBColumn> DBcol){

        String result = "select '['||(select substr(my_json, 2,LENGTH(my_json)) from ( SELECT ',{'";
        String res = "";
        int arrsize = DBcol.size();
        arrsize = arrsize-1;
        for(int i = 0; i < DBcol.size(); i++){
            if(arrsize == i){
                res += "||'\""+DBcol.get(i).getColumnname()+"\":'||'\"'||"+DBcol.get(i).getColumnname()+"||'\"'||'";
            }
            else{
                res = "||'\""+DBcol.get(i).getColumnname()+"\":'||'\"'||"+DBcol.get(i).getColumnname()+"||'\"'||',";
            }
        }

        result += res;
        result += "}' AS my_json FROM "+TableName+" ))||']' as best_result from dual;";
        return result;
    }

    public static String getORACLEQueryLimit(String limit, String TableName, ArrayList<DBColumn> DBcol){

        String result = "select '['||(select substr(my_json, 2,LENGTH(my_json)) from ( SELECT ',{'";
        String res = "";
        int arrsize = DBcol.size();
        arrsize = arrsize-1;
        for(int i = 0; i < DBcol.size(); i++){
            if(arrsize == i){
                res += "||'\""+DBcol.get(i).getColumnname()+"\":'||'\"'||"+DBcol.get(i).getColumnname()+"||'\"'||'";
            }
            else{
                res = "||'\""+DBcol.get(i).getColumnname()+"\":'||'\"'||"+DBcol.get(i).getColumnname()+"||'\"'||',";
            }
        }

        result += res;
        result += "}' AS my_json FROM "+TableName+" WHERE ROWNUM <=  '"+limit+"' ))||']' as best_result from dual;";
        return result;
    }

    public static String getORACLEQuery_where(String TableName, ArrayList<DBColumn> DBcol,ArrayList<DBColumnResult> DBcolres){

        String result = "select '['||(select substr(my_json, 2,LENGTH(my_json)) from ( SELECT ',{'";
        String res = "";
        int arrsize = DBcol.size();
        arrsize = arrsize-1;
        for(int i = 0; i < DBcol.size(); i++){
            if(arrsize == i){
                res += "||'\""+DBcol.get(i).getColumnname()+"\":'||'\"'||"+DBcol.get(i).getColumnname()+"||'\"'||'";
            }
            else{
                res = "||'\""+DBcol.get(i).getColumnname()+"\":'||'\"'||"+DBcol.get(i).getColumnname()+"||'\"'||',";
            }
        }

        result += res;
        result += "}' AS my_json FROM "+TableName+" "+wclausebuilder(DBcolres)+"  ))||']' as best_result from dual;";
        return result;
    }

    public static String getORACLEQuery_where_Limit(String limit, String TableName, ArrayList<DBColumn> DBcol,ArrayList<DBColumnResult> DBcolres){

        String result = "select '['||(select substr(my_json, 2,LENGTH(my_json)) from ( SELECT ',{'";
        String res = "";
        int arrsize = DBcol.size();
        arrsize = arrsize-1;
        for(int i = 0; i < DBcol.size(); i++){
            if(arrsize == i){
                res += "||'\""+DBcol.get(i).getColumnname()+"\":'||'\"'||"+DBcol.get(i).getColumnname()+"||'\"'||'";
            }
            else{
                res = "||'\""+DBcol.get(i).getColumnname()+"\":'||'\"'||"+DBcol.get(i).getColumnname()+"||'\"'||',";
            }
        }

        result += res;
        result += "}' AS my_json FROM "+TableName+" "+wclausebuilder(DBcolres)+"  ROWNUM <=  '"+limit+"' ))||']' as best_result from dual;";
        return result;
    }

    public static String wclausebuilder(ArrayList<DBColumnResult> DBcolres){
        String wherecalus = "";
        int warrsize = DBcolres.size();
        warrsize = warrsize -1;
        for(int i = 0; i < DBcolres.size(); i++){
            if(warrsize == i){
                wherecalus += " " +DBcolres.get(i).getColumnname()+" = '"+ DBcolres.get(i).getColumnResult()+"' " ;
            }else{
                wherecalus += " " +DBcolres.get(i).getColumnname()+" = '"+ DBcolres.get(i).getColumnResult()+"' and " ;
            }
        }

        String result = "WHERE " + wherecalus;
        return result;
    }

    public static String getORACLEQuery_whereRaw(String TableName, ArrayList<DBColumn> DBcol,String DBcolres){

        String result = "select '['||(select substr(my_json, 2,LENGTH(my_json)) from ( SELECT ',{'";
        String res = "";
        int arrsize = DBcol.size();
        arrsize = arrsize-1;
        for(int i = 0; i < DBcol.size(); i++){
            if(arrsize == i){
                res += "||'\""+DBcol.get(i).getColumnname()+"\":'||'\"'||"+DBcol.get(i).getColumnname()+"||'\"'||'";
            }
            else{
                res = "||'\""+DBcol.get(i).getColumnname()+"\":'||'\"'||"+DBcol.get(i).getColumnname()+"||'\"'||',";
            }
        }

        result += res;
        result += "}' AS my_json FROM "+TableName+" "+DBcolres+" ))||']' as best_result from dual;";
        return result;
    }

    public static String getORACLEQuery_where_RawLimit(String limit, String TableName, ArrayList<DBColumn> DBcol,String DBcolres){

        String result = "select '['||(select substr(my_json, 2,LENGTH(my_json)) from ( SELECT ',{'";
        String res = "";
        int arrsize = DBcol.size();
        arrsize = arrsize-1;
        for(int i = 0; i < DBcol.size(); i++){
            if(arrsize == i){
                res += "||'\""+DBcol.get(i).getColumnname()+"\":'||'\"'||"+DBcol.get(i).getColumnname()+"||'\"'||'";
            }
            else{
                res = "||'\""+DBcol.get(i).getColumnname()+"\":'||'\"'||"+DBcol.get(i).getColumnname()+"||'\"'||',";
            }
        }

        result += res;
        String RowLimit = "";
        if(DBcolres.equals("")){
            RowLimit   = "Where  ROWNUM <=  '"+limit+"'";
        }
        else{
            RowLimit   = " ROWNUM <=  '"+limit+"'";
        }
        result += "}' AS my_json FROM "+TableName+" "+DBcolres+"  "+RowLimit+" ))||']' as best_result from dual;";
        return result;
    }


    //AliyasingQuerybuilderssetup --------------------------------------------------------------->

    public static ArrayList<DBColRAWReturn> getORACLEQuery_whereRawAliyasing(String TableName, ArrayList<DBColumnDoub> DBcol, String DBcolres){

        ArrayList<DBColumn> dbs = new ArrayList<>();
        String result = "select '['||(select substr(my_json, 2,LENGTH(my_json)) from ( SELECT ',{'";
        String res = "";
        int arrsize = DBcol.size();
        arrsize = arrsize-1;
        for(int i = 0; i < DBcol.size(); i++){
            if(arrsize == i){
                res += "||'\""+DBcol.get(i).getColumnname()+"\":'||'\"'||"+DBcol.get(i).getColumnfunalias()+"||'\"'||'";
            }
            else{
                res = "||'\""+DBcol.get(i).getColumnname()+"\":'||'\"'||"+DBcol.get(i).getColumnfunalias()+"||'\"'||',";
            }
            dbs.add(new DBColumn(DBcol.get(i).getColumnname()));
        }

        result += res;
        result += "}' AS my_json FROM "+TableName+"  "+DBcolres+"  ))||']' as best_result from dual;";

        ArrayList<DBColRAWReturn> returnlist = new ArrayList<>();
        returnlist.add(new DBColRAWReturn(result,dbs));

        return returnlist;
    }

    public static ArrayList<DBColRAWReturn> getORACLEQuery_where_RawAliyasingLimit(String limit, String TableName, ArrayList<DBColumnDoub> DBcol, String DBcolres){

        ArrayList<DBColumn> dbs = new ArrayList<>();

        String result = "select '['||(select substr(my_json, 2,LENGTH(my_json)) from ( SELECT ',{'";
        String res = "";
        int arrsize = DBcol.size();
        arrsize = arrsize-1;
        for(int i = 0; i < DBcol.size(); i++){
            if(arrsize == i){
                res += "||'\""+DBcol.get(i).getColumnname()+"\":'||'\"'||"+DBcol.get(i).getColumnfunalias()+"||'\"'||'";
            }
            else{
                res = "||'\""+DBcol.get(i).getColumnname()+"\":'||'\"'||"+DBcol.get(i).getColumnfunalias()+"||'\"'||',";
            }
            dbs.add(new DBColumn(DBcol.get(i).getColumnname()));
        }

        result += res;
        String RowLimit = "";
        if(DBcolres.equals("")){
            RowLimit   = "Where  ROWNUM <=  '"+limit+"'";
        }
        else{
            RowLimit   = " ROWNUM <=  '"+limit+"'";
        }
        result += "}' AS my_json FROM "+TableName+"  "+DBcolres+" "+RowLimit+" ))||']' as best_result from dual;";

        ArrayList<DBColRAWReturn> returnlist = new ArrayList<>();
        returnlist.add(new DBColRAWReturn(result,dbs));

        return returnlist;
    }

    public static String updateQueryBuilder(String TableName, ArrayList<DBColumnResult> DBcolvalue, ArrayList<DBColumnResult> DBcolwhere){
        String HeadUPdate = "UPDATE  "+TableName+" SET ";
        String upcalus = "";
        int uparrsize = DBcolvalue.size();
        uparrsize = uparrsize -1;
        for(int i = 0; i < DBcolvalue.size(); i++){
            if(uparrsize == i){
                upcalus += " " +DBcolvalue.get(i).getColumnname()+"  = '"+ DBcolvalue.get(i).getColumnResult()+"' " ;
            }else{
                upcalus += " " +DBcolvalue.get(i).getColumnname()+"  = '"+ DBcolvalue.get(i).getColumnResult()+"',  " ;
            }
        }

        String wresult = wclausebuilder(DBcolwhere);
        String result = HeadUPdate + upcalus + wresult +" ;";
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
}
