package tn.esprit;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.entities.Fournisseur;
import tn.esprit.services.FournisseurService;


import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class FournisseurServiceJunitTest {
        @Autowired
        FournisseurService fournisseurServicer;
    Fournisseur f1 = new Fournisseur(11L,"1111","name","immatFiscal","contact","mail","siteWeb","tel",1L);
    Fournisseur f2 = new Fournisseur(51L,"5511","name","immatFiscal","contact","mail","siteWeb","tel",1L);

        @Test
        @Order(1)
        public void testaddFournisseur() {
            Fournisseur FournisseurAdded =  fournisseurServicer.addFournisseur(f1);
            Assertions.assertEquals(FournisseurAdded.getId(), FournisseurAdded.getId());
        }

        @Test
        @Order(2)
        public void testRetrieveAllFournisseurs() {
            List<Fournisseur> listFournisseurs = fournisseurServicer.retreiveAllFournisseur();
            Assertions.assertEquals(listFournisseurs.size(), listFournisseurs.size());
        }

        @Order(3)
        @Test
        public void testRetrieveFournisseur() {
            Fournisseur FournisseurRetrieved = fournisseurServicer.retrieveFournisseur(1L);
            Assertions.assertEquals(1L, FournisseurRetrieved.getId().longValue());
        }

        @Test

        @Order(4)
        public void testModifyFournisseur()   {

            Fournisseur FournisseurUpdated  = fournisseurServicer.updateFournisseur(f2);
            Assertions.assertEquals(f2.getId(), FournisseurUpdated.getId());
        }

        @Test

        @Order(5)
        public void testDeleteFournisseur() {

            fournisseurServicer.deleteFournisseur(11L);
            Assertions.assertEquals(null,fournisseurServicer.retrieveFournisseur(11L).getId());


        }
    }



