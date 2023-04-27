package UIController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OpretController {

    @GetMapping("/Opret bruger")
    public String showOpretPage() {
        return "Opret bruger";
    }

    @PostMapping("/Opret bruger")
    public String OpretBruger(@RequestParam String fnavn,@RequestParam String enavn, @RequestParam String email, @RequestParam String password, Model model) {

        if (email.isEmpty() || password.isEmpty()) {
            model.addAttribute("error", "Invalid email, name or password");
            return "Opret bruger";
        } else {
            model.addAttribute("fnavn", fnavn);
            model.addAttribute("enavn", enavn);
            model.addAttribute("email", email);
            model.addAttribute("password", password);
            return "redirect:/Forside";
        }
    }

    @GetMapping("/Forside")
    public String showForsidePage() {
        return "Forside";
    }
}

