package tn.esprit;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.entities.ContatDeMarche;
import tn.esprit.entities.Depense;
import tn.esprit.entities.Facture;
import tn.esprit.services.DepenseService;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DepenseJunitTest {
    @Autowired
    DepenseService depenseService;

    ContatDeMarche contatDeMarche =new ContatDeMarche();
    Facture facture =new Facture();
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    Date date = sdf.parse("12-02-2023");

    Depense d1 = new Depense(11L,date,"objetFacture","111","111","121212","description","statutFacture",1L,contatDeMarche,facture);
    Depense d2 = new Depense(51L,date,"objetFacture","111","111","121212","description","statutFacture",1L,contatDeMarche,facture);

    public DepenseJunitTest() throws ParseException {
    }

    @Test
    @Order(1)
    public void testaddDepense() {
        Depense DepenseAdded =  depenseService.addDepense(d1);
        Assertions.assertEquals(DepenseAdded.getId(), DepenseAdded.getId());
    }

    @Test
    @Order(2)
    public void testRetrieveAllDepenses() {
        List<Depense> listDepenses = depenseService.retreiveAllDepense();
        Assertions.assertEquals(listDepenses.size(), listDepenses.size());
    }

    @Order(3)
    @Test
    public void testRetrieveDepense() {
        Depense DepenseRetrieved = depenseService.retrieveDepense(11L);
        Assertions.assertEquals(11L, DepenseRetrieved.getId());
    }

    @Test

    @Order(4)
    public void testModifyDepense()   {

        Depense DepenseUpdated  = depenseService.updateDepense(d2);
        Assertions.assertEquals(d2.getId(), DepenseUpdated.getId());
    }

    @Test

    @Order(5)
    public void testDeleteDepense() {

        depenseService.deleteDepense(11L);
        Assertions.assertEquals(null,depenseService.retrieveDepense(11L).getId());


    }
}


