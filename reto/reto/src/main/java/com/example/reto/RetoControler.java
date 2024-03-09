package com.example.reto;

import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RetoControler {
    private int prize = 100000;
    private int Num;

    @GetMapping("/guess")
    public String guessForm (Model model) {
        Random random = new Random();
        Num = random.nextInt(10) + 1;
        model.addAttribute("actualValue", "Premio: " + prize);
        return "guess";
    }

    @PostMapping("/guess")
    public String processGuess(int guess, Model model) {
        int numberToGuess = (int) (Math.random() * 10) + 1;
        if (guess == Num) {
            model.addAttribute("message", "¡Felicidades! Has ganado $" + prize);
        } else {
            prize -= 10000;
            if (prize < 0) {
                prize = 0;
            }
            model.addAttribute("message", "Intenta de nuevo. El número era " + numberToGuess + ".");
        }
        model.addAttribute("prize", prize);
        return "guess";
    }

    @PostMapping("/reset")
    public String reset(Model model) {
        prize = 100000;
        model.addAttribute("prize", prize);
        return "redirect:/guess";
    }
}
