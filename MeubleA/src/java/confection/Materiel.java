/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 *//*
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
public class Materiel {
    int idMateriel;
    String materiel;
    String unite;
    double qp;
    /*---------------------------------------------------------GETTERS---------------------------------------------------------*/
    public int getIdMateriel() {
        return idMateriel;
    }

    public String getMateriel() {
        return materiel;
    }

    public String getUnite() {
        return unite;
    }
    public double getQp() {return qp;}

    /*---------------------------------------------------------GETTERS---------------------------------------------------------*/
    public void setIdMateriel(int idMateriel) {
        this.idMateriel = idMateriel;
    }

    public void setMateriel(String materiel) {
        this.materiel = materiel;
    }

    public void setUnite(String unite) {
        this.unite = unite;
    }

    public void setQp(double qp) {this.qp = qp; }

    /*---------------------------------------------------------CONSTRUCTEURS-----------------------------------------------------*/
    public Materiel() {}
    public Materiel(String materiel, String unite) {
        this.setMateriel(materiel);
        this.setUnite(unite);
    }
    public Materiel(int idMateriel, String materiel, String unite) {
        this.setIdMateriel(idMateriel);
        this.setMateriel(materiel);
        this.setUnite(unite);
    }

    public Materiel( String materiel, String unite, double qp) {
        this.setMateriel(materiel);
        this.setUnite(unite);
        this.setQp(qp);
    }

    public Materiel(int idMateriel, String materiel, String unite, double qp) {
        this.setIdMateriel(idMateriel);
        this.setMateriel(materiel);
        this.setUnite(unite);
        this.setQp(qp);
    }

    /*---------------------------------------------------------FONCTIONS---------------------------------------------------------*/
    public static Object[] selectAll()throws Exception{
        String requete="select * from Materiel;";
        Object[] result=General.takeObjects(Class.forName("confection.Materiel"),requete);
        return result;
    }
    public  List<Materiel> listAll(Connection c)throws Exception{
        try {
            if (c == null) {
                c = new DbConnect().getConnect();
            }
            List<Materiel> listP = new ArrayList<Materiel>();
            Statement stmt = c.createStatement();
            String req = "select * from Materiel";
            ResultSet rs = stmt.executeQuery(req);
            while(rs.next() ){
                listP.add(new Materiel(rs.getInt(1), rs.getString(2),rs.getString(3)));
            }
            return listP;
        } catch (Exception e) {e.printStackTrace();
        } finally {c.close();}
        return null;
    }
    public  List<Materiel> list_MeubleC(Connection c)throws Exception{
        try {
            if (c == null) {
                c = new DbConnect().getConnect();
            }
            List<Materiel> listP = new ArrayList<Materiel>();
            Statement stmt = c.createStatement();
            String req = "SELECT me.meuble,m.unite,cm.quantiteUtilisee\n" +
                    "FROM confectionMeuble cm \n" +
                    "JOIN materiel m ON m.idMateriel = cm.idMateriel\n" +
                    "JOIN meuble me ON cm.idMeuble = me.idMeuble\n" +
                    "WHERE m.idMateriel="+this.getIdMateriel();
            ResultSet rs = stmt.executeQuery(req);
            while(rs.next() ){
                Materiel mat = new Materiel();
                listP.add(new Materiel(rs.getString(1), rs.getString(2),rs.getDouble(3)));
            }
            return listP;
        } catch (Exception e) {e.printStackTrace();
        } finally {c.close();}
        return null;
    }
    public  List<Materiel> listBy_Style(Connection c,Style s)throws Exception{
        try {
            if (c == null) {
                c = new DbConnect().getConnect();
            }
            List<Materiel> listP = new ArrayList<Materiel>();
            Statement stmt = c.createStatement();
            String req = "SELECT m.idMateriel,m.materiel,m.unite,sm.quantiteEnplus\n" +
                    "FROM stylemateriel sm \n" +
                    "JOIN materiel m ON m.idMateriel = sm.idMateriel\n" +
                    "JOIN style s ON s.idStyle = sm.idStyle\n" +
                    "WHERE s.idStyle ="+s.getIdStyle();
            ResultSet rs = stmt.executeQuery(req);
            while(rs.next() ){
                listP.add(new Materiel(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getDouble(4)));
            }
            return listP;
        } catch (Exception e) {e.printStackTrace();
        } finally {c.close();}
        return null;
    }
    public Materiel insert(Connection c) throws Exception {
        if (c == null) {
            c = new DbConnect().getConnect();
        }
        Materiel pan = new Materiel();
        try (Statement stmt = c.createStatement()) {
            stmt.executeUpdate("INSERT INTO materiel (materiel,unite) VALUES ('" + this.getMateriel()+"','"+this.getUnite() + "')", Statement.RETURN_GENERATED_KEYS);
            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) pan = new Materiel(rs.getInt(1), rs.getString(2),rs.getString(3));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {c.close();}
        return pan;
    }


}

