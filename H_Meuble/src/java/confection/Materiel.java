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
public class Materiel {
    int idMateriel;
    String materiel;
    String unite;
    //getters
    public int getIdMateriel() {
        return idMateriel;
    }

    public String getMateriel() {
        return materiel;
    }

    public String getUnite() {
        return unite;
    }
    //setters

    public void setIdMateriel(int idMateriel) {
        this.idMateriel = idMateriel;
    }

    public void setMateriel(String materiel) {
        this.materiel = materiel;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }
    public static Object[] selectAll()throws Exception
    {
        String requete="select * from Materiel;";
        Object[] result=General.takeObjects(Class.forName("confection.Materiel"),requete);
        return result;
    }
    
    
}
