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
public class ConfectionMeuble {
    int idConfectionMeuble,idMeuble,idMateriel;
    double quantiteUtilisee;
/*---------------------------------------------------------GETTERS---------------------------------------------------------*/   
    public int getIdConfectionMeuble() {
        return idConfectionMeuble;
    }

    public int getIdMeuble() {
        return idMeuble;
    }

    public int getIdMateriel() {
        return idMateriel;
    }

    public double getQuantiteUtilisee() {
        return quantiteUtilisee;
    }
/*---------------------------------------------------------SETTERS---------------------------------------------------------*/   
    public void setIdConfectionMeuble(int idConfectionMeuble) {
        this.idConfectionMeuble = idConfectionMeuble;
    }

    public void setIdMeuble(int idMeuble) {
        this.idMeuble = idMeuble;
    }

    public void setIdMateriel(int idMateriel) {
        this.idMateriel = idMateriel;
    }

    public void setQuantiteUtilisee(double quantiteUtilisee) {
        this.quantiteUtilisee = quantiteUtilisee;
    }
/*--------------------------------------------------CONSTRUCTEURS---------------------------------------------------------*/  
    public ConfectionMeuble() {}
    public ConfectionMeuble(int idMeuble, int idMateriel, double quantiteUtilisee) {
        this.setIdMeuble(idMeuble);
        this.setIdMateriel(idMateriel);
        this.setQuantiteUtilisee(quantiteUtilisee);
    }
    public ConfectionMeuble(int idConfectionMeuble, int idMeuble, int idMateriel, double quantiteUtilisee) {
        this.setIdConfectionMeuble(idConfectionMeuble);
        this.setIdMeuble(idMeuble);
        this.setIdMateriel(idMateriel);
        this.setQuantiteUtilisee(quantiteUtilisee);
    }
/*---------------------------------------------------------FONCTIONS---------------------------------------------------------*/      
    public static Object[] selectAll()throws Exception
    {
        String requete="select * from ConfectionMeuble;";
        Object[] result=General.takeObjects(Class.forName("confection.ConfectionMeuble"),requete);
        return result;
    }
     public ConfectionMeuble insert(Connection c) throws Exception {
    if (c == null) {
        c = new DbConnect().getConnect();
    }
    ConfectionMeuble pan = new ConfectionMeuble();
    try (Statement stmt = c.createStatement()) {
        stmt.executeUpdate("INSERT INTO ConfectionMeuble (idMeuble,idMateriel,quantiteUtilisee) VALUES (" + this.getIdMeuble()+","+this.getIdMateriel()+","+this.getQuantiteUtilisee()+ ")", Statement.RETURN_GENERATED_KEYS);
        try (ResultSet rs = stmt.getGeneratedKeys()) {
            if (rs.next()) pan = new ConfectionMeuble(rs.getInt(1), rs.getInt(2),rs.getDouble(3));
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {c.close();}
    return pan;
    }
    
    
            
}
