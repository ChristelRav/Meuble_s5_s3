/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package confection;

import java.sql.Date;
import outil.*;
/**
 *
 * @author njaka
 */
public class MeubleConfectionne {
    int idMeubleConfectionne,idMeuble;
    double quantite,quantiteMvt,prixUnitaire;
    Date dateConfection;
    //getters
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
    //setters

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
    public static Object[] selectAll()throws Exception
    {
        String requete="select * from MeubleConfectionne;";
        Object[] result=General.takeObjects(Class.forName("confection.MeubleConfectionne"),requete);
        return result;
    }
    
}
