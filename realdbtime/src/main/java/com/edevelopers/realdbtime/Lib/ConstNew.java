package com.edevelopers.realdbtime.Lib;

import com.edevelopers.realdbtime.Model.DBColRAWReturn;
import com.edevelopers.realdbtime.Model.DBColumn;
import com.edevelopers.realdbtime.Model.DBColumnDoub;
import com.edevelopers.realdbtime.Model.DBColumnResult;

import java.util.ArrayList;

public class ConstNew {

    public static final String INSERT_START_INIT = "INSERT INTO ";
    public static final String INSERT_START_VALUES = "VALUES ";
    public static final String INSERT_HEAD_DECLARE_start = " [";
    public static final String INSERT_HEAD_DECLARE_end = " [";
    public static final String INSERT_separater_DECLARE = ",";
    public static final String INSERT_VALUE_HEAD_DECLARE = "'";
    public static final String BRACK_START = " ( ";
    public static final String BRACK_end = " ) ";

    public static String getMSSQLQuery(String TableName, ArrayList<DBColumn> DBcol){

        String result = "SELECT '[' + STUFF(( SELECT ',{";
        String res = "";
        int arrsize = DBcol.size();
        arrsize = arrsize-1;
        for(int i = 0; i < DBcol.size(); i++){
            if(arrsize == i){
                res += "\""+DBcol.get(i).getColumnname()+"\":\"' + CAST(["+DBcol.get(i).getColumnname()+"] AS NVARCHAR(MAX)) + '\"";
            }
            else{
                res += "\""+DBcol.get(i).getColumnname()+"\":\"' + CAST(["+DBcol.get(i).getColumnname()+"] AS NVARCHAR(MAX)) + '\",' + '";
            }
        }

        result += res;
        result += "}' FROM ["+TableName+"] FOR XML PATH(''), TYPE  ).value('.', 'varchar(max)'),1,1,'' ) + ']' as best_result;";
        return result;
    }

    public static String getMSSQLQueryLimit(String limit, String TableName, ArrayList<DBColumn> DBcol){

        String result = "SELECT '[' + STUFF(( SELECT TOP ("+limit+") ',{";
        String res = "";
        int arrsize = DBcol.size();
        arrsize = arrsize-1;
        for(int i = 0; i < DBcol.size(); i++){
            if(arrsize == i){
                res += "\""+DBcol.get(i).getColumnname()+"\":\"' + CAST(["+DBcol.get(i).getColumnname()+"] AS NVARCHAR(MAX)) + '\"";
            }
            else{
                res += "\""+DBcol.get(i).getColumnname()+"\":\"' + CAST(["+DBcol.get(i).getColumnname()+"] AS NVARCHAR(MAX)) + '\",' + '";
            }
        }

        result += res;
        result += "}' FROM ["+TableName+"] FOR XML PATH(''), TYPE  ).value('.', 'varchar(max)'),1,1,'' ) + ']' as best_result;";
        return result;
    }

    public static String getMSSQLQuery_where(String TableName, ArrayList<DBColumn> DBcol,ArrayList<DBColumnResult> DBcolres){

        String result = "SELECT '[' + STUFF(( SELECT ',{";
        String res = "";
        int arrsize = DBcol.size();
        arrsize = arrsize-1;
        for(int i = 0; i < DBcol.size(); i++){
            if(arrsize == i){
                res += "\""+DBcol.get(i).getColumnname()+"\":\"' + CAST(["+DBcol.get(i).getColumnname()+"] AS NVARCHAR(MAX)) + '\"";
            }
            else{
                res += "\""+DBcol.get(i).getColumnname()+"\":\"' + CAST(["+DBcol.get(i).getColumnname()+"] AS NVARCHAR(MAX)) + '\",' + '";
            }
        }

        result += res;
        result += "}' FROM ["+TableName+"] "+ wclausebuilder(DBcolres) +" FOR XML PATH(''), TYPE  ).value('.', 'varchar(max)'),1,1,'' ) + ']' as best_result;";
        return result;
    }

