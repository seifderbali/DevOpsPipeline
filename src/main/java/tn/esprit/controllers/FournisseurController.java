package tn.esprit.controllers;

import com.google.zxing.WriterException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.entities.Fournisseur;
import tn.esprit.services.IFournisseurService;


import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/Fournisseur")
@CrossOrigin(origins = {"*","http://localhost:4200/"})

public class FournisseurController {

    @Autowired
    IFournisseurService Fs;


    @PostMapping("/addFournisseur")
    void add(@RequestBody Fournisseur f)
    {
        Fs.addFournisseur(f);
    }

    @PutMapping("/updateFournisseur")
    void update(@RequestBody Fournisseur f)
    {
        Fs.updateFournisseur(f);
    }
    @DeleteMapping("/deleteFournisseur/{id}")
    void delete(@PathVariable("id") int id)
    {
        Fs.deleteFournisseur(id);
    }
    @GetMapping("/displayFournisseur")
    List<Fournisseur> display()
    {
        return Fs.retreiveAllFournisseur();
    }
    @GetMapping("/find/{id}")
    Fournisseur find(@PathVariable("id") int id)
    {
        return Fs.retrieveFournisseur(id);
    }

    @GetMapping("/search/{keyword}")
    List<Fournisseur> search(@PathVariable("keyword") String keyword)
    {
        return Fs.searchFournisseur(keyword);
    }

    @GetMapping("/findByContrat/{id}")
    Fournisseur findByContrat(@PathVariable("id") int id)
    {
        return Fs.findByContrat(id);
    }

    @GetMapping("/findBudget/{id}")
    String findBudget(@PathVariable("id") int id)
    {
        return Fs.findBudget(id);
    }

    @RequestMapping("/generate/{id}")
    void GenerateQrCode(@PathVariable("id") int id) throws WriterException, IOException
    {

        Fs.generateQRCodeImage(Fs.toStringg(id),id);
    }
}
