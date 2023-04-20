package com.example.katteklubben;

import database.Database;
import klasser.Kæledyr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class KatController {

    private Database connector;
    private Connection connection;

    public ArrayList<Kæledyr> slå_alle_medlemmer_og_katte_op() {
        ArrayList<Kæledyr> katList = new ArrayList<>();
        try {
            String sql = "SELECT medlem.mid, medlem.fnavn, medlem.enavn, medlem.email " +
                    ",kæledyr.kid, kæledyr.knavn, kæledyr.koen, kæledyr.kalder " +
                    "FROM medlem INNER JOIN kæledyr ON medlem.mid = kæledyr.kid";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                Kæledyr kat = new Kæledyr();
                kat.setKid(rs.getInt("kid"));
                kat.setKnavn(rs.getString("knavn"));
                kat.setKoen(rs.getString("koen"));
                kat.setKalder(rs.getString("kalder"));

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
