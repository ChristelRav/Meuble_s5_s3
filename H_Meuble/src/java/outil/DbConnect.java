/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package outil;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author njaka
 */
public class DbConnect {
    Connection connect;
    //Getters
    public Connection getConnect() {
        return connect;
    }
    //Setters
    public void setConnect(Connection connect) {
        this.connect = connect;
    }

    public DbConnect(){
        Connection c = null;
        try {
            Class.forName("org.postgresql.Driver");
            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/meuble","postgres", "postgres");
            setConnect(c);
        } 
        
        catch (Exception e) {
            e.printStackTrace();
            System.err.println(e.getClass().getName()+": "+e.getMessage());
        }

    }
}
