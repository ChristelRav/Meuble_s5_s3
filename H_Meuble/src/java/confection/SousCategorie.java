/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package confection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.logging.Logger;
import outil.*;
/**
 *
 * @author ravmi
 */
public class SousCategorie {

    int idSousCategorie,idCategorie;
    String sousCategorie;
    double longueur,largeur,plus,tempsFabrication;

    public int getIdSousCategorie() {
        return idSousCategorie;
    }

    public void setIdSousCategorie(int idSousCategorie) {
        this.idSousCategorie = idSousCategorie;
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getSousCategorie() {
        return sousCategorie;
    }

    public void setSousCategorie(String sousCategorie) {
        this.sousCategorie = sousCategorie;
    }

    public double getLongueur() {
        return longueur;
    }

    public void setLongueur(double longueur) {
        this.longueur = longueur;
    }

    public double getLargeur() {
        return largeur;
    }

    public void setLargeur(double largeur) {
        this.largeur = largeur;
    }

    public double getPlus() {
        return plus;
    }

    public void setPlus(double plus) {
        this.plus = plus;
    }

    public double getTempsFabrication() {
        return tempsFabrication;
    }

    public void setTempsFabrication(double tempsFabrication) {
        this.tempsFabrication = tempsFabrication;
    }

    public SousCategorie(int idCategorie, String sousCategorie, double longueur, double largeur, double plus, double tempsFabrication) {
        this.setIdCategorie(idCategorie);
        this.setSousCategorie(sousCategorie);
        this.setLongueur(longueur);
        this.setLargeur(largeur);
        this.setPlus(plus);
        this.setTempsFabrication(tempsFabrication);
    }
    public SousCategorie(){ }
    
    //fonctions
    public static Object[] selectAll()throws Exception
    {
        String requete="select * from SousCategorie;";
        Object[] result=General.takeObjects(Class.forName("confection.SousCategorie"),requete);
        return result;
    }
    public SousCategorie insert(Connection c) throws Exception {
    if (c == null) {
        c = new DbConnect().getConnect();
    }
    SousCategorie pan = new SousCategorie();
    try (Statement stmt = c.createStatement()) {
        stmt.executeUpdate("INSERT INTO sousCategorie (idCategorie,sousCategorie,longueur,largeur, plus ,tempsFabrication) VALUES ("+this.getIdCategorie()+",'"+this.getSousCategorie()+"','"+this.getLongueur() + "','"+this.getLargeur()+"','"+this.getPlus()+"','"+this.getTempsFabrication()+");", Statement.RETURN_GENERATED_KEYS);
        try (ResultSet rs = stmt.getGeneratedKeys()) {
            if (rs.next()) pan = new SousCategorie(rs.getInt(1),rs.getString(2),rs.getDouble(3), rs.getDouble(4), rs.getDouble(5),rs.getDouble(6));
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {c.close();}
    return pan;
    }
    

    
}
