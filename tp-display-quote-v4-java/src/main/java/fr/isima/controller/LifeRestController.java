package fr.isima.controller;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

import fr.isima.business.Life;
import fr.isima.business.ManageLife;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lifing")
public class LifeRestController {

    public Life life;


    @GetMapping("{generationNumber}")
    public Life lifing(@PathVariable Integer generationNumber) throws IOException {
        life = new Life();
        life.createNewWorld();
       //life.nextGeneration();
        //life.nextGeneration();
        ManageLife.generation(life,generationNumber);
        return life;

    }
}