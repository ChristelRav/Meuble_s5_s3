/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package confection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import outil.*;

/**
 *
 * @author njaka
 */
public class Meuble {
    int idMeuble,idSousCategorie,idStyle;
    String meuble;
/*---------------------------------------------------------GETTERS-----------------------------------------------------*/   
    public int getIdMeuble() {
        return idMeuble;
    }

    public int getIdSousCategorie() {
        return idSousCategorie;
    }

    public int getIdStyle() {
        return idStyle;
    }
    public String getMeuble() {
        return meuble;
    }
/*---------------------------------------------------------SETTERS-----------------------------------------------------*/   
    public void setIdMeuble(int idMeuble) {
        this.idMeuble = idMeuble;
    }

    public void setIdSousCategorie(int idSousCategorie) {
        this.idSousCategorie = idSousCategorie;
    }

    public void setIdStyle(int idStyle) {
        this.idStyle = idStyle;
    }
    public void setMeuble(String meuble) {
        this.meuble = meuble;
    }
/*---------------------------------------------------------CONSTRUCTEURS-----------------------------------------------------*/   
    public Meuble() {}

    public Meuble(int idSousCategorie, int idStyle,String meuble) {
        this.setIdSousCategorie(idSousCategorie);
        this.setIdStyle(idStyle);
        this.setMeuble(meuble);
    }
    
    public Meuble(int idMeuble, int idSousCategorie, int idStyle,String meuble) {
        this.setIdMeuble(idMeuble);
        this.setIdSousCategorie(idSousCategorie);
        this.setIdStyle(idStyle);
        this.setMeuble(meuble);
    }    
/*---------------------------------------------------------FONCTIONS-----------------------------------------------------*/       
    public static Object[] selectAll()throws Exception
    {
        String requete="select * from Meuble;";
        Object[] result=General.takeObjects(Class.forName("confection.Meuble"),requete);
        return result;
    }
    public Meuble insert(Connection c) throws Exception {
    if (c == null) {
        c = new DbConnect().getConnect();
    }
    Meuble pan = new Meuble();
    try (Statement stmt = c.createStatement()) {
        stmt.executeUpdate("INSERT INTO meuble (idSousCategorie, idStyle, meuble) VALUES (" + this.getIdSousCategorie() + "," + this.getIdStyle() + ",'" + this.getMeuble() + "')", Statement.RETURN_GENERATED_KEYS);
        try (ResultSet rs = stmt.getGeneratedKeys()) {
            if (rs.next()) pan = new Meuble(rs.getInt(1),rs.getInt(2), rs.getInt(3),rs.getString(4));
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {c.close();}
    return pan;
    }
    
    
}
