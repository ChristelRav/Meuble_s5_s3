/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package confection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import outil.DbConnect;
import outil.General;
import java.sql.Time;

/**
 *
 * @author njaka
 */
public class Style {
    int idStyle;
    String style;
    Time tempsFabrication;;
/*---------------------------------------------------------GETTERS-----------------------------------------------------*/     
    public int getIdStyle() {
        return idStyle;
    }

    public String getStyle() {
        return style;
    }

    public Time getTempsFabrication() {
        return tempsFabrication;
    }
/*---------------------------------------------------------SETTERS-----------------------------------------------------*/     
    public void setIdStyle(int idStyle) {
        this.idStyle = idStyle;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public void setTempsFabrication(Time tempsFabrication) {
        this.tempsFabrication = tempsFabrication;
    }
/*---------------------------------------------------------CONSTRUCTEURS-----------------------------------------------------*/  
    public Style() {}

    public Style(String style, Time tempsFabrication) {
         this.setStyle(style);
        this.setTempsFabrication(tempsFabrication);
    }
    
    public Style(int idStyle, String style, Time tempsFabrication) {
        this.setIdStyle(idStyle);
        this.setStyle(style);
        this.setTempsFabrication(tempsFabrication);
    }
/*---------------------------------------------------------FONCTIONS-----------------------------------------------------*/         
    public static Object[] selectAll()throws Exception{
        String requete="select * from Style;";
        Object[] result=General.takeObjects(Class.forName("confection.Style"),requete);
        return result;
    }
     public Style insert(Connection c) throws Exception {
    if (c == null) {
        c = new DbConnect().getConnect();
    }
    Style pan = new Style();
    try (Statement stmt = c.createStatement()) {
        stmt.executeUpdate("INSERT INTO style (style,tempsfabrication) VALUES ('"+this.getStyle()+"','"+this.getTempsFabrication() +"')", Statement.RETURN_GENERATED_KEYS);
        try (ResultSet rs = stmt.getGeneratedKeys()) {
            if (rs.next()) pan = new Style(rs.getInt(1),rs.getString(2), rs.getTime(3));
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {c.close();}
    return pan;
    }
}
