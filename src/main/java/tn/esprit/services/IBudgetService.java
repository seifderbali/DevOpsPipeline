
package tn.esprit.services;


import tn.esprit.entities.Budget;
import java.util.List;

public interface IBudgetService {

    List<Budget> retreiveAllBudgetInvestissement();
    List<Budget> retreiveAllBudgetMaintenance();

    Budget addBudgetInvestissement(Budget b);
    Budget addBudgetIMaintenance(Budget b);

    void deleteBudget(long id);
    Budget updateBudget(Budget b);
    Budget retrieveBudget(long id);
    List<Budget> searchBudgetInvestissement(String keyword);
    List<Budget> searchBudgetMaintenance(String keyword);

    Budget findByContrat(long id);

    List<Budget> findByEntiteMain(long id);
    List<Budget> findByEntiteInv(long id);


    List<Budget> retreiveAllBudgetInvestissementSortByDate();
    List<Budget> retreiveAllBudgetInvestissementSortByCoutEtudeServ();
    List<Budget> retreiveAllBudgetInvestissementSortByCoutLogiciel();
    List<Budget> retreiveAllBudgetInvestissementSortByCoutMateriel();

    List<Budget> retreiveAllBudgetMaintenanceSortByDate();
    List<Budget> retreiveAllBudgetMaintenanceSortByCoutEtudeServ();
    List<Budget> retreiveAllBudgetMaintenanceSortByCoutLogiciel();
    List<Budget> retreiveAllBudgetMaintenanceSortByCoutMateriel();

}


