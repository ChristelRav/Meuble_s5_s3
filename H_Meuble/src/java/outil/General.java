/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package outil;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;
import outil.DbConnect;

/**
 *
 * @author njaka
 */
public class General {
    static Object takeObject(Class<?> objClass,ResultSet angalana) throws Exception{
        Object averina=objClass.newInstance();
        Field[] fields=objClass.getDeclaredFields();
        for(int i=0;i<fields.length;i++){
            Object settena=null;
            System.out.println(fields[i].getType());
            if(fields[i].getType()==int.class){
                settena=angalana.getInt(fields[i].getName().toLowerCase());
            }
            else if(fields[i].getType()==double.class){
                settena=angalana.getDouble(fields[i].getName().toLowerCase());
            }
            else if(fields[i].getType()==String.class){
                settena=angalana.getString(fields[i].getName().toLowerCase());
            }
            else if(fields[i].getType()==Class.forName("java.sql.Date")){
                settena=angalana.getDate(fields[i].getName().toLowerCase());
            }
            else if(fields[i].getType()==Class.forName("java.sql.Time")){
                settena=angalana.getTime(fields[i].getName().toLowerCase());
            }
            else{
                settena=takeObject(fields[i].getType(),angalana);
            }
            String functionName="set"+firstLetterUppercase(fields[i].getName());
            Method set=objClass.getMethod(functionName,fields[i].getType());
            set.invoke(averina,settena);
        }
        return averina;
    }

    static String firstLetterUppercase(String toModif){
        return toModif.substring(0,1).toUpperCase()+toModif.substring(1);
    }
    public static Object[] takeObjects(Class<?> objClass,ResultSet angalana) throws Exception{
        Vector<Object> toReturn=new Vector<Object>();

        while(angalana.next()){
            toReturn.addElement(takeObject(objClass, angalana));
        }

        return toReturn.toArray();
    }

    public static Object[] takeObjects(Class<?> objClass, String requete) throws Exception{
        Connection connect=new DbConnect().getConnect();
        ResultSet angalana=connect.createStatement().executeQuery(requete);
        Object[] result=takeObjects(objClass,angalana);
        connect.close();
        return result;
    }
    
}
