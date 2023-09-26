package tn.esprit;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.entities.Budget;
import tn.esprit.entities.ContatDeMarche;
import tn.esprit.entities.Fournisseur;
import tn.esprit.services.ContatDeMarcheService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ContratDeMarcheJunitTest {

    @Autowired
    ContatDeMarcheService contatDeMarcheService;

    Budget budget =new Budget();
    Fournisseur fournisseur =new Fournisseur();
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    Date date = sdf.parse("12-02-2023");


    ContatDeMarche c1 = new ContatDeMarche(11L,"2102","statutProjet","axeDemande","10000","30002","1234","21-02-2023","observation",date,date,date,1L,budget,fournisseur);
    ContatDeMarche c2 = new ContatDeMarche(51L,"2102","statutProjet","axeDemande","10000","30002","1234","21-02-2023","observation",date,date,date,1L,budget,fournisseur);

    public ContratDeMarcheJunitTest() throws ParseException {
    }

    @Test
    @Order(1)
    public void testaddContatDeMarche() {
        ContatDeMarche ContatDeMarcheAdded =  contatDeMarcheService.addContatDeMarche(c1);
        Assertions.assertEquals(ContatDeMarcheAdded.getId(), ContatDeMarcheAdded.getId());
    }

    @Test
    @Order(2)
    public void testRetrieveAllContatDeMarches() {
        List<ContatDeMarche> listContatDeMarches = contatDeMarcheService.retreiveAllContatDeMarche();
        Assertions.assertEquals(listContatDeMarches.size(), listContatDeMarches.size());
    }

    @Order(3)
    @Test
    public void testRetrieveContatDeMarche() {
        ContatDeMarche ContatDeMarcheRetrieved = contatDeMarcheService.retrieveContatDeMarche(1L);
        Assertions.assertEquals(1L, ContatDeMarcheRetrieved.getId().longValue());
    }

    @Test

    @Order(4)
    public void testModifyContatDeMarche()   {

        ContatDeMarche ContatDeMarcheUpdated  = contatDeMarcheService.updateContatDeMarche(c2);
        Assertions.assertEquals(c2.getId(), ContatDeMarcheUpdated.getId());
    }

    @Test

    @Order(5)
    public void testDeleteContatDeMarche() {

        contatDeMarcheService.deleteContatDeMarche(11L);
        Assertions.assertEquals(null,contatDeMarcheService.retrieveContatDeMarche(11L).getId());


    }
}



