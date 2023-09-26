package tn.esprit.services;


import tn.esprit.entities.ContatDeMarche;

import java.util.List;

public interface IContatDeMarcheService {

    List<ContatDeMarche> retreiveAllContatDeMarche();
    List<ContatDeMarche> retreiveAllContatDeMarcheMaintenance();

    ContatDeMarche addContatDeMarche(ContatDeMarche c);
    void deleteContatDeMarche(long id);
    ContatDeMarche updateContatDeMarche(ContatDeMarche c);
    ContatDeMarche retrieveContatDeMarche(long id);
    List<ContatDeMarche> searchContatDeMarche(String keyword);
    List<ContatDeMarche> searchContatDeMarcheInv(String keyword);
    List<ContatDeMarche> searchContatDeMarcheMain(String keyword);
    List<ContatDeMarche> findBudget(long id );
    List<ContatDeMarche> findFournisseur(long id );
    List<ContatDeMarche> findContras();

}
