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
public class StyleMateriel {
    int idStyleMateriel,idStyle,idMateriel;
    double quantiteEnplus;
/*---------------------------------------------------------GETTERS-----------------------------------------------------*/   
    public int getIdStyleMateriel() {
        return idStyleMateriel;
    }

    public int getIdStyle() {
        return idStyle;
    }

    public int getIdMateriel() {
        return idMateriel;
    }
    public double getQuantiteEnplus() {
        return quantiteEnplus;
    }
/*---------------------------------------------------------SETTERS-----------------------------------------------------*/   
    public void setIdStyleMateriel(int idStyleMateriel) {
        this.idStyleMateriel = idStyleMateriel;
    }

    public void setIdStyle(int idStyle) {
        this.idStyle = idStyle;
    }

    public void setIdMateriel(int idMateriel) {
        this.idMateriel = idMateriel;
    }
    public void setQuantiteEnplus(double quantiteEnplus) {
        this.quantiteEnplus = quantiteEnplus;
    }
/*---------------------------------------------------------CONSTRUCTEURS-----------------------------------------------------*/    
    public StyleMateriel() {}

    public StyleMateriel(int idStyle, int idMateriel,double quantiteEnplus) {
        this.setIdStyle(idStyle);
        this.setIdMateriel(idMateriel);
          this.setQuantiteEnplus(quantiteEnplus);
    }
    public StyleMateriel(int idStyleMateriel, int idStyle, int idMateriel,double quantiteEnplus) {
        this.setIdStyleMateriel(idStyleMateriel);
        this.setIdStyle(idStyle);
        this.setIdMateriel(idMateriel);
        this.setQuantiteEnplus(quantiteEnplus);
    }   
/*---------------------------------------------------------FONCTIONS-----------------------------------------------------*/       
    public static Object[] selectAll()throws Exception{
        String requete="select * from StyleMateriel;";
        Object[] result=General.takeObjects(Class.forName("confection.StyleMateriel"),requete);
        return result;
    }
    public StyleMateriel insert(Connection c) throws Exception {
    if (c == null) {
        c = new DbConnect().getConnect();
    }
    StyleMateriel pan = new StyleMateriel();
    try (Statement stmt = c.createStatement()) {
        stmt.executeUpdate("INSERT INTO styleMateriel (idstyle,idMateriel,quantiteEnplus) VALUES ("+this.getIdStyle()+","+this.getIdMateriel()+","+this.getQuantiteEnplus() +")", Statement.RETURN_GENERATED_KEYS);
        try (ResultSet rs = stmt.getGeneratedKeys()) {
            if (rs.next()) pan = new StyleMateriel(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getDouble(4));
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {c.close();}
    return pan;
    }
}
