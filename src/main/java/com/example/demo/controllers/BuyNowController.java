package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BuyNowController {

    @GetMapping("/buyNowFailure")
    public String redirectToMainScreenOnFailure() {
        return "buyNowFailure";
    }

    @GetMapping("/buyNowSuccess")
    public String redirectToMainScreenOnSuccess() {
        return "buyNowSucess";
    }
}
