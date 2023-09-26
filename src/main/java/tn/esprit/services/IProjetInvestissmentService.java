package tn.esprit.services;


import tn.esprit.entities.ProjetInvestissment;

import java.util.List;

public interface IProjetInvestissmentService {
    List<ProjetInvestissment> retreiveAllProjetInvestissment();
    ProjetInvestissment addProjetInvestissmentr(ProjetInvestissment p);
    void deleteProjetInvestissment(long id);
    ProjetInvestissment updateProjetInvestissment(ProjetInvestissment p );
    ProjetInvestissment retrieveProjetInvestissment(long id);
    List<ProjetInvestissment> searchProjetInvestissment(String keyword);

   // Budget findBudget(long id);

  //  List<BudgetInvestissement> findByEntite(long id);
   ProjetInvestissment findProject(long id);

}

