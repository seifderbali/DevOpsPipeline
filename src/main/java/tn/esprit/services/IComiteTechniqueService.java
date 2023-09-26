package tn.esprit.services;

import tn.esprit.entities.ComiteTechnique;

import java.util.List;

public interface IComiteTechniqueService {

    List<ComiteTechnique> retreiveAllComiteTechnique();
    List<ComiteTechnique> retreiveAllComiteTechniqueInv();
    List<ComiteTechnique> retreiveAllComiteTechniqueMain();

    ComiteTechnique addComiteTechnique(ComiteTechnique c);
    void deleteComiteTechnique(long id);
    ComiteTechnique updateComiteTechnique(ComiteTechnique c);
    ComiteTechnique retrieveComiteTechnique(long id);
    List<ComiteTechnique> searchComiteTechnique(String keyword);
    List<ComiteTechnique> searchComiteTechniqueInv(String keyword);
    List<ComiteTechnique> searchComiteTechniqueMain(String keyword);
}


