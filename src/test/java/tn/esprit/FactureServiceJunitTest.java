package tn.esprit;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.entities.Facture;
import tn.esprit.services.FactureService;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FactureServiceJunitTest {
        @Autowired
        FactureService factureService;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    Date date = sdf.parse("12-02-2023");
    Facture f1 = new Facture(11L,"11111",date,date,date,date,date,date,date,date,date,date,date,1L);
    Facture f2 = new Facture(51L,"55111",date,date,date,date,date,date,date,date,date,date,date,1L);

    public FactureServiceJunitTest() throws ParseException {
    }

    @Test
        @Order(1)
        public void testaddFacture() {
            Facture FactureAdded =  factureService.addFacture(f1);
            Assertions.assertEquals(FactureAdded.getId(), FactureAdded.getId());
        }

        @Test
        @Order(2)
        public void testRetrieveAllFactures() {
            List<Facture> listFactures = factureService.retreiveAllFacture();
            Assertions.assertEquals(listFactures.size(), listFactures.size());
        }

        @Order(3)
        @Test
        public void testRetrieveFacture() {
            Facture FactureRetrieved = factureService.retrieveFacture(1L);
            Assertions.assertEquals(1L, FactureRetrieved.getId().longValue());
        }

        @Test

        @Order(4)
        public void testModifyFacture()   {

            Facture FactureUpdated  = factureService.updateFacture(f2);
            Assertions.assertEquals(f2.getId(), FactureUpdated.getId());
        }

        @Test

        @Order(5)
        public void testDeleteFacture() {

            factureService.deleteFacture(11L);
            Assertions.assertEquals(null,factureService.retrieveFacture(11L).getId());


        }
    }



