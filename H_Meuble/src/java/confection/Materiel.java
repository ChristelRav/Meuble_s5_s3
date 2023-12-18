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
public class Materiel {
    int idMateriel;
    String materiel;
    String unite;
/*---------------------------------------------------------GETTERS---------------------------------------------------------*/   
    public int getIdMateriel() {
        return idMateriel;
    }

    public String getMateriel() {
        return materiel;
    }

    public String getUnite() {
        return unite;
    }
/*---------------------------------------------------------GETTERS---------------------------------------------------------*/   
    public void setIdMateriel(int idMateriel) {
        this.idMateriel = idMateriel;
    }

    public void setMateriel(String materiel) {
        this.materiel = materiel;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }
/*---------------------------------------------------------CONSTRUCTEURS-----------------------------------------------------*/   
    public Materiel() {}

    public Materiel(String materiel, String unite) {
        this.setMateriel(materiel);
        this.setUnite(unite);
    }
    

    public Materiel(int idMateriel, String materiel, String unite) {
        this.setIdMateriel(idMateriel);
        this.setMateriel(materiel);
        this.setUnite(unite);
    }
        
        
/*---------------------------------------------------------FONCTIONS---------------------------------------------------------*/       
    public static Object[] selectAll()throws Exception{
        String requete="select * from Materiel;";
        Object[] result=General.takeObjects(Class.forName("confection.Materiel"),requete);
        return result;
    }
    public Materiel insert(Connection c) throws Exception {
    if (c == null) {
        c = new DbConnect().getConnect();
    }
    Materiel pan = new Materiel();
    try (Statement stmt = c.createStatement()) {
        stmt.executeUpdate("INSERT INTO Materiel (materiel,unite) VALUES ('" + this.getMateriel()+"','"+this.getUnite() + "')", Statement.RETURN_GENERATED_KEYS);
        try (ResultSet rs = stmt.getGeneratedKeys()) {
            if (rs.next()) pan = new Materiel(rs.getInt(1), rs.getString(2),rs.getString(3));
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {c.close();}
    return pan;
    }
    
    
}