    public static String getMSSQLQuery_where_Limit(String limit, String TableName, ArrayList<DBColumn> DBcol,ArrayList<DBColumnResult> DBcolres){

        String result = "SELECT '[' + STUFF(( SELECT TOP ("+limit+") ',{";
        String res = "";
        int arrsize = DBcol.size();
        arrsize = arrsize-1;
        for(int i = 0; i < DBcol.size(); i++){
            if(arrsize == i){
                res += "\""+DBcol.get(i).getColumnname()+"\":\"' + CAST(["+DBcol.get(i).getColumnname()+"] AS NVARCHAR(MAX)) + '\"";
            }
            else{
                res += "\""+DBcol.get(i).getColumnname()+"\":\"' + CAST(["+DBcol.get(i).getColumnname()+"] AS NVARCHAR(MAX)) + '\",' + '";
            }
        }

        result += res;
        result += "}' FROM ["+TableName+"] "+ wclausebuilder(DBcolres) +" FOR XML PATH(''), TYPE  ).value('.', 'varchar(max)'),1,1,'' ) + ']' as best_result;";
        return result;
    }

    public static String wclausebuilder(ArrayList<DBColumnResult> DBcolres){
        String wherecalus = "";
        int warrsize = DBcolres.size();
        warrsize = warrsize -1;
        for(int i = 0; i < DBcolres.size(); i++){
            if(warrsize == i){
                wherecalus += "[" +DBcolres.get(i).getColumnname()+"] = '"+ DBcolres.get(i).getColumnResult()+"' " ;
            }else{
                wherecalus += "[" +DBcolres.get(i).getColumnname()+"] = '"+ DBcolres.get(i).getColumnResult()+"' and " ;
            }
        }

        String result = "WHERE " + wherecalus;
        return result;
    }

    public static String getMSSQLQuery_whereRaw(String TableName, ArrayList<DBColumn> DBcol,String DBcolres){

        String result = "SELECT '[' + STUFF(( SELECT ',{";
        String res = "";
        int arrsize = DBcol.size();
        arrsize = arrsize-1;
        for(int i = 0; i < DBcol.size(); i++){
            if(arrsize == i){
                res += "\""+DBcol.get(i).getColumnname()+"\":\"' + CAST(["+DBcol.get(i).getColumnname()+"] AS NVARCHAR(MAX)) + '\"";
            }
            else{
                res += "\""+DBcol.get(i).getColumnname()+"\":\"' + CAST(["+DBcol.get(i).getColumnname()+"] AS NVARCHAR(MAX)) + '\",' + '";
            }
        }

        result += res;
        result += "}' FROM ["+TableName+"] "+ DBcolres +" FOR XML PATH(''), TYPE  ).value('.', 'varchar(max)'),1,1,'' ) + ']' as best_result;";
        return result;
    }

    public static String getMSSQLQuery_where_RawLimit(String limit, String TableName, ArrayList<DBColumn> DBcol,String DBcolres){

        String result = "SELECT '[' + STUFF(( SELECT TOP ("+limit+") ',{";
        String res = "";
        int arrsize = DBcol.size();
        arrsize = arrsize-1;
        for(int i = 0; i < DBcol.size(); i++){
            if(arrsize == i){
                res += "\""+DBcol.get(i).getColumnname()+"\":\"' + CAST(["+DBcol.get(i).getColumnname()+"] AS NVARCHAR(MAX)) + '\"";
            }
            else{
                res += "\""+DBcol.get(i).getColumnname()+"\":\"' + CAST(["+DBcol.get(i).getColumnname()+"] AS NVARCHAR(MAX)) + '\",' + '";
            }
        }

        result += res;
        result += "}' FROM ["+TableName+"] "+ DBcolres +" FOR XML PATH(''), TYPE  ).value('.', 'varchar(max)'),1,1,'' ) + ']' as best_result;";
        return result;
    }


    //AliyasingQuerybuilderssetup --------------------------------------------------------------->

    public static ArrayList<DBColRAWReturn> getMSSQLQuery_whereRawAliyasing(String TableName, ArrayList<DBColumnDoub> DBcol,String DBcolres){

        ArrayList<DBColumn> dbs = new ArrayList<>();
        String result = "SELECT '[' + STUFF(( SELECT ',{";
        String res = "";
        int arrsize = DBcol.size();
        arrsize = arrsize-1;
        for(int i = 0; i < DBcol.size(); i++){
            if(arrsize == i){
                res += "\""+DBcol.get(i).getColumnname()+"\":\"' + CAST("+DBcol.get(i).getColumnfunalias()+" AS NVARCHAR(MAX)) + '\"";
            }
            else{
                res += "\""+DBcol.get(i).getColumnname()+"\":\"' + CAST("+DBcol.get(i).getColumnfunalias()+" AS NVARCHAR(MAX)) + '\",' + '";
            }
            dbs.add(new DBColumn(DBcol.get(i).getColumnname()));
        }

        result += res;
        result += "}' FROM  "+TableName+"  "+ DBcolres +" FOR XML PATH(''), TYPE  ).value('.', 'varchar(max)'),1,1,'' ) + ']' as best_result;";

        ArrayList<DBColRAWReturn> returnlist = new ArrayList<>();
        returnlist.add(new DBColRAWReturn(result,dbs));

        return returnlist;
    }

