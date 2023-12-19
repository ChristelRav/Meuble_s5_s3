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
    //gettters

    public int getIdStyleMateriel() {
        return idStyleMateriel;
    }

    public int getIdStyle() {
        return idStyle;
    }

    public int getIdMateriel() {
        return idMateriel;
    }
    //setters

    public void setIdStyleMateriel(int idStyleMateriel) {
        this.idStyleMateriel = idStyleMateriel;
    }

    public void setIdStyle(int idStyle) {
        this.idStyle = idStyle;
    }

    public void setIdMateriel(int idMateriel) {
        this.idMateriel = idMateriel;
    }
    //constructor
    public StyleMateriel(){}

    public StyleMateriel(int idStyle, int idMateriel) {
        this.setIdStyle(idStyle);
        this.setIdMateriel(idMateriel);
    }
    //fonctions
    public static Object[] selectAll()throws Exception
    {
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
        stmt.executeUpdate("INSERT INTO styleMateriel (idStyle,idMateriel) VALUES ("+this.getIdStyle()+",'"+this.getIdMateriel()+"')", Statement.RETURN_GENERATED_KEYS);
        try (ResultSet rs = stmt.getGeneratedKeys()) {
            if (rs.next()) pan = new StyleMateriel(rs.getInt(1),rs.getInt(2));
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {c.close();}
    return pan;
    }
}
