package fr.isima.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/game")
public class GameOfLifeController {

    @GetMapping
    public ModelAndView game() {
        return new ModelAndView("gameoflife");
    }
}
