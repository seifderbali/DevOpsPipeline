package tn.esprit.services;


import tn.esprit.entities.EntiteSI;

import java.util.List;

public interface IEntiteSIService {
    List<EntiteSI> retreiveAllEntiteSI();
    EntiteSI addEntiteSI(EntiteSI e);
    void deleteEntiteSI(long id);
    EntiteSI updateEntiteSI(EntiteSI e);
    EntiteSI retrieveEntiteSI(long id);
    List<EntiteSI> searchEntiteSI(String keyword);
    EntiteSI findByName(String name);
    String findBudget(long id);
    String allbudget();

}
