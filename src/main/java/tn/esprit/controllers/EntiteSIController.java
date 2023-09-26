package tn.esprit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.entities.EntiteSI;
import tn.esprit.services.IEntiteSIService;

import java.util.List;

@RestController
@RequestMapping("/EntiteSI")
@CrossOrigin(origins = {"*","http://localhost:4200/"})
public class EntiteSIController {
    @Autowired
    IEntiteSIService Es;


    @PostMapping("/addentiteSI")
    void add(@RequestBody EntiteSI e)
    {
        Es.addEntiteSI(e);
    }

    @PutMapping("/updateentiteSI")
    void update(@RequestBody EntiteSI e)
    {
        Es.updateEntiteSI(e);
    }
    @DeleteMapping("/deleteentiteSI/{id}")
    void delete(@PathVariable("id") int id)
    {
        Es.deleteEntiteSI(id);
    }
    @GetMapping("/displayentiteSIs")
    List<EntiteSI> display()
    {
        return Es.retreiveAllEntiteSI();
    }
    @GetMapping("/find/{id}")
    EntiteSI find(@PathVariable("id") int id)
    {
        return Es.retrieveEntiteSI(id);
    }
    @GetMapping("/findByName/{name}")
    EntiteSI findbyname(@PathVariable("name") String name)
    {
        return Es.findByName(name);
    }

    @GetMapping("/search/{keyword}")
    List<EntiteSI> search(@PathVariable("keyword") String keyword)
    {
        return Es.searchEntiteSI(keyword);
    }

    @GetMapping("/findBudget/{id}")
    String findBudget(@PathVariable("id") long id)
    {
        return Es.findBudget(id);
    }
    @GetMapping("/AllBudget")
    String allBudget()
    {
        return Es.allbudget();
    }

}

