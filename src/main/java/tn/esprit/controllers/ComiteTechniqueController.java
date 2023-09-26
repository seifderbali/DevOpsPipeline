package tn.esprit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.entities.ComiteTechnique;
import tn.esprit.services.IBudgetService;
import tn.esprit.services.IComiteTechniqueService;
import tn.esprit.services.IDateValidationService;
import tn.esprit.services.IProjetInvestissmentService;

import java.util.List;

@RestController
@RequestMapping("/ComiteTechnique")
@CrossOrigin(origins = {"*","http://localhost:4200/"})

public class ComiteTechniqueController {

    @Autowired
    IComiteTechniqueService Cs;
    @Autowired
    IDateValidationService Ds;
    @Autowired
    IBudgetService Bs;


    @PostMapping("/addComiteTechnique/{idd}/{idp}")
    void add(@RequestBody ComiteTechnique c, @PathVariable("idd") int idd, @PathVariable("idp") int idp)
    {
        c.setDateValidation(Ds.retrieveValidation(idd));
        c.setBudget(Bs.retrieveBudget(idp));
        Cs.addComiteTechnique(c);
    }

    @PutMapping("/updateComiteTechnique")
    void update(@RequestBody ComiteTechnique c)
    {
        Cs.updateComiteTechnique(c);
    }
    @DeleteMapping("/deleteComiteTechnique/{id}")
    void delete(@PathVariable("id") int id)
    {
        Cs.deleteComiteTechnique(id);
    }
    @GetMapping("/displayComiteTechnique")
    List<ComiteTechnique> display()
    {
        return Cs.retreiveAllComiteTechnique();
    }
    @GetMapping("/displayComiteTechniqueInvestissement")
    List<ComiteTechnique> displayInv()
    {
        return Cs.retreiveAllComiteTechniqueInv();
    }
    @GetMapping("/displayComiteTechniqueMaintenance")
    List<ComiteTechnique> displayMain()
    {
        return Cs.retreiveAllComiteTechniqueMain();
    }
    @GetMapping("/find/{id}")
    ComiteTechnique find(@PathVariable("id") int id)
    {
        return Cs.retrieveComiteTechnique(id);
    }

    @GetMapping("/search/{keyword}")
    List<ComiteTechnique> search(@PathVariable("keyword") String keyword)
    {
        return Cs.searchComiteTechnique(keyword);
    }
    @GetMapping("/searchInv/{keyword}")
    List<ComiteTechnique> searchInv(@PathVariable("keyword") String keyword)
    {
        return Cs.searchComiteTechniqueInv(keyword);
    }    @GetMapping("/searchMain/{keyword}")
    List<ComiteTechnique> searchMain(@PathVariable("keyword") String keyword)
    {
        return Cs.searchComiteTechniqueMain(keyword);
    }
}
