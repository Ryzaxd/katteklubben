package UIController;

import klasser.Kat;
import klasser.Medlem;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import repository.KatRepository;
import repository.MedlemRepository;

import java.util.ArrayList;

@Controller
public class KatController {

    private final KatRepository katRepository;
    private final MedlemRepository medlemRepository;

    public KatController(KatRepository katRepository, MedlemRepository medlemRepository) {
        this.katRepository = katRepository;
        this.medlemRepository = medlemRepository;
    }

    @GetMapping("/")
    public String showLoginForm(Model model) {
        model.addAttribute("medlem", new Medlem());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Medlem medlem) {
        Medlem foundMedlem = medlemRepository.findByEmail(medlem.getEmail());
        if (foundMedlem != null && foundMedlem.getPassword().equals(medlem.getPassword())) {
            return "redirect:/tilføj-kat";
        } else {
            return "login-error";
        }
    }

    @GetMapping("/tilføj-kat")
    public String showAddCatForm(Model model) {
        model.addAttribute("kat", new Kat());
        return "tilføj-kat";
    }

    @PostMapping("/tilføj-kat")
    public String addCat(Kat kat) {
        System.out.println("Navn: " + kat.getKnavn() + ", Alder: " + kat.getKalder() + ", Køn: " + kat.getKoen());
        katRepository.save(kat);
        return "redirect:/kat";
    }

    @GetMapping("/kat")
    public String showCats(Model model) {
        model.addAttribute("kat", katRepository.findAll());
        return "kat";
    }

    public ArrayList<Kat> getAllCatsForUser(int logged_medlem_id) {
        return getAllCatsForUser(logged_medlem_id);
    }
}