    public static ArrayList<DBColRAWReturn> getMSSQLQuery_where_RawAliyasingLimit(String limit, String TableName, ArrayList<DBColumnDoub> DBcol, String DBcolres){

        ArrayList<DBColumn> dbs = new ArrayList<>();

        String result = "SELECT '[' + STUFF(( SELECT TOP ("+limit+") ',{";
        String res = "";
        int arrsize = DBcol.size();
        arrsize = arrsize-1;
        for(int i = 0; i < DBcol.size(); i++){
            if(arrsize == i){
                res += "\""+DBcol.get(i).getColumnname()+"\":\"' + CAST("+DBcol.get(i).getColumnfunalias()+" AS NVARCHAR(MAX)) + '\"";
            }
            else{
                res += "\""+DBcol.get(i).getColumnname()+"\":\"' + CAST("+DBcol.get(i).getColumnfunalias()+" AS NVARCHAR(MAX)) + '\",' + '";
            }
            dbs.add(new DBColumn(DBcol.get(i).getColumnname()));
        }

        result += res;
        result += "}' FROM  "+TableName+"  "+ DBcolres +" FOR XML PATH(''), TYPE  ).value('.', 'varchar(max)'),1,1,'' ) + ']' as best_result;";

        ArrayList<DBColRAWReturn> returnlist = new ArrayList<>();
        returnlist.add(new DBColRAWReturn(result,dbs));

        return returnlist;
    }

    public static String updateQueryBuilder(String TableName, ArrayList<DBColumnResult> DBcolvalue, ArrayList<DBColumnResult> DBcolwhere){
        String HeadUPdate = "UPDATE  ["+TableName+"] SET ";
        String upcalus = "";
        int uparrsize = DBcolvalue.size();
        uparrsize = uparrsize -1;
        for(int i = 0; i < DBcolvalue.size(); i++){
            if(uparrsize == i){
                upcalus += "[" +DBcolvalue.get(i).getColumnname()+"] = '"+ DBcolvalue.get(i).getColumnResult()+"' " ;
            }else{
                upcalus += "[" +DBcolvalue.get(i).getColumnname()+"] = '"+ DBcolvalue.get(i).getColumnResult()+"',  " ;
            }
        }

        String wresult = wclausebuilder(DBcolwhere);
        String result = HeadUPdate + upcalus + wresult +" ;";
        return result;
    }

    public static String insertQueryBuilder(String TableName, ArrayList<DBColumnResult> DBcolres){
        String start_result = INSERT_START_INIT + INSERT_HEAD_DECLARE_start + TableName + INSERT_HEAD_DECLARE_end + BRACK_START ;
        String end_result = INSERT_START_VALUES + BRACK_START ;

        String end_start_result = BRACK_end;
        String end_end_result = BRACK_end+";";

        String res_st = "";
        String res_end = "";
        int arrsize = DBcolres.size();
        arrsize = arrsize-1;
        for(int i = 0; i < DBcolres.size(); i++){
            if(arrsize == i){
                res_st += INSERT_HEAD_DECLARE_start+DBcolres.get(i).getColumnname()+INSERT_HEAD_DECLARE_end;
                res_end += INSERT_VALUE_HEAD_DECLARE+DBcolres.get(i).getColumnResult()+INSERT_VALUE_HEAD_DECLARE;
            }
            else{
                res_st += INSERT_HEAD_DECLARE_start+DBcolres.get(i).getColumnname()+INSERT_HEAD_DECLARE_end+INSERT_separater_DECLARE;
                res_end += INSERT_VALUE_HEAD_DECLARE+DBcolres.get(i).getColumnResult()+INSERT_VALUE_HEAD_DECLARE+INSERT_separater_DECLARE;
            }
        }

        String result = start_result + res_st + end_start_result + end_result + res_end + end_end_result;
        return result;
    }
}
