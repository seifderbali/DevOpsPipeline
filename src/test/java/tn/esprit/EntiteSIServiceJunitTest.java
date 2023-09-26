package tn.esprit;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.entities.EntiteSI;
import tn.esprit.services.EntiteSIService;
;

import java.util.List;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EntiteSIServiceJunitTest {


        @Autowired
        EntiteSIService entiteSIService;
    EntiteSI e1 = new EntiteSI(11L,"EntiteSI",1L);
    EntiteSI e2 = new EntiteSI(51L,"EntiteSI",1L);

        @Test
        @Order(1)
        public void testaddEntiteSI() {
            EntiteSI EntiteSIAdded =  entiteSIService.addEntiteSI(e1);
            Assertions.assertEquals(EntiteSIAdded.getId(),EntiteSIAdded.getId());
        }

        @Test
        @Order(2)
        public void testRetrieveAllEntiteSIs() {
            List<EntiteSI> listEntiteSIs = entiteSIService.retreiveAllEntiteSI();
            Assertions.assertEquals(listEntiteSIs.size(), listEntiteSIs.size());
        }

        @Order(3)
        @Test
        public void testRetrieveEntiteSI() {
            EntiteSI EntiteSIRetrieved = entiteSIService.retrieveEntiteSI(1L);
            Assertions.assertEquals(1L, EntiteSIRetrieved.getId().longValue());
        }

        @Test

        @Order(4)
        public void testModifyEntiteSI()   {

            EntiteSI EntiteSIUpdated  = entiteSIService.updateEntiteSI(e2);
            Assertions.assertEquals(e2.getId(), EntiteSIUpdated.getId());
        }

        @Test

        @Order(5)
        public void testDeleteEntiteSI() {

            entiteSIService.deleteEntiteSI(11L);
            Assertions.assertEquals(null,entiteSIService.retrieveEntiteSI(11L).getId());


        }
    }

