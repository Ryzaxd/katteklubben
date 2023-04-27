package com.example.demoIgen;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MedlemController {
    private final MedlemRepository medlemRepository;

    public MedlemController(MedlemRepository medlemRepository) {
        this.medlemRepository = medlemRepository;
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        model.addAttribute("medlem", new Medlem());
        return "login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute Medlem medlem) {
        if (medlemRepository.findByEmailAndPassword(medlem.getEmail(), medlem.getPassword()) != null) {
            return "redirect:/add-cat";
        } else {
            return "login-error";
        }
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("medlem", new Medlem());
        return "register";
    }

    @PostMapping("/register")
    public String register(@ModelAttribute Medlem medlem, RedirectAttributes redirectAttributes) {
        if (medlemRepository.findByEmail(medlem.getEmail()) == null) {
            medlemRepository.save(medlem);
            redirectAttributes.addFlashAttribute("successMessage", "Your account has been created successfully. Please log in.");
            return "redirect:/login";
        } else {
            redirectAttributes.addFlashAttribute("errorMessage", "An account with that email address already exists. Please try again.");
            return "redirect:/register";
        }
    }
}
