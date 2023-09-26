package tn.esprit;

import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.entities.Budget;
import tn.esprit.entities.EntiteSI;
import tn.esprit.services.BudgetService;

import java.util.List;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BudgetServiceJunitTest {

    @Autowired
    BudgetService budgetService;
    EntiteSI rntite =new EntiteSI();
    Budget b1 = new Budget(11L,"libelle","21-02-2023","1222","10000","30002","1234","23000","100","1000","type",1L,rntite);
    Budget b2 = new Budget(51L,"libelle","21-02-2023","1222","10000","30002","1234","23000","100","1000","type",1L,rntite);

    @Test
    @Order(1)
    public void testaddBudget() {
        Budget BudgetAdded =  budgetService.addBudgetInvestissement(b1);
        Assertions.assertEquals(BudgetAdded.getId(), BudgetAdded.getId());
    }

    @Test
    @Order(2)
    public void testRetrieveAllBudgets() {
        List<Budget> listBudgets = budgetService.retreiveAllBudgetInvestissement();
        Assertions.assertEquals(listBudgets.size(), listBudgets.size());
    }

    @Order(3)
    @Test
    public void testRetrieveBudget() {
        Budget BudgettRetrieved = budgetService.retrieveBudget(1L);
        Assertions.assertEquals(1L, BudgettRetrieved.getId().longValue());
    }

    @Test

    @Order(4)
    public void testModifyBudget()   {

        Budget BudgetUpdated  = budgetService.updateBudget(b2);
        Assertions.assertEquals(b2.getId(), BudgetUpdated.getId());
    }

    @Test

    @Order(5)
    public void testDeleteBudget() {

        budgetService.deleteBudget(11L);
        Assertions.assertEquals(null,budgetService.retrieveBudget(11L).getId());


    }
}


