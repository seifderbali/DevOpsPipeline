package tn.esprit.services;

import tn.esprit.entities.Depense;

import java.util.List;

public interface IDepenseService {

    List<Depense> retreiveAllDepense();

    Depense addDepense(Depense d);
    void deleteDepense(long id);
    Depense updateDepense(Depense c);
    Depense retrieveDepense(long id);
    List<Depense> searchDepense(String keyword);
}
