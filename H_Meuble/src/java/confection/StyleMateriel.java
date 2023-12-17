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
    
    public static Object[] selectAll()throws Exception
    {
        String requete="select * from StyleMateriel;";
        Object[] result=General.takeObjects(Class.forName("confection.StyleMateriel"),requete);
        return result;
    }
}
