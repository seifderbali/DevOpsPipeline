
package tn.esprit.services;

        import lombok.extern.slf4j.Slf4j;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;
        import tn.esprit.entities.Budget;
        import tn.esprit.repositories.BudgetRepository;

        import java.util.ArrayList;
        import java.util.List;

@Slf4j
@Service
public class BudgetService implements IBudgetService {

    @Autowired
    BudgetRepository budgetRepository;

    @Override
    public List<Budget> retreiveAllBudgetInvestissement() {
        List<Budget> listBudgets = new ArrayList<Budget>();
        try {
            listBudgets = (List<Budget>) budgetRepository.findAllBudgetInvestissement();
            for(Budget b : listBudgets)
            {
                //   u.setUsers(null);
                log.info("user = "+b);
            }}
        catch(Exception e)
        {
            log.info("error = "+e);
        }

        return listBudgets;
    }

    @Override
    public List<Budget> retreiveAllBudgetMaintenance() {
        List<Budget> listBudgets = new ArrayList<Budget>();
        try {
            listBudgets = (List<Budget>) budgetRepository.findAllBudgetMaintenance();
            for(Budget b : listBudgets)
            {
                //   u.setUsers(null);
                log.info("user = "+b);
            }}
        catch(Exception e)
        {
            log.info("error = "+e);
        }

        return listBudgets;
    }


