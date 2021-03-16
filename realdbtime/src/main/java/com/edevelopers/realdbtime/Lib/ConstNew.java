package com.edevelopers.realdbtime.Lib;

import com.edevelopers.realdbtime.Model.DBColRAWReturn;
import com.edevelopers.realdbtime.Model.DBColumn;
import com.edevelopers.realdbtime.Model.DBColumnDoub;
import com.edevelopers.realdbtime.Model.DBColumnResult;

import java.util.ArrayList;

public class ConstNew {

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
                res += "\""+DBcol.get(i).getColumnname()+"\":\"' + CAST(["+DBcol.get(i).getColumnfunalias()+"] AS NVARCHAR(MAX)) + '\"";
            }
            else{
                res += "\""+DBcol.get(i).getColumnname()+"\":\"' + CAST(["+DBcol.get(i).getColumnfunalias()+"] AS NVARCHAR(MAX)) + '\",' + '";
            }
            dbs.add(new DBColumn(DBcol.get(i).getColumnname()));
        }

        result += res;
        result += "}' FROM ["+TableName+"] "+ DBcolres +" FOR XML PATH(''), TYPE  ).value('.', 'varchar(max)'),1,1,'' ) + ']' as best_result;";

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
                res += "\""+DBcol.get(i).getColumnname()+"\":\"' + CAST(["+DBcol.get(i).getColumnfunalias()+"] AS NVARCHAR(MAX)) + '\"";
            }
            else{
                res += "\""+DBcol.get(i).getColumnname()+"\":\"' + CAST(["+DBcol.get(i).getColumnfunalias()+"] AS NVARCHAR(MAX)) + '\",' + '";
            }
            dbs.add(new DBColumn(DBcol.get(i).getColumnname()));
        }

        result += res;
        result += "}' FROM ["+TableName+"] "+ DBcolres +" FOR XML PATH(''), TYPE  ).value('.', 'varchar(max)'),1,1,'' ) + ']' as best_result;";

        ArrayList<DBColRAWReturn> returnlist = new ArrayList<>();
        returnlist.add(new DBColRAWReturn(result,dbs));

        return returnlist;
    }

}
