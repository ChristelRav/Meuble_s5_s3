/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package confection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.Statement;
import outil.*;
/**
 *
 * @author njaka
 */
public class MiseEnVente {
    int idMiseEnVente,idMeuble;
    double quantiteVente;
    Date dateVente;
/*---------------------------------------------------------GETTERS-----------------------------------------------------*/   
     public int getIdMiseEnVente() {
        return idMiseEnVente;
    }

    public int getIdMeuble() {
        return idMeuble;
    }

    public double getQuantiteVente() {
        return quantiteVente;
    }

    public Date getDateVente() {
        return dateVente;
    }
/*---------------------------------------------------------SETTERS-----------------------------------------------------*/   
    public void setIdMiseEnVente(int idMiseEnVente) {
        this.idMiseEnVente = idMiseEnVente;
    }

    public void setIdMeuble(int idMeuble) {
        this.idMeuble = idMeuble;
    }

    public void setQuantiteVente(double quantiteVente) {
        this.quantiteVente = quantiteVente;
    }

    public void setDateVente(Date dateVente) {
        this.dateVente = dateVente;
    }
/*---------------------------------------------------------CONSTRUCTEURS-----------------------------------------------------*/   
    public MiseEnVente() {}
    public MiseEnVente(int idMeuble, double quantiteVente, Date dateVente) {
        this.setIdMeuble(idMeuble);
        this.setQuantiteVente(quantiteVente);
        this.setDateVente(dateVente);
    }
    public MiseEnVente(int idMiseEnVente, int idMeuble, double quantiteVente, Date dateVente) {
        this.setIdMiseEnVente(idMiseEnVente);
        this.setIdMeuble(idMeuble);
        this.setQuantiteVente(quantiteVente);
        this.setDateVente(dateVente);
    }
/*---------------------------------------------------------FONCTIONS-----------------------------------------------------*/       
    public static Object[] selectAll()throws Exception{
            String requete="select * from MiseEnVente;";
            Object[] result=General.takeObjects(Class.forName("confection.MiseEnVente"),requete);
            return result;
        }
    public MiseEnVente insert(Connection c) throws Exception {
    if (c == null) {
        c = new DbConnect().getConnect();
    }
    MiseEnVente pan = new MiseEnVente();
    try (Statement stmt = c.createStatement()) {
        stmt.executeUpdate("INSERT INTO miseEnVente (idMeuble,quantiteVente,dateVente) VALUES ("+this.getIdMeuble()+", "+this.getQuantiteVente()+",'"+this.getDateVente() + "')", Statement.RETURN_GENERATED_KEYS);
        try (ResultSet rs = stmt.getGeneratedKeys()) {
            if (rs.next()) pan = new MiseEnVente(rs.getInt(1),rs.getInt(2), rs.getDouble(3), rs.getDate(4));
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {c.close();}
    return pan;
    }
   
    
}
