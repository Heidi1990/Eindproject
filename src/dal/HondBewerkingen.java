/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dal;

import bll.Hond;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

/**
 *
 * @author Heidi
 */
public class HondBewerkingen {

    private static int adopteren;
    private static boolean adop;

    private static final String ConnectionString = "jdbc:mysql://localhost:3307/EindprojectJavaDB?zeroDateTimeBehavior=convertToNull";

    public static void HondToevoegen(Hond hond) {
        if (hond.isAdopteren() == true) {
            adopteren = 1;
        } else {
            adopteren = 0;
        }
        try {
            Connection Con = DriverManager.getConnection(ConnectionString, "root", "usbw");
            Statement state = Con.createStatement();
            state.executeUpdate("INSERT INTO HOND (Naam, Ras, Geslacht, Leeftijd, Beschrijving, Foto, Adopteren) VALUES ('" + hond.getNaam() + "','" + hond.getRas() + "','" + hond.getGeslacht() + "'," + hond.getLeeftijd() + ",'" + hond.getBeschrijving() + "','" + hond.getFoto() + "'," + adopteren + ")");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public static void HondWijzigen(Hond hond) {
        try {
            if (hond.isAdopteren() == true) {
                adopteren = 1;
            } else {
                adopteren = 0;
            }
            Connection Con = DriverManager.getConnection(ConnectionString, "root", "usbw");
            Statement state = Con.createStatement();
            state.executeUpdate("UPDATE HOND SET Naam = '" + hond.getNaam() + "', Ras = '" + hond.getRas() + "', Geslacht = '" + hond.getGeslacht() + "', Leeftijd = " + hond.getLeeftijd() + ", Beschrijving = '" + hond.getBeschrijving() + "', Foto = '" + hond.getFoto() + "', Adopteren = " + adopteren + "WHERE ID = " + hond.getId() + " ");

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    public static void Hondverwijderen(Hond hond) {
        try {
            Connection Con = DriverManager.getConnection(ConnectionString, "root", "usbw");
            Statement state = Con.createStatement();
            state.executeUpdate("DELETE FROM HOND WHERE ID = " + hond.getId());

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());

        }

    }

    public static List<Hond> Hondenlijst() {
        List<Hond> Hondenlijst = new ArrayList<>();
        try {
            Connection Con = DriverManager.getConnection(ConnectionString, "root", "usbw");
            Statement state = Con.createStatement();
            ResultSet result = state.executeQuery("SELECT * FROM HOND ORDER BY Naam");

            while (result.next()) {
                Hond hond = new Hond();
                hond.setId(result.getLong("ID"));
                hond.setNaam(result.getString("Naam"));
                hond.setRas(result.getString("Ras"));
                hond.setGeslacht(result.getString("Geslacht"));
                hond.setLeeftijd(result.getInt("Leeftijd"));
                hond.setBeschrijving(result.getString("Beschrijving"));
                hond.setFoto(result.getString("Foto"));
                if (result.getInt("Adopteren") == 1) {
                    adop = true;
                } else {
                    adop = false;
                }
                hond.setAdopteren(adop);
                Hondenlijst.add(hond);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return Hondenlijst;

    }

}
