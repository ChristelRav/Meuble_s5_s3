/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package confection;
import java.sql.Time;
import outil.*;
/**
 *
 * @author ravmi
 */
public class SousCategorie {
    int idSousCategorie,idCategorie;
    String sousCategorie;
    double longueur,largeur,plus;
    Time tempsFabrication;    
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
    public Time getTempsFabrication() {
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
    public void setTempsFabrication(Time tempsFabrication) {
        this.tempsFabrication = tempsFabrication;
    }
/*---------------------------------------------------------CONSTRUCTEURS-----------------------------------------------------*/  
    public SousCategorie() {}

    public SousCategorie(int idCategorie, String sousCategorie, double longueur, double largeur, double plus, Time tempsFabrication) {
         this.setIdCategorie(idCategorie);
        this.setSousCategorie(sousCategorie);
        this.setLongueur(longueur);
        this.setLargeur(largeur);
        this.setPlus(plus);
        this.setTempsFabrication(tempsFabrication);
    }
    
    public SousCategorie(int idSousCategorie, int idCategorie, String sousCategorie, double longueur, double largeur, double plus, Time tempsFabrication) {
        this.setIdSousCategorie(idSousCategorie);
        this.setIdCategorie(idCategorie);
        this.setSousCategorie(sousCategorie);
        this.setLongueur(longueur);
        this.setLargeur(largeur);
        this.setPlus(plus);
        this.setTempsFabrication(tempsFabrication);
    }    
/*---------------------------------------------------------FONCTIONS-----------------------------------------------------*/      
    public static Object[] selectAll()throws Exception {
        String requete="select * from SousCategorie;";
        Object[] result=General.takeObjects(Class.forName("confection.SousCategorie"),requete);
        return result;
    }
     public  Object[] getOne()throws Exception{
        String requete="select * from SousCategorie where idcategorie = "+this.getIdCategorie()+";";
        Object[] result=General.takeObjects(Class.forName("confection.SousCategorie"),requete);
        return result;
    }

    
}
