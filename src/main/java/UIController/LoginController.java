package UIController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/index")
    public String showLoginPage() {
        return "index";
    }

    @PostMapping("/index")
    public String login(@RequestParam String email, @RequestParam String password, Model model) {

        if (email.isEmpty() || password.isEmpty()) {
            model.addAttribute("error", "Invalid email or password");
            return "index";
        } else {
            return "redirect:/Forside";
        }
    }

    @GetMapping("/Forside")
    public String showForsidePage() {
        return "Forside";
    }

    @GetMapping("/Opret bruger")
    public String showOpretBrugerForm(Model model) {
        return "Opret bruger";
    }

}
