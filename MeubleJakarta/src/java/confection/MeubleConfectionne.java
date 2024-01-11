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
public class MeubleConfectionne {
    int idMeubleConfectionne,idMeuble;
    double quantite,quantiteMvt,prixUnitaire;
    Date dateConfection;
/*---------------------------------------------------------GETTERS-----------------------------------------------------*/   
    public int getIdMeubleConfectionne() {
        return idMeubleConfectionne;
    }

    public int getIdMeuble() {
        return idMeuble;
    }

    public double getQuantite() {
        return quantite;
    }

    public double getQuantiteMvt() {
        return quantiteMvt;
    }

    public double getPrixUnitaire() {
        return prixUnitaire;
    }

    public Date getDateConfection() {
        return dateConfection;
    }
/*---------------------------------------------------------SETTERS-----------------------------------------------------*/   
    public void setIdMeubleConfectionne(int idMeubleConfectionne) {
        this.idMeubleConfectionne = idMeubleConfectionne;
    }

    public void setIdMeuble(int idMeuble) {
        this.idMeuble = idMeuble;
    }

    public void setQuantite(double quantite) {
        this.quantite = quantite;
    }

    public void setQuantiteMvt(double quantiteMvt) {
        this.quantiteMvt = quantiteMvt;
    }

    public void setPrixUnitaire(double prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public void setDateConfection(Date dateConfection) {
        this.dateConfection = dateConfection;
    }
/*---------------------------------------------------------CONSTRUCTEURS-----------------------------------------------------*/   
    public MeubleConfectionne() {}
    public MeubleConfectionne(int idMeuble, double quantite, double quantiteMvt, double prixUnitaire, Date dateConfection) {
        this.setIdMeuble(idMeuble);
        this.setQuantite(quantite);
        this.setQuantiteMvt(quantiteMvt);
        this.setPrixUnitaire(prixUnitaire);
        this.setDateConfection(dateConfection);
    }
    public MeubleConfectionne(int idMeubleConfectionne, int idMeuble, double quantite, double quantiteMvt, double prixUnitaire, Date dateConfection) {
        this.setIdMeubleConfectionne(idMeubleConfectionne);
        this.setIdMeuble(idMeuble);
        this.setQuantite(quantite);
        this.setQuantiteMvt(quantiteMvt);
        this.setPrixUnitaire(prixUnitaire);
        this.setDateConfection(dateConfection);
    }
/*---------------------------------------------------------FONCTIONS-----------------------------------------------------*/       
    public static Object[] selectAll()throws Exception
    {
        String requete="select * from MeubleConfectionne;";
        Object[] result=General.takeObjects(Class.forName("confection.MeubleConfectionne"),requete);
        return result;
    }
    public MeubleConfectionne insert(Connection c) throws Exception {
    if (c == null) {
        c = new DbConnect().getConnect();
    }
    MeubleConfectionne pan = new MeubleConfectionne();
    try (Statement stmt = c.createStatement()) {
        stmt.executeUpdate("INSERT INTO meubleConfectionne (idMeuble,quantite,quantiteMvt,prixUnitaire,dateConfection) VALUES ("+this.getIdMeuble()+", "+this.getQuantite()+", "+this.getQuantiteMvt()+", "+ this.getPrixUnitaire()+",'"+this.getDateConfection() + "')", Statement.RETURN_GENERATED_KEYS);
        try (ResultSet rs = stmt.getGeneratedKeys()) {
            if (rs.next()) pan = new MeubleConfectionne(rs.getInt(1),rs.getInt(2), rs.getDouble(3), rs.getDouble(4),rs.getDouble(5),rs.getDate(6));
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {c.close();}
    return pan;
    }
    
}
