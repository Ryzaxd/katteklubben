package com.example.demo;

import javax.xml.crypto.Data;
import java.sql.*;
import java.util.ArrayList;

public class BrugerController {

    private Database connector;
    private Connection connection;

    public boolean opret_bruger(String bruger_navn, String bruger_email, String bruger_password) {
        try {
            String sql = "INSERT INTO bruger (Bruger_navn, Bruger_email, Bruger_password) VALUES (?,?,?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            statement.setString(1, bruger_navn);
            statement.setString(2,bruger_navn);
            statement.setString(3,bruger_password);

            int rowsInserted = statement.executeUpdate();
            if(rowsInserted > 0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Medlem> slå_alle_medlemmer_op() {

        ArrayList<Medlem> medlemList = new ArrayList<>();

        try {
            String sql = "SELECT * from medlem";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            while(rs.next()) {
                Medlem medlem = new Medlem();
                medlem.setMedlem_id(rs.getInt("medlem_id"));
                medlem.setNavn(rs.getString("medlem_navn"));
                medlem.setEfternavn(rs.getString("medlem_efternavn"));
                medlem.setMedlem_email(rs.getString("medlem_email"));

                medlemList.add(medlem);
            }

            rs.close();
            statement.close();

        } catch (SQLException e) {
            System.out.println("Error: " + e.getMessage());
        }
        return medlemList;
    }
}
