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
public class MiseEnVente {
    int idMiseEnVente,idMeuble;
    double quantiteVente;
    Date dateVente;
    //getters
     public int getIdMiseEnVente() {
        return idMiseEnVente;
    }

    /*public int getIdMeuble() {
        return idMeuble;
    }*/

    public double getQuantiteVente() {
        return quantiteVente;
    }

    public Date getDateVente() {
        return dateVente;
    }
    //setters

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
    
    public static Object[] selectAll()throws Exception
        {
            String requete="select * from MiseEnVente;";
            Object[] result=General.takeObjects(Class.forName("confection.MiseEnVente"),requete);
            return result;
        }
   
    
}
