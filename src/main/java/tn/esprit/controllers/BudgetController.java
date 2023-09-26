
package tn.esprit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.entities.Budget;
import tn.esprit.services.IBudgetService;
import tn.esprit.services.IEntiteSIService;
import java.util.List;

@RestController
@RequestMapping("/Budget")
@CrossOrigin(origins = {"*","http://localhost:4200/"})

public class BudgetController {

    @Autowired
    IBudgetService Bs;
    @Autowired
    IEntiteSIService Es;

    @GetMapping("/displayBudgetInvestissements")
    List<Budget> displayBudgetInvestissements()
    {
        return Bs.retreiveAllBudgetInvestissement();
    }
    @GetMapping("/displayBudgetMaintenances")
    List<Budget> displayBudgetMaintenances()
    {
        return Bs.retreiveAllBudgetMaintenance();
    }

    @PostMapping("/addBudgetInvestissement/{id}")
    void addBudgetInvestissement(@RequestBody Budget b, @PathVariable("id") int id)
    {
        b.setEntiteSI(Es.retrieveEntiteSI(id));
        Bs.addBudgetInvestissement(b);
    }
    @PostMapping("/addBudgetMaintenance/{id}")
    void addBudgetMaintenance(@RequestBody Budget b, @PathVariable("id") int id)
    {
        b.setEntiteSI(Es.retrieveEntiteSI(id));
        Bs.addBudgetIMaintenance(b);
    }

    @PutMapping("/updateBudget")
    void update(@RequestBody Budget b)
    {
        Bs.updateBudget(b);
    }
    @DeleteMapping("/deleteBudget/{id}")
    void delete(@PathVariable("id") int id)
    {
        Bs.deleteBudget(id);
    }
    @GetMapping("/find/{id}")
    Budget find(@PathVariable("id") int id)
    {
        return Bs.retrieveBudget(id);
    }

    @GetMapping("/searchBudgetInvestissement/{keyword}")
    List<Budget> searchBudgetInvestissement(@PathVariable("keyword") String keyword)
    {
        return Bs.searchBudgetInvestissement(keyword);
    }
    @GetMapping("/searchBudgetMaintenance/{keyword}")
    List<Budget> searchBudgetMaintenance(@PathVariable("keyword") String keyword)
    {
        return Bs.searchBudgetMaintenance(keyword);
    }


    @GetMapping("/findByContrat/{id}")
    Budget findByContrat(@PathVariable("id") int id)
    {
        return Bs.findByContrat(id);
    }




    @GetMapping("/findByEntiteInv/{id}")
    List<Budget> findByEntiteInv(@PathVariable("id") long id)
    {
        return Bs.findByEntiteInv(id);
    }
    @GetMapping("/findByEntiteMain/{id}")
    List<Budget> findByEntiteMain(@PathVariable("id") long id)
    {
        return Bs.findByEntiteMain(id);
    }

    @GetMapping("/displayBudgetInvestissementsSortByDate")
    List<Budget> displayBudgetInvestissementsSortByDate()
    {
        return Bs.retreiveAllBudgetInvestissementSortByDate();
    }
    @GetMapping("/displayBudgetInvestissementsSortByCoutEtudeServ")
    List<Budget> displayBudgetInvestissementsSortByCoutEtudeServ()
    {
        return Bs.retreiveAllBudgetInvestissementSortByCoutEtudeServ();
    }
    @GetMapping("/displayBudgetInvestissementsSortByCoutLogiciel")
    List<Budget> displayBudgetInvestissementsSortByCoutLogiciel()
    {
        return Bs.retreiveAllBudgetInvestissementSortByCoutLogiciel();
    }
    @GetMapping("/displayBudgetInvestissementsSortByCoutMateriel")
    List<Budget> displayBudgetInvestissementsSortByCoutMateriel()
    {
        return Bs.retreiveAllBudgetInvestissementSortByCoutMateriel();
    }


    @GetMapping("/displayBudgetMaintenancesSortByDate")
    List<Budget> displayBudgetMaintenancesSortByDate()
    {
        return Bs.retreiveAllBudgetMaintenanceSortByDate();
    }
    @GetMapping("/displayBudgetMaintenancesSortByCoutEtudeServ")
    List<Budget> displayBudgetMaintenancesSortByCoutEtudeServ()
    {
        return Bs.retreiveAllBudgetMaintenanceSortByCoutEtudeServ();
    }
    @GetMapping("/displayBudgetMaintenancesSortByCoutLogiciel")
    List<Budget> displayBudgetMaintenancesSortByCoutLogiciel()
    {
        return Bs.retreiveAllBudgetMaintenanceSortByCoutLogiciel();
    }
    @GetMapping("/displayBudgetMaintenancesSortByCoutMateriel")
    List<Budget> displayBudgetMaintenancesSortByCoutMateriel()
    {
        return Bs.retreiveAllBudgetMaintenanceSortByCoutMateriel();
    }
}
