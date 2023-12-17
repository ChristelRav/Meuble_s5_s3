/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package confection;

import outil.General;

/**
 *
 * @author njaka
 */
public class Style {
    int idStyle;
    String style;
    double tempsFabrication;
    //getters
    public int getIdStyle() {
        return idStyle;
    }

    public String getStyle() {
        return style;
    }

    public double getTempsFabrication() {
        return tempsFabrication;
    }
    //setters

    public void setIdStyle(int idStyle) {
        this.idStyle = idStyle;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public void setTempsFabrication(double tempsFabrication) {
        this.tempsFabrication = tempsFabrication;
    }
    
    public static Object[] selectAll()throws Exception
    {
        String requete="select * from Style;";
        Object[] result=General.takeObjects(Class.forName("confection.Style"),requete);
        return result;
    }
}
