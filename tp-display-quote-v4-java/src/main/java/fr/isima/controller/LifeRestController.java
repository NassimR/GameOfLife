package fr.isima.controller;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

import fr.isima.business.Life;
import fr.isima.business.ManageLife;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/games/{gameId}/generation", method = RequestMethod.GET)
public class LifeRestController {

    public Life life;

    @GetMapping("{generationNumber}")
    public Life lifing(@PathVariable("gameId") int gameId, @PathVariable Integer generationNumber) throws IOException {
        life = new Life();
        life.createNewWorld("./tp-display-quote-v4-java/src/main/java/fr/isima/files/" + gameId + ".txt");
        ManageLife.generation(life,generationNumber);
        return life;
    }
}