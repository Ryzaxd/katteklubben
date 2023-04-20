package com.example.demo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class KatController {

    private Database connector;
    private Connection connection;

    public ArrayList<Kat> slå_alle_medlemmer_og_katte_op() {
        ArrayList<Kat> katList = new ArrayList<>();
        try {
            String sql = "SELECT medlem.medlem_id, medlem.medlem_navn, medlem.medlem_alder, medlem.medlem_adresse, medlem.medlem_telefon, " +
                    "kat.kat_id, kat.kat_navn, kat.kat_køn, kat.kat_race " +
                    "FROM medlem INNER JOIN kat ON medlem.medlem_id = kat.medlem_id";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                Kat kat = new Kat();
                kat.setId(rs.getInt("kat_id"));
                kat.setKat_navn(rs.getString("kat_navn"));
                kat.setKat_køn(rs.getString("kat_køn"));
                kat.setKat_race(rs.getString("kat_race"));

                katList.add(kat);
            }

            rs.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return katList;
    }

}
