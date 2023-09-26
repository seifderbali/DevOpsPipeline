package tn.esprit;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.entities.DateValidation;
import tn.esprit.services.DateValidationService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class DateValidationJunitTest {

    @Autowired
    DateValidationService dateValidationService;
    SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");

    Date date = sdf.parse("12-02-2023");

    DateValidation d1 = new DateValidation(11L,date,"statutProjet",date,"typeDemande",date,"decisionComiteTechFin",1L);
    DateValidation d2 = new DateValidation(11L,date,"statutProjet",date,"typeDemande",date,"decisionComiteTechFin",1L);

    public DateValidationJunitTest() throws ParseException {
    }

    @Test
    @Order(1)
    public void testaddDateValidation() {
        DateValidation DateValidationAdded =  dateValidationService.addDateValidation(d1);
        Assertions.assertEquals(DateValidationAdded.getId(), DateValidationAdded.getId());
    }

    @Test
    @Order(2)
    public void testRetrieveAllDateValidations() {
        List<DateValidation> listDateValidations = dateValidationService.retreiveAllDateValidation();
        Assertions.assertEquals(listDateValidations.size(), listDateValidations.size());
    }

    @Order(3)
    @Test
    public void testRetrieveDateValidation() {
        DateValidation DateValidationRetrieved = dateValidationService.retrieveValidation(1L);
        Assertions.assertEquals(1L, DateValidationRetrieved.getId().longValue());
    }

    @Test

    @Order(4)
    public void testModifyDateValidation()   {

        DateValidation DateValidationUpdated  = dateValidationService.updateValidation(d2);
        Assertions.assertEquals(d2.getId(), DateValidationUpdated.getId());
    }

    @Test

    @Order(5)
    public void testDeleteDateValidation() {

        dateValidationService.deleteDateValidation(11L);
        Assertions.assertEquals(null,dateValidationService.retrieveValidation(11L).getId());


    }
}



