package tn.esprit.services;


import tn.esprit.entities.Facture;

import java.util.List;

public interface IFactureService {

    List<Facture> retreiveAllFacture();
    Facture addFacture(Facture f);
    void deleteFacture(long id);
    Facture updateFacture(Facture f);
    Facture retrieveFacture(long id);
}

