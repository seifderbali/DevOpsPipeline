package tn.esprit.controllers;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import tn.esprit.entities.swear_words;
import tn.esprit.services.SwearService;




@RestController
@RequestMapping("/Swear")
@CrossOrigin(origins = {"*","http://localhost:4200/"})
public class SwearController {

    @Autowired
    SwearService Os;
    @PostMapping("/addswear")
    void add(@RequestBody swear_words f)
    {
        Os.addSwears(f);
    }

    @DeleteMapping("/deleteswear/{id}")
    void delete(@PathVariable("id") int id)
    {
        Os.deleteSwear(id);
    }

    @GetMapping("/displayswear")
    List<swear_words> display()
    {
        return Os.listswears();
    }
    @GetMapping("/swearAction/{ch}")
    int swearAction(@PathVariable("ch") String ch)
    {

        return Os.swearAction(ch);
    }
}
