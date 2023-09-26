package tn.esprit.services;


import com.google.zxing.WriterException;
import tn.esprit.entities.Fournisseur;

import java.io.IOException;
import java.util.List;

public interface IFournisseurService {

    List<Fournisseur> retreiveAllFournisseur();
    Fournisseur addFournisseur(Fournisseur f);
    void deleteFournisseur(long id);
    Fournisseur updateFournisseur(Fournisseur f);
    Fournisseur retrieveFournisseur(long id);
    List<Fournisseur> searchFournisseur(String keyword);
    Fournisseur findByContrat(long id);
    String findBudget(long id);
    void generateQRCodeImage(String text,int id) throws WriterException, IOException;
    String toStringg(long id);

}

