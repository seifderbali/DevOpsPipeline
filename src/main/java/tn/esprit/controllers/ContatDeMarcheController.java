package tn.esprit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.entities.ContatDeMarche;
import tn.esprit.services.*;

import java.util.List;

@RestController
@RequestMapping("/ContatDeMarche")
@CrossOrigin(origins = {"*","http://localhost:4200/"})

public class ContatDeMarcheController {

    @Autowired
    IContatDeMarcheService Cs;

    @Autowired
    IBudgetService Bs;

    @Autowired
    IFournisseurService Fs;


    @PostMapping("/addContatDeMarche/{idb}/{idf}")
    void add(@RequestBody ContatDeMarche c, @PathVariable("idb") long idb, @PathVariable("idf") long idf)
    {
        c.setBudget(Bs.retrieveBudget(idb));
        c.setFournisseur(Fs.retrieveFournisseur(idf));
        Cs.addContatDeMarche(c);
    }
    @PostMapping("/addContatDeMarcheMaintenance/{idb}/{idf}")
    void addContratMaintenance(@RequestBody ContatDeMarche c, @PathVariable("idb") long idb, @PathVariable("idf") long idf)
    {
        c.setBudget(Bs.retrieveBudget(idb));
        c.setFournisseur(Fs.retrieveFournisseur(idf));
        Cs.addContatDeMarche(c);
    }

    @PutMapping("/updateContatDeMarche")
    void update(@RequestBody ContatDeMarche c)
    {
        Cs.updateContatDeMarche(c);
    }
    @DeleteMapping("/deleteContatDeMarche/{id}")
    void delete(@PathVariable("id") int id)
    {
        Cs.deleteContatDeMarche(id);
    }
    @GetMapping("/displayContatDeMarche")
    List<ContatDeMarche> display()
    {
        return Cs.retreiveAllContatDeMarche();
    }
    @GetMapping("/displayContatDeMarcheMaintenance")
    List<ContatDeMarche> displayMaintenance()
    {
        return Cs.retreiveAllContatDeMarcheMaintenance();
    }
    @GetMapping("/find/{id}")
    ContatDeMarche find(@PathVariable("id") int id)
    {
        return Cs.retrieveContatDeMarche(id);
    }

    @GetMapping("/search/{keyword}")
    List<ContatDeMarche> search(@PathVariable("keyword") String keyword)
    {
        return Cs.searchContatDeMarche(keyword);
    }    @GetMapping("/searchInv/{keyword}")
    List<ContatDeMarche> searchInv(@PathVariable("keyword") String keyword)
    {
        return Cs.searchContatDeMarcheInv(keyword);
    }    @GetMapping("/searchMain/{keyword}")
    List<ContatDeMarche> searchMain(@PathVariable("keyword") String keyword)
    {
        return Cs.searchContatDeMarcheMain(keyword);
    }
    @GetMapping("/findByBudget/{id}")
    List<ContatDeMarche> findByBudget(@PathVariable("id") long id)
    {
        return Cs.findBudget(id);
    }
    @GetMapping("/findByFournisseur/{id}")
    List<ContatDeMarche> findByFournisseur(@PathVariable("id") long id)
    {
        return Cs.findFournisseur(id);
    }

    @GetMapping("/findContrats")
    List<ContatDeMarche> findContrats()
    {
        return Cs.findContras();
    }

}
