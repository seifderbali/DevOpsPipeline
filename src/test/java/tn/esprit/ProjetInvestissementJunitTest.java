package tn.esprit;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.entities.Budget;
import tn.esprit.entities.ProjetInvestissment;
import tn.esprit.services.ProjetInvestissmentService;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProjetInvestissementJunitTest {

    @Autowired
    ProjetInvestissmentService projetInvestissmentService;
    Budget budget = new Budget();
    ProjetInvestissment p1 = new ProjetInvestissment(11L,"11","intituleProjet","descriptionSomaire","categorie","classification","natureBesoin","type",100,1000,1L,budget);
    ProjetInvestissment p2 = new ProjetInvestissment(55L,"22","intituleProjet","descriptionSomaire","categorie","classification","natureBesoin","type",222,2222,1L,budget);


    @Test
    @Order(1)
    public void testaddProjet() {
        ProjetInvestissment projettAdded =  projetInvestissmentService.addProjetInvestissmentr(p1);
        Assertions.assertEquals(projettAdded.getCodeProjet(), projettAdded.getCodeProjet());
    }

    @Test
    @Order(2)
    public void testRetrieveAllProjets() {
        List<ProjetInvestissment> listProjets = projetInvestissmentService.retreiveAllProjetInvestissment();
        Assertions.assertEquals(listProjets.size(), listProjets.size());
    }

    @Order(3)
    @Test
    public void testRetrieveProjet() {
        ProjetInvestissment projettRetrieved = projetInvestissmentService.retrieveProjetInvestissment(1L);
        Assertions.assertEquals(1L, projettRetrieved.getId().longValue());
    }

    @Test

    @Order(4)
    public void testModifyProjet()   {

        ProjetInvestissment projetUpdated  = projetInvestissmentService.updateProjetInvestissment(p2);
        Assertions.assertEquals(p2.getCodeProjet(), projetUpdated.getCodeProjet());
    }

    @Test

    @Order(5)
    public void testDeleteProjet() {

        projetInvestissmentService.deleteProjetInvestissment(11L);
        Assertions.assertEquals(null,projetInvestissmentService.retrieveProjetInvestissment(11L).getId());


    }
}

