/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package confection;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import outil.*;

/**
 *
 * @author njaka
 */
public class Meuble {
      int idMeuble,idSousCategorie,idStyle;
    String meuble;
    double prix;
/*---------------------------------------------------------GETTERS-----------------------------------------------------*/   
    public int getIdMeuble() {
        return idMeuble;
    }

    public int getIdSousCategorie() {
        return idSousCategorie;
    }

    public int getIdStyle() {
        return idStyle;
    }
    public String getMeuble() {
        return meuble;
    }
    public double getPrix()
    {
    return prix;
    }
/*---------------------------------------------------------SETTERS-----------------------------------------------------*/   
    public void setIdMeuble(int idMeuble) {
        this.idMeuble = idMeuble;
    }

    public void setIdSousCategorie(int idSousCategorie) {
        this.idSousCategorie = idSousCategorie;
    }

    public void setIdStyle(int idStyle) {
        this.idStyle = idStyle;
    }
    public void setMeuble(String meuble) {
        this.meuble = meuble;
    }
    public void setPrix(double prix)
    {
        this.prix=prix;
    }
/*---------------------------------------------------------CONSTRUCTEURS-----------------------------------------------------*/   
    public Meuble() {}

    public Meuble(int idSousCategorie, int idStyle,String meuble) {
        this.setIdSousCategorie(idSousCategorie);
        this.setIdStyle(idStyle);
        this.setMeuble(meuble);
    }
    
    public Meuble(int idMeuble, int idSousCategorie, int idStyle,String meuble) {
        this.setIdMeuble(idMeuble);
        this.setIdSousCategorie(idSousCategorie);
        this.setIdStyle(idStyle);
        this.setMeuble(meuble);
    }  
    public Meuble(String meuble,double prix)
    {
        this.setMeuble(meuble);
        this.setPrix(prix);
    }
/*---------------------------------------------------------FONCTIONS-----------------------------------------------------*/       
    public static Object[] selectAll()throws Exception
    {
        String requete="select * from Meuble;";
        Object[] result=General.takeObjects(Class.forName("confection.Meuble"),requete);
        return result;
    }
    public Meuble insert(Connection c) throws Exception {
    if (c == null) {
        c = new DbConnect().getConnect();
    }
    Meuble pan = new Meuble();
    try (Statement stmt = c.createStatement()) {
        stmt.executeUpdate("INSERT INTO meuble (idSousCategorie, idStyle, meuble) VALUES (" + this.getIdSousCategorie() + "," + this.getIdStyle() + ",'" + this.getMeuble() + "')", Statement.RETURN_GENERATED_KEYS);
        try (ResultSet rs = stmt.getGeneratedKeys()) {
            if (rs.next()) pan = new Meuble(rs.getInt(1),rs.getInt(2), rs.getInt(3),rs.getString(4));
        }
    } catch (Exception e) {
        e.printStackTrace();
    } finally {c.close();}
    return pan;
    }
    public  List<Meuble> list_MeubleAll(Connection c,int id)throws Exception{
        try {
            if (c == null) {
                c = new DbConnect().getConnect();
            }
            List<Meuble> listP = new ArrayList<Meuble>();
            Statement stmt = c.createStatement();
            String req = "SELECT m.meuble, SUM(cm.quantiteutilisee * mat.pu) as prix\n" +
                         "FROM meuble m\n" +
                         "JOIN confectionmeuble cm ON cm.idMeuble = m.idMeuble\n" +
                         "JOIN materiel mat ON mat.idMateriel = cm.idMateriel\n" +
                         "JOIN souscategorie sc ON sc. idsouscategorie = m. idsouscategorie \n" +
                         "where sc.idcategorie ="+ id +"\n" +
                         "GROUP BY m.meuble";
            ResultSet rs = stmt.executeQuery(req);
            while(rs.next() ){
                Materiel mat = new Materiel();
                listP.add(new Meuble(rs.getString(1), rs.getDouble(2)));
            }
            return listP;
        } catch (Exception e) {e.printStackTrace();
        } finally {c.close();}
        return null;
    
}
    public List<Meuble> listMeuble_Prix(Connection c )throws Exception{
         try {
            if (c == null) {
                c = new DbConnect().getConnect();
            }
            List<Meuble> listP = new ArrayList<Meuble>();
            Statement stmt = c.createStatement();
            String req = "SELECT * from get_prix";
            ResultSet rs = stmt.executeQuery(req);
            while(rs.next() ){
                Materiel mat = new Materiel();
                listP.add(new Meuble(rs.getString(1), rs.getDouble(2)));
            }
            return listP;
        } catch (Exception e) {e.printStackTrace();
        } finally {c.close();}
        return null;
    }
    
    public List<Meuble> list_Meuble(List<Meuble> list, double max,double min)throws Exception{
        List<Meuble> listP = new ArrayList<Meuble>();
        for(int i=0;i<list.size();i++)
        {   
            Meuble m=(Meuble)list.get(i);
            if(m.getPrix()<=max)
            {
                if(m.getPrix()>=min)
                {
                    listP.add(m);
                }
            }
        }
        return listP;
    }
    
}
