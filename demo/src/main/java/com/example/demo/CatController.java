package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CatController {
    private final CatRepository catRepository;

    public CatController(CatRepository catRepository) {
        this.catRepository = catRepository;
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
