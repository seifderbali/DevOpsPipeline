package tn.esprit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.entities.DateValidation;
import tn.esprit.entities.Facture;
import tn.esprit.services.IFactureService;

import java.util.List;

@RestController
@RequestMapping("/Facture")
@CrossOrigin(origins = {"*","http://localhost:4200/"})
public class FactureController {

    @Autowired
    IFactureService Fs;

    @PostMapping("/addFacture")
    void add(@RequestBody Facture f)
    {

        Fs.addFacture(f);
    }

    @PutMapping("/updateFacture")
    void update(@RequestBody Facture f)
    {
        Fs.updateFacture(f);
    }
    @DeleteMapping("/deleteFacture/{id}")
    void delete(@PathVariable("id") int id)
    {
        Fs.deleteFacture(id);
    }
    @GetMapping("/displayFactures")
    List<Facture> display()
    {
        return Fs.retreiveAllFacture();
    }
    @GetMapping("/find/{id}")
    Facture find(@PathVariable("id") int id)
    {
        return Fs.retrieveFacture(id);
    }

}
