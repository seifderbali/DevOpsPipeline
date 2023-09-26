package tn.esprit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.entities.ProjetInvestissment;
import tn.esprit.services.IBudgetService;
import tn.esprit.services.IEntiteSIService;
import tn.esprit.services.IProjetInvestissmentService;


import java.util.List;

@RestController
@RequestMapping("/ProjetInvestissment")
@CrossOrigin(origins = {"*","http://localhost:4200/"})

public class ProjetInvestissmentController {
    @Autowired
    IProjetInvestissmentService Ps;
    @Autowired
    IEntiteSIService Es;

    @Autowired
    IBudgetService Bs;

    @PostMapping("/addProjetInvestissment/{idb}")
    void add(@RequestBody ProjetInvestissment p, @PathVariable("idb") int idb)
    {

        p.setBudget(Bs.retrieveBudget(idb));
        Ps.addProjetInvestissmentr(p);
    }

    @PutMapping("/updateProjetInvestissment")
    void update(@RequestBody ProjetInvestissment p)
    {
        Ps.updateProjetInvestissment(p);
    }
    @DeleteMapping("/deleteProjetInvestissment/{id}")
    void delete(@PathVariable("id") int id)
    {
        Ps.deleteProjetInvestissment(id);
    }
    @GetMapping("/displayProjetInvestissment")
    List<ProjetInvestissment> display()
    {
        return Ps.retreiveAllProjetInvestissment();
    }
    @GetMapping("/find/{id}")
    ProjetInvestissment find(@PathVariable("id") int id)
    {
        return Ps.retrieveProjetInvestissment(id);
    }

    @GetMapping("/search/{keyword}")
    List<ProjetInvestissment> search(@PathVariable("keyword") String keyword)
    {
        return Ps.searchProjetInvestissment(keyword);
    }
    /*
       @GetMapping("/findBudget/{id}")
       BudgetInvestissement searchbudget(@PathVariable("id") long id )
       {
           return Ps.findBudget(id);
       }


       @GetMapping("/findByEntite/{id}")
       List<BudgetInvestissement> findByEntite(@PathVariable("id") long id )
       {

           return Ps.findByEntite(id);
       }

     */
    @GetMapping("/findProject/{id}")
    ProjetInvestissment findProject(@PathVariable("id") long id )
    {
        return Ps.findProject(id);
    }



}