    @Override
    public Budget addBudgetInvestissement(Budget b) {
        try
        {
            b.setType("Investissement");
            budgetRepository.save(b);
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
        return b;
    }

    @Override
    public Budget addBudgetIMaintenance(Budget b) {
        try
        {
            b.setType("Maintenance");
            budgetRepository.save(b);
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
        return b;
    }

    @Override
    public void deleteBudget(long id) {
        try{
            //	Long idl = Long.parseLong(id);
            budgetRepository.deleteById(id);
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }

    }

    @Override
    public Budget updateBudget(Budget b) {
        try
        {
            budgetRepository.save(b);
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
        return b;
    }

    @Override
    public Budget retrieveBudget(long id) {
        Budget b = new Budget();
        try{
            b = budgetRepository.findById(id).get();
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
        return b ;
    }

    @Override
    public List<Budget> searchBudgetInvestissement(String keyword) {
        List<Budget> listBudgets = new ArrayList<Budget>();
        try {
            listBudgets = (List<Budget>) budgetRepository.searchBudgetInvestissement(keyword);
            for(Budget b : listBudgets)
            {
                log.info("BudgetInvestissement = "+b);
            }}
        catch(Exception e)
        {
            log.info("error = "+e);
        }

        return listBudgets;
    }

    @Override
    public List<Budget> searchBudgetMaintenance(String keyword) {
        List<Budget> listBudgets = new ArrayList<Budget>();
        try {
            listBudgets = (List<Budget>) budgetRepository.searchBudgetMaintenance(keyword);
            for(Budget b : listBudgets)
            {
                log.info("BudgetInvestissement = "+b);
            }}
        catch(Exception e)
        {
            log.info("error = "+e);
        }

        return listBudgets;
    }

    @Override
    public Budget findByContrat(long id) {
        return budgetRepository.findContrat(id);
    }

    @Override
    public List<Budget> findByEntiteMain(long id) {
        List<Budget> listBudgets = new ArrayList<Budget>();
        try {
            listBudgets = (List<Budget>) budgetRepository.findByEntiteMain(id);
            for(Budget b : listBudgets)
            {
                //   u.setUsers(null);
                log.info("user = "+b);
            }}
        catch(Exception e)
        {
            log.info("error = "+e);
        }

        return listBudgets;
    }

    @Override
    public List<Budget> findByEntiteInv(long id) {
        List<Budget> listBudgets = new ArrayList<Budget>();
        try {
            listBudgets = (List<Budget>) budgetRepository.findByEntiteInv(id);
            for(Budget b : listBudgets)
            {
                //   u.setUsers(null);
                log.info("user = "+b);
            }}
        catch(Exception e)
        {
            log.info("error = "+e);
        }

        return listBudgets;
    }

    @Override
    public List<Budget> retreiveAllBudgetInvestissementSortByDate() {
        List<Budget> listBudgets = new ArrayList<Budget>();
        try {
            listBudgets = (List<Budget>) budgetRepository.findAllBudgetInvestissementSortByDate();
            for(Budget b : listBudgets)
            {
                //   u.setUsers(null);
                log.info("user = "+b);
            }}
        catch(Exception e)
        {
            log.info("error = "+e);
        }

        return listBudgets;    }

    @Override
    public List<Budget> retreiveAllBudgetInvestissementSortByCoutEtudeServ() {
        List<Budget> listBudgets = new ArrayList<Budget>();
        try {
            listBudgets = (List<Budget>) budgetRepository.findAllBudgetInvestissementSortByCoutEtudeServ();
            for(Budget b : listBudgets)
            {
                //   u.setUsers(null);
                log.info("user = "+b);
            }}
        catch(Exception e)
        {
            log.info("error = "+e);
        }

        return listBudgets;    }

    @Override
    public List<Budget> retreiveAllBudgetInvestissementSortByCoutLogiciel() {
        List<Budget> listBudgets = new ArrayList<Budget>();
        try {
            listBudgets = (List<Budget>) budgetRepository.findAllBudgetInvestissementSortByCoutLogiciel();
            for(Budget b : listBudgets)
            {
                //   u.setUsers(null);
                log.info("user = "+b);
            }}
        catch(Exception e)
        {
            log.info("error = "+e);
        }

        return listBudgets;    }

    @Override
    public List<Budget> retreiveAllBudgetInvestissementSortByCoutMateriel() {
        List<Budget> listBudgets = new ArrayList<Budget>();
        try {
            listBudgets = (List<Budget>) budgetRepository.findAllBudgetInvestissementSortByCoutMaterliel();
            for(Budget b : listBudgets)
            {
                //   u.setUsers(null);
                log.info("user = "+b);
            }}
        catch(Exception e)
        {
            log.info("error = "+e);
        }

        return listBudgets;    }

    @Override
    public List<Budget> retreiveAllBudgetMaintenanceSortByDate() {
        List<Budget> listBudgets = new ArrayList<Budget>();
        try {
            listBudgets = (List<Budget>) budgetRepository.findAllBudgetMaintenanceSortByDate();
            for(Budget b : listBudgets)
            {
                //   u.setUsers(null);
                log.info("user = "+b);
            }}
        catch(Exception e)
        {
            log.info("error = "+e);
        }

        return listBudgets;    }

    @Override
    public List<Budget> retreiveAllBudgetMaintenanceSortByCoutEtudeServ() {
        List<Budget> listBudgets = new ArrayList<Budget>();
        try {
            listBudgets = (List<Budget>) budgetRepository.findAllBudgetMaintenanceSortByCoutEtudeServ();
            for(Budget b : listBudgets)
            {
                //   u.setUsers(null);
                log.info("user = "+b);
            }}
        catch(Exception e)
        {
            log.info("error = "+e);
        }

        return listBudgets;    }

    @Override
    public List<Budget> retreiveAllBudgetMaintenanceSortByCoutLogiciel() {
        List<Budget> listBudgets = new ArrayList<Budget>();
        try {
            listBudgets = (List<Budget>) budgetRepository.findAllBudgetMaintenanceSortByCoutLogiciel();
            for(Budget b : listBudgets)
            {
                //   u.setUsers(null);
                log.info("user = "+b);
            }}
        catch(Exception e)
        {
            log.info("error = "+e);
        }

        return listBudgets;    }

    @Override
    public List<Budget> retreiveAllBudgetMaintenanceSortByCoutMateriel() {
        List<Budget> listBudgets = new ArrayList<Budget>();
        try {
            listBudgets = (List<Budget>) budgetRepository.findAllBudgetMaintenanceSortByCoutMaterliel();
            for(Budget b : listBudgets)
            {
                //   u.setUsers(null);
                log.info("user = "+b);
            }}
        catch(Exception e)
        {
            log.info("error = "+e);
        }

        return listBudgets;    }

}
