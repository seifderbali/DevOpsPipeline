package tn.esprit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.entities.DateValidation;
import tn.esprit.services.IDateValidationService;

import java.util.List;

@RestController
@RequestMapping("/DateValidation")
@CrossOrigin(origins = {"*","http://localhost:4200/"})

public class DateValidationController {

    @Autowired
    IDateValidationService Ds;




    @PostMapping("/addDateValidation")
    void add(@RequestBody DateValidation d)
    {

        Ds.addDateValidation(d);
    }

    @PutMapping("/updateDateValidation")
    void update(@RequestBody DateValidation d)
    {
        Ds.updateValidation(d);
    }
    @DeleteMapping("/deleteDateValidation/{id}")
    void delete(@PathVariable("id") int id)
    {
        Ds.deleteDateValidation(id);
    }
    @GetMapping("/displayDateValidation")
    List<DateValidation> display()
    {
        return Ds.retreiveAllDateValidation();
    }
    @GetMapping("/find/{id}")
    DateValidation find(@PathVariable("id") int id)
    {
        return Ds.retrieveValidation(id);
    }

}
