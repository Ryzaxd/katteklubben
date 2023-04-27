package com.example.demoIgen;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class CatController {
    private final CatRepository catRepository;
    private final MedlemRepository medlemRepository;

    public CatController(CatRepository catRepository, MedlemRepository medlemRepository) {
        this.catRepository = catRepository;
        this.medlemRepository = medlemRepository;
    }

    @GetMapping("/")
    public String showLoginForm(Model model) {
        model.addAttribute("medlem", new Medlem());
        return "login";
    }

    @PostMapping("/cat-login") // Modified mapping
    public String login(@ModelAttribute Medlem medlem) {
        Medlem foundMedlem = medlemRepository.findByEmail(medlem.getEmail());
        if (foundMedlem != null && foundMedlem.getPassword().equals(medlem.getPassword())) {
            return "redirect:/add-cat";
        } else {
            return "login-error";
        }
    }

    @GetMapping("/add-cat")
    public String showAddCatForm(Model model) {
        model.addAttribute("cat", new Cat());
        return "add-cat";
    }

    @PostMapping("/add-cat")
    public String addCat(Cat cat) {
        System.out.println("Name: " + cat.getName() + ", Age: " + cat.getAge());
        catRepository.save(cat);
        return "redirect:/cats";
    }

    @GetMapping("/cats")
    public String showCats(Model model) {
        model.addAttribute("cats", catRepository.findAll());
        return "cats";
    }
}
