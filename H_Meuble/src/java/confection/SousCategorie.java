/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package confection;
import outil.*;
/**
 *
 * @author ravmi
 */
public class SousCategorie {
    int idSousCategorie,idCategorie;
    String sousCategorie;
    double longueur,largeur,plus,tempsFabrication;    
/*---------------------------------------------------------GETTERS-----------------------------------------------------*/   
    public int getIdSousCategorie() {
        return idSousCategorie;
    }
    public int getIdCategorie() {
        return idCategorie;
    }
    public String getSousCategorie() {
        return sousCategorie;
    }
      public double getLongueur() {
        return longueur;
    }
          public double getLargeur() {
        return largeur;
    }
              public double getPlus() {
        return plus;
    }
    public double getTempsFabrication() {
        return tempsFabrication;
    }          
/*---------------------------------------------------------SETTERS-----------------------------------------------------*/  
    public void setIdSousCategorie(int idSousCategorie) {
        this.idSousCategorie = idSousCategorie;
    }
    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }
     public void setSousCategorie(String sousCategorie) {
        this.sousCategorie = sousCategorie;
    }
    public void setLongueur(double longueur) {
        this.longueur = longueur;
    }
    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }
    public void setPlus(double plus) {
        this.plus = plus;
    }
    public void setTempsFabrication(double tempsFabrication) {
        this.tempsFabrication = tempsFabrication;
    }
/*---------------------------------------------------------CONSTRUCTEURS-----------------------------------------------------*/  
/*---------------------------------------------------------FONCTIONS-----------------------------------------------------*/      
    public static Object[] selectAll()throws Exception
    {
        String requete="select * from SousCategorie;";
        Object[] result=General.takeObjects(Class.forName("confection.SousCategorie"),requete);
        return result;
    }

    
}
