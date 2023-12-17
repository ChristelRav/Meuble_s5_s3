/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package confection;

import outil.*;

/**
 *
 * @author njaka
 */
public class Meuble {
    int idMeuble,idSousCategorie,idStyle;
    //getters
    public int getIdMeuble() {
        return idMeuble;
    }

    public int getIdSousCategorie() {
        return idSousCategorie;
    }

    public int getIdStyle() {
        return idStyle;
    }
    //setters

    public void setIdMeuble(int idMeuble) {
        this.idMeuble = idMeuble;
    }

    public void setIdSousCategorie(int idSousCategorie) {
        this.idSousCategorie = idSousCategorie;
    }

    public void setIdStyle(int idStyle) {
        this.idStyle = idStyle;
    }
    public static Object[] selectAll()throws Exception
    {
        String requete="select * from Meuble;";
        Object[] result=General.takeObjects(Class.forName("confection.Meuble"),requete);
        return result;
    }
    
    
}
