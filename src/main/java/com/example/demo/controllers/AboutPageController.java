package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutPageController {

    @GetMapping("/about")
    public String aboutPage() {
        return "about"; // Assuming you have a Thymeleaf template named "about.html" for the About page
    }

    @GetMapping("/")
    public String redirectToMainScreen() {
        return "redirect:/mainscreen";
    }
}
