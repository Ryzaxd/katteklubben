package UIController;

import database.Database;
import entiteter.Kæledyr;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

@Controller
public class KatController {

        private final kæledyrRepository kæledyrRepository;

        public KatController(kæledyrRepository kæledyrRepository) {
            this.kæledyrRepository = kæledyrRepository;
        }


    @GetMapping("/add-cat")
        public String showAddCatForm(Model model) {
            model.addAttribute("kæledyr", new Kæledyr());
            return "tilføj-kæledyr";
        }

        @PostMapping("/tilføj-kæledyr")
        public String addCat(Kæledyr kæledyr) {
            System.out.println("Navn: " + kæledyr.getKnavn() + ", Alder: " + kæledyr.getKalder() + ", Køn: " + kæledyr.getKoen());
            kæledyrRepository.save(kæledyr);
            return "redirect:/kæledyr";
        }


        @GetMapping("/kæledyr")
        public String showCats(Model model) {
            model.addAttribute("kæledyr", kæledyrRepository.findAll());
            return "kæledyr";
        }

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

    public ArrayList<Kæledyr> getAllCatsForUser(int mid) {
        ArrayList<Kæledyr> katte_list = new ArrayList<>();

        try {
            PreparedStatement stmt = connection.prepareStatement("SELECT * FROM kæledyr WHERE kid = ?");
            stmt.setInt(1, mid);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()) {
                Kæledyr kat = new Kæledyr();
                kat.setKid(rs.getInt("kid"));
                kat.setKnavn(rs.getString("knavn"));
                kat.setKoen(rs.getString("koen"));
                kat.setBilledePath(rs.getString("katbilledepath"));

                katte_list.add(kat);
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return katte_list;
    }
}
