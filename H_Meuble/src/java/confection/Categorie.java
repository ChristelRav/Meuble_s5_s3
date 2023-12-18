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
 * @author ravmi
 */
public class Categorie {
    int idCategorie;
    String categorie;
/*---------------------------------------------------------GETTERS---------------------------------------------------------*/   
    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }
/*---------------------------------------------------------SETTERS---------------------------------------------------------*/   
    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
/*--------------------------------------------------CONSTRUCTEURS---------------------------------------------------------*/    
    public Categorie() {}
    public Categorie(String categorie) {
       this.setCategorie(categorie);
    }
    public Categorie(int idCategorie, String categorie) {
        this.setIdCategorie(idCategorie);
        this.setCategorie(categorie);
    }/*--------------------------------------------------FONCTIONS---------------------------------------------------------*/  
    
    public static Object[] selectAll()throws Exception{
        String requete="select * from Categorie;";
        Object[] result=General.takeObjects(Class.forName("confection.Categorie"),requete);
        return result;
    }
    public Categorie insert(Connection c) throws Exception {
    if (c == null) {
        c = new DbConnect().getConnect();
    }
    Categorie pan = new Categorie();
    try (Statement stmt = c.createStatement()) {
        stmt.executeUpdate("INSERT INTO categorie (categorie) VALUES (" + this.getCategorie() + ")", Statement.RETURN_GENERATED_KEYS);
        try (ResultSet rs = stmt.getGeneratedKeys()) {
            if (rs.next()) pan = new Categorie(rs.getInt(1), rs.getString(2));
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {c.close();}
    return pan;
    }

    
}
