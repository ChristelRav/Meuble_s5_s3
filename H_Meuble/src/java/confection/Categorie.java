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
public class Categorie {
    int idCategorie;
    String categorie;

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    public static Object[] selectAll()throws Exception
    {
        String requete="select * from Categorie;";
        Object[] result=General.takeObjects(Class.forName("confection.Categorie"),requete);
        return result;
    }
    
}
