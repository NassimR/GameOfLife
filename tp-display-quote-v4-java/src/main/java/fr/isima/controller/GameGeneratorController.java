package fr.isima.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/gameGenerator")
public class GameGeneratorController {

    @GetMapping
    public ModelAndView gameGenerator() {
        return new ModelAndView("gameGenerator");
    }
}
