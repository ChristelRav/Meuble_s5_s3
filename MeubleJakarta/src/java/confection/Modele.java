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
public class Modele {
    int idModele , idCategorie;
    String modelecol1,modelecol2,modelecol3,modelecol4;
/*---------------------------------------------------------GETTERS-----------------------------------------------------*/   
    public int getIdModele() {
        return idModele;
    }
    public int getIdCategorie() {
        return idCategorie;
    }
    public String getModelecol1() {
        return modelecol1;
    }
    public String getModelecol2() {
        return modelecol2;
    }
    public String getModelecol3() {
        return modelecol3;
    }
    public String getModelecol4() {
        return modelecol4;
    }
/*---------------------------------------------------------SETTERS-----------------------------------------------------*/   
     public void setIdModele(int idModele) {
        this.idModele = idModele;
    }
     public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }
    public void setModelecol1(String modelecol1) {
        this.modelecol1 = modelecol1;
    }
    public void setModelecol2(String modelecol2) {
        this.modelecol2 = modelecol2;
    }
    public void setModelecol3(String modelecol3) {
        this.modelecol3 = modelecol3;
    }
    public void setModelecol4(String modelecol4) {
        this.modelecol4 = modelecol4;
    }
/*---------------------------------------------------------CONSTRUCTEURS-----------------------------------------------------*/ 
    public Modele() {}
    public Modele(int idCategorie, String modelecol1, String modelecol2, String modelecol3, String modelecol4) {
         this.setIdModele(idModele);
        this.setIdCategorie(idCategorie);
        this.setModelecol1(modelecol1);
        this.setModelecol2(modelecol2);
        this.setModelecol3(modelecol3);
        this.setModelecol4(modelecol4);
    }
    
    public Modele(int idModele, int idCategorie, String modelecol1, String modelecol2, String modelecol3, String modelecol4) {
        this.setIdModele(idModele);
        this.setIdCategorie(idCategorie);
        this.setModelecol1(modelecol1);
        this.setModelecol2(modelecol2);
        this.setModelecol3(modelecol3);
        this.setModelecol4(modelecol4);
    }
/*---------------------------------------------------------FONCTIONS-----------------------------------------------------*/       
    public static Object[] selectAll()throws Exception
    {
        String requete="select * from Modele;";
        Object[] result=General.takeObjects(Class.forName("confection.Modele"),requete);
        return result;
    }
    public Modele insert(Connection c) throws Exception {
    if (c == null) {
        c = new DbConnect().getConnect();
    }
    Modele pan = new Modele();
    try (Statement stmt = c.createStatement()) {
        stmt.executeUpdate("INSERT INTO modele (idCategorie,modelecol1,modelecol2,modelecol3,modelecol4) VALUES ("+this.getIdCategorie()+",'"+this.getModelecol1()+"','"+this.getModelecol2() + "','"+this.getModelecol3()+"','"+this.getModelecol4()+"')", Statement.RETURN_GENERATED_KEYS);
        try (ResultSet rs = stmt.getGeneratedKeys()) {
            if (rs.next()) pan = new Modele(rs.getInt(1),rs.getInt(2),rs.getString(3), rs.getString(4), rs.getString(5),rs.getString(6));
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {c.close();}
    return pan;
    }
    
}
