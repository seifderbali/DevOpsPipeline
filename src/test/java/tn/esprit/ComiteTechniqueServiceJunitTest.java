package tn.esprit;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.entities.Budget;
import tn.esprit.entities.ComiteTechnique;
import tn.esprit.entities.DateValidation;
import tn.esprit.services.ComiteTechniqueService;


import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ComiteTechniqueServiceJunitTest {

    @Autowired
    ComiteTechniqueService comiteTechniqueService;
    Budget budget =new Budget();
    DateValidation dateValidation =new DateValidation();
    ComiteTechnique c1 = new ComiteTechnique(11L,"21-02-2023","statutProjet","axeDemande","typeDemande","typeDemande",1L,dateValidation, budget);
    ComiteTechnique c2 = new ComiteTechnique(51L,"21-02-2023","statutProjet","axeDemande","typeDemande","typeDemande",1L,dateValidation, budget);

    @Test
    @Order(1)
    public void testaddComiteTechnique() {
        ComiteTechnique ComiteTechniqueAdded =  comiteTechniqueService.addComiteTechnique(c1);
        Assertions.assertEquals(ComiteTechniqueAdded.getId(), ComiteTechniqueAdded.getId());
    }

    @Test
    @Order(2)
    public void testRetrieveAllComiteTechniques() {
        List<ComiteTechnique> listComiteTechniques = comiteTechniqueService.retreiveAllComiteTechnique();
        Assertions.assertEquals(listComiteTechniques.size(), listComiteTechniques.size());
    }

    @Order(3)
    @Test
    public void testRetrieveComiteTechnique() {
        ComiteTechnique ComiteTechniqueRetrieved = comiteTechniqueService.retrieveComiteTechnique(1L);
        Assertions.assertEquals(1L, ComiteTechniqueRetrieved.getId().longValue());
    }

    @Test

    @Order(4)
    public void testModifyComiteTechnique()   {

        ComiteTechnique ComiteTechniqueUpdated  = comiteTechniqueService.updateComiteTechnique(c2);
        Assertions.assertEquals(c2.getId(), ComiteTechniqueUpdated.getId());
    }

    @Test

    @Order(5)
    public void testDeleteComiteTechnique() {

        comiteTechniqueService.deleteComiteTechnique(11L);
        Assertions.assertEquals(null,comiteTechniqueService.retrieveComiteTechnique(11L).getId());


    }
}



